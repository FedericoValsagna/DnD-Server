package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.ClassFeature

// Cleric y sus dominios. Cleric y Life Domain son SRD: llevan el texto del SRD 5.1 además del resumen propio.
internal val CLERIC_FEATURES = listOf(
    ClassFeature(
        id = "CLERIC_SPELLCASTING",
        name = "Spellcasting",
        level = 1,
        summary =
        "Prepared caster with Wisdom: after a long rest, prepare Wisdom modifier + cleric level spells from the " +
            "cleric list. Slots recover on a long rest. Prepared ritual spells can be cast as rituals, and a holy " +
            "symbol works as spellcasting focus.",
        srdText =
        "Cantrips. At 1st level, you know three cantrips of your choice from the cleric spell list. You learn " +
            "additional cleric cantrips of your choice at higher levels, as shown in the Cantrips Known column of " +
            "the Cleric table.\n\nPreparing and Casting Spells. The Cleric table shows how many spell slots you " +
            "have to cast your spells of 1st level and higher. To cast one of these spells, you must expend a slot " +
            "of the spell's level or higher. You regain all expended spell slots when you finish a long " +
            "rest.\n\nYou prepare the list of cleric spells that are available for you to cast, choosing from the " +
            "cleric spell list. When you do so, choose a number of cleric spells equal to your Wisdom modifier + " +
            "your cleric level (minimum of one spell). The spells must be of a level for which you have spell " +
            "slots.\n\nFor example, if you are a 3rd-level cleric, you have four 1st-level and two 2nd-level spell " +
            "slots. With a Wisdom of 16, your list of prepared spells can include six spells of 1st or 2nd level, " +
            "in any combination. If you prepare the 1st-level spell cure wounds, you can cast it using a 1st-level " +
            "or 2nd-level slot. Casting the spell doesn't remove it from your list of prepared spells.\n\nYou can " +
            "change your list of prepared spells when you finish a long rest. Preparing a new list of cleric spells " +
            "requires time spent in prayer and meditation: at least 1 minute per spell level for each spell on your " +
            "list.\n\nSpellcasting Ability. Wisdom is your spellcasting ability for your cleric spells. The power " +
            "of your spells comes from your devotion to your deity. You use your Wisdom whenever a cleric spell " +
            "refers to your spellcasting ability. In addition, you use your Wisdom modifier when setting the saving " +
            "throw DC for a cleric spell you cast and when making an attack roll with one.\n\nSpell save DC = 8 + " +
            "your proficiency bonus + your Wisdom modifier\n\nSpell attack modifier = your proficiency bonus + your " +
            "Wisdom modifier\n\nRitual Casting. You can cast a cleric spell as a ritual if that spell has the " +
            "ritual tag and you have the spell prepared.\n\nSpellcasting Focus. You can use a holy symbol (see " +
            "Equipment) as a spellcasting focus for your cleric spells.",
    ),
    ClassFeature(
        id = "CLERIC_CHANNEL_DIVINITY",
        name = "Channel Divinity",
        level = 2,
        summary =
        "Channel divine energy into one of your effects: Turn Undead or your domain's. Once per short or long " +
            "rest, twice from 6th level and three times from 18th. Saves use your cleric spell save DC.",
        srdText =
        "At 2nd level, you gain the ability to channel divine energy directly from your deity, using that " +
            "energy to fuel magical effects. You start with two such effects: Turn Undead and an effect determined " +
            "by your domain. Some domains grant you additional effects as you advance in levels, as noted in the " +
            "domain description.\n\nWhen you use your Channel Divinity, you choose which effect to create. You must " +
            "then finish a short or long rest to use your Channel Divinity again.\n\nSome Channel Divinity effects " +
            "require saving throws. When you use such an effect from this class, the DC equals your cleric spell " +
            "save DC.\n\nBeginning at 6th level, you can use your Channel Divinity twice between rests, and " +
            "beginning at 18th level, you can use it three times between rests. When you finish a short or long " +
            "rest, you regain your expended uses.",
    ),
    ClassFeature(
        id = "CLERIC_TURN_UNDEAD",
        name = "Channel Divinity: Turn Undead",
        level = 2,
        summary =
        "Action: each undead within 30 ft that can see or hear you makes a Wisdom save. On a failure it is " +
            "turned for 1 minute or until it takes damage: it must move away from you, can't come within 30 ft and " +
            "can't take reactions.",
        srdText =
        "As an action, you present your holy symbol and speak a prayer censuring the undead. Each undead that " +
            "can see or hear you within 30 feet of you must make a Wisdom saving throw. If the creature fails its " +
            "saving throw, it is turned for 1 minute or until it takes any damage.\n\nA turned creature must spend " +
            "its turns trying to move as far away from you as it can, and it can't willingly move to a space within " +
            "30 feet of you. It also can't take reactions. For its action, it can use only the Dash action or try " +
            "to escape from an effect that prevents it from moving. If there's nowhere to move, the creature can " +
            "use the Dodge action.",
    ),
    ClassFeature(
        id = "CLERIC_ABILITY_SCORE_IMPROVEMENT",
        name = "Ability Score Improvement",
        level = 4,
        summary = "At 4th, 8th, 12th, 16th and 19th level: +2 to one ability score or +1 to two (maximum 20).",
        srdText =
        "When you reach 4th level, and again at 8th, 12th, 16th, and 19th level, you can increase one ability " +
            "score of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you " +
            "can't increase an ability score above 20 using this feature.",
    ),
    ClassFeature(
        id = "CLERIC_DESTROY_UNDEAD",
        name = "Destroy Undead",
        level = 5,
        summary =
        "An undead that fails its save against your Turn Undead is destroyed outright if its CR is low enough: " +
            "1/2 or lower at 5th level, 1 at 8th, 2 at 11th, 3 at 14th and 4 at 17th.",
        srdText =
        "Starting at 5th level, when an undead fails its saving throw against your Turn Undead feature, the " +
            "creature is instantly destroyed if its challenge rating is at or below a certain " +
            "threshold.\n\nDestroys undead of CR: 1/2 or lower at 5th level, 1 or lower at 8th, 2 or lower at 11th, " +
            "3 or lower at 14th, 4 or lower at 17th.",
    ),
    ClassFeature(
        id = "CLERIC_DIVINE_INTERVENTION",
        name = "Divine Intervention",
        level = 10,
        summary =
        "Action: ask your deity for help and roll d100; if you get your cleric level or lower, the GM decides " +
            "how it intervenes. After a success you wait 7 days to use it again, otherwise a long rest. From 20th " +
            "level it always succeeds.",
        srdText =
        "Beginning at 10th level, you can call on your deity to intervene on your behalf when your need is " +
            "great.\n\nImploring your deity's aid requires you to use your action. Describe the assistance you " +
            "seek, and roll percentile dice. If you roll a number equal to or lower than your cleric level, your " +
            "deity intervenes. The GM chooses the nature of the intervention; the effect of any cleric spell or " +
            "cleric domain spell would be appropriate.\n\nIf your deity intervenes, you can't use this feature " +
            "again for 7 days. Otherwise, you can use it again after you finish a long rest.\n\nAt 20th level, your " +
            "call for intervention succeeds automatically, no roll required.",
    ),
)

