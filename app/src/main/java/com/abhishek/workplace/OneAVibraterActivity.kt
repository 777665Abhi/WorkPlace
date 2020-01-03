package com.abhishek.workplace

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_one_avibrater.*


@Suppress("DEPRECATION")
class OneAVibraterActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bnVibrateStart -> {
                startVibration()

            }
            R.id.bnVibrateStop -> {
                stopVibration()

            }
        }
    }

    var vibrator: Vibrator? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_avibrater)
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        bnVibrateStart.setOnClickListener(this)
        bnVibrateStop.setOnClickListener(this)
    }

    fun startVibration() {
        if (hasVibrator()) {
//            val pattern :Long[] = {50,100,200,500}
            val pattern = longArrayOf(0, 500, 1000)
            //vibrator!!.vibrate(pattern, 0)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator!!.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE))
            }else{
                //deprecated in API 26
                vibrator!!.vibrate(pattern,0)
            }
        } else {
            Toast.makeText(this, "NO Vibration", Toast.LENGTH_SHORT).show()
        }
    }

    fun stopVibration() {
        if (hasVibrator()) {
            vibrator!!.cancel()
        }
    }

    fun hasVibrator(): Boolean {
        if (vibrator!!.hasVibrator()) {
            return true
        }
        return false
    }
}
