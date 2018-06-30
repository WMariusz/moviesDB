package com.wmariusz.moviesdb.usecase

import com.wmariusz.moviesdb.network.MovieService
import javax.inject.Inject

class MovieDetailUseCase
@Inject constructor(
        private val movieService: MovieService
) {
    fun movieDetail(movieId: String) = movieService.movieDetails(movieId)
}