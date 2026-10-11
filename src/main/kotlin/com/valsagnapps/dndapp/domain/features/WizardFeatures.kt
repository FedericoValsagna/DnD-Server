package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.ClassFeature

// Wizard y sus escuelas. Wizard y School of Evocation son SRD: llevan el texto del SRD 5.1 además del resumen propio.
internal val WIZARD_FEATURES = listOf(
    ClassFeature(
        id = "WIZARD_SPELLCASTING",
        name = "Spellcasting",
        level = 1,
        summary =
        "Prepared caster with Intelligence and a spellbook: after a long rest, prepare Intelligence modifier + " +
            "wizard level spells from your spellbook. Slots recover on a long rest. Spellbook ritual spells can be " +
            "cast as rituals without preparing them, and an arcane focus works as spellcasting focus.",
        srdText =
        "As a student of arcane magic, you have a spellbook containing spells that show the first glimmerings of " +
            "your true power.\n\nCantrips. At 1st level, you know three cantrips of your choice from the wizard " +
            "spell list. You learn additional wizard cantrips of your choice at higher levels, as shown in the " +
            "Cantrips Known column of the Wizard table.\n\nSpellbook. At 1st level, you have a spellbook containing " +
            "six 1st-level wizard spells of your choice. Your spellbook is the repository of the wizard spells you " +
            "know, except your cantrips, which are fixed in your mind.\n\nPreparing and Casting Spells. The Wizard " +
            "table shows how many spell slots you have to cast your spells of 1st level and higher. To cast one of " +
            "these spells, you must expend a slot of the spell's level or higher. You regain all expended spell " +
            "slots when you finish a long rest.\n\nYou prepare the list of wizard spells that are available for you " +
            "to cast. To do so, choose a number of wizard spells from your spellbook equal to your Intelligence " +
            "modifier + your wizard level (minimum of one spell). The spells must be of a level for which you have " +
            "spell slots.\n\nFor example, if you're a 3rd-level wizard, you have four 1st-level and two 2nd-level " +
            "spell slots. With an Intelligence of 16, your list of prepared spells can include six spells of 1st or " +
            "2nd level, in any combination, chosen from your spellbook. If you prepare the 1st-level spell magic " +
            "missile, you can cast it using a 1st-level or a 2nd-level slot. Casting the spell doesn't remove it " +
            "from your list of prepared spells.\n\nYou can change your list of prepared spells when you finish a " +
            "long rest. Preparing a new list of wizard spells requires time spent studying your spellbook and " +
            "memorizing the incantations and gestures you must make to cast the spell: at least 1 minute per spell " +
            "level for each spell on your list.\n\nSpellcasting Ability. Intelligence is your spellcasting ability " +
            "for your wizard spells, since you learn your spells through dedicated study and memorization. You use " +
            "your Intelligence whenever a spell refers to your spellcasting ability. In addition, you use your " +
            "Intelligence modifier when setting the saving throw DC for a wizard spell you cast and when making an " +
            "attack roll with one.\n\nSpell save DC = 8 + your proficiency bonus + your Intelligence " +
            "modifier.\n\nSpell attack modifier = your proficiency bonus + your Intelligence modifier.\n\nRitual " +
            "Casting. You can cast a wizard spell as a ritual if that spell has the ritual tag and you have the " +
            "spell in your spellbook. You don't need to have the spell prepared.\n\nSpellcasting Focus. You can use " +
            "an arcane focus as a spellcasting focus for your wizard spells.",
    ),
    ClassFeature(
        id = "WIZARD_ARCANE_RECOVERY",
        name = "Arcane Recovery",
        level = 1,
        summary =
        "Once per day, after a short rest, recover expended spell slots with a combined level up to half your wizard " +
            "level (rounded up), none of 6th level or higher.",
        srdText =
        "You have learned to regain some of your magical energy by studying your spellbook. Once per day when you " +
            "finish a short rest, you can choose expended spell slots to recover. The spell slots can have a " +
            "combined level that is equal to or less than half your wizard level (rounded up), and none of the slots " +
            "can be 6th level or higher.\n\nFor example, if you're a 4th-level wizard, you can recover up to two " +
            "levels worth of spell slots. You can recover either a 2nd-level spell slot or two 1st-level spell slots.",
    ),
    ClassFeature(
        id = "WIZARD_ABILITY_SCORE_IMPROVEMENT",
        name = "Ability Score Improvement",
        level = 4,
        summary = "At 4th, 8th, 12th, 16th and 19th level: +2 to one ability score or +1 to two (maximum 20).",
        srdText =
        "When you reach 4th level, and again at 8th, 12th, 16th, and 19th level, you can increase one ability score " +
            "of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you can't " +
            "increase an ability score above 20 using this feature.",
    ),
    ClassFeature(
        id = "WIZARD_SPELL_MASTERY",
        name = "Spell Mastery",
        level = 18,
        summary =
        "Choose a 1st-level and a 2nd-level wizard spell from your spellbook: you can cast them at their lowest " +
            "level without a slot while prepared. 8 hours of study to swap them.",
        srdText =
        "At 18th level, you have achieved such mastery over certain spells that you can cast them at will. Choose a " +
            "1st-level wizard spell and a 2nd-level wizard spell that are in your spellbook. You can cast those " +
            "spells at their lowest level without expending a spell slot when you have them prepared. If you want to " +
            "cast either spell at a higher level, you must expend a spell slot as normal.\n\nBy spending 8 hours in " +
            "study, you can exchange one or both of the spells you chose for different spells of the same levels.",
    ),
    ClassFeature(
        id = "WIZARD_SIGNATURE_SPELL",
        name = "Signature Spell",
        level = 20,
        summary =
        "Choose two 3rd-level wizard spells from your spellbook: they are always prepared without counting against " +
            "the limit, and you can cast each once at 3rd level without a slot per short or long rest.",
        srdText =
        "When you reach 20th level, you gain mastery over two powerful spells and can cast them with little effort. " +
            "Choose two 3rd-level wizard spells in your spellbook as your signature spells. You always have these " +
            "spells prepared, they don't count against the number of spells you have prepared, and you can cast each " +
            "of them once at 3rd level without expending a spell slot. When you do so, you can't do so again until " +
            "you finish a short or long rest.\n\nIf you want to cast either spell at a higher level, you must expend " +
            "a spell slot as normal.",
    ),
)

