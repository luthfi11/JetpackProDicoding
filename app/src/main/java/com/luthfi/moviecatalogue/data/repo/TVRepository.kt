package com.luthfi.moviecatalogue.data.repo

import androidx.lifecycle.MutableLiveData
import com.luthfi.moviecatalogue.BuildConfig
import com.luthfi.moviecatalogue.data.api.APIClient
import com.luthfi.moviecatalogue.data.api.APIService
import com.luthfi.moviecatalogue.data.model.TVResponse
import com.luthfi.moviecatalogue.data.model.TVShow
import com.luthfi.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TVRepository {

    private val apiService = APIClient.getClient().create(APIService::class.java)
    private val data = MutableLiveData<TVResponse>()
    private val detail = MutableLiveData<TVShow>()

    fun getListTV(): MutableLiveData<TVResponse> {
        EspressoIdlingResource.increment()
        apiService.getListTV(BuildConfig.API_KEY).enqueue(object : Callback<TVResponse> {
            override fun onResponse(call: Call<TVResponse>, response: Response<TVResponse>) {
                EspressoIdlingResource.decrement()
                data.postValue(response.body())
            }

            override fun onFailure(call: Call<TVResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return data
    }

    fun getTVDetail(tvShow: TVShow): MutableLiveData<TVShow> {
        detail.postValue(tvShow)
        return detail
    }
}