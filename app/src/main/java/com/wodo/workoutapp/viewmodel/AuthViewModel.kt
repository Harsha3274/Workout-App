package com.wodo.workoutapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.wodo.workoutapp.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val result = repository.login(email, password)
            _authState.postValue(result.value)
        }
    }

    fun signup(email: String, password: String) {
        viewModelScope.launch {
            val result = repository.signup(email, password)
            _authState.postValue(result.value)
        }
    }
}

sealed class AuthState {
    data class Success(val user: FirebaseUser?) : AuthState()
    data class Error(val error: String?) : AuthState()
}
