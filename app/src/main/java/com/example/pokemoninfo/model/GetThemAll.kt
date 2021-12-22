package com.example.pokemoninfo.model

import io.reactivex.rxjava3.core.Single

interface GetThemAll {

    fun getThemAll(id: Int) : Single<FinalPokedex>
}