internal val LIFE_FEATURES = listOf(
    ClassFeature(
        id = "LIFE_BONUS_PROFICIENCY",
        name = "Bonus Proficiency",
        level = 1,
        summary = "Proficiency with heavy armor.",
        srdText = "When you choose this domain at 1st level, you gain proficiency with heavy armor.",
    ),
    ClassFeature(
        id = "LIFE_DISCIPLE_OF_LIFE",
        name = "Disciple of Life",
        level = 1,
        summary =
        "Your healing spells of 1st level or higher restore an extra 2 + the spell's level hit points to each " +
            "target.",
        srdText =
        "Also starting at 1st level, your healing spells are more effective. Whenever you use a spell of 1st " +
            "level or higher to restore hit points to a creature, the creature regains additional hit points equal " +
            "to 2 + the spell's level.",
    ),
    ClassFeature(
        id = "LIFE_PRESERVE_LIFE",
        name = "Channel Divinity: Preserve Life",
        level = 2,
        summary =
        "Action: split up to five times your cleric level in healing among creatures within 30 ft, without " +
            "raising any of them above half its hit point maximum. Doesn't work on undead or constructs.",
        srdText =
        "Starting at 2nd level, you can use your Channel Divinity to heal the badly injured.\n\nAs an action, " +
            "you present your holy symbol and evoke healing energy that can restore a number of hit points equal to " +
            "five times your cleric level.\n\nChoose any creatures within 30 feet of you, and divide those hit " +
            "points among them. This feature can restore a creature to no more than half of its hit point maximum. " +
            "You can't use this feature on an undead or a construct.",
    ),
    ClassFeature(
        id = "LIFE_BLESSED_HEALER",
        name = "Blessed Healer",
        level = 6,
        summary =
        "When a spell of 1st level or higher you cast heals someone else, you regain 2 + the spell's level hit " +
            "points.",
        srdText =
        "Beginning at 6th level, the healing spells you cast on others heal you as well. When you cast a spell " +
            "of 1st level or higher that restores hit points to a creature other than you, you regain hit points " +
            "equal to 2 + the spell's level.",
    ),
    ClassFeature(
        id = "LIFE_DIVINE_STRIKE",
        name = "Divine Strike",
        level = 8,
        summary = "Once on each of your turns, a weapon hit deals an extra 1d8 radiant damage (2d8 from 14th level).",
        srdText =
        "At 8th level, you gain the ability to infuse your weapon strikes with divine energy. Once on each of " +
            "your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra 1d8 " +
            "radiant damage to the target. When you reach 14th level, the extra damage increases to 2d8.",
    ),
    ClassFeature(
        id = "LIFE_SUPREME_HEALING",
        name = "Supreme Healing",
        level = 17,
        summary = "The healing dice of your spells always count as their highest value instead of being rolled.",
        srdText =
        "Starting at 17th level, when you would normally roll one or more dice to restore hit points with a " +
            "spell, you instead use the highest number possible for each die. For example, instead of restoring 2d6 " +
            "hit points to a creature, you restore 12.",
    ),
)

