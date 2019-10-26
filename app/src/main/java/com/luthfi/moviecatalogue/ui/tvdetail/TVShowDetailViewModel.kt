package com.luthfi.moviecatalogue.ui.tvdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.luthfi.moviecatalogue.data.model.TVShow
import com.luthfi.moviecatalogue.data.repo.TVRepository

class TVShowDetailViewModel: ViewModel() {

    private val repo = TVRepository()

    fun getTVShow(tvShow: TVShow): LiveData<TVShow> {
        return repo.getTVDetail(tvShow)
    }

}