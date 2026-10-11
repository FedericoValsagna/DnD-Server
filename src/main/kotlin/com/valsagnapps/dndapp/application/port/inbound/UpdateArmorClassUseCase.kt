package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId

interface UpdateArmorClassUseCase {
    // null vuelve a la CA calculada.
    fun updateArmorClassOverride(id: CharacterId, armorClassOverride: Int?): Character
}
