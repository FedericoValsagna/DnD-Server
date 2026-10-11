package com.valsagnapps.dndapp.domain

// Qué cuesta usar una feature en el turno. Las pasivas (o las que van dentro de otra acción, como Sneak Attack)
// no tienen.
enum class ActionType { ACTION, BONUS_ACTION, REACTION }
