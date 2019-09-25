package com.luthfi.moviecatalogue.ui.movies

import com.luthfi.moviecatalogue.data.model.Movie
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovie() {
        val listMovie: List<Movie> = viewModel.getMovie()
        assertNotNull(listMovie)
        assertEquals(10, listMovie.size)
    }
}