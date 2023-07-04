package com.saehyun.ondo100.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saehyun.ondo100.style.OndoColor

@Composable
fun OndoLinearProgressBar(
    progress: Float,
) {
    LinearProgressIndicator(
        modifier = Modifier.height(8.dp),
        color = OndoColor.Main1,
        progress = progress,
    )
}