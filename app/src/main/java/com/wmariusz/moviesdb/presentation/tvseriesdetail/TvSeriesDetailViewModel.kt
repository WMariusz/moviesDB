package com.wmariusz.moviesdb.presentation.tvseriesdetail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.wmariusz.moviesdb.network.model.TvSeries
import com.wmariusz.moviesdb.usecase.TopTvSeriesDetailUseCase
import javax.inject.Inject

class TvSeriesDetailViewModel
@Inject constructor(
        private val tvSeriesDetailUseCase: TopTvSeriesDetailUseCase
) : ViewModel() {

    private val mutableTvSeriesDetails = MutableLiveData<TvSeries>()
    val tvSeriesDetails: LiveData<TvSeries> = mutableTvSeriesDetails

    fun showTvSeriesDetails(tvSeriesId: String) {
        tvSeriesDetailUseCase.tvSeriesDetail(tvSeriesId).subscribe { details ->
            mutableTvSeriesDetails.postValue(details)
        }
    }
}