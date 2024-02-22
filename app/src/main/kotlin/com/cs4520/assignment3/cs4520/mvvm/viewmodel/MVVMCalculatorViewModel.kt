import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.cs4520.mvvm.model.MVVMCalculatorModel

class MVVMCalculatorViewModel : ViewModel() {
    private val model = MVVMCalculatorModel()

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    private val _number1 = MutableLiveData<String>()
    val number1: LiveData<String> get() = _number1

    private val _number2 = MutableLiveData<String>()
    val number2: LiveData<String> get() = _number2

    fun setNumber1(num: String) {
        _number1.value = num
    }

    fun setNumber2(num: String) {
        _number2.value = num
    }

    fun add(num1: Int, num2: Int) {
        _result.value = "Result: " + model.add(num1, num2)
    }

    fun subtract(num1: Int, num2: Int) {
        _result.value = "Result: " + model.subtract(num1, num2)
    }

    fun divide(num1: Int, num2: Int) {
        _result.value = "Result: " + model.divide(num1, num2)
    }

    fun multiply(num1: Int, num2: Int) {
        _result.value = "Result: " + model.multiply(num1, num2)
    }

    fun setResult(result: String) {
        _result.value = result
    }
}
