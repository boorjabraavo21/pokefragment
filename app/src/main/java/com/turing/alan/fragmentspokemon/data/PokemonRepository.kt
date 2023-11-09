package com.turing.alan.fragmentspokemon.data

import com.turing.alan.fragmentspokemon.R
import com.turing.alan.fragmentspokemon.model.Pokemon

class PokemonRepository private constructor(){
    private val _pokemons = mutableListOf<Pokemon>()
    val pokemons: List<Pokemon>
        get() = _pokemons
    companion object {
        private var _INSTANCE: PokemonRepository? = null
        fun getInstance():PokemonRepository {
            _INSTANCE = _INSTANCE ?: PokemonRepository()
            return _INSTANCE!!
        }
    }
    init {
        add(Pokemon(1,"Bulbasaur",
            "Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo",
            "Planta",
            "Veneno",
            R.drawable.bulbasaur))
        add(Pokemon(4,"Charmander",
            "Prefiere las cosas calientes. Dicen que cuando llueve le sale vapor de la punta de la cola",
            "Fuego",
            null,
            R.drawable.charmander))
        add(Pokemon(7,"Squirtle",
            "Cuando retrae su largo cuello en el caparazón, dispara agua a una presión increíble",
            "Agua",
            null,
            R.drawable.squirtle))
        add(Pokemon(25,"Pikachu",
            "Cuando se enfada, este Pokémon descarga la energía que almacena en el interior de las bolsas de las mejillas",
            "Eléctrico",
            null,
            R.drawable.pikachu))
    }

    fun add(pokemon: Pokemon) {
        _pokemons.add(pokemon)
    }


}