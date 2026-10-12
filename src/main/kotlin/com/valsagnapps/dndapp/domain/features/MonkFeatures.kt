package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.ActionType
import com.valsagnapps.dndapp.domain.ClassFeature
import com.valsagnapps.dndapp.domain.Recharge
import com.valsagnapps.dndapp.domain.Resource
import com.valsagnapps.dndapp.domain.Uses

// Monk y sus tradiciones. Monk y Way of the Open Hand son SRD: llevan el texto del SRD 5.1 además del resumen propio.
internal val MONK_FEATURES = listOf(
    ClassFeature(
        id = "MONK_UNARMORED_DEFENSE",
        name = "Unarmored Defense",
        level = 1,
        summary = "Without armor or shield, your AC is 10 + Dexterity modifier + Wisdom modifier.",
        srdText =
        "Beginning at 1st level, while you are wearing no armor and not wielding a shield, your AC equals 10 + your " +
            "Dexterity modifier + your Wisdom modifier.",
    ),
    ClassFeature(
        id = "MONK_MARTIAL_ARTS",
        name = "Martial Arts",
        level = 1,
        summary =
        "Unarmed or with monk weapons (shortswords and simple melee weapons without two-handed or heavy), and no " +
            "armor or shield: use Dexterity for attack and damage, roll the Martial Arts die for damage (d4, d6 at " +
            "5th, d8 at 11th, d10 at 17th) and make an unarmed strike as a bonus action after attacking.",
        srdText =
        "At 1st level, your practice of martial arts gives you mastery of combat styles that use unarmed strikes and " +
            "monk weapons, which are shortswords and any simple melee weapons that don't have the two-handed or " +
            "heavy property.\n\nYou gain the following benefits while you are unarmed or wielding only monk weapons " +
            "and you aren't wearing armor or wielding a shield:\n\n- You can use Dexterity instead of Strength for " +
            "the attack and damage rolls of your unarmed strikes and monk weapons.\n\n- You can roll a d4 in place " +
            "of the normal damage of your unarmed strike or monk weapon. This die changes as you gain monk levels, " +
            "as shown in the Martial Arts column of Table: The Monk.\n\n- When you use the Attack action with an " +
            "unarmed strike or a monk weapon on your turn, you can make one unarmed strike as a bonus action. For " +
            "example, if you take the Attack action and attack with a quarterstaff, you can also make an unarmed " +
            "strike as a bonus action, assuming you haven't already taken a bonus action this turn.\n\nCertain " +
            "monasteries use specialized forms of the monk weapons. For example, you might use a club that is two " +
            "lengths of wood connected by a short chain (called a nunchaku) or a sickle with a shorter, straighter " +
            "blade (called a kama). Whatever name you use for a monk weapon, you can use the game statistics " +
            "provided for the weapon.\n\nMartial Arts die: 1d4 at 1st level, 1d6 at 5th level, 1d8 at 11th level, " +
            "1d10 at 17th level.",
        actionType = ActionType.BONUS_ACTION,
    ),
    ClassFeature(
        id = "MONK_KI",
        name = "Ki",
        level = 2,
        summary =
        "Ki points equal to your monk level, recovered after a short or long rest with 30 minutes of meditation. Ki " +
            "save DC = 8 + proficiency bonus + Wisdom modifier.",
        srdText =
        "Starting at 2nd level, your training allows you to harness the mystic energy of ki. Your access to this " +
            "energy is represented by a number of ki points. Your monk level determines the number of points you " +
            "have, as shown in the Ki Points column of Table: The Monk.\n\nYou can spend these points to fuel " +
            "various ki features. You start knowing three such features: Flurry of Blows, Patient Defense, and Step " +
            "of the Wind. You learn more ki features as you gain levels in this class.\n\nWhen you spend a ki point, " +
            "it is unavailable until you finish a short or long rest, at the end of which you draw all of your " +
            "expended ki back into yourself. You must spend at least 30 minutes of the rest meditating to regain " +
            "your ki points.\n\nSome of your ki features require your target to make a saving throw to resist the " +
            "feature's effects. The saving throw DC is calculated as follows:\n\nKi save DC = 8 + your proficiency " +
            "bonus + your Wisdom modifier\n\nKi points: equal to your monk level (2 at 2nd level, 20 at 20th).",
        resource = Resource.KI,
        uses = Uses.perClassLevel(multiplier = 1, recharge = Recharge.SHORT_REST),
    ),
    ClassFeature(
        id = "MONK_FLURRY_OF_BLOWS",
        name = "Flurry of Blows",
        level = 2,
        summary = "1 ki point, right after the Attack action: two unarmed strikes as a bonus action.",
        srdText =
        "Immediately after you take the Attack action on your turn, you can spend 1 ki point to make two unarmed " +
            "strikes as a bonus action.",
        actionType = ActionType.BONUS_ACTION,
        resource = Resource.KI,
    ),
    ClassFeature(
        id = "MONK_PATIENT_DEFENSE",
        name = "Patient Defense",
        level = 2,
        summary = "1 ki point: Dodge as a bonus action.",
        srdText = "You can spend 1 ki point to take the Dodge action as a bonus action on your turn.",
        actionType = ActionType.BONUS_ACTION,
        resource = Resource.KI,
    ),
    ClassFeature(
        id = "MONK_STEP_OF_THE_WIND",
        name = "Step of the Wind",
        level = 2,
        summary = "1 ki point: Disengage or Dash as a bonus action, and your jump distance is doubled for the turn.",
        srdText =
        "You can spend 1 ki point to take the Disengage or Dash action as a bonus action on your turn, and your jump " +
            "distance is doubled for the turn.",
        actionType = ActionType.BONUS_ACTION,
        resource = Resource.KI,
    ),
    ClassFeature(
        id = "MONK_UNARMORED_MOVEMENT",
        name = "Unarmored Movement",
        level = 2,
        summary =
        "Without armor or shield, +10 ft of speed (+15 at 6th, +20 at 10th, +25 at 14th, +30 at 18th). From 9th " +
            "level you can move along vertical surfaces and across liquids during your move.",
        srdText =
        "Starting at 2nd level, your speed increases by 10 feet while you are not wearing armor or wielding a " +
            "shield. This bonus increases when you reach certain monk levels, as shown in Table: The Monk.\n\nAt 9th " +
            "level, you gain the ability to move along vertical surfaces and across liquids on your turn without " +
            "falling during the move.\n\nSpeed bonus: +10 ft at 2nd level, +15 ft at 6th level, +20 ft at 10th " +
            "level, +25 ft at 14th level, +30 ft at 18th level.",
    ),
    ClassFeature(
        id = "MONK_DEFLECT_MISSILES",
        name = "Deflect Missiles",
        level = 3,
        summary =
        "Reaction: when hit by a ranged weapon attack, reduce the damage by 1d10 + Dexterity modifier + monk level. " +
            "If it drops to 0 you can catch the missile and spend 1 ki point to throw it back (range 20/60).",
        srdText =
        "Starting at 3rd level, you can use your reaction to deflect or catch the missile when you are hit by a " +
            "ranged weapon attack. When you do so, the damage you take from the attack is reduced by 1d10 + your " +
            "Dexterity modifier + your monk level.\n\nIf you reduce the damage to 0, you can catch the missile if it " +
            "is small enough for you to hold in one hand and you have at least one hand free. If you catch a missile " +
            "in this way, you can spend 1 ki point to make a ranged attack with the weapon or piece of ammunition " +
            "you just caught, as part of the same reaction. You make this attack with proficiency, regardless of " +
            "your weapon proficiencies, and the missile counts as a monk weapon for the attack, which has a normal " +
            "range of 20 feet and a long range of 60 feet.",
        actionType = ActionType.REACTION,
    ),
    ClassFeature(
        id = "MONK_ABILITY_SCORE_IMPROVEMENT",
        name = "Ability Score Improvement",
        level = 4,
        summary = "At 4th, 8th, 12th, 16th and 19th level: +2 to one ability score or +1 to two (maximum 20).",
        srdText =
        "When you reach 4th level, and again at 8th, 12th, 16th, and 19th level, you can increase one ability score " +
            "of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you can't " +
            "increase an ability score above 20 using this feature.",
    ),
    ClassFeature(
        id = "MONK_SLOW_FALL",
        name = "Slow Fall",
        level = 4,
        summary = "Reaction: reduce falling damage by five times your monk level.",
        srdText =
        "Beginning at 4th level, you can use your reaction when you fall to reduce any falling damage you take by an " +
            "amount equal to five times your monk level.",
        actionType = ActionType.REACTION,
    ),
    ClassFeature(
        id = "MONK_EXTRA_ATTACK",
        name = "Extra Attack",
        level = 5,
        summary = "Attack twice when you take the Attack action.",
        srdText =
        "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your " +
            "turn.",
    ),
    ClassFeature(
        id = "MONK_STUNNING_STRIKE",
        name = "Stunning Strike",
        level = 5,
        summary =
        "When you hit with a melee weapon attack, spend 1 ki point: the target makes a Constitution save or is " +
            "stunned until the end of your next turn.",
        srdText =
        "Starting at 5th level, you can interfere with the flow of ki in an opponent's body. When you hit another " +
            "creature with a melee weapon attack, you can spend 1 ki point to attempt a stunning strike. The target " +
            "must succeed on a Constitution saving throw or be stunned until the end of your next turn.",
        resource = Resource.KI,
    ),
    ClassFeature(
        id = "MONK_KI_EMPOWERED_STRIKES",
        name = "Ki-Empowered Strikes",
        level = 6,
        summary = "Your unarmed strikes count as magical for overcoming resistance and immunity.",
        srdText =
        "Starting at 6th level, your unarmed strikes count as magical for the purpose of overcoming resistance and " +
            "immunity to nonmagical attacks and damage.",
    ),
    ClassFeature(
        id = "MONK_EVASION",
        name = "Evasion",
        level = 7,
        summary = "On Dexterity saves for half damage, take no damage on a success and half on a failure.",
        srdText =
        "At 7th level, your instinctive agility lets you dodge out of the way of certain area effects, such as a " +
            "blue dragon's lightning breath or a fireball spell. When you are subjected to an effect that allows you " +
            "to make a Dexterity saving throw to take only half damage, you instead take no damage if you succeed on " +
            "the saving throw, and only half damage if you fail.",
    ),
    ClassFeature(
        id = "MONK_STILLNESS_OF_MIND",
        name = "Stillness of Mind",
        level = 7,
        summary = "Action: end one effect charming or frightening you.",
        srdText =
        "Starting at 7th level, you can use your action to end one effect on yourself that is causing you to be " +
            "charmed or frightened.",
        actionType = ActionType.ACTION,
    ),
    ClassFeature(
        id = "MONK_PURITY_OF_BODY",
        name = "Purity of Body",
        level = 10,
        summary = "Immunity to disease and poison.",
        srdText = "At 10th level, your mastery of the ki flowing through you makes you immune to disease and poison.",
    ),
    ClassFeature(
        id = "MONK_TONGUE_OF_THE_SUN_AND_MOON",
        name = "Tongue of the Sun and Moon",
        level = 13,
        summary = "You understand all spoken languages, and any creature that understands a language understands you.",
        srdText =
        "Starting at 13th level, you learn to touch the ki of other minds so that you understand all spoken " +
            "languages. Moreover, any creature that can understand a language can understand what you say.",
    ),
    ClassFeature(
        id = "MONK_DIAMOND_SOUL",
        name = "Diamond Soul",
        level = 14,
        summary = "Proficiency in all saving throws, and spend 1 ki point to reroll a failed save.",
        srdText =
        "Beginning at 14th level, your mastery of ki grants you proficiency in all saving throws.\n\nAdditionally, " +
            "whenever you make a saving throw and fail, you can spend 1 ki point to reroll it and take the second " +
            "result.",
        resource = Resource.KI,
    ),
    ClassFeature(
        id = "MONK_TIMELESS_BODY",
        name = "Timeless Body",
        level = 15,
        summary = "No frailty of old age, can't be aged magically, and you no longer need food or water.",
        srdText =
        "At 15th level, your ki sustains you so that you suffer none of the frailty of old age, and you can't be " +
            "aged magically. You can still die of old age, however. In addition, you no longer need food or water.",
    ),
    ClassFeature(
        id = "MONK_EMPTY_BODY",
        name = "Empty Body",
        level = 18,
        summary =
        "Action, 4 ki points: invisible for 1 minute with resistance to all damage except force. 8 ki points: cast " +
            "astral projection on yourself only, without material components.",
        srdText =
        "Beginning at 18th level, you can use your action to spend 4 ki points to become invisible for 1 minute. " +
            "During that time, you also have resistance to all damage but force damage.\n\nAdditionally, you can " +
            "spend 8 ki points to cast the astral projection spell, without needing material components. When you do " +
            "so, you can't take any other creatures with you.",
        actionType = ActionType.ACTION,
        resource = Resource.KI,
    ),
    ClassFeature(
        id = "MONK_PERFECT_SELF",
        name = "Perfect Self",
        level = 20,
        summary = "If you roll initiative with no ki points left, regain 4.",
        srdText =
        "At 20th level, when you roll for initiative and have no ki points remaining, you regain 4 ki points.",
    ),
)

