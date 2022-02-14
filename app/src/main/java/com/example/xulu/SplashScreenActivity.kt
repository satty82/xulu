package com.example.xulu

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle
import android.content.Intent
import android.os.Handler


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handler = Handler()
        handler.postDelayed( {
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()

        },1500
        )

    }
}