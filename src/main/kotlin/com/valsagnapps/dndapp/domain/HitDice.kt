package com.valsagnapps.dndapp.domain

// Los Hit Dice de un tamaño (d10, d8, ...): uno por nivel de las clases que lo usan. Los usados se gastan en el short
// rest y vuelven con el long rest.
data class HitDice(val die: Int, val count: Int, val used: Int) {
    val remaining: Int
        get() = count - used

    companion object {
        // Agrupados por dado, de mayor a menor (ej. d10 × 3, d8 × 2). Los usados se recortan al total, que puede haber
        // bajado con el nivel.
        fun of(classes: List<ClassLevel>, used: Map<Int, Int>): List<HitDice> = classes
            .groupBy { it.characterClass.hitDie }
            .map { (die, levels) ->
                val count = levels.sumOf { it.level }
                HitDice(die, count, minOf(count, used[die] ?: 0))
            }
            .sortedByDescending { it.die }
    }
}
