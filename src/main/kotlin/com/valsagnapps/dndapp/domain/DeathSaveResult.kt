package com.valsagnapps.dndapp.domain

// Lo que marca el jugador: la app no tira dados. CRITICAL_SUCCESS es un 20 natural (vuelve con 1 HP) y
// CRITICAL_FAILURE un 1 natural (cuenta como dos fallos).
enum class DeathSaveResult { SUCCESS, FAILURE, CRITICAL_SUCCESS, CRITICAL_FAILURE }
