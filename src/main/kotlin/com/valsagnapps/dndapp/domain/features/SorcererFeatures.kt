package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.ActionType
import com.valsagnapps.dndapp.domain.ClassFeature
import com.valsagnapps.dndapp.domain.Recharge
import com.valsagnapps.dndapp.domain.Resource
import com.valsagnapps.dndapp.domain.Uses

// Sorcerer y sus orígenes. Sorcerer y Draconic Bloodline son SRD: llevan el texto del SRD 5.1 además del
// resumen propio.
internal val SORCERER_FEATURES = listOf(
    ClassFeature(
        id = "SORCERER_SPELLCASTING",
        name = "Spellcasting",
        level = 1,
        summary =
        "Known-spells caster with Charisma: you learn sorcerer spells as you level up and can swap one for another " +
            "each level. Slots recover on a long rest, and an arcane focus works as spellcasting focus.",
        srdText =
        "An event in your past, or in the life of a parent or ancestor, left an indelible mark on you, infusing you " +
            "with arcane magic. This font of magic, whatever its origin, fuels your spells.\n\nCantrips. At 1st " +
            "level, you know four cantrips of your choice from the sorcerer spell list. You learn additional " +
            "sorcerer cantrips of your choice at higher levels, as shown in the Cantrips Known column of the " +
            "Sorcerer table.\n\nSpell Slots. The Sorcerer table shows how many spell slots you have to cast your " +
            "spells of 1st level and higher. To cast one of these sorcerer spells, you must expend a slot of the " +
            "spell's level or higher. You regain all expended spell slots when you finish a long rest.\n\nFor " +
            "example, if you know the 1st-level spell burning hands and have a 1st-level and a 2nd-level spell slot " +
            "available, you can cast burning hands using either slot.\n\nSpells Known of 1st Level and Higher. You " +
            "know two 1st-level spells of your choice from the sorcerer spell list.\n\nThe Spells Known column of " +
            "the Sorcerer table shows when you learn more sorcerer spells of your choice. Each of these spells must " +
            "be of a level for which you have spell slots. For instance, when you reach 3rd level in this class, you " +
            "can learn one new spell of 1st or 2nd level.\n\nAdditionally, when you gain a level in this class, you " +
            "can choose one of the sorcerer spells you know and replace it with another spell from the sorcerer " +
            "spell list, which also must be of a level for which you have spell slots.\n\nSpellcasting Ability. " +
            "Charisma is your spellcasting ability for your sorcerer spells, since the power of your magic relies on " +
            "your ability to project your will into the world. You use your Charisma whenever a spell refers to your " +
            "spellcasting ability. In addition, you use your Charisma modifier when setting the saving throw DC for " +
            "a sorcerer spell you cast and when making an attack roll with one.\n\nSpell save DC = 8 + your " +
            "proficiency bonus + your Charisma modifier.\n\nSpell attack modifier = your proficiency bonus + your " +
            "Charisma modifier.\n\nSpellcasting Focus. You can use an arcane focus as a spellcasting focus for your " +
            "sorcerer spells.",
    ),
    ClassFeature(
        id = "SORCERER_FONT_OF_MAGIC",
        name = "Font of Magic",
        level = 2,
        summary =
        "Sorcery points equal to your sorcerer level, recovered on a long rest. Bonus action: turn points into a " +
            "spell slot up to 5th level (2, 3, 5, 6 and 7 points for 1st to 5th; it vanishes on a long rest), or " +
            "expend a slot to gain points equal to its level.",
        srdText =
        "At 2nd level, you tap into a deep wellspring of magic within yourself. This wellspring is represented by " +
            "sorcery points, which allow you to create a variety of magical effects.\n\nSorcery Points. You have 2 " +
            "sorcery points, and you gain more as you reach higher levels, as shown in the Sorcery Points column of " +
            "the Sorcerer table. You can never have more sorcery points than shown on the table for your level. You " +
            "regain all spent sorcery points when you finish a long rest.\n\nCreating Spell Slots. You can transform " +
            "unexpended sorcery points into one spell slot as a bonus action on your turn. The Creating Spell Slots " +
            "table shows the cost of creating a spell slot of a given level. You can create spell slots no higher in " +
            "level than 5th.\n\nAny spell slot you create with this feature vanishes when you finish a long " +
            "rest.\n\nCreating Spell Slots (spell slot level: sorcery point cost): 1st: 2, 2nd: 3, 3rd: 5, 4th: 6, " +
            "5th: 7.\n\nConverting a Spell Slot to Sorcery Points. As a bonus action on your turn, you can expend " +
            "one spell slot and gain a number of sorcery points equal to the slot's level.",
        actionType = ActionType.BONUS_ACTION,
        resource = Resource.SORCERY_POINTS,
        uses = Uses.perClassLevel(multiplier = 1, recharge = Recharge.LONG_REST),
    ),
    ClassFeature(
        id = "SORCERER_METAMAGIC",
        name = "Metamagic",
        level = 3,
        summary =
        "Learn two Metamagic options (three at 10th level, four at 17th), only one per spell unless noted: Careful " +
            "(1 point), Distant (1), Empowered (1), Extended (1), Heightened (3), Quickened (2), Subtle (1) and " +
            "Twinned (spell level, 1 for cantrips).",
        srdText =
        "At 3rd level, you gain the ability to twist your spells to suit your needs. You gain two of the following " +
            "Metamagic options of your choice. You gain another one at 10th and 17th level.\n\nYou can use only one " +
            "Metamagic option on a spell when you cast it, unless otherwise noted.\n\nCareful Spell. When you cast a " +
            "spell that forces other creatures to make a saving throw, you can protect some of those creatures from " +
            "the spell's full force. To do so, you spend 1 sorcery point and choose a number of those creatures up " +
            "to your Charisma modifier (minimum of one creature). A chosen creature automatically succeeds on its " +
            "saving throw against the spell.\n\nDistant Spell. When you cast a spell that has a range of 5 feet or " +
            "greater, you can spend 1 sorcery point to double the range of the spell.\n\nWhen you cast a spell that " +
            "has a range of touch, you can spend 1 sorcery point to make the range of the spell 30 " +
            "feet.\n\nEmpowered Spell. When you roll damage for a spell, you can spend 1 sorcery point to reroll a " +
            "number of the damage dice up to your Charisma modifier (minimum of one). You must use the new " +
            "rolls.\n\nYou can use Empowered Spell even if you have already used a different Metamagic option during " +
            "the casting of the spell.\n\nExtended Spell. When you cast a spell that has a duration of 1 minute or " +
            "longer, you can spend 1 sorcery point to double its duration, to a maximum duration of 24 " +
            "hours.\n\nHeightened Spell. When you cast a spell that forces a creature to make a saving throw to " +
            "resist its effects, you can spend 3 sorcery points to give one target of the spell disadvantage on its " +
            "first saving throw made against the spell.\n\nQuickened Spell. When you cast a spell that has a casting " +
            "time of 1 action, you can spend 2 sorcery points to change the casting time to 1 bonus action for this " +
            "casting.\n\nSubtle Spell. When you cast a spell, you can spend 1 sorcery point to cast it without any " +
            "somatic or verbal components.\n\nTwinned Spell. When you cast a spell that targets only one creature " +
            "and doesn't have a range of self, you can spend a number of sorcery points equal to the spell's level " +
            "to target a second creature in range with the same spell (1 sorcery point if the spell is a " +
            "cantrip).\n\nTo be eligible, a spell must be incapable of targeting more than one creature at the " +
            "spell's current level. For example, magic missile and scorching ray aren't eligible, but ray of frost " +
            "is.",
        resource = Resource.SORCERY_POINTS,
    ),
    ClassFeature(
        id = "SORCERER_ABILITY_SCORE_IMPROVEMENT",
        name = "Ability Score Improvement",
        level = 4,
        summary = "At 4th, 8th, 12th, 16th and 19th level: +2 to one ability score or +1 to two (maximum 20).",
        srdText =
        "When you reach 4th level, and again at 8th, 12th, 16th, and 19th level, you can increase one ability score " +
            "of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you can't " +
            "increase an ability score above 20 using this feature.",
    ),
    ClassFeature(
        id = "SORCERER_SORCEROUS_RESTORATION",
        name = "Sorcerous Restoration",
        level = 20,
        summary = "Regain 4 expended sorcery points when you finish a short rest.",
        srdText = "At 20th level, you regain 4 expended sorcery points whenever you finish a short rest.",
    ),
)

