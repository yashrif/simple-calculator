package com.example.calculator.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberPad(modifier: Modifier = Modifier, onClick: (String) -> Unit) {
    val cyanKeys = Color(0xF500D4BB)
    val orangeKeys = Color(0xFFFF6D00)
    val autoKeys = MaterialTheme.colorScheme.onBackground

    val keys = listOf(
        listOf(
            Pair("C", Pair(cyanKeys, 24.sp)),
            Pair("7", Pair(autoKeys, 24.sp)),
            Pair("4", Pair(autoKeys, 24.sp)),
            Pair("1", Pair(autoKeys, 24.sp)),
            Pair((177).toChar().toString(), Pair(cyanKeys, 30.sp))
        ), listOf(
            Pair(("\u2190").toString(), Pair(cyanKeys, 30.sp)),
            Pair("8", Pair(autoKeys, 24.sp)),
            Pair("5", Pair(autoKeys, 24.sp)),
            Pair("2", Pair(autoKeys, 24.sp)),
            Pair("0", Pair(autoKeys, 24.sp)),
        ), listOf(
            Pair("%", Pair(cyanKeys, 30.sp)),
            Pair("9", Pair(autoKeys, 24.sp)),
            Pair("6", Pair(autoKeys, 24.sp)),
            Pair("3", Pair(autoKeys, 24.sp)),
            Pair(".", Pair(autoKeys, 24.sp)),
        ), listOf(
            Pair((247).toChar().toString(), Pair(orangeKeys, 30.sp)),
            Pair("x", Pair(orangeKeys, 28.sp)),
            Pair("-", Pair(orangeKeys, 30.sp)),
            Pair("+", Pair(orangeKeys, 30.sp)),
            Pair("=", Pair(orangeKeys, 30.sp)),
        )
    )


    Surface(
        color = if (isSystemInDarkTheme()) Color.White.copy(alpha = .05f) else Color.Black.copy(
            alpha = .025f
        ), shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            for (keysRow in keys) {
                Column(
                    modifier = modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (key in keysRow) {
                        NumberKey(
                            key = key.first,
                            keyColor = key.second.first,
                            keyFontSize = key.second.second
                        ) {
                            onClick(it)
                        }
                    }
                }
            }
        }
    }
}