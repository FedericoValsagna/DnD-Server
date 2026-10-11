package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.CharacterId

interface DeleteCharacterUseCase {
    fun delete(id: CharacterId)
}
