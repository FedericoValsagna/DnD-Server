package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId
import com.valsagnapps.dndapp.domain.Resource

interface UpdateResourceUseCase {
    fun updateResourceUsed(id: CharacterId, resource: Resource, used: Int): Character
}
