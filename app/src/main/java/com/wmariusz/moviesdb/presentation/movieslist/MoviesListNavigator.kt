package com.wmariusz.moviesdb.presentation.movieslist

import androidx.navigation.NavController
import javax.inject.Inject

class MoviesListNavigator @Inject constructor() {

    fun toMovieDetail(navController: NavController, movieId: String) {
        navController.navigate(
            MoviesListFragmentDirections.fromListToDetail(movieId)
        )
    }
}