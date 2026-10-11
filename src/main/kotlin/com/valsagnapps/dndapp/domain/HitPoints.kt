package com.valsagnapps.dndapp.domain

// HP del personaje y su estado en combate. El máximo lo carga el jugador; el resto lo mueven el daño, la curación,
// los HP temporales y los death saves, con las reglas de 5e 2014 (PHB, cap. 9).
data class HitPoints(
    val max: Int,
    val current: Int = max,
    val temporary: Int = 0,
    val status: LifeStatus = LifeStatus.CONSCIOUS,
    val deathSaves: DeathSaves = DeathSaves.NONE,
) {
    init {
        require(max in MIN_MAX..MAX_MAX) { "maxHitPoints must be between $MIN_MAX and $MAX_MAX, was $max" }
        require(current in 0..max) { "current hit points must be between 0 and $max, was $current" }
        require(temporary in 0..MAX_TEMPORARY) {
            "temporary hit points must be between 0 and $MAX_TEMPORARY, was $temporary"
        }
        require((current > 0) == (status == LifeStatus.CONSCIOUS)) {
            "a character is CONSCIOUS exactly when it has hit points, was $status with $current"
        }
        require(deathSaves == DeathSaves.NONE || status in COUNTING_STATUSES) {
            "only dying or dead characters have death saves, was $status"
        }
    }

    // Los temporales absorben primero. Si el resto lo deja en 0 y lo que sobra llega al máximo, muere en el acto.
    // Estando en 0, cualquier daño es un fallo de death save (dos si es crítico), o muerte si llega al máximo.
    // A un muerto no le pasa nada.
    fun takeDamage(amount: Int, critical: Boolean = false): HitPoints {
        require(amount >= 1) { "damage must be at least 1, was $amount" }
        if (status == LifeStatus.DEAD) return this
        val absorbed = minOf(temporary, amount)
        val remaining = amount - absorbed
        val afterTemporary = copy(temporary = temporary - absorbed)
        return when {
            remaining == 0 -> afterTemporary
            remaining - current >= max -> afterTemporary.copy(current = 0, status = LifeStatus.DEAD)
            remaining < current -> afterTemporary.copy(current = current - remaining)
            current > 0 -> afterTemporary.copy(current = 0, status = LifeStatus.DYING)
            else -> afterTemporary.withFailures(if (critical) 2 else 1)
        }
    }

    // Tope en el máximo. Curar a alguien en 0 lo despierta y reinicia los death saves; a un muerto hay que revivirlo.
    fun heal(amount: Int): HitPoints {
        require(amount >= 1) { "healing must be at least 1, was $amount" }
        checkNotDead("healed")
        return conscious(minOf(max, current + amount))
    }

    // Los temporales nuevos reemplazan a los que había: no se suman. 0 los saca.
    fun withTemporary(amount: Int): HitPoints {
        checkNotDead("given temporary hit points")
        return copy(temporary = amount)
    }

    fun recordDeathSave(result: DeathSaveResult): HitPoints {
        if (status != LifeStatus.DYING) {
            throw CombatActionNotAllowedException("only a dying character makes death saves, was $status")
        }
        return when (result) {
            DeathSaveResult.SUCCESS -> withSuccess()
            DeathSaveResult.FAILURE -> withFailures(1)
            DeathSaveResult.CRITICAL_SUCCESS -> conscious(1)
            DeathSaveResult.CRITICAL_FAILURE -> withFailures(2)
        }
    }

    // Revivify, Raise Dead y similares dejan 1 HP; otras magias (True Resurrection) dan más.
    fun revive(hitPoints: Int = 1): HitPoints {
        if (status != LifeStatus.DEAD) {
            throw CombatActionNotAllowedException("only a dead character can be revived, was $status")
        }
        require(hitPoints in 1..max) { "revived hit points must be between 1 and $max, was $hitPoints" }
        return conscious(hitPoints).copy(temporary = 0)
    }

    // Si el máximo baja del actual, el actual baja con él.
    fun withMax(newMax: Int): HitPoints = copy(max = newMax, current = minOf(current, newMax))

    private fun conscious(hitPoints: Int) =
        copy(current = hitPoints, status = LifeStatus.CONSCIOUS, deathSaves = DeathSaves.NONE)

    // Tres éxitos lo estabilizan y los contadores vuelven a 0.
    private fun withSuccess(): HitPoints {
        val successes = deathSaves.successes + 1
        return if (successes == DeathSaves.MAX) {
            copy(status = LifeStatus.STABLE, deathSaves = DeathSaves.NONE)
        } else {
            copy(deathSaves = deathSaves.copy(successes = successes))
        }
    }

    // Un estable que recibe daño vuelve a estar muriendo. Tres fallos lo matan.
    private fun withFailures(count: Int): HitPoints {
        val failures = minOf(DeathSaves.MAX, deathSaves.failures + count)
        val newStatus = if (failures == DeathSaves.MAX) LifeStatus.DEAD else LifeStatus.DYING
        return copy(status = newStatus, deathSaves = deathSaves.copy(failures = failures))
    }

    private fun checkNotDead(action: String) {
        if (status == LifeStatus.DEAD) {
            throw CombatActionNotAllowedException("a dead character can't be $action: revive it first")
        }
    }

    companion object {
        const val MIN_MAX = 1
        const val MAX_MAX = 999
        const val MAX_TEMPORARY = 999
        private val COUNTING_STATUSES = setOf(LifeStatus.DYING, LifeStatus.DEAD)
    }
}
