package com.example.sis.view.santri

import android.app.SearchManager
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sis.R
import com.example.sis.adapter.SantriAdapter
import com.example.sis.data.api.StatusResponse
import com.example.sis.databinding.ActivitySantriBinding
import com.example.sis.viewmodel.SantriViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SantriActivity : AppCompatActivity() {

    private val santriViewModel: SantriViewModel by viewModels()
    lateinit var binding: ActivitySantriBinding

    private lateinit var adapter: SantriAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySantriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = TITLE
        binding.rvSantri
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        showRecyclerList()
        showLoading(true)
    }

    //Option Menu in Action Bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_sub, menu)

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
                Toast.makeText(this@SantriActivity, query, Toast.LENGTH_SHORT).show()
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

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvSantri.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.rvSantri.layoutManager = LinearLayoutManager(this)
        }
        adapter = SantriAdapter(ArrayList())
        santriViewModel.getSantri().observe(this) { response ->
            when (response.status) {
                StatusResponse.SUCCESS -> {
                    showLoading(false)
                    val data = response.body?.santriResponse
                    if (response.body != null) {
                        adapter = data?.let { SantriAdapter(it) }!!
                        binding.rvSantri.adapter = adapter
                    }
                }
                StatusResponse.EMPTY -> {
                    showLoading(false)
                    adapter = SantriAdapter(ArrayList())
                    binding.rvSantri.adapter = adapter
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
        //on click
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
            binding.rvSantri.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.rvSantri.visibility = View.VISIBLE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val TITLE = "Daftar Santri"
    }
}