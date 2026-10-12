package com.valsagnapps.dndapp.domain

import com.valsagnapps.dndapp.domain.CharacterClass.FIGHTER
import com.valsagnapps.dndapp.domain.CharacterClass.WIZARD
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RestTest {
    // Fighter 3 / Wizard 2: 3d10 y 2d6, CON +2.
    private fun multiclass(current: Int = 20, hitDiceUsed: Map<Int, Int> = emptyMap()) = character(
        classes = listOf(ClassLevel(FIGHTER, 3), ClassLevel(WIZARD, 2)),
        abilityScores = abilityScores(constitution = 14),
        hitPoints = HitPoints(max = 40, current = current),
        hitDiceUsed = hitDiceUsed,
    )

    // Fighter 9: Second Wind y Action Surge vuelven con el short rest; Indomitable, con el long.
    private val usedFighter = character(
        level = 9,
        maxHitPoints = 80,
        resourcesUsed = mapOf(Resource.SECOND_WIND to 1, Resource.ACTION_SURGE to 1, Resource.INDOMITABLE to 1),
    )

    private fun Character.usedDice(die: Int) = hitDice.first { it.die == die }.used

    @Test
    fun `a short rest heals the roll plus the constitution modifier per die`() {
        val rested = multiclass().shortRest(mapOf(10 to 2, 6 to 1), roll = 12)

        assertEquals(20 + 12 + 3 * 2, rested.hitPoints.current)
    }

    @Test
    fun `a short rest spends the hit dice`() {
        val rested = multiclass(hitDiceUsed = mapOf(10 to 1)).shortRest(mapOf(10 to 1, 6 to 2), roll = 10)

        assertEquals(listOf(HitDice(10, 3, 2), HitDice(6, 2, 2)), rested.hitDice)
    }

    @Test
    fun `short rest healing stops at the maximum`() {
        assertEquals(40, multiclass(current = 38).shortRest(mapOf(10 to 1), roll = 9).hitPoints.current)
    }

    @Test
    fun `a negative constitution can't make a short rest hurt`() {
        val weak = multiclass().copy(abilityScores = abilityScores(constitution = 6))

        assertEquals(20, weak.shortRest(mapOf(6 to 2), roll = 2).hitPoints.current)
    }

    @Test
    fun `a short rest without hit dice only recovers the short rest resources`() {
        val rested = usedFighter.shortRest(emptyMap(), roll = 0)

        assertEquals(mapOf(Resource.INDOMITABLE to 1), rested.resourcesUsed)
        assertEquals(usedFighter.hitPoints, rested.hitPoints)
    }

    @Test
    fun `a short rest can't spend more hit dice than are left`() {
        assertFailsWith<IllegalArgumentException> {
            multiclass(hitDiceUsed = mapOf(6 to 1)).shortRest(mapOf(6 to 2), roll = 4)
        }
    }

    @Test
    fun `a short rest can't spend a die the character doesn't have`() {
        assertFailsWith<IllegalArgumentException> { multiclass().shortRest(mapOf(8 to 1), roll = 4) }
    }

    @ParameterizedTest
    @CsvSource("1", "21")
    fun `the roll must be possible with the dice spent`(roll: Int) {
        assertFailsWith<IllegalArgumentException> { multiclass().shortRest(mapOf(10 to 2), roll) }
    }

    @Test
    fun `without hit dice there is no roll`() {
        assertFailsWith<IllegalArgumentException> { multiclass().shortRest(emptyMap(), roll = 5) }
    }

    @Test
    fun `a stable character can take a short rest without spending hit dice`() {
        val stable = multiclass(current = 0).copy(
            hitPoints = HitPoints(max = 40, current = 0, deathSaves = DeathSaves(successes = 3)),
        )

        assertEquals(stable.hitPoints, stable.shortRest(emptyMap(), roll = 0).hitPoints)
        assertFailsWith<CombatActionNotAllowedException> { stable.shortRest(mapOf(10 to 1), roll = 5) }
    }

    @Test
    fun `a dying or dead character can't rest`() {
        val dying = multiclass(current = 0)
        val dead = dying.copy(hitPoints = HitPoints(max = 40, current = 0, deathSaves = DeathSaves(failures = 3)))

        listOf(dying, dead).forEach { character ->
            assertFailsWith<CombatActionNotAllowedException> { character.shortRest(emptyMap(), roll = 0) }
            assertFailsWith<CombatActionNotAllowedException> { character.longRest() }
        }
    }

    @Test
    fun `a long rest restores hit points and clears temporary ones and death saves`() {
        val stable = multiclass().copy(
            hitPoints = HitPoints(max = 40, current = 0, temporary = 5, deathSaves = DeathSaves(successes = 3)),
        )

        assertEquals(HitPoints(max = 40), stable.longRest().hitPoints)
    }

    @Test
    fun `a long rest recovers every resource`() {
        assertEquals(emptyMap(), usedFighter.longRest().resourcesUsed)
    }

    @Test
    fun `a long rest recovers half the hit dice, the largest first`() {
        // Nivel 5: recupera 2.
        val rested = multiclass(hitDiceUsed = mapOf(10 to 1, 6 to 2)).longRest()

        assertEquals(0, rested.usedDice(10))
        assertEquals(1, rested.usedDice(6))
    }

    @Test
    fun `a long rest recovers at least one hit die`() {
        val rested = character(level = 1, hitDiceUsed = mapOf(10 to 1)).longRest()

        assertEquals(0, rested.usedDice(10))
    }

    @Test
    fun `used hit dice are capped at the total`() {
        assertEquals(1, character(level = 1, hitDiceUsed = mapOf(10 to 3)).usedDice(10))
    }
}
