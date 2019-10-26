package com.luthfi.moviecatalogue.ui.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.TVShow
import com.luthfi.moviecatalogue.ui.tvdetail.TVShowDetailActivity
import kotlinx.android.synthetic.main.item_movies.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class TVAdapter(private var tvShow: MutableList<TVShow>) : RecyclerView.Adapter<TVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movies,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return tvShow.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tvShow[position])
    }

    fun setData(data: List<TVShow>) {
        tvShow.clear()
        tvShow.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(TVShow: TVShow) {

            with(itemView) {
                Glide.with(context).load("https://image.tmdb.org/t/p/w185/${TVShow.poster_path}")
                    .placeholder(android.R.color.darker_gray).into(imgMovie)
                tvTitle.text = TVShow.name
                tvOverview.text = TVShow.overview

                onClick { context.startActivity<TVShowDetailActivity>("tv" to TVShow) }
            }
        }
    }
}