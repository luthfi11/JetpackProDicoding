package com.luthfi.moviecatalogue.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_movies.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MoviesAdapter(private val movies: List<Movie>): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie) {
            Glide.with(itemView.context).load(movie.poster).placeholder(android.R.color.darker_gray).into(itemView.imgMovie)
            itemView.tvTitle.text = movie.title
            itemView.tvOverview.text = movie.overview

            itemView.onClick { itemView.context.startActivity<DetailActivity>("data" to movie) }
        }
    }
}