package com.luthfi.moviecatalogue.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.Movie
import kotlinx.android.synthetic.main.movies_fragment.*
import org.jetbrains.anko.support.v4.onRefresh

class MoviesFragment : Fragment() {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapter: MoviesAdapter
    private var movieList = mutableListOf<Movie>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)

        setUpRecycler()
        getData()
        srlMovie.onRefresh { viewModel.refreshMovie() }
    }

    private fun setUpRecycler() {
        adapter = MoviesAdapter(movieList)
        rvMovies.layoutManager = LinearLayoutManager(context)
        rvMovies.setHasFixedSize(true)
        rvMovies.adapter = adapter
    }

    private fun getData() {
        srlMovie.isRefreshing = true
        viewModel.getLitMovie().observe(this, Observer {
            if (it.results.isNotEmpty()) displayData(it.results)
        })
    }

    private fun displayData(movie: List<Movie>) {
        srlMovie.isRefreshing = false
        adapter.setData(movie)
    }
}
