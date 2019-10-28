package com.luthfi.moviecatalogue.ui.detail.tvdetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.luthfi.moviecatalogue.data.db.AppDatabase
import com.luthfi.moviecatalogue.data.model.TVShow
import com.luthfi.moviecatalogue.data.repo.local.LocalTVShowRepository
import kotlinx.coroutines.launch

class TVShowDetailViewModel(application: Application): AndroidViewModel(application) {

    private val localRepo: LocalTVShowRepository
    private val tvData = MutableLiveData<TVShow>()

    init {
        val tvShowDao = AppDatabase.getDatabase(application).tvDao()
        localRepo = LocalTVShowRepository(tvShowDao)
    }

    fun getTVShow(tvShow: TVShow): LiveData<TVShow> {
        tvData.postValue(tvShow)
        return tvData
    }

    fun checkFavTV(id: Int?): LiveData<List<TVShow>> {
        return localRepo.check(id)
    }

    fun addTVFav(tv: TVShow) = viewModelScope.launch {
        localRepo.insert(tv)
    }

    fun deleteTVFav(tv: TVShow) = viewModelScope.launch {
        localRepo.delete(tv)
    }

}