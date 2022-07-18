package com.example.sis.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sis.R
import com.example.sis.data.model.SantriItem
import com.example.sis.databinding.ItemListBinding

class SantriAdapter(private val listSantri: List<SantriItem>) :
    RecyclerView.Adapter<SantriAdapter.SantriViewHolder>() {

    class SantriViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding  = ItemListBinding.bind(itemView)
        fun bind(dataSantri: SantriItem) {
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