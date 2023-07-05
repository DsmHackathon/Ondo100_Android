package com.saehyun.ondo100.feature.kakao

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.ondo100.R
import com.saehyun.ondo100.component.OndoSimpleLayout
import com.saehyun.ondo100.component.Spacer
import com.saehyun.ondo100.style.pretendardFamily


@Composable
fun KakaoScreen(
    name: String,
    date: String,
    state: KakaoState,
) {
    OndoSimpleLayout(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFAFC0CF)),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.kakao_top_bar),
                        contentDescription = null,
                    )
                    Text(
                        text = name,
                        fontSize = 16.sp,
                        fontFamily = pretendardFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(CenterHorizontally)
                        .background(
                            color = Color(0x26000000),
                            shape = RoundedCornerShape(34.dp)
                        )
                        .padding(
                            horizontal = 10.dp,
                            vertical = 6.dp,
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = date,
                        fontSize = 11.sp,
                        fontFamily = pretendardFamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                    )
                }
                Spacer(modifier = Modifier.height(7.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    state.messages.forEach {  message ->
                        when (message.isText) {
                            true -> {
                                when (message.isMine) {
                                    true -> MineTalkComment(comment = message.message ?: "")
                                    false -> OtherTalkComment(name = name, comment = message.message ?: "")
                                }
                            }

                            false -> {
                                OtherTalkImage(name = name, image = message.image ?: 0)
                            }
                        }
                    }
                }
            }
        },
        bottomContent = {
            KakaoBottomLayout()
        }
    )
}

@Composable
fun OtherTalkImage(
    @DrawableRes image: Int,
    name: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier.size(34.dp),
            painter = painterResource(id = R.drawable.ic_default_profile),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column {
            Text(
                text = name,
                fontSize = 12.sp,
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Normal,
                color = Color(0x80000000),
            )
            Spacer(modifier = Modifier.height(5.dp))
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
            )
        }
    }
}

@Composable
fun OtherTalkComment(
    name: String,
    comment: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .wrapContentWidth(Alignment.Start)
    ) {
        Image(
            modifier = Modifier.size(34.dp),
            painter = painterResource(id = R.drawable.ic_default_profile),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column {
            Text(
                text = name,
                fontSize = 12.sp,
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Normal,
                color = Color(0x80000000),
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                Image(
                    modifier = Modifier.offset(x = 4.dp),
                    painter = painterResource(id = R.drawable.ic_talk_tail),
                    contentDescription = null
                )
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(13.5.dp)
                        )
                        .padding(
                            horizontal = 10.dp,
                            vertical = 8.dp,
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = comment,
                        fontSize = 15.sp,
                        fontFamily = pretendardFamily,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF282A2B),
                    )
                }
            }
        }
    }
}

@Composable
fun KakaoBottomLayout() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(
                color = Color.White,
            )
            .padding(top = 4.dp, start = 13.dp, end = 10.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_kakao_bottom),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Composable
fun MineTalkComment(
    comment: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(End),
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFFFAE64C),
                    shape = RoundedCornerShape(13.5.dp)
                )
                .padding(
                    horizontal = 10.dp,
                    vertical = 8.dp,
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = comment,
                fontSize = 15.sp,
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF282A2B),
            )
        }
        Image(
            modifier = Modifier.offset(x = (-4).dp),
            painter = painterResource(id = R.drawable.ic_other_talk_tail),
            contentDescription = null
        )
    }
}
