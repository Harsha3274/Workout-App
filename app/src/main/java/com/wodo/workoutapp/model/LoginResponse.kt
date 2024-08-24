package com.wodo.workoutapp.model

data class LoginResponse(val user: User?, val token: String?, val error: String?)
