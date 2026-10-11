package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.CharacterClass
import com.valsagnapps.dndapp.domain.ClassFeature
import com.valsagnapps.dndapp.domain.Subclass

// Features por clase y subclase, en orden de nivel. Las clases y subclases sin cargar todavía no tienen features.
internal val CLASS_FEATURES: Map<CharacterClass, List<ClassFeature>> = mapOf(
    CharacterClass.CLERIC to CLERIC_FEATURES,
    CharacterClass.PALADIN to PALADIN_FEATURES,
    CharacterClass.RANGER to RANGER_FEATURES,
)

internal val SUBCLASS_FEATURES: Map<Subclass, List<ClassFeature>> = mapOf(
    Subclass.LIFE to LIFE_FEATURES,
    Subclass.NATURE to NATURE_FEATURES,
    Subclass.HUNTER to HUNTER_FEATURES,
    Subclass.DEVOTION to DEVOTION_FEATURES,
    Subclass.ANCIENTS to ANCIENTS_FEATURES,
    Subclass.VENGEANCE to VENGEANCE_FEATURES,
)
