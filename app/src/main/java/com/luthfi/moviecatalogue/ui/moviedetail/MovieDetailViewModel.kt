package com.luthfi.moviecatalogue.ui.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.data.model.TVShow
import com.luthfi.moviecatalogue.data.repo.MovieRepository

class MovieDetailViewModel: ViewModel() {

    private val repo = MovieRepository()

    fun getMovie(movie: Movie): LiveData<Movie> {
        return repo.getMovieDetail(movie)
    }

}