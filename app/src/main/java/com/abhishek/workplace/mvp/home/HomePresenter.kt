package com.abhishek.workplace.mvp.home

import com.abhishek.workplace.ApiClient.Response.PostResponse

class HomePresenter(val homeView:HomeMvpView,val homeMvpInteractor: HomeMvpInteractor): HomeMvpInteractor.HomeMvpInteractorCallback {
    override fun onSuccessData(arrayListPost: ArrayList<PostResponse>) {
        homeView.displayData(arrayListPost)
    }

    override fun onErrorData(msg:String) {
        homeView.showToast(msg)
    }


    fun getDataPresenter()
    {
        homeMvpInteractor.apiHit(this)
    }
}