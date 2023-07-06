package com.saehyun.ondo100.feature.think

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.ondo100.R
import com.saehyun.ondo100.style.pretendardFamily
import com.saehyun.ondo100.util.Extras
import com.saehyun.ondo100.util.finishWithAnimation
import com.saehyun.ondo100.util.ondoClickable
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.viewmodel.observe

@AndroidEntryPoint
class ThinkActivity : ComponentActivity() {

    private val vm: ThinkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val step = intent.getIntExtra(Extras.THINK_STEP, 1)
            val state = vm.container.stateFlow.collectAsState().value

            ThinkScreen(
                state = state,
            ) {
                when (step) {
                    1 -> vm.nextStep1()
                    2 -> vm.nextStep2()
                    3 -> vm.nextStep3()
                }
            }

            vm.observe(
                lifecycleOwner = this,
                sideEffect = ::handleSideEffect,
            )
        }
    }

    private fun handleSideEffect(sideEffect: ThinkSideEffect) {
        when (sideEffect) {
            is ThinkSideEffect.Back -> {
                finishWithAnimation()
            }

            is ThinkSideEffect.Ending -> {

            }
        }
    }
}

@Composable
fun ThinkScreen(
    state: ThinkState,
    onNextStep: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF000000))
            .ondoClickable(
                rippleEnabled = false
            ) {
                onNextStep()
            },
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(
            horizontal = 34.dp,
            vertical = 40.dp,
        )
    ) {
        items(state.thinks) { str ->
            if (state.thinks.last() == str) {
                Text(
                    text = str,
                    fontSize = 24.sp,
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFFFFFFF),
                )
            } else {
                Text(
                    text = str,
                    fontSize = 20.sp,
                    fontFamily = pretendardFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF8C8C8C),
                )
            }
        }
    }
}