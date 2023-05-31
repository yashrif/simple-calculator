package com.example.calculator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberScreen(
    modifier: Modifier = Modifier,
    firstNumber: Double?,
    secondNumber: Double?,
    operator: Char?,
    result: String?,
) {
    Surface(Modifier.height(320.dp)) {
        Column(
            modifier = modifier
                .padding(vertical = 24.dp, horizontal = 24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "${firstNumber ?: " "} ${operator ?: " "} ${secondNumber ?: " "}",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 48.sp
            )
            Spacer(modifier = modifier.height(12.dp))
            Text(
                text = result ?: "",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 48.sp
            )
        }
    }
}