package com.luthfi.moviecatalogue.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.luthfi.moviecatalogue.data.model.MovieResponse
import com.luthfi.moviecatalogue.data.repo.MovieRepository

class MoviesViewModel : ViewModel() {

    private val isRefresh = MutableLiveData<Boolean>()
    private val repo = MovieRepository()

    private val movie: LiveData<MovieResponse> = Transformations.switchMap(isRefresh) {
        repo.getListMovies()
    }

    init {
        refreshMovie()
    }

    fun getLitMovie(): LiveData<MovieResponse> = movie

    fun refreshMovie() {
        isRefresh.postValue(true)
    }
}
