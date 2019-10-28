package com.luthfi.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.luthfi.moviecatalogue.data.model.TVResponse
import com.luthfi.moviecatalogue.data.model.TVShow
import com.luthfi.moviecatalogue.data.repo.remote.RemoteRepository
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TVShowViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: TVShowViewModel

    @Mock
    private lateinit var repo: RemoteRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TVShow>>

    @Mock
    private lateinit var movieResponse: PagedList<TVShow>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = TVShowViewModel()
    }

    @Test
    fun getTV() {
        val response = MutableLiveData<PagedList<TVShow>>()

        Mockito.`when`(repo.getTVShowList()).thenReturn(response)

        viewModel.getTV().observeForever(observer)
        observer.onChanged(movieResponse)
        Mockito.verify(observer).onChanged(movieResponse)
    }
}