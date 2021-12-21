package com.example.pokemoninfo.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id: Int) : Single<PokemonInformation>
}