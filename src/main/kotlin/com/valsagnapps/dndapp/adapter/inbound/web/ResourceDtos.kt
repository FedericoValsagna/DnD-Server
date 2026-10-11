package com.valsagnapps.dndapp.adapter.inbound.web

import com.valsagnapps.dndapp.domain.CharacterResource
import com.valsagnapps.dndapp.domain.Recharge
import com.valsagnapps.dndapp.domain.Resource
import com.valsagnapps.dndapp.domain.UsesDisplay
import jakarta.validation.constraints.Min

data class UpdateResourceRequest(@field:Min(0) val used: Int)

// display: PIPS (puntos que se tocan) o POOL (un número que se gasta con el teclado).
data class ResourceResponse(
    val id: Resource,
    val name: String,
    val max: Int,
    val used: Int,
    val recharge: Recharge,
    val display: UsesDisplay,
) {
    companion object {
        fun from(resource: CharacterResource) = ResourceResponse(
            id = resource.resource,
            name = resource.resource.displayName,
            max = resource.max,
            used = resource.used,
            recharge = resource.recharge,
            display = resource.resource.display,
        )
    }
}
