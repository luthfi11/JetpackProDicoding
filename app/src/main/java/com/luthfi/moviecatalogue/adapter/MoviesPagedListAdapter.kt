package com.luthfi.moviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.ui.detail.moviedetail.MovieDetailActivity
import kotlinx.android.synthetic.main.item_movies.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MoviesPagedListAdapter :
    PagedListAdapter<Movie, MoviesPagedListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movies,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie?) {

            with(itemView) {
                Glide.with(context).load("https://image.tmdb.org/t/p/w185/${movie?.poster_path}")
                    .placeholder(android.R.color.darker_gray).into(imgMovie)
                tvTitle.text = movie?.title
                tvOverview.text = movie?.overview

                onClick { context.startActivity<MovieDetailActivity>("movie" to movie) }
            }
        }
    }
}