package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.ClassFeature

// Warlock y sus patrones. Warlock y The Fiend son SRD: llevan el texto del SRD 5.1 además del resumen propio.
internal val WARLOCK_FEATURES = listOf(
    ClassFeature(
        id = "WARLOCK_PACT_MAGIC",
        name = "Pact Magic",
        level = 1,
        summary =
        "Known-spells caster with Charisma: few spell slots, all of the same level (up to 5th), recovered on a short " +
            "or long rest. You learn warlock spells as you level up and can swap one each level. An arcane focus " +
            "works as spellcasting focus.",
        srdText =
        "Your arcane research and the magic bestowed on you by your patron have given you facility with " +
            "spells.\n\nCantrips. You know two cantrips of your choice from the warlock spell list. You learn " +
            "additional warlock cantrips of your choice at higher levels, as shown in the Cantrips Known column of " +
            "the Warlock table.\n\nSpell Slots. The Warlock table shows how many spell slots you have. The table " +
            "also shows what the level of those slots is; all of your spell slots are the same level. To cast one of " +
            "your warlock spells of 1st level or higher, you must expend a spell slot. You regain all expended spell " +
            "slots when you finish a short or long rest.\n\nFor example, when you are 5th level, you have two " +
            "3rd-level spell slots. To cast the 1st-level spell thunderwave, you must spend one of those slots, and " +
            "you cast it as a 3rd-level spell.\n\nSpells Known of 1st Level and Higher. At 1st level, you know two " +
            "1st-level spells of your choice from the warlock spell list.\n\nThe Spells Known column of the Warlock " +
            "table shows when you learn more warlock spells of your choice of 1st level and higher. \n\nA spell you " +
            "choose must be of a level no higher than what's shown in the table's Slot Level column for your level. " +
            "When you reach 6th level, for example, you learn a new warlock spell, which can be 1st, 2nd, or 3rd " +
            "level.\n\nAdditionally, when you gain a level in this class, you can choose one of the warlock spells " +
            "you know and replace it with another spell from the warlock spell list, which also must be of a level " +
            "for which you have spell slots.\n\nSpellcasting Ability. Charisma is your spellcasting ability for your " +
            "warlock spells, so you use your Charisma whenever a spell refers to your spellcasting ability. In " +
            "addition, you use your Charisma modifier when setting the saving throw DC for a warlock spell you cast " +
            "and when making an attack roll with one.\n\nSpell save DC = 8 + your proficiency bonus + your Charisma " +
            "modifier.\n\nSpell attack modifier = your proficiency bonus + your Charisma modifier.\n\nSpellcasting " +
            "Focus. You can use an arcane focus as a spellcasting focus for your warlock spells.",
    ),
    ClassFeature(
        id = "WARLOCK_ELDRITCH_INVOCATIONS",
        name = "Eldritch Invocations",
        level = 2,
        summary =
        "Learn two invocations (three at 5th level, four at 7th, five at 9th, six at 12th, seven at 15th and eight " +
            "at 18th); each level you can swap one. Invocations: Agonizing Blast (eldritch blast adds your Charisma " +
            "modifier to damage); Armor of Shadows (mage armor on yourself at will); Ascendant Step (9th: levitate " +
            "on yourself at will); Beast Speech (speak with animals at will); Beguiling Influence (proficiency in " +
            "Deception and Persuasion); Bewitching Whispers (7th: compulsion once per long rest with a slot); Book " +
            "of Ancient Secrets (Tome: two 1st-level ritual spells in your book, and you can add more); Chains of " +
            "Carceri (15th, Chain: hold monster at will on celestials, fiends and elementals); Devil's Sight (see " +
            "normally in darkness, even magical, to 120 ft); Dreadful Word (7th: confusion once per long rest with a " +
            "slot); Eldritch Sight (detect magic at will); Eldritch Spear (eldritch blast reaches 300 ft); Eyes of " +
            "the Rune Keeper (read all writing); Fiendish Vigor (false life on yourself at will); Gaze of Two Minds " +
            "(action: perceive through the senses of a willing humanoid you touch); Lifedrinker (12th, Blade: your " +
            "pact weapon deals extra necrotic damage equal to your Charisma modifier); Mask of Many Faces (disguise " +
            "self at will); Master of Myriad Forms (15th: alter self at will); Minions of Chaos (9th: conjure " +
            "elemental once per long rest with a slot); Mire the Mind (5th: slow once per long rest with a slot); " +
            "Misty Visions (silent image at will); One with Shadows (5th: action in dim light or darkness to become " +
            "invisible until you move or act); Otherworldly Leap (9th: jump on yourself at will); Repelling Blast " +
            "(eldritch blast pushes 10 ft); Sculptor of Flesh (7th: polymorph once per long rest with a slot); Sign " +
            "of Ill Omen (5th: bestow curse once per long rest with a slot); Thief of Five Fates (bane once per long " +
            "rest with a slot); Thirsting Blade (5th, Blade: attack twice with your pact weapon); Visions of Distant " +
            "Realms (15th: arcane eye at will); Voice of the Chain Master (Chain: telepathy with your familiar, " +
            "perceive and speak through it); Whispers of the Grave (9th: speak with dead at will); Witch Sight " +
            "(15th: see the true form of shapechangers and creatures hidden by illusion or transmutation within 30 " +
            "ft).",
        srdText =
        "In your study of occult lore, you have unearthed eldritch invocations, fragments of forbidden knowledge " +
            "that imbue you with an abiding magical ability.\n\nAt 2nd level, you gain two eldritch invocations of " +
            "your choice. Your invocation options are detailed at the end of the class description. When you gain " +
            "certain warlock levels, you gain additional invocations of your choice, as shown in the Invocations " +
            "Known column of the Warlock table.\n\nAdditionally, when you gain a level in this class, you can choose " +
            "one of the invocations you know and replace it with another invocation that you could learn at that " +
            "level.\n\nAgonizing Blast (Prerequisite: eldritch blast cantrip). When you cast eldritch blast, add " +
            "your Charisma modifier to the damage it deals on a hit.\n\nArmor of Shadows. You can cast mage armor on " +
            "yourself at will, without expending a spell slot or material components.\n\nAscendant Step " +
            "(Prerequisite: 9th level). You can cast levitate on yourself at will, without expending a spell slot or " +
            "material components.\n\nBeast Speech. You can cast speak with animals at will, without expending a " +
            "spell slot.\n\nBeguiling Influence. You gain proficiency in the Deception and Persuasion " +
            "skills.\n\nBewitching Whispers (Prerequisite: 7th level). You can cast compulsion once using a warlock " +
            "spell slot. You can't do so again until you finish a long rest.\n\nBook of Ancient Secrets " +
            "(Prerequisite: Pact of the Tome feature). You can now inscribe magical rituals in your Book of Shadows. " +
            "Choose two 1st-level spells that have the ritual tag from any class's spell list (the two needn't be " +
            "from the same list). The spells appear in the book and don't count against the number of spells you " +
            "know. With your Book of Shadows in hand, you can cast the chosen spells as rituals. You can't cast the " +
            "spells except as rituals, unless you've learned them by some other means. You can also cast a warlock " +
            "spell you know as a ritual if it has the ritual tag.\n\nOn your adventures, you can add other ritual " +
            "spells to your Book of Shadows. When you find such a spell, you can add it to the book if the spell's " +
            "level is equal to or less than half your warlock level (rounded up) and if you can spare the time to " +
            "transcribe the spell. For each level of the spell, the transcription process takes 2 hours and costs 50 " +
            "gp for the rare inks needed to inscribe it.\n\nChains of Carceri (Prerequisite: 15th level, Pact of the " +
            "Chain feature). You can cast hold monster at will--targeting a celestial, fiend, or elemental--without " +
            "expending a spell slot or material components. You must finish a long rest before you can use this " +
            "invocation on the same creature again.\n\nDevil's Sight. You can see normally in darkness, both magical " +
            "and nonmagical, to a distance of 120 feet.\n\nDreadful Word (Prerequisite: 7th level). You can cast " +
            "confusion once using a warlock spell slot. You can't do so again until you finish a long " +
            "rest.\n\nEldritch Sight. You can cast detect magic at will, without expending a spell slot.\n\nEldritch " +
            "Spear (Prerequisite: eldritch blast cantrip). When you cast eldritch blast, its range is 300 " +
            "feet.\n\nEyes of the Rune Keeper. You can read all writing.\n\nFiendish Vigor. You can cast false life " +
            "on yourself at will as a 1st-level spell, without expending a spell slot or material " +
            "components.\n\nGaze of Two Minds. You can use your action to touch a willing humanoid and perceive " +
            "through its senses until the end of your next turn. As long as the creature is on the same plane of " +
            "existence as you, you can use your action on subsequent turns to maintain this connection, extending " +
            "the duration until the end of your next turn. While perceiving through the other creature's senses, you " +
            "benefit from any special senses possessed by that creature, and you are blinded and deafened to your " +
            "own surroundings.\n\nLifedrinker (Prerequisite: 12th level, Pact of the Blade feature). When you hit a " +
            "creature with your pact weapon, the creature takes extra necrotic damage equal to your Charisma " +
            "modifier (minimum 1).\n\nMask of Many Faces. You can cast disguise self at will, without expending a " +
            "spell slot.\n\nMaster of Myriad Forms (Prerequisite: 15th level). You can cast alter self at will, " +
            "without expending a spell slot.\n\nMinions of Chaos (Prerequisite: 9th level). You can cast conjure " +
            "elemental once using a warlock spell slot. You can't do so again until you finish a long rest.\n\nMire " +
            "the Mind (Prerequisite: 5th level). You can cast slow once using a warlock spell slot. You can't do so " +
            "again until you finish a long rest.\n\nMisty Visions. You can cast silent image at will, without " +
            "expending a spell slot or material components.\n\nOne with Shadows (Prerequisite: 5th level). When you " +
            "are in an area of dim light or darkness, you can use your action to become invisible until you move or " +
            "take an action or a reaction.\n\nOtherworldly Leap (Prerequisite: 9th level). You can cast jump on " +
            "yourself at will, without expending a spell slot or material components.\n\nRepelling Blast " +
            "(Prerequisite: eldritch blast cantrip). When you hit a creature with eldritch blast, you can push the " +
            "creature up to 10 feet away from you in a straight line.\n\nSculptor of Flesh (Prerequisite: 7th " +
            "level). You can cast polymorph once using a warlock spell slot. You can't do so again until you finish " +
            "a long rest.\n\nSign of Ill Omen (Prerequisite: 5th level). You can cast bestow curse once using a " +
            "warlock spell slot. You can't do so again until you finish a long rest.\n\nThief of Five Fates. You can " +
            "cast bane once using a warlock spell slot. You can't do so again until you finish a long " +
            "rest.\n\nThirsting Blade (Prerequisite: 5th level, Pact of the Blade feature). You can attack with your " +
            "pact weapon twice, instead of once, whenever you take the Attack action on your turn.\n\nVisions of " +
            "Distant Realms (Prerequisite: 15th level). You can cast arcane eye at will, without expending a spell " +
            "slot.\n\nVoice of the Chain Master (Prerequisite: Pact of the Chain feature). You can communicate " +
            "telepathically with your familiar and perceive through your familiar's senses as long as you are on the " +
            "same plane of existence.\n\nAdditionally, while perceiving through your familiar's senses, you can also " +
            "speak through your familiar in your own voice, even if your familiar is normally incapable of " +
            "speech.\n\nWhispers of the Grave (Prerequisite: 9th level). You can cast speak with dead at will, " +
            "without expending a spell slot.\n\nWitch Sight (Prerequisite: 15th level). You can see the true form of " +
            "any shapechanger or creature concealed by illusion or transmutation magic while the creature is within " +
            "30 feet of you and within line of sight.",
    ),
    ClassFeature(
        id = "WARLOCK_PACT_BOON",
        name = "Pact Boon",
        level = 3,
        summary =
        "Choose one gift from your patron. Pact of the Blade: action to create a melee pact weapon you are " +
            "proficient with and that counts as magical; you can bind a magic weapon to it with a 1-hour ritual. " +
            "Pact of the Chain: you learn find familiar as a ritual, with special forms (imp, pseudodragon, quasit " +
            "or sprite), and you can forgo one of your attacks so the familiar attacks with its reaction. Pact of " +
            "the Tome: a Book of Shadows with three cantrips from any class list that you can cast at will while you " +
            "carry it.",
        srdText =
        "At 3rd level, your otherworldly patron bestows a gift upon you for your loyal service. You gain one of the " +
            "following features of your choice.\n\nPact of the Blade. You can use your action to create a pact " +
            "weapon in your empty hand. You can choose the form that this melee weapon takes each time you create " +
            "it. You are proficient with it while you wield it. This weapon counts as magical for the purpose of " +
            "overcoming resistance and immunity to nonmagical attacks and damage.\n\nYour pact weapon disappears if " +
            "it is more than 5 feet away from you for 1 minute or more. It also disappears if you use this feature " +
            "again, if you dismiss the weapon (no action required), or if you die.\n\nYou can transform one magic " +
            "weapon into your pact weapon by performing a special ritual while you hold the weapon. You perform the " +
            "ritual over the course of 1 hour, which can be done during a short rest. You can then dismiss the " +
            "weapon, shunting it into an extradimensional space, and it appears whenever you create your pact weapon " +
            "thereafter. You can't affect an artifact or a sentient weapon in this way. The weapon ceases being your " +
            "pact weapon if you die, if you perform the 1-hour ritual on a different weapon, or if you use a 1-hour " +
            "ritual to break your bond to it. The weapon appears at your feet if it is in the extradimensional space " +
            "when the bond breaks.\n\nIf you serve the Fiend, your weapon could be an axe made of black metal and " +
            "adorned with decorative flames.\n\nPact of the Chain. You learn the find familiar spell and can cast it " +
            "as a ritual. The spell doesn't count against your number of spells known.\n\nWhen you cast the spell, " +
            "you can choose one of the normal forms for your familiar or one of the following special forms: imp, " +
            "pseudodragon, quasit, or sprite.\n\nAdditionally, when you take the Attack action, you can forgo one of " +
            "your own attacks to allow your familiar to make one attack of its own with its reaction.\n\nYour " +
            "familiar is more cunning than a typical familiar. Its default form can be a reflection of your patron, " +
            "with imps and quasits tied to the Fiend.\n\nPact of the Tome. Your patron gives you a grimoire called a " +
            "Book of Shadows. When you gain this feature, choose three cantrips from any class's spell list (the " +
            "three needn't be from the same list). While the book is on your person, you can cast those cantrips at " +
            "will. They don't count against your number of cantrips known. If they don't appear on the warlock spell " +
            "list, they are nonetheless warlock spells for you.\n\nIf you lose your Book of Shadows, you can perform " +
            "a 1-hour ceremony to receive a replacement from your patron. This ceremony can be performed during a " +
            "short or long rest, and it destroys the previous book. The book turns to ash when you die.\n\nYour Book " +
            "of Shadows could be a weighty tome bound in demon hide studded with iron, holding spells of conjuration " +
            "and a wealth of forbidden lore about the sinister regions of the cosmos, a gift of the Fiend.",
    ),
    ClassFeature(
        id = "WARLOCK_ABILITY_SCORE_IMPROVEMENT",
        name = "Ability Score Improvement",
        level = 4,
        summary = "At 4th, 8th, 12th, 16th and 19th level: +2 to one ability score or +1 to two (maximum 20).",
        srdText =
        "When you reach 4th level, and again at 8th, 12th, 16th, and 19th level, you can increase one ability score " +
            "of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you can't " +
            "increase an ability score above 20 using this feature.",
    ),
    ClassFeature(
        id = "WARLOCK_MYSTIC_ARCANUM",
        name = "Mystic Arcanum",
        level = 11,
        summary =
        "Choose one 6th-level warlock spell you can cast once per long rest without a slot. One more of 7th level at " +
            "13th, 8th level at 15th and 9th level at 17th.",
        srdText =
        "At 11th level, your patron bestows upon you a magical secret called an arcanum. Choose one 6th-level spell " +
            "from the warlock spell list as this arcanum.\n\nYou can cast your arcanum spell once without expending " +
            "a spell slot. You must finish a long rest before you can do so again.\n\nAt higher levels, you gain " +
            "more warlock spells of your choice that can be cast in this way: one 7th-level spell at 13th level, one " +
            "8th-level spell at 15th level, and one 9th-level spell at 17th level. You regain all uses of your " +
            "Mystic Arcanum when you finish a long rest.",
    ),
    ClassFeature(
        id = "WARLOCK_ELDRITCH_MASTER",
        name = "Eldritch Master",
        level = 20,
        summary =
        "Spend 1 minute entreating your patron to recover all your Pact Magic spell slots. Once per long rest.",
        srdText =
        "At 20th level, you can draw on your inner reserve of mystical power while entreating your patron to regain " +
            "expended spell slots. You can spend 1 minute entreating your patron for aid to regain all your expended " +
            "spell slots from your Pact Magic feature.\n\nOnce you regain spell slots with this feature, you must " +
            "finish a long rest before you can do so again.",
    ),
)