internal val EVOCATION_FEATURES = listOf(
    ClassFeature(
        id = "EVOCATION_EVOCATION_SAVANT",
        name = "Evocation Savant",
        level = 2,
        summary = "Copying evocation spells into your spellbook takes half the gold and time.",
        srdText =
        "Beginning when you select this school at 2nd level, the gold and time you must spend to copy an evocation " +
            "spell into your spellbook is halved.",
    ),
    ClassFeature(
        id = "EVOCATION_SCULPT_SPELLS",
        name = "Sculpt Spells",
        level = 2,
        summary =
        "When you cast an evocation spell, choose up to 1 + the spell's level creatures you can see: they " +
            "automatically succeed on their saves and take no damage instead of half.",
        srdText =
        "Beginning at 2nd level, you can create pockets of relative safety within the effects of your evocation " +
            "spells. When you cast an evocation spell that affects other creatures that you can see, you can choose " +
            "a number of them equal to 1 + the spell's level. The chosen creatures automatically succeed on their " +
            "saving throws against the spell, and they take no damage if they would normally take half damage on a " +
            "successful save.",
    ),
    ClassFeature(
        id = "EVOCATION_POTENT_CANTRIP",
        name = "Potent Cantrip",
        level = 6,
        summary =
        "A creature that succeeds on a save against your cantrip still takes half its damage, but no other effect.",
        srdText =
        "Starting at 6th level, your damaging cantrips affect even creatures that avoid the brunt of the effect. " +
            "When a creature succeeds on a saving throw against your cantrip, the creature takes half the cantrip's " +
            "damage (if any) but suffers no additional effect from the cantrip.",
    ),
    ClassFeature(
        id = "EVOCATION_EMPOWERED_EVOCATION",
        name = "Empowered Evocation",
        level = 10,
        summary = "Add your Intelligence modifier to one damage roll of your wizard evocation spells.",
        srdText =
        "Beginning at 10th level, you can add your Intelligence modifier to one damage roll of any wizard evocation " +
            "spell you cast.",
    ),
    ClassFeature(
        id = "EVOCATION_OVERCHANNEL",
        name = "Overchannel",
        level = 14,
        summary =
        "Deal maximum damage with a damaging wizard spell of 1st to 5th level. The first use per long rest is free; " +
            "each extra one deals you 2d12 necrotic damage per spell level, +1d12 per level each further time, " +
            "ignoring resistance and immunity.",
        srdText =
        "Starting at 14th level, you can increase the power of your simpler spells. When you cast a wizard spell of " +
            "1st through 5th level that deals damage, you can deal maximum damage with that spell.\n\nThe first time " +
            "you do so, you suffer no adverse effect. If you use this feature again before you finish a long rest, " +
            "you take 2d12 necrotic damage for each level of the spell, immediately after you cast it. Each time you " +
            "use this feature again before finishing a long rest, the necrotic damage per spell level increases by " +
            "1d12. This damage ignores resistance and immunity.",
    ),
)

