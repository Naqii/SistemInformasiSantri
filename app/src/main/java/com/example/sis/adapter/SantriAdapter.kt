package com.example.sis.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sis.R
import com.example.sis.data.api.SantriResponseItem
import com.example.sis.databinding.ItemListBinding

class SantriAdapter(private val listSantri: List<SantriResponseItem>) : RecyclerView.Adapter<SantriAdapter.SantriViewHolder>() {

    inner class SantriViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding  = ItemListBinding.bind(itemView)
        fun bind(dataSantri: SantriResponseItem) {
            with(binding) {
                tvNis.text = dataSantri.nis
                tvUsername.text = dataSantri.name
                tvTelp.text = dataSantri.telp
                tvAddress.text = dataSantri.address
            }
            //on click
//            itemView.setOnClickListener {
//
//            }
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