package com.wmariusz.moviesdb.network.model

import com.squareup.moshi.Json

data class TvSeries(
        val id: String,
        val name: String,
        @Json(name = "vote_count") val voteCount: Int,
        @Json(name = "vote_average") val voteAverage: Double,
        @Json(name = "backdrop_path") val posterPath: String,
        val overview: String,
        @Json(name = "first_air_date") val releaseDate: String
) {
    val posterUrl = "https://image.tmdb.org/t/p/original/$posterPath"
}