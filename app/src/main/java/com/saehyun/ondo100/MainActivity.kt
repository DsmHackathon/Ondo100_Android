package com.saehyun.ondo100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.saehyun.ondo100.feature.kakao.KakaoActivity
import com.saehyun.ondo100.feature.kakao.KakaoScreen
import com.saehyun.ondo100.feature.think.ThinkActivity
import com.saehyun.ondo100.util.Extras
import com.saehyun.ondo100.util.putStringExtra
import com.saehyun.ondo100.util.startActivityWithAnimation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startThink()
    }

    private fun startThink() {
        startActivityWithAnimation<ThinkActivity>()
    }

    private fun startKakao() {
        startActivityWithAnimation<KakaoActivity>(
            intentBuilder = {
                putExtra(Extras.NAME, "김민식")
                putExtra(Extras.DATE, "2023년 8월 1일")
            }
        )
    }
}