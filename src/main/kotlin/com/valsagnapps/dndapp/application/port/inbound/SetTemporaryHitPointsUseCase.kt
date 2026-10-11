package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId

interface SetTemporaryHitPointsUseCase {
    fun setTemporaryHitPoints(id: CharacterId, temporaryHitPoints: Int): Character
}
