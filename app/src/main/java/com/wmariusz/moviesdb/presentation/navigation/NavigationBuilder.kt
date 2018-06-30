package com.wmariusz.moviesdb.presentation.navigation

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class NavigationBuilder {
    @ContributesAndroidInjector
    internal abstract fun navigationActivity(): NavigationActivity
}