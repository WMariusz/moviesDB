package com.wmariusz.moviesdb.presentation.moviedetail

import android.os.Bundle
import androidx.navigation.NavController
import com.wmariusz.moviesdb.ARG_MOVIE_ID
import com.wmariusz.moviesdb.R
import javax.inject.Inject

class MovieDetailNavigator @Inject constructor() {

    fun toMovieCase(navController: NavController, movieId: String) {
        navController.navigate(
            MovieDetailFragmentDirections.fromDetailToCast(movieId)
        )
    }
}