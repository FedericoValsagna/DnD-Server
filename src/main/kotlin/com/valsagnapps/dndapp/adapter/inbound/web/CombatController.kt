package com.valsagnapps.dndapp.adapter.inbound.web

import com.valsagnapps.dndapp.application.port.inbound.HealUseCase
import com.valsagnapps.dndapp.application.port.inbound.ReviveUseCase
import com.valsagnapps.dndapp.application.port.inbound.SetTemporaryHitPointsUseCase
import com.valsagnapps.dndapp.application.port.inbound.TakeDamageUseCase
import com.valsagnapps.dndapp.application.port.inbound.UpdateArmorClassUseCase
import com.valsagnapps.dndapp.application.port.inbound.UpdateDeathSavesUseCase
import com.valsagnapps.dndapp.application.port.inbound.UpdateSpeedUseCase
import com.valsagnapps.dndapp.domain.CharacterId
import com.valsagnapps.dndapp.domain.DeathSaves
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

// Acciones de combate sobre un personaje. Todas devuelven el personaje actualizado; las que el estado no permite
// (curar a un muerto, ...) dan 409.
@RestController
@RequestMapping("/api/v1/characters/{id}")
class CombatController(
    private val takeDamage: TakeDamageUseCase,
    private val heal: HealUseCase,
    private val setTemporaryHitPoints: SetTemporaryHitPointsUseCase,
    private val updateDeathSaves: UpdateDeathSavesUseCase,
    private val revive: ReviveUseCase,
    private val updateArmorClass: UpdateArmorClassUseCase,
    private val updateSpeed: UpdateSpeedUseCase,
) {
    @PostMapping("/damage")
    fun takeDamage(@PathVariable id: UUID, @Valid @RequestBody request: DamageRequest): CharacterResponse =
        CharacterResponse.from(takeDamage.takeDamage(CharacterId(id), request.amount, request.critical))

    @PostMapping("/healing")
    fun heal(@PathVariable id: UUID, @Valid @RequestBody request: HealingRequest): CharacterResponse =
        CharacterResponse.from(heal.heal(CharacterId(id), request.amount))

    @PutMapping("/temporary-hit-points")
    fun setTemporaryHitPoints(
        @PathVariable id: UUID,
        @Valid @RequestBody request: UpdateTemporaryHitPointsRequest,
    ): CharacterResponse = CharacterResponse.from(
        setTemporaryHitPoints.setTemporaryHitPoints(CharacterId(id), request.temporaryHitPoints),
    )

    // Los contadores completos, como quedaron después de marcar o desmarcar un punto.
    @PutMapping("/death-saves")
    fun updateDeathSaves(
        @PathVariable id: UUID,
        @Valid @RequestBody request: UpdateDeathSavesRequest,
    ): CharacterResponse = CharacterResponse.from(
        updateDeathSaves.updateDeathSaves(CharacterId(id), DeathSaves(request.successes, request.failures)),
    )

    // El cuerpo es opcional: sin él vuelve con 1 HP.
    @PostMapping("/revive")
    fun revive(
        @PathVariable id: UUID,
        @Valid @RequestBody(required = false) request: ReviveRequest?,
    ): CharacterResponse =
        CharacterResponse.from(revive.revive(CharacterId(id), (request ?: ReviveRequest()).hitPoints))

    @PutMapping("/armor-class")
    fun updateArmorClass(
        @PathVariable id: UUID,
        @Valid @RequestBody request: UpdateArmorClassRequest,
    ): CharacterResponse =
        CharacterResponse.from(updateArmorClass.updateArmorClassOverride(CharacterId(id), request.armorClassOverride))

    @PutMapping("/speed")
    fun updateSpeed(@PathVariable id: UUID, @Valid @RequestBody request: UpdateSpeedRequest): CharacterResponse =
        CharacterResponse.from(updateSpeed.updateBaseSpeed(CharacterId(id), request.baseSpeed))
}
