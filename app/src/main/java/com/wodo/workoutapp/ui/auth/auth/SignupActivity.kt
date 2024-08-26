package com.wodo.workoutapp.ui.auth.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.wodo.workoutapp.databinding.ActivitySignupBinding
import com.wodo.workoutapp.ui.auth.home.HomeActivity
import com.wodo.workoutapp.viewmodel.AuthViewModel

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupButton.setOnClickListener {
            val email = binding.emailEditTextSignup.text.toString().trim()
            val password = binding.passwordEditTextSignup.text.toString().trim()
            authViewModel.signup(email, password)
        }

        authViewModel.signupStatus.observe(this) { isSuccess ->
            if (isSuccess) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()
            }
        }

        binding.LoginText.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
