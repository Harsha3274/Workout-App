package com.wodo.workoutapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.wodo.workoutapp.data.remote.ApiService
import com.wodo.workoutapp.viewmodel.AuthState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository(private val apiService: ApiService) {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun login(email: String, password: String): LiveData<AuthState> {
        return withContext(Dispatchers.IO) {
            val authState = MutableLiveData<AuthState>()

            // Firebase Authentication
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        authState.postValue(AuthState.Success(firebaseAuth.currentUser))
                    } else {
                        authState.postValue(AuthState.Error(task.exception?.message))
                    }
                }
            authState
        }
    }

    suspend fun signup(email: String, password: String): LiveData<AuthState> {
        return withContext(Dispatchers.IO) {
            val authState = MutableLiveData<AuthState>()

            // Firebase Authentication
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        authState.postValue(AuthState.Success(firebaseAuth.currentUser))
                    } else {
                        authState.postValue(AuthState.Error(task.exception?.message))
                    }
                }
            authState
        }
    }
}