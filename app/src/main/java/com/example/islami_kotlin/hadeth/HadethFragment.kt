package com.example.islami_kotlin.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami_kotlin.Constants
import com.example.islami_kotlin.databinding.FragmentHadethBinding
import com.example.islami_kotlin.quran.SuraNameAdapter
import com.example.islami_kotlin.sura_details.SurahDetailsActiivity

class HadethFragment:Fragment() {
    lateinit var viewBinding: FragmentHadethBinding
    lateinit var adapter: HadethAdapter
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
        adapter = HadethAdapter(allAhadeth)
        adapter.onItemHClick= object : HadethAdapter.OnItemHClick {
            override fun onHadethNameClick(hadeth: Hadeth, position: Int) {
                val intent = Intent(requireActivity(), HadethContentActivity::class.java)
                intent.putExtra(Constants.HADETH_NAME_EXTRA, hadeth.title)
                intent.putExtra(Constants.CONTENT_HADETH_EXTRA, hadeth.content)
                startActivity(intent)
            }

        }
        viewBinding.hadethRecycler.adapter =adapter
    }

     val allAhadeth = mutableListOf<Hadeth>()
    private fun readHadethFile() {
        val fileContent= activity?.assets?.open("ahadeth.txt")?.bufferedReader().use {
            it?.readText()
        }
        if(fileContent==null)return
        val ahadethContents = fileContent.trim().split("#")

        ahadethContents.forEach { singleHadeth->
            val title = singleHadeth.trim().substringBefore('\n')
            val content = singleHadeth.trim().substringAfter('\n')
            val hadeth = Hadeth(title, content)
            allAhadeth.add(hadeth)
        }
    }
}