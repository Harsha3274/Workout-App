package com.wodo.workoutapp.utils

import com.google.firebase.auth.FirebaseAuth

object FirebaseUtils {
    val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
}