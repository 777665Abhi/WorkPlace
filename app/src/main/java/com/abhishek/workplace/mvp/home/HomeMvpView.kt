package com.abhishek.workplace.mvp.home

import com.abhishek.workplace.ApiClient.Response.PostResponse

interface HomeMvpView {
    fun showProgress()
    fun hideProgress()
    fun displayData(postArray:ArrayList<PostResponse>)
    fun showToast(msg:String)

}