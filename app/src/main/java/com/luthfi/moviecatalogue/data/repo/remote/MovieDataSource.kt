package com.luthfi.moviecatalogue.data.repo.remote

import androidx.paging.PageKeyedDataSource
import com.luthfi.moviecatalogue.BuildConfig
import com.luthfi.moviecatalogue.data.api.APIClient
import com.luthfi.moviecatalogue.data.api.APIService
import com.luthfi.moviecatalogue.data.model.Movie
import com.luthfi.moviecatalogue.data.model.MovieResponse
import com.luthfi.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDataSource : PageKeyedDataSource<Int, Movie>() {

    private val apiService = APIClient.getClient().create(APIService::class.java)

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        EspressoIdlingResource.increment()
        apiService.getListMovie(BuildConfig.API_KEY).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                EspressoIdlingResource.decrement()
                if (response.isSuccessful)
                    callback.onResult(response.body()!!.results, null, 2)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {

    }
}