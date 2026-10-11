package com.valsagnapps.dndapp.adapter.inbound.web

import com.valsagnapps.dndapp.application.service.InMemoryCharacterRepository
import com.valsagnapps.dndapp.application.service.ResourceService
import com.valsagnapps.dndapp.domain.CharacterClass
import com.valsagnapps.dndapp.domain.ClassLevel
import com.valsagnapps.dndapp.domain.abilityScores
import com.valsagnapps.dndapp.domain.character
import org.hamcrest.Matchers.contains
import org.hamcrest.Matchers.nullValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActionsDsl
import org.springframework.test.web.servlet.put
import java.util.UUID
import kotlin.test.Test

@WebMvcTest(ResourceController::class)
@Import(ResourceControllerTest.Config::class)
class ResourceControllerTest {
    @TestConfiguration
    class Config {
        @Bean
        fun repository() = InMemoryCharacterRepository()

        @Bean
        fun resourceService(repository: InMemoryCharacterRepository) = ResourceService(repository)
    }

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var repository: InMemoryCharacterRepository

    private val monk
        get() = repository.save(
            character(
                classes = listOf(ClassLevel(CharacterClass.MONK, 5, null)),
                abilityScores = abilityScores(wisdom = 14),
            ),
        )

    private fun update(id: UUID, resource: String, body: String): ResultActionsDsl =
        mockMvc.put("/api/v1/characters/$id/resources/$resource") {
            contentType = MediaType.APPLICATION_JSON
            content = body
        }

    @Test
    fun `updating used uses returns the character with its resources`() {
        update(monk.id.value, "KI", """{ "used": 2 }""").andExpect {
            status { isOk() }
            jsonPath("$.resources[0].id") { value("KI") }
            jsonPath("$.resources[0].name") { value("Ki") }
            jsonPath("$.resources[0].max") { value(5) }
            jsonPath("$.resources[0].used") { value(2) }
            jsonPath("$.resources[0].recharge") { value("SHORT_REST") }
            jsonPath("$.resources[0].display") { value("POOL") }
        }
    }

    private val flurryOfBlows = "$.classes[0].features[?(@.id == 'MONK_FLURRY_OF_BLOWS')]"
    private val unarmoredDefense = "$.classes[0].features[?(@.id == 'MONK_UNARMORED_DEFENSE')]"

    @Test
    fun `features come with their action type and resource`() {
        val flurryOfBlows = "$.classes[0].features[?(@.id == 'MONK_FLURRY_OF_BLOWS')]"
        val unarmoredDefense = "$.classes[0].features[?(@.id == 'MONK_UNARMORED_DEFENSE')]"

        update(monk.id.value, "KI", """{ "used": 0 }""").andExpect {
            status { isOk() }
            jsonPath("$flurryOfBlows.actionType") { value(contains("BONUS_ACTION")) }
            jsonPath("$flurryOfBlows.resource") { value(contains("KI")) }
            jsonPath("$unarmoredDefense.actionType") { value(contains(nullValue())) }
        }
    }

    @Test
    fun `more used uses than the maximum is a bad request`() {
        update(monk.id.value, "KI", """{ "used": 6 }""").andExpect { status { isBadRequest() } }
    }

    @Test
    fun `negative used uses is a bad request`() {
        update(monk.id.value, "KI", """{ "used": -1 }""").andExpect { status { isBadRequest() } }
    }

    @Test
    fun `a resource the character doesn't have is a bad request`() {
        update(monk.id.value, "RAGE", """{ "used": 1 }""").andExpect { status { isBadRequest() } }
    }

    @Test
    fun `an unknown resource is a bad request`() {
        update(monk.id.value, "MANA", """{ "used": 1 }""").andExpect { status { isBadRequest() } }
    }

    @Test
    fun `a missing character is not found`() {
        update(UUID.randomUUID(), "KI", """{ "used": 1 }""").andExpect { status { isNotFound() } }
    }
}
