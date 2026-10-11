package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.ActionType
import com.valsagnapps.dndapp.domain.ClassFeature
import com.valsagnapps.dndapp.domain.Recharge
import com.valsagnapps.dndapp.domain.Resource
import com.valsagnapps.dndapp.domain.Uses
import com.valsagnapps.dndapp.domain.atLevel

// Barbarian y sus caminos. Barbarian y Path of the Berserker son SRD: llevan el texto del SRD 5.1 además del
// resumen propio.
internal val BARBARIAN_FEATURES = listOf(
    ClassFeature(
        id = "BARBARIAN_RAGE",
        name = "Rage",
        level = 1,
        summary =
        "Bonus action, without heavy armor: for 1 minute, advantage on Strength checks and saves, extra damage on " +
            "Strength melee weapon attacks (+2, +3 at 9th level, +4 at 16th) and resistance to bludgeoning, piercing " +
            "and slashing. No spellcasting while raging. Ends early if you don't attack or take damage in a turn. 2 " +
            "uses per long rest (3 at 3rd level, 4 at 6th, 5 at 12th, 6 at 17th).",
        srdText =
        "In battle, you fight with primal ferocity. On your turn, you can enter a rage as a bonus action. While " +
            "raging, you gain the following benefits if you aren't wearing heavy armor:\n\n- You have advantage on " +
            "Strength checks and Strength saving throws.\n\n- When you make a melee weapon attack using Strength, " +
            "you gain a +2 bonus to the damage roll. This bonus increases as you level.\n\n- You have resistance to " +
            "bludgeoning, piercing, and slashing damage.\n\nIf you are able to cast spells, you can't cast them or " +
            "concentrate on them while raging.\n\nYour rage lasts for 1 minute. It ends early if you are knocked " +
            "unconscious or if your turn ends and you haven't attacked a hostile creature since your last turn or " +
            "taken damage since then. You can also end your rage on your turn as a bonus action.\n\nOnce you have " +
            "raged the maximum number of times for your barbarian level, you must finish a long rest before you can " +
            "rage again. You may rage 2 times at 1st level, 3 at 3rd, 4 at 6th, 5 at 12th, and 6 at 17th.\n\nRage " +
            "damage: +2 at 1st level, +3 at 9th level, +4 at 16th level.",
        actionType = ActionType.BONUS_ACTION,
        resource = Resource.RAGE,
        uses = Uses.byLevel(
            Recharge.LONG_REST,
            atLevel(level = 1, uses = 2),
            atLevel(level = 3, uses = 3),
            atLevel(level = 6, uses = 4),
            atLevel(level = 12, uses = 5),
            atLevel(level = 17, uses = 6),
            atLevel(level = 20, uses = null),
        ),
    ),
    ClassFeature(
        id = "BARBARIAN_UNARMORED_DEFENSE",
        name = "Unarmored Defense",
        level = 1,
        summary = "Without armor, your AC is 10 + Dexterity modifier + Constitution modifier. You can use a shield.",
        srdText =
        "While you are not wearing any armor, your Armor Class equals 10 + your Dexterity modifier + your " +
            "Constitution modifier. You can use a shield and still gain this benefit.",
    ),
    ClassFeature(
        id = "BARBARIAN_RECKLESS_ATTACK",
        name = "Reckless Attack",
        level = 2,
        summary =
        "On your first attack of the turn, gain advantage on Strength melee weapon attacks this turn; attacks " +
            "against you have advantage until your next turn.",
        srdText =
        "Starting at 2nd level, you can throw aside all concern for defense to attack with fierce desperation. When " +
            "you make your first attack on your turn, you can decide to attack recklessly. Doing so gives you " +
            "advantage on melee weapon attack rolls using Strength during this turn, but attack rolls against you " +
            "have advantage until your next turn.",
    ),
    ClassFeature(
        id = "BARBARIAN_DANGER_SENSE",
        name = "Danger Sense",
        level = 2,
        summary =
        "Advantage on Dexterity saves against effects you can see, unless blinded, deafened or incapacitated.",
        srdText =
        "At 2nd level, you gain an uncanny sense of when things nearby aren't as they should be, giving you an edge " +
            "when you dodge away from danger. You have advantage on Dexterity saving throws against effects that you " +
            "can see, such as traps and spells. To gain this benefit, you can't be blinded, deafened, or " +
            "incapacitated.",
    ),
    ClassFeature(
        id = "BARBARIAN_ABILITY_SCORE_IMPROVEMENT",
        name = "Ability Score Improvement",
        level = 4,
        summary = "At 4th, 8th, 12th, 16th and 19th level: +2 to one ability score or +1 to two (maximum 20).",
        srdText =
        "When you reach 4th level, and again at 8th, 12th, 16th, and 19th level, you can increase one ability score " +
            "of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you can't " +
            "increase an ability score above 20 using this feature.",
    ),
    ClassFeature(
        id = "BARBARIAN_EXTRA_ATTACK",
        name = "Extra Attack",
        level = 5,
        summary = "Attack twice when you take the Attack action.",
        srdText =
        "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack action on your " +
            "turn.",
    ),
    ClassFeature(
        id = "BARBARIAN_FAST_MOVEMENT",
        name = "Fast Movement",
        level = 5,
        summary = "+10 ft of speed while not wearing heavy armor.",
        srdText = "Starting at 5th level, your speed increases by 10 feet while you aren't wearing heavy armor.",
    ),
    ClassFeature(
        id = "BARBARIAN_FERAL_INSTINCT",
        name = "Feral Instinct",
        level = 7,
        summary =
        "Advantage on initiative. If surprised, you can act on your first turn if you rage before anything else.",
        srdText =
        "By 7th level, your instincts are so honed that you have advantage on initiative rolls.\n\nAdditionally, if " +
            "you are surprised at the beginning of combat and aren't incapacitated, you can act normally on your " +
            "first turn, but only if you enter your rage before doing anything else on that turn.",
    ),
    ClassFeature(
        id = "BARBARIAN_BRUTAL_CRITICAL",
        name = "Brutal Critical",
        level = 9,
        summary = "Roll one extra weapon damage die on melee critical hits (two at 13th level, three at 17th).",
        srdText =
        "Beginning at 9th level, you can roll one additional weapon damage die when determining the extra damage for " +
            "a critical hit with a melee attack. This increases to two additional dice at 13th level and three " +
            "additional dice at 17th level.",
    ),
    ClassFeature(
        id = "BARBARIAN_RELENTLESS_RAGE",
        name = "Relentless Rage",
        level = 11,
        summary =
        "When you drop to 0 hit points while raging, a DC 10 Constitution save leaves you at 1 instead. The DC rises " +
            "by 5 per use and resets on a short or long rest.",
        srdText =
        "Starting at 11th level, your rage can keep you fighting despite grievous wounds. If you drop to 0 hit " +
            "points while you're raging and don't die outright, you can make a DC 10 Constitution saving throw. If " +
            "you succeed, you drop to 1 hit point instead.\n\nEach time you use this feature after the first, the DC " +
            "increases by 5. When you finish a short or long rest, the DC resets to 10.",
    ),
    ClassFeature(
        id = "BARBARIAN_PERSISTENT_RAGE",
        name = "Persistent Rage",
        level = 15,
        summary = "Your rage only ends early if you fall unconscious or choose to end it.",
        srdText =
        "Beginning at 15th level, your rage is so fierce that it ends early only if you fall unconscious or if you " +
            "choose to end it.",
    ),
    ClassFeature(
        id = "BARBARIAN_INDOMITABLE_MIGHT",
        name = "Indomitable Might",
        level = 18,
        summary = "If a Strength check totals less than your Strength score, use the score instead.",
        srdText =
        "Beginning at 18th level, if your total for a Strength check is less than your Strength score, you can use " +
            "that score in place of the total.",
    ),
    ClassFeature(
        id = "BARBARIAN_PRIMAL_CHAMPION",
        name = "Primal Champion",
        level = 20,
        summary = "Strength and Constitution increase by 4, with a maximum of 24.",
        srdText =
        "At 20th level, you embody the power of the wilds. Your Strength and Constitution scores increase by 4. Your " +
            "maximum for those scores is now 24.",
    ),
)

