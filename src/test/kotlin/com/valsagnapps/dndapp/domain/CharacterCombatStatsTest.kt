package com.valsagnapps.dndapp.domain

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CharacterCombatStatsTest {
    @Test
    fun `armor class is 10 plus dexterity`() {
        assertEquals(13, character(abilityScores = abilityScores(dexterity = 16)).armorClass)
    }

    @Test
    fun `barbarian unarmored defense adds constitution`() {
        val barbarian = character(
            characterClass = CharacterClass.BARBARIAN,
            abilityScores = abilityScores(dexterity = 14, constitution = 16),
        )

        assertEquals(15, barbarian.armorClass)
    }

    @Test
    fun `monk unarmored defense adds wisdom`() {
        val monk = character(
            characterClass = CharacterClass.MONK,
            abilityScores = abilityScores(dexterity = 16, wisdom = 14),
        )

        assertEquals(15, monk.armorClass)
    }

    @Test
    fun `unarmored defense never lowers the armor class`() {
        val barbarian = character(
            characterClass = CharacterClass.BARBARIAN,
            abilityScores = abilityScores(dexterity = 14, constitution = 8),
        )

        assertEquals(12, barbarian.armorClass)
    }

    @Test
    fun `with barbarian and monk levels the best unarmored defense wins`() {
        val character = character(
            classes = listOf(ClassLevel(CharacterClass.MONK, 3), ClassLevel(CharacterClass.BARBARIAN, 1)),
            abilityScores = abilityScores(dexterity = 14, constitution = 12, wisdom = 16),
        )

        assertEquals(15, character.armorClass)
    }

    @Test
    fun `draconic resilience is 13 plus dexterity`() {
        val sorcerer = character(
            classes = listOf(ClassLevel(CharacterClass.SORCERER, 1, Subclass.DRACONIC_BLOODLINE)),
            abilityScores = abilityScores(dexterity = 14),
        )

        assertEquals(15, sorcerer.armorClass)
    }

    @Test
    fun `the armor class override wins over the calculated one`() {
        val character = character(
            characterClass = CharacterClass.MONK,
            abilityScores = abilityScores(dexterity = 16, wisdom = 16),
            armorClassOverride = 18,
        )

        assertEquals(18, character.armorClass)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 51])
    fun `rejects an armor class override out of range`(armorClass: Int) {
        assertFailsWith<IllegalArgumentException> { character(armorClassOverride = armorClass) }
    }

    @Test
    fun `initiative is the dexterity modifier`() {
        assertEquals(-1, character(abilityScores = abilityScores(dexterity = 8)).initiative)
    }

    @ParameterizedTest
    @CsvSource("1, 2", "2, 3", "5, 3", "9, 4", "17, 5")
    fun `jack of all trades adds half the proficiency bonus rounded down from bard 2`(level: Int, initiative: Int) {
        val bard = character(
            characterClass = CharacterClass.BARD,
            level = level,
            abilityScores = abilityScores(dexterity = 14),
        )

        assertEquals(initiative, bard.initiative)
    }

    @ParameterizedTest
    @CsvSource("6, 2", "7, 4", "13, 5")
    fun `remarkable athlete adds half the proficiency bonus rounded up from champion 7`(level: Int, initiative: Int) {
        val champion = character(
            classes = listOf(ClassLevel(CharacterClass.FIGHTER, level, Subclass.CHAMPION)),
            abilityScores = abilityScores(dexterity = 14),
        )

        assertEquals(initiative, champion.initiative)
    }

    @Test
    fun `jack of all trades and remarkable athlete don't stack`() {
        val character = character(
            classes = listOf(
                ClassLevel(CharacterClass.FIGHTER, 7, Subclass.CHAMPION),
                ClassLevel(CharacterClass.BARD, 2),
            ),
            abilityScores = abilityScores(dexterity = 14),
        )

        assertEquals(4, character.initiative)
    }

    @Test
    fun `speed defaults to 30`() {
        assertEquals(30, character().speed)
    }

    @Test
    fun `speed starts from the base speed`() {
        assertEquals(25, character(baseSpeed = 25).speed)
    }

    @ParameterizedTest
    @ValueSource(ints = [-5, 205])
    fun `rejects a base speed out of range`(speed: Int) {
        assertFailsWith<IllegalArgumentException> { character(baseSpeed = speed) }
    }

    @ParameterizedTest
    @CsvSource("1, 30", "2, 40", "5, 40", "6, 45", "10, 50", "14, 55", "18, 60", "20, 60")
    fun `monk unarmored movement grows with monk level`(level: Int, speed: Int) {
        assertEquals(speed, character(characterClass = CharacterClass.MONK, level = level).speed)
    }

    @ParameterizedTest
    @CsvSource("4, 30", "5, 40")
    fun `barbarian fast movement adds 10 from barbarian 5`(level: Int, speed: Int) {
        assertEquals(speed, character(characterClass = CharacterClass.BARBARIAN, level = level).speed)
    }

    @Test
    fun `fast movement and unarmored movement stack`() {
        val character = character(
            classes = listOf(ClassLevel(CharacterClass.BARBARIAN, 5), ClassLevel(CharacterClass.MONK, 2)),
        )

        assertEquals(50, character.speed)
    }

    @Test
    fun `changing the max hit points keeps the combat state`() {
        val hurt = character(hitPoints = HitPoints(max = 20, current = 12, temporary = 3))

        assertEquals(HitPoints(max = 25, current = 12, temporary = 3), hurt.withMaxHitPoints(25).hitPoints)
    }
}
