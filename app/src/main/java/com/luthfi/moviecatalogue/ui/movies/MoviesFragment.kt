package com.luthfi.moviecatalogue.ui.movies

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.Movie
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment() {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapter: MoviesAdapter
    private lateinit var movieList: List<Movie>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        movieList = viewModel.getMovie()

        adapter = MoviesAdapter(movieList)

        rvMovies.layoutManager = LinearLayoutManager(context)
        rvMovies.setHasFixedSize(true)
        rvMovies.adapter = adapter
    }
}
