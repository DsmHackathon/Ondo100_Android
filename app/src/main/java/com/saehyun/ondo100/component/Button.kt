package com.saehyun.ondo100.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.saehyun.ondo100.style.OndoColor
import com.saehyun.ondo100.style.OndoBody5
import com.saehyun.ondo100.style.OndoBody6
import com.saehyun.ondo100.util.runIf
import com.saehyun.ondo100.util.ondoClickable

@Composable
fun OndoMediumButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    color: Color,
    onClick: () -> Unit,
) {
    val textColor = if (enabled) OndoColor.White else color

    Box(
        modifier = modifier
            .width(136.dp)
            .height(40.dp)
            .ondoClickable(
                rippleEnabled = enabled,
            ) {
                onClick()
            }
            .runIf(!enabled) {
                border(
                    width = 1.dp,
                    color = color,
                    shape = RoundedCornerShape(12.dp),
                )
            }
            .runIf(enabled) {
                background(
                    color = color,
                    shape = RoundedCornerShape(12.dp),
                )
            },
        contentAlignment = Alignment.Center,
    ) {
        OndoBody6(
            text = text,
            color = textColor,
        )
    }
}

@Composable
fun OndoTextFieldButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val backgroundColor = if (enabled) OndoColor.Gray200 else OndoColor.Gray200

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .ondoClickable(
                rippleEnabled = enabled,
            ) {
                if (enabled) {
                    onClick()
                }
            }
            .background(
                shape = RoundedCornerShape(12.dp),
                color = backgroundColor,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(space = 12.dp)
        OndoBody6(
            text = text,
            color = OndoColor.Black,
        )
    }
}

@Composable
fun OndoLargeButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val backgroundColor = if (enabled) OndoColor.Main1 else OndoColor.Main3

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .ondoClickable(
                rippleEnabled = enabled,
            ) {
                if (enabled) {
                    onClick()
                }
            }
            .background(
                shape = RoundedCornerShape(12.dp),
                color = backgroundColor,
            ),
        contentAlignment = Alignment.Center,
    ) {
        OndoBody5(
            text = text,
            color = OndoColor.White,
        )
    }
}

@Composable
fun OndoOutlineLargeButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val backgroundColor = if (enabled) OndoColor.Main1 else OndoColor.Main3

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .ondoClickable(
                rippleEnabled = enabled,
            ) {
                if (enabled) {
                    onClick()
                }
            }
            .border(
                shape = RoundedCornerShape(12.dp),
                color = backgroundColor,
                width = 1.dp
            ),
        contentAlignment = Alignment.Center,
    ) {
        OndoBody5(
            text = text,
            color = backgroundColor,
        )
    }
}