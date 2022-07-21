package com.example.sis.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sis.data.model.SantriItem
import com.example.sis.databinding.ItemListBinding

class SantriAdapter(private val listSantri: ArrayList<SantriItem>) :
    RecyclerView.Adapter<SantriAdapter.SantriViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setList(santri: ArrayList<SantriItem>) {
        listSantri.clear()
        listSantri.addAll(santri)
        notifyDataSetChanged()
    }

    inner class SantriViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataSantri: SantriItem) {
            with(binding) {
                Glide.with(itemView)
                    .load(dataSantri.img)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(foto)
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
        val view =
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SantriViewHolder(view)
    }

    override fun onBindViewHolder(holder: SantriViewHolder, position: Int) {
        holder.bind(listSantri[position])
    }

    override fun getItemCount(): Int = listSantri.size
}