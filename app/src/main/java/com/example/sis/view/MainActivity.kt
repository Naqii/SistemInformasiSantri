package com.example.sis.view

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.sis.R
import com.example.sis.databinding.ActivityMainBinding
import com.example.sis.view.santri.SantriActivity
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    private val santriViewModel: SantriViewModel by viewModels()
    private lateinit var mAuth: FirebaseAuth
    private lateinit var activityMainBinding: ActivityMainBinding

//    private lateinit var adapter: SantriAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        supportActionBar?.title = TITLE

        //preview email logged
        mAuth = FirebaseAuth.getInstance() //this script for initiate
        val currentUser = mAuth.currentUser
        activityMainBinding.prevEmail.text = currentUser?.email

        //move activity santri
        activityMainBinding.santri.setOnClickListener{
            startActivity(Intent(this, SantriActivity::class.java))
        }

        //recycle list
//        showRecyclerList()
    }

    //Option Menu in Action Bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)

        //menu search
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            /*
                Gunakan method ini ketika search selesai atau OK
            */
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
                searchView.clearFocus()
                return true
            }
            /*
                Gunakan method ini untuk merespon tiap perubahan huruf pada searchView
            */
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
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

//    private fun showRecyclerList() {
//        adapter = SantriAdapter(ArrayList())
//        activityMainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
//        activityMainBinding.recyclerView.adapter = adapter
//        santriViewModel.getSantri().observe(this) { response ->
//            when (response.status) {
//                StatusResponse.SUCCESS -> {
//                    showLoading(false)
//                    val data = response.body?.santriResponse
//                    if (response.body != null) {
//                        adapter = data?.let { SantriAdapter(it) }!!
//                        activityMainBinding.recyclerView.adapter = adapter
//                    }
//                }
//                StatusResponse.EMPTY -> {
//                    showLoading(false)
//                    adapter = SantriAdapter(ArrayList())
//                    activityMainBinding.recyclerView.adapter = adapter
//                }
//                StatusResponse.ERROR -> {
//                    showLoading(false)
//                    Toast.makeText(
//                        this,
//                        "An error occured, Please try again later.",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//                else -> {
//                    showLoading(true)
//                }
//            }
//        }
//    }

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