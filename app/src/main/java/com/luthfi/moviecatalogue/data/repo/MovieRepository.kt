package com.luthfi.moviecatalogue.data.repo

import androidx.lifecycle.MutableLiveData
import com.luthfi.moviecatalogue.BuildConfig
import com.luthfi.moviecatalogue.data.api.APIClient
import com.luthfi.moviecatalogue.data.api.APIService
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.data.model.MovieResponse
import com.luthfi.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {

    private val apiService = APIClient.getClient().create(APIService::class.java)
    private val data = MutableLiveData<MovieResponse>()
    private val detail = MutableLiveData<Movie>()

    fun getListMovies(): MutableLiveData<MovieResponse> {
        EspressoIdlingResource.increment()
        apiService.getListMovie(BuildConfig.API_KEY).enqueue(object : Callback<MovieResponse> {
                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    EspressoIdlingResource.decrement()
                    data.postValue(response.body())
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    t.printStackTrace()
                }
            })

        return data
    }

    fun getMovieDetail(movie: Movie): MutableLiveData<Movie> {
        detail.postValue(movie)
        return detail
    }
}