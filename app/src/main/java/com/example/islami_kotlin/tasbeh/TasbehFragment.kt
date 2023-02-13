package com.example.islami_kotlin.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami_kotlin.Constants
import com.example.islami_kotlin.databinding.FragmentTasbehBinding

class TasbehFragment: Fragment() {
    var count :Int=0
    lateinit var viewBinding: FragmentTasbehBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentTasbehBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.countNum.text="$count"
        viewBinding.phase.text=Constants.SUBHAN_ALLAH
        viewBinding.bodySebha.setOnClickListener {
            onSebhaClicked()
        }
    }

    private fun onSebhaClicked() {
        viewBinding.bodySebha.rotation= viewBinding.bodySebha.rotation+5
        count ++
        viewBinding.countNum.text="$count"

         if(count==34){
             if (viewBinding.phase.text== Constants.SUBHAN_ALLAH){
                 viewBinding.phase.text= Constants.ALHAMEDUILLAH
                 count=0
                 viewBinding.countNum.text="$count"
             }
             else if (viewBinding.phase.text== Constants.ALHAMEDUILLAH){
                 viewBinding.phase.text= Constants.ALLAH_AKBAR
                 count=0
                 viewBinding.countNum.text="$count"
             }
             else if (viewBinding.phase.text== Constants.ALLAH_AKBAR) {
                 viewBinding.phase.text = Constants.ASTGFER_ALLAH
                 count = 0
                 viewBinding.countNum.text = "$count"
             }
             else if (viewBinding.phase.text== Constants.ASTGFER_ALLAH) {
                 viewBinding.phase.text = Constants.SUBHAN_ALLAH
                 count = 0
                 viewBinding.countNum.text = "$count"
             }
         }
    }
}