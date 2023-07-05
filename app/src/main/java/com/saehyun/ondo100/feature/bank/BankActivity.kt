package com.saehyun.ondo100.feature.bank

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.ondo100.R
import com.saehyun.ondo100.component.Spacer
import com.saehyun.ondo100.style.pretendardFamily
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BankActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BankScreen(
                name = "임세현",
                senderMonkey = 300000,
                senderAccount = 0,
                money = 10000,
            )
        }
    }
}

@Composable
fun BankScreen(
    name: String,
    senderMonkey: Int,
    senderAccount: Int,
    money: Int,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp),
    ) {
        Spacer(space = 30.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = name,
                fontSize = 22.sp,
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
            )
            Spacer(space = 6.dp)
            Box(
                modifier = Modifier
                    .background(
                        color = Color(0xFFF7F7F7),
                        shape = RoundedCornerShape(30.dp),
                    )
                    .padding(
                        horizontal = 16.dp,
                        vertical = 5.dp
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "내 계좌",
                    fontSize = 10.sp,
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF202020),
                )
            }
            Spacer(weight = 1f)
            Image(
                painter = painterResource(id = R.drawable.ic_default_profile),
                contentDescription = null,
                modifier = Modifier.size(40.dp),
            )
        }
        Spacer(space = 20.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(69.dp)
                .background(
                    color = Color(0xFFF7F7F7),
                    shape = RoundedCornerShape(20.dp),
                )
                .padding(
                    horizontal = 24.dp,
                    vertical = 12.dp,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.ic_toss), contentDescription = null)
            Spacer(space = 12.dp)
            Column {
                Text(
                    text = "스마일에게 ${senderMonkey}원 보내실건가요?",
                    fontSize = 12.sp,
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight.Normal,
                )
                Text(
                    text = "토스뱅크 100045471522",
                    fontSize = 16.sp,
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF3670C7),
                )
            }
            Spacer(weight = 1f)
            Image(painter = painterResource(id = R.drawable.ic_close_12), contentDescription = null)
        }
        Spacer(space = 8.dp)
        Image(
            painter = painterResource(id = R.drawable.bg_kakao_banner_1),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
        )
        Spacer(weight = 1f)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(125.dp)
                .background(
                    color = Color(0xFFFEA4AE),
                    shape = RoundedCornerShape(20.dp),
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 24.dp,
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_kakao_mini),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                )
                Spacer(space = 4.dp)
                Column {
                    Text(
                        text = "$name mini",
                        fontSize = 12.sp,
                        fontFamily = pretendardFamily,
                        fontStyle = FontStyle.Normal,
                        color = Color.Black
                    )
                    Text(
                        text = "${money}원",
                        fontSize = 18.sp,
                        fontFamily = pretendardFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                }
            }
            Spacer(space = 4.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Spacer(weight = 1f)
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFF49DA6),
                            shape = RoundedCornerShape(size = 30.dp)
                        )
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp,
                        )
                ) {
                    Text(
                        text = "카드",
                        fontSize = 12.sp,
                        fontFamily = pretendardFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                    )
                }
                Spacer(space = 8.dp)
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFF49DA6),
                            shape = RoundedCornerShape(size = 30.dp)
                        )
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp,
                        )
                ) {
                    Text(
                        text = "이체",
                        fontSize = 12.sp,
                        fontFamily = pretendardFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                    )
                }
            }
        }
        Spacer(space = 8.dp)
        Image(
            painter = painterResource(id = R.drawable.bg_kakao_banner_2),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
        )
        Spacer(space = 8.dp)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    color = Color(0xFFF7F7F7),
                    shape = RoundedCornerShape(30.dp),
                ),
            contentAlignment = Alignment.Center,
        ) {
            Image(painter = painterResource(id = R.drawable.ic_plus), contentDescription = null)
        }
        Spacer(space = 34.dp)
    }
}