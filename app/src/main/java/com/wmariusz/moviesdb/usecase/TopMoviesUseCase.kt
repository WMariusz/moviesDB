package com.wmariusz.moviesdb.usecase

import com.wmariusz.moviesdb.network.MovieService
import javax.inject.Inject

class TopMoviesUseCase
@Inject constructor(
        private val movieService: MovieService
) {
    fun topMovies() = movieService.topMovies()
}