package com.example.sis.view.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sis.view.activity.MainActivity
import com.example.sis.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
//    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var activityLoginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(activityLoginBinding.root)

        supportActionBar?.hide()

        //initialize firebase
        mAuth = FirebaseAuth.getInstance()

        //login normaly
        activityLoginBinding.btnLogin.setOnClickListener {
            login()
        }
        //login using google account
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
//
//        Binding.btnGoogleLogin.setOnClickListener { view: View? ->
//            Toast.makeText(this, "Logging In", Toast.LENGTH_SHORT).show()
//            signGoogle()
//        }
        //register account
        activityLoginBinding.tvRedirectSignUp.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
            showLoading(true)
        }
        showLoading(false)
    }

    //login normaly
    private fun login() {
        val email = activityLoginBinding.inputEmail.text.toString()
        val pass = activityLoginBinding.inputPass.text.toString()

        if (email.isBlank() || pass.isBlank()) {
            Toast.makeText(this, "Email and Password can not be blank", Toast.LENGTH_SHORT).show()
            return
        }

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this){
            if (it.isSuccessful) {
                startActivity(Intent(this, MainActivity::class.java))
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                showLoading(true)
                finish()
            } else
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
        }
    }

    //login using google account


    private fun showLoading(state: Boolean) {
        activityLoginBinding.progressBar.visibility = if (state) View.VISIBLE else View.INVISIBLE
    }

//    companion object {
//        const val REQ_CODE = 123
//    }
}