package com.luthfi.moviecatalogue.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.TVShow
import kotlinx.android.synthetic.main.tvshow_fragment.*
import org.jetbrains.anko.support.v4.onRefresh

class TVShowFragment : Fragment() {

    private lateinit var viewModel: TVShowViewModel
    private lateinit var adapter: TVAdapter
    private var tvList = mutableListOf<TVShow>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tvshow_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(TVShowViewModel::class.java)

        setUpRecycler()
        getData()
        srlTV.onRefresh { viewModel.refreshTV() }
    }

    private fun setUpRecycler() {
        adapter = TVAdapter(tvList)
        rvTV.layoutManager = LinearLayoutManager(context)
        rvTV.setHasFixedSize(true)
        rvTV.adapter = adapter
    }

    private fun getData() {
        srlTV.isRefreshing = true
        viewModel.getTV().observe(this, Observer {
            if (it.results.isNotEmpty()) displayData(it.results)
        })
    }

    private fun displayData(data: List<TVShow>) {
        adapter.setData(data)
        srlTV.isRefreshing = false
    }
}