internal val BERSERKER_FEATURES = listOf(
    ClassFeature(
        id = "BERSERKER_FRENZY",
        name = "Frenzy",
        level = 3,
        summary =
        "When you rage you can frenzy: a melee weapon attack as a bonus action on each later turn of the rage, and " +
            "one level of exhaustion when it ends.",
        srdText =
        "Starting when you choose this path at 3rd level, you can go into a frenzy when you rage. If you do so, for " +
            "the duration of your rage you can make a single melee weapon attack as a bonus action on each of your " +
            "turns after this one. When your rage ends, you suffer one level of exhaustion (as described in appendix " +
            "A).",
        actionType = ActionType.BONUS_ACTION,
    ),
    ClassFeature(
        id = "BERSERKER_MINDLESS_RAGE",
        name = "Mindless Rage",
        level = 6,
        summary = "You can't be charmed or frightened while raging; those effects are suspended during the rage.",
        srdText =
        "Beginning at 6th level, you can't be charmed or frightened while raging. If you are charmed or frightened " +
            "when you enter your rage, the effect is suspended for the duration of the rage.",
    ),
    ClassFeature(
        id = "BERSERKER_INTIMIDATING_PRESENCE",
        name = "Intimidating Presence",
        level = 10,
        summary =
        "Action: a creature within 30 ft that can see or hear you makes a Wisdom save (DC 8 + proficiency bonus + " +
            "Charisma modifier) or is frightened until the end of your next turn; extend it with your action each " +
            "turn. On a success, it is immune for 24 hours.",
        srdText =
        "Beginning at 10th level, you can use your action to frighten someone with your menacing presence. When you " +
            "do so, choose one creature that you can see within 30 feet of you. If the creature can see or hear you, " +
            "it must succeed on a Wisdom saving throw (DC equal to 8 + your proficiency bonus + your Charisma " +
            "modifier) or be frightened of you until the end of your next turn. On subsequent turns, you can use " +
            "your action to extend the duration of this effect on the frightened creature until the end of your next " +
            "turn. This effect ends if the creature ends its turn out of line of sight or more than 60 feet away " +
            "from you.\n\nIf the creature succeeds on its saving throw, you can't use this feature on that creature " +
            "again for 24 hours.",
        actionType = ActionType.ACTION,
    ),
    ClassFeature(
        id = "BERSERKER_RETALIATION",
        name = "Retaliation",
        level = 14,
        summary = "Reaction: when a creature within 5 ft damages you, make a melee weapon attack against it.",
        srdText =
        "Starting at 14th level, when you take damage from a creature that is within 5 feet of you, you can use your " +
            "reaction to make a melee weapon attack against that creature.",
        actionType = ActionType.REACTION,
    ),
)

