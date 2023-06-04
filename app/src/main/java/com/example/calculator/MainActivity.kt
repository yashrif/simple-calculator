package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.calculator.components.NumberPad
import com.example.calculator.components.NumberScreen
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.utils.calculateResult
import java.util.StringTokenizer

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Interface()
            }
        }
    }
}

@Composable
fun Interface() {

    val result = remember {
        mutableStateOf<String?>(null)
    }
    val fullExpression = remember {
        mutableStateOf<String?>(null)
    }
    val fullExpressionSplit = remember {
        mutableStateListOf<String>()
    }

    NumberScreen(fullExpressionSplit = fullExpressionSplit, result = result.value)

    NumberPad {
//        if (fullExpression.value!!.last() in '0'..'9') {
//            firstNumber.value =
//                if (firstNumber.value == null) (fullExpression.value!![fullExpression.value!!.length - 1] - '0').toDouble() else
//                    (fullExpression.value!![fullExpression.value!!.length - 1] - '0').toDouble() + (firstNumber.value
//                        ?: 0.0) * 10
////            Log.d("FirstNumber", "Interface: ${firstNumber.value}")
//        } else {
//            secondNumber.value = firstNumber.value
//            firstNumber.value = null
//            operator.value = fullExpression.value?.get(fullExpression.value!!.length - 1)
//        }
        if (fullExpression.value == null) fullExpression.value = it
        else
            when (it.lowercase()) {
                "c" -> {
                    fullExpression.value = null
                    fullExpressionSplit.clear()
                }

                "=" -> {
                    result.value = calculateResult(fullExpression.value!!)
                }

                else -> {
                    fullExpression.value += it

                    val tokens = StringTokenizer(fullExpression.value, "-+", true)
                    fullExpressionSplit.clear()
                    while (tokens.hasMoreTokens()) {
                        fullExpressionSplit.add(tokens.nextToken())
                    }
                }
            }

    }
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    CalculatorTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column {
                content()
            }
        }
    }
}