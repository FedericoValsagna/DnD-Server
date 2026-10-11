package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.ClassFeature

// Bard y sus colegios. Bard y College of Lore son SRD: llevan el texto del SRD 5.1 además del resumen propio.
internal val BARD_FEATURES = listOf(
    ClassFeature(
        id = "BARD_SPELLCASTING",
        name = "Spellcasting",
        level = 1,
        summary =
        "Known-spells caster with Charisma: you learn bard spells as you level up and can swap one for another each " +
            "level. Slots recover on a long rest. Known ritual spells can be cast as rituals, and a musical " +
            "instrument works as spellcasting focus.",
        srdText =
        "You have learned to untangle and reshape the fabric of reality in harmony with your wishes and music. Your " +
            "spells are part of your vast repertoire, magic that you can tune to different situations.\n\nCantrips. " +
            "You know two cantrips of your choice from the bard spell list. You learn additional bard cantrips of " +
            "your choice at higher levels, as shown in the Cantrips Known column of the Bard table.\n\nSpell Slots. " +
            "The Bard table shows how many spell slots you have to cast your spells of 1st level and higher. To cast " +
            "one of these spells, you must expend a slot of the spell's level or higher. You regain all expended " +
            "spell slots when you finish a long rest.\n\nFor example, if you know the 1st-level spell cure wounds " +
            "and have a 1st-level and a 2nd-level spell slot available, you can cast cure wounds using either " +
            "slot.\n\nSpells Known of 1st Level and Higher. You know four 1st-level spells of your choice from the " +
            "bard spell list.\n\nThe Spells Known column of the Bard table shows when you learn more bard spells of " +
            "your choice.\n\nEach of these spells must be of a level for which you have spell slots, as shown on the " +
            "table. For instance, when you reach 3rd level in this class, you can learn one new spell of 1st or 2nd " +
            "level.\n\nAdditionally, when you gain a level in this class, you can choose one of the bard spells you " +
            "know and replace it with another spell from the bard spell list, which also must be of a level for " +
            "which you have spell slots.\n\nSpellcasting Ability. Charisma is your spellcasting ability for your " +
            "bard spells. Your magic comes from the heart and soul you pour into the performance of your music or " +
            "oration. You use your Charisma whenever a spell refers to your spellcasting ability. In addition, you " +
            "use your Charisma modifier when setting the saving throw DC for a bard spell you cast and when making " +
            "an attack roll with one.\n\nSpell save DC = 8 + your proficiency bonus + your Charisma " +
            "modifier.\n\nSpell attack modifier = your proficiency bonus + your Charisma modifier.\n\nRitual " +
            "Casting. You can cast any bard spell you know as a ritual if that spell has the ritual " +
            "tag.\n\nSpellcasting Focus. You can use a musical instrument (see Equipment) as a spellcasting focus " +
            "for your bard spells.",
    ),
    ClassFeature(
        id = "BARD_BARDIC_INSPIRATION",
        name = "Bardic Inspiration",
        level = 1,
        summary =
        "Bonus action: give a creature within 60 ft that can hear you an inspiration die (d6, d8 at 5th level, d10 " +
            "at 10th, d12 at 15th) to add to one ability check, attack roll or saving throw within 10 minutes. " +
            "Charisma modifier uses (minimum 1) per long rest.",
        srdText =
        "You can inspire others through stirring words or music. To do so, you use a bonus action on your turn to " +
            "choose one creature other than yourself within 60 feet of you who can hear you. That creature gains one " +
            "Bardic Inspiration die, a d6. Once within the next 10 minutes, the creature can roll the die and add " +
            "the number rolled to one ability check, attack roll, or saving throw it makes. The creature can wait " +
            "until after it rolls the d20 before deciding to use the Bardic Inspiration die, but must decide before " +
            "the GM says whether the roll succeeds or fails. Once the Bardic Inspiration die is rolled, it is lost. " +
            "A creature can have only one Bardic Inspiration die at a time.\n\nYou can use this feature a number of " +
            "times equal to your Charisma modifier (a minimum of once). You regain any expended uses when you finish " +
            "a long rest.\n\nYour Bardic Inspiration die changes when you reach certain levels in this class. The " +
            "die becomes a d8 at 5th level, a d10 at 10th level, and a d12 at 15th level.",
    ),
    ClassFeature(
        id = "BARD_JACK_OF_ALL_TRADES",
        name = "Jack of All Trades",
        level = 2,
        summary = "Add half your proficiency bonus (rounded down) to ability checks that don't already include it.",
        srdText =
        "Starting at 2nd level, you can add half your proficiency bonus, rounded down, to any ability check you make " +
            "that doesn't already include your proficiency bonus.",
    ),
    ClassFeature(
        id = "BARD_SONG_OF_REST",
        name = "Song of Rest",
        level = 2,
        summary =
        "During a short rest, you and friendly creatures who hear you and spend Hit Dice regain an extra 1d6 hit " +
            "points (1d8 at 9th level, 1d10 at 13th, 1d12 at 17th).",
        srdText =
        "Beginning at 2nd level, you can use soothing music or oration to help revitalize your wounded allies during " +
            "a short rest. If you or any friendly creatures who can hear your performance regain hit points at the " +
            "end of the short rest by spending one or more Hit Dice, each of those creatures regains an extra 1d6 " +
            "hit points.\n\nThe extra hit points increase when you reach certain levels in this class: to 1d8 at 9th " +
            "level, to 1d10 at 13th level, and to 1d12 at 17th level.",
    ),
    ClassFeature(
        id = "BARD_EXPERTISE",
        name = "Expertise",
        level = 3,
        summary = "Double your proficiency bonus on two skills you are proficient in, and on two more at 10th level.",
        srdText =
        "At 3rd level, choose two of your skill proficiencies. Your proficiency bonus is doubled for any ability " +
            "check you make that uses either of the chosen proficiencies. At 10th level, you can choose another two " +
            "skill proficiencies to gain this benefit.",
    ),
    ClassFeature(
        id = "BARD_ABILITY_SCORE_IMPROVEMENT",
        name = "Ability Score Improvement",
        level = 4,
        summary = "At 4th, 8th, 12th, 16th and 19th level: +2 to one ability score or +1 to two (maximum 20).",
        srdText =
        "When you reach 4th level, and again at 8th, 12th, 16th, and 19th level, you can increase one ability score " +
            "of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you can't " +
            "increase an ability score above 20 using this feature.",
    ),
    ClassFeature(
        id = "BARD_FONT_OF_INSPIRATION",
        name = "Font of Inspiration",
        level = 5,
        summary = "Bardic Inspiration uses recover on a short or long rest.",
        srdText =
        "Beginning when you reach 5th level, you regain all of your expended uses of Bardic Inspiration when you " +
            "finish a short or long rest.",
    ),
    ClassFeature(
        id = "BARD_COUNTERCHARM",
        name = "Countercharm",
        level = 6,
        summary =
        "Action: until the end of your next turn, you and friendly creatures within 30 ft that hear you have " +
            "advantage on saves against being frightened or charmed.",
        srdText =
        "At 6th level, you gain the ability to use musical notes or words of power to disrupt mind-influencing " +
            "effects. As an action, you can start a performance that lasts until the end of your next turn. During " +
            "that time, you and any friendly creatures within 30 feet of you have advantage on saving throws against " +
            "being frightened or charmed. A creature must be able to hear you to gain this benefit. The performance " +
            "ends early if you are incapacitated or silenced or if you voluntarily end it (no action required).",
    ),
    ClassFeature(
        id = "BARD_MAGICAL_SECRETS",
        name = "Magical Secrets",
        level = 10,
        summary =
        "Learn two spells from any class (cantrips or levels you can cast), which count as bard spells known. Two " +
            "more at 14th and 18th level.",
        srdText =
        "By 10th level, you have plundered magical knowledge from a wide spectrum of disciplines. Choose two spells " +
            "from any class, including this one. A spell you choose must be of a level you can cast, as shown on the " +
            "Bard table, or a cantrip.\n\nThe chosen spells count as bard spells for you and are included in the " +
            "number in the Spells Known column of the Bard table.\n\nYou learn two additional spells from any class " +
            "at 14th level and again at 18th level.",
    ),
    ClassFeature(
        id = "BARD_SUPERIOR_INSPIRATION",
        name = "Superior Inspiration",
        level = 20,
        summary = "If you roll initiative with no Bardic Inspiration uses left, regain one.",
        srdText =
        "At 20th level, when you roll initiative and have no uses of Bardic Inspiration left, you regain one use.",
    ),
)

