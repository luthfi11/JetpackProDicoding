package com.luthfi.moviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.utils.movieData

class MoviesViewModel : ViewModel() {

    fun getMovie(): List<Movie> {
        return movieData
    }
}
