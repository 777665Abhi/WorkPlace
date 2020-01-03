package com.abhishek.workplace.mvp.addPost

import com.abhishek.workplace.ApiClient.Response.PostResponse

class AddPostPresenter(val addPostView:AddPostView,val addPostInteracter:AddPostInteractor) : AddPostInteractor.AddPostInteractorCallback {

    fun addPostPre( msg:String )
    {addPostInteracter.addPost(msg,this)}


    override fun onSuccessData(msg: String) {
        addPostView.addPostSuccess(msg)
    }

    override fun onErrorData(msg: String) {
        addPostView.showToast(msg)
    }
}