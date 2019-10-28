package com.luthfi.moviecatalogue.data.repo.remote

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.luthfi.moviecatalogue.data.model.Movie

class MovieDataSourceFactory: DataSource.Factory<Int, Movie>() {

    private val movieLiveDataSource = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource()
        movieLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}