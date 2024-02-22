package com.cs4520.assignment3.cs4520.mvvm.model

class MVVMCalculatorModel {
    fun add(num1: Int, num2: Int): String {
        return (num1 + num2).toString()
    }

    fun subtract(num1: Int, num2: Int): String {
        return (num1 - num2).toString()
    }

    fun divide(num1: Int, num2: Int): String {
        return (num1 / num2).toString()
    }

    fun multiply(num1: Int, num2: Int): String {
        return (num1 * num2).toString()
    }
}