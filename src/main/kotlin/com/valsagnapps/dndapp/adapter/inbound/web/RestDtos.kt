package com.valsagnapps.dndapp.adapter.inbound.web

import jakarta.validation.Valid
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

private const val MAX_ROLL = 999L

// Cuántos dados de un tamaño (10 = d10) gasta.
data class HitDiceSpendRequest(@field:Min(1) val die: Int, @field:Min(1) val count: Int)

// Sin dados (o sin el cuerpo) solo recupera los recursos de short rest. roll: el total de los dados, sin la CON.
data class ShortRestRequest(
    @field:Valid val hitDice: List<HitDiceSpendRequest> = emptyList(),
    @field:Min(0) @field:Max(MAX_ROLL) val roll: Int = 0,
)
