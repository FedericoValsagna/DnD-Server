package com.valsagnapps.dndapp.domain

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertSame

class HitPointsTest {
    private val dying = HitPoints(max = 20, current = 0)
    private val stable = HitPoints(max = 20, current = 0, deathSaves = DeathSaves(successes = 3))
    private val dead = HitPoints(max = 20, current = 0, deathSaves = DeathSaves(failures = 3))

    @Test
    fun `starts at full hit points, conscious and without death saves`() {
        val hitPoints = HitPoints(max = 20)

        assertEquals(20, hitPoints.current)
        assertEquals(0, hitPoints.temporary)
        assertEquals(LifeStatus.CONSCIOUS, hitPoints.status)
        assertEquals(DeathSaves.NONE, hitPoints.deathSaves)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1000])
    fun `rejects max hit points out of range`(max: Int) {
        assertFailsWith<IllegalArgumentException> { HitPoints(max = max) }
    }

    @Test
    fun `rejects current hit points above the max`() {
        assertFailsWith<IllegalArgumentException> { HitPoints(max = 20, current = 21) }
    }

    @Test
    fun `at 0 hit points the death saves tell the status`() {
        assertEquals(LifeStatus.DYING, dying.status)
        assertEquals(LifeStatus.DYING, dying.copy(deathSaves = DeathSaves(successes = 2, failures = 2)).status)
        assertEquals(LifeStatus.STABLE, stable.status)
        assertEquals(LifeStatus.DEAD, dead.status)
    }

    @Test
    fun `rejects death saves on a conscious character`() {
        assertFailsWith<IllegalArgumentException> { HitPoints(max = 20, deathSaves = DeathSaves(failures = 1)) }
    }

    @Test
    fun `damage lowers current hit points`() {
        assertEquals(12, HitPoints(max = 20).takeDamage(8).current)
    }

    @Test
    fun `temporary hit points absorb damage first`() {
        val hitPoints = HitPoints(max = 20, temporary = 5).takeDamage(8)

        assertEquals(0, hitPoints.temporary)
        assertEquals(17, hitPoints.current)
    }

    @Test
    fun `damage below the temporary hit points leaves current untouched`() {
        val hitPoints = HitPoints(max = 20, temporary = 5).takeDamage(3)

        assertEquals(2, hitPoints.temporary)
        assertEquals(20, hitPoints.current)
    }

    @Test
    fun `dropping to 0 starts dying`() {
        val hitPoints = HitPoints(max = 20, current = 5).takeDamage(10)

        assertEquals(0, hitPoints.current)
        assertEquals(LifeStatus.DYING, hitPoints.status)
        assertEquals(DeathSaves.NONE, hitPoints.deathSaves)
    }

    @Test
    fun `damage left over after 0 equal to the max kills outright`() {
        val hitPoints = HitPoints(max = 20, current = 5, temporary = 3).takeDamage(28)

        assertEquals(LifeStatus.DEAD, hitPoints.status)
        assertEquals(0, hitPoints.current)
        assertEquals(DeathSaves(failures = 3), hitPoints.deathSaves)
    }

    @Test
    fun `damage left over below the max only drops to 0`() {
        assertEquals(LifeStatus.DYING, HitPoints(max = 20, current = 5).takeDamage(24).status)
    }

    @Test
    fun `damage while dying is a failed death save`() {
        assertEquals(DeathSaves(failures = 1), dying.takeDamage(3).deathSaves)
    }

    @Test
    fun `a critical hit while dying is two failed death saves`() {
        assertEquals(DeathSaves(failures = 2), dying.takeDamage(3, critical = true).deathSaves)
    }

    @Test
    fun `damage while dying equal to the max kills outright`() {
        assertEquals(LifeStatus.DEAD, dying.takeDamage(20).status)
    }

    @Test
    fun `temporary hit points absorb damage while dying`() {
        val hitPoints = dying.copy(temporary = 5).takeDamage(3)

        assertEquals(DeathSaves.NONE, hitPoints.deathSaves)
        assertEquals(2, hitPoints.temporary)
    }

    @Test
    fun `third failed death save from damage kills, keeping the successes`() {
        val hitPoints = dying.copy(deathSaves = DeathSaves(successes = 1, failures = 2)).takeDamage(1)

        assertEquals(LifeStatus.DEAD, hitPoints.status)
        assertEquals(DeathSaves(successes = 1, failures = 3), hitPoints.deathSaves)
    }

    @Test
    fun `a critical hit with two failures kills without going over three`() {
        assertEquals(
            DeathSaves(failures = 3),
            dying.copy(deathSaves = DeathSaves(failures = 2)).takeDamage(1, critical = true).deathSaves,
        )
    }

    @Test
    fun `damage on a stable character starts dying again from scratch`() {
        val hitPoints = stable.takeDamage(1)

        assertEquals(LifeStatus.DYING, hitPoints.status)
        assertEquals(DeathSaves(failures = 1), hitPoints.deathSaves)
    }

    @Test
    fun `damage on a dead character does nothing`() {
        assertSame(dead, dead.takeDamage(5))
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    fun `rejects damage below 1`(amount: Int) {
        assertFailsWith<IllegalArgumentException> { HitPoints(max = 20).takeDamage(amount) }
    }

    @Test
    fun `healing raises current hit points up to the max`() {
        assertEquals(15, HitPoints(max = 20, current = 10).heal(5).current)
        assertEquals(20, HitPoints(max = 20, current = 10).heal(50).current)
    }

    @Test
    fun `healing a dying character wakes it up and resets death saves`() {
        val hitPoints = dying.copy(deathSaves = DeathSaves(successes = 2, failures = 2)).heal(4)

        assertEquals(4, hitPoints.current)
        assertEquals(LifeStatus.CONSCIOUS, hitPoints.status)
        assertEquals(DeathSaves.NONE, hitPoints.deathSaves)
    }

    @Test
    fun `healing a dead character is not allowed`() {
        assertFailsWith<CombatActionNotAllowedException> { dead.heal(5) }
    }

    @Test
    fun `rejects healing below 1`() {
        assertFailsWith<IllegalArgumentException> { HitPoints(max = 20).heal(0) }
    }

    @Test
    fun `new temporary hit points replace the old ones`() {
        assertEquals(3, HitPoints(max = 20, temporary = 8).withTemporary(3).temporary)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 1000])
    fun `rejects temporary hit points out of range`(amount: Int) {
        assertFailsWith<IllegalArgumentException> { HitPoints(max = 20).withTemporary(amount) }
    }

    @Test
    fun `a dead character can't get temporary hit points`() {
        assertFailsWith<CombatActionNotAllowedException> { dead.withTemporary(5) }
    }

    @Test
    fun `marks death saves at 0 hit points`() {
        val hitPoints = dying.withDeathSaves(DeathSaves(successes = 1, failures = 2))

        assertEquals(DeathSaves(successes = 1, failures = 2), hitPoints.deathSaves)
        assertEquals(LifeStatus.DYING, hitPoints.status)
    }

    @Test
    fun `third success stabilizes`() {
        assertEquals(LifeStatus.STABLE, dying.withDeathSaves(DeathSaves(successes = 3, failures = 1)).status)
    }

    @Test
    fun `third failure kills`() {
        assertEquals(LifeStatus.DEAD, dying.withDeathSaves(DeathSaves(successes = 2, failures = 3)).status)
    }

    @Test
    fun `unmarking a success undoes the stabilization`() {
        assertEquals(LifeStatus.DYING, stable.withDeathSaves(DeathSaves(successes = 2)).status)
    }

    @Test
    fun `unmarking a failure undoes the death`() {
        assertEquals(LifeStatus.DYING, dead.withDeathSaves(DeathSaves(failures = 2)).status)
    }

    @Test
    fun `only a character at 0 hit points makes death saves`() {
        assertFailsWith<CombatActionNotAllowedException> {
            HitPoints(max = 20).withDeathSaves(DeathSaves(successes = 1))
        }
    }

    @Test
    fun `rejects three successes and three failures at once`() {
        assertFailsWith<IllegalArgumentException> { DeathSaves(successes = 3, failures = 3) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 4])
    fun `rejects death saves out of range`(count: Int) {
        assertFailsWith<IllegalArgumentException> { DeathSaves(successes = count) }
        assertFailsWith<IllegalArgumentException> { DeathSaves(failures = count) }
    }

    @Test
    fun `healing a stable character wakes it up`() {
        val hitPoints = stable.heal(1)

        assertEquals(LifeStatus.CONSCIOUS, hitPoints.status)
        assertEquals(DeathSaves.NONE, hitPoints.deathSaves)
    }

    @Test
    fun `reviving leaves 1 hit point by default and clears death saves`() {
        val hitPoints = dead.copy(temporary = 4).revive()

        assertEquals(1, hitPoints.current)
        assertEquals(0, hitPoints.temporary)
        assertEquals(LifeStatus.CONSCIOUS, hitPoints.status)
        assertEquals(DeathSaves.NONE, hitPoints.deathSaves)
    }

    @Test
    fun `reviving can leave more hit points`() {
        assertEquals(20, dead.revive(hitPoints = 20).current)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 21])
    fun `rejects revived hit points out of range`(hitPoints: Int) {
        assertFailsWith<IllegalArgumentException> { dead.revive(hitPoints) }
    }

    @Test
    fun `only a dead character can be revived`() {
        assertFailsWith<CombatActionNotAllowedException> { dying.revive() }
    }

    @Test
    fun `lowering the max below current lowers current`() {
        assertEquals(15, HitPoints(max = 20).withMax(15).current)
    }

    @Test
    fun `raising the max keeps current`() {
        val hitPoints = HitPoints(max = 20, current = 12).withMax(30)

        assertEquals(30, hitPoints.max)
        assertEquals(12, hitPoints.current)
    }
}
