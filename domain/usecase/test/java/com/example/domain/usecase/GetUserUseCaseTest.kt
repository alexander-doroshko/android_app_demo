package com.example.domain.usecase

import com.example.domain.model.User
import org.junit.Assert.assertEquals
import org.junit.Test

class GetUserUseCaseTest {

    private val useCase = GetUserUseCase()

    @Test
    fun `returns user with correct id`() {
        val user = useCase.execute("user-42")
        assertEquals("user-42", user.id)
    }

    @Test
    fun `returns non-empty name`() {
        val user = useCase.execute("user-1")
        assert(user.name.isNotBlank())
    }

    @Test
    fun `returns valid email`() {
        val user = useCase.execute("user-1")
        assert(user.email.contains("@"))
    }
}
