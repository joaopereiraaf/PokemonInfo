package com.example.pokemoninfo.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id: Int) : Single<PokeApiResponse>

    @GET("pokemon/?offset=0&limit=90000")
    fun getListOfPokemonName() : Single<List<PokeApiResponse>>
}