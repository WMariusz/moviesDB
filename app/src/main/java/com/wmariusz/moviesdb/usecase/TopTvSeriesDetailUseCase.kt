package com.wmariusz.moviesdb.usecase

import com.wmariusz.moviesdb.network.MovieService
import javax.inject.Inject

class TopTvSeriesDetailUseCase
@Inject constructor(
        private val movieService: MovieService
) {

    fun tvSeriesDetail(tvSeriesId: String) = movieService.tvSeriesDetails(tvSeriesId)
}