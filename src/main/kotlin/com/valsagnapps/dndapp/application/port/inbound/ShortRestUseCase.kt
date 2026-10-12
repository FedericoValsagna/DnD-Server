package com.valsagnapps.dndapp.application.port.inbound

import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.CharacterId

interface ShortRestUseCase {
    // hitDice: cuántos gasta de cada dado (10 = d10). roll: el total que salió, sin la CON.
    fun shortRest(id: CharacterId, hitDice: Map<Int, Int>, roll: Int): Character
}