internal val OPEN_HAND_FEATURES = listOf(
    ClassFeature(
        id = "OPEN_HAND_OPEN_HAND_TECHNIQUE",
        name = "Open Hand Technique",
        level = 3,
        summary =
        "When you hit with a Flurry of Blows attack, choose one: Dexterity save or prone, Strength save or pushed 15 " +
            "ft, or no reactions until the end of your next turn.",
        srdText =
        "Starting when you choose this tradition at 3rd level, you can manipulate your enemy's ki when you harness " +
            "your own. Whenever you hit a creature with one of the attacks granted by your Flurry of Blows, you can " +
            "impose one of the following effects on that target:\n\n- It must succeed on a Dexterity saving throw or " +
            "be knocked prone.\n\n- It must make a Strength saving throw. If it fails, you can push it up to 15 feet " +
            "away from you.\n\n- It can't take reactions until the end of your next turn.",
    ),
    ClassFeature(
        id = "OPEN_HAND_WHOLENESS_OF_BODY",
        name = "Wholeness of Body",
        level = 6,
        summary = "Action: regain three times your monk level in hit points. Once per long rest.",
        srdText =
        "At 6th level, you gain the ability to heal yourself. As an action, you can regain hit points equal to three " +
            "times your monk level. You must finish a long rest before you can use this feature again.",
        actionType = ActionType.ACTION,
        resource = Resource.WHOLENESS_OF_BODY,
        uses = Uses.fixed(count = 1, recharge = Recharge.LONG_REST),
    ),
    ClassFeature(
        id = "OPEN_HAND_TRANQUILITY",
        name = "Tranquility",
        level = 11,
        summary =
        "At the end of a long rest, gain the effect of sanctuary until your next long rest (DC 8 + Wisdom modifier + " +
            "proficiency bonus).",
        srdText =
        "Beginning at 11th level, you can enter a special meditation that surrounds you with an aura of peace. At " +
            "the end of a long rest, you gain the effect of a sanctuary spell that lasts until the start of your " +
            "next long rest (the spell can end early as normal). The saving throw DC for the spell equals 8 + your " +
            "Wisdom modifier + your proficiency bonus.",
    ),
    ClassFeature(
        id = "OPEN_HAND_QUIVERING_PALM",
        name = "Quivering Palm",
        level = 17,
        summary =
        "When you hit with an unarmed strike, spend 3 ki points to set up vibrations lasting your monk level in " +
            "days. Action to end them: Constitution save or drop to 0 hit points, 10d10 necrotic on a success. One " +
            "creature at a time.",
        srdText =
        "At 17th level, you gain the ability to set up lethal vibrations in someone's body. When you hit a creature " +
            "with an unarmed strike, you can spend 3 ki points to start these imperceptible vibrations, which last " +
            "for a number of days equal to your monk level. The vibrations are harmless unless you use your action " +
            "to end them. To do so, you and the target must be on the same plane of existence. When you use this " +
            "action, the creature must make a Constitution saving throw. If it fails, it is reduced to 0 hit points. " +
            "If it succeeds, it takes 10d10 necrotic damage.\n\nYou can have only one creature under the effect of " +
            "this feature at a time. You can choose to end the vibrations harmlessly without using an action.",
        resource = Resource.KI,
    ),
)

