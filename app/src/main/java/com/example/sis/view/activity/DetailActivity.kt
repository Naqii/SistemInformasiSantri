package com.example.sis.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sis.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = TITLE

    }

    companion object {
        const val TITLE = "Detail Santri"
    }
}