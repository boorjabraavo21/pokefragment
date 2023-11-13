package com.turing.alan.fragmentspokemon.ui.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turing.alan.fragmentspokemon.data.PokemonRepository
import com.turing.alan.fragmentspokemon.model.PokemonApiModel
import kotlinx.coroutines.launch

class PokemonListViewModel(): ViewModel() {

    private val repository = PokemonRepository.getInstance()
    private var _pokemon = MutableLiveData<PokemonApiModel>()
    val pokemon: LiveData<PokemonApiModel>
        get() = _pokemon
    init {
        fetch()
        val observer = Observer<PokemonApiModel> {

        }
    }
    fun fetch() {
        viewModelScope.launch {
            repository.fetch()
            _pokemon = repository.pokemon as MutableLiveData<PokemonApiModel>
        }
    }
}