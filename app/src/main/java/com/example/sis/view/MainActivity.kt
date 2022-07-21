package com.example.sis.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sis.R
import com.example.sis.adapter.SantriAdapter
import com.example.sis.data.api.StatusResponse
import com.example.sis.databinding.ActivityMainBinding
import com.example.sis.viewmodel.SantriViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val santriViewModel: SantriViewModel by viewModels()
    private lateinit var mAuth: FirebaseAuth
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var adapter: SantriAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        supportActionBar?.title = TITLE

        //preview email logged
        mAuth = FirebaseAuth.getInstance() //this script for initiate
        val currentUser = mAuth.currentUser
        activityMainBinding.prevEmail.text = currentUser?.email

        //recycle list
        showRecyclerList()
    }

    //Option Menu in Action Bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu -> {
                startActivity(Intent(this, MenuActivity::class.java))
                return true
            }
            else -> return true
        }
    }

    private fun showRecyclerList() {
        adapter = SantriAdapter(ArrayList())
//        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            activityMainBinding.recyclerView.layoutManager = GridLayoutManager(this, 2)
//        } else {
//            activityMainBinding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        }
        activityMainBinding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        showData()
    }

    private fun showData() {
        santriViewModel.getSantri().observe(this) { response ->
            when (response.status) {
                StatusResponse.SUCCESS -> {
                    showLoading(false)
                    val data = response.body?.santri
                    if (response.body != null) {
                        adapter = data?.let { SantriAdapter(it) }!!
                        activityMainBinding.recyclerView.adapter = adapter
                    }
                }
                StatusResponse.EMPTY -> {
                    showLoading(false)
                    adapter = SantriAdapter(ArrayList())
                    activityMainBinding.recyclerView.adapter = adapter
                }
                StatusResponse.ERROR -> {
                    showLoading(false)
                    Toast.makeText(
                        this,
                        "An error occured, Please try again later.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    showLoading(true)
                }
            }
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            activityMainBinding.progressBar.visibility = View.VISIBLE
            activityMainBinding.recyclerView.visibility = View.GONE
        } else {
            activityMainBinding.progressBar.visibility = View.GONE
            activityMainBinding.recyclerView.visibility = View.VISIBLE
        }
    }

    companion object {
        const val TITLE = "Sistem Informasi Santri"
    }
}