package com.example.pokemoninfo.model

data class FinalPokedex(
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
    val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    val frontDefault: String
)

data class DreamWorld(
    val fontDefault: String,
    val frontFemale: String
)

data class Stats(
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