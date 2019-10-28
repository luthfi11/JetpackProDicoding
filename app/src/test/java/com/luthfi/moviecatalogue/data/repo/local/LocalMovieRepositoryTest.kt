package com.luthfi.moviecatalogue.data.repo.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.luthfi.moviecatalogue.data.model.Movie
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class LocalMovieRepositoryTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: LocalMovieRepository

    @Mock
    private lateinit var dataSource: DataSource.Factory<Int, Movie>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getAllMovie() {
        repo.getAllMovie()

        `when`(repo.getAllMovie()).thenReturn(dataSource)
        verify(repo).getAllMovie()
    }
}