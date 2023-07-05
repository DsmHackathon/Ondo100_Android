package com.saehyun.ondo100.feature.think

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.ondo100.style.pretendardFamily
import com.saehyun.ondo100.util.ondoClickable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThinkActivity : ComponentActivity() {

    private val vm: ThinkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val state = vm.container.stateFlow.collectAsState().value

            ThinkScreen(
                state = state,
            ) {
                vm.nextStep1()
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