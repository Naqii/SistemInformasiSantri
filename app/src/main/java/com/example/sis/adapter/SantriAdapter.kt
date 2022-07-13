package com.example.sis.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sis.R
import com.example.sis.data.api.SantriResponseItem
import com.example.sis.databinding.ItemListBinding

class SantriAdapter(private val listSantri: List<SantriResponseItem>) :
    RecyclerView.Adapter<SantriAdapter.SantriViewHolder>() {
    inner class SantriViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding  = ItemListBinding.bind(view)
        fun bind(dataSantri: SantriResponseItem) {
            with(binding) {
                tvUsername.text = dataSantri.name
                //on click
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SantriViewHolder {
        return SantriViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SantriViewHolder, position: Int) {
        holder.bind(listSantri[position])
    }

    override fun getItemCount(): Int = listSantri.size
}