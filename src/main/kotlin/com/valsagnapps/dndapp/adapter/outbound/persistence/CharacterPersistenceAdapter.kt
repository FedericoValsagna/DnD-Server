package com.valsagnapps.dndapp.adapter.outbound.persistence

import com.valsagnapps.dndapp.application.port.outbound.CharacterRepository
import com.valsagnapps.dndapp.domain.AbilityScores
import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId
import com.valsagnapps.dndapp.domain.ClassLevel
import com.valsagnapps.dndapp.domain.DeathSaves
import com.valsagnapps.dndapp.domain.HitPoints
import com.valsagnapps.dndapp.domain.SkillProficiencies
import org.springframework.stereotype.Component

@Component
class CharacterPersistenceAdapter(private val jpaRepository: CharacterJpaRepository) : CharacterRepository {
    override fun save(character: Character): Character = jpaRepository.save(character.toEntity()).toDomain()

    override fun findById(id: CharacterId): Character? = jpaRepository.findById(id.value).orElse(null)?.toDomain()

    override fun findAll(): List<Character> = jpaRepository.findAll().map { it.toDomain() }

    // Las skills, clases y recursos (element collections) se borran con el personaje.
    override fun delete(id: CharacterId) = jpaRepository.deleteById(id.value)
}

private fun Character.toEntity() = CharacterEntity(
    id = id.value,
    name = name,
    strength = abilityScores.strength,
    dexterity = abilityScores.dexterity,
    constitution = abilityScores.constitution,
    intelligence = abilityScores.intelligence,
    wisdom = abilityScores.wisdom,
    charisma = abilityScores.charisma,
    maxHitPoints = hitPoints.max,
    currentHitPoints = hitPoints.current,
    temporaryHitPoints = hitPoints.temporary,
    deathSaveSuccesses = hitPoints.deathSaves.successes,
    deathSaveFailures = hitPoints.deathSaves.failures,
    armorClassOverride = armorClassOverride,
    baseSpeed = baseSpeed,
    skills = skillProficiencies.toMap().toMutableMap(),
    classes = classes.map { ClassLevelEmbeddable(it.characterClass, it.level, it.subclass) }.toMutableList(),
    // Los usados de recursos que ya no tiene (bajó de nivel, cambió de clase) no se guardan.
    resourcesUsed = resources.filter { it.used > 0 }.associate { it.resource to it.used }.toMutableMap(),
)

private fun CharacterEntity.toDomain() = Character(
    id = CharacterId(id),
    name = name,
    classes = classes.map { ClassLevel(it.characterClass, it.level, it.subclass) },
    abilityScores = AbilityScores(strength, dexterity, constitution, intelligence, wisdom, charisma),
    hitPoints = HitPoints(
        max = maxHitPoints,
        current = currentHitPoints,
        temporary = temporaryHitPoints,
        deathSaves = DeathSaves(deathSaveSuccesses, deathSaveFailures),
    ),
    skillProficiencies = SkillProficiencies.of(skills),
    armorClassOverride = armorClassOverride,
    baseSpeed = baseSpeed,
    resourcesUsed = resourcesUsed.toMap(),
)
