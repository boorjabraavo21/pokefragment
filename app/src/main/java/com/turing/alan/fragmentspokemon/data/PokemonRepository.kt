package com.turing.alan.fragmentspokemon.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.turing.alan.fragmentspokemon.model.PokemonApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("/api/v2/pokemon/{id}/")
    suspend fun fetchPokemon(@Path("id") id:String): PokemonApiModel
}
class PokemonRepository private constructor(private val api: PokemonApi) {
    //private val _pokemons = mutableListOf<Pokemon>()
    private val _pokemon = MutableLiveData<PokemonApiModel>()
    val pokemon: LiveData<PokemonApiModel>
        get() = _pokemon
    /*val pokemons: List<Pokemon>
        get() = _pokemons*/
    companion object {

        private var _INSTANCE: PokemonRepository? = null
        fun getInstance():PokemonRepository {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create()).build()

            val pokemonApi = retrofit.create(PokemonApi::class.java)

            _INSTANCE = _INSTANCE ?: PokemonRepository(pokemonApi)
            return _INSTANCE!!
        }
    }

   suspend fun fetch() {
       val pokemonResponse = api.fetchPokemon("1")
       Log.d("BORJA",pokemonResponse.toString())
       _pokemon.value = pokemonResponse
    }
    /*init {
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
    }*/


}