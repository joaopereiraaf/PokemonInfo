package com.example.pokemoninfo.data

import com.example.pokemoninfo.data.PokemonResponse.Pokedex
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PokeApi {

    @GET("pokedex/1/")
    fun getPokemons() : Single<List<Pokedex>>
}