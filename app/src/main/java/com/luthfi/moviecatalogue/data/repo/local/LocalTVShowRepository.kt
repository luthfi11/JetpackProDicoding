package com.luthfi.moviecatalogue.data.repo.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.luthfi.moviecatalogue.data.dao.TVShowDao
import com.luthfi.moviecatalogue.data.model.TVShow

class LocalTVShowRepository(private val tvShowDao: TVShowDao) {

    fun getAllTV(): DataSource.Factory<Int, TVShow> {
        return tvShowDao.getAllTV()
    }

    fun check(id: Int?): LiveData<List<TVShow>> {
        return tvShowDao.checkTV(id)
    }

    suspend fun insert(tvShow: TVShow) {
        tvShowDao.insertTV(tvShow)
    }

    suspend fun delete(tvShow: TVShow) {
        tvShowDao.deleteTV(tvShow)
    }
}