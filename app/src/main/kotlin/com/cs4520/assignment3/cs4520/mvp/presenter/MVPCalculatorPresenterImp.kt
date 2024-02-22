package com.cs4520.assignment3.com.cs4520.assignment3.mvp.presenter

import com.cs4520.assignment3.com.cs4520.assignment3.mvp.model.MVPCalculatorModel
import com.cs4520.assignment3.com.cs4520.assignment3.mvp.model.MVPCalculatorModelImp
import com.cs4520.assignment3.com.cs4520.assignment3.mvp.view.MVPFragment

class MVPCalculatorPresenterImp (private val view: MVPFragment) : MVPCalculatorPresenter {
    private val model: MVPCalculatorModel = MVPCalculatorModelImp()

    override fun add(num1: Int, num2: Int) {
        val result = model.add(num1, num2)
        view.applyResult(result)

    }

    override fun subtract(num1: Int, num2: Int){
        val result = model.subtract(num1, num2)
        view.applyResult(result)
    }

    override fun divide(num1: Int, num2: Int) {
        val result = model.divide(num1, num2)
        view.applyResult(result)
    }

    override fun multiply(num1: Int, num2: Int) {
        val result = model.multiply(num1, num2)
        view.applyResult(result)
    }
}