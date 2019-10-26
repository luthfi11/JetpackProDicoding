package com.luthfi.moviecatalogue.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MovieResponse (
    @SerializedName("results")
    val results: List<Movie>
)

@Parcelize
data class Movie (
    var id: Int? = null,
    var title: String? = null,
    var overview: String? = null,
    var release_date: String? = null,
    var poster_path: String? = null,
    var backdrop_path: String? = null,
    var vote_average: String? = null,
    var vote_count: Int? = null
): Parcelable