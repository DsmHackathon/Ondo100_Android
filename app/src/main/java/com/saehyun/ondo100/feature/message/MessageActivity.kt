package com.saehyun.ondo100.feature.message

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.ondo100.R
import com.saehyun.ondo100.component.OndoSimpleLayout
import com.saehyun.ondo100.component.Spacer
import com.saehyun.ondo100.feature.kakao.KakaoBottomLayout
import com.saehyun.ondo100.style.pretendardFamily
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.ContainerHost

@AndroidEntryPoint
class MessageActivity : ComponentActivity() {

    private val vm: MessageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.startTalk()

        setContent {
            val state = vm.container.stateFlow.collectAsState().value

            MessageScreen(
                number = "010-8757-3315",
                state = state,
            )
        }
    }
}


@Composable
fun MessageScreen(
    number: String,
    state: MessageState,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        OndoSimpleLayout(
            topAppBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_back_24),
                        contentDescription = null
                    )
                    androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = number,
                        fontFamily = pretendardFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                    )
                    Spacer(weight = 1f)
                    Image(
                        painter = painterResource(id = R.drawable.ic_message_top_icon),
                        contentDescription = null,
                        modifier = Modifier.height(20.dp),
                        contentScale = ContentScale.FillHeight,
                    )
                }
            },
            content = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(CenterHorizontally),
                    text = "2028년 1월 9일",
                    fontFamily = pretendardFamily,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF7A7A7A),
                    textAlign = TextAlign.Center,
                )

                Spacer(space = 16.dp)

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    state.message.forEach { msg ->
                        when (msg.isText) {
                            true -> {
                                when (msg.isMine) {
                                    true -> RightComment(
                                        message = msg.message ?: ""
                                    )

                                    false -> LeftComment(
                                        message = msg.message ?: ""
                                    )
                                }
                            }

                            false -> {
                                when (msg.isMine) {
                                    true -> RightImage(
                                        image = msg.image ?: 0
                                    )

                                    false -> LeftImage(
                                        image = msg.image ?: 0
                                    )
                                }
                            }
                        }
                    }
                }
                Spacer(space = 64.dp)
            },
            bottomContent = {
                KakaoBottomLayout()
            }
        )
    }
}

@Composable
fun LeftImage(
    @DrawableRes image: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier.offset(x = 20.dp),
            painter = painterResource(id = R.drawable.ic_message_container_black),
            contentDescription = null,
        )
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFF1F2C34),
                    shape = RoundedCornerShape(11.dp),
                )
                .padding(
                    horizontal = 12.dp,
                    vertical = 4.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = image), contentDescription = null)
        }
    }
}

@Composable
fun RightImage(
    @DrawableRes image: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(End)
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFF005D4B),
                    shape = RoundedCornerShape(11.dp),
                )
                .padding(
                    horizontal = 12.dp,
                    vertical = 4.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = image), contentDescription = null)
        }
        Image(
            modifier = Modifier.offset(x = (-20).dp),
            painter = painterResource(id = R.drawable.ic_message_container),
            contentDescription = null,
        )
    }
}


@Composable
fun LeftComment(
    message: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier.offset(x = 20.dp),
            painter = painterResource(id = R.drawable.ic_message_container_black),
            contentDescription = null,
        )
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFF1F2C34),
                    shape = RoundedCornerShape(11.dp),
                )
                .padding(
                    horizontal = 12.dp,
                    vertical = 4.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = message,
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White,
            )
        }
    }
}


@Composable
fun RightComment(
    message: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(End)
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFF005D4B),
                    shape = RoundedCornerShape(11.dp),
                )
                .padding(
                    horizontal = 12.dp,
                    vertical = 4.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = message,
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White,
            )
        }
        Image(
            modifier = Modifier.offset(x = (-20).dp),
            painter = painterResource(id = R.drawable.ic_message_container),
            contentDescription = null,
        )
    }
}
