package com.saehyun.ondo100.feature.call

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.ondo100.R
import com.saehyun.ondo100.component.Spacer
import com.saehyun.ondo100.style.pretendardFamily
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CallActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CallScreen(
                "임세현",
                "010-8757-3315"
            )
        }
    }
}

@Composable
fun CallScreen(
    name: String,
    phoneNumber: String,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF45A7B5),
                        Color(0x26000000)
                    )
                )
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(space = 80.dp)
            Text(
                text = name,
                fontSize = 36.sp,
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
            )
            Spacer(space = 4.dp)
            Text(
                text = "휴대전화 $phoneNumber",
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Normal,
            )
            Spacer(weight = 1f)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 37.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_call_accept),
                    contentDescription = null
                )
                Spacer(weight = 1f)
                Image(
                    painter = painterResource(id = R.drawable.ic_call_deny),
                    contentDescription = null
                )
            }
            Spacer(space = 24.dp)
            Text(
                text = "내가 설정한 V컬러링입니다.",
                fontSize = 14.sp,
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Normal,
                color = Color.White,
            )
            Spacer(space = 56.dp)
        }
    }
}