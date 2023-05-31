package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.calculator.components.NumberPad
import com.example.calculator.components.NumberScreen
import com.example.calculator.ui.theme.CalculatorTheme

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
    val firstNumber = remember {
        mutableStateOf<Double?>(null)
    }
    val secondNumber = remember {
        mutableStateOf<Double?>(null)
    }
    val result = remember {
        mutableStateOf<Double?>(null)
    }
    val operator = remember {
        mutableStateOf<Char?>(null)
    }
    val fullExpression = remember {
        mutableStateOf<String?>(null)
    }

    NumberScreen(
        firstNumber = firstNumber.value,
        secondNumber = secondNumber.value,
        operator = operator.value,
        result = fullExpression.value,
    )
    NumberPad {
        if (fullExpression.value == null) fullExpression.value = it else fullExpression.value += it
        if (fullExpression.value?.get(fullExpression.value!!.length - 1) in '9' downTo '0') {
            secondNumber.value = firstNumber.value
            operator.value = fullExpression.value?.get(fullExpression.value!!.length - 1)

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