package com.example.sis.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.sis.data.model.SantriItem
import com.example.sis.databinding.ActivityAddBinding
import com.example.sis.viewmodel.CreateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddActivity : AppCompatActivity() {

    private val viewModel: CreateViewModel by viewModels()
    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = TITLE
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun setupListener() {
        binding.button.setOnClickListener {
            Log.e("", binding.edtNis.toString())
        }
    }

    private fun saveData() {

    }

    private fun dataInput(){
       with(binding){
           edtNis.toString()
           edtName.toString()
           edtTelp.toString()
           edtAddress.toString()
           edtCity.toString()
           edtProv.toString()
           edtBirth.toString()
           edtEmail.toString()
           edtSikap.toString()
           edtMateri.toString()
           edtBacaan.toString()
           edtHafalan.toString()
           edtHadir.toString()
           edtIzin.toString()
           edtAlfa.toString()
           edtKeterangan.toString()
           edtUniv.toString()
           edtProgdi.toString()
           edtJurusan.toString()
           edtGelar.toString()
           //foto belum
       }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val TITLE = "Add Data"
    }
}