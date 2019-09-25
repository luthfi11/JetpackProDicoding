package com.luthfi.moviecatalogue.ui.tvshow

import com.luthfi.moviecatalogue.data.model.Movie
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel

    @Before
    fun setUp() {
        viewModel = TVShowViewModel()
    }

    @Test
    fun getTV() {
        val listMovie: List<Movie> = viewModel.getTV()
        assertNotNull(listMovie)
        assertEquals(10, listMovie.size)
    }
}