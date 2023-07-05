package com.saehyun.ondo100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saehyun.ondo100.feature.bank.BankActivity
import com.saehyun.ondo100.feature.call.CallActivity
import com.saehyun.ondo100.feature.kakao.KakaoActivity
import com.saehyun.ondo100.feature.message.MessageActivity
import com.saehyun.ondo100.feature.think.ThinkActivity
import com.saehyun.ondo100.util.Extras
import com.saehyun.ondo100.util.startActivityWithAnimation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateToBank()
    }

    private fun navigateToBank() {
        startActivityWithAnimation<BankActivity>()
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

    private fun navigateToKakao() {
        startActivityWithAnimation<KakaoActivity>(
            intentBuilder = {
                putExtra(Extras.NAME, "김민식")
                putExtra(Extras.DATE, "2023년 8월 1일")
            }
        )
    }
}