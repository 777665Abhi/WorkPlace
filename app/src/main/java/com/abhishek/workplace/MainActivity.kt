package com.abhishek.workplace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.abhishek.workplace.TextToImage.TextToImageActivity
import com.abhishek.workplace.location.LocationActivity
import com.abhishek.workplace.mvp.login.MvpLoginActivity
import com.abhishek.workplace.mvvm.login.MvvLoginActivity
import com.abhishek.workplace.mvvm.login.MvvmLoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Registering the Click Listener*/
        bnVibration.setOnClickListener(this)
        bnMvp.setOnClickListener(this)
        bnMvvm.setOnClickListener(this)
        bnLocation.setOnClickListener(this)
        bnTextToImage.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bnVibration -> {
                Utils.moveNextScreen(this,OneAVibraterActivity::class.java)
            }
            R.id.bnMvp -> {
                Utils.moveNextScreen(this,MvpLoginActivity::class.java)
            }
            R.id.bnMvvm -> {
                Utils.moveNextScreen(this, MvvLoginActivity::class.java)
            }
            R.id.bnLocation->{
                Utils.moveNextScreen(this, LocationActivity::class.java)
            }
            R.id.bnTextToImage->{
                Utils.moveNextScreen(this, TextToImageActivity::class.java)
            }
        }
    }


}
