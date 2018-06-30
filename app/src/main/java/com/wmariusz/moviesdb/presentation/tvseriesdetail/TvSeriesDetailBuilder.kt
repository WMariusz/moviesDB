package com.wmariusz.moviesdb.presentation.tvseriesdetail

import android.arch.lifecycle.ViewModel
import com.wmariusz.moviesdb.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class TvSeriesDetailBuilder {
    @ContributesAndroidInjector
    internal abstract fun tvSeriesDetailFragment(): TvSeriesDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(TvSeriesDetailViewModel::class)
    abstract fun tvSeriesDetailViewModel(viewModel: TvSeriesDetailViewModel): ViewModel
}