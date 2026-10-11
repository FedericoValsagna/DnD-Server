package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId

interface ReviveUseCase {
    fun revive(id: CharacterId, hitPoints: Int): Character
}