internal val FIEND_FEATURES = listOf(
    ClassFeature(
        id = "FIEND_DARK_ONES_BLESSING",
        name = "Dark One's Blessing",
        level = 1,
        summary =
        "When you reduce a hostile creature to 0 hit points, gain Charisma modifier + warlock level temporary hit " +
            "points (minimum 1).",
        srdText =
        "Starting at 1st level, when you reduce a hostile creature to 0 hit points, you gain temporary hit points " +
            "equal to your Charisma modifier + your warlock level (minimum of 1).",
    ),
    ClassFeature(
        id = "FIEND_DARK_ONES_OWN_LUCK",
        name = "Dark One's Own Luck",
        level = 6,
        summary =
        "Add a d10 to an ability check or saving throw, after seeing the roll but before its effects. Once per short " +
            "or long rest.",
        srdText =
        "Starting at 6th level, you can call on your patron to alter fate in your favor. When you make an ability " +
            "check or a saving throw, you can use this feature to add a d10 to your roll. You can do so after seeing " +
            "the initial roll but before any of the roll's effects occur.\n\nOnce you use this feature, you can't " +
            "use it again until you finish a short or long rest.",
    ),
    ClassFeature(
        id = "FIEND_FIENDISH_RESILIENCE",
        name = "Fiendish Resilience",
        level = 10,
        summary =
        "After a short or long rest, choose a damage type to resist until you choose another one. Magical or silver " +
            "weapons ignore this resistance.",
        srdText =
        "Starting at 10th level, you can choose one damage type when you finish a short or long rest. You gain " +
            "resistance to that damage type until you choose a different one with this feature. Damage from magical " +
            "weapons or silver weapons ignores this resistance.",
    ),
    ClassFeature(
        id = "FIEND_HURL_THROUGH_HELL",
        name = "Hurl Through Hell",
        level = 14,
        summary =
        "When you hit a creature with an attack, send it through the lower planes until the end of your next turn; " +
            "when it returns it takes 10d10 psychic damage unless it is a fiend. Once per long rest.",
        srdText =
        "Starting at 14th level, when you hit a creature with an attack, you can use this feature to instantly " +
            "transport the target through the lower planes. The creature disappears and hurtles through a nightmare " +
            "landscape.\n\nAt the end of your next turn, the target returns to the space it previously occupied, or " +
            "the nearest unoccupied space. If the target is not a fiend, it takes 10d10 psychic damage as it reels " +
            "from its horrific experience.\n\nOnce you use this feature, you can't use it again until you finish a " +
            "long rest.",
    ),
)

