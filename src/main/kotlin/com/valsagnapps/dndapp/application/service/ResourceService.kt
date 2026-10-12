package com.valsagnapps.dndapp.application.service

import com.valsagnapps.dndapp.application.port.inbound.UpdateResourceUseCase
import com.valsagnapps.dndapp.application.port.outbound.CharacterRepository
import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId
import com.valsagnapps.dndapp.domain.CharacterNotFoundException
import com.valsagnapps.dndapp.domain.Resource

// Usos de los recursos de clase. El máximo y la recarga los calcula Character; acá se guardan los gastados.
class ResourceService(private val characterRepository: CharacterRepository) : UpdateResourceUseCase {
    override fun updateResourceUsed(id: CharacterId, resource: Resource, used: Int): Character {
        val character = characterRepository.findById(id) ?: throw CharacterNotFoundException(id)
        return characterRepository.save(character.withResourceUsed(resource, used))
    }
}
