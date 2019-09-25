package com.luthfi.moviecatalogue.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var id: Int? = null,
    val title: String? = null,
    val overview: String? = null,
    val year: String? = null,
    val poster: Int? = null
): Parcelable