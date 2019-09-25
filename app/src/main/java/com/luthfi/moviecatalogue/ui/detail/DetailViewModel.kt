package com.luthfi.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.luthfi.moviecatalogue.data.model.Movie

class DetailViewModel: ViewModel() {

    fun getDetail(data: Movie?): Movie? = data
}