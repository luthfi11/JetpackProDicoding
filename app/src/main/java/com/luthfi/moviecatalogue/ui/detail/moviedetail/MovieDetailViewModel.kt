package com.luthfi.moviecatalogue.ui.detail.moviedetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.luthfi.moviecatalogue.data.db.AppDatabase
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.data.repo.local.LocalMovieRepository
import kotlinx.coroutines.launch

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: LocalMovieRepository
    private val movieData = MutableLiveData<Movie>()

    init {
        val movieDao = AppDatabase.getDatabase(application).movieDao()
        repo = LocalMovieRepository(movieDao)
    }

    fun getMovie(movie: Movie): LiveData<Movie> {
        movieData.postValue(movie)
        return movieData
    }

    fun checkFavMovie(id: Int?): LiveData<List<Movie>> {
        return repo.check(id)
    }

    fun addMovieFav(movie: Movie) = viewModelScope.launch {
        repo.insert(movie)
    }

    fun deleteMovieFav(movie: Movie) = viewModelScope.launch {
        repo.delete(movie)
    }
}