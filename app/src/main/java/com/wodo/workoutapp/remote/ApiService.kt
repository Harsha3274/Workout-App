package com.wodo.workoutapp.data.remote

import com.wodo.workoutapp.model.LoginRequest
import com.wodo.workoutapp.model.LoginResponse
import com.wodo.workoutapp.model.SignupRequest
import com.wodo.workoutapp.model.SignupResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("signup")
    suspend fun signup(@Body signupRequest: SignupRequest): Response<SignupResponse>
}
