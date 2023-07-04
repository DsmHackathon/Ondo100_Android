package com.saehyun.ondo100.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saehyun.ondo100.style.OndoColor
import com.saehyun.ondo100.style.OndoBody7

@Composable
fun InnerTextBox(
    text: String,
) {
    Box(
        modifier = Modifier
            .size(28.dp)
            .border(
                width = 1.dp,
                color = OndoColor.Gray900,
                shape = CircleShape,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(
                    shape = CircleShape,
                    color = Color.Black,
                ),
            contentAlignment = Alignment.Center,
        ) {
            OndoBody7(text = text, color = Color.White)
        }
    }
}

@Preview
@Composable
fun PreviewTextBox() {
    InnerTextBox(text = "1")
}