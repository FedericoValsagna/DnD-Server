package com.valsagnapps.dndapp.domain

// Short rest: gasta los Hit Dice elegidos (dado → cuántos) y cura lo que salió en ellos, `roll` (el total de los
// dados, sin la CON), más la CON por dado. El jugador carga solo el total, así que el mínimo de 0 por dado se aplica
// al total. Recupera los recursos de short rest. Sin dados, `roll` es 0: solo recupera los recursos.
// Muerto o muriendo no se descansa; estable en 0 HP sí, pero sin gastar dados (la regla pide 1 HP).
fun Character.shortRest(spent: Map<Int, Int>, roll: Int): Character {
    checkCanRest()
    val dice = spent.filterValues { it > 0 }
    val count = dice.values.sum()
    if (count > 0 && hitPoints.current == 0) {
        throw CombatActionNotAllowedException("a character at 0 hit points can't spend hit dice")
    }
    dice.forEach { (die, amount) ->
        val available = hitDice.find { it.die == die }?.remaining ?: 0
        require(amount <= available) { "the character has $available d$die hit dice left, wanted $amount" }
    }
    val maxRoll = dice.entries.sumOf { (die, amount) -> die * amount }
    require(roll in count..maxRoll) { "the roll of $count hit dice must be between $count and $maxRoll, was $roll" }
    val healing = maxOf(0, roll + count * abilityScores.modifierOf(Ability.CONSTITUTION))
    return copy(
        hitPoints = if (healing > 0) hitPoints.heal(healing) else hitPoints,
        hitDiceUsed = hitDice.associate { it.die to it.used + (dice[it.die] ?: 0) }.filterValues { it > 0 },
        resourcesUsed = resourcesUsed.filterKeys { resource -> rechargeOf(resource) != Recharge.SHORT_REST },
    )
}

// Long rest: HP al máximo, sin temporales ni death saves, recupera la mitad de los Hit Dice totales (mínimo 1;
// primero los más grandes) y todos los recursos. Muerto o muriendo no se descansa.
fun Character.longRest(): Character {
    checkCanRest()
    var recovered = maxOf(1, level / 2)
    val hitDiceUsed = hitDice.associate { dice ->
        val back = minOf(dice.used, recovered)
        recovered -= back
        dice.die to dice.used - back
    }
    return copy(
        hitPoints = HitPoints(max = hitPoints.max),
        hitDiceUsed = hitDiceUsed.filterValues { it > 0 },
        resourcesUsed = emptyMap(),
    )
}

private fun Character.checkCanRest() {
    val status = hitPoints.status
    if (status == LifeStatus.DEAD || status == LifeStatus.DYING) {
        throw CombatActionNotAllowedException("a ${status.name.lowercase()} character can't rest")
    }
}

private fun Character.rechargeOf(resource: Resource): Recharge? = resources.find { it.resource == resource }?.recharge
