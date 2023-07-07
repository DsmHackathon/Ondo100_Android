package com.saehyun.ondo100.feature.think

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.ondo100.component.Spacer
import com.saehyun.ondo100.style.pretendardFamily
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FinishActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FinishScreen()
        }
    }
}

@Composable
fun FinishScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(space = 32.dp)
        Text(
            text = "도박 중독자의\n삶은 어떠셨나요?",
            fontSize = 36.sp,
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            textAlign = TextAlign.Center,
        )
        Spacer(space = 80.dp)
        Text(
            text = """
            당신이 호기심에 시작한 도박이 개인의 심리적, 금융적, 사회적 위협을 주고 주변인들과의 관계를 파괴합니다.

            도박. 지금 당장 멈추세요.
        """.trimIndent(),
            fontSize = 22.sp,
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            textAlign = TextAlign.Center,
        )
        Spacer(weight = 1f)
        Text(
            text = "한국도박문제관리센터\nhttps://www.kcgp.or.kr/pcMain.do",
            fontSize = 12.sp,
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            textAlign = TextAlign.Center,
        )
        Spacer(space = 64.dp)
    }
}