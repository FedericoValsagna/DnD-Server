package com.valsagnapps.dndapp.domain.features

import com.valsagnapps.dndapp.domain.ActionType
import com.valsagnapps.dndapp.domain.ClassFeature
import com.valsagnapps.dndapp.domain.Recharge
import com.valsagnapps.dndapp.domain.Resource
import com.valsagnapps.dndapp.domain.Uses
import com.valsagnapps.dndapp.domain.atLevel

// Druid y sus círculos. Druid y Circle of the Land son SRD: llevan el texto del SRD 5.1 además del resumen propio.
internal val DRUID_FEATURES = listOf(
    ClassFeature(
        id = "DRUID_DRUIDIC",
        name = "Druidic",
        level = 1,
        summary =
        "You know Druidic, the secret language of druids, and can leave hidden messages in it. Others need a DC 15 " +
            "Wisdom (Perception) check to notice them and magic to read them.",
        srdText =
        "You know Druidic, the secret language of druids. You can speak the language and use it to leave hidden " +
            "messages. You and others who know this language automatically spot such a message. Others spot the " +
            "message's presence with a successful DC 15 Wisdom (Perception) check but can't decipher it without " +
            "magic.",
    ),
    ClassFeature(
        id = "DRUID_SPELLCASTING",
        name = "Spellcasting",
        level = 1,
        summary =
        "Prepared caster with Wisdom: after a long rest, prepare Wisdom modifier + druid level spells from the druid " +
            "list. Slots recover on a long rest. Prepared ritual spells can be cast as rituals, and a druidic focus " +
            "works as spellcasting focus.",
        srdText =
        "Drawing on the divine essence of nature itself, you can cast spells to shape that essence to your " +
            "will.\n\nCantrips. At 1st level, you know two cantrips of your choice from the druid spell list. You " +
            "learn additional druid cantrips of your choice at higher levels, as shown in the Cantrips Known column " +
            "of the Druid table.\n\nPreparing and Casting Spells. The Druid table shows how many spell slots you " +
            "have to cast your spells of 1st level and higher. To cast one of these druid spells, you must expend a " +
            "slot of the spell's level or higher. You regain all expended spell slots when you finish a long " +
            "rest.\n\nYou prepare the list of druid spells that are available for you to cast, choosing from the " +
            "druid spell list. When you do so, choose a number of druid spells equal to your Wisdom modifier + your " +
            "druid level (minimum of one spell). The spells must be of a level for which you have spell " +
            "slots.\n\nFor example, if you are a 3rd-level druid, you have four 1st-level and two 2nd-level spell " +
            "slots. With a Wisdom of 16, your list of prepared spells can include six spells of 1st or 2nd level, in " +
            "any combination. If you prepare the 1st-level spell cure wounds, you can cast it using a 1st-level or " +
            "2nd-level slot. Casting the spell doesn't remove it from your list of prepared spells.\n\nYou can also " +
            "change your list of prepared spells when you finish a long rest. Preparing a new list of druid spells " +
            "requires time spent in prayer and meditation: at least 1 minute per spell level for each spell on your " +
            "list.\n\nSpellcasting Ability. Wisdom is your spellcasting ability for your druid spells, since your " +
            "magic draws upon your devotion and attunement to nature. You use your Wisdom whenever a spell refers to " +
            "your spellcasting ability. In addition, you use your Wisdom modifier when setting the saving throw DC " +
            "for a druid spell you cast and when making an attack roll with one.\n\nSpell save DC = 8 + your " +
            "proficiency bonus + your Wisdom modifier.\n\nSpell attack modifier = your proficiency bonus + your " +
            "Wisdom modifier.\n\nRitual Casting. You can cast a druid spell as a ritual if that spell has the ritual " +
            "tag and you have the spell prepared.\n\nSpellcasting Focus. You can use a druidic focus (see chapter 5, " +
            "\"Equipment\") as a spellcasting focus for your druid spells.",
    ),
    ClassFeature(
        id = "DRUID_WILD_SHAPE",
        name = "Wild Shape",
        level = 2,
        summary =
        "Action: turn into a beast you have seen, for up to half your druid level in hours. Two uses per short or " +
            "long rest. Maximum CR 1/4 without flying or swimming speed at 2nd level, 1/2 without flying speed at " +
            "4th and 1 at 8th. You keep your mental scores and proficiencies, take the beast's hit points and can't " +
            "cast spells.",
        srdText =
        "Starting at 2nd level, you can use your action to magically assume the shape of a beast that you have seen " +
            "before. You can use this feature twice. You regain expended uses when you finish a short or long " +
            "rest.\n\nYour druid level determines the beasts you can transform into, as shown in the Beast Shapes " +
            "table. At 2nd level, for example, you can transform into any beast that has a challenge rating of 1/4 " +
            "or lower that doesn't have a flying or swimming speed.\n\nYou can stay in a beast shape for a number of " +
            "hours equal to half your druid level (rounded down). You then revert to your normal form unless you " +
            "expend another use of this feature. You can revert to your normal form earlier by using a bonus action " +
            "on your turn. You automatically revert if you fall unconscious, drop to 0 hit points, or die.\n\nWhile " +
            "you are transformed, the following rules apply:\n\n- Your game statistics are replaced by the " +
            "statistics of the beast, but you retain your alignment, personality, and Intelligence, Wisdom, and " +
            "Charisma scores. You also retain all of your skill and saving throw proficiencies, in addition to " +
            "gaining those of the creature. If the creature has the same proficiency as you and the bonus in its " +
            "stat block is higher than yours, use the creature's bonus instead of yours. If the creature has any " +
            "legendary or lair actions, you can't use them.\n\n- When you transform, you assume the beast's hit " +
            "points and Hit Dice. When you revert to your normal form, you return to the number of hit points you " +
            "had before you transformed. However, if you revert as a result of dropping to 0 hit points, any excess " +
            "damage carries over to your normal form. For example, if you take 10 damage in animal form and have " +
            "only 1 hit point left, you revert and take 9 damage. As long as the excess damage doesn't reduce your " +
            "normal form to 0 hit points, you aren't knocked unconscious.\n\n- You can't cast spells, and your " +
            "ability to speak or take any action that requires hands is limited to the capabilities of your beast " +
            "form. Transforming doesn't break your concentration on a spell you've already cast, however, or prevent " +
            "you from taking actions that are part of a spell, such as call lightning, that you've already " +
            "cast.\n\n- You retain the benefit of any features from your class, race, or other source and can use " +
            "them if the new form is physically capable of doing so. However, you can't use any of your special " +
            "senses, such as darkvision, unless your new form also has that sense.\n\n- You choose whether your " +
            "equipment falls to the ground in your space, merges into your new form, or is worn by it. Worn " +
            "equipment functions as normal, but the GM decides whether it is practical for the new form to wear a " +
            "piece of equipment, based on the creature's shape and size. Your equipment doesn't change size or shape " +
            "to match the new form, and any equipment that the new form can't wear must either fall to the ground or " +
            "merge with it. Equipment that merges with the form has no effect until you leave the form.\n\nBeast " +
            "Shapes: 2nd level: CR 1/4 or below, no flying or swim speed; 4th level: CR 1/2 or below, no flying " +
            "speed; 8th level: CR 1 or below.",
        actionType = ActionType.ACTION,
        resource = Resource.WILD_SHAPE,
        uses = Uses.byLevel(
            Recharge.SHORT_REST,
            atLevel(level = 2, uses = 2),
            atLevel(level = 20, uses = null),
        ),
    ),
    ClassFeature(
        id = "DRUID_ABILITY_SCORE_IMPROVEMENT",
        name = "Ability Score Improvement",
        level = 4,
        summary = "At 4th, 8th, 12th, 16th and 19th level: +2 to one ability score or +1 to two (maximum 20).",
        srdText =
        "When you reach 4th level, and again at 8th, 12th, 16th, and 19th level, you can increase one ability score " +
            "of your choice by 2, or you can increase two ability scores of your choice by 1. As normal, you can't " +
            "increase an ability score above 20 using this feature.",
    ),
    ClassFeature(
        id = "DRUID_TIMELESS_BODY",
        name = "Timeless Body",
        level = 18,
        summary = "You age only 1 year for every 10 that pass.",
        srdText =
        "Starting at 18th level, the primal magic that you wield causes you to age more slowly. For every 10 years " +
            "that pass, your body ages only 1 year.",
    ),
    ClassFeature(
        id = "DRUID_BEAST_SPELLS",
        name = "Beast Spells",
        level = 18,
        summary = "You can cast druid spells in Wild Shape, with verbal and somatic components but no material ones.",
        srdText =
        "Beginning at 18th level, you can cast many of your druid spells in any shape you assume using Wild Shape. " +
            "You can perform the somatic and verbal components of a druid spell while in a beast shape, but you " +
            "aren't able to provide material components.",
    ),
    ClassFeature(
        id = "DRUID_ARCHDRUID",
        name = "Archdruid",
        level = 20,
        summary =
        "Unlimited Wild Shape, and you ignore verbal, somatic and costless non-consumed material components of your " +
            "druid spells, in any shape.",
        srdText =
        "At 20th level, you can use your Wild Shape an unlimited number of times.\n\nAdditionally, you can ignore " +
            "the verbal and somatic components of your druid spells, as well as any material components that lack a " +
            "cost and aren't consumed by a spell. You gain this benefit in both your normal shape and your beast " +
            "shape from Wild Shape.",
    ),
)

internal val LAND_FEATURES = listOf(
    ClassFeature(
        id = "LAND_BONUS_CANTRIP",
        name = "Bonus Cantrip",
        level = 2,
        summary = "Learn one extra druid cantrip.",
        srdText = "When you choose this circle at 2nd level, you learn one additional druid cantrip of your choice.",
    ),
    ClassFeature(
        id = "LAND_NATURAL_RECOVERY",
        name = "Natural Recovery",
        level = 2,
        summary =
        "Once per long rest, during a short rest, recover expended spell slots with a combined level up to half your " +
            "druid level (rounded up), none of 6th level or higher.",
        srdText =
        "Starting at 2nd level, you can regain some of your magical energy by sitting in meditation and communing " +
            "with nature. During a short rest, you choose expended spell slots to recover. The spell slots can have " +
            "a combined level that is equal to or less than half your druid level (rounded up), and none of the " +
            "slots can be 6th level or higher. You can't use this feature again until you finish a long rest.\n\nFor " +
            "example, when you are a 4th-level druid, you can recover up to two levels worth of spell slots. You can " +
            "recover either a 2nd-level slot or two 1st-level slots.",
        resource = Resource.NATURAL_RECOVERY,
        uses = Uses.fixed(count = 1, recharge = Recharge.LONG_REST),
    ),
    ClassFeature(
        id = "LAND_LANDS_STRIDE",
        name = "Land's Stride",
        level = 6,
        summary =
        "Nonmagical difficult terrain and plants don't slow or hurt you, and you have advantage on saves against " +
            "magical plants that impede movement.",
        srdText =
        "Starting at 6th level, moving through nonmagical difficult terrain costs you no extra movement. You can " +
            "also pass through nonmagical plants without being slowed by them and without taking damage from them if " +
            "they have thorns, spines, or a similar hazard.\n\nIn addition, you have advantage on saving throws " +
            "against plants that are magically created or manipulated to impede movement, such those created by the " +
            "entangle spell.",
    ),
    ClassFeature(
        id = "LAND_NATURES_WARD",
        name = "Nature's Ward",
        level = 10,
        summary = "Elementals and fey can't charm or frighten you, and you are immune to poison and disease.",
        srdText =
        "When you reach 10th level, you can't be charmed or frightened by elementals or fey, and you are immune to " +
            "poison and disease.",
    ),
    ClassFeature(
        id = "LAND_NATURES_SANCTUARY",
        name = "Nature's Sanctuary",
        level = 14,
        summary =
        "A beast or plant that attacks you makes a Wisdom save against your spell save DC or must pick another " +
            "target (or miss). On a success it is immune for 24 hours.",
        srdText =
        "When you reach 14th level, creatures of the natural world sense your connection to nature and become " +
            "hesitant to attack you. When a beast or plant creature attacks you, that creature must make a Wisdom " +
            "saving throw against your druid spell save DC. On a failed save, the creature must choose a different " +
            "target, or the attack automatically misses. On a successful save, the creature is immune to this effect " +
            "for 24 hours. The creature is aware of this effect before it makes its attack against you.",
    ),
)

// Circle of the Moon no es SRD: solo resúmenes propios.
internal val MOON_FEATURES = listOf(
    ClassFeature(
        id = "MOON_COMBAT_WILD_SHAPE",
        name = "Combat Wild Shape",
        level = 2,
        summary =
        "Use Wild Shape as a bonus action. While transformed, bonus action: expend a spell slot to regain 1d8 hit " +
            "points per slot level.",
        actionType = ActionType.BONUS_ACTION,
        resource = Resource.WILD_SHAPE,
    ),
    ClassFeature(
        id = "MOON_CIRCLE_FORMS",
        name = "Circle Forms",
        level = 2,
        summary =
        "Wild Shape into beasts of CR up to 1, ignoring the CR limit of the Beast Shapes table (but not the movement " +
            "ones). From 6th level, up to your druid level divided by 3 (rounded down).",
    ),
    ClassFeature(
        id = "MOON_PRIMAL_STRIKE",
        name = "Primal Strike",
        level = 6,
        summary = "Your attacks in beast form count as magical for overcoming resistance and immunity.",
    ),
    ClassFeature(
        id = "MOON_ELEMENTAL_WILD_SHAPE",
        name = "Elemental Wild Shape",
        level = 10,
        summary = "Spend two uses of Wild Shape at once to turn into an air, earth, fire or water elemental.",
        resource = Resource.WILD_SHAPE,
    ),
    ClassFeature(
        id = "MOON_THOUSAND_FORMS",
        name = "Thousand Forms",
        level = 14,
        summary = "Cast alter self at will.",
    ),
)
