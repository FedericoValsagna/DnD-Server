package com.valsagnapps.dndapp.application.service

import com.valsagnapps.dndapp.domain.CharacterId
import com.valsagnapps.dndapp.domain.CharacterNotFoundException
import com.valsagnapps.dndapp.domain.CombatActionNotAllowedException
import com.valsagnapps.dndapp.domain.DeathSaves
import com.valsagnapps.dndapp.domain.HitPoints
import com.valsagnapps.dndapp.domain.LifeStatus
import com.valsagnapps.dndapp.domain.abilityScores
import com.valsagnapps.dndapp.domain.character
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CombatServiceTest {
    private val repository = InMemoryCharacterRepository()
    private val service = CombatService(repository)

    @Test
    fun `damage is saved`() {
        val character = repository.save(character(maxHitPoints = 20))

        val damaged = service.takeDamage(character.id, 8, critical = false)

        assertEquals(12, damaged.hitPoints.current)
        assertEquals(damaged, repository.findById(character.id))
    }

    @Test
    fun `a critical hit while dying counts two failures`() {
        val dying = HitPoints(max = 20, current = 0)
        val character = repository.save(character(maxHitPoints = 20, hitPoints = dying))

        assertEquals(
            DeathSaves(failures = 2),
            service.takeDamage(character.id, 3, critical = true).hitPoints.deathSaves,
        )
    }

    @Test
    fun `healing is saved`() {
        val character = repository.save(character(hitPoints = HitPoints(max = 20, current = 5)))

        val healed = service.heal(character.id, 10)

        assertEquals(15, healed.hitPoints.current)
        assertEquals(healed, repository.findById(character.id))
    }

    @Test
    fun `temporary hit points are saved`() {
        val character = repository.save(character())

        assertEquals(7, service.setTemporaryHitPoints(character.id, 7).hitPoints.temporary)
        assertEquals(7, repository.findById(character.id)?.hitPoints?.temporary)
    }

    @Test
    fun `death saves are saved`() {
        val dying = HitPoints(max = 20, current = 0)
        val character = repository.save(character(maxHitPoints = 20, hitPoints = dying))

        val saved = service.updateDeathSaves(character.id, DeathSaves(successes = 1, failures = 2))

        assertEquals(DeathSaves(successes = 1, failures = 2), saved.hitPoints.deathSaves)
        assertEquals(saved, repository.findById(character.id))
    }

    @Test
    fun `reviving is saved`() {
        val dead = HitPoints(max = 20, current = 0, deathSaves = DeathSaves(failures = 3))
        val character = repository.save(character(maxHitPoints = 20, hitPoints = dead))

        val revived = service.revive(character.id, 1)

        assertEquals(LifeStatus.CONSCIOUS, revived.hitPoints.status)
        assertEquals(revived, repository.findById(character.id))
    }

    @Test
    fun `a rejected action leaves the character as it was`() {
        val dead = HitPoints(max = 20, current = 0, deathSaves = DeathSaves(failures = 3))
        val character = repository.save(character(maxHitPoints = 20, hitPoints = dead))

        assertFailsWith<CombatActionNotAllowedException> { service.heal(character.id, 5) }
        assertEquals(character, repository.findById(character.id))
    }

    @Test
    fun `the armor class override is saved and can be removed`() {
        val character = repository.save(character(abilityScores = abilityScores(dexterity = 14)))

        assertEquals(18, service.updateArmorClassOverride(character.id, 18).armorClass)
        assertEquals(18, repository.findById(character.id)?.armorClassOverride)
        assertEquals(12, service.updateArmorClassOverride(character.id, null).armorClass)
    }

    @Test
    fun `the base speed is saved`() {
        val character = repository.save(character())

        assertEquals(25, service.updateBaseSpeed(character.id, 25).speed)
        assertEquals(25, repository.findById(character.id)?.baseSpeed)
    }

    @Test
    fun `fails when the character does not exist`() {
        assertFailsWith<CharacterNotFoundException> { service.heal(CharacterId.new(), 5) }
    }
}
