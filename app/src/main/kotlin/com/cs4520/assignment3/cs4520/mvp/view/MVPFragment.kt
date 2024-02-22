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
import java.util.logging.Logger

class MVPFragment : Fragment(), MVPCalculatorView {

    companion object {
        private val logger = Logger.getLogger("MyLogger")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.mvp_fragment, container, false)

        val presenter = MVPCalculatorPresenterImp(this)

        val number1 : EditText = view.findViewById(R.id.number1EditText)
        val number2 : EditText = view.findViewById(R.id.number2EditText)
        val addButton : Button = view.findViewById(R.id.addButton)
        val subtractButton : Button = view.findViewById(R.id.subtractButton)
        val multiplyButton : Button = view.findViewById(R.id.multiplyButton)
        val divideButton : Button = view.findViewById(R.id.divideButton)


        addButton.setOnClickListener{
            val num1String = number1.text.toString()
            val num2String = number2.text.toString()

            if (num1String.isNotEmpty() && num2String.isNotEmpty()) {
                val num1 = num1String.toIntOrNull()
                val num2 = num2String.toIntOrNull()

                if (num1 != null && num2 != null) {
                    presenter.add(num1, num2)
                    number1.text.clear()
                    number2.text.clear()
                } else {
                    Toast.makeText(requireContext(), "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please enter both numbers", Toast.LENGTH_SHORT).show()
            }
        }

        subtractButton.setOnClickListener{
            val num1String = number1.text.toString()
            val num2String = number2.text.toString()

            if (num1String.isNotEmpty() && num2String.isNotEmpty()) {
                val num1 = num1String.toIntOrNull()
                val num2 = num2String.toIntOrNull()

                if (num1 != null && num2 != null) {
                    presenter.subtract(num1, num2)
                    number1.text.clear()
                    number2.text.clear()
                } else {
                    Toast.makeText(requireContext(), "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please enter both numbers", Toast.LENGTH_SHORT).show()
            }
        }

        multiplyButton.setOnClickListener{
            val num1String = number1.text.toString()
            val num2String = number2.text.toString()

            if (num1String.isNotEmpty() && num2String.isNotEmpty()) {
                val num1 = num1String.toIntOrNull()
                val num2 = num2String.toIntOrNull()

                if (num1 != null && num2 != null) {
                    presenter.multiply(num1, num2)
                    number1.text.clear()
                    number2.text.clear()
                } else {
                    Toast.makeText(requireContext(), "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please enter both numbers", Toast.LENGTH_SHORT).show()
            }
        }

        divideButton.setOnClickListener{
            val num1String = number1.text.toString()
            val num2String = number2.text.toString()

            if (num1String.isNotEmpty() && num2String.isNotEmpty()) {
                val num1 = num1String.toIntOrNull()
                val num2 = num2String.toIntOrNull()

                if (num1 != null && num2 != null) {
                    presenter.divide(num1, num2)
                    number1.text.clear()
                    number2.text.clear()
                } else {
                    Toast.makeText(requireContext(), "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please enter both numbers", Toast.LENGTH_SHORT).show()
            }
        }
        return view
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
        logger.info("On destroy is called")
    }

    override fun applyResult(result: Int) {
        val textView : TextView = requireView().findViewById(R.id.textView)
        textView.text = "Result: " + result.toString()
    }


}