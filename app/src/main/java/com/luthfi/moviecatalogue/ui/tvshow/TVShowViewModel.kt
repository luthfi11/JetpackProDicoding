package com.luthfi.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.luthfi.moviecatalogue.data.model.TVShow
import com.luthfi.moviecatalogue.data.repo.remote.RemoteRepository

class TVShowViewModel : ViewModel() {

    private val isRefresh = MutableLiveData<Boolean>()
    private val repo = RemoteRepository()

    private val tvShow: LiveData<PagedList<TVShow>> = Transformations.switchMap(isRefresh) {
        repo.getTVShowList()
    }

    init {
        refreshTV()
    }

    fun getTV() = tvShow


    fun refreshTV() {
        isRefresh.postValue(true)
    }
}
