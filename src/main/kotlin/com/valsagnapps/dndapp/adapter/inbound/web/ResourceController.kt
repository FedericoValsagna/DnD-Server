package com.valsagnapps.dndapp.adapter.inbound.web

import com.valsagnapps.dndapp.application.port.inbound.UpdateResourceUseCase
import com.valsagnapps.dndapp.domain.CharacterId
import com.valsagnapps.dndapp.domain.Resource
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

// Usos de los recursos de clase. Devuelve el personaje actualizado.
@RestController
@RequestMapping("/api/v1/characters/{id}/resources")
class ResourceController(private val updateResource: UpdateResourceUseCase) {
    // Cuántos usos lleva gastados, como quedaron después de gastar o recuperar (0 los recupera todos). Un recurso que
    // el personaje no tiene, o más usados que el máximo, es 400.
    @PutMapping("/{resource}")
    fun updateResource(
        @PathVariable id: UUID,
        @PathVariable resource: Resource,
        @Valid @RequestBody request: UpdateResourceRequest,
    ): CharacterResponse =
        CharacterResponse.from(updateResource.updateResourceUsed(CharacterId(id), resource, request.used))
}
