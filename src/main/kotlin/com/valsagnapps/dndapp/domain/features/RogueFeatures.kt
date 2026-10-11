package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.ClassFeature

// Rogue y sus arquetipos. Rogue y Thief son SRD: llevan el texto del SRD 5.1 además del resumen propio.
internal val ROGUE_FEATURES = listOf(
    ClassFeature(
        id = "ROGUE_EXPERTISE",
        name = "Expertise",
        level = 1,
        summary =
        "Choose two skill proficiencies (or one and thieves' tools): double proficiency bonus on checks with them. " +
            "Two more at 6th level.",
        srdText =
        "At 1st level, choose two of your skill proficiencies, or one of your skill proficiencies and your " +
            "proficiency with thieves' tools. Your proficiency bonus is doubled for any ability check you make that " +
            "uses either of the chosen proficiencies.\n\nAt 6th level, you can choose two more of your proficiencies " +
            "(in skills or with thieves' tools) to gain this benefit.",
    ),
    ClassFeature(
        id = "ROGUE_SNEAK_ATTACK",
        name = "Sneak Attack",
        level = 1,
        summary =
        "Once per turn, extra damage to a creature you hit with a finesse or ranged weapon if you have advantage, or " +
            "if another enemy of the target, not incapacitated, is within 5 ft of it and you don't have " +
            "disadvantage. 1d6 at 1st level, one more d6 every two levels: 2d6 at 3rd, 3d6 at 5th... up to 10d6 at " +
            "19th.",
        srdText =
        "Beginning at 1st level, you know how to strike subtly and exploit a foe's distraction. Once per turn, you " +
            "can deal an extra 1d6 damage to one creature you hit with an attack if you have advantage on the attack " +
            "roll. The attack must use a finesse or a ranged weapon.\n\nYou don't need advantage on the attack roll " +
            "if another enemy of the target is within 5 feet of it, that enemy isn't incapacitated, and you don't " +
            "have disadvantage on the attack roll.\n\nThe amount of the extra damage increases as you gain levels in " +
            "this class, as shown in the Sneak Attack column of the Rogue table.",
    ),
    ClassFeature(
        id = "ROGUE_THIEVES_CANT",
        name = "Thieves' Cant",
        level = 1,
        summary =
        "You know thieves' cant: hide messages in normal conversation (four times slower) and read the secret signs " +
            "and symbols of thieves.",
        srdText =
        "During your rogue training you learned thieves' cant, a secret mix of dialect, jargon, and code that allows " +
            "you to hide messages in seemingly normal conversation. Only another creature that knows thieves' cant " +
            "understands such messages. It takes four times longer to convey such a message than it does to speak " +
            "the same idea plainly.\n\nIn addition, you understand a set of secret signs and symbols used to convey " +
            "short, simple messages, such as whether an area is dangerous or the territory of a thieves' guild, " +
            "whether loot is nearby, or whether the people in an area are easy marks or will provide a safe house " +
            "for thieves on the run.",
    ),
    ClassFeature(
        id = "ROGUE_CUNNING_ACTION",
        name = "Cunning Action",
        level = 2,
        summary = "Bonus action on each of your turns in combat: Dash, Disengage or Hide.",
        srdText =
        "Starting at 2nd level, your quick thinking and agility allow you to move and act quickly. You can take a " +
            "bonus action on each of your turns in combat. This action can be used only to take the Dash, Disengage, " +
            "or Hide action.",
    ),
    ClassFeature(
        id = "ROGUE_ABILITY_SCORE_IMPROVEMENT",
        name = "Ability Score Improvement",
        level = 4,
        summary = "At 4th, 8th, 10th, 12th, 16th and 19th level: +2 to one ability score or +1 to two (maximum 20).",
        srdText =
        "When you reach 4th level, and again at 8th, 10th, 12th, 16th, and 19th level, you can increase one ability " +
            "score of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you " +
            "can't increase an ability score above 20 using this feature.",
    ),
    ClassFeature(
        id = "ROGUE_UNCANNY_DODGE",
        name = "Uncanny Dodge",
        level = 5,
        summary = "Reaction: halve the damage of an attack that hits you from an attacker you can see.",
        srdText =
        "Starting at 5th level, when an attacker that you can see hits you with an attack, you can use your reaction " +
            "to halve the attack's damage against you.",
    ),
    ClassFeature(
        id = "ROGUE_EVASION",
        name = "Evasion",
        level = 7,
        summary = "On Dexterity saves for half damage, take no damage on a success and half on a failure.",
        srdText =
        "Beginning at 7th level, you can nimbly dodge out of the way of certain area effects, such as a red dragon's " +
            "fiery breath or an ice storm spell. When you are subjected to an effect that allows you to make a " +
            "Dexterity saving throw to take only half damage, you instead take no damage if you succeed on the " +
            "saving throw, and only half damage if you fail.",
    ),
    ClassFeature(
        id = "ROGUE_RELIABLE_TALENT",
        name = "Reliable Talent",
        level = 11,
        summary = "On ability checks that add your proficiency bonus, a d20 roll of 9 or lower counts as 10.",
        srdText =
        "By 11th level, you have refined your chosen skills until they approach perfection. Whenever you make an " +
            "ability check that lets you add your proficiency bonus, you can treat a d20 roll of 9 or lower as a 10.",
    ),
    ClassFeature(
        id = "ROGUE_BLINDSENSE",
        name = "Blindsense",
        level = 14,
        summary = "If you can hear, you know the location of hidden or invisible creatures within 10 ft.",
        srdText =
        "Starting at 14th level, if you are able to hear, you are aware of the location of any hidden or invisible " +
            "creature within 10 feet of you.",
    ),
    ClassFeature(
        id = "ROGUE_SLIPPERY_MIND",
        name = "Slippery Mind",
        level = 15,
        summary = "Proficiency in Wisdom saving throws.",
        srdText =
        "By 15th level, you have acquired greater mental strength. You gain proficiency in Wisdom saving throws.",
    ),
    ClassFeature(
        id = "ROGUE_ELUSIVE",
        name = "Elusive",
        level = 18,
        summary = "No attack roll has advantage against you while you aren't incapacitated.",
        srdText =
        "Beginning at 18th level, you are so evasive that attackers rarely gain the upper hand against you. No " +
            "attack roll has advantage against you while you aren't incapacitated.",
    ),
    ClassFeature(
        id = "ROGUE_STROKE_OF_LUCK",
        name = "Stroke of Luck",
        level = 20,
        summary =
        "Turn a missed attack into a hit, or a failed ability check into a d20 roll of 20. Once per short or long " +
            "rest.",
        srdText =
        "At 20th level, you have an uncanny knack for succeeding when you need to. If your attack misses a target " +
            "within range, you can turn the miss into a hit. Alternatively, if you fail an ability check, you can " +
            "treat the d20 roll as a 20.\n\nOnce you use this feature, you can't use it again until you finish a " +
            "short or long rest.",
    ),
)

