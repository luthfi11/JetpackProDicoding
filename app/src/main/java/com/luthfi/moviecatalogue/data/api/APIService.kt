package com.luthfi.moviecatalogue.data.api

import com.luthfi.moviecatalogue.data.model.MovieResponse
import com.luthfi.moviecatalogue.data.model.TVResponse
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @GET("movie/now_playing")
    fun getListMovie (@Query("api_key") apiKey: String): Call<MovieResponse>

    @GET("discover/tv")
    fun getListTV (@Query("api_key") apiKey: String): Call<TVResponse>
}