// The Archfey y The Great Old One no son SRD: solo resúmenes propios.
internal val ARCHFEY_FEATURES = listOf(
    ClassFeature(
        id = "ARCHFEY_FEY_PRESENCE",
        name = "Fey Presence",
        level = 1,
        summary =
        "Action: each creature in a 10-ft cube from you makes a Wisdom save against your spell save DC; on a failure " +
            "it is charmed or frightened by you (your choice) until the end of your next turn. Once per short or " +
            "long rest.",
    ),
    ClassFeature(
        id = "ARCHFEY_MISTY_ESCAPE",
        name = "Misty Escape",
        level = 6,
        summary =
        "Reaction when you take damage: turn invisible and teleport up to 60 ft to a space you can see. You stay " +
            "invisible until the start of your next turn or until you attack or cast a spell. Once per short or long " +
            "rest.",
    ),
    ClassFeature(
        id = "ARCHFEY_BEGUILING_DEFENSES",
        name = "Beguiling Defenses",
        level = 10,
        summary =
        "Immunity to being charmed. When a creature tries to charm you, reaction: it makes a Wisdom save or is " +
            "charmed by you for 1 minute or until it takes damage.",
    ),
    ClassFeature(
        id = "ARCHFEY_DARK_DELIRIUM",
        name = "Dark Delirium",
        level = 14,
        summary =
        "Action: a creature within 60 ft makes a Wisdom save; on a failure it is charmed or frightened by you (your " +
            "choice) for 1 minute or until your concentration breaks, lost in an illusory realm where it can only " +
            "see and hear you. It ends early if the creature takes damage. Once per short or long rest.",
    ),
)

