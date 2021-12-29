package com.example.pokemoninfo.data

data class PokemonResultList(val result: List<PokeApiResponseListPokemon>)

data class PokeApiResponseListPokemon(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)

data class Result(
    val name: String,
    val url: String
)

