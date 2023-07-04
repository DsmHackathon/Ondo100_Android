package com.saehyun.ondo100.style

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.saehyun.ondo100.R
import com.saehyun.ondo100.util.runIf
import com.saehyun.ondo100.util.ondoClickable

internal val pretendardFamily = FontFamily(
    Font(R.font.pretendard_black, FontWeight.Black),
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_extra_light, FontWeight.ExtraLight),
    Font(R.font.pretendard_light, FontWeight.Light),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_thin, FontWeight.Thin),
    Font(R.font.pretendrad_extra_bold, FontWeight.ExtraBold),
)

internal object OndoTextStyle {
    val Body1 = TextStyle(
        color = OndoColor.Black,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body2 = TextStyle(
        color = OndoColor.Black,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body3 = TextStyle(
        color = OndoColor.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body4 = TextStyle(
        color = OndoColor.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body5 = TextStyle(
        color = OndoColor.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body6 = TextStyle(
        color = OndoColor.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body7 = TextStyle(
        color = OndoColor.Black,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body8 = TextStyle(
        color = OndoColor.Black,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
    val Body9 = TextStyle(
        color = OndoColor.Black,
        fontSize = 10.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = pretendardFamily,
    )
    val Body10 = TextStyle(
        color = OndoColor.Black,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = pretendardFamily,
    )
}

@Composable
fun OndoBody1(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = OndoColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .ondoClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = OndoTextStyle.Body1.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun OndoBody2(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = OndoColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .ondoClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = OndoTextStyle.Body2.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun OndoBody3(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = OndoColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .ondoClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            )
            .runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = OndoTextStyle.Body3.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun OndoBody4(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = OndoColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .ondoClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = OndoTextStyle.Body4.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun OndoBody5(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = OndoColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .ondoClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = OndoTextStyle.Body5.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun OndoBody6(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = OndoColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .ondoClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = OndoTextStyle.Body6.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun OndoBody7(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = OndoColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .ondoClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = OndoTextStyle.Body7.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun OndoBody8(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = OndoColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .ondoClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = OndoTextStyle.Body8.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun OndoBody9(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = OndoColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .ondoClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = OndoTextStyle.Body9.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}

@Composable
fun OndoBody10(
    modifier: Modifier = Modifier,
    padding: PaddingValues? = null,
    text: String,
    color: Color = OndoColor.Black,
    align: TextAlign = TextAlign.Start,
    rippleEnabled: Boolean = false,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    onClick: (() -> Unit)? = null
) {
    Text(
        modifier = modifier
            .ondoClickable(
                rippleEnabled = rippleEnabled,
                onClick = onClick
            ).runIf(
                condition = padding != null
            ) {
                padding(
                    paddingValues = padding!!
                )
            },
        text = text,
        style = OndoTextStyle.Body10.copy(
            color = color,
            textAlign = align
        ),
        overflow = overflow
    )
}