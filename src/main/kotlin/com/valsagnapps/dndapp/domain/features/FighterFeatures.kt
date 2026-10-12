package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.ActionType
import com.valsagnapps.dndapp.domain.ClassFeature
import com.valsagnapps.dndapp.domain.Recharge
import com.valsagnapps.dndapp.domain.Resource
import com.valsagnapps.dndapp.domain.Uses
import com.valsagnapps.dndapp.domain.atLevel

// Fighter y sus arquetipos. Fighter y Champion son SRD: llevan el texto del SRD 5.1 además del resumen propio.
internal val FIGHTER_FEATURES = listOf(
    ClassFeature(
        id = "FIGHTER_FIGHTING_STYLE",
        name = "Fighting Style",
        level = 1,
        summary =
        "Choose one: Archery (+2 to ranged weapon attack rolls), Defense (+1 AC while wearing armor), Dueling (+2 " +
            "damage with a one-handed melee weapon and no other weapon), Great Weapon Fighting (reroll 1s and 2s on " +
            "damage dice of two-handed melee weapons), Protection (reaction with a shield: impose disadvantage on an " +
            "attack against an ally within 5 ft) or Two-Weapon Fighting (add your ability modifier to the damage of " +
            "the second attack).",
        srdText =
        "Archery. You gain a +2 bonus to attack rolls you make with ranged weapons.\n\nDefense. While you are " +
            "wearing armor, you gain a +1 bonus to AC.\n\nDueling. When you are wielding a melee weapon in one hand " +
            "and no other weapons, you gain a +2 bonus to damage rolls with that weapon.\n\nGreat Weapon Fighting. " +
            "When you roll a 1 or 2 on a damage die for an attack you make with a melee weapon that you are wielding " +
            "with two hands, you can reroll the die and must use the new roll, even if the new roll is a 1 or a 2. " +
            "The weapon must have the two-handed or versatile property for you to gain this benefit.\n\nProtection. " +
            "When a creature you can see attacks a target other than you that is within 5 feet of you, you can use " +
            "your reaction to impose disadvantage on the attack roll. You must be wielding a shield.\n\nTwo-Weapon " +
            "Fighting. When you engage in two-weapon fighting, you can add your ability modifier to the damage of " +
            "the second attack.",
    ),
    ClassFeature(
        id = "FIGHTER_SECOND_WIND",
        name = "Second Wind",
        level = 1,
        summary = "Bonus action: regain 1d10 + fighter level hit points. Once per short or long rest.",
        srdText =
        "You have a limited well of stamina that you can draw on to protect yourself from harm. On your turn, you " +
            "can use a bonus action to regain hit points equal to 1d10 + your fighter level. Once you use this " +
            "feature, you must finish a short or long rest before you can use it again.",
        actionType = ActionType.BONUS_ACTION,
        resource = Resource.SECOND_WIND,
        uses = Uses.fixed(count = 1, recharge = Recharge.SHORT_REST),
    ),
    ClassFeature(
        id = "FIGHTER_ACTION_SURGE",
        name = "Action Surge",
        level = 2,
        summary =
        "Take one additional action on your turn. Once per short or long rest; twice from 17th level, but only once " +
            "per turn.",
        srdText =
        "Starting at 2nd level, you can push yourself beyond your normal limits for a moment. On your turn, you can " +
            "take one additional action on top of your regular action and a possible bonus action.\n\nOnce you use " +
            "this feature, you must finish a short or long rest before you can use it again. Starting at 17th level, " +
            "you can use it twice before a rest, but only once on the same turn.",
        resource = Resource.ACTION_SURGE,
        uses = Uses.byLevel(
            Recharge.SHORT_REST,
            atLevel(level = 2, uses = 1),
            atLevel(level = 17, uses = 2),
        ),
    ),
    ClassFeature(
        id = "FIGHTER_ABILITY_SCORE_IMPROVEMENT",
        name = "Ability Score Improvement",
        level = 4,
        summary =
        "At 4th, 6th, 8th, 12th, 14th, 16th and 19th level: +2 to one ability score or +1 to two (maximum 20).",
        srdText =
        "When you reach 4th level, and again at 6th, 8th, 12th, 14th, 16th, and 19th level, you can increase one " +
            "ability score of your choice by 2, or you can increase two ability scores of your choice by 1. As " +
            "normal, you can't increase an ability score above 20 using this feature.",
    ),
    ClassFeature(
        id = "FIGHTER_EXTRA_ATTACK",
        name = "Extra Attack",
        level = 5,
        summary = "Attack twice when you take the Attack action, three times from 11th level and four from 20th.",
        srdText =
        "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your " +
            "turn. The number of attacks increases to three when you reach 11th level in this class and to four when " +
            "you reach 20th level in this class.",
    ),
    ClassFeature(
        id = "FIGHTER_INDOMITABLE",
        name = "Indomitable",
        level = 9,
        summary =
        "Reroll a failed saving throw and keep the new roll. Once per long rest, twice from 13th level and three " +
            "times from 17th.",
        srdText =
        "Beginning at 9th level, you can reroll a saving throw that you fail. If you do so, you must use the new " +
            "roll, and you can't use this feature again until you finish a long rest. You can use this feature twice " +
            "between long rests starting at 13th level and three times between long rests starting at 17th level.",
        resource = Resource.INDOMITABLE,
        uses = Uses.byLevel(
            Recharge.LONG_REST,
            atLevel(level = 9, uses = 1),
            atLevel(level = 13, uses = 2),
            atLevel(level = 17, uses = 3),
        ),
    ),
)

