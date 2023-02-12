package com.example.islami_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islami_kotlin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}