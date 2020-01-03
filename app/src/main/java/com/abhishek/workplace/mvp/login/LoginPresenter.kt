package com.abhishek.workplace.mvp.login

class LoginPresenter(val loginView: LoginView, val interactor: LoginInteractor) :
    LoginInteractorCallback {

    fun loginPresenter(user: String, pass: String) {
        interactor.doLogin(user, pass,this)
    }

    override fun errorLogin(msg: String) {
        loginView.showToast(msg)
    }

    override fun successLogin() {
        loginView.moveToNext()
    }
}