package com.luthfi.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.luthfi.moviecatalogue.data.model.TVResponse
import com.luthfi.moviecatalogue.data.repo.TVRepository

class TVShowViewModel : ViewModel() {

    private val isRefresh = MutableLiveData<Boolean>()
    private val repo = TVRepository()

    private val tvShow: LiveData<TVResponse> = Transformations.switchMap(isRefresh) {
        repo.getListTV()
    }

    init {
        refreshTV()
    }

    fun getTV(): LiveData<TVResponse> = tvShow


    fun refreshTV() {
        isRefresh.postValue(true)
    }
}
