package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId

interface TakeDamageUseCase {
    fun takeDamage(id: CharacterId, amount: Int, critical: Boolean): Character
}
