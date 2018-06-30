package com.wmariusz.moviesdb.usecase

import com.wmariusz.moviesdb.network.MovieService
import javax.inject.Inject

class MovieCastUseCase
@Inject constructor(
        private val moviesService: MovieService
) {
    fun movieCredits(movieId: String) = moviesService.movieCredits(movieId)
}