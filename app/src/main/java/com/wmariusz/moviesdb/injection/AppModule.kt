package com.wmariusz.moviesdb.injection

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun context(application: Application): Context = application.applicationContext
}
