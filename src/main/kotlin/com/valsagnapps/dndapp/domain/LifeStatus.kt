package com.valsagnapps.dndapp.domain

// CONSCIOUS: HP por encima de 0. En 0 HP lo dicen los death saves: DEAD con tres fallos (solo vuelve revivido),
// STABLE con tres éxitos (no tira, hasta que lo curen o le peguen) y DYING si no.
enum class LifeStatus { CONSCIOUS, DYING, STABLE, DEAD }
