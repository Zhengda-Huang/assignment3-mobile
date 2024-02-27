package com.cs4520.assignment3.com.cs4520.assignment3.mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.R
import com.cs4520.assignment3.com.cs4520.assignment3.mvp.presenter.MVPCalculatorPresenterImp
import com.cs4520.assignment3.databinding.FragmentHomeBinding
import com.cs4520.assignment3.databinding.FragmentMvpBinding
import java.util.logging.Logger

class MVPFragment : Fragment(), MVPCalculatorView {

    companion object {
        private val logger = Logger.getLogger("MyLogger")
    }

    private var _binding: FragmentMvpBinding? = null
    private val binding get() = _binding!!
    val presenter = MVPCalculatorPresenterImp(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMvpBinding.inflate(inflater, container, false)
        val view = binding.root

        val number1 : EditText = view.findViewById(R.id.number1EditText)
        val number2 : EditText = view.findViewById(R.id.number2EditText)
        val addButton : Button = view.findViewById(R.id.addButton)
        val subtractButton : Button = view.findViewById(R.id.subtractButton)
        val multiplyButton : Button = view.findViewById(R.id.multiplyButton)
        val divideButton : Button = view.findViewById(R.id.divideButton)

        fun performOperation(operation: Char) {
            calculate(operation, number1.text.toString(), number2.text.toString())
        }

        addButton.setOnClickListener {
            performOperation('+')
            number1.text.clear()
            number2.text.clear()
        }

        subtractButton.setOnClickListener {
            performOperation('-')
            number1.text.clear()
            number2.text.clear()
        }

        multiplyButton.setOnClickListener {
            performOperation('*')
            number1.text.clear()
            number2.text.clear()
        }

        divideButton.setOnClickListener {
            performOperation('/')
            number1.text.clear()
            number2.text.clear()
        }
        return view
    }


private fun calculate(operation: Char, num1: String, num2: String) {
    if (num1.isNotEmpty() && num2.isNotEmpty()) {
        val num1Int = num1.toIntOrNull()
        val num2Int = num2.toIntOrNull()

        if (num1Int != null && num2Int != null) {
            when (operation) {
                '+' -> presenter.add(num1Int, num2Int)
                '-' -> presenter.subtract(num1Int, num2Int)
                '*' -> presenter.multiply(num1Int, num2Int)
                '/' -> presenter.divide(num1Int, num2Int)
                else -> throw IllegalArgumentException("Invalid operation")
            }
        } else {
            Toast.makeText(requireContext(), "Please enter valid numbers", Toast.LENGTH_SHORT).show()
        }
    } else {
        Toast.makeText(requireContext(), "Please enter both numbers", Toast.LENGTH_SHORT).show()
    }
}

    override fun onStart() {
        super.onStart()
        logger.info("On start is called")
    }

    override fun onResume() {
        super.onResume()
        logger.info("On resume is called")

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        logger.info("On destroy is called")
    }

    override fun applyResult(result: Int) {
        val textView : TextView = requireView().findViewById(R.id.textView)
        textView.text = "Result: " + result.toString()
    }


}