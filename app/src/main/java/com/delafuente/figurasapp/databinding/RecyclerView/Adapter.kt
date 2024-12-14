package com.delafuente.figurasapp.databinding.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.delafuente.figurasapp.data.Figura

class FiguraAdapter(private val listaFiguras: List<Figura>) :
    RecyclerView.Adapter<FiguraAdapter.FiguraViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FiguraViewHolder {
        val binding = ItemFiguraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FiguraViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FiguraViewHolder, position: Int) {
        val figura = listaFiguras[position]
        holder.bind(figura)
    }

    override fun getItemCount(): Int = listaFiguras.size

    inner class FiguraViewHolder(private val binding: ItemFiguraBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(figura: Figura) {
            binding.textViewName.text = figura.nombre
            Glide.with(binding.imageView.context)
                .load(figura.logo)
                .into(binding.imageView)
        }
    }
}