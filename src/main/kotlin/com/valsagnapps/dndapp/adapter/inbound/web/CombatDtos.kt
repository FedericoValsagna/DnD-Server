package com.valsagnapps.dndapp.adapter.inbound.web

import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.DeathSaveResult
import com.valsagnapps.dndapp.domain.HitPoints
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

private const val MAX_AMOUNT = 9999L
private const val MAX_TEMPORARY = HitPoints.MAX_TEMPORARY.toLong()
private const val MIN_HIT_POINTS = HitPoints.MIN_MAX.toLong()
private const val MAX_HIT_POINTS = HitPoints.MAX_MAX.toLong()
private const val MIN_ARMOR_CLASS = Character.MIN_ARMOR_CLASS.toLong()
private const val MAX_ARMOR_CLASS = Character.MAX_ARMOR_CLASS.toLong()
private const val MAX_SPEED = Character.MAX_SPEED.toLong()

// critical: el golpe fue crítico. Solo importa estando en 0 HP, donde cuenta dos fallos de death save.
data class DamageRequest(@field:Min(1) @field:Max(MAX_AMOUNT) val amount: Int, val critical: Boolean = false)

data class HealingRequest(@field:Min(1) @field:Max(MAX_AMOUNT) val amount: Int)

// Reemplaza a los temporales que había (no se suman); 0 los saca.
data class UpdateTemporaryHitPointsRequest(@field:Min(0) @field:Max(MAX_TEMPORARY) val temporaryHitPoints: Int)

data class DeathSaveRequest(val result: DeathSaveResult)

// Con cuántos HP vuelve: 1 (Revivify, Raise Dead) si no viene.
data class ReviveRequest(@field:Min(MIN_HIT_POINTS) @field:Max(MAX_HIT_POINTS) val hitPoints: Int = 1)

// null (o sin el campo) vuelve a la CA calculada.
data class UpdateArmorClassRequest(
    @field:Min(MIN_ARMOR_CLASS) @field:Max(MAX_ARMOR_CLASS) val armorClassOverride: Int? = null,
)

data class UpdateSpeedRequest(@field:Min(0) @field:Max(MAX_SPEED) val baseSpeed: Int)

data class DeathSavesResponse(val successes: Int, val failures: Int)
