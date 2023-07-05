package com.saehyun.ondo100.feature.game

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.ondo100.R
import com.saehyun.ondo100.component.Spacer
import com.saehyun.ondo100.style.pretendardFamily
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GameScreen()
        }

    }
}

@Composable
fun GameScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_game),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight,
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_game_top),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
            )
            Spacer(space = 8.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Start)
            ) {
                Text(
                    text = "현재 잔고",
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.White,
                )
                Spacer(space = 2.dp)
                Text(
                    text = "￦ 300,000",
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color(0xFFD2FF1E),
                )
            }
            Spacer(space = 8.dp)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFFFF2)),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .background(Color(0xFFCDC5B2)),
                    contentAlignment = Center
                ) {
                    Text(
                        text = "스마일 사다리게임",
                        fontFamily = pretendardFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 30.sp,
                        color = Color.Black,
                    )
                }
                Spacer(space = 16.dp)
                Image(
                    painter = painterResource(id = R.drawable.bg_game_1),
                    contentDescription = null,
                    modifier = Modifier.height(180.dp),
                    contentScale = ContentScale.FillHeight,
                )
                Spacer(space = 16.dp)
                Image(
                    painter = painterResource(id = R.drawable.ic_game_character),
                    contentDescription = null
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(17.dp)
                        .background(Color(0xFFCDC5B2))
                )
            }

            Spacer(space = 4.dp)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.bg_coin_1k),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.bg_coin_10k),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.bg_coin_50k),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.bg_coin_100k),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.bg_coin_500k),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.bg_coin_1m),
                    contentDescription = null,
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(weight = 1f)
                Text(
                    text = "배팅금",
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.White,
                )
                Spacer(space = 2.dp)
                Text(
                    text = "￦ 300,000",
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color(0xFFD2FF1E),
                )
            }
            Spacer(weight = 1f)
            Image(
                painter = painterResource(id = R.drawable.bg_game_bottom),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
            )
        }
    }
}
