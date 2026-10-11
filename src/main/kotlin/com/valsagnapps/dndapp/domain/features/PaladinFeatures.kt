package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.Ability
import com.valsagnapps.dndapp.domain.ActionType
import com.valsagnapps.dndapp.domain.ClassFeature
import com.valsagnapps.dndapp.domain.Recharge
import com.valsagnapps.dndapp.domain.Resource
import com.valsagnapps.dndapp.domain.Uses

// Paladin y sus juramentos. Paladin y Oath of Devotion son SRD: llevan el texto del SRD 5.1 además del resumen propio.
internal val PALADIN_FEATURES = listOf(
    ClassFeature(
        id = "PALADIN_DIVINE_SENSE",
        name = "Divine Sense",
        level = 1,
        summary =
        "Action: until the end of your next turn, know the location and type of any celestial, fiend or undead " +
            "within 60 ft not behind total cover, and any consecrated or desecrated place or object. 1 + Charisma " +
            "modifier uses per long rest.",
        srdText =
        "The presence of strong evil registers on your senses like a noxious odor, and powerful good rings like " +
            "heavenly music in your ears. As an action, you can open your awareness to detect such forces. Until the " +
            "end of your next turn, you know the location of any celestial, fiend, or undead within 60 feet of you " +
            "that is not behind total cover. You know the type (celestial, fiend, or undead) of any being whose " +
            "presence you sense, but not its identity. Within the same radius, you also detect the presence of any " +
            "place or object that has been consecrated or desecrated, as with the hallow spell.\n\nYou can use this " +
            "feature a number of times equal to 1 + your Charisma modifier. When you finish a long rest, you regain " +
            "all expended uses.",
        actionType = ActionType.ACTION,
        resource = Resource.DIVINE_SENSE,
        uses = Uses.abilityModifier(Ability.CHARISMA, Recharge.LONG_REST, bonus = 1),
    ),
    ClassFeature(
        id = "PALADIN_LAY_ON_HANDS",
        name = "Lay on Hands",
        level = 1,
        summary =
        "Healing pool of five times your paladin level hit points per long rest. Action: touch a creature to restore " +
            "hit points from the pool, or spend 5 points to cure a disease or neutralize a poison. Doesn't work on " +
            "undead or constructs.",
        srdText =
        "Your blessed touch can heal wounds. You have a pool of healing power that replenishes when you take a long " +
            "rest. With that pool, you can restore a total number of hit points equal to your paladin level x " +
            "5.\n\nAs an action, you can touch a creature and draw power from the pool to restore a number of hit " +
            "points to that creature, up to the maximum amount remaining in your pool.\n\nAlternatively, you can " +
            "expend 5 hit points from your pool of healing to cure the target of one disease or neutralize one " +
            "poison affecting it. You can cure multiple diseases and neutralize multiple poisons with a single use " +
            "of Lay on Hands, expending hit points separately for each one.\n\nThis feature has no effect on undead " +
            "and constructs.",
        actionType = ActionType.ACTION,
        resource = Resource.LAY_ON_HANDS,
        uses = Uses.perClassLevel(multiplier = 5, recharge = Recharge.LONG_REST),
    ),
    ClassFeature(
        id = "PALADIN_FIGHTING_STYLE",
        name = "Fighting Style",
        level = 2,
        summary =
        "Choose one: Defense (+1 AC while wearing armor), Dueling (+2 damage with a one-handed melee weapon and no " +
            "other weapon), Great Weapon Fighting (reroll 1s and 2s on damage dice of two-handed melee weapons) or " +
            "Protection (reaction with a shield: impose disadvantage on an attack against an ally within 5 ft).",
        srdText =
        "Defense. While you are wearing armor, you gain a +1 bonus to AC.\n\nDueling. When you are wielding a melee " +
            "weapon in one hand and no other weapons, you gain a +2 bonus to damage rolls with that weapon.\n\nGreat " +
            "Weapon Fighting. When you roll a 1 or 2 on a damage die for an attack you make with a melee weapon that " +
            "you are wielding with two hands, you can reroll the die and must use the new roll. The weapon must have " +
            "the two-handed or versatile property for you to gain this benefit.\n\nProtection. When a creature you " +
            "can see attacks a target other than you that is within 5 feet of you, you can use your reaction to " +
            "impose disadvantage on the attack roll. You must be wielding a shield.",
    ),
    ClassFeature(
        id = "PALADIN_SPELLCASTING",
        name = "Spellcasting",
        level = 2,
        summary =
        "Prepared half caster with Charisma: after a long rest, prepare Charisma modifier + half your paladin level " +
            "spells from the paladin list. Slots recover on a long rest, and a holy symbol works as spellcasting " +
            "focus.",
        srdText =
        "By 2nd level, you have learned to draw on divine magic through meditation and prayer to cast spells as a " +
            "cleric does.\n\nPreparing and Casting Spells. The Paladin table shows how many spell slots you have to " +
            "cast your spells. To cast one of your paladin spells of 1st level or higher, you must expend a slot of " +
            "the spell's level or higher. You regain all expended spell slots when you finish a long rest.\n\nYou " +
            "prepare the list of paladin spells that are available for you to cast, choosing from the paladin spell " +
            "list. When you do so, choose a number of paladin spells equal to your Charisma modifier + half your " +
            "paladin level, rounded down (minimum of one spell). The spells must be of a level for which you have " +
            "spell slots.\n\nFor example, if you are a 5th-level paladin, you have four 1st-level and two 2nd-level " +
            "spell slots. With a Charisma of 14, your list of prepared spells can include four spells of 1st or 2nd " +
            "level, in any combination. If you prepare the 1st-level spell cure wounds, you can cast it using a " +
            "1st-level or a 2nd-level slot. Casting the spell doesn't remove it from your list of prepared " +
            "spells.\n\nYou can change your list of prepared spells when you finish a long rest. Preparing a new " +
            "list of paladin spells requires time spent in prayer and meditation: at least 1 minute per spell level " +
            "for each spell on your list.\n\nSpellcasting Ability. Charisma is your spellcasting ability for your " +
            "paladin spells, since their power derives from the strength of your convictions. You use your Charisma " +
            "whenever a spell refers to your spellcasting ability. In addition, you use your Charisma modifier when " +
            "setting the saving throw DC for a paladin spell you cast and when making an attack roll with " +
            "one.\n\nSpell save DC = 8 + your proficiency bonus + your Charisma modifier.\n\nSpell attack modifier = " +
            "your proficiency bonus + your Charisma modifier.\n\nSpellcasting Focus. You can use a holy symbol as a " +
            "spellcasting focus for your paladin spells.",
    ),
    ClassFeature(
        id = "PALADIN_DIVINE_SMITE",
        name = "Divine Smite",
        level = 2,
        summary =
        "When you hit with a melee weapon attack, expend a spell slot to deal an extra 2d8 radiant damage, +1d8 per " +
            "slot level above 1st (maximum 5d8), and +1d8 against undead or fiends.",
        srdText =
        "Starting at 2nd level, when you hit a creature with a melee weapon attack, you can expend one spell slot to " +
            "deal radiant damage to the target, in addition to the weapon's damage. The extra damage is 2d8 for a " +
            "1st-level spell slot, plus 1d8 for each spell level higher than 1st, to a maximum of 5d8. The damage " +
            "increases by 1d8 if the target is an undead or a fiend.",
    ),
    ClassFeature(
        id = "PALADIN_DIVINE_HEALTH",
        name = "Divine Health",
        level = 3,
        summary = "Immunity to disease.",
        srdText = "By 3rd level, the divine magic flowing through you makes you immune to disease.",
    ),
    ClassFeature(
        id = "PALADIN_CHANNEL_DIVINITY",
        name = "Channel Divinity",
        level = 3,
        summary =
        "Channel divine energy into one of your oath's Channel Divinity options. Once per short or long rest. Saves " +
            "use your paladin spell save DC.",
        srdText =
        "Your oath allows you to channel divine energy to fuel magical effects. Each Channel Divinity option " +
            "provided by your oath explains how to use it.\n\nWhen you use your Channel Divinity, you choose which " +
            "option to use. You must then finish a short or long rest to use your Channel Divinity again.\n\nSome " +
            "Channel Divinity effects require saving throws. When you use such an effect from this class, the DC " +
            "equals your paladin spell save DC.",
        resource = Resource.CHANNEL_DIVINITY,
        uses = Uses.fixed(count = 1, recharge = Recharge.SHORT_REST),
    ),
    ClassFeature(
        id = "PALADIN_ABILITY_SCORE_IMPROVEMENT",
        name = "Ability Score Improvement",
        level = 4,
        summary = "At 4th, 8th, 12th, 16th and 19th level: +2 to one ability score or +1 to two (maximum 20).",
        srdText =
        "When you reach 4th level, and again at 8th, 12th, 16th, and 19th level, you can increase one ability score " +
            "of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you can't " +
            "increase an ability score above 20 using this feature.",
    ),
    ClassFeature(
        id = "PALADIN_EXTRA_ATTACK",
        name = "Extra Attack",
        level = 5,
        summary = "Attack twice when you take the Attack action.",
        srdText =
        "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your " +
            "turn.",
    ),
    ClassFeature(
        id = "PALADIN_AURA_OF_PROTECTION",
        name = "Aura of Protection",
        level = 6,
        summary =
        "While you are conscious, you and friendly creatures within 10 ft add your Charisma modifier (minimum +1) to " +
            "saving throws. The aura reaches 30 ft from 18th level.",
        srdText =
        "Starting at 6th level, whenever you or a friendly creature within 10 feet of you must make a saving throw, " +
            "the creature gains a bonus to the saving throw equal to your Charisma modifier (with a minimum bonus of " +
            "+1). You must be conscious to grant this bonus.\n\nAt 18th level, the range of this aura increases to " +
            "30 feet.",
    ),
    ClassFeature(
        id = "PALADIN_AURA_OF_COURAGE",
        name = "Aura of Courage",
        level = 10,
        summary =
        "While you are conscious, you and friendly creatures within 10 ft can't be frightened. The aura reaches 30 " +
            "ft from 18th level.",
        srdText =
        "Starting at 10th level, you and friendly creatures within 10 feet of you can't be frightened while you are " +
            "conscious.\n\nAt 18th level, the range of this aura increases to 30 feet.",
    ),
    ClassFeature(
        id = "PALADIN_IMPROVED_DIVINE_SMITE",
        name = "Improved Divine Smite",
        level = 11,
        summary = "Your melee weapon hits deal an extra 1d8 radiant damage, which stacks with Divine Smite.",
        srdText =
        "By 11th level, you are so suffused with righteous might that all your melee weapon strikes carry divine " +
            "power with them. Whenever you hit a creature with a melee weapon, the creature takes an extra 1d8 " +
            "radiant damage. If you also use your Divine Smite with an attack, you add this damage to the extra " +
            "damage of your Divine Smite.",
    ),
    ClassFeature(
        id = "PALADIN_CLEANSING_TOUCH",
        name = "Cleansing Touch",
        level = 14,
        summary =
        "Action: end one spell on yourself or on a willing creature you touch. Charisma modifier uses (minimum 1) " +
            "per long rest.",
        srdText =
        "Beginning at 14th level, you can use your action to end one spell on yourself or on one willing creature " +
            "that you touch.\n\nYou can use this feature a number of times equal to your Charisma modifier (a " +
            "minimum of once). You regain expended uses when you finish a long rest.",
        actionType = ActionType.ACTION,
        resource = Resource.CLEANSING_TOUCH,
        uses = Uses.abilityModifier(Ability.CHARISMA, Recharge.LONG_REST),
    ),
)

