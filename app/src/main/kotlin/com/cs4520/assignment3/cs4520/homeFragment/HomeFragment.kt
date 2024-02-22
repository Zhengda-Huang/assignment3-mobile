package com.cs4520.assignment3.com.cs4520.assignment3.homeFragment

import MVVMFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.R
import com.cs4520.assignment3.com.cs4520.assignment3.mvp.view.MVPFragment
import java.util.logging.Logger

class HomeFragment : Fragment(){

    companion object {
        private val logger = Logger.getLogger("MyLogger")
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logger.info("On view created is called")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)
        logger.info("On create view is called")

        val mvpButton: Button = view.findViewById(R.id.mvpButton)
        val mvvmButton: Button = view.findViewById(R.id.mvvmButton)

        mvpButton.setOnClickListener{
            val mvpFragment = MVPFragment()
            logger.info("mvp button called")

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, mvpFragment)
                .addToBackStack(null)
                .commit()

        }

        mvvmButton.setOnClickListener{
            val mvvmFragment = MVVMFragment()
            logger.info("mvvm button called")

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, mvvmFragment)
                .addToBackStack(null)
                .commit()
        }
        return view
    }
}