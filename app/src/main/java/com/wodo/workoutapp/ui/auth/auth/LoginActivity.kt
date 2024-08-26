package com.wodo.workoutapp.ui.auth.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.wodo.workoutapp.databinding.ActivityLoginBinding
import com.wodo.workoutapp.ui.auth.home.HomeActivity
import com.wodo.workoutapp.viewmodel.AuthViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditTextLogin.text.toString().trim()
            val password = binding.passwordEditTextLogin.text.toString().trim()
            authViewModel.login(email, password)
        }

        authViewModel.loginStatus.observe(this) { isSuccess ->
            if (isSuccess) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }

        binding.SignupText.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}
