package com.abhishek.workplace.mvvm.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.lifecycle.ViewModelProviders
import com.abhishek.workplace.R
import com.abhishek.workplace.mvvm.observation.ScreenState
import kotlinx.android.synthetic.main.activity_mvv_login.*

class MvvLoginActivity : AppCompatActivity() {
    var viewModel: MvvmLoginViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvv_login)
        /**1 Create instance of VM*/
          viewModel= ViewModelProviders.of(this,LoginViewModelFactory(MvvmLoginInteractor(this)))[MvvmLoginViewModel::class.java]
          viewModel!!.loginState.observe(::getLifecycle,::updateUI)
        bnLogin.setOnClickListener { onLoginClicked()}
    }

    private fun updateUI(screenState: ScreenState<LoginState>?) {
        when (screenState) {
            ScreenState.Loading -> progress.visibility = View.VISIBLE
            is ScreenState.Render -> processLoginState(screenState.renderState)
        }
    }

    private fun processLoginState(renderState: LoginState) {
        progress.visibility = View.GONE
        when (renderState) {
            LoginState.Success -> Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
                //moveScreenIntent(this, SyncActivity::class.java, true)
            LoginState.WrongUserName -> etUser.error = "error username"
            LoginState.WrongPassword -> etPass.error = "error password"
            LoginState.ErrorServer  -> Toast.makeText(this, "error login", Toast.LENGTH_SHORT).show()
        }
    }
    private fun onLoginClicked() {
        viewModel!!.onLoginClicked(etUser.text.toString(), etPass.text.toString())
    }
}