// Nature Domain no es SRD: solo resúmenes propios.
internal val NATURE_FEATURES = listOf(
    ClassFeature(
        id = "NATURE_ACOLYTE_OF_NATURE",
        name = "Acolyte of Nature",
        level = 1,
        summary = "Learn one druid cantrip, which counts as a cleric cantrip, and gain proficiency in one skill: " +
            "Animal Handling, Nature or Survival.",
    ),
    ClassFeature(
        id = "NATURE_BONUS_PROFICIENCY",
        name = "Bonus Proficiency",
        level = 1,
        summary = "Proficiency with heavy armor.",
    ),
    ClassFeature(
        id = "NATURE_CHARM_ANIMALS_AND_PLANTS",
        name = "Channel Divinity: Charm Animals and Plants",
        level = 2,
        summary = "Action: each beast or plant creature within 30 ft that can see you makes a Wisdom save. On a " +
            "failure it is charmed by you for 1 minute or until it takes damage, and is friendly to you and the " +
            "creatures you choose.",
    ),
    ClassFeature(
        id = "NATURE_DAMPEN_ELEMENTS",
        name = "Dampen Elements",
        level = 6,
        summary = "Reaction: when you or a creature within 30 ft takes acid, cold, fire, lightning or thunder " +
            "damage, grant resistance against that damage.",
    ),
    ClassFeature(
        id = "NATURE_DIVINE_STRIKE",
        name = "Divine Strike",
        level = 8,
        summary = "Once on each of your turns, a weapon hit deals an extra 1d8 cold, fire or lightning damage (your " +
            "choice), 2d8 from 14th level.",
    ),
    ClassFeature(
        id = "NATURE_MASTER_OF_NATURE",
        name = "Master of Nature",
        level = 17,
        summary = "Bonus action: command the creatures charmed by your Charm Animals and Plants, telling each one " +
            "what it does on its next turn.",
    ),
)

