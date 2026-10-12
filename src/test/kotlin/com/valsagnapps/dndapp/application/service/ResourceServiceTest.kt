package com.valsagnapps.dndapp.application.service

import com.valsagnapps.dndapp.domain.CharacterClass
import com.valsagnapps.dndapp.domain.CharacterId
import com.valsagnapps.dndapp.domain.CharacterNotFoundException
import com.valsagnapps.dndapp.domain.Resource
import com.valsagnapps.dndapp.domain.character
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ResourceServiceTest {
    private val repository = InMemoryCharacterRepository()
    private val service = ResourceService(repository)

    @Test
    fun `used uses are saved`() {
        val monk = repository.save(character(characterClass = CharacterClass.MONK, level = 5))

        val updated = service.updateResourceUsed(monk.id, Resource.KI, 2)

        assertEquals(mapOf(Resource.KI to 2), updated.resourcesUsed)
        assertEquals(updated, repository.findById(monk.id))
    }

    @Test
    fun `a resource the character doesn't have is rejected`() {
        val fighter = repository.save(character())

        assertFailsWith<IllegalArgumentException> { service.updateResourceUsed(fighter.id, Resource.KI, 1) }
    }

    @Test
    fun `a missing character is not found`() {
        assertFailsWith<CharacterNotFoundException> {
            service.updateResourceUsed(CharacterId.new(), Resource.KI, 1)
        }
    }
}
