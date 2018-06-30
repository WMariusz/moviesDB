package com.wmariusz.moviesdb.network

import com.wmariusz.moviesdb.network.model.Movie
import com.wmariusz.moviesdb.network.model.MovieCredits
import com.wmariusz.moviesdb.network.model.TopMovies
import com.wmariusz.moviesdb.network.model.TopTvSeries
import com.wmariusz.moviesdb.network.model.TvSeries
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("movie/popular")
    fun topMovies(): Single<TopMovies>

    @GET("movie/{movieId}")
    fun movieDetails(@Path("movieId") movieId: String): Single<Movie>

    @GET("movie/{movieId}/credits")
    fun movieCredits(@Path("movieId") movieId: String): Single<MovieCredits>

    @GET("tv/popular")
    fun topTvSeries(): Single<TopTvSeries>

    @GET("tv/{tvSeriesId}")
    fun tvSeriesDetails(@Path("tvSeriesId") tvSeriesId: String): Single<TvSeries>
}