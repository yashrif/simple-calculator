package com.example.calculator.utils

import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
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

@Composable
fun CreateExpressionDisplay(fullExpressionSplit: List<String>) {
    val signs = listOf("+", "-", "%", "x")

    return Text(
        text = buildAnnotatedString {
            fullExpressionSplit.map {
                withStyle(
                    style = SpanStyle(
                        color = if (!signs.contains(it)) MaterialTheme.colorScheme.onBackground else Color(
                            0xFFFF6D00
                        )
                    )
                ) {
                    append(it)
                }
            }
        },
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 48.sp,
        textAlign = TextAlign.Right
    )
}

fun extracted(
    fullExpression: String?,
    fullExpressionSplit: SnapshotStateList<String>
) {
    val tokens = StringTokenizer(fullExpression, "-+x", true)
    fullExpressionSplit.clear()
    while (tokens.hasMoreTokens()) {
        fullExpressionSplit.add(tokens.nextToken())
    }
}