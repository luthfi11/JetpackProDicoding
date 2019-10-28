package com.luthfi.moviecatalogue.data.repo.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.luthfi.moviecatalogue.data.dao.MovieDao
import com.luthfi.moviecatalogue.data.model.Movie

class LocalMovieRepository(private val movieDao: MovieDao) {

    fun getAllMovie(): DataSource.Factory<Int, Movie> {
        return movieDao.getAllMovie()
    }

    fun check(id: Int?): LiveData<List<Movie>> {
        return movieDao.checkMovie(id)
    }

    suspend fun insert(movie: Movie) {
        movieDao.insertMovie(movie)
    }

    suspend fun delete(movie: Movie) {
        movieDao.deleteMovie(movie)
    }
}