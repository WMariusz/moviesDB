package com.wmariusz.moviesdb.presentation.cast

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.wmariusz.moviesdb.network.model.MovieCast
import com.wmariusz.moviesdb.usecase.MovieCastUseCase
import javax.inject.Inject

class CastViewModel
@Inject constructor(
    private val movieCastUseCase: MovieCastUseCase
) : ViewModel() {

    private val mutableCast = MutableLiveData<List<MovieCast>>()
    val cast: LiveData<List<MovieCast>> = mutableCast

    fun cast(movieId: String) = movieCastUseCase.movieCredits(movieId)
        .subscribe { movieCredits -> mutableCast.postValue(movieCredits.cast) }
}