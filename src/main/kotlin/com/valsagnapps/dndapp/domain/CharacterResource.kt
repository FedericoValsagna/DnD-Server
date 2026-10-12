package com.valsagnapps.dndapp.domain

// Un recurso del personaje: el máximo y la recarga salen de sus clases; los usados los marca el jugador.
data class CharacterResource(val resource: Resource, val max: Int, val used: Int, val recharge: Recharge) {
    val remaining: Int
        get() = max - used

    companion object {
        // Los recursos que dan las features ganadas, en el orden de las clases y sus features. Si varias clases dan
        // el mismo (Channel Divinity de Cleric y Paladin), no se suman: vale el mayor máximo y la recarga más
        // corta. Uno sin límite no se lleva. Los usados se recortan al máximo, que puede haber bajado con el nivel.
        fun of(classes: List<ClassLevel>, abilityScores: AbilityScores, used: Map<Resource, Int>) = classes
            .flatMap { classLevel ->
                classLevel.features.mapNotNull { feature ->
                    feature.uses?.let { uses ->
                        Grant(
                            feature.resource!!,
                            uses.max(classLevel.level, abilityScores),
                            uses.recharge(classLevel.level),
                        )
                    }
                }
            }
            .groupBy { it.resource }
            .filterValues { grants -> grants.all { it.max != null } }
            .map { (resource, grants) ->
                val max = grants.maxOf { it.max!! }
                CharacterResource(
                    resource = resource,
                    max = max,
                    used = minOf(max, used[resource] ?: 0),
                    recharge = grants.minOf { it.recharge },
                )
            }

        private data class Grant(val resource: Resource, val max: Int?, val recharge: Recharge)
    }
}
