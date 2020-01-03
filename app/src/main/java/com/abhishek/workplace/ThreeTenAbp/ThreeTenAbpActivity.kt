package com.abhishek.workplace.ThreeTenAbp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abhishek.workplace.R
import com.jakewharton.threetenabp.AndroidThreeTen
import org.threeten.bp.Instant
import kotlinx.android.synthetic.main.activity_three_ten_abp.*
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime


class ThreeTenAbpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_ten_abp)
        AndroidThreeTen.init(this)

        val data: ZonedDateTime=hereAndNow()
        tvTime.text="${data.minute}"
    }

    fun now(): Instant {
        return Instant.now()
    }

    fun hereAndNow(): ZonedDateTime {
        return ZonedDateTime.ofInstant(now(), ZoneId.systemDefault())
    }
}
