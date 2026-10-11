package com.valsagnapps.dndapp.application.service

import com.valsagnapps.dndapp.application.port.inbound.HealUseCase
import com.valsagnapps.dndapp.application.port.inbound.ReviveUseCase
import com.valsagnapps.dndapp.application.port.inbound.SetTemporaryHitPointsUseCase
import com.valsagnapps.dndapp.application.port.inbound.TakeDamageUseCase
import com.valsagnapps.dndapp.application.port.inbound.UpdateArmorClassUseCase
import com.valsagnapps.dndapp.application.port.inbound.UpdateDeathSavesUseCase
import com.valsagnapps.dndapp.application.port.inbound.UpdateSpeedUseCase
import com.valsagnapps.dndapp.application.port.outbound.CharacterRepository
import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId
import com.valsagnapps.dndapp.domain.CharacterNotFoundException
import com.valsagnapps.dndapp.domain.DeathSaves
import com.valsagnapps.dndapp.domain.HitPoints

// Estado de combate del personaje. Las reglas (temporales primero, death saves, muerte) viven en HitPoints.
class CombatService(private val characterRepository: CharacterRepository) :
    TakeDamageUseCase,
    HealUseCase,
    SetTemporaryHitPointsUseCase,
    UpdateDeathSavesUseCase,
    ReviveUseCase,
    UpdateArmorClassUseCase,
    UpdateSpeedUseCase {
    override fun takeDamage(id: CharacterId, amount: Int, critical: Boolean): Character =
        updateHitPoints(id) { it.takeDamage(amount, critical) }

    override fun heal(id: CharacterId, amount: Int): Character = updateHitPoints(id) { it.heal(amount) }

    override fun setTemporaryHitPoints(id: CharacterId, temporaryHitPoints: Int): Character =
        updateHitPoints(id) { it.withTemporary(temporaryHitPoints) }

    override fun updateDeathSaves(id: CharacterId, deathSaves: DeathSaves): Character =
        updateHitPoints(id) { it.withDeathSaves(deathSaves) }

    override fun revive(id: CharacterId, hitPoints: Int): Character = updateHitPoints(id) { it.revive(hitPoints) }

    override fun updateArmorClassOverride(id: CharacterId, armorClassOverride: Int?): Character =
        characterRepository.save(get(id).copy(armorClassOverride = armorClassOverride))

    override fun updateBaseSpeed(id: CharacterId, baseSpeed: Int): Character =
        characterRepository.save(get(id).copy(baseSpeed = baseSpeed))

    private fun updateHitPoints(id: CharacterId, change: (HitPoints) -> HitPoints): Character {
        val character = get(id)
        return characterRepository.save(character.copy(hitPoints = change(character.hitPoints)))
    }

    private fun get(id: CharacterId): Character =
        characterRepository.findById(id) ?: throw CharacterNotFoundException(id)
}
