package com.example.sis.view.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sis.view.activity.MainActivity
import com.example.sis.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth
    private lateinit var activityRegistrationBinding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegistrationBinding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(activityRegistrationBinding.root)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()
        activityRegistrationBinding.btnSign.setOnClickListener {
            signUpUser()
        }

        activityRegistrationBinding.tvRedirectLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            showLoading(true)
        }

        showLoading(false)
    }

    private fun signUpUser() {
        val email = activityRegistrationBinding.email.text.toString()
        val pass = activityRegistrationBinding.password.text.toString()
        val confirmPass = activityRegistrationBinding.confirmPassword.text.toString()

        if (email.isBlank() || pass.isBlank() || confirmPass.isBlank()) {
            Toast.makeText(this, "Email and Password can not be blank", Toast.LENGTH_SHORT).show()
            return
        }else if (pass != confirmPass){
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }

        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful){
                startActivity(Intent(this, MainActivity::class.java))
                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                showLoading(true)
                finish()
            } else {
                Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showLoading(state: Boolean) {
        activityRegistrationBinding.progressBar.visibility = if (state) View.VISIBLE else View.INVISIBLE
    }
}