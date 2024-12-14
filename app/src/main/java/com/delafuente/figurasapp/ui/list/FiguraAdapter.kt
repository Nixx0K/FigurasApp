package com.delafuente.figurasapp.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.delafuente.figurasapp.data.Figura
import com.delafuente.figurasapp.databinding.ItemFiguraBinding

class FiguraAdapter(private val onClick: (Figura) -> Unit) :
    ListAdapter<Figura, FiguraAdapter.FiguraViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Figura>() {
        override fun areItemsTheSame(oldItem: Figura, newItem: Figura): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Figura, newItem: Figura): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FiguraViewHolder {
        val binding = ItemFiguraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FiguraViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FiguraViewHolder, position: Int) {
        val figura = getItem(position)
        holder.bind(figura, onClick)
    }

    class FiguraViewHolder(private val binding: ItemFiguraBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(figura: Figura, onClick: (Figura) -> Unit) {
            binding.nombre.text = figura.nombre
            binding.root.setOnClickListener { onClick(figura) }
        }
    }
}