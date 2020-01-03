package com.abhishek.workplace.mvp.addPost

import com.abhishek.workplace.ApiClient.Response.PostResponse

interface AddPostView {
    fun showProgress()
    fun hideProgress()
    fun addPostSuccess(msg:String)
    fun showToast(msg:String)
}