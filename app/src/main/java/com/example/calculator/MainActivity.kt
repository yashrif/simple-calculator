package com.example.calculator

import android.os.Bundle
import android.util.Log
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
import com.example.calculator.utils.extracted

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
    val expressions = remember {
        mutableStateListOf(" ")
    }
    val fullExpression = remember {
        mutableStateOf<String?>(null)
    }
    val fullExpressionSplit = remember {
        mutableStateListOf<String>()
    }


    NumberScreen(expressions = expressions)
    NumberPad {
        when (it.lowercase()) {
            "c" -> {
                fullExpression.value = null
                fullExpressionSplit.clear()
            }

            "=" -> {
                fullExpression.value = calculateResult(fullExpression.value!!)
                expressions.add(
                    StringBuilder(fullExpression.value!!).insert(0, '=').toString()
                )
                fullExpressionSplit.clear()
            }

            else -> {
                if (fullExpression.value == null) fullExpression.value = it
                else fullExpression.value += it

                extracted(fullExpression.value, fullExpressionSplit)
                Log.d("Size", "Interface: ${expressions.size}")
                expressions.removeLast()
                expressions.add(fullExpression.value!!)
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