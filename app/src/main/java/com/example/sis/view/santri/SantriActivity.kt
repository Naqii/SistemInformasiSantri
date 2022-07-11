package com.example.sis.view.santri

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sis.adapter.SantriAdapter
import com.example.sis.data.api.StatusResponse
import com.example.sis.databinding.ActivitySantriBinding
import com.example.sis.viewmodel.SantriViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SantriActivity : AppCompatActivity() {

    private val santriViewModel: SantriViewModel by viewModels()
    private lateinit var santriAdapter: SantriAdapter
    lateinit var activitySantriBinding: ActivitySantriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySantriBinding = ActivitySantriBinding.inflate(layoutInflater)
        setContentView(activitySantriBinding.root)

        supportActionBar?.hide()

        activitySantriBinding.listSantri

//        showDataSantri()
        showRecyclerList()
        showLoading(true)
    }

//    private fun showDataSantri() {
//
//
//    }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            activitySantriBinding.listSantri.layoutManager = GridLayoutManager(this, 2)
        } else {
            activitySantriBinding.listSantri.layoutManager = LinearLayoutManager(this)
        }
        santriAdapter = SantriAdapter(ArrayList())
        activitySantriBinding.listSantri.adapter = santriAdapter
        santriViewModel.getSantri().observe(this) { response ->
            when (response.status) {
                StatusResponse.SUCCESS -> {
                    showLoading(false)
                    val data = response.body?.santriResponse
                    if (response.body != null) {
                        santriAdapter = data?.let { SantriAdapter(it) }!!
                    }
                }
                StatusResponse.EMPTY -> {
                    showLoading(false)
                    santriAdapter = SantriAdapter(ArrayList())
                    activitySantriBinding.listSantri.adapter = santriAdapter
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
            activitySantriBinding.progressBar.visibility = View.VISIBLE
            activitySantriBinding.listSantri.visibility = View.GONE
        } else {
            activitySantriBinding.progressBar.visibility = View.GONE
            activitySantriBinding.listSantri.visibility = View.VISIBLE
        }
    }
}