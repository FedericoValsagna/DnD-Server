package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId

interface UpdateNameUseCase {
    fun updateName(id: CharacterId, name: String): Character
}