// Path of the Totem Warrior no es SRD: solo resúmenes propios.
internal val TOTEM_WARRIOR_FEATURES = listOf(
    ClassFeature(
        id = "TOTEM_WARRIOR_SPIRIT_SEEKER",
        name = "Spirit Seeker",
        level = 3,
        summary = "Cast beast sense and speak with animals as rituals.",
    ),
    ClassFeature(
        id = "TOTEM_WARRIOR_TOTEM_SPIRIT",
        name = "Totem Spirit",
        level = 3,
        summary =
        "Choose a totem animal, which grants a benefit while raging. Bear: resistance to all damage except psychic. " +
            "Eagle: without heavy armor, opportunity attacks against you have disadvantage and you can Dash as a " +
            "bonus action. Wolf: your friends have advantage on melee attacks against hostile creatures within 5 ft " +
            "of you.",
    ),
    ClassFeature(
        id = "TOTEM_WARRIOR_ASPECT_OF_THE_BEAST",
        name = "Aspect of the Beast",
        level = 6,
        summary =
        "Choose a totem animal (it can differ from the earlier one). Bear: double carrying capacity and advantage on " +
            "Strength checks to push, pull, lift or break. Eagle: see up to 1 mile clearly, and dim light doesn't " +
            "hinder your Wisdom (Perception) checks. Wolf: track creatures at a fast pace and move stealthily at a " +
            "normal pace.",
    ),
    ClassFeature(
        id = "TOTEM_WARRIOR_SPIRIT_WALKER",
        name = "Spirit Walker",
        level = 10,
        summary = "Cast commune with nature as a ritual.",
    ),
    ClassFeature(
        id = "TOTEM_WARRIOR_TOTEMIC_ATTUNEMENT",
        name = "Totemic Attunement",
        level = 14,
        summary =
        "Choose a totem animal for a benefit while raging. Bear: hostile creatures within 5 ft that can see or hear " +
            "you have disadvantage on attacks against anyone but you (unless they can't be frightened). Eagle: " +
            "flying speed equal to your walking speed, but you fall if you end your turn in the air. Wolf: bonus " +
            "action to knock prone a Large or smaller creature you hit with a melee weapon attack.",
    ),
)
