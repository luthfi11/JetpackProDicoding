package com.luthfi.moviecatalogue.data.repo.remote

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.luthfi.moviecatalogue.data.model.TVShow

class TVShowDataSourceFactory: DataSource.Factory<Int, TVShow>() {

    private val tvLiveDataSource = MutableLiveData<TVShowDataSource>()

    override fun create(): DataSource<Int, TVShow> {
        val tvDataSource = TVShowDataSource()
        tvLiveDataSource.postValue(tvDataSource)
        return tvDataSource
    }
}