internal val DRACONIC_BLOODLINE_FEATURES = listOf(
    ClassFeature(
        id = "DRACONIC_BLOODLINE_DRAGON_ANCESTOR",
        name = "Dragon Ancestor",
        level = 1,
        summary =
        "Choose a dragon type, which sets your damage type for later features. You speak, read and write Draconic, " +
            "and double your proficiency bonus on Charisma checks with dragons.",
        srdText =
        "At 1st level, you choose one type of dragon as your ancestor. The damage type associated with each dragon " +
            "is used by features you gain later.\n\nDraconic Ancestry (dragon and damage type): Black (acid), Blue " +
            "(lightning), Brass (fire), Bronze (lightning), Copper (acid), Gold (fire), Green (poison), Red (fire), " +
            "Silver (cold), White (cold).\n\nYou can speak, read, and write Draconic. Additionally, whenever you " +
            "make a Charisma check when interacting with dragons, your proficiency bonus is doubled if it applies to " +
            "the check.",
    ),
    ClassFeature(
        id = "DRACONIC_BLOODLINE_DRACONIC_RESILIENCE",
        name = "Draconic Resilience",
        level = 1,
        summary =
        "Your hit point maximum increases by 1 per sorcerer level, and your AC without armor is 13 + Dexterity " +
            "modifier.",
        srdText =
        "As magic flows through your body, it causes physical traits of your dragon ancestors to emerge. At 1st " +
            "level, your hit point maximum increases by 1 and increases by 1 again whenever you gain a level in this " +
            "class.\n\nAdditionally, parts of your skin are covered by a thin sheen of dragon-like scales. When you " +
            "aren't wearing armor, your AC equals 13 + your Dexterity modifier.",
    ),
    ClassFeature(
        id = "DRACONIC_BLOODLINE_ELEMENTAL_AFFINITY",
        name = "Elemental Affinity",
        level = 6,
        summary =
        "Add your Charisma modifier to one damage roll of spells of your ancestry's damage type, and spend 1 sorcery " +
            "point to gain resistance to that type for 1 hour.",
        srdText =
        "Starting at 6th level, when you cast a spell that deals damage of the type associated with your draconic " +
            "ancestry, you can add your Charisma modifier to one damage roll of that spell. At the same time, you " +
            "can spend 1 sorcery point to gain resistance to that damage type for 1 hour.",
        resource = Resource.SORCERY_POINTS,
    ),
    ClassFeature(
        id = "DRACONIC_BLOODLINE_DRAGON_WINGS",
        name = "Dragon Wings",
        level = 14,
        summary =
        "Bonus action: sprout dragon wings and gain a flying speed equal to your speed until you dismiss them. Not " +
            "while wearing armor that isn't made for them.",
        srdText =
        "At 14th level, you gain the ability to sprout a pair of dragon wings from your back, gaining a flying speed " +
            "equal to your current speed. You can create these wings as a bonus action on your turn. They last until " +
            "you dismiss them as a bonus action on your turn.\n\nYou can't manifest your wings while wearing armor " +
            "unless the armor is made to accommodate them, and clothing not made to accommodate your wings might be " +
            "destroyed when you manifest them.",
        actionType = ActionType.BONUS_ACTION,
    ),
    ClassFeature(
        id = "DRACONIC_BLOODLINE_DRACONIC_PRESENCE",
        name = "Draconic Presence",
        level = 18,
        summary =
        "Action, 5 sorcery points: a 60 ft aura of awe or fear for 1 minute (concentration). Hostile creatures that " +
            "start their turn in it make a Wisdom save or are charmed or frightened until it ends; on a success they " +
            "are immune for 24 hours.",
        srdText =
        "Beginning at 18th level, you can channel the dread presence of your dragon ancestor, causing those around " +
            "you to become awestruck or frightened. As an action, you can spend 5 sorcery points to draw on this " +
            "power and exude an aura of awe or fear (your choice) to a distance of 60 feet. For 1 minute or until " +
            "you lose your concentration (as if you were casting a concentration spell), each hostile creature that " +
            "starts its turn in this aura must succeed on a Wisdom saving throw or be charmed (if you chose awe) or " +
            "frightened (if you chose fear) until the aura ends. A creature that succeeds on this saving throw is " +
            "immune to your aura for 24 hours.",
        actionType = ActionType.ACTION,
        resource = Resource.SORCERY_POINTS,
    ),
)

