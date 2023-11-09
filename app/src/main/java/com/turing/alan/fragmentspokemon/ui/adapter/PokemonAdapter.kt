package com.turing.alan.fragmentspokemon.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.turing.alan.fragmentspokemon.databinding.PokemonItemBinding
import com.turing.alan.fragmentspokemon.model.Pokemon

class PokemonAdapter(private val onShowDetail:(p:Pokemon,v: View)->Unit

): ListAdapter<Pokemon,PokemonAdapter.PokemonItemViewHolder>(PokemonDiffCallback) {
    inner class PokemonItemViewHolder(private val binding: PokemonItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(p:Pokemon) {
            binding.pokemonImage.setImageResource(p.imageId)
            binding.nameText.text = p.name
            binding.descriptionText.text = p.description
            binding.showDetailButton.setOnClickListener {
                onShowDetail(p,binding.root)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonItemViewHolder {
        val binding = PokemonItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return PokemonItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private object PokemonDiffCallback:DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon) = oldItem == newItem

    }
}