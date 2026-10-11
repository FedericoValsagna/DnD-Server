package com.valsagnapps.dndapp.adapter.inbound.web

import com.valsagnapps.dndapp.domain.CombatActionNotAllowedException
import org.springframework.http.HttpStatus
import kotlin.test.Test
import kotlin.test.assertEquals

class ApiExceptionHandlerTest {
    private val handler = ApiExceptionHandler()

    @Test
    fun `maps domain rule violations to 400`() {
        val problem = handler.handleInvalidArgument(IllegalArgumentException("level must be between 1 and 20"))

        assertEquals(HttpStatus.BAD_REQUEST.value(), problem.status)
        assertEquals("level must be between 1 and 20", problem.detail)
    }

    @Test
    fun `maps actions the state doesn't allow to 409`() {
        val problem = handler.handleActionNotAllowed(
            CombatActionNotAllowedException("a dead character can't be healed"),
        )

        assertEquals(HttpStatus.CONFLICT.value(), problem.status)
        assertEquals("a dead character can't be healed", problem.detail)
    }
}