// School of Abjuration no es SRD: solo resúmenes propios.
internal val ABJURATION_FEATURES = listOf(
    ClassFeature(
        id = "ABJURATION_ABJURATION_SAVANT",
        name = "Abjuration Savant",
        level = 2,
        summary = "Copying abjuration spells into your spellbook takes half the gold and time.",
    ),
    ClassFeature(
        id = "ABJURATION_ARCANE_WARD",
        name = "Arcane Ward",
        level = 2,
        summary =
        "When you cast an abjuration spell of 1st level or higher, create a ward (once per long rest) with twice " +
            "your wizard level + Intelligence modifier hit points that absorbs damage you take. Casting more " +
            "abjuration spells restores it by twice the spell level.",
    ),
    ClassFeature(
        id = "ABJURATION_PROJECTED_WARD",
        name = "Projected Ward",
        level = 6,
        summary =
        "Reaction: when a creature you can see within 30 ft takes damage, your Arcane Ward absorbs it instead.",
    ),
    ClassFeature(
        id = "ABJURATION_IMPROVED_ABJURATION",
        name = "Improved Abjuration",
        level = 10,
        summary =
        "Add your proficiency bonus to the ability checks of your abjuration spells (like counterspell and dispel " +
            "magic).",
    ),
    ClassFeature(
        id = "ABJURATION_SPELL_RESISTANCE",
        name = "Spell Resistance",
        level = 14,
        summary = "Advantage on saving throws against spells, and resistance to the damage of spells.",
    ),
)

// School of Conjuration no es SRD: solo resúmenes propios.
internal val CONJURATION_FEATURES = listOf(
    ClassFeature(
        id = "CONJURATION_CONJURATION_SAVANT",
        name = "Conjuration Savant",
        level = 2,
        summary = "Copying conjuration spells into your spellbook takes half the gold and time.",
    ),
    ClassFeature(
        id = "CONJURATION_MINOR_CONJURATION",
        name = "Minor Conjuration",
        level = 2,
        summary =
        "Action: conjure a nonmagical object you have seen, up to 3 ft on a side and 10 lb, within 10 ft. It lasts 1 " +
            "hour, until it takes damage or until you use this again.",
    ),
    ClassFeature(
        id = "CONJURATION_BENIGN_TRANSPOSITION",
        name = "Benign Transposition",
        level = 6,
        summary =
        "Action: teleport up to 30 ft to an unoccupied space you can see, or swap places with a willing Small or " +
            "Medium creature. Once per long rest, or until you cast a conjuration spell of 1st level or higher.",
    ),
    ClassFeature(
        id = "CONJURATION_FOCUSED_CONJURATION",
        name = "Focused Conjuration",
        level = 10,
        summary = "Taking damage can't break your concentration on a conjuration spell.",
    ),
    ClassFeature(
        id = "CONJURATION_DURABLE_SUMMONS",
        name = "Durable Summons",
        level = 14,
        summary = "Creatures you summon or create with a conjuration spell have 30 temporary hit points.",
    ),
)