internal val THIEF_FEATURES = listOf(
    ClassFeature(
        id = "THIEF_FAST_HANDS",
        name = "Fast Hands",
        level = 3,
        summary =
        "Your Cunning Action bonus action can also be a Dexterity (Sleight of Hand) check, using thieves' tools to " +
            "disarm a trap or open a lock, or the Use an Object action.",
        srdText =
        "Starting at 3rd level, you can use the bonus action granted by your Cunning Action to make a Dexterity " +
            "(Sleight of Hand) check, use your thieves' tools to disarm a trap or open a lock, or take the Use an " +
            "Object action.",
    ),
    ClassFeature(
        id = "THIEF_SECOND_STORY_WORK",
        name = "Second-Story Work",
        level = 3,
        summary =
        "Climbing doesn't cost you extra movement, and your running jumps grow by your Dexterity modifier in feet.",
        srdText =
        "When you choose this archetype at 3rd level, you gain the ability to climb faster than normal; climbing no " +
            "longer costs you extra movement.\n\nIn addition, when you make a running jump, the distance you cover " +
            "increases by a number of feet equal to your Dexterity modifier.",
    ),
    ClassFeature(
        id = "THIEF_SUPREME_SNEAK",
        name = "Supreme Sneak",
        level = 9,
        summary = "Advantage on Dexterity (Stealth) checks if you move no more than half your speed that turn.",
        srdText =
        "Starting at 9th level, you have advantage on a Dexterity (Stealth) check if you move no more than half your " +
            "speed on the same turn.",
    ),
    ClassFeature(
        id = "THIEF_USE_MAGIC_DEVICE",
        name = "Use Magic Device",
        level = 13,
        summary = "Ignore all class, race and level requirements to use magic items.",
        srdText =
        "By 13th level, you have learned enough about the workings of magic that you can improvise the use of items " +
            "even when they are not intended for you. You ignore all class, race, and level requirements on the use " +
            "of magic items.",
    ),
    ClassFeature(
        id = "THIEF_THIEFS_REFLEXES",
        name = "Thief's Reflexes",
        level = 17,
        summary =
        "Take two turns in the first round of combat: one at your initiative and another at your initiative minus " +
            "10. Not while surprised.",
        srdText =
        "When you reach 17th level, you have become adept at laying ambushes and quickly escaping danger. You can " +
            "take two turns during the first round of any combat. You take your first turn at your normal initiative " +
            "and your second turn at your initiative minus 10. You can't use this feature when you are surprised.",
    ),
)

