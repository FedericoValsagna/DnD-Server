package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId

interface HealUseCase {
    fun heal(id: CharacterId, amount: Int): Character
}