internal val DEVOTION_FEATURES = listOf(
    ClassFeature(
        id = "DEVOTION_SACRED_WEAPON",
        name = "Channel Divinity: Sacred Weapon",
        level = 3,
        summary =
        "Action: for 1 minute, a weapon you hold adds your Charisma modifier (minimum +1) to attack rolls, sheds " +
            "bright light in 20 ft and counts as magical.",
        srdText =
        "As an action, you can imbue one weapon that you are holding with positive energy, using your Channel " +
            "Divinity. For 1 minute, you add your Charisma modifier to attack rolls made with that weapon (with a " +
            "minimum bonus of +1). The weapon also emits bright light in a 20-foot radius and dim light 20 feet " +
            "beyond that. If the weapon is not already magical, it becomes magical for the duration.\n\nYou can end " +
            "this effect on your turn as part of any other action. If you are no longer holding or carrying this " +
            "weapon, or if you fall unconscious, this effect ends.",
        actionType = ActionType.ACTION,
        resource = Resource.CHANNEL_DIVINITY,
    ),
    ClassFeature(
        id = "DEVOTION_TURN_THE_UNHOLY",
        name = "Channel Divinity: Turn the Unholy",
        level = 3,
        summary =
        "Action: each fiend or undead within 30 ft that can see or hear you makes a Wisdom save. On a failure it is " +
            "turned for 1 minute or until it takes damage.",
        srdText =
        "As an action, you present your holy symbol and speak a prayer censuring fiends and undead, using your " +
            "Channel Divinity. Each fiend or undead that can see or hear you within 30 feet of you must make a " +
            "Wisdom saving throw. If the creature fails its saving throw, it is turned for 1 minute or until it " +
            "takes damage.\n\nA turned creature must spend its turns trying to move as far away from you as it can, " +
            "and it can't willingly move to a space within 30 feet of you. It also can't take reactions. For its " +
            "action, it can use only the Dash action or try to escape from an effect that prevents it from moving. " +
            "If there's nowhere to move, the creature can use the Dodge action.",
        actionType = ActionType.ACTION,
        resource = Resource.CHANNEL_DIVINITY,
    ),
    ClassFeature(
        id = "DEVOTION_AURA_OF_DEVOTION",
        name = "Aura of Devotion",
        level = 7,
        summary =
        "While you are conscious, you and friendly creatures within 10 ft can't be charmed. The aura reaches 30 ft " +
            "from 18th level.",
        srdText =
        "Starting at 7th level, you and friendly creatures within 10 feet of you can't be charmed while you are " +
            "conscious.\n\nAt 18th level, the range of this aura increases to 30 feet.",
    ),
    ClassFeature(
        id = "DEVOTION_PURITY_OF_SPIRIT",
        name = "Purity of Spirit",
        level = 15,
        summary = "You are always under the effects of protection from evil and good.",
        srdText = "Beginning at 15th level, you are always under the effects of a protection from evil and good spell.",
    ),
    ClassFeature(
        id = "DEVOTION_HOLY_NIMBUS",
        name = "Holy Nimbus",
        level = 20,
        summary =
        "Action: for 1 minute, shed bright sunlight in 30 ft. Enemies that start their turn in it take 10 radiant " +
            "damage, and you have advantage on saves against spells of fiends and undead. Once per long rest.",
        srdText =
        "At 20th level, as an action, you can emanate an aura of sunlight. For 1 minute, bright light shines from " +
            "you in a 30-foot radius, and dim light shines 30 feet beyond that.\n\nWhenever an enemy creature starts " +
            "its turn in the bright light, the creature takes 10 radiant damage.\n\nIn addition, for the duration, " +
            "you have advantage on saving throws against spells cast by fiends or undead.",
        actionType = ActionType.ACTION,
        resource = Resource.HOLY_NIMBUS,
        uses = Uses.fixed(count = 1, recharge = Recharge.LONG_REST),
    ),
)

