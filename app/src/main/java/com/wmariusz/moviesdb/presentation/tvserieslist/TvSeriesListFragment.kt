package com.wmariusz.moviesdb.presentation.tvserieslist

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.wmariusz.moviesdb.R
import com.wmariusz.moviesdb.extention.observeNotNull
import com.wmariusz.moviesdb.network.model.TvSeries
import com.wmariusz.moviesdb.util.LineDividerItemDecoration
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_tv_list.tvSeriesList
import javax.inject.Inject

class TvSeriesListFragment : DaggerFragment() {

    @Inject lateinit var navigator: TvSeriesListNavigator
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: TvSeriesListViewModel

    val adapter by lazy { TvSeriesListAdapter { onTvSeriesClicked(it) } }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_tv_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvSeriesList.adapter = adapter
        tvSeriesList.layoutManager = LinearLayoutManager(context)
        tvSeriesList.addItemDecoration(LineDividerItemDecoration(context!!, R.drawable.list_item_divider))

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TvSeriesListViewModel::class.java)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.tvSeriesList.observeNotNull(this) {
            adapter.swapData(it)
        }
    }

    private fun onTvSeriesClicked(tvSeries: TvSeries) {
        navigator.toTvSeriesDetail(findNavController(), tvSeries.id)
    }
}