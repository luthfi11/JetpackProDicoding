package com.luthfi.moviecatalogue.ui.detail

import com.luthfi.moviecatalogue.R
import com.luthfi.moviecatalogue.data.model.Movie
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private lateinit var data: Movie

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        data = Movie(1,"Avengers Infinity War","Test","2018", R.drawable.poster_infinity_war)
    }

    @Test
    fun getDetail() {
        val movie = viewModel.getDetail(data)
        assertNotNull(movie)
        assertEquals(movie, data)
    }
}