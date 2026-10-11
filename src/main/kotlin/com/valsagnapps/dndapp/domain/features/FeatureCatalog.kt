package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.CharacterClass
import com.valsagnapps.dndapp.domain.ClassFeature
import com.valsagnapps.dndapp.domain.Subclass

// Features por clase y subclase, en orden de nivel. Las clases y subclases sin cargar todavía no tienen features.
internal val CLASS_FEATURES: Map<CharacterClass, List<ClassFeature>> = mapOf(
    CharacterClass.BARBARIAN to BARBARIAN_FEATURES,
    CharacterClass.BARD to BARD_FEATURES,
    CharacterClass.CLERIC to CLERIC_FEATURES,
    CharacterClass.DRUID to DRUID_FEATURES,
    CharacterClass.FIGHTER to FIGHTER_FEATURES,
    CharacterClass.MONK to MONK_FEATURES,
    CharacterClass.PALADIN to PALADIN_FEATURES,
    CharacterClass.RANGER to RANGER_FEATURES,
    CharacterClass.ROGUE to ROGUE_FEATURES,
    CharacterClass.SORCERER to SORCERER_FEATURES,
    CharacterClass.WIZARD to WIZARD_FEATURES,
)

internal val SUBCLASS_FEATURES: Map<Subclass, List<ClassFeature>> = mapOf(
    Subclass.BERSERKER to BERSERKER_FEATURES,
    Subclass.TOTEM_WARRIOR to TOTEM_WARRIOR_FEATURES,
    Subclass.LORE to LORE_FEATURES,
    Subclass.VALOR to VALOR_FEATURES,
    Subclass.LIFE to LIFE_FEATURES,
    Subclass.NATURE to NATURE_FEATURES,
    Subclass.LAND to LAND_FEATURES,
    Subclass.MOON to MOON_FEATURES,
    Subclass.CHAMPION to CHAMPION_FEATURES,
    Subclass.BATTLE_MASTER to BATTLE_MASTER_FEATURES,
    Subclass.ELDRITCH_KNIGHT to ELDRITCH_KNIGHT_FEATURES,
    Subclass.OPEN_HAND to OPEN_HAND_FEATURES,
    Subclass.SHADOW to SHADOW_FEATURES,
    Subclass.FOUR_ELEMENTS to FOUR_ELEMENTS_FEATURES,
    Subclass.HUNTER to HUNTER_FEATURES,
    Subclass.THIEF to THIEF_FEATURES,
    Subclass.ASSASSIN to ASSASSIN_FEATURES,
    Subclass.ARCANE_TRICKSTER to ARCANE_TRICKSTER_FEATURES,
    Subclass.DEVOTION to DEVOTION_FEATURES,
    Subclass.ANCIENTS to ANCIENTS_FEATURES,
    Subclass.VENGEANCE to VENGEANCE_FEATURES,
    Subclass.DRACONIC_BLOODLINE to DRACONIC_BLOODLINE_FEATURES,
    Subclass.WILD_MAGIC to WILD_MAGIC_FEATURES,
    Subclass.ABJURATION to ABJURATION_FEATURES,
    Subclass.CONJURATION to CONJURATION_FEATURES,
    Subclass.DIVINATION to DIVINATION_FEATURES,
    Subclass.ENCHANTMENT to ENCHANTMENT_FEATURES,
    Subclass.EVOCATION to EVOCATION_FEATURES,
    Subclass.ILLUSION to ILLUSION_FEATURES,
    Subclass.NECROMANCY to NECROMANCY_FEATURES,
    Subclass.TRANSMUTATION to TRANSMUTATION_FEATURES,
)
