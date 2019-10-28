package com.luthfi.moviecatalogue.data.repo.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.luthfi.moviecatalogue.data.model.TVShow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class LocalTVShowRepositoryTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: LocalTVShowRepository

    @Mock
    private lateinit var dataSource: DataSource.Factory<Int, TVShow>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getAllTV() {
        repo.getAllTV()

        `when`(repo.getAllTV()).thenReturn(dataSource)
        verify(repo).getAllTV()
    }
}