package com.example.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    protected fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }

    protected fun setError(message: String?) {
        _errorMessage.value = message
    }

    protected fun clearError() {
        _errorMessage.value = null
    }
}
