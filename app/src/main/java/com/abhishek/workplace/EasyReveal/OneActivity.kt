package com.abhishek.workplace.EasyReveal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.abhishek.workplace.R
import kotlinx.android.synthetic.main.activity_one.*

class OneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        oneMove.setOnClickListener(View.OnClickListener {

        })
    }
}
