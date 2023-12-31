package com.saehyun.ondo100.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OndoSimpleLayout(
    topAppBar: (@Composable () -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
    bottomContent: (@Composable () -> Unit)? = null,
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            if (topAppBar != null) {
                topAppBar()
            }

            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .heightIn(min = 0.dp, max = 1000.dp) // TEMP
            ) {
                content()
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter),
        ) {
            bottomContent?.let { it() }
        }
    }
}