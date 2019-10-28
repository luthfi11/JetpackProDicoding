package com.luthfi.moviecatalogue.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.data.repo.remote.RemoteRepository

class MoviesViewModel : ViewModel() {

    private val isRefresh = MutableLiveData<Boolean>()
    private val repo = RemoteRepository()

    private val movie: LiveData<PagedList<Movie>> = Transformations.switchMap(isRefresh) {
        repo.getMovieList()
    }

    init {
        refreshMovie()
    }

    fun getListMovie() = movie

    fun refreshMovie() {
        isRefresh.postValue(true)
    }
}
