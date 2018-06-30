package com.wmariusz.moviesdb.presentation.tvserieslist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.wmariusz.moviesdb.R
import com.wmariusz.moviesdb.extention.inflate
import com.wmariusz.moviesdb.injection.GlideApp
import com.wmariusz.moviesdb.network.model.TvSeries
import kotlinx.android.synthetic.main.item_tv_series.view.tvSeriesPoster
import kotlinx.android.synthetic.main.item_tv_series.view.tvSeriesTitle

class TvSeriesListAdapter(
        private val onTvSeriesClick: (TvSeries) -> Unit
) : RecyclerView.Adapter<TvSeriesListAdapter.ViewHolder>() {

    private val tvSeries = mutableListOf<TvSeries>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.item_tv_series))

    override fun getItemCount() = tvSeries.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder) {
        bind(tvSeries[position], onTvSeriesClick)
    }

    fun swapData(data: List<TvSeries>) {
        tvSeries.clear()
        tvSeries.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvSeries: TvSeries, onTvSeriesClick: (TvSeries) -> Unit) = with(itemView) {
            tvSeriesTitle.text = tvSeries.name
            GlideApp.with(this)
                    .load(tvSeries.posterUrl)
                    .placeholder(R.drawable.ic_tv)
                    .centerInside()
                    .transition(withCrossFade())
                    .into(tvSeriesPoster)

            setOnClickListener {
                onTvSeriesClick(tvSeries)
            }
        }
    }
}