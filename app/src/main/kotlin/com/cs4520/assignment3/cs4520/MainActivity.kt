package com.cs4520.assignment3.com.cs4520.assignment3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cs4520.assignment3.R
import com.cs4520.assignment3.com.cs4520.assignment3.homeFragment.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val homeFragment = HomeFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, homeFragment)
                .commit()
        }
    }
}