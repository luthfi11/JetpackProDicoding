package com.luthfi.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.utils.tvData

class TVShowViewModel : ViewModel() {

    fun getTV() : List<Movie> {
        return tvData
    }
}
