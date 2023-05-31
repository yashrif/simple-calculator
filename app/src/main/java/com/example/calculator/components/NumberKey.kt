package com.example.calculator.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun NumberKey(
    modifier: Modifier = Modifier,
    key: String,
    keyColor: Color,
    keyFontSize: TextUnit = 24.sp
) {
    Button(
        onClick = {  },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = CircleShape
    ) {
        Text(
            text = key,
            color = keyColor,
            fontSize = keyFontSize,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
    }
}