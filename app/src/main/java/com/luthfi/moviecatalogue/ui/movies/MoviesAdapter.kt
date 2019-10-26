package com.luthfi.moviecatalogue.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.ui.moviedetail.MovieDetailActivity
import kotlinx.android.synthetic.main.item_movies.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MoviesAdapter(private var movies: MutableList<Movie>): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun setData(data: List<Movie>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(movie: Movie) {

            with(itemView) {
                Glide.with(context).load("https://image.tmdb.org/t/p/w185/${movie.poster_path}").placeholder(android.R.color.darker_gray).into(imgMovie)
                tvTitle.text = movie.title
                tvOverview.text = movie.overview

                onClick { context.startActivity<MovieDetailActivity>("movie" to movie) }
            }
        }
    }
}