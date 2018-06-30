package com.wmariusz.moviesdb.presentation.tvserieslist

import androidx.navigation.NavController
import javax.inject.Inject

class TvSeriesListNavigator @Inject constructor() {

    fun toTvSeriesDetail(navController: NavController, tvSeriesId: String) {
            navController.navigate(
                TvSeriesListFragmentDirections.showTvDetaildFromList(tvSeriesId)
            )
    }
}