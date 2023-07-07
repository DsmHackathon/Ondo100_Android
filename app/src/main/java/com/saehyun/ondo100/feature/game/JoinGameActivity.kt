package com.saehyun.ondo100.feature.game

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saehyun.ondo100.R
import com.saehyun.ondo100.component.OndoLargeButton
import com.saehyun.ondo100.component.OndoTextField
import com.saehyun.ondo100.component.Spacer
import com.saehyun.ondo100.util.Extras
import com.saehyun.ondo100.util.changeActivityWithAnimation
import com.saehyun.ondo100.util.startActivityWithAnimation
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JoinGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_join)

        setContent {
            JoinScreen {
                changeActivityWithAnimation<GameActivity>(
                    intentBuilder = {
                        putExtra(Extras.GAME_MONEY, 300000)
                    }
                )
            }
        }
//        findViewById<Button>(R.id.btn_join).setOnClickListener {
//            changeActivityWithAnimation<JoinGame2Activity>()
//        }
    }
}

@Composable
fun JoinScreen(
    onNext: () -> Unit,
) {
    var value1 by remember {
        mutableStateOf("")
    }
    var value2 by remember {
        mutableStateOf("")
    }
    var value3 by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(space = 32.dp)
        Image(
            painter = painterResource(id = R.drawable.bg_join_banner),
            contentDescription = null,
            modifier = Modifier.size(252.dp)
        )
        Spacer(space = 8.dp)
        OndoTextField(
            value = value1,
            onValueChange = { value1 = it },
            hint = "아이디",
        )
        Spacer(space = 8.dp)
        OndoTextField(
            value = value2,
            onValueChange = { value2 = it },
            hint = "비밀번호",
        )
        Spacer(space = 8.dp)
        OndoTextField(
            value = value3,
            onValueChange = { value3 = it },
            hint = "비밀번호 확인",
        )
        Spacer(weight = 1f)
        OndoLargeButton(text = "회원가입", enabled = true, enabledColor = Color(0xFFEA4D3E)) {
            onNext()
        }
    }
}