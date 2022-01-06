package com.example.pokemoninfo.data

import retrofit2.http.GET
import retrofit2.http.Path
import io.reactivex.rxjava3.core.Observable

interface PokeApi {
    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id: Int) : Observable<PokeApiResponse>

    @GET("pokemon/?offset=0&limit=90000")
    fun getListOfPokemonName() : Observable<PokeApiResponseListPokemon>
}