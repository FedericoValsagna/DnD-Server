package com.valsagnapps.dndapp.domain

// Los marca el jugador: la app no tira dados. Tres éxitos estabilizan y tres fallos matan, así que no pueden
// estar los dos completos.
data class DeathSaves(val successes: Int = 0, val failures: Int = 0) {
    init {
        require(successes in 0..MAX) { "death save successes must be between 0 and $MAX, was $successes" }
        require(failures in 0..MAX) { "death save failures must be between 0 and $MAX, was $failures" }
        require(successes < MAX || failures < MAX) { "death saves can't have $MAX successes and $MAX failures" }
    }

    val isStable: Boolean get() = successes == MAX
    val isDead: Boolean get() = failures == MAX

    companion object {
        const val MAX = 3
        val NONE = DeathSaves()
    }
}
