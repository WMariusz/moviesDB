package com.wmariusz.moviesdb.presentation.movieslist

import android.arch.lifecycle.ViewModel
import com.wmariusz.moviesdb.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class MoviesListBuilder {
    @ContributesAndroidInjector
    internal abstract fun moviesListFragment(): MoviesListFragment

    @Binds
    @IntoMap
    @ViewModelKey(MoviesListViewModel::class)
    abstract fun moviesListViewModel(viewModel: MoviesListViewModel): ViewModel

}