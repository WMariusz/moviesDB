package com.wmariusz.moviesdb.presentation.moviedetail

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.wmariusz.moviesdb.R
import com.wmariusz.moviesdb.extention.observeNotNull
import com.wmariusz.moviesdb.injection.GlideApp
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movie_detail.movieCast
import kotlinx.android.synthetic.main.fragment_movie_detail.movieDescription
import kotlinx.android.synthetic.main.fragment_movie_detail.moviePoster
import kotlinx.android.synthetic.main.fragment_movie_detail.movieTitle
import javax.inject.Inject

class MovieDetailFragment : DaggerFragment() {

    @Inject lateinit var navigator: MovieDetailNavigator
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_movie_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieDetailViewModel::class.java)
        observeViewModel()

        val movieId = MovieDetailFragmentArgs.fromBundle(arguments).movieId

        viewModel.movieDetail(movieId)

        movieCast.setOnClickListener { v ->
            navigator.toMovieCase(v.findNavController(), movieId)
        }

    }

    private fun observeViewModel() {
        viewModel.movieDetail.observeNotNull(this) { movie ->
            movieTitle.text = movie.title
            movieDescription.text = movie.overview

            GlideApp.with(this)
                .load(movie.posterUrl)
                .placeholder(R.drawable.ic_movies)
                .centerInside()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(moviePoster)
        }
    }
}