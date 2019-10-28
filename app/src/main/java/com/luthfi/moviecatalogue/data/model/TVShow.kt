package com.luthfi.moviecatalogue.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class TVResponse(@SerializedName("results") val results: List<TVShow>)

@Entity(tableName = "t_tvshow")
@Parcelize
data class TVShow(
    @PrimaryKey
    var id: Int? = null,
    var name: String? = null,
    var overview: String? = null,
    var first_air_date: String? = null,
    var vote_count: Int? = null,
    var vote_average: String? = null,
    var poster_path: String? = null,
    var backdrop_path: String? = null
) : Parcelable