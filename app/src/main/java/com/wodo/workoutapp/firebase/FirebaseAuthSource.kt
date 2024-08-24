package com.wodo.workoutapp.firebase

import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthSource {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun login(email: String, password: String) = firebaseAuth.signInWithEmailAndPassword(email, password)

    fun signup(email: String, password: String) = firebaseAuth.createUserWithEmailAndPassword(email, password)
}