// Oath of the Ancients no es SRD: solo resúmenes propios.
internal val ANCIENTS_FEATURES = listOf(
    ClassFeature(
        id = "ANCIENTS_NATURES_WRATH",
        name = "Channel Divinity: Nature's Wrath",
        level = 3,
        summary =
        "Action: spectral vines try to restrain a creature within 10 ft. It makes a Strength or Dexterity save (its " +
            "choice) or is restrained, and repeats the save at the end of each of its turns.",
        actionType = ActionType.ACTION,
        resource = Resource.CHANNEL_DIVINITY,
    ),
    ClassFeature(
        id = "ANCIENTS_TURN_THE_FAITHLESS",
        name = "Channel Divinity: Turn the Faithless",
        level = 3,
        summary =
        "Action: each fey or fiend within 30 ft that can hear you makes a Wisdom save or is turned for 1 minute or " +
            "until it takes damage. A creature in disguise or shapechanged reveals its true form.",
        actionType = ActionType.ACTION,
        resource = Resource.CHANNEL_DIVINITY,
    ),
    ClassFeature(
        id = "ANCIENTS_AURA_OF_WARDING",
        name = "Aura of Warding",
        level = 7,
        summary =
        "You and friendly creatures within 10 ft have resistance to damage from spells. The aura reaches 30 ft from " +
            "18th level.",
    ),
    ClassFeature(
        id = "ANCIENTS_UNDYING_SENTINEL",
        name = "Undying Sentinel",
        level = 15,
        summary =
        "Once per long rest, when you are reduced to 0 hit points without being killed outright, drop to 1 hit point " +
            "instead. You also don't suffer the drawbacks of old age and can't be aged magically.",
        resource = Resource.UNDYING_SENTINEL,
        uses = Uses.fixed(count = 1, recharge = Recharge.LONG_REST),
    ),
    ClassFeature(
        id = "ANCIENTS_ELDER_CHAMPION",
        name = "Elder Champion",
        level = 20,
        summary =
        "Action: transform for 1 minute. You regain 10 hit points at the start of each of your turns, cast paladin " +
            "spells of 1 action as a bonus action, and enemies within 10 ft have disadvantage on saves against your " +
            "spells and Channel Divinity. Once per long rest.",
        actionType = ActionType.ACTION,
        resource = Resource.ELDER_CHAMPION,
        uses = Uses.fixed(count = 1, recharge = Recharge.LONG_REST),
    ),
)

