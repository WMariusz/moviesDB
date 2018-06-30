package com.wmariusz.moviesdb.injection

import com.wmariusz.moviesdb.BuildConfig
import com.wmariusz.moviesdb.network.MovieService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class RetrofitModule {

    @Provides
    fun moshi() = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    fun moshiConverterFactory(moshi: Moshi) = MoshiConverterFactory.create(moshi)

    @Provides
    fun interceptor() = Interceptor { chain ->
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build()

        val requestBuilder = original.newBuilder().url(url)

        chain.proceed(requestBuilder.build())
    }

    @Provides
    fun loggingInterceptor() = HttpLoggingInterceptor().apply {
        if (BuildConfig.DEBUG) {
            level = Level.BODY
        } else {
            level = Level.NONE
        }
    }

    @Provides
    fun okHttpClient(apiKeyInterceptor: Interceptor, loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

    @Reusable
    @Provides
    fun retrofit(moshiConverterFactory: MoshiConverterFactory, okHttpClient: OkHttpClient) = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.newThread()))
            .addConverterFactory(moshiConverterFactory)
            .client(okHttpClient)
            .build()

    @Reusable
    @Provides
    fun movieService(retrofit: Retrofit) = retrofit.create(MovieService::class.java)
}