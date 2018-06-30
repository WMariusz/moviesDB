package com.wmariusz.moviesdb.presentation.tvseriesdetail

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.wmariusz.moviesdb.R
import com.wmariusz.moviesdb.extention.observeNotNull
import com.wmariusz.moviesdb.injection.GlideApp
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_tv_series_detail.tvSeriesDescription
import kotlinx.android.synthetic.main.fragment_tv_series_detail.tvSeriesTitle
import kotlinx.android.synthetic.main.item_tv_series.tvSeriesPoster
import javax.inject.Inject

class TvSeriesDetailFragment : DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: TvSeriesDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_tv_series_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSeriesId = TvSeriesDetailFragmentArgs.fromBundle(arguments).tvShowId

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TvSeriesDetailViewModel::class.java)
        observeViewModel()
        viewModel.showTvSeriesDetails(tvSeriesId)
    }

    private fun observeViewModel() {
        viewModel.tvSeriesDetails.observeNotNull(this) { details ->
            tvSeriesTitle.text = details.name
            tvSeriesDescription.text = details.overview

            GlideApp.with(this)
                    .load(details.posterUrl)
                    .placeholder(R.drawable.ic_tv)
                    .centerInside()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(tvSeriesPoster)
        }
    }
}