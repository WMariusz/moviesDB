package com.wmariusz.moviesdb

import com.wmariusz.moviesdb.injection.DaggerAppComponent
import dagger.android.DaggerApplication
import timber.log.Timber
import timber.log.Timber.DebugTree

class OMDbApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(DebugTree())
    }

    override fun applicationInjector() = DaggerAppComponent.builder().create(this)
}