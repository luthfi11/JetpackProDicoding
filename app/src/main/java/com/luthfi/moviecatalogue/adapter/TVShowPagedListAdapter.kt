package com.luthfi.moviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.TVShow
import com.luthfi.moviecatalogue.ui.detail.tvdetail.TVShowDetailActivity
import kotlinx.android.synthetic.main.item_movies.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class TVShowPagedListAdapter : PagedListAdapter<TVShow, TVShowPagedListAdapter.ViewHolder>(
    DIFF_CALLBACK
) {

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
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TVShow>() {
            override fun areItemsTheSame(oldItem: TVShow, newItem: TVShow): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TVShow, newItem: TVShow): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(TVShow: TVShow?) {
            with(itemView) {
                Glide.with(context).load("https://image.tmdb.org/t/p/w185/${TVShow?.poster_path}")
                    .placeholder(android.R.color.darker_gray).into(imgMovie)
                tvTitle.text = TVShow?.name
                tvOverview.text = TVShow?.overview

                onClick { context.startActivity<TVShowDetailActivity>("tv" to TVShow) }
            }
        }
    }
}