package com.luthfi.moviecatalogue.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.adapter.MoviesPagedListAdapter
import kotlinx.android.synthetic.main.fragment_movies.*
import org.jetbrains.anko.support.v4.onRefresh

class MoviesFragment : Fragment() {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapter: MoviesPagedListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)

        setUpRecycler()
        getData()
        srlMovie.onRefresh { viewModel.refreshMovie() }
    }

    private fun setUpRecycler() {
        adapter = MoviesPagedListAdapter()
        rvMovies.layoutManager = LinearLayoutManager(context)
        rvMovies.setHasFixedSize(true)
        rvMovies.adapter = adapter
    }

    private fun getData() {
        srlMovie.isRefreshing = true
        viewModel.getListMovie().observe(this, Observer {
            displayData(it)
        })
    }

    private fun displayData(movie: PagedList<Movie>) {
        srlMovie.isRefreshing = false
        adapter.submitList(movie)
    }
}
