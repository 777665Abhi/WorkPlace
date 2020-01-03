package com.abhishek.workplace.ApiClient

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




object ApiClient {

//    https://newsapi.org/v2/top-headlines?country=in&apiKey=228c09333f5f4da9afc8501d3b9e1a32
    val url1="https://jsonplaceholder.typicode.com"
    val urlWeather=" http://api.openweathermap.org/data/2.5/"
    val urlNews="https://newsapi.org/v2/"


    val WEATHER_TYPE="WEATHER_TYPE"
    val NEWS_TYPE="NEWS_TYPE"



    fun getApiService(requesttype:String) :ApiService
    {
      return  getClient(requesttype).create(ApiService::class.java)

    }

    fun getClient(requesttype: String): Retrofit {
        var url:String?=null
        when(requesttype)
        {
            WEATHER_TYPE->url=urlWeather
            NEWS_TYPE ->url=urlNews

        }
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder().baseUrl(url)
            .addConverterFactory(
                GsonConverterFactory.create(gson)
            ).build()
    }


    //    private val retrofitInstance: Retrofit
//        get() {
//            val gson = GsonBuilder().setLenient().create()
//            return Retrofit.Builder().baseUrl(url2)
//                .addConverterFactory(
//                    GsonConverterFactory.create(gson)
//                ).build()
//        }

    //    val apiService: ApiService
//        get() = retrofitInstance.create(ApiService::class.java)
   /*Retrofit instance for News*/
//    private val retrofitInstanceNews: Retrofit
//        get() {
//            val gson = GsonBuilder().setLenient().create()
//            return Retrofit.Builder().baseUrl(url2)
//                .addConverterFactory(
//                    GsonConverterFactory.create(gson)
//                ).build()
//        }
//
//    val apiServiceNews: ApiService
//        get() = retrofitInstanceNews.create(ApiService::class.java)
}