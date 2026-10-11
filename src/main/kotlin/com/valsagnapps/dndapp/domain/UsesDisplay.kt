package com.valsagnapps.dndapp.domain

// Cómo muestra la app un recurso: puntos que se tocan (pocos usos) o un número que se gasta con el teclado (pools
// grandes, como Ki o Lay on Hands). Lo decide el server para que la app no repita la regla.
enum class UsesDisplay { PIPS, POOL }
