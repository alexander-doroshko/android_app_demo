package com.example.feature.home

import com.example.domain.model.User
import com.example.domain.usecase.GetUserUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HomeViewModelTest {

    private val fakeUseCase = GetUserUseCase()
    private val viewModel = HomeViewModel(getUserUseCase = fakeUseCase)

    @Test
    fun `user is loaded on init`() {
        assertNotNull(viewModel.user.value)
    }

    @Test
    fun `loaded user has non-empty name`() {
        val user = viewModel.user.value
        assertNotNull(user)
        assert(user!!.name.isNotBlank())
    }

    @Test
    fun `isLoading is false after init`() {
        assertFalse(viewModel.isLoading.value ?: true)
    }

    @Test
    fun `refresh reloads user`() {
        viewModel.refresh()
        assertNotNull(viewModel.user.value)
    }
}
