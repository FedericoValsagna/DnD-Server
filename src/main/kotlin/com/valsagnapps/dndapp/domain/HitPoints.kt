package com.valsagnapps.dndapp.domain

// HP del personaje y su estado en combate. El máximo lo carga el jugador; el resto lo mueven el daño, la curación,
// los HP temporales y los death saves, con las reglas de 5e 2014 (PHB, cap. 9). El estado sale del HP y de los
// death saves, así que marcarlos o desmarcarlos a mano también corrige el estado.
data class HitPoints(
    val max: Int,
    val current: Int = max,
    val temporary: Int = 0,
    val deathSaves: DeathSaves = DeathSaves.NONE,
) {
    init {
        require(max in MIN_MAX..MAX_MAX) { "maxHitPoints must be between $MIN_MAX and $MAX_MAX, was $max" }
        require(current in 0..max) { "current hit points must be between 0 and $max, was $current" }
        require(temporary in 0..MAX_TEMPORARY) {
            "temporary hit points must be between 0 and $MAX_TEMPORARY, was $temporary"
        }
        require(current == 0 || deathSaves == DeathSaves.NONE) {
            "only a character at 0 hit points has death saves, had $current"
        }
    }

    val status: LifeStatus
        get() = when {
            current > 0 -> LifeStatus.CONSCIOUS
            deathSaves.isDead -> LifeStatus.DEAD
            deathSaves.isStable -> LifeStatus.STABLE
            else -> LifeStatus.DYING
        }

    // Los temporales absorben primero. Si el resto lo deja en 0 y lo que sobra llega al máximo, muere en el acto.
    // Estando en 0, cualquier daño es un fallo de death save (dos si es crítico), o muerte si llega al máximo; un
    // estable vuelve a tirar desde cero. A un muerto no le pasa nada.
    fun takeDamage(amount: Int, critical: Boolean = false): HitPoints {
        require(amount >= 1) { "damage must be at least 1, was $amount" }
        if (status == LifeStatus.DEAD) return this
        val absorbed = minOf(temporary, amount)
        val remaining = amount - absorbed
        val afterTemporary = copy(temporary = temporary - absorbed)
        return when {
            remaining == 0 -> afterTemporary
            remaining - current >= max -> afterTemporary.copy(current = 0, deathSaves = DEAD)
            remaining < current -> afterTemporary.copy(current = current - remaining)
            current > 0 -> afterTemporary.copy(current = 0)
            else -> afterTemporary.withFailures(if (critical) 2 else 1)
        }
    }

    // Tope en el máximo. Curar a alguien en 0 lo despierta y reinicia los death saves (un 20 natural es curar 1);
    // a un muerto hay que revivirlo.
    fun heal(amount: Int): HitPoints {
        require(amount >= 1) { "healing must be at least 1, was $amount" }
        checkNotDead("healed")
        return copy(current = minOf(max, current + amount), deathSaves = DeathSaves.NONE)
    }

    // Los temporales nuevos reemplazan a los que había: no se suman. 0 los saca.
    fun withTemporary(amount: Int): HitPoints {
        checkNotDead("given temporary hit points")
        return copy(temporary = amount)
    }

    // El jugador marca y desmarca los puntos, como los slots: con 0 HP, cualquier combinación vale (también
    // desmarcar el tercer fallo, para corregir un error).
    fun withDeathSaves(deathSaves: DeathSaves): HitPoints {
        if (current > 0) {
            throw CombatActionNotAllowedException("only a character at 0 hit points makes death saves")
        }
        return copy(deathSaves = deathSaves)
    }

    // Revivify, Raise Dead y similares dejan 1 HP; otras magias (True Resurrection) dan más.
    fun revive(hitPoints: Int = 1): HitPoints {
        if (status != LifeStatus.DEAD) {
            throw CombatActionNotAllowedException("only a dead character can be revived, was $status")
        }
        require(hitPoints in 1..max) { "revived hit points must be between 1 and $max, was $hitPoints" }
        return copy(current = hitPoints, temporary = 0, deathSaves = DeathSaves.NONE)
    }

    // Si el máximo baja del actual, el actual baja con él.
    fun withMax(newMax: Int): HitPoints = copy(max = newMax, current = minOf(current, newMax))

    // Un estable que recibe daño vuelve a tirar desde cero. Tres fallos lo matan.
    private fun withFailures(count: Int): HitPoints {
        val previous = if (status == LifeStatus.STABLE) DeathSaves.NONE else deathSaves
        return copy(deathSaves = previous.copy(failures = minOf(DeathSaves.MAX, previous.failures + count)))
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
        private val DEAD = DeathSaves(failures = DeathSaves.MAX)
    }
}
