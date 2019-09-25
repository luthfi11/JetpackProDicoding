package com.luthfi.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.ui.movies.MoviesAdapter
import kotlinx.android.synthetic.main.tvshow_fragment.*

class TVShowFragment : Fragment() {

    private lateinit var viewModel: TVShowViewModel
    private lateinit var adapter: MoviesAdapter
    private lateinit var tvList: List<Movie>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tvshow_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(TVShowViewModel::class.java)
        tvList = viewModel.getTV()
        adapter = MoviesAdapter(tvList)

        rvTV.layoutManager = LinearLayoutManager(context)
        rvTV.setHasFixedSize(true)
        rvTV.adapter = adapter
    }

}
