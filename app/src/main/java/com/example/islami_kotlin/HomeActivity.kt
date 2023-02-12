package com.example.islami_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islami_kotlin.databinding.ActivityHomeBinding
import com.example.islami_kotlin.hadeth.HadethFragment
import com.example.islami_kotlin.quran.QuranFragment
import com.example.islami_kotlin.radio.RadioFragment
import com.example.islami_kotlin.tasbeh.TasbehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    lateinit var bottomNav:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.content.navHome.setOnItemSelectedListener (object :NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.quran_nav ->{
                        showFragment(QuranFragment())
                    }
                    R.id.hadeth_nav ->{
                        showFragment(HadethFragment())

                    }
                    R.id.radio_nav ->{
                        showFragment(RadioFragment())

                    }
                    R.id.tasbeh_nav ->{
                        showFragment(TasbehFragment())

                    }
                }
                return true;
            }

        })
    viewBinding.content.navHome.selectedItemId=R.id.quran_nav
    }
     fun showFragment(fragment: Fragment){
         supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
     }
    }
