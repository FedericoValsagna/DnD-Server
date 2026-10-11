package com.valsagnapps.dndapp.adapter.inbound.web

import com.valsagnapps.dndapp.application.service.CombatService
import com.valsagnapps.dndapp.application.service.InMemoryCharacterRepository
import com.valsagnapps.dndapp.domain.Character
import com.valsagnapps.dndapp.domain.DeathSaves
import com.valsagnapps.dndapp.domain.HitPoints
import com.valsagnapps.dndapp.domain.abilityScores
import com.valsagnapps.dndapp.domain.character
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockHttpServletRequestDsl
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActionsDsl
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.put
import java.util.UUID
import kotlin.test.Test

@WebMvcTest(CombatController::class)
@Import(CombatControllerTest.Config::class)
class CombatControllerTest {
    @TestConfiguration
    class Config {
        @Bean
        fun repository() = InMemoryCharacterRepository()

        @Bean
        fun combatService(repository: InMemoryCharacterRepository) = CombatService(repository)
    }

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var repository: InMemoryCharacterRepository

    private fun saved(character: Character = character(maxHitPoints = 20)) = repository.save(character)

    private fun dying() = saved(character(hitPoints = HitPoints(max = 20, current = 0)))

    private fun dead() = saved(
        character(hitPoints = HitPoints(max = 20, current = 0, deathSaves = DeathSaves(failures = 3))),
    )

    private fun send(method: String, character: Character, path: String, body: String?): ResultActionsDsl {
        val url = "/api/v1/characters/${character.id.value}/$path"
        val request: MockHttpServletRequestDsl.() -> Unit = {
            contentType = MediaType.APPLICATION_JSON
            body?.let { content = it }
        }
        return if (method == "PUT") mockMvc.put(url, dsl = request) else mockMvc.post(url, dsl = request)
    }

    @Test
    fun `damage returns the updated character`() {
        val character = saved(character(maxHitPoints = 20, hitPoints = HitPoints(max = 20, temporary = 3)))

        send("POST", character, "damage", """{ "amount": 8 }""").andExpect {
            status { isOk() }
            jsonPath("$.maxHitPoints") { value(20) }
            jsonPath("$.currentHitPoints") { value(15) }
            jsonPath("$.temporaryHitPoints") { value(0) }
            jsonPath("$.lifeStatus") { value("CONSCIOUS") }
            jsonPath("$.deathSaves.successes") { value(0) }
            jsonPath("$.deathSaves.failures") { value(0) }
        }
    }

    @Test
    fun `critical damage while dying counts two failures`() {
        send("POST", dying(), "damage", """{ "amount": 3, "critical": true }""").andExpect {
            status { isOk() }
            jsonPath("$.lifeStatus") { value("DYING") }
            jsonPath("$.deathSaves.failures") { value(2) }
        }
    }

    @Test
    fun `rejects damage below 1`() {
        send("POST", saved(), "damage", """{ "amount": 0 }""").andExpect { status { isBadRequest() } }
    }

    @Test
    fun `healing returns the updated character`() {
        send("POST", dying(), "healing", """{ "amount": 5 }""").andExpect {
            status { isOk() }
            jsonPath("$.currentHitPoints") { value(5) }
            jsonPath("$.lifeStatus") { value("CONSCIOUS") }
        }
    }

    @Test
    fun `healing a dead character is a conflict`() {
        send("POST", dead(), "healing", """{ "amount": 5 }""").andExpect {
            status { isConflict() }
            jsonPath("$.detail") { value("a dead character can't be healed: revive it first") }
        }
    }

    @Test
    fun `sets temporary hit points`() {
        send("PUT", saved(), "temporary-hit-points", """{ "temporaryHitPoints": 6 }""").andExpect {
            status { isOk() }
            jsonPath("$.temporaryHitPoints") { value(6) }
        }
    }

    @Test
    fun `rejects negative temporary hit points`() {
        send("PUT", saved(), "temporary-hit-points", """{ "temporaryHitPoints": -1 }""").andExpect {
            status { isBadRequest() }
        }
    }

    @Test
    fun `updates the death saves`() {
        send("PUT", dying(), "death-saves", """{ "successes": 1, "failures": 3 }""").andExpect {
            status { isOk() }
            jsonPath("$.deathSaves.successes") { value(1) }
            jsonPath("$.deathSaves.failures") { value(3) }
            jsonPath("$.lifeStatus") { value("DEAD") }
        }
    }

    @Test
    fun `unmarking a failure brings a dead character back to dying`() {
        send("PUT", dead(), "death-saves", """{ "successes": 0, "failures": 2 }""").andExpect {
            status { isOk() }
            jsonPath("$.lifeStatus") { value("DYING") }
        }
    }

    @Test
    fun `death saves while conscious are a conflict`() {
        send("PUT", saved(), "death-saves", """{ "successes": 1, "failures": 0 }""").andExpect {
            status { isConflict() }
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            """{ "successes": 4, "failures": 0 }""",
            """{ "successes": 0, "failures": -1 }""",
            """{ "successes": 3, "failures": 3 }""",
        ],
    )
    fun `rejects invalid death saves`(body: String) {
        send("PUT", dying(), "death-saves", body).andExpect { status { isBadRequest() } }
    }

    @Test
    fun `revives with 1 hit point without a body`() {
        send("POST", dead(), "revive", null).andExpect {
            status { isOk() }
            jsonPath("$.currentHitPoints") { value(1) }
            jsonPath("$.lifeStatus") { value("CONSCIOUS") }
        }
    }

    @Test
    fun `revives with the given hit points`() {
        send("POST", dead(), "revive", """{ "hitPoints": 20 }""").andExpect {
            status { isOk() }
            jsonPath("$.currentHitPoints") { value(20) }
        }
    }

    @Test
    fun `reviving with more than the max is a bad request`() {
        send("POST", dead(), "revive", """{ "hitPoints": 21 }""").andExpect { status { isBadRequest() } }
    }

    @Test
    fun `reviving a living character is a conflict`() {
        send("POST", saved(), "revive", null).andExpect { status { isConflict() } }
    }

    @Test
    fun `sets and removes the armor class override`() {
        val character = saved(character(abilityScores = abilityScores(dexterity = 14)))

        send("PUT", character, "armor-class", """{ "armorClassOverride": 17 }""").andExpect {
            status { isOk() }
            jsonPath("$.armorClass") { value(17) }
            jsonPath("$.armorClassOverride") { value(17) }
        }
        send("PUT", character, "armor-class", "{}").andExpect {
            status { isOk() }
            jsonPath("$.armorClass") { value(12) }
            jsonPath("$.armorClassOverride") { value(null as Any?) }
        }
    }

    @Test
    fun `rejects an armor class override out of range`() {
        send("PUT", saved(), "armor-class", """{ "armorClassOverride": 0 }""").andExpect { status { isBadRequest() } }
    }

    @Test
    fun `sets the base speed`() {
        send("PUT", saved(), "speed", """{ "baseSpeed": 25 }""").andExpect {
            status { isOk() }
            jsonPath("$.speed") { value(25) }
            jsonPath("$.baseSpeed") { value(25) }
        }
    }

    @Test
    fun `rejects a base speed out of range`() {
        send("PUT", saved(), "speed", """{ "baseSpeed": 201 }""").andExpect { status { isBadRequest() } }
    }

    @Test
    fun `returns 404 when the character does not exist`() {
        mockMvc.post("/api/v1/characters/${UUID.randomUUID()}/healing") {
            contentType = MediaType.APPLICATION_JSON
            content = """{ "amount": 5 }"""
        }.andExpect { status { isNotFound() } }
    }
}
