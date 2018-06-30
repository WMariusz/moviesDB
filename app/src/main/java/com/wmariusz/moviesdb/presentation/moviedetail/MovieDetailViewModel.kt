package com.wmariusz.moviesdb.presentation.moviedetail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.wmariusz.moviesdb.network.model.Movie
import com.wmariusz.moviesdb.usecase.MovieDetailUseCase
import javax.inject.Inject

class MovieDetailViewModel
@Inject constructor(
    private val movieDetailUseCase: MovieDetailUseCase
) : ViewModel() {

    private val mutableMovieDetail = MutableLiveData<Movie>()
    val movieDetail: LiveData<Movie> = mutableMovieDetail

    fun movieDetail(movieId: String) = movieDetailUseCase.movieDetail(movieId)
        .subscribe { movieDetail -> mutableMovieDetail.postValue(movieDetail) }
}