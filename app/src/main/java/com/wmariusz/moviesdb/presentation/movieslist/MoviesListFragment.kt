package com.wmariusz.moviesdb.presentation.movieslist

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.wmariusz.moviesdb.R
import com.wmariusz.moviesdb.extention.observeNotNull
import com.wmariusz.moviesdb.extention.toast
import com.wmariusz.moviesdb.network.model.Movie
import com.wmariusz.moviesdb.util.LineDividerItemDecoration
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movie_list.moviesList
import javax.inject.Inject

class MoviesListFragment : DaggerFragment() {

    @Inject lateinit var navigator: MoviesListNavigator
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MoviesListViewModel

    private val adapter by lazy { MoviesListAdapter { movie -> onMovieClicked(movie) } }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_movie_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesList.adapter = adapter
        moviesList.layoutManager = LinearLayoutManager(context)
        moviesList.addItemDecoration(LineDividerItemDecoration(context!!, R.drawable.list_item_divider))

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MoviesListViewModel::class.java)
        observeViewModel()
        viewModel.topMovies()
    }

    private fun observeViewModel() {
        viewModel.moviesList.observeNotNull(this) { moviesList ->
            adapter.swapData(moviesList)
        }
    }

    private fun onMovieClicked(movie: Movie) {
        toast(movie.title)
        navigator.toMovieDetail(findNavController(), movie.id)
    }
}