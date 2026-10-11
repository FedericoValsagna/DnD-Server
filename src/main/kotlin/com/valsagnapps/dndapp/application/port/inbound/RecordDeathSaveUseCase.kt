package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId
import com.valsagnapps.dndapp.domain.DeathSaveResult

interface RecordDeathSaveUseCase {
    fun recordDeathSave(id: CharacterId, result: DeathSaveResult): Character
}
