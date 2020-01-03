package com.abhishek.workplace.mvp.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.abhishek.workplace.R
import com.abhishek.workplace.Utils
import com.abhishek.workplace.mvp.home.HomeMvpActivity
import kotlinx.android.synthetic.main.activity_login.*

class MvpLoginActivity : AppCompatActivity(), View.OnClickListener, LoginView {
    var loginPresenter: LoginPresenter? = null
    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.INVISIBLE
    }

    override fun moveToNext() {
        hideProgress()
        Utils.moveNextScreen(this, HomeMvpActivity::class.java)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bnLogin -> {
                showProgress()
                if (!TextUtils.isEmpty(etUser.text) && !TextUtils.isEmpty(etPass.text)) {
                    loginPresenter!!.loginPresenter(etUser.text.toString(), etPass.text.toString())
                } else {
                    hideProgress()
                    Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //Initialization
        loginPresenter = LoginPresenter(this, LoginInteractor())

//        Register Click Listener
        bnLogin.setOnClickListener(this)

    }
}
