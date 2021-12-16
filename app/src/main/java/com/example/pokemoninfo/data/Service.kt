package com.example.pokemoninfo.data

import com.example.pokemoninfo.data.PokemonResponse.Pokedex
import com.example.pokemoninfo.model.GetThemAll
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class Service @Inject constructor(private val api: PokeApi) : GetThemAll {

//    override fun getRepos(): Single<List<Pokedex>> {
//        return api.getPokemons().map { it.toDomainModel() }
//    }
}