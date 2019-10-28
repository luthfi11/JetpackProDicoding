package com.luthfi.moviecatalogue.ui.favorite.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.adapter.MoviesPagedListAdapter
import kotlinx.android.synthetic.main.movies_favorite_fragment.*

class MoviesFavoriteFragment : Fragment() {

    private lateinit var viewModel: MoviesFavoriteViewModel
    private lateinit var adapter: MoviesPagedListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.movies_favorite_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecycler()

        viewModel = ViewModelProviders.of(this).get(MoviesFavoriteViewModel::class.java)
        viewModel.getAllMovie().observe(this, Observer {
            adapter.submitList(it)
        })
    }

    private fun setupRecycler() {
        adapter = MoviesPagedListAdapter()
        rvMovies.setHasFixedSize(true)
        rvMovies.layoutManager = LinearLayoutManager(context)
        rvMovies.adapter = adapter
    }

}
