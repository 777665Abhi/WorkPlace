package com.abhishek.workplace.weather

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhishek.workplace.ApiClient.ApiClient
import com.abhishek.workplace.ApiClient.Response.Article
import com.abhishek.workplace.ApiClient.Response.ResponseNews
import com.abhishek.workplace.ApiClient.Response.WeatherPojo
import com.abhishek.workplace.R
import com.abhishek.workplace.Utils
import com.abhishek.workplace.weather.adapter.NewsAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class WeatherActivity : AppCompatActivity() {

    var responseNews: ResponseNews? = null
    var limit: Int = 0
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    private lateinit var adapter: NewsAdapter
    var articleList: ArrayList<Article>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        mHandler = Handler()

//        getWeather()
        getNews()
    }

    fun getWeather() {
//        lat=30.7&lon=76.7&units=imperial&appid=fb7a109beaeae6622a9f3dc65920ad4c"
        val postResponse = ApiClient.getApiService(ApiClient.WEATHER_TYPE).getWeatherDaily(
            "30.7",
            "76.7",
            "imperial",
            "fb7a109beaeae6622a9f3dc65920ad4c"
        )
        postResponse.enqueue(object : Callback<WeatherPojo> {
            override fun onFailure(call: Call<WeatherPojo>, t: Throwable) {

                Toast.makeText(this@WeatherActivity, "Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<WeatherPojo>,
                response: Response<WeatherPojo>
            ) {
                tvCurrentTemp.text = response.body()!!.main!!.temp.toString()
                tvMaxTemp.text = response.body()!!.main!!.temp_max.toString()
                tvMinTemp.text = response.body()!!.main!!.temp_min.toString()
                tvDetail.text = response.body()!!.weather!![0].description
                weatherType.text = response.body()!!.weather!![0].main
//                Glide.with(this@WeatherActivity).load(" http://openweathermap.org/img/w/${response.body()!!.weather!![0].icon.toString()}.png").into(ivIcon)
                // Glide.with(this@WeatherActivity).load(" http://openweathermap.org/img/w/01d.png").into(ivIcon)
                Glide.with(this@WeatherActivity).load("http://openweathermap.org/img/w/01d.png")
                    .into(ivIcon)

                //Sunset/Sunrise
                val sunriseDate: Long = response.body()!!.sys!!.sunrise!!.toLong()
                val simple = SimpleDateFormat("HH:mm:ss:SSS Z")
                val result = Date(sunriseDate)
                tvSunrise.text = simple.format(result)
                // tvSunrise.text = response.body()!!.sys!!.sunrise.toString()
                tvSunset.text = response.body()!!.sys!!.sunset.toString()

                //Wind
                tvWindSpeed.text = response.body()!!.wind!!.speed.toString()
                tvWindDeg.text = response.body()!!.wind!!.deg.toString()


                Toast.makeText(this@WeatherActivity, "Done", Toast.LENGTH_SHORT).show()
            }
        })
    }

    /*Api hit to get the News Article*/
    fun getNews() {
        val newsResponse = ApiClient.getApiService(ApiClient.NEWS_TYPE)
            .getNews("in", "228c09333f5f4da9afc8501d3b9e1a32")
        newsResponse.enqueue(object : Callback<ResponseNews> {
            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Utils.showToast("Error to load the news Update", this@WeatherActivity)
            }

            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
//                Utils.showToast(response.body().toString(), this@WeatherActivity)
                responseNews = response.body()
                setNewsRecycleView(limit)
            }
        })
    }

    /* Setting the Data in recycleView*/
    fun setNewsRecycleView(limit: Int) {
        for (i in limit..limit + 5) {
            articleList!!.add(responseNews!!.articles!![i])
        }
        //  var articleList = responseNews!!.articles
        adapter = NewsAdapter(articleList!!, this@WeatherActivity)
        rvNews.adapter = adapter
        rvNews.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        updateData(limit + 6)
    }


    fun updateData(limit: Int) {
        mHandler.postDelayed({

            // This method will be executed once the timer is over
            // Start your app main activity

            if (limit < responseNews!!.articles!!.size - 5) {
                articleList!!.clear()
                for (i in limit..limit + 5) {
                    articleList!!.add(responseNews!!.articles!![i])
                }
                adapter.notifyDataSetChanged()
                updateData(limit + 5)

                // close this activity
            } else {
                articleList!!.clear()
                updateData(0)
            }

        }, 5000)
    }


    override fun onDestroy() {
        mHandler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}
