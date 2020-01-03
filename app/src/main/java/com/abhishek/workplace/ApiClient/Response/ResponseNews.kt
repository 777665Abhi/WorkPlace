package com.abhishek.workplace.ApiClient.Response

import com.google.gson.annotations.SerializedName



class ResponseNews {
    @SerializedName("status")
    var status : String?=null
    @SerializedName("totalResults")
    var totalResults : Int?=null
    @SerializedName("articles")
    var articles :  ArrayList<Article>?=null
}

class Article{
    @SerializedName("author")
    var author:String?=null
    @SerializedName("title")
    var title:String?=null
    @SerializedName("description")
    var description:String?=null
    @SerializedName("url")
    var url:String?=null
    @SerializedName("urlToImage")
    var urlToImage:String?=null
    @SerializedName("publishedAt")
    var publishedAt:String?=null
    @SerializedName("content")
    var content:String?=null
    @SerializedName("source")
    var source:Source?=null
}

class Source{
    @SerializedName("id")
    var id:String?=null
    @SerializedName("name")
    var name:String?=null
}