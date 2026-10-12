package com.valsagnapps.dndapp.application.service

import com.valsagnapps.dndapp.application.port.inbound.LongRestUseCase
import com.valsagnapps.dndapp.application.port.inbound.ShortRestUseCase
import com.valsagnapps.dndapp.application.port.outbound.CharacterRepository
import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId
import com.valsagnapps.dndapp.domain.CharacterNotFoundException
import com.valsagnapps.dndapp.domain.longRest
import com.valsagnapps.dndapp.domain.shortRest

// Descansos. Las reglas (qué se recupera, Hit Dice, quién puede descansar) viven en el dominio.
class RestService(private val characterRepository: CharacterRepository) :
    ShortRestUseCase,
    LongRestUseCase {
    override fun shortRest(id: CharacterId, hitDice: Map<Int, Int>, roll: Int): Character =
        characterRepository.save(get(id).shortRest(hitDice, roll))

    override fun longRest(id: CharacterId): Character = characterRepository.save(get(id).longRest())

    private fun get(id: CharacterId): Character =
        characterRepository.findById(id) ?: throw CharacterNotFoundException(id)
}
