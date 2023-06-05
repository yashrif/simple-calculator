package com.example.calculator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.calculator.utils.CreateExpressionDisplay
import com.example.calculator.utils.extracted
import kotlinx.coroutines.launch

@Composable
fun NumberScreen(
    modifier: Modifier = Modifier,
    expressions: SnapshotStateList<String>,
) {
    val expressionsSplit = mutableListOf<SnapshotStateList<String>>();
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(expressions.size) {
        coroutineScope.launch {
            listState.animateScrollToItem(index = expressions.size - 1)
        }
    }

    expressions.forEach {
        val temp = SnapshotStateList<String>()
        extracted(fullExpression = it, fullExpressionSplit = temp)
        expressionsSplit.add(temp)
    }

    Surface(modifier = modifier.height(380.dp)) {
        LazyColumn(
            modifier = modifier
                .padding(vertical = 24.dp, horizontal = 24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            items(expressionsSplit.size) { index ->
                CreateExpressionDisplay(expressionsSplit[index])
            }
        }
    }
}
