package com.turing.alan.fragmentspokemon.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.turing.alan.fragmentspokemon.data.PokemonRepository
import com.turing.alan.fragmentspokemon.databinding.FragmentPokemonListBinding
import com.turing.alan.fragmentspokemon.model.Pokemon
import com.turing.alan.fragmentspokemon.model.PokemonApiModel
import com.turing.alan.fragmentspokemon.ui.adapter.PokemonAdapter
import com.turing.alan.fragmentspokemon.ui.adapter.PokemonListViewModel

class PokemonListFragment : Fragment() {
    private  val viewModel:PokemonListViewModel by viewModels()
    private val repository = PokemonRepository.getInstance()
    private lateinit var binding: FragmentPokemonListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonListBinding.inflate(inflater,
            container,
            false,
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val observer = Observer<PokemonApiModel> {
            binding.
        }
        viewModel.pokemon.observe(viewLifecycleOwner,observer)
        /*val recyclerView = binding.pokemonList
        val adapter = PokemonAdapter(::onShowDetail)
        adapter.submitList(repository.pokemons)
        recyclerView.adapter = adapter*/
    }
    private fun onShowDetail(pokemon: Pokemon,view:View) {
        val action = PokemonListFragmentDirections
            .actionPokemonListFragmentToPokemonDetailFragment(pokemon)
        view.findNavController().navigate(action)
    }


}