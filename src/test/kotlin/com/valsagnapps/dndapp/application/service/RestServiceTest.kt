package com.valsagnapps.dndapp.application.service

import com.valsagnapps.dndapp.domain.CharacterId
import com.valsagnapps.dndapp.domain.CharacterNotFoundException
import com.valsagnapps.dndapp.domain.HitDice
import com.valsagnapps.dndapp.domain.HitPoints
import com.valsagnapps.dndapp.domain.Resource
import com.valsagnapps.dndapp.domain.character
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RestServiceTest {
    private val repository = InMemoryCharacterRepository()
    private val service = RestService(repository)

    // Fighter 5 con 2 Hit Dice gastados, Second Wind usado y la mitad del HP.
    private val tired = character(
        level = 5,
        hitPoints = HitPoints(max = 40, current = 20),
        resourcesUsed = mapOf(Resource.SECOND_WIND to 1),
        hitDiceUsed = mapOf(10 to 2),
    )

    @Test
    fun `a short rest is saved`() {
        repository.save(tired)

        val rested = service.shortRest(tired.id, mapOf(10 to 1), roll = 6)

        assertEquals(26, rested.hitPoints.current)
        assertEquals(listOf(HitDice(10, 5, 3)), rested.hitDice)
        assertEquals(emptyMap(), rested.resourcesUsed)
        assertEquals(rested, repository.findById(tired.id))
    }

    @Test
    fun `a long rest is saved`() {
        repository.save(tired)

        val rested = service.longRest(tired.id)

        assertEquals(40, rested.hitPoints.current)
        assertEquals(emptyMap(), rested.hitDiceUsed)
        assertEquals(rested, repository.findById(tired.id))
    }

    @Test
    fun `a missing character is not found`() {
        assertFailsWith<CharacterNotFoundException> { service.shortRest(CharacterId.new(), emptyMap(), 0) }
        assertFailsWith<CharacterNotFoundException> { service.longRest(CharacterId.new()) }
    }
}
