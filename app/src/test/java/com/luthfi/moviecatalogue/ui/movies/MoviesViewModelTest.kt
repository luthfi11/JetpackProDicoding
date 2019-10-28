package com.luthfi.moviecatalogue.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.data.repo.remote.RemoteRepository
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
    private lateinit var repo: RemoteRepository

    @Mock
    private lateinit var observer: Observer<PagedList<Movie>>

    @Mock
    private lateinit var movieResponse: PagedList<Movie>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MoviesViewModel()
    }

    @Test
    fun getListMovie() {
        val response = MutableLiveData<PagedList<Movie>>()

        `when`(repo.getMovieList()).thenReturn(response)

        viewModel.getListMovie().observeForever(observer)
        observer.onChanged(movieResponse)
        verify(observer).onChanged(movieResponse)
    }
}