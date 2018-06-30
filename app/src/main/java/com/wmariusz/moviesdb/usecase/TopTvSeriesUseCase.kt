package com.wmariusz.moviesdb.usecase

import com.wmariusz.moviesdb.network.MovieService
import javax.inject.Inject

class TopTvSeriesUseCase
@Inject constructor(
        private val movieService: MovieService
) {

    fun topTvSeries() = movieService.topTvSeries()
}