package com.wmariusz.moviesdb.presentation.moviedetail

import android.arch.lifecycle.ViewModel
import com.wmariusz.moviesdb.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class MovieDetailBuilder {
    @ContributesAndroidInjector
    internal abstract fun movieDetailFragment(): MovieDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun movieDetailViewModel(viewModel: MovieDetailViewModel): ViewModel
}