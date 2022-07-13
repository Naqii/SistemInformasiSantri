package com.example.sis.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sis.databinding.ActivityMenuBinding
import com.example.sis.view.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var activityMenuBinding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMenuBinding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(activityMenuBinding.root)

        //Option Menu
        supportActionBar?.title = TITLE
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //firebase log out
        mAuth = FirebaseAuth.getInstance()
        activityMenuBinding.glogout.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    companion object {
        const val TITLE = "Logout Page"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}