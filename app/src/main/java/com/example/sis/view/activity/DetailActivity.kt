package com.example.sis.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sis.data.model.SantriItem
import com.example.sis.databinding.ActivityDetailBinding
import com.example.sis.viewmodel.SantriViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val santriViewModel: SantriViewModel by viewModels()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = TITLE
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailList = intent.getParcelableExtra(EXTRA_DATA) as? SantriItem

    }

    private fun setDataDetail(data: SantriItem) {
        with(binding) {
            Glide.with(this@DetailActivity)
                .load(data.foto)
                .apply(RequestOptions().override(150, 150))
                .into(foto)
            nis.text = data.nis
            name.text = data.name
            telp.text = data.telp
//            showLoading(false)
        }
    }

//    private fun showLoading(state: Boolean) {
//        if (state) {
//            binding.progressBar.visibility = View.VISIBLE
//        } else {
//            binding.progressBar.visibility = View.GONE
//        }
//    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val TITLE = "Detail Santri"
        const val EXTRA_DATA = "extra_data"
    }
}