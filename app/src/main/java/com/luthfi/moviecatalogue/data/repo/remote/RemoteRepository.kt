package com.luthfi.moviecatalogue.data.repo.remote

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.data.model.TVShow

class RemoteRepository {

    private val movieDataSourceFactory = MovieDataSourceFactory()
    private val tvDataSourceFactory = TVShowDataSourceFactory()

    private val config = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(10)
        .setPageSize(5)
        .build()

    fun getMovieList(): LiveData<PagedList<Movie>> {
        return LivePagedListBuilder(movieDataSourceFactory, config).build()
    }

    fun getTVShowList(): LiveData<PagedList<TVShow>> {
        return LivePagedListBuilder(tvDataSourceFactory, config).build()
    }
}