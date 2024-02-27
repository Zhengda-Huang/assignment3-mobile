import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.R
import com.cs4520.assignment3.com.cs4520.assignment3.mvp.view.MVPFragment
import com.cs4520.assignment3.databinding.FragmentMvpBinding
import com.cs4520.assignment3.databinding.FragmentMvvmBinding

class MVVMFragment : Fragment() {
    private lateinit var viewModel: MVVMCalculatorViewModel

    private var _binding: FragmentMvvmBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMvvmBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[MVVMCalculatorViewModel::class.java]

        val number1: EditText = view.findViewById(R.id.number1EditText)
        val number2: EditText = view.findViewById(R.id.number2EditText)
        val textView: TextView = view.findViewById(R.id.textView)
        val addButton: Button = view.findViewById(R.id.addButton)
        val subtractButton: Button = view.findViewById(R.id.subtractButton)
        val multiplyButton: Button = view.findViewById(R.id.multiplyButton)
        val divideButton: Button = view.findViewById(R.id.divideButton)

        viewModel.number1.observe(viewLifecycleOwner) {
            number1.setText(it)
        }

        viewModel.number2.observe(viewLifecycleOwner) {
            number2.setText(it)
        }

        viewModel.result.observe(viewLifecycleOwner) {
            textView.text = it
        }

        addButton.setOnClickListener {
            viewModel.setNumber1(number1.text.toString())
            viewModel.setNumber2(number2.text.toString())
            calculate('+', number1.text.toString(), number2.text.toString())
            number1.text.clear()
            number2.text.clear()

        }
        subtractButton.setOnClickListener {
            viewModel.setNumber1(number1.text.toString())
            viewModel.setNumber2(number2.text.toString())
            calculate('-', number1.text.toString(), number2.text.toString())
            number1.text.clear()
            number2.text.clear()
        }
        multiplyButton.setOnClickListener {
            viewModel.setNumber1(number1.text.toString())
            viewModel.setNumber2(number2.text.toString())
            calculate('*', number1.text.toString(), number2.text.toString())
            number1.text.clear()
            number2.text.clear()
        }
        divideButton.setOnClickListener {
            viewModel.setNumber1(number1.text.toString())
            viewModel.setNumber2(number2.text.toString())
            calculate('/', number1.text.toString(), number2.text.toString())
            number1.text.clear()
            number2.text.clear()
        }

        viewModel.result.observe(viewLifecycleOwner) { result ->
            textView.text = result
        }

        return view
    }

    private fun calculate(operation: Char, num1: String, num2: String) {

        if (num1.isNotEmpty() && num2.isNotEmpty()) {
            val num1Int = num1.toIntOrNull()
            val num2Int = num2.toIntOrNull()

            if (num1Int != null && num2Int != null) {
                when (operation) {
                    '+' -> viewModel.add(num1Int, num2Int)
                    '-' -> viewModel.subtract(num1Int, num2Int)
                    '*' -> viewModel.multiply(num1Int, num2Int)
                    '/' -> viewModel.divide(num1Int, num2Int)
                    else -> throw IllegalArgumentException("Invalid operation")
                }
            } else {
                Toast.makeText(requireContext(), "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(requireContext(), "Please enter both numbers", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
