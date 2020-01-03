package com.abhishek.workplace.mvp.login

interface  LoginView{
    fun showToast(msg:String)
    fun showProgress()
    fun hideProgress()
    fun moveToNext()
}