internal val GREAT_OLD_ONE_FEATURES = listOf(
    ClassFeature(
        id = "GREAT_OLD_ONE_AWAKENED_MIND",
        name = "Awakened Mind",
        level = 1,
        summary =
        "Speak telepathically with any creature you can see within 30 ft, as long as it knows a language (it doesn't " +
            "need to share one with you).",
    ),
    ClassFeature(
        id = "GREAT_OLD_ONE_ENTROPIC_WARD",
        name = "Entropic Ward",
        level = 6,
        summary =
        "Reaction when a creature attacks you: impose disadvantage on the roll. If it misses, you have advantage on " +
            "your next attack against it before the end of your next turn. Once per short or long rest.",
    ),
    ClassFeature(
        id = "GREAT_OLD_ONE_THOUGHT_SHIELD",
        name = "Thought Shield",
        level = 10,
        summary =
        "Telepathy can't read your thoughts unless you allow it, you resist psychic damage, and a creature that " +
            "deals you psychic damage takes the same amount.",
    ),
    ClassFeature(
        id = "GREAT_OLD_ONE_CREATE_THRALL",
        name = "Create Thrall",
        level = 14,
        summary =
        "Action: touch an incapacitated humanoid to charm it until a remove curse is cast on it, the charm is " +
            "removed or you use this feature again. While on the same plane, you can communicate telepathically with " +
            "it.",
    ),
)
