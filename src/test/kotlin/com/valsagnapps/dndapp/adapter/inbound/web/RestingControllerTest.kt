package com.valsagnapps.dndapp.adapter.inbound.web

import com.valsagnapps.dndapp.application.service.InMemoryCharacterRepository
import com.valsagnapps.dndapp.application.service.RestService
import com.valsagnapps.dndapp.domain.DeathSaves
import com.valsagnapps.dndapp.domain.HitPoints
import com.valsagnapps.dndapp.domain.Resource
import com.valsagnapps.dndapp.domain.character
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActionsDsl
import org.springframework.test.web.servlet.post
import java.util.UUID
import kotlin.test.Test

@WebMvcTest(RestingController::class)
@Import(RestingControllerTest.Config::class)
class RestingControllerTest {
    @TestConfiguration
    class Config {
        @Bean
        fun repository() = InMemoryCharacterRepository()

        @Bean
        fun restService(repository: InMemoryCharacterRepository) = RestService(repository)
    }

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var repository: InMemoryCharacterRepository

    // Fighter 5 con 2 Hit Dice gastados, Second Wind usado y la mitad del HP.
    private fun tired(hitPoints: HitPoints = HitPoints(max = 40, current = 20)) = repository.save(
        character(
            level = 5,
            hitPoints = hitPoints,
            resourcesUsed = mapOf(Resource.SECOND_WIND to 1),
            hitDiceUsed = mapOf(10 to 2),
        ),
    )

    private fun shortRest(id: UUID, body: String? = null): ResultActionsDsl =
        mockMvc.post("/api/v1/characters/$id/short-rest") {
            if (body != null) {
                contentType = MediaType.APPLICATION_JSON
                content = body
            }
        }

    private fun longRest(id: UUID): ResultActionsDsl = mockMvc.post("/api/v1/characters/$id/long-rest")

    @Test
    fun `a short rest spends hit dice and heals`() {
        shortRest(tired().id.value, """{ "hitDice": [{ "die": 10, "count": 2 }], "roll": 11 }""").andExpect {
            status { isOk() }
            jsonPath("$.currentHitPoints") { value(31) }
            jsonPath("$.hitDice[0].die") { value(10) }
            jsonPath("$.hitDice[0].count") { value(5) }
            jsonPath("$.hitDice[0].used") { value(4) }
            jsonPath("$.resources[?(@.id == 'SECOND_WIND')].used") { value(0) }
        }
    }

    @Test
    fun `a short rest without a body only recovers resources`() {
        shortRest(tired().id.value).andExpect {
            status { isOk() }
            jsonPath("$.currentHitPoints") { value(20) }
            jsonPath("$.hitDice[0].used") { value(2) }
        }
    }

    @Test
    fun `spending more hit dice than are left is a bad request`() {
        shortRest(tired().id.value, """{ "hitDice": [{ "die": 10, "count": 4 }], "roll": 20 }""")
            .andExpect { status { isBadRequest() } }
    }

    @Test
    fun `a repeated die is a bad request`() {
        val body = """{ "hitDice": [{ "die": 10, "count": 1 }, { "die": 10, "count": 1 }], "roll": 8 }"""
        shortRest(tired().id.value, body).andExpect { status { isBadRequest() } }
    }

    @Test
    fun `an impossible roll is a bad request`() {
        shortRest(tired().id.value, """{ "hitDice": [{ "die": 10, "count": 1 }], "roll": 11 }""")
            .andExpect { status { isBadRequest() } }
    }

    @Test
    fun `a count below 1 is a bad request`() {
        shortRest(tired().id.value, """{ "hitDice": [{ "die": 10, "count": 0 }], "roll": 0 }""")
            .andExpect { status { isBadRequest() } }
    }

    @Test
    fun `spending hit dice at 0 hit points is a conflict`() {
        val stable = tired(HitPoints(max = 40, current = 0, deathSaves = DeathSaves(successes = 3)))

        shortRest(stable.id.value, """{ "hitDice": [{ "die": 10, "count": 1 }], "roll": 5 }""")
            .andExpect { status { isConflict() } }
    }

    @Test
    fun `a long rest restores hit points, hit dice and resources`() {
        longRest(tired().id.value).andExpect {
            status { isOk() }
            jsonPath("$.currentHitPoints") { value(40) }
            jsonPath("$.hitDice[0].used") { value(0) }
            jsonPath("$.resources[?(@.id == 'SECOND_WIND')].used") { value(0) }
        }
    }

    @Test
    fun `a dying character can't rest`() {
        val dying = tired(HitPoints(max = 40, current = 0))

        longRest(dying.id.value).andExpect { status { isConflict() } }
        shortRest(dying.id.value).andExpect { status { isConflict() } }
    }

    @Test
    fun `a missing character is not found`() {
        longRest(UUID.randomUUID()).andExpect { status { isNotFound() } }
        shortRest(UUID.randomUUID()).andExpect { status { isNotFound() } }
    }
}
