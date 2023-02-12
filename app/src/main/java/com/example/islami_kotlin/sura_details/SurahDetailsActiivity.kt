package com.example.islami_kotlin.sura_details

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.example.islami_kotlin.Constants.FILE_NAME_EXTRA
import com.example.islami_kotlin.Constants.SURA_NAME_EXTRA
import com.example.islami_kotlin.databinding.ActivitySurahDetailsBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.streams.toList

class SurahDetailsActiivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySurahDetailsBinding
    //val lines :MutableList<String> = mutableListOf() //mutable because I wanna edit it
    var suraContent =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivitySurahDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        //each activity has intent .. activity started by this intent
        val sura_name= intent.getStringExtra(SURA_NAME_EXTRA)
        val fileName =intent.getStringExtra(FILE_NAME_EXTRA)

        viewBinding.suraNameTitle.text=sura_name
        readSuraFile(fileName?:"")
        viewBinding.suraContent.text=suraContent

        //to scroll over sura content
        viewBinding.suraContent.movementMethod=ScrollingMovementMethod()

        initListeners()
    }

    fun initListeners(){
        //enable back button
        viewBinding.arrowBackIcon.setOnClickListener{
     finish()
        }
    }

    fun readSuraFile(fileName:String){
        val reaeder = BufferedReader(
            InputStreamReader(assets.open((fileName))

            )
        )
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.N){
            val lines= reaeder.lines().toList()
            for (i in 0..lines.size-1){
                val line =lines.get(i)
                suraContent +=line + "(${i+1})"
            }
        }
    }
}