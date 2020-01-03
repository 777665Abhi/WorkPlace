package com.abhishek.workplace.TextToImage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.abhishek.workplace.R
import kotlinx.android.synthetic.main.activity_text_to_image.*
import android.R.id.text2
import android.R.id.text1
import android.R.attr.textColor
import android.graphics.Bitmap
import android.graphics.Paint.Align
import android.R.attr.textSize
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Color.BLACK
import android.graphics.Color.RED
import android.text.Html
import androidx.core.text.HtmlCompat
import kotlin.math.roundToInt
import android.os.Build
import android.text.SpannableString
import android.text.Spanned

import net.glxn.qrgen.android.QRCode


class TextToImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.abhishek.workplace.R.layout.activity_text_to_image)
        bnAction.setOnClickListener(View.OnClickListener {
            if (!etLine1.text.isEmpty() && !etLine2.text.isEmpty() && !etLine1.text.isEmpty()) {
                tvColourText.text=fromHtml("Ready to Print", "#00000099")

                ivImage.setImageBitmap(
                    textToImage(
                        etLine1.text.toString(),
                        etLine2.text.toString(),
                        etLine3.text.toString(),
                        40f,
                        BLACK
                    )
                )
            } else {
                Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show()
                tvColourText.text= fromHtml("Fill all the fields", "#00990000")


            }
        })

        bnQR.setOnClickListener(View.OnClickListener {

            if (!etLine1.text.isEmpty() && !etLine2.text.isEmpty() && !etLine1.text.isEmpty()) {
            val myBitmap = QRCode.from("Name:    ${etLine1.text} \nDevices id: ${etLine2.text}\n" +
                    "Location: ${etLine3.text} ").bitmap()
            ivImage.setImageBitmap(myBitmap)
                tvColourText.text=fromHtml("Ready to Print", "#00000099")

            }
            else {
                Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show()
                tvColourText.text= fromHtml("Fill all the fields", "#00990000")

            }
        })
    }

    fun fromHtml(input: String?,color:String): Spanned {
        var html: String = "<font color=$color>$input</font>"

        return if (html == null) {
            // return an empty spannable if the html is null
            SpannableString("")
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(html)
        }
    }

    private fun textToImage(
        text1: String,
        text2: String,
        text3: String,
        textSize: Float,
        textColor: Int
    ): Bitmap? {
        val paint = Paint()
        paint.textSize = textSize
        paint.color = Color.WHITE
        paint.textAlign = Paint.Align.LEFT
        val baseline = -paint.ascent() // ascent() is negative
        val widthA = (paint.measureText(text1) + 0.5)
        val width: Int = widthA.roundToInt()

        val heightA = (baseline + paint.descent() + 0.5)
        val height: Int = heightA.roundToInt()
        val image = Bitmap.createBitmap(width + 500, height + 350, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(image)
        canvas.drawRect(0f, 0f, width + 500f, height + 350f, paint)
        paint.color = textColor
        canvas.drawText("Name : "+text1, 10f, baseline, paint)
        canvas.drawText("Device id : "+text2, 10f, baseline + 50, paint)
        canvas.drawText("Location : "+text3, 10f, baseline + 100, paint)
        return image
    }


}
