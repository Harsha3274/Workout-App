package com.wodo.workoutapp.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.wodo.workoutapp.R
import com.wodo.workoutapp.viewmodel.AuthState
import com.wodo.workoutapp.viewmodel.AuthViewModel
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        authViewModel.authState.observe(this) { authState ->
            when (authState) {
                is AuthState.Success -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
                is AuthState.Error -> {
                    Toast.makeText(this, authState.error, Toast.LENGTH_SHORT).show()
                }
            }
        }

        signupButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            authViewModel.signup(email, password)
        }
    }
}
