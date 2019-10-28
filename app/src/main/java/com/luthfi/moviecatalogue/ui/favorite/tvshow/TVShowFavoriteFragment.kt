package com.luthfi.moviecatalogue.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.adapter.TVShowPagedListAdapter
import kotlinx.android.synthetic.main.tvshow_favorite_fragment.*

class TVShowFavoriteFragment : Fragment() {

    private lateinit var viewModel: TVShowFavoriteViewModel
    private lateinit var adapter: TVShowPagedListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tvshow_favorite_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecycler()

        viewModel = ViewModelProviders.of(this).get(TVShowFavoriteViewModel::class.java)
        viewModel.getAllTV().observe(this, Observer {
            adapter.submitList(it)
        })
    }

    private fun setupRecycler() {
        adapter = TVShowPagedListAdapter()
        rvTV.setHasFixedSize(true)
        rvTV.layoutManager = LinearLayoutManager(context)
        rvTV.adapter = adapter
    }

}
