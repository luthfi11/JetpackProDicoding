package com.luthfi.moviecatalogue.data.repo.remote

import androidx.paging.PageKeyedDataSource
import com.luthfi.moviecatalogue.BuildConfig
import com.luthfi.moviecatalogue.data.api.APIClient
import com.luthfi.moviecatalogue.data.api.APIService
import com.luthfi.moviecatalogue.data.model.TVResponse
import com.luthfi.moviecatalogue.data.model.TVShow
import com.luthfi.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TVShowDataSource : PageKeyedDataSource<Int, TVShow>() {

    private val apiService = APIClient.getClient().create(APIService::class.java)

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, TVShow>
    ) {
        EspressoIdlingResource.increment()
        apiService.getListTV(BuildConfig.API_KEY).enqueue(object : Callback<TVResponse> {
            override fun onResponse(call: Call<TVResponse>, response: Response<TVResponse>) {
                EspressoIdlingResource.decrement()
                if (response.isSuccessful)
                    callback.onResult(response.body()!!.results, null, 2)
            }

            override fun onFailure(call: Call<TVResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, TVShow>) {

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, TVShow>) {

    }

}