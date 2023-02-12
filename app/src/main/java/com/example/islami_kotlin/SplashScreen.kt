package com.example.islami_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
       Handler(Looper.getMainLooper()).postDelayed(object :Runnable{
           override fun run() {
               val intent = Intent(this@SplashScreen, HomeActivity::class.java)
               startActivity(intent)
           }
       }, 2000)
    }
}