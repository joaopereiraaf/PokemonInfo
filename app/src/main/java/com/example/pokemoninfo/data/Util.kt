package com.example.pokemoninfo.data

import com.example.pokemoninfo.model.FinalPokedex
import com.example.pokemoninfo.model.Abilities
import com.example.pokemoninfo.model.Ability

//fun PokeApiResponse.toDomainModel() : FinalPokedex {
//    return FinalPokedex(
//        abilities = abilitiesResponse.toAbilitiesDomainModel(),
//        height = heightResponse,
//        id = idResponse,
//        moves = PokeApiResponse().movesResponse,
//        name = nameResponse,
//        sprites = PokeApiResponse().spritesResponse,
//        stats = PokeApiResponse().statsResponse,
//        types = PokeApiResponse().typesResponse,
//        weight = weightResponse
//    )
//}
//
//fun AbilitiesResponse.toDomainModel() : Abilities {
//    return Abilities(
//        ability = abilityResponse.toDomainModel(),
//        slot = slotResponse
//    )
//}
//
//fun AbilityResponse.toDomainModel() : Ability {
//    return Ability(
//        name = nameResponse
//    )
//}
//
//fun List<AbilitiesResponse>.toAbilitiesDomainModel() : List<Abilities> {
//    return this.map { it.toDomainModel() }
//}
//
//fun List<PokeApiResponse>.toDomainModel() : List<FinalPokedex> {
//    return this.map { it.toDomainModel() }
//}