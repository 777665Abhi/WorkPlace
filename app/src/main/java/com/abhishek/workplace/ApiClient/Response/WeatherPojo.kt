package com.abhishek.workplace.ApiClient.Response

import com.google.gson.annotations.SerializedName

//
//"coord",
//"weather",
//"base",
//"main",
//"wind",
//"clouds",
//"dt",
//"sys",
//"timezone",
//"id",
//"name",
//"cod"
//})
class WeatherPojo {
    @SerializedName("main")
    var main : Main ?=null
    @SerializedName("weather")
    var weather : ArrayList<Weather> ?=null
    @SerializedName("sys")
    var sys : Sys ?=null
    @SerializedName("wind")
    var wind : Wind ?=null

}
class Wind{
    @SerializedName("speed")
    var speed : String ?=null
    @SerializedName("deg")
    var deg : String ?=null
}
class  Sys
{
    @SerializedName("sunrise")
    var sunrise : String ?=null
    @SerializedName("sunset")
    var sunset : String ?=null
}
class Main {
    @SerializedName("temp")
    var temp : Double ?=null
    @SerializedName("temp_min")
    var temp_min : Double ?=null
    @SerializedName("temp_max")
    var temp_max : Double ?=null

    @SerializedName("pressure")
    var pressure : Double ?=null
    @SerializedName("humidity")
    var humidity : Double ?=null

}

class Weather {
    @SerializedName("main")
    var main : String ?=null
    @SerializedName("description")
    var description : String ?=null
    @SerializedName("icon")
    var icon : Double ?=null


}
