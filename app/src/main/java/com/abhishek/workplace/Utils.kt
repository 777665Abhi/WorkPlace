package com.abhishek.workplace

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class Utils {
    companion object {
        fun moveNextScreen(source: Context, destination: Class<*>) {
            val intent = Intent(source, destination)
            source.startActivity(intent)
        }

        fun showToast(msg:String,context: Context)
        {
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
        }
    }
}