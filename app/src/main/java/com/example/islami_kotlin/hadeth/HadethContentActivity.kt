package com.example.islami_kotlin.hadeth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.example.islami_kotlin.Constants
import com.example.islami_kotlin.databinding.ActivityHadethContentBinding
import com.example.islami_kotlin.databinding.ItemHadethBinding

class HadethContentActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityHadethContentBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        //each activity has intent .. activity started by this intent
        val hadethTitle= intent.getStringExtra(Constants.HADETH_NAME_EXTRA)
        val hadethContent =intent.getStringExtra(Constants.CONTENT_HADETH_EXTRA)


        viewBinding.hadethNameTitle.text= hadethTitle
        viewBinding.hadethContent.text= hadethContent

        initListeners()
    }

    fun initListeners(){
        //enable back button
        viewBinding.arrowBackIcon.setOnClickListener{
            finish()
        }
    }
}