internal val CHAMPION_FEATURES = listOf(
    ClassFeature(
        id = "CHAMPION_IMPROVED_CRITICAL",
        name = "Improved Critical",
        level = 3,
        summary = "Your weapon attacks score a critical hit on 19 or 20.",
        srdText =
        "Beginning when you choose this archetype at 3rd level, your weapon attacks score a critical hit on a roll " +
            "of 19 or 20.",
    ),
    ClassFeature(
        id = "CHAMPION_REMARKABLE_ATHLETE",
        name = "Remarkable Athlete",
        level = 7,
        summary =
        "Add half your proficiency bonus (rounded up) to Strength, Dexterity and Constitution checks that don't " +
            "already use it, and your running long jump grows by your Strength modifier in feet.",
        srdText =
        "Starting at 7th level, you can add half your proficiency bonus (round up) to any Strength, Dexterity, or " +
            "Constitution check you make that doesn't already use your proficiency bonus. In addition, when you make " +
            "a running long jump, the distance you can cover increases by a number of feet equal to your Strength " +
            "modifier.",
    ),
    ClassFeature(
        id = "CHAMPION_ADDITIONAL_FIGHTING_STYLE",
        name = "Additional Fighting Style",
        level = 10,
        summary = "Choose a second Fighting Style option.",
        srdText = "At 10th level, you can choose a second option from the Fighting Style class feature.",
    ),
    ClassFeature(
        id = "CHAMPION_SUPERIOR_CRITICAL",
        name = "Superior Critical",
        level = 15,
        summary = "Your weapon attacks score a critical hit on 18 to 20.",
        srdText = "Starting at 15th level, your weapon attacks score a critical hit on a roll of 18-20.",
    ),
    ClassFeature(
        id = "CHAMPION_SURVIVOR",
        name = "Survivor",
        level = 18,
        summary =
        "At the start of each of your turns, regain 5 + Constitution modifier hit points if you are at half your hit " +
            "points or fewer (but not at 0).",
        srdText =
        "At 18th level, you attain the pinnacle of resilience in battle. At the start of each of your turns, you " +
            "regain hit points equal to 5 + your Constitution modifier if you have no more than half of your hit " +
            "points left. You don't gain this benefit if you have 0 hit points.",
    ),
)

