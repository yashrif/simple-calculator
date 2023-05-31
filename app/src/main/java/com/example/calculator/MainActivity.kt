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
        mutableStateOf(0.0)
    }
    val secondNumber = remember {
        mutableStateOf(0.0)
    }
    val result = remember {
        mutableStateOf(0.0)
    }

    NumberScreen()
    NumberPad()
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    CalculatorTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column() {
                content()
            }
        }
    }
}