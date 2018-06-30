package com.wmariusz.moviesdb.injection

import com.wmariusz.moviesdb.OMDbApp
import com.wmariusz.moviesdb.presentation.cast.CastBuilder
import com.wmariusz.moviesdb.presentation.moviedetail.MovieDetailBuilder
import com.wmariusz.moviesdb.presentation.movieslist.MoviesListBuilder
import com.wmariusz.moviesdb.presentation.navigation.NavigationBuilder
import com.wmariusz.moviesdb.presentation.tvseriesdetail.TvSeriesDetailBuilder
import com.wmariusz.moviesdb.presentation.tvserieslist.TvSeriesListBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ViewModelBuilder::class,
    AppModule::class,
    RetrofitModule::class,
    NavigationBuilder::class,
    MoviesListBuilder::class,
    MovieDetailBuilder::class,
    CastBuilder::class,
    TvSeriesListBuilder::class,
    TvSeriesDetailBuilder::class
])
interface AppComponent : AndroidInjector<OMDbApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<OMDbApp>()
}