// Way of Shadow no es SRD: solo resúmenes propios.
internal val SHADOW_FEATURES = listOf(
    ClassFeature(
        id = "SHADOW_SHADOW_ARTS",
        name = "Shadow Arts",
        level = 3,
        summary =
        "Spend 2 ki points to cast darkness, darkvision, pass without trace or silence without material components. " +
            "You also learn the minor illusion cantrip.",
        actionType = ActionType.ACTION,
        resource = Resource.KI,
    ),
    ClassFeature(
        id = "SHADOW_SHADOW_STEP",
        name = "Shadow Step",
        level = 6,
        summary =
        "Bonus action: from dim light or darkness, teleport up to 60 ft to a space you can see that is also in dim " +
            "light or darkness, and gain advantage on your first melee attack before the end of the turn.",
        actionType = ActionType.BONUS_ACTION,
    ),
    ClassFeature(
        id = "SHADOW_CLOAK_OF_SHADOWS",
        name = "Cloak of Shadows",
        level = 11,
        summary =
        "Action: in dim light or darkness, become invisible until you attack, cast a spell or are in bright light.",
        actionType = ActionType.ACTION,
    ),
    ClassFeature(
        id = "SHADOW_OPPORTUNIST",
        name = "Opportunist",
        level = 17,
        summary =
        "Reaction: when a creature within 5 ft is hit by someone else's attack, make a melee attack against it.",
        actionType = ActionType.REACTION,
    ),
)