// Assassin y Arcane Trickster no son SRD: solo resúmenes propios.
internal val ASSASSIN_FEATURES = listOf(
    ClassFeature(
        id = "ASSASSIN_BONUS_PROFICIENCIES",
        name = "Bonus Proficiencies",
        level = 3,
        summary = "Proficiency with the disguise kit and the poisoner's kit.",
    ),
    ClassFeature(
        id = "ASSASSIN_ASSASSINATE",
        name = "Assassinate",
        level = 3,
        summary =
        "Advantage on attack rolls against creatures that haven't taken a turn in the combat yet, and any hit " +
            "against a surprised creature is a critical hit.",
    ),
    ClassFeature(
        id = "ASSASSIN_INFILTRATION_EXPERTISE",
        name = "Infiltration Expertise",
        level = 9,
        summary =
        "Spend seven days and 25 gp to build a reliable false identity (history, profession, contacts and " +
            "documents). It can't be the identity of someone who already exists.",
    ),
    ClassFeature(
        id = "ASSASSIN_IMPOSTOR",
        name = "Impostor",
        level = 13,
        summary =
        "After three hours studying a person, you imitate their speech, handwriting and behavior well enough to fool " +
            "casual observers; you have advantage on Charisma (Deception) checks against wary creatures to avoid " +
            "detection.",
    ),
    ClassFeature(
        id = "ASSASSIN_DEATH_STRIKE",
        name = "Death Strike",
        level = 17,
        summary =
        "When you hit a surprised creature, it makes a Constitution save (DC 8 + Dexterity modifier + proficiency " +
            "bonus); on a failure the attack deals double damage.",
    ),
)

internal val ARCANE_TRICKSTER_FEATURES = listOf(
    ClassFeature(
        id = "ARCANE_TRICKSTER_SPELLCASTING",
        name = "Spellcasting",
        level = 3,
        summary =
        "Known-spells third caster with Intelligence, from the wizard list: mage hand plus two other cantrips (one " +
            "more at 10th level) and spells mostly of enchantment and illusion, with a few from any school. You " +
            "learn spells as you level up and can swap one each level. Slots recover on a long rest.",
    ),
    ClassFeature(
        id = "ARCANE_TRICKSTER_MAGE_HAND_LEGERDEMAIN",
        name = "Mage Hand Legerdemain",
        level = 3,
        summary =
        "Your mage hand is invisible and can stow or take an object from a container another creature wears or " +
            "carries, and pick locks or disarm traps with thieves' tools at range. Doing it unnoticed takes a " +
            "Dexterity (Sleight of Hand) check against the creature's Wisdom (Perception). You can control the hand " +
            "with your Cunning Action bonus action.",
    ),
    ClassFeature(
        id = "ARCANE_TRICKSTER_MAGICAL_AMBUSH",
        name = "Magical Ambush",
        level = 9,
        summary =
        "If you are hidden from a creature when you cast a spell on it, it has disadvantage on its saves against " +
            "that spell this turn.",
    ),
    ClassFeature(
        id = "ARCANE_TRICKSTER_VERSATILE_TRICKSTER",
        name = "Versatile Trickster",
        level = 13,
        summary =
        "Bonus action: pick a creature within 5 ft of your mage hand; you have advantage on attack rolls against it " +
            "until the end of the turn.",
    ),
    ClassFeature(
        id = "ARCANE_TRICKSTER_SPELL_THIEF",
        name = "Spell Thief",
        level = 17,
        summary =
        "Reaction when a creature casts a spell that targets you or includes you in its area: it makes a save with " +
            "its spellcasting ability against your spell save DC. On a failure the spell has no effect on you and, " +
            "if it is of 1st level or higher and of a level you can cast, you steal it: you know it and can cast it " +
            "with your slots for 8 hours, and the creature can't cast it during that time. Once per long rest.",
    ),
)
