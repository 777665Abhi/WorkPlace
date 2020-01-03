package com.abhishek.workplace.mvp.home

import com.abhishek.workplace.ApiClient.ApiClient
import com.abhishek.workplace.ApiClient.Response.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeMvpInteractor {

    fun apiHit(homeMvpInteractorCallback: HomeMvpInteractorCallback) {
        /*
        * Api Hit
        * Success  ==> */
        val postResponse = ApiClient.getApiService(ApiClient.NEWS_TYPE).getPost()
        postResponse.enqueue(object : Callback<ArrayList<PostResponse>> {
            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                homeMvpInteractorCallback.onErrorData("Error to get Post")
            }

            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                homeMvpInteractorCallback.onSuccessData(response.body()!!)
            }
        })
    }


    interface HomeMvpInteractorCallback {
        fun onSuccessData(arrayList: ArrayList<PostResponse>)
        fun onErrorData(msg: String)
    }
}