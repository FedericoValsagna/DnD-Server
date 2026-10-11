package com.valsagnapps.dndapp.domain

// Con qué descanso se recuperan todos los usos de un recurso, de más corto a más largo (el orden importa: entre dos
// recargas vale la más corta). El long rest recupera también los de short rest.
enum class Recharge { SHORT_REST, LONG_REST }
