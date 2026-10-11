package com.valsagnapps.dndapp.domain

import com.valsagnapps.dndapp.domain.CharacterClass.BARBARIAN
import com.valsagnapps.dndapp.domain.CharacterClass.BARD
import com.valsagnapps.dndapp.domain.CharacterClass.CLERIC
import com.valsagnapps.dndapp.domain.CharacterClass.DRUID
import com.valsagnapps.dndapp.domain.CharacterClass.FIGHTER
import com.valsagnapps.dndapp.domain.CharacterClass.MONK
import com.valsagnapps.dndapp.domain.CharacterClass.PALADIN
import com.valsagnapps.dndapp.domain.CharacterClass.RANGER
import com.valsagnapps.dndapp.domain.CharacterClass.ROGUE
import com.valsagnapps.dndapp.domain.CharacterClass.SORCERER
import com.valsagnapps.dndapp.domain.CharacterClass.WARLOCK
import com.valsagnapps.dndapp.domain.CharacterClass.WIZARD
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ClassFeatureTest {
    private val allFeatures =
        CharacterClass.entries.flatMap { it.features } + Subclass.entries.flatMap { it.features }

    @Test
    fun `feature ids are unique across classes and subclasses`() {
        assertEquals(allFeatures.size, allFeatures.map { it.id }.toSet().size)
    }

    @Test
    fun `every feature has a name, a summary and a level between 1 and 20`() {
        allFeatures.forEach {
            assertTrue(it.name.isNotBlank() && it.summary.isNotBlank(), it.id)
            assertTrue(it.level in Character.MIN_LEVEL..Character.MAX_LEVEL, it.id)
            assertTrue(it.srdText?.isNotBlank() ?: true, it.id)
        }
    }

    @ParameterizedTest
    @EnumSource(CharacterClass::class)
    fun `class features are sorted by level and prefixed with the class`(characterClass: CharacterClass) {
        val features = characterClass.features

        assertEquals(features.sortedBy { it.level }, features)
        assertTrue(features.all { it.id.startsWith("${characterClass}_") })
    }

    @ParameterizedTest
    @EnumSource(Subclass::class)
    fun `subclass features start at the subclass level and are prefixed with the subclass`(subclass: Subclass) {
        val features = subclass.features

        assertEquals(features.sortedBy { it.level }, features)
        assertTrue(features.all { it.level >= subclass.characterClass.subclassLevel })
        assertTrue(features.all { it.id.startsWith("${subclass}_") })
    }

    @Test
    fun `cleric and ranger have their features loaded`() {
        assertEquals(6, CLERIC.features.size)
        assertEquals(12, RANGER.features.size)
        assertEquals(6, Subclass.LIFE.features.size)
        assertEquals(6, Subclass.NATURE.features.size)
        assertEquals(5, Subclass.KNOWLEDGE.features.size)
        assertEquals(6, Subclass.LIGHT.features.size)
        assertEquals(6, Subclass.TEMPEST.features.size)
        assertEquals(5, Subclass.TRICKERY.features.size)
        assertEquals(6, Subclass.WAR.features.size)
        assertEquals(4, Subclass.HUNTER.features.size)
        assertEquals(4, Subclass.BEAST_MASTER.features.size)
    }

    @Test
    fun `paladin and its oaths have their features loaded`() {
        assertEquals(13, PALADIN.features.size)
        assertEquals(5, Subclass.DEVOTION.features.size)
        assertEquals(5, Subclass.ANCIENTS.features.size)
        assertEquals(5, Subclass.VENGEANCE.features.size)
    }

    @Test
    fun `sorcerer and its origins have their features loaded`() {
        assertEquals(5, SORCERER.features.size)
        assertEquals(5, Subclass.DRACONIC_BLOODLINE.features.size)
        assertEquals(5, Subclass.WILD_MAGIC.features.size)
    }

    @Test
    fun `wizard and its schools have their features loaded`() {
        assertEquals(5, WIZARD.features.size)
        Subclass.entries.filter { it.characterClass == WIZARD }.forEach {
            assertEquals(5, it.features.size, it.name)
        }
    }

    @Test
    fun `druid and its circles have their features loaded`() {
        assertEquals(7, DRUID.features.size)
        assertEquals(5, Subclass.LAND.features.size)
        assertEquals(5, Subclass.MOON.features.size)
    }

    @Test
    fun `monk and its traditions have their features loaded`() {
        assertEquals(21, MONK.features.size)
        assertEquals(4, Subclass.OPEN_HAND.features.size)
        assertEquals(4, Subclass.SHADOW.features.size)
        assertEquals(1, Subclass.FOUR_ELEMENTS.features.size)
    }

    @Test
    fun `barbarian and its paths have their features loaded`() {
        assertEquals(13, BARBARIAN.features.size)
        assertEquals(4, Subclass.BERSERKER.features.size)
        assertEquals(5, Subclass.TOTEM_WARRIOR.features.size)
    }

    @Test
    fun `bard and its colleges have their features loaded`() {
        assertEquals(10, BARD.features.size)
        assertEquals(4, Subclass.LORE.features.size)
        assertEquals(4, Subclass.VALOR.features.size)
    }

    @Test
    fun `fighter and its archetypes have their features loaded`() {
        assertEquals(6, FIGHTER.features.size)
        assertEquals(5, Subclass.CHAMPION.features.size)
        assertEquals(5, Subclass.BATTLE_MASTER.features.size)
        assertEquals(6, Subclass.ELDRITCH_KNIGHT.features.size)
    }

    @Test
    fun `rogue and its archetypes have their features loaded`() {
        assertEquals(12, ROGUE.features.size)
        assertEquals(5, Subclass.THIEF.features.size)
        assertEquals(5, Subclass.ASSASSIN.features.size)
        assertEquals(5, Subclass.ARCANE_TRICKSTER.features.size)
    }

    @Test
    fun `warlock and its patrons have their features loaded`() {
        assertEquals(6, WARLOCK.features.size)
        assertEquals(4, Subclass.ARCHFEY.features.size)
        assertEquals(4, Subclass.FIEND.features.size)
        assertEquals(4, Subclass.GREAT_OLD_ONE.features.size)
    }

    @Test
    fun `every class and subclass has its features loaded`() {
        assertTrue(CharacterClass.entries.all { it.features.isNotEmpty() })
        assertTrue(Subclass.entries.all { it.features.isNotEmpty() })
    }

    @Test
    fun `a class level has the features of its class up to its level`() {
        val ids = ClassLevel(CLERIC, 4).features.map { it.id }

        assertEquals(
            listOf(
                "CLERIC_SPELLCASTING",
                "CLERIC_CHANNEL_DIVINITY",
                "CLERIC_TURN_UNDEAD",
                "CLERIC_ABILITY_SCORE_IMPROVEMENT",
            ),
            ids,
        )
    }

    @Test
    fun `a class level mixes in its subclass features by level`() {
        val ids = ClassLevel(CLERIC, 2, Subclass.LIFE).features.map { it.id }

        assertEquals(
            listOf(
                "CLERIC_SPELLCASTING",
                "LIFE_BONUS_PROFICIENCY",
                "LIFE_DISCIPLE_OF_LIFE",
                "CLERIC_CHANNEL_DIVINITY",
                "CLERIC_TURN_UNDEAD",
                "LIFE_PRESERVE_LIFE",
            ),
            ids,
        )
    }

    @Test
    fun `a class level at 20 has every feature of its class and subclass`() {
        val features = ClassLevel(RANGER, 20, Subclass.HUNTER).features

        assertEquals(RANGER.features.size + Subclass.HUNTER.features.size, features.size)
        assertEquals("RANGER_FOE_SLAYER", features.last().id)
    }

    @Test
    fun `features mark whether they come with the SRD text`() {
        assertTrue(allFeatures.all { it.source == Source.PHB })
        assertTrue(CLERIC.features.all { it.srdText != null })
        assertTrue(
            Subclass.entries
                .filter { it.characterClass == CLERIC && it != Subclass.LIFE }
                .all { domain -> domain.features.all { it.srdText == null } },
        )
        assertTrue((PALADIN.features + Subclass.DEVOTION.features).all { it.srdText != null })
        assertTrue((Subclass.ANCIENTS.features + Subclass.VENGEANCE.features).all { it.srdText == null })
        assertTrue((WIZARD.features + Subclass.EVOCATION.features).all { it.srdText != null })
        assertTrue((SORCERER.features + Subclass.DRACONIC_BLOODLINE.features).all { it.srdText != null })
        assertTrue(Subclass.WILD_MAGIC.features.all { it.srdText == null })
        assertTrue((DRUID.features + Subclass.LAND.features).all { it.srdText != null })
        assertTrue(Subclass.MOON.features.all { it.srdText == null })
        assertTrue((MONK.features + Subclass.OPEN_HAND.features).all { it.srdText != null })
        assertTrue((Subclass.SHADOW.features + Subclass.FOUR_ELEMENTS.features).all { it.srdText == null })
        assertTrue((FIGHTER.features + Subclass.CHAMPION.features).all { it.srdText != null })
        assertTrue((Subclass.BATTLE_MASTER.features + Subclass.ELDRITCH_KNIGHT.features).all { it.srdText == null })
        assertTrue((BARD.features + Subclass.LORE.features).all { it.srdText != null })
        assertTrue(Subclass.VALOR.features.all { it.srdText == null })
        assertTrue((BARBARIAN.features + Subclass.BERSERKER.features).all { it.srdText != null })
        assertTrue(Subclass.TOTEM_WARRIOR.features.all { it.srdText == null })
        assertTrue((RANGER.features + Subclass.HUNTER.features).all { it.srdText != null })
        assertTrue(Subclass.BEAST_MASTER.features.all { it.srdText == null })
        assertTrue((ROGUE.features + Subclass.THIEF.features).all { it.srdText != null })
        assertTrue((Subclass.ASSASSIN.features + Subclass.ARCANE_TRICKSTER.features).all { it.srdText == null })
        assertTrue((WARLOCK.features + Subclass.FIEND.features).all { it.srdText != null })
        assertTrue((Subclass.ARCHFEY.features + Subclass.GREAT_OLD_ONE.features).all { it.srdText == null })
        assertTrue(
            Subclass.entries
                .filter { it.characterClass == WIZARD && it != Subclass.EVOCATION }
                .all { school -> school.features.all { it.srdText == null } },
        )
    }
}
