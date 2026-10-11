package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId

interface UpdateSpeedUseCase {
    fun updateBaseSpeed(id: CharacterId, baseSpeed: Int): Character
}
