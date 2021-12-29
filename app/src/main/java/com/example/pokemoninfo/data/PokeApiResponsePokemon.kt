package com.example.pokemoninfo.data

import com.squareup.moshi.Json

data class PokeApiResponse(
    @field:Json(name = "abilities")
    val abilitiesResponse: List<AbilitiesResponse>,
    @field:Json(name = "height")
    val heightResponse: Int,
    @field:Json(name = "id")
    val idResponse: Int,
    @field:Json(name = "moves")
    val movesResponse: List<MovesResponse>,
    @field:Json(name = "name")
    val nameResponse: String,
    @field:Json(name = "sprites")
    val spritesResponse: SpritesResponse,
    @field:Json(name = "stats")
    val statsResponse: List<StatsResponse>,
    @field:Json(name = "types")
    val typesResponse: List<TypesResponse>,
    @field:Json(name = "weight")
    val weightResponse: Int
)

data class AbilitiesResponse(
    @field:Json(name = "ability")
    val abilityResponse: AbilityResponse,
    @field:Json(name = "slot")
    val slotResponse: Int
)

data class AbilityResponse(
    @field:Json(name = "name")
    val nameResponse: String,
//    val url: String
)

data class MovesResponse(
    @field:Json(name = "move")
    val moveResponse: MoveResponse,
)

data class MoveResponse(
    @field:Json(name = "name")
    val nameResponse: String,
)

data class SpritesResponse(
    @field:Json(name = "other")
    val otherResponse: OtherResponse,
)

data class OtherResponse(
    @field:Json(name = "dream_world")
    val dreamWorldResponse: DreamWorldResponse,
    @field:Json(name = "official-artwork")
    val officialArtworkResponse: OfficialArtworkResponse
)

data class OfficialArtworkResponse(
    @field:Json(name = "front_default")
    val frontDefaultResponse: String
)

data class DreamWorldResponse(
    @field:Json(name = "font_default")
    val fontDefaultResponse: String,
    @field:Json(name = "front_female")
    val frontFemaleResponse: String
)

data class StatsResponse(
    @field:Json(name = "base_stat")
    val baseStatResponse: Int,
    @field:Json(name = "stat")
    val statResponse: StatResponse
)

data class StatResponse(
    @field:Json(name = "name")
    val nameResponse: String,
    @field:Json(name = "url")
    val urlResponse: String
)

data class TypesResponse(
    @field:Json(name = "slot")
    val slotResponse: Int,
    @field:Json(name = "type")
    val typeResponse: TypeResponse
)

data class TypeResponse(
    @field:Json(name = "name")
    val nameResponse: String,
)