internal val LORE_FEATURES = listOf(
    ClassFeature(
        id = "LORE_BONUS_PROFICIENCIES",
        name = "Bonus Proficiencies",
        level = 3,
        summary = "Proficiency in three skills of your choice.",
        srdText =
        "When you join the College of Lore at 3rd level, you gain proficiency with three skills of your choice.",
    ),
    ClassFeature(
        id = "LORE_CUTTING_WORDS",
        name = "Cutting Words",
        level = 3,
        summary =
        "Reaction: when a creature within 60 ft makes an attack roll, ability check or damage roll, spend a Bardic " +
            "Inspiration use and subtract the die from it. Doesn't work on creatures that can't hear you or can't be " +
            "charmed.",
        srdText =
        "Also at 3rd level, you learn how to use your wit to distract, confuse, and otherwise sap the confidence and " +
            "competence of others.\n\nWhen a creature that you can see within 60 feet of you makes an attack roll, " +
            "an ability check, or a damage roll, you can use your reaction to expend one of your uses of Bardic " +
            "Inspiration, rolling a Bardic Inspiration die and subtracting the number rolled from the creature's " +
            "roll.\n\nYou can choose to use this feature after the creature makes its roll, but before the GM " +
            "determines whether the attack roll or ability check succeeds or fails, or before the creature deals its " +
            "damage. The creature is immune if it can't hear you or if it's immune to being charmed.",
    ),
    ClassFeature(
        id = "LORE_ADDITIONAL_MAGICAL_SECRETS",
        name = "Additional Magical Secrets",
        level = 6,
        summary =
        "Learn two spells from any class (cantrips or levels you can cast); they count as bard spells but not " +
            "against your spells known.",
        srdText =
        "At 6th level, you learn two spells of your choice from any class. A spell you choose must be of a level you " +
            "can cast, as shown on the Bard table, or a cantrip. The chosen spells count as bard spells for you but " +
            "don't count against the number of bard spells you know.",
    ),
    ClassFeature(
        id = "LORE_PEERLESS_SKILL",
        name = "Peerless Skill",
        level = 14,
        summary = "Spend a Bardic Inspiration use to add the die to one of your ability checks.",
        srdText =
        "Starting at 14th level, when you make an ability check, you can expend one use of Bardic Inspiration. Roll " +
            "a Bardic Inspiration die and add the number rolled to your ability check. You can choose to do so after " +
            "you roll the die for the ability check, but before the GM tells you whether you succeed or fail.",
    ),
)

// College of Valor no es SRD: solo resúmenes propios.
internal val VALOR_FEATURES = listOf(
    ClassFeature(
        id = "VALOR_BONUS_PROFICIENCIES",
        name = "Bonus Proficiencies",
        level = 3,
        summary = "Proficiency with medium armor, shields and martial weapons.",
    ),
    ClassFeature(
        id = "VALOR_COMBAT_INSPIRATION",
        name = "Combat Inspiration",
        level = 3,
        summary =
        "A creature with your Bardic Inspiration die can also add it to a weapon damage roll, or use its reaction to " +
            "add it to its AC against an attack.",
    ),
    ClassFeature(
        id = "VALOR_EXTRA_ATTACK",
        name = "Extra Attack",
        level = 6,
        summary = "Attack twice when you take the Attack action.",
    ),
    ClassFeature(
        id = "VALOR_BATTLE_MAGIC",
        name = "Battle Magic",
        level = 14,
        summary = "When you use your action to cast a bard spell, make one weapon attack as a bonus action.",
    ),
)
