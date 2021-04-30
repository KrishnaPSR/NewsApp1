package com.example.mynews2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.mynews2.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashHandler()
    }
    private fun splashHandler() {
        try {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this , MainActivity::class.java))
                finish()

            }, 2000)
        } catch (e: Exception) {
            Log.e("Error: ", e.toString())
        }
    }
}