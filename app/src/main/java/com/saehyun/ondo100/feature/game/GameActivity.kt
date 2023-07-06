package com.saehyun.ondo100.feature.game

import android.os.Bundle
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.saehyun.ondo100.util.Extras
import com.saehyun.ondo100.util.ondoClickable
import com.saehyun.ondo100.util.randomInt
import com.saehyun.ondo100.util.rememberToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GameActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val monkey = intent.getIntExtra(Extras.GAME_MONEY, 0)
        setContent {
            GameScreen(
                initMonkey = monkey
            )
        }

    }
}

@Composable
fun GameScreen(
    initMonkey: Int,
) {
    val gameImg = remember {
        mutableStateOf(R.drawable.bg_game_inner_1)
    }
    val coroutineScope = rememberCoroutineScope()
    val toast = rememberToast()
    val money = remember { mutableStateOf(initMonkey) }
    val batMoney = remember { mutableStateOf(0) }

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
                    text = "￦ ${money.value}",
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
                    .background(Color(0xFFFFFFF2))
                    .ondoClickable {
                        if (randomInt() % 2 == 0) {
                            coroutineScope.launch {
                                gameImg.value = R.drawable.bg_game_inner_2
                                toast.invoke("이번 회차 정답은 홀입니다. 돈을 잃었어요 ㅜㅜ")
                                delay(2000L)
                                gameImg.value = R.drawable.bg_game_inner_1
                                money.value = money.value - batMoney.value
                                batMoney.value = 0
                            }
                        } else {
                            coroutineScope.launch {
                                gameImg.value = R.drawable.bg_game_inner_3
                                toast.invoke("이번 회차 정답은 짝입니다. 돈을 잃었어요 ㅜㅜ")
                                delay(2000L)
                                gameImg.value = R.drawable.bg_game_inner_1
                                money.value = money.value - batMoney.value
                                batMoney.value = 0
                            }
                        }
                    },
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
                    painter = painterResource(id = gameImg.value),
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
                    modifier = Modifier
                        .size(32.dp)
                        .ondoClickable {
                            batMoney.value = batMoney.value + 1000
                        },
                    painter = painterResource(id = R.drawable.bg_coin_1k),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .ondoClickable {
                            batMoney.value = batMoney.value + 10000
                        },
                    painter = painterResource(id = R.drawable.bg_coin_10k),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .ondoClickable {
                            batMoney.value = batMoney.value + 50000
                        },
                    painter = painterResource(id = R.drawable.bg_coin_50k),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .ondoClickable {
                            batMoney.value = batMoney.value + 100000
                        },
                    painter = painterResource(id = R.drawable.bg_coin_100k),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .ondoClickable {
                            batMoney.value = batMoney.value + 500000
                        },
                    painter = painterResource(id = R.drawable.bg_coin_500k),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .ondoClickable {
                            batMoney.value = batMoney.value + 1000000
                        },
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
                    text = "￦ ${batMoney.value}",
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
