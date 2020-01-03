package com.abhishek.workplace.mvp.login

interface  LoginInteractorCallback{
    fun successLogin()
    fun errorLogin(msg:String)
}