// Wild Magic no es SRD: solo resúmenes propios.
internal val WILD_MAGIC_FEATURES = listOf(
    ClassFeature(
        id = "WILD_MAGIC_WILD_MAGIC_SURGE",
        name = "Wild Magic Surge",
        level = 1,
        summary =
        "After you cast a sorcerer spell of 1st level or higher, the GM can have you roll a d20: on a 1, roll on the " +
            "Wild Magic Surge table for a random magical effect.",
    ),
    ClassFeature(
        id = "WILD_MAGIC_TIDES_OF_CHAOS",
        name = "Tides of Chaos",
        level = 1,
        summary =
        "Gain advantage on one attack roll, ability check or saving throw. Once per long rest, or until the GM has " +
            "you roll on the Wild Magic Surge table after casting a sorcerer spell of 1st level or higher.",
        resource = Resource.TIDES_OF_CHAOS,
        uses = Uses.fixed(count = 1, recharge = Recharge.LONG_REST),
    ),
    ClassFeature(
        id = "WILD_MAGIC_BEND_LUCK",
        name = "Bend Luck",
        level = 6,
        summary =
        "Reaction, 2 sorcery points: when a creature you can see makes an attack roll, ability check or saving " +
            "throw, roll 1d4 and add it to or subtract it from the roll.",
        actionType = ActionType.REACTION,
        resource = Resource.SORCERY_POINTS,
    ),
    ClassFeature(
        id = "WILD_MAGIC_CONTROLLED_CHAOS",
        name = "Controlled Chaos",
        level = 14,
        summary = "When you roll on the Wild Magic Surge table, roll twice and pick either result.",
    ),
    ClassFeature(
        id = "WILD_MAGIC_SPELL_BOMBARDMENT",
        name = "Spell Bombardment",
        level = 18,
        summary =
        "Once per turn, when you roll damage for a spell and a die shows its highest number, roll that die again and " +
            "add it to the damage.",
    ),
)
