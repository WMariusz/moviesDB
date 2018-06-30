package com.wmariusz.moviesdb.presentation.tvserieslist

import android.arch.lifecycle.ViewModel
import com.wmariusz.moviesdb.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class TvSeriesListBuilder {
    @ContributesAndroidInjector
    internal abstract fun tvSeriesListFragment(): TvSeriesListFragment

    @Binds
    @IntoMap
    @ViewModelKey(TvSeriesListViewModel::class)
    abstract fun tvSeriesListViewModel(viewModel: TvSeriesListViewModel): ViewModel
}