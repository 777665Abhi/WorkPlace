package com.abhishek.workplace.mvvm.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.abhishek.workplace.mvp.login.LoginInteractor
import com.abhishek.workplace.mvvm.observation.ScreenState

class MvvmLoginViewModel(private val loginInteractor: MvvmLoginInteractor) : ViewModel(),
    MvvmLoginInteractor.OnLoginFinishedListener {


    /**Declare the LD instance*/
    private val _loginState: MutableLiveData<ScreenState<LoginState>> = MutableLiveData()

    /**Declare public Getter for LD*/
    val loginState: LiveData<ScreenState<LoginState>>
        get() = _loginState

    /**Calling the Interactor Method*/
    fun onLoginClicked(username: String, password: String) {
        _loginState.value = ScreenState.Loading
        loginInteractor.login(username, password, this)
    }

    override fun onUsernameError() {
        _loginState.value = ScreenState.Render(LoginState.WrongUserName)
    }

    override fun onPasswordError() {
        _loginState.value = ScreenState.Render(LoginState.WrongPassword)

    }

    override fun onSuccess() {
        _loginState.value = ScreenState.Render(LoginState.Success)
    }

    override fun onError() {
        _loginState.value = ScreenState.Render(LoginState.Success)
    }
}

class LoginViewModelFactory(private val loginInteractor: MvvmLoginInteractor) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MvvmLoginViewModel(loginInteractor) as T
    }
}