package com.example.my3lab

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.my3lab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FirstFragment.newInstance())
            .commit()

        binding.butt1.setOnClickListener {
            openFrag(FirstFragment.newInstance(), "1")
        }
        binding.butt2.setOnClickListener {
            openFrag(SecondFragment.newInstance(), "2")
        }
        binding.butt3.setOnClickListener {
            openFrag(ThirdFragment.newInstance(), "3")
        }
        binding.butt4.setOnClickListener {
            openFrag(FourthFragment.newInstance(), "4")
        }

        binding.backButt.setOnClickListener {
            if (supportFragmentManager.fragments.last() is SecondFragment) {
                openFrag(FirstFragment.newInstance(), "1")
            }
            if (supportFragmentManager.fragments.last() is ThirdFragment) {
                openFrag(SecondFragment.newInstance(), "2")
            }
            if (supportFragmentManager.fragments.last() is FourthFragment) {
                openFrag(ThirdFragment.newInstance(), "3")
            }
        }
        binding.nextButt.setOnClickListener {
            if (supportFragmentManager.fragments.last() is FirstFragment) {
                openFrag(SecondFragment.newInstance(), "2")
            }
            if (supportFragmentManager.fragments.last() is SecondFragment) {
                openFrag(ThirdFragment.newInstance(), "3")
            }
            if (supportFragmentManager.fragments.last() is ThirdFragment) {
                openFrag(FourthFragment.newInstance(), "4")
            }
        }

    }

    private fun openFrag(f: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, f)
            .addToBackStack(tag)
            .commit()
    }
}