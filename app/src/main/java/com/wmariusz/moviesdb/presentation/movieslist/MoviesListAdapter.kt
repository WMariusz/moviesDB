package com.wmariusz.moviesdb.presentation.movieslist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.wmariusz.moviesdb.R
import com.wmariusz.moviesdb.extention.inflate
import com.wmariusz.moviesdb.injection.GlideApp
import com.wmariusz.moviesdb.network.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesListAdapter(
    private val onMovieClick: (Movie) -> Unit
) : RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {

    private val movies = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.item_movie))

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder) {
        bind(movies[position], onMovieClick)
    }

    fun swapData(data: List<Movie>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie, onMovieClick: (Movie) -> Unit) = with(itemView) {
            movieTitle.text = movie.title
            GlideApp.with(this)
                .load(movie.posterUrl)
                .placeholder(R.drawable.ic_movies)
                .centerInside()
                .transition(withCrossFade())
                .into(moviePoster)

            setOnClickListener {
                onMovieClick(movie)
            }
        }
    }
}