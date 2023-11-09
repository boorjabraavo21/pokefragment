package com.turing.alan.fragmentspokemon.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.turing.alan.fragmentspokemon.databinding.FragmentPokemonDetailBinding

class PokemonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPokemonDetailBinding
    private val args: PokemonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonDetailBinding.inflate( inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pokemon = args.pokemon
        binding.pokemonNameText.text = pokemon.name
        binding.pokemonDescriptionText.text = pokemon.description
        binding.pokemonImage.setImageResource(pokemon.imageId)
        val chipGroup:ChipGroup = binding.pokemonTypes
        val chip:Chip = Chip(view.context).apply {
            text = pokemon.mainType
        }

        chipGroup.addView(chip)
        if (pokemon.secondaryType != null) {
            chipGroup.addView(Chip(view.context).apply { text = pokemon.secondaryType })
        }
    }


}