// Oath of Vengeance no es SRD: solo resúmenes propios.
internal val VENGEANCE_FEATURES = listOf(
    ClassFeature(
        id = "VENGEANCE_ABJURE_ENEMY",
        name = "Channel Divinity: Abjure Enemy",
        level = 3,
        summary =
        "Action: a creature within 60 ft that you can see makes a Wisdom save (fiends and undead with disadvantage). " +
            "On a failure it is frightened for 1 minute or until it takes damage and its speed is 0; on a success " +
            "its speed is halved.",
        actionType = ActionType.ACTION,
        resource = Resource.CHANNEL_DIVINITY,
    ),
    ClassFeature(
        id = "VENGEANCE_VOW_OF_ENMITY",
        name = "Channel Divinity: Vow of Enmity",
        level = 3,
        summary =
        "Bonus action: gain advantage on attack rolls against a creature within 10 ft for 1 minute or until it drops " +
            "to 0 hit points or falls unconscious.",
        actionType = ActionType.BONUS_ACTION,
        resource = Resource.CHANNEL_DIVINITY,
    ),
    ClassFeature(
        id = "VENGEANCE_RELENTLESS_AVENGER",
        name = "Relentless Avenger",
        level = 7,
        summary =
        "When you hit a creature with an opportunity attack, you can move up to half your speed right away as part " +
            "of the same reaction, without provoking opportunity attacks.",
    ),
    ClassFeature(
        id = "VENGEANCE_SOUL_OF_VENGEANCE",
        name = "Soul of Vengeance",
        level = 15,
        summary =
        "When the target of your Vow of Enmity attacks, you can use your reaction to make a melee weapon attack " +
            "against it if it is within range.",
        actionType = ActionType.REACTION,
    ),
    ClassFeature(
        id = "VENGEANCE_AVENGING_ANGEL",
        name = "Avenging Angel",
        level = 20,
        summary =
        "Action: transform for 1 hour. You gain wings with a 60 ft flying speed and an aura of menace in 30 ft: the " +
            "first time an enemy enters it or starts its turn there in a battle, it makes a Wisdom save or is " +
            "frightened for 1 minute or until it takes damage. Attacks against a frightened creature have advantage. " +
            "Once per long rest.",
        actionType = ActionType.ACTION,
        resource = Resource.AVENGING_ANGEL,
        uses = Uses.fixed(count = 1, recharge = Recharge.LONG_REST),
    ),
)
