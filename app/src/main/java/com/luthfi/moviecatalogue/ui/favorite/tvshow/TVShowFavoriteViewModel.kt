package com.luthfi.moviecatalogue.ui.favorite.tvshow

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.luthfi.moviecatalogue.data.db.AppDatabase
import com.luthfi.moviecatalogue.data.model.TVShow
import com.luthfi.moviecatalogue.data.repo.local.LocalTVShowRepository

class TVShowFavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: LocalTVShowRepository

    init {
        val tvDao = AppDatabase.getDatabase(application).tvDao()
        repo = LocalTVShowRepository(tvDao)
    }

    fun getAllTV(): LiveData<PagedList<TVShow>> {
        return LivePagedListBuilder(repo.getAllTV(),10).build()
    }

}
