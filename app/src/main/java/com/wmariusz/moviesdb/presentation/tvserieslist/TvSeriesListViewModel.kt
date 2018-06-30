package com.wmariusz.moviesdb.presentation.tvserieslist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.wmariusz.moviesdb.network.model.TvSeries
import com.wmariusz.moviesdb.usecase.TopTvSeriesUseCase
import javax.inject.Inject

class TvSeriesListViewModel
@Inject constructor(
        topTvSeriesUseCase: TopTvSeriesUseCase
) : ViewModel() {

    private val mutableTvSeriesList = MutableLiveData<List<TvSeries>>()
    val tvSeriesList: LiveData<List<TvSeries>> = mutableTvSeriesList

    init {
        topTvSeriesUseCase.topTvSeries().subscribe { topTvSeries ->
            mutableTvSeriesList.postValue(topTvSeries.results)
        }
    }
}