// Battle Master no es SRD: solo resúmenes propios.
internal val BATTLE_MASTER_FEATURES = listOf(
    ClassFeature(
        id = "BATTLE_MASTER_COMBAT_SUPERIORITY",
        name = "Combat Superiority",
        level = 3,
        summary =
        "Learn three maneuvers (two more at 7th, 10th and 15th level; when you learn new ones you can swap one) and " +
            "gain four superiority dice, d8s (one more at 7th and 15th), recovered on a short or long rest. " +
            "Maneuvers use one die each, once per attack, and their saves have DC 8 + proficiency bonus + Strength " +
            "or Dexterity modifier. Maneuvers: Commander's Strike (forgo an attack and use a bonus action so an ally " +
            "attacks with its reaction, adding the die to damage); Disarming Attack (add the die to damage, Strength " +
            "save or drop an item); Distracting Strike (add the die to damage, the next attack by someone else " +
            "against the target has advantage); Evasive Footwork (add the die to AC while moving); Feinting Attack " +
            "(bonus action: advantage on your next attack against a creature within 5 ft, add the die to damage); " +
            "Goading Attack (add the die to damage, Wisdom save or disadvantage attacking others); Lunging Attack " +
            "(+5 ft of reach, add the die to damage); Maneuvering Attack (add the die to damage, an ally moves half " +
            "its speed without provoking from the target); Menacing Attack (add the die to damage, Wisdom save or " +
            "frightened until the end of your next turn); Parry (reaction: reduce melee damage by the die + " +
            "Dexterity modifier); Precision Attack (add the die to an attack roll); Pushing Attack (add the die to " +
            "damage, Strength save or pushed 15 ft, Large or smaller); Rally (bonus action: an ally gains temporary " +
            "hit points equal to the die + Charisma modifier); Riposte (reaction: when a creature misses you in " +
            "melee, attack it and add the die to damage); Sweeping Attack (deal the die as damage to another " +
            "creature within 5 ft if the attack roll would hit it); Trip Attack (add the die to damage, Strength " +
            "save or prone, Large or smaller).",
        resource = Resource.SUPERIORITY_DICE,
        uses = Uses.byLevel(
            Recharge.SHORT_REST,
            atLevel(level = 3, uses = 4),
            atLevel(level = 7, uses = 5),
            atLevel(level = 15, uses = 6),
        ),
    ),
    ClassFeature(
        id = "BATTLE_MASTER_STUDENT_OF_WAR",
        name = "Student of War",
        level = 3,
        summary = "Proficiency with one type of artisan's tools.",
    ),
    ClassFeature(
        id = "BATTLE_MASTER_KNOW_YOUR_ENEMY",
        name = "Know Your Enemy",
        level = 7,
        summary =
        "Observe or interact with a creature for 1 minute outside combat to learn whether it is your equal, superior " +
            "or inferior in two of: Strength, Dexterity, Constitution, AC, current hit points, total class levels or " +
            "fighter levels.",
    ),
    ClassFeature(
        id = "BATTLE_MASTER_IMPROVED_COMBAT_SUPERIORITY",
        name = "Improved Combat Superiority",
        level = 10,
        summary = "Your superiority dice become d10s, and d12s from 18th level.",
    ),
    ClassFeature(
        id = "BATTLE_MASTER_RELENTLESS",
        name = "Relentless",
        level = 15,
        summary = "If you roll initiative with no superiority dice left, regain one.",
    ),
)

// Eldritch Knight no es SRD: solo resúmenes propios.
internal val ELDRITCH_KNIGHT_FEATURES = listOf(
    ClassFeature(
        id = "ELDRITCH_KNIGHT_SPELLCASTING",
        name = "Spellcasting",
        level = 3,
        summary =
        "Known-spells third caster with Intelligence, from the wizard list: mostly abjuration and evocation spells, " +
            "with a few from any school. You learn spells as you level up and can swap one each level. Slots recover " +
            "on a long rest.",
    ),
    ClassFeature(
        id = "ELDRITCH_KNIGHT_WEAPON_BOND",
        name = "Weapon Bond",
        level = 3,
        summary =
        "A 1-hour ritual bonds you to a weapon (up to two). You can't be disarmed of it unless incapacitated, and as " +
            "a bonus action you can summon it to your hand from the same plane.",
        actionType = ActionType.BONUS_ACTION,
    ),
    ClassFeature(
        id = "ELDRITCH_KNIGHT_WAR_MAGIC",
        name = "War Magic",
        level = 7,
        summary = "When you use your action to cast a cantrip, make one weapon attack as a bonus action.",
        actionType = ActionType.BONUS_ACTION,
    ),
    ClassFeature(
        id = "ELDRITCH_KNIGHT_ELDRITCH_STRIKE",
        name = "Eldritch Strike",
        level = 10,
        summary =
        "A creature you hit with a weapon attack has disadvantage on its next save against a spell you cast before " +
            "the end of your next turn.",
    ),
    ClassFeature(
        id = "ELDRITCH_KNIGHT_ARCANE_CHARGE",
        name = "Arcane Charge",
        level = 15,
        summary = "When you use Action Surge, you can teleport up to 30 ft to an unoccupied space you can see.",
    ),
    ClassFeature(
        id = "ELDRITCH_KNIGHT_IMPROVED_WAR_MAGIC",
        name = "Improved War Magic",
        level = 18,
        summary = "When you use your action to cast a spell, make one weapon attack as a bonus action.",
    ),
)
