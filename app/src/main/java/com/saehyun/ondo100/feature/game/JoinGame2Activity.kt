package com.saehyun.ondo100.feature.game

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.saehyun.ondo100.R
import com.saehyun.ondo100.util.Extras
import com.saehyun.ondo100.util.changeActivityWithAnimation
import com.saehyun.ondo100.util.finishWithAnimation
import com.saehyun.ondo100.util.startActivityWithAnimation
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JoinGame2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gmae_join2)

    }

    fun navigateGame(view: View) {
        changeActivityWithAnimation<GameActivity>(
            intentBuilder = {
                putExtra(Extras.GAME_MONEY, 300000)
            }
        )
    }
}