// School of Divination no es SRD: solo resúmenes propios.
internal val DIVINATION_FEATURES = listOf(
    ClassFeature(
        id = "DIVINATION_DIVINATION_SAVANT",
        name = "Divination Savant",
        level = 2,
        summary = "Copying divination spells into your spellbook takes half the gold and time.",
    ),
    ClassFeature(
        id = "DIVINATION_PORTENT",
        name = "Portent",
        level = 2,
        summary =
        "After a long rest, roll two d20s and keep them. You can replace an attack roll, saving throw or ability " +
            "check of a creature you can see with one of them before it is rolled. Unused rolls are lost on a long " +
            "rest.",
    ),
    ClassFeature(
        id = "DIVINATION_EXPERT_DIVINATION",
        name = "Expert Divination",
        level = 6,
        summary =
        "When you cast a divination spell of 2nd level or higher with a slot, regain one expended slot of a lower " +
            "level (5th level at most).",
    ),
    ClassFeature(
        id = "DIVINATION_THE_THIRD_EYE",
        name = "The Third Eye",
        level = 10,
        summary =
        "Action: until you are incapacitated or take a rest, gain one of darkvision 60 ft, ethereal sight 60 ft, the " +
            "ability to read any language, or seeing invisible creatures and objects within 10 ft. Once per short or " +
            "long rest.",
    ),
    ClassFeature(
        id = "DIVINATION_GREATER_PORTENT",
        name = "Greater Portent",
        level = 14,
        summary = "Portent rolls three d20s instead of two.",
    ),
)

// School of Enchantment no es SRD: solo resúmenes propios.
internal val ENCHANTMENT_FEATURES = listOf(
    ClassFeature(
        id = "ENCHANTMENT_ENCHANTMENT_SAVANT",
        name = "Enchantment Savant",
        level = 2,
        summary = "Copying enchantment spells into your spellbook takes half the gold and time.",
    ),
    ClassFeature(
        id = "ENCHANTMENT_HYPNOTIC_GAZE",
        name = "Hypnotic Gaze",
        level = 2,
        summary =
        "Action: a creature within 5 ft that can see or hear you makes a Wisdom save or is charmed until the end of " +
            "your next turn: speed 0, incapacitated and dazed. You can extend it with your action each turn. On a " +
            "success, or once it ends, you can't use it on that creature until a long rest.",
    ),
    ClassFeature(
        id = "ENCHANTMENT_INSTINCTIVE_CHARM",
        name = "Instinctive Charm",
        level = 6,
        summary =
        "Reaction: when a creature within 30 ft attacks you, it makes a Wisdom save or must target the closest other " +
            "creature, or lose the attack if there is none. On a success it is immune until a long rest.",
    ),
    ClassFeature(
        id = "ENCHANTMENT_SPLIT_ENCHANTMENT",
        name = "Split Enchantment",
        level = 10,
        summary = "An enchantment spell that targets only one creature can target a second one.",
    ),
    ClassFeature(
        id = "ENCHANTMENT_ALTER_MEMORIES",
        name = "Alter Memories",
        level = 14,
        summary =
        "When you charm creatures with a spell, one of them can be unaware of it. Before the spell ends you can make " +
            "it forget part of the time it was charmed (up to 1 + Charisma modifier hours) with an Intelligence save.",
    ),
)

// School of Illusion no es SRD: solo resúmenes propios.
internal val ILLUSION_FEATURES = listOf(
    ClassFeature(
        id = "ILLUSION_ILLUSION_SAVANT",
        name = "Illusion Savant",
        level = 2,
        summary = "Copying illusion spells into your spellbook takes half the gold and time.",
    ),
    ClassFeature(
        id = "ILLUSION_IMPROVED_MINOR_ILLUSION",
        name = "Improved Minor Illusion",
        level = 2,
        summary =
        "Learn the minor illusion cantrip (or another wizard cantrip if you already know it). When you cast it, you " +
            "can create both a sound and an image.",
    ),
    ClassFeature(
        id = "ILLUSION_MALLEABLE_ILLUSIONS",
        name = "Malleable Illusions",
        level = 6,
        summary =
        "Action: change the nature of an illusion spell with a duration of 1 minute or longer that you can see.",
    ),
    ClassFeature(
        id = "ILLUSION_ILLUSORY_SELF",
        name = "Illusory Self",
        level = 10,
        summary =
        "Reaction: when a creature attacks you, an illusory duplicate makes the attack miss. Once per short or long " +
            "rest.",
    ),
    ClassFeature(
        id = "ILLUSION_ILLUSORY_REALITY",
        name = "Illusory Reality",
        level = 14,
        summary =
        "Bonus action: when you cast an illusion spell of 1st level or higher, make one inanimate, nonmagical object " +
            "of the illusion real for 1 minute. It can't deal damage or harm anyone directly.",
    ),
)

// School of Necromancy no es SRD: solo resúmenes propios.
internal val NECROMANCY_FEATURES = listOf(
    ClassFeature(
        id = "NECROMANCY_NECROMANCY_SAVANT",
        name = "Necromancy Savant",
        level = 2,
        summary = "Copying necromancy spells into your spellbook takes half the gold and time.",
    ),
    ClassFeature(
        id = "NECROMANCY_GRIM_HARVEST",
        name = "Grim Harvest",
        level = 2,
        summary =
        "Once per turn, when a spell of 1st level or higher you cast kills a creature (not an undead or construct), " +
            "regain hit points equal to twice the spell's level, or three times for necromancy spells.",
    ),
    ClassFeature(
        id = "NECROMANCY_UNDEAD_THRALLS",
        name = "Undead Thralls",
        level = 6,
        summary =
        "Learn animate dead if you don't know it. It animates one extra target, and your undead add your wizard " +
            "level to their hit point maximum and your proficiency bonus to their weapon damage.",
    ),
    ClassFeature(
        id = "NECROMANCY_INURED_TO_UNDEATH",
        name = "Inured to Undeath",
        level = 10,
        summary = "Resistance to necrotic damage, and your hit point maximum can't be reduced.",
    ),
    ClassFeature(
        id = "NECROMANCY_COMMAND_UNDEAD",
        name = "Command Undead",
        level = 14,
        summary =
        "Action: an undead within 60 ft makes a Charisma save or becomes friendly and obeys you until you use this " +
            "again. Undead with Intelligence 8 or higher have advantage, and those with 12 or more repeat the save " +
            "every hour.",
    ),
)

// School of Transmutation no es SRD: solo resúmenes propios.
internal val TRANSMUTATION_FEATURES = listOf(
    ClassFeature(
        id = "TRANSMUTATION_TRANSMUTATION_SAVANT",
        name = "Transmutation Savant",
        level = 2,
        summary = "Copying transmutation spells into your spellbook takes half the gold and time.",
    ),
    ClassFeature(
        id = "TRANSMUTATION_MINOR_ALCHEMY",
        name = "Minor Alchemy",
        level = 2,
        summary =
        "Spend 10 minutes to turn an object of wood, stone (not gemstone), iron, copper or silver into another of " +
            "those materials, 1 cubic foot per 10 minutes. It reverts after 1 hour or if you lose concentration.",
    ),
    ClassFeature(
        id = "TRANSMUTATION_TRANSMUTERS_STONE",
        name = "Transmuter's Stone",
        level = 6,
        summary =
        "Spend 8 hours to create a stone that gives its bearer one benefit of your choice: darkvision 60 ft, +10 ft " +
            "of speed while unencumbered, proficiency in Constitution saves, or resistance to acid, cold, fire, " +
            "lightning or thunder damage. Casting a transmutation spell of 1st level or higher lets you change the " +
            "benefit.",
    ),
    ClassFeature(
        id = "TRANSMUTATION_SHAPECHANGER",
        name = "Shapechanger",
        level = 10,
        summary =
        "Add polymorph to your spellbook. Once per short or long rest you can cast it on yourself without a slot, to " +
            "become a beast of challenge rating 1 or lower.",
    ),
    ClassFeature(
        id = "TRANSMUTATION_MASTER_TRANSMUTER",
        name = "Master Transmuter",
        level = 14,
        summary =
        "Action: destroy your transmuter's stone for one effect: transform a nonmagical object into another of " +
            "similar size and value, remove curses, diseases and poisons and heal a creature fully, cast raise dead " +
            "without a slot, or make a creature up to 3 years younger. Then make a new stone after a long rest.",
    ),
)
