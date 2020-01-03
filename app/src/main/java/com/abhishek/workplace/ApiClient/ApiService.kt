package com.abhishek.workplace.ApiClient

import com.abhishek.workplace.ApiClient.Response.PostResponse
import com.abhishek.workplace.ApiClient.Response.ResponseNews
import com.abhishek.workplace.ApiClient.Response.WeatherPojo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/posts")
    fun getPost(
    ): Call<ArrayList<PostResponse>>

    @GET("weather")
    fun getWeatherDaily(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("units") units: String,
        @Query("appid") appid: String

    ): Call<WeatherPojo>


    /*Get News*/
    @GET("top-headlines")
    fun getNews(@Query("country") country:String,
                @Query("apiKey") apiKey:String):Call<ResponseNews>



}