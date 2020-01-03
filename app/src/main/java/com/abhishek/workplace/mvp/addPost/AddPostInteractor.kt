package com.abhishek.workplace.mvp.addPost

import com.abhishek.workplace.ApiClient.Response.PostResponse

class AddPostInteractor {


    fun addPost(msg: String,listener:AddPostInteractorCallback)
    {
    listener.onSuccessData("Posted Successfully")
    }

    interface AddPostInteractorCallback {
        fun onSuccessData(msg: String)
        fun onErrorData(msg: String)
    }
}