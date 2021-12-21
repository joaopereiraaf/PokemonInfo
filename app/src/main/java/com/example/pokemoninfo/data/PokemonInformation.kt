package com.example.pokemoninfo.data

import com.squareup.moshi.Json

data class PokemonInformation(
    val abilities: List<Abilities>,
    val height: Int,
    val id: Int,
    val moves: List<Moves>,
    val name: String,
    val sprites: Sprites,
    val stats: List<Stats>,
    val types: List<Types>,
    val weight: Int
)

data class Abilities(
    val ability: Ability,
    val slot: Int
)

data class Ability(
    val name: String,
//    val url: String
)

data class Moves(
    val move: Move,
)

data class Move(
    val name: String,
)

data class Sprites(
    val other: Other,
)

data class Other(
    val dream_world: DreamWorld,
    @field:Json(name = "official-artwork")
    val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    @field:Json(name = "front_default")
    val frontDefault: String
)

data class DreamWorld(
    @field:Json(name = "font_default")
    val fontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: String
)

data class Stats(
    @field:Json(name = "base_stat")
    val baseStat: Int,
    val stat: Stat
)

data class Stat(
    val name: String,
    val url: String
)

data class Types(
    val slot: Int,
    val type: Type
)

data class Type(
    val name: String,
)