// Knowledge, Light, Tempest, Trickery y War no son SRD: solo resúmenes propios.
internal val KNOWLEDGE_FEATURES = listOf(
    ClassFeature(
        id = "KNOWLEDGE_BLESSINGS_OF_KNOWLEDGE",
        name = "Blessings of Knowledge",
        level = 1,
        summary =
        "Learn two languages and gain proficiency in two skills among Arcana, History, Nature and Religion, with " +
            "double proficiency bonus on checks with them.",
    ),
    ClassFeature(
        id = "KNOWLEDGE_KNOWLEDGE_OF_THE_AGES",
        name = "Channel Divinity: Knowledge of the Ages",
        level = 2,
        summary = "Action: gain proficiency with one skill or tool of your choice for 10 minutes.",
    ),
    ClassFeature(
        id = "KNOWLEDGE_READ_THOUGHTS",
        name = "Channel Divinity: Read Thoughts",
        level = 6,
        summary =
        "Action: a creature within 60 ft makes a Wisdom save. On a failure you read its surface thoughts for 1 " +
            "minute while it stays within 60 ft, and during that time you can use an action to end the effect and " +
            "cast suggestion on it without a slot; it fails the save automatically. On a success you can't try again " +
            "on it until a long rest.",
    ),
    ClassFeature(
        id = "KNOWLEDGE_POTENT_SPELLCASTING",
        name = "Potent Spellcasting",
        level = 8,
        summary = "Add your Wisdom modifier to the damage of your cleric cantrips.",
    ),
    ClassFeature(
        id = "KNOWLEDGE_VISIONS_OF_THE_PAST",
        name = "Visions of the Past",
        level = 17,
        summary =
        "Meditate (concentrating, as with a spell) for at least 1 minute and up to your Wisdom score in minutes to " +
            "see glimpses of the past. Object reading: holding an object, you see its previous owner and how it got " +
            "and lost it, plus a recent significant event involving it. Area reading: for each minute, one " +
            "significant event in your surroundings, from the most recent back to as many days ago as your Wisdom " +
            "score. Once per short or long rest.",
    ),
)

internal val LIGHT_FEATURES = listOf(
    ClassFeature(
        id = "LIGHT_BONUS_CANTRIP",
        name = "Bonus Cantrip",
        level = 1,
        summary = "You learn the light cantrip, if you don't know it already.",
    ),
    ClassFeature(
        id = "LIGHT_WARDING_FLARE",
        name = "Warding Flare",
        level = 1,
        summary =
        "Reaction when a creature you can see within 30 ft attacks you: impose disadvantage on the roll (creatures " +
            "that can't be blinded are immune). Uses equal to your Wisdom modifier (minimum 1) per long rest.",
    ),
    ClassFeature(
        id = "LIGHT_RADIANCE_OF_THE_DAWN",
        name = "Channel Divinity: Radiance of the Dawn",
        level = 2,
        summary =
        "Action: dispel magical darkness within 30 ft, and each hostile creature within 30 ft makes a Constitution " +
            "save, taking 2d10 + cleric level radiant damage on a failure or half on a success. Total cover " +
            "protects.",
    ),
    ClassFeature(
        id = "LIGHT_IMPROVED_FLARE",
        name = "Improved Flare",
        level = 6,
        summary =
        "You can also use Warding Flare when a creature you can see within 30 ft attacks someone other than you.",
    ),
    ClassFeature(
        id = "LIGHT_POTENT_SPELLCASTING",
        name = "Potent Spellcasting",
        level = 8,
        summary = "Add your Wisdom modifier to the damage of your cleric cantrips.",
    ),
    ClassFeature(
        id = "LIGHT_CORONA_OF_LIGHT",
        name = "Corona of Light",
        level = 17,
        summary =
        "Action: emit an aura of sunlight for 1 minute or until you dismiss it (bright light in 60 ft, dim light 30 " +
            "ft more). Your enemies in the bright light have disadvantage on saves against spells that deal fire or " +
            "radiant damage.",
    ),
)

internal val TEMPEST_FEATURES = listOf(
    ClassFeature(
        id = "TEMPEST_BONUS_PROFICIENCIES",
        name = "Bonus Proficiencies",
        level = 1,
        summary = "Proficiency with martial weapons and heavy armor.",
    ),
    ClassFeature(
        id = "TEMPEST_WRATH_OF_THE_STORM",
        name = "Wrath of the Storm",
        level = 1,
        summary =
        "Reaction when a creature within 5 ft that you can see hits you: it makes a Dexterity save, taking 2d8 " +
            "lightning or thunder damage (your choice) on a failure or half on a success. Uses equal to your Wisdom " +
            "modifier (minimum 1) per long rest.",
    ),
    ClassFeature(
        id = "TEMPEST_DESTRUCTIVE_WRATH",
        name = "Channel Divinity: Destructive Wrath",
        level = 2,
        summary = "When you roll lightning or thunder damage, deal the maximum instead of rolling.",
    ),
    ClassFeature(
        id = "TEMPEST_THUNDERBOLT_STRIKE",
        name = "Thunderbolt Strike",
        level = 6,
        summary =
        "When you deal lightning damage to a Large or smaller creature, you can push it up to 10 ft away from you.",
    ),
    ClassFeature(
        id = "TEMPEST_DIVINE_STRIKE",
        name = "Divine Strike",
        level = 8,
        summary = "Once on each of your turns, a weapon hit deals an extra 1d8 thunder damage, 2d8 from 14th level.",
    ),
    ClassFeature(
        id = "TEMPEST_STORMBORN",
        name = "Stormborn",
        level = 17,
        summary = "Flying speed equal to your walking speed while you aren't underground or indoors.",
    ),
)

internal val TRICKERY_FEATURES = listOf(
    ClassFeature(
        id = "TRICKERY_BLESSING_OF_THE_TRICKSTER",
        name = "Blessing of the Trickster",
        level = 1,
        summary =
        "Action: a willing creature you touch, other than you, has advantage on Dexterity (Stealth) checks for 1 " +
            "hour or until you use this feature again.",
    ),
    ClassFeature(
        id = "TRICKERY_INVOKE_DUPLICITY",
        name = "Channel Divinity: Invoke Duplicity",
        level = 2,
        summary =
        "Action: create an illusory duplicate of yourself within 30 ft, for 1 minute with concentration. Bonus " +
            "action: move it up to 30 ft (it must stay within 120 ft). You can cast spells as if you were in its " +
            "space, and you have advantage on attacks against a creature that is within 5 ft of both you and the " +
            "duplicate.",
    ),
    ClassFeature(
        id = "TRICKERY_CLOAK_OF_SHADOWS",
        name = "Channel Divinity: Cloak of Shadows",
        level = 6,
        summary = "Action: become invisible until the end of your next turn or until you attack or cast a spell.",
    ),
    ClassFeature(
        id = "TRICKERY_DIVINE_STRIKE",
        name = "Divine Strike",
        level = 8,
        summary = "Once on each of your turns, a weapon hit deals an extra 1d8 poison damage, 2d8 from 14th level.",
    ),
    ClassFeature(
        id = "TRICKERY_IMPROVED_DUPLICITY",
        name = "Improved Duplicity",
        level = 17,
        summary = "Invoke Duplicity creates up to four duplicates, and a single bonus action moves any of them.",
    ),
)

internal val WAR_FEATURES = listOf(
    ClassFeature(
        id = "WAR_BONUS_PROFICIENCIES",
        name = "Bonus Proficiencies",
        level = 1,
        summary = "Proficiency with martial weapons and heavy armor.",
    ),
    ClassFeature(
        id = "WAR_WAR_PRIEST",
        name = "War Priest",
        level = 1,
        summary =
        "When you take the Attack action, you can make one weapon attack as a bonus action. Uses equal to your " +
            "Wisdom modifier (minimum 1) per long rest.",
    ),
    ClassFeature(
        id = "WAR_GUIDED_STRIKE",
        name = "Channel Divinity: Guided Strike",
        level = 2,
        summary = "+10 to one of your attack rolls, chosen after seeing the roll but before knowing if it hits.",
    ),
    ClassFeature(
        id = "WAR_WAR_GODS_BLESSING",
        name = "Channel Divinity: War God's Blessing",
        level = 6,
        summary =
        "Reaction when a creature within 30 ft makes an attack roll: give it +10, after seeing the roll but before " +
            "knowing if it hits.",
    ),
    ClassFeature(
        id = "WAR_DIVINE_STRIKE",
        name = "Divine Strike",
        level = 8,
        summary =
        "Once on each of your turns, a weapon hit deals an extra 1d8 damage of the same type as the weapon's damage, " +
            "2d8 from 14th level.",
    ),
    ClassFeature(
        id = "WAR_AVATAR_OF_BATTLE",
        name = "Avatar of Battle",
        level = 17,
        summary = "Resistance to bludgeoning, piercing and slashing damage from nonmagical weapons.",
    ),
)
