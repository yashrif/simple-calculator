package com.example.calculator.utils

import android.util.Log
import java.util.StringTokenizer

fun calculateResult(expression: String): String {
    val st = StringTokenizer(expression, "+-x%", true)
    val numbers = mutableListOf<Double>()
    val signs = mutableListOf<String>()
    while (st.hasMoreTokens()) {
        val token = st.nextToken()
        if (token in "+-x%") {
            signs.add(token)
        } else {
            numbers.add(token.toDouble())
        }
    }
    Log.d("Numbers", "calculateResult: $numbers")
    Log.d("Signs", "calculateResult: $signs")
    var result = numbers[0]
    for (i in 1 until numbers.size) {
        result = when (signs[i - 1]) {
            "+" -> result + numbers[i]
            "-" -> result - numbers[i]
            "x" -> result * numbers[i]
            "%" -> result / numbers[i]
            else -> result
        }
    }
    return result.toString()
}
