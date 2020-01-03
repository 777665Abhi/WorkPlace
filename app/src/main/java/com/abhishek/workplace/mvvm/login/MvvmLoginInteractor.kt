package com.abhishek.workplace.mvvm.login

import android.content.Context

class MvvmLoginInteractor(private val context: Context){


    fun login(username: String, password: String, listener: OnLoginFinishedListener) {

        when {
            username.isEmpty() -> listener.onUsernameError()
            password.isEmpty() -> listener.onPasswordError()
            else -> processLoginRequest(username,password,listener)
        }
    }

    fun processLoginRequest(name:String, pass:String, listener: OnLoginFinishedListener)
    {
        listener.onSuccess()
    }

    interface OnLoginFinishedListener {
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
        //fun onSuccess(loginResponse: LoginResponse?, context: Context)
        fun onError()
    }
}