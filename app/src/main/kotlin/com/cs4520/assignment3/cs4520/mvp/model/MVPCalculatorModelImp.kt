package com.cs4520.assignment3.com.cs4520.assignment3.mvp.model

class MVPCalculatorModelImp : MVPCalculatorModel {
    override fun add(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    override fun subtract(num1: Int, num2: Int): Int {
        return num1 - num2
    }

    override fun divide(num1: Int, num2: Int): Int {
        return num1 / num2
    }

    override fun multiply(num1: Int, num2: Int): Int {
        return num1 * num2
    }
}