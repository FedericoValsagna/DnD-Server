package com.valsagnapps.dndapp.adapter.inbound.web

import com.valsagnapps.dndapp.application.port.inbound.LongRestUseCase
import com.valsagnapps.dndapp.application.port.inbound.ShortRestUseCase
import com.valsagnapps.dndapp.domain.CharacterId
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

// Descansos. Devuelven el personaje actualizado; muerto o muriendo es 409.
@RestController
@RequestMapping("/api/v1/characters/{id}")
class RestingController(private val shortRest: ShortRestUseCase, private val longRest: LongRestUseCase) {
    // Más dados de los que quedan, un dado repetido o un total imposible es 400; gastar dados con 0 HP, 409.
    @PostMapping("/short-rest")
    fun shortRest(
        @PathVariable id: UUID,
        @Valid @RequestBody(required = false) request: ShortRestRequest?,
    ): CharacterResponse {
        val body = request ?: ShortRestRequest()
        require(body.hitDice.distinctBy { it.die }.size == body.hitDice.size) { "hit dice must not be repeated" }
        val hitDice = body.hitDice.associate { it.die to it.count }
        return CharacterResponse.from(shortRest.shortRest(CharacterId(id), hitDice, body.roll))
    }

    @PostMapping("/long-rest")
    fun longRest(@PathVariable id: UUID): CharacterResponse = CharacterResponse.from(longRest.longRest(CharacterId(id)))
}
