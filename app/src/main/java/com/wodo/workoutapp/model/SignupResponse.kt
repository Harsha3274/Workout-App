package com.wodo.workoutapp.model

data class SignupResponse(val user: User?, val token: String?, val error: String?)
