package com.example.pokemoninfo.model

data class FinalPokedex(
    val pokemon_entries: List<PokemonEntry>,
)

data class PokemonEntry(
    val entry_number: Int,
    val pokemon_species: PokemonSpecies
)

data class PokemonSpecies(
    val name: String,
    val url: String
)