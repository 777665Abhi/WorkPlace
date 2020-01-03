package com.abhishek.workplace.mvp.login

import android.widget.Toast

class LoginInteractor {


    fun doLogin(user: String, pass: String ,listener:LoginInteractorCallback) {
        if (user.equals("abhi") && pass.equals("1234")) {
            listener.successLogin()
        } else{
            listener.errorLogin("Credentials are not matching")
        }

    }
}