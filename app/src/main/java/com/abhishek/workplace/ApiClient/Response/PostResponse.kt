package com.abhishek.workplace.ApiClient.Response

import com.google.gson.annotations.SerializedName

class PostResponse {

        @SerializedName("userId")
        var userId : String?=null
        @SerializedName("title")
        var title : String?=null
        @SerializedName("body")
        var body : String?=null


}