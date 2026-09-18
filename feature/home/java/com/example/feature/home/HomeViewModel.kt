package com.example.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.User
import com.example.domain.usecase.GetUserUseCase

class HomeViewModel(
    private val getUserUseCase: GetUserUseCase = GetUserUseCase(),
) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        loadUser()
    }

    private fun loadUser() {
        _isLoading.value = true
        // Simulated synchronous call — in real app this would be async
        _user.value = getUserUseCase.execute("current-user")
        _isLoading.value = false
    }

    fun refresh() {
        loadUser()
    }
}