// Way of the Four Elements no es SRD: solo resúmenes propios.
internal val FOUR_ELEMENTS_FEATURES = listOf(
    ClassFeature(
        id = "FOUR_ELEMENTS_DISCIPLE_OF_THE_ELEMENTS",
        name = "Disciple of the Elements",
        level = 3,
        summary =
        "Learn Elemental Attunement and one elemental discipline, plus one more at 6th, 11th and 17th level; when " +
            "you learn one you can swap another. Disciplines that cast a spell spend ki (maximum per spell: 2 at 3rd " +
            "level, 3 at 5th, 4 at 9th, 5 at 13th, 6 at 17th; each extra point raises the spell level by one) and " +
            "use your ki save DC. Disciplines: Elemental Attunement (minor elemental effects, free); Fangs of the " +
            "Fire Snake (1 ki: 10 ft reach and fire damage on unarmed strikes, +1d10 per extra ki); Fist of Four " +
            "Thunders (2 ki: thunderwave); Fist of Unbroken Air (2 ki, 30 ft: Strength save or 3d10 bludgeoning, " +
            "pushed 20 ft and prone, +1d10 per extra ki); Rush of the Gale Spirits (2 ki: gust of wind); Shape the " +
            "Flowing River (1 ki: shape water and ice in a 30 ft cube); Sweeping Cinder Strike (2 ki: burning " +
            "hands); Water Whip (2 ki, 30 ft: Dexterity save or 3d10 bludgeoning and prone or pulled 25 ft, +1d10 " +
            "per extra ki). From 6th level: Clench of the North Wind (3 ki: hold person); Gong of the Summit (3 ki: " +
            "shatter). From 11th: Eternal Mountain Defense (5 ki: stoneskin on yourself); Flames of the Phoenix (4 " +
            "ki: fireball); Mist Stance (4 ki: gaseous form on yourself); Ride the Wind (4 ki: fly on yourself). " +
            "From 17th: Breath of Winter (6 ki: cone of cold); River of Hungry Flame (5 ki: wall of fire); Wave of " +
            "Rolling Earth (6 ki: wall of stone).",
        actionType = ActionType.ACTION,
        resource = Resource.KI,
    ),
)
