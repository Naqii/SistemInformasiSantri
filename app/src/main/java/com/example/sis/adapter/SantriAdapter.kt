package com.example.sis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sis.data.api.SantriResponseItem
import com.example.sis.databinding.ItemListBinding

class SantriAdapter(private val listSantri: List<SantriResponseItem>) :
    RecyclerView.Adapter<SantriAdapter.SantriViewHolder>() {

    class SantriViewHolder(var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
//        private val binding  = ItemListBinding.bind(itemView)
//        fun bind(dataSantri: SantriResponseItem) {
//            with(binding) {
//                tvNis.text = dataSantri.nis
//                tvUsername.text = dataSantri.name
//                tvTelp.text = dataSantri.telp
//                tvAddress.text = dataSantri.address
//            }
//            //on click
////            itemView.setOnClickListener {
////
////            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SantriViewHolder {
//        return SantriViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
//        )
        val binding =
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SantriViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SantriViewHolder, position: Int) {
//        holder.bind(listSantri[position])
        val dataSantri = listSantri[position]
        with(holder) {
            binding.tvNis.text = dataSantri.nis
            binding.tvUsername.text = dataSantri.name
            binding.tvTelp.text = dataSantri.telp
            binding.tvAddress.text = dataSantri.address
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "You choose " + listSantri[bindingAdapterPosition].name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int = listSantri.size
}