package com.wmariusz.moviesdb.network.model

import com.squareup.moshi.Json

data class Movie(
        val id: String,
        @Json(name = "vote_count") val voteCount: Int,
        @Json(name = "vote_average") val voteAverage: Double,
        val title: String,
        @Json(name = "poster_path") val posterPath: String,
        val adult: Boolean,
        val overview: String,
        @Json(name = "release_date") val releaseDate: String
) {
    val posterUrl = "https://image.tmdb.org/t/p/original/$posterPath"
}