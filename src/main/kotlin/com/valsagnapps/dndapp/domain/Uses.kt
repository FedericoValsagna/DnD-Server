package com.valsagnapps.dndapp.domain

// Máximo de usos según el nivel de la clase que da el recurso y los atributos. null es sin límite: el recurso no se
// lleva (Rage del Barbarian 20).
fun interface UsesFormula {
    fun max(classLevel: Int, abilityScores: AbilityScores): Int?
}

// Usos que da una feature: cuántos y con qué descanso se recuperan. shortRestFromLevel: desde ese nivel de clase
// también se recupera con short rest (Bardic Inspiration desde Font of Inspiration, al 5).
class Uses(
    private val formula: UsesFormula,
    private val recharge: Recharge,
    private val shortRestFromLevel: Int? = null,
) {
    fun max(classLevel: Int, abilityScores: AbilityScores): Int? = formula.max(classLevel, abilityScores)

    fun recharge(classLevel: Int): Recharge =
        if (shortRestFromLevel != null && classLevel >= shortRestFromLevel) Recharge.SHORT_REST else recharge

    companion object {
        fun fixed(count: Int, recharge: Recharge) = Uses({ _, _ -> count }, recharge)

        // Escalones (nivel desde el que vale, usos), en orden de nivel.
        fun byLevel(recharge: Recharge, vararg steps: Pair<Int, Int?>) = Uses(
            { classLevel, _ -> steps.last { (level, _) -> level <= classLevel }.second },
            recharge,
        )

        // Modificador del atributo más bonus, con mínimo 1.
        fun abilityModifier(ability: Ability, recharge: Recharge, bonus: Int = 0, shortRestFromLevel: Int? = null) =
            Uses(
                { _, scores -> maxOf(1, scores.modifierOf(ability) + bonus) },
                recharge,
                shortRestFromLevel,
            )

        // Tantos por nivel de clase (Ki, Sorcery Points, Lay on Hands).
        fun perClassLevel(multiplier: Int, recharge: Recharge) =
            Uses({ classLevel, _ -> multiplier * classLevel }, recharge)
    }
}

// Un escalón de Uses.byLevel, con nombre para leer la tabla: atLevel(level = 3, uses = 3).
fun atLevel(level: Int, uses: Int?): Pair<Int, Int?> = level to uses
