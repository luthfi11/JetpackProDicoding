package com.luthfi.moviecatalogue.ui.tvshow

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
import com.luthfi.moviecatalogue.data.model.TVShow
import com.luthfi.moviecatalogue.adapter.TVShowPagedListAdapter
import kotlinx.android.synthetic.main.fragment_tvshow.*
import org.jetbrains.anko.support.v4.onRefresh

class TVShowFragment : Fragment() {

    private lateinit var viewModel: TVShowViewModel
    private lateinit var adapter: TVShowPagedListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tvshow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(TVShowViewModel::class.java)

        setUpRecycler()
        getData()
        srlTV.onRefresh { viewModel.refreshTV() }
    }

    private fun setUpRecycler() {
        adapter = TVShowPagedListAdapter()
        rvTV.layoutManager = LinearLayoutManager(context)
        rvTV.setHasFixedSize(true)
        rvTV.adapter = adapter
    }

    private fun getData() {
        srlTV.isRefreshing = true
        viewModel.getTV().observe(this, Observer {
            displayData(it)
        })
    }

    private fun displayData(data: PagedList<TVShow>) {
        adapter.submitList(data)
        srlTV.isRefreshing = false
    }
}
