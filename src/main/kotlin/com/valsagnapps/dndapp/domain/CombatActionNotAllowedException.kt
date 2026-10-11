package com.valsagnapps.dndapp.domain

// Una acción que el estado del personaje no permite ahora (curar a un muerto, marcar un death save estando
// consciente, ...). Sale como 409: el pedido es válido, pero no en este estado.
class CombatActionNotAllowedException(message: String) : RuntimeException(message)
