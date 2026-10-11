package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.AbilityScores
import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId

interface UpdateAbilityScoresUseCase {
    fun updateAbilityScores(id: CharacterId, abilityScores: AbilityScores): Character
}
