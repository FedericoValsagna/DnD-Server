package com.valsagnapps.dndapp.domain

data class DeathSaves(val successes: Int = 0, val failures: Int = 0) {
    init {
        require(successes in 0 until MAX) { "death save successes must be between 0 and ${MAX - 1}, was $successes" }
        require(failures in 0..MAX) { "death save failures must be between 0 and $MAX, was $failures" }
    }

    companion object {
        // Tres éxitos estabilizan (y los contadores vuelven a 0); tres fallos matan.
        const val MAX = 3
        val NONE = DeathSaves()
    }
}
