package com.valsagnapps.dndapp.domain

// classes: una entrada por clase (multiclase). La primera es la clase inicial, la que da las salvaciones.
data class Character(
    val id: CharacterId,
    val name: String,
    val classes: List<ClassLevel>,
    val abilityScores: AbilityScores,
    // El máximo se carga a mano: puede ser el promedio o lo que salió en los dados.
    val hitPoints: HitPoints,
    val skillProficiencies: SkillProficiencies = SkillProficiencies.NONE,
    // Gana sobre la CA calculada: es como se carga la armadura hasta que exista el equipo.
    val armorClassOverride: Int? = null,
    // Se carga a mano hasta que existan las razas, que la van a dar.
    val baseSpeed: Int = DEFAULT_SPEED,
) {
    init {
        require(name.isNotBlank()) { "name must not be blank" }
        require(name.length <= MAX_NAME_LENGTH) { "name must have at most $MAX_NAME_LENGTH characters" }
        require(classes.isNotEmpty()) { "a character must have at least one class" }
        require(classes.distinctBy { it.characterClass }.size == classes.size) { "classes must not be repeated" }
        require(level in MIN_LEVEL..MAX_LEVEL) { "level must be between $MIN_LEVEL and $MAX_LEVEL, was $level" }
        require(armorClassOverride == null || armorClassOverride in MIN_ARMOR_CLASS..MAX_ARMOR_CLASS) {
            "armor class must be between $MIN_ARMOR_CLASS and $MAX_ARMOR_CLASS, was $armorClassOverride"
        }
        require(baseSpeed in 0..MAX_SPEED) { "speed must be between 0 and $MAX_SPEED, was $baseSpeed" }
    }

    val maxHitPoints: Int
        get() = hitPoints.max

    val level: Int
        get() = classes.sumOf { it.level }

    // +2 en niveles 1-4, +3 en 5-8, ... +6 en 17-20.
    val proficiencyBonus: Int
        get() = 2 + (level - 1) / 4

    // Dados de golpe totales agrupados por tamaño, de mayor a menor (ej. {10: 3, 8: 2}).
    val hitDice: Map<Int, Int>
        get() = classes
            .groupBy { it.characterClass.hitDie }
            .mapValues { (_, levels) -> levels.sumOf { it.level } }
            .toSortedMap(reverseOrder())

    // La clase inicial da sus competencias completas; las que se suman por multiclase, las reducidas.
    val proficiencies: Proficiencies
        get() = classProficiencies.map { (isStarting, granted) ->
            if (isStarting) granted.starting else granted.multiclass
        }
            .reduce(Proficiencies::plus)

    // Skills a elegir por cada clase, en el mismo orden que `classes`. Solo sugerencia: no se valida.
    val skillChoices: List<SkillChoice>
        get() = classProficiencies.map { (isStarting, granted) ->
            if (isStarting) granted.startingSkills else granted.multiclassSkills
        }

    // Competencias de cada clase, marcando cuál es la inicial.
    private val classProficiencies: List<Pair<Boolean, ClassProficiencies>>
        get() = classes.mapIndexed { index, classLevel -> (index == 0) to classLevel.characterClass.proficiencies }

    // Reemplaza las clases conservando la subclase de las que siguen con nivel para tenerla:
    // si una clase cambia o baja del nivel de subclase, la subclase se borra.
    fun withClasses(newClasses: List<ClassLevel>): Character = copy(
        classes = newClasses.map { new ->
            val kept = classes.find { it.characterClass == new.characterClass }?.subclass
            new.copy(subclass = new.subclass ?: kept?.takeIf { new.canHaveSubclass })
        },
    )

    // Elige (o quita, con null) la subclase de una de sus clases.
    fun withSubclass(characterClass: CharacterClass, subclass: Subclass?): Character {
        require(classes.any { it.characterClass == characterClass }) { "the character has no $characterClass levels" }
        return copy(
            classes = classes.map { if (it.characterClass == characterClass) it.copy(subclass = subclass) else it },
        )
    }

    fun savingThrowProficiency(ability: Ability): Proficiency =
        if (ability in classes.first().characterClass.savingThrows) Proficiency.PROFICIENT else Proficiency.NONE

    fun savingThrowBonus(ability: Ability): Int =
        abilityScores.modifierOf(ability) + proficiencyBonus * savingThrowProficiency(ability).multiplier

    fun skillBonus(skill: Skill): Int =
        abilityScores.modifierOf(skill.ability) + proficiencyBonus * skillProficiencies.of(skill).multiplier

    val passivePerception: Int
        get() = PASSIVE_BASE + skillBonus(Skill.PERCEPTION)

    // Sin override: 10 + DEX, o lo que dé una CA sin armadura si es mayor (Unarmored Defense de Barbarian y Monk,
    // Draconic Resilience). No se apilan: se usa la mejor. Sin equipo no se sabe si lleva armadura o escudo.
    val armorClass: Int
        get() = armorClassOverride ?: (UNARMORED_BASE + modifier(Ability.DEXTERITY) + unarmoredBonus)

    private val unarmoredBonus: Int
        get() = listOfNotNull(
            0,
            modifier(Ability.CONSTITUTION).takeIf { levelIn(CharacterClass.BARBARIAN) >= 1 },
            modifier(Ability.WISDOM).takeIf { levelIn(CharacterClass.MONK) >= 1 },
            DRACONIC_RESILIENCE_BONUS.takeIf { classes.any { it.subclass == Subclass.DRACONIC_BLOODLINE } },
        ).max()

    // DEX más Jack of All Trades (Bard 2+, mitad del bonus redondeado abajo) o Remarkable Athlete (Champion 7+,
    // mitad redondeado arriba), el mayor. Cuando entren los feats, Alert suma +5.
    val initiative: Int
        get() = modifier(Ability.DEXTERITY) + maxOf(jackOfAllTrades, remarkableAthlete)

    private val jackOfAllTrades: Int
        get() = if (levelIn(CharacterClass.BARD) >= JACK_OF_ALL_TRADES_LEVEL) proficiencyBonus / 2 else 0

    private val remarkableAthlete: Int
        get() {
            val champion = classes.any { it.subclass == Subclass.CHAMPION && it.level >= REMARKABLE_ATHLETE_LEVEL }
            return if (champion) (proficiencyBonus + 1) / 2 else 0
        }

    // Base manual más Unarmored Movement (Monk 2+: +10, +5 cada 4 niveles hasta +30) y Fast Movement (Barbarian 5+).
    // Los dos piden no llevar armadura (pesada, en el Barbarian): sin equipo no se sabe, se suman siempre.
    val speed: Int
        get() = baseSpeed + unarmoredMovement + fastMovement

    private val unarmoredMovement: Int
        get() {
            val monkLevel = levelIn(CharacterClass.MONK)
            return if (monkLevel >= UNARMORED_MOVEMENT_LEVEL) {
                UNARMORED_MOVEMENT_BASE +
                    SPEED_STEP * ((monkLevel - UNARMORED_MOVEMENT_LEVEL) / UNARMORED_MOVEMENT_STEP_LEVELS)
            } else {
                0
            }
        }

    private val fastMovement: Int
        get() = if (levelIn(CharacterClass.BARBARIAN) >= FAST_MOVEMENT_LEVEL) FAST_MOVEMENT_BONUS else 0

    fun withMaxHitPoints(maxHitPoints: Int): Character = copy(hitPoints = hitPoints.withMax(maxHitPoints))

    private fun modifier(ability: Ability): Int = abilityScores.modifierOf(ability)

    private fun levelIn(characterClass: CharacterClass): Int =
        classes.find { it.characterClass == characterClass }?.level ?: 0

    companion object {
        const val MIN_LEVEL = 1
        const val MAX_LEVEL = 20
        const val MAX_NAME_LENGTH = 100
        const val MIN_ARMOR_CLASS = 1
        const val MAX_ARMOR_CLASS = 50
        const val DEFAULT_SPEED = 30
        const val MAX_SPEED = 200
        private const val PASSIVE_BASE = 10
        private const val UNARMORED_BASE = 10
        private const val DRACONIC_RESILIENCE_BONUS = 3
        private const val JACK_OF_ALL_TRADES_LEVEL = 2
        private const val REMARKABLE_ATHLETE_LEVEL = 7
        private const val UNARMORED_MOVEMENT_LEVEL = 2
        private const val UNARMORED_MOVEMENT_BASE = 10
        private const val SPEED_STEP = 5
        private const val UNARMORED_MOVEMENT_STEP_LEVELS = 4
        private const val FAST_MOVEMENT_LEVEL = 5
        private const val FAST_MOVEMENT_BONUS = 10
    }
}
