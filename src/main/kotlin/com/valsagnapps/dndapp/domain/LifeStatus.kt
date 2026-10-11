package com.valsagnapps.dndapp.domain

// CONSCIOUS: HP por encima de 0. En 0 HP: DYING (tira death saves), STABLE (no tira, hasta que lo curen o le
// peguen) o DEAD (solo vuelve revivido).
enum class LifeStatus { CONSCIOUS, DYING, STABLE, DEAD }
