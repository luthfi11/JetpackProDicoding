package com.luthfi.moviecatalogue.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.luthfi.moviecatalogue.data.model.MovieResponse
import com.luthfi.moviecatalogue.data.repo.MovieRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class MoviesViewModelTest {

    @Rule @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MoviesViewModel

    @Mock
    private lateinit var repo: MovieRepository

    @Mock
    private lateinit var observer: Observer<MovieResponse>

    @Mock
    private lateinit var movieResponse: MovieResponse

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MoviesViewModel()
    }

    @Test
    fun getListMovie() {
        val response = MutableLiveData<MovieResponse>()

        `when`(repo.getListMovies()).thenReturn(response)

        viewModel.getLitMovie().observeForever(observer)
        observer.onChanged(movieResponse)
        verify(observer).onChanged(movieResponse)
    }
}