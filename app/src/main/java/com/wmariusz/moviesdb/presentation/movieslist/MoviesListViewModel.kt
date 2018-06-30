package com.wmariusz.moviesdb.presentation.movieslist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.wmariusz.moviesdb.network.model.Movie
import com.wmariusz.moviesdb.usecase.TopMoviesUseCase
import javax.inject.Inject

class MoviesListViewModel
@Inject constructor(
    private val topMoviesUseCase: TopMoviesUseCase
) : ViewModel() {

    private val mutableMoviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>> = mutableMoviesList

    fun topMovies() = topMoviesUseCase.topMovies()
        .subscribe { topMovies -> mutableMoviesList.postValue(topMovies.results) }

}