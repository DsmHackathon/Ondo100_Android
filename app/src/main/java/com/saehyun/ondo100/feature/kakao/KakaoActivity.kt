package com.saehyun.ondo100.feature.kakao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.saehyun.ondo100.util.Extras
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KakaoActivity : ComponentActivity() {

    private val vm: KakaoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra(Extras.NAME) ?: ""
        val date = intent.getStringExtra(Extras.DATE) ?: ""

        vm.startTalk(2)

        setContent {
            val state = vm.container.stateFlow.collectAsState().value

            KakaoScreen(
                name = name,
                date = date,
                state = state,
            )
        }
    }
}