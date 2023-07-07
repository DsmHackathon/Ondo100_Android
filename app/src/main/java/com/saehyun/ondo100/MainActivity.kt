package com.saehyun.ondo100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.ondo100.component.Spacer
import com.saehyun.ondo100.feature.bank.BankActivity
import com.saehyun.ondo100.feature.call.CallActivity
import com.saehyun.ondo100.feature.call.VoiceActivity
import com.saehyun.ondo100.feature.game.GameActivity
import com.saehyun.ondo100.feature.game.JoinGameActivity
import com.saehyun.ondo100.feature.kakao.KakaoActivity
import com.saehyun.ondo100.feature.message.MessageActivity
import com.saehyun.ondo100.feature.onboard.OnboardActivity
import com.saehyun.ondo100.feature.think.EndingActivity
import com.saehyun.ondo100.feature.think.FinishActivity
import com.saehyun.ondo100.feature.think.FinishScreen
import com.saehyun.ondo100.feature.think.ThinkActivity
import com.saehyun.ondo100.style.pretendardFamily
import com.saehyun.ondo100.util.Extras
import com.saehyun.ondo100.util.ondoClickable
import com.saehyun.ondo100.util.startActivityWithAnimation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    /**
     * step 0 : 전화연결
     */
    private var step = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(step = step) {
                step++
                navigateWithNextStep()
            }
        }
    }

    private fun navigateWithNextStep() {
        when (step) {
            0 -> {
                step++
                navigateToCall()
            }

            1 -> {
                step++
                navigateToOnboard()
            }

            2 -> {
                step++
                startActivityWithAnimation<KakaoActivity>(
                    intentBuilder = {
                        putExtra(Extras.NAME, "김민식")
                        putExtra(Extras.DATE, "2023년 8월 1일")
                        putExtra(Extras.KAKAO_STEP, 1)
                    }
                )
            }

            3 -> {
                step++
                startActivityWithAnimation<BankActivity>(
                    intentBuilder = {
                        putExtra(Extras.BANK_STEP, 1)
                    }
                )
            }

            4 -> {

            }

            5 -> {
                startActivityWithAnimation<JoinGameActivity>()
            }

            6 -> {
                step++
                startActivityWithAnimation<ThinkActivity>(
                    intentBuilder = {
                        putExtra(Extras.THINK_STEP, 1)
                    }
                )
            }

            7 -> {
                step++
                startActivityWithAnimation<KakaoActivity>(
                    intentBuilder = {
                        putExtra(Extras.NAME, "돈많은놈")
                        putExtra(Extras.DATE, "2023년 8월 1일")
                        putExtra(Extras.KAKAO_STEP, 2)
                    }
                )
            }

            8 -> {

            }

            9 -> {
                step++
                startActivityWithAnimation<BankActivity>(
                    intentBuilder = {
                        putExtra(Extras.GAME_MONEY, 1000000)
                        putExtra(Extras.BANK_STEP, 2)
                    }
                )
            }

            10 -> {

            }

            11 -> {
                step++
                startActivityWithAnimation<GameActivity>(
                    intentBuilder = {
                        putExtra(Extras.GAME_MONEY, 1000000)
                    }
                )
            }

            12 -> {
                step++
                startActivityWithAnimation<ThinkActivity>(
                    intentBuilder = {
                        putExtra(Extras.THINK_STEP, 2)
                    }
                )
            }

            13 -> {

            }

            14 -> {
                step++
                startActivityWithAnimation<MessageActivity>()
            }

            15 -> {
                step++
                startActivityWithAnimation<BankActivity>(
                    intentBuilder = {
                        putExtra(Extras.GAME_MONEY, 10000000)
                        putExtra(Extras.BANK_STEP, 3)
                    }
                )
            }

            16 -> {

            }

            17 -> {
                step++
                startActivityWithAnimation<GameActivity>(
                    intentBuilder = {
                        putExtra(Extras.GAME_MONEY, 10000000)
                    }
                )
            }

            18 -> {
                step++
                startActivityWithAnimation<ThinkActivity>(
                    intentBuilder = {
                        putExtra(Extras.THINK_STEP, 3)
                    }
                )
            }

            19 -> {
                step++
                startActivityWithAnimation<EndingActivity>(
                    intentBuilder = {
                        putExtra(Extras.THINK_STEP, 3)
                    }
                )
            }

            20 -> {
                step++
                startActivityWithAnimation<CallActivity>(
                    intentBuilder = {
                        putExtra(Extras.THINK_STEP, 3)
                    }
                )
            }

            21 -> {
                startActivityWithAnimation<FinishActivity>()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (step == 5) step++
        navigateWithNextStep()
    }

    private fun navigateToOnboard() {
        startActivityWithAnimation<OnboardActivity>()
    }

    private fun navigateToGame() {
        startActivityWithAnimation<GameActivity>(
            intentBuilder = {
                intent.putExtra(Extras.GAME_MONEY, 300000)
            }
        )
    }

    private fun navigateToCall() {
        startActivityWithAnimation<CallActivity>()
    }

    private fun navigateToThink() {
        startActivityWithAnimation<ThinkActivity>()
    }

    private fun navigateToMessage() {
        startActivityWithAnimation<MessageActivity>()
    }
}


@Composable
fun MainScreen(
    step: Int,
    onNextStep: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF282828)),
    ) {
        Spacer(space = 32.dp)
        Image(
            painter = painterResource(id = R.drawable.bg_main_banner),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            contentScale = ContentScale.FillWidth
        )
        Spacer(space = 2.dp)
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(CenterHorizontally),
            text = "TheDayBefore",
            fontSize = 12.sp,
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Normal,
            color = Color.White,

        )
        Spacer(space = 20.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(33.dp)
        ) {
            IconSection(imageRes = R.drawable.ic_home_kakao, title = "카카오톡") {
                onNextStep()
            }
            IconSection(imageRes = R.drawable.ic_home_kakao_bank, title = "카카오뱅크") {
                onNextStep()
            }
            IconSection(imageRes = R.drawable.ic_home_google, title = "Google") {
                onNextStep()
            }
        }
        Spacer(weight = 1f)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    color = Color(0xFF6C6C6C),
                    shape = RoundedCornerShape(topStart = 13.dp, topEnd = 13.dp)
                )
                .padding(horizontal = 80.dp)
                .padding(top = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.ondoClickable {
                    onNextStep()
                },
                painter = painterResource(id = R.drawable.ic_home_phone),
                contentDescription = null
            )
            Image(
                modifier = Modifier.ondoClickable {
                    onNextStep()
                },
                painter = painterResource(id = R.drawable.ic_home_message),
                contentDescription = null
            )
        }
    }
}

@Composable
fun IconSection(
    @DrawableRes imageRes: Int,
    title: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier.ondoClickable {
            onClick()
        },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .size(54.dp)
                .clip(
                    RoundedCornerShape(14.dp)
                ),
            painter = painterResource(id = imageRes),
            contentDescription = null,
        )
        Text(
            text = title,
            fontSize = 12.sp,
            fontFamily = pretendardFamily,
            fontWeight = FontWeight.Normal,
            color = Color.White,
        )
    }
}