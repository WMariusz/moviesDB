package com.wmariusz.moviesdb.presentation.cast

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.wmariusz.moviesdb.R
import com.wmariusz.moviesdb.extention.inflate
import com.wmariusz.moviesdb.network.model.MovieCast
import kotlinx.android.synthetic.main.item_cast.view.*

class CastAdapter : RecyclerView.Adapter<CastAdapter.ViewHolder>() {

    private val data = mutableListOf<MovieCast>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_cast))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder) {
        bind(data[position])
    }

    fun swapData(cast: List<MovieCast>) {
        data.clear()
        data.addAll(cast)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(cast: MovieCast) = with(itemView) {
            castCharacter.text = cast.character
            castName.text = cast.name
        }
    }
}