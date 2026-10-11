package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId
import com.valsagnapps.dndapp.domain.DeathSaves

interface UpdateDeathSavesUseCase {
    fun updateDeathSaves(id: CharacterId, deathSaves: DeathSaves): Character
}
