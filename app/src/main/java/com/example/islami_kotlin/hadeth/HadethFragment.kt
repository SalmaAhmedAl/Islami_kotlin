package com.example.islami_kotlin.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami_kotlin.databinding.FragmentHadethBinding

class HadethFragment:Fragment() {
    lateinit var viewBinding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentHadethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile()
    }

    private fun readHadethFile() {
        val fileContent= activity?.assets?.open("ahadeth.txt")?.bufferedReader().use {
            it?.readText()
        }
        if(fileContent==null)return
        val ahadethContents = fileContent.trim().split("#")

        ahadethContents.forEach { singleHadeth->
            val title = singleHadeth.trim().substringBefore('\n')
            val content = singleHadeth.trim().substringAfter('\n')
        }
    }
}