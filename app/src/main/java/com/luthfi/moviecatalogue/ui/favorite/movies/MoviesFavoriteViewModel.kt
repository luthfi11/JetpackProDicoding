package com.luthfi.moviecatalogue.ui.favorite.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.luthfi.moviecatalogue.data.db.AppDatabase
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.data.repo.local.LocalMovieRepository


class MoviesFavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: LocalMovieRepository

    init {
        val movieDao = AppDatabase.getDatabase(application).movieDao()
        repo = LocalMovieRepository(movieDao)
    }

    fun getAllMovie(): LiveData<PagedList<Movie>> {
        return LivePagedListBuilder(repo.getAllMovie(), 10).build()
    }

}
