package com.example.pokemoninfo.data

import com.example.pokemoninfo.model.FinalPokedex
import com.example.pokemoninfo.model.GetThemAll
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

//class Service @Inject constructor(private val api: PokeApi) : GetThemAll {
//
//    override fun getThemAll(id: Int): Single<FinalPokedex> {
//        return api.getPokemon(id = id).map { it.toDomainModel }
//    }
//}