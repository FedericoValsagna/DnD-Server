package com.valsagnapps.dndapp.domain

import com.valsagnapps.dndapp.domain.CharacterClass.BARBARIAN
import com.valsagnapps.dndapp.domain.CharacterClass.BARD
import com.valsagnapps.dndapp.domain.CharacterClass.CLERIC
import com.valsagnapps.dndapp.domain.CharacterClass.FIGHTER
import com.valsagnapps.dndapp.domain.CharacterClass.MONK
import com.valsagnapps.dndapp.domain.CharacterClass.PALADIN
import com.valsagnapps.dndapp.domain.CharacterClass.WIZARD
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

class CharacterResourcesTest {
    private fun Character.resource(resource: Resource): CharacterResource? = resources.find { it.resource == resource }

    @ParameterizedTest
    @CsvSource("1, 2", "2, 2", "3, 3", "6, 4", "12, 5", "17, 6")
    fun `barbarian rages grow with the level`(level: Int, rages: Int) {
        val rage = character(characterClass = BARBARIAN, level = level).resource(Resource.RAGE)

        assertEquals(CharacterResource(Resource.RAGE, max = rages, used = 0, recharge = Recharge.LONG_REST), rage)
    }

    @Test
    fun `a 20th level barbarian rages without limit, so rage is not tracked`() {
        assertNull(character(characterClass = BARBARIAN, level = 20).resource(Resource.RAGE))
    }

    @ParameterizedTest
    @CsvSource("16, 3", "10, 1", "8, 1")
    fun `bardic inspiration uses the charisma modifier with a minimum of 1`(charisma: Int, uses: Int) {
        val bard = character(characterClass = BARD, abilityScores = abilityScores(charisma = charisma))

        assertEquals(uses, bard.resource(Resource.BARDIC_INSPIRATION)?.max)
    }

    @ParameterizedTest
    @CsvSource("4, LONG_REST", "5, SHORT_REST")
    fun `bardic inspiration recharges on a short rest from font of inspiration`(level: Int, recharge: Recharge) {
        assertEquals(
            recharge,
            character(characterClass = BARD, level = level).resource(Resource.BARDIC_INSPIRATION)?.recharge,
        )
    }

    @ParameterizedTest
    @CsvSource("1, 0", "2, 1", "6, 2", "18, 3")
    fun `cleric channel divinity grows with the level`(level: Int, uses: Int) {
        val channelDivinity = character(characterClass = CLERIC, level = level).resource(Resource.CHANNEL_DIVINITY)

        assertEquals(uses, channelDivinity?.max ?: 0)
    }

    @Test
    fun `a cleric paladin shares channel divinity and keeps the larger maximum`() {
        val multiclass = character(classes = listOf(ClassLevel(CLERIC, 6), ClassLevel(PALADIN, 3)))

        assertEquals(
            listOf(CharacterResource(Resource.CHANNEL_DIVINITY, max = 2, used = 0, recharge = Recharge.SHORT_REST)),
            multiclass.resources.filter { it.resource == Resource.CHANNEL_DIVINITY },
        )
    }

    @Test
    fun `paladin pools scale with the level and charisma`() {
        val paladin = character(characterClass = PALADIN, level = 4, abilityScores = abilityScores(charisma = 16))

        assertEquals(20, paladin.resource(Resource.LAY_ON_HANDS)?.max)
        assertEquals(4, paladin.resource(Resource.DIVINE_SENSE)?.max)
        assertEquals(1, paladin.resource(Resource.CHANNEL_DIVINITY)?.max)
    }

    @Test
    fun `monks get one ki point per level from 2nd level`() {
        assertNull(character(characterClass = MONK, level = 1).resource(Resource.KI))
        assertEquals(
            CharacterResource(Resource.KI, max = 7, used = 0, recharge = Recharge.SHORT_REST),
            character(characterClass = MONK, level = 7).resource(Resource.KI),
        )
    }

    @Test
    fun `subclass resources come only with the subclass`() {
        val fighter = character(classes = listOf(ClassLevel(FIGHTER, 7)))
        val battleMaster = character(classes = listOf(ClassLevel(FIGHTER, 7, Subclass.BATTLE_MASTER)))

        assertEquals(listOf(Resource.SECOND_WIND, Resource.ACTION_SURGE), fighter.resources.map { it.resource })
        assertEquals(5, battleMaster.resource(Resource.SUPERIORITY_DICE)?.max)
    }

    @Test
    fun `the arcane ward is twice the wizard level plus intelligence`() {
        val abjurer = character(
            classes = listOf(ClassLevel(WIZARD, 6, Subclass.ABJURATION)),
            abilityScores = abilityScores(intelligence = 18),
        )

        assertEquals(16, abjurer.resource(Resource.ARCANE_WARD)?.max)
    }

    @Test
    fun `marking used uses keeps the rest`() {
        val monk = character(characterClass = MONK, level = 5).withResourceUsed(Resource.KI, 3)

        assertEquals(3, monk.resource(Resource.KI)?.used)
        assertEquals(2, monk.resource(Resource.KI)?.remaining)
        assertEquals(0, monk.withResourceUsed(Resource.KI, 0).resource(Resource.KI)?.used)
    }

    @ParameterizedTest
    @CsvSource("-1", "6")
    fun `used uses must be between 0 and the maximum`(used: Int) {
        val monk = character(characterClass = MONK, level = 5)

        assertFailsWith<IllegalArgumentException> { monk.withResourceUsed(Resource.KI, used) }
    }

    @Test
    fun `a character can't use a resource it doesn't have`() {
        assertFailsWith<IllegalArgumentException> { character().withResourceUsed(Resource.KI, 1) }
    }

    @Test
    fun `used uses are capped when the maximum goes down`() {
        val monk = character(characterClass = MONK, level = 10).withResourceUsed(Resource.KI, 8)

        assertEquals(5, monk.withClasses(listOf(ClassLevel(MONK, 5))).resource(Resource.KI)?.used)
    }

    @Test
    fun `used uses can't be negative`() {
        assertFailsWith<IllegalArgumentException> { character(resourcesUsed = mapOf(Resource.KI to -1)) }
    }
}
