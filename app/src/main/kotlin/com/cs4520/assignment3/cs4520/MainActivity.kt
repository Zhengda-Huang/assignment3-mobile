package com.cs4520.assignment3.cs4520

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cs4520.assignment3.R
import com.cs4520.assignment3.com.cs4520.assignment3.homeFragment.HomeFragment
import com.cs4520.assignment3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            val homeFragment = HomeFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, homeFragment)
                .commit()
        }
    }
}