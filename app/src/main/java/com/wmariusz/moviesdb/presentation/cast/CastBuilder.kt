package com.wmariusz.moviesdb.presentation.cast

import android.arch.lifecycle.ViewModel
import com.wmariusz.moviesdb.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class CastBuilder {
    @ContributesAndroidInjector
    internal abstract fun castFragment(): CastFragment

    @Binds
    @IntoMap
    @ViewModelKey(CastViewModel::class)
    abstract fun castViewModel(viewModel: CastViewModel): ViewModel

}