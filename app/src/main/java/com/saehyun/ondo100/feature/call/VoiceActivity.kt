package com.saehyun.ondo100.feature.call

import android.media.MediaPlayer
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.ondo100.MainActivity
import com.saehyun.ondo100.R
import com.saehyun.ondo100.component.Spacer
import com.saehyun.ondo100.style.pretendardFamily
import com.saehyun.ondo100.util.finishWithAnimation
import com.saehyun.ondo100.util.ondoClickable
import com.saehyun.ondo100.util.startActivityWithAnimation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VoiceActivity : ComponentActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VoiceScreen(
                name = "김민식",
                phoneNumber = "010-8757-3315",
                onAccept = {
                    finishWithAnimation()
                },
                onDeny = {
                    finishWithAnimation()
                }
            )
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.start_voice)
        mediaPlayer.setOnCompletionListener {
           startActivityWithAnimation<MainActivity>() // SingleTop
        }
        mediaPlayer.start() // Media will start playing immediately
    }

    // Remember to release the player when you're done with it
    override fun onDestroy() {
        mediaPlayer.release()
        super.onDestroy()
    }
}

@Composable
fun VoiceScreen(
    name: String,
    phoneNumber: String,
    onAccept: () -> Unit,
    onDeny: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF45A7B5),
                        Color(0x26000000)
                    )
                )
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(space = 80.dp)
            Text(
                text = name,
                fontSize = 36.sp,
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
            )
            Spacer(space = 4.dp)
            Text(
                text = "휴대전화 $phoneNumber",
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = pretendardFamily,
                fontWeight = FontWeight.Normal,
            )
            Spacer(weight = 1f)
            Image(
                painter = painterResource(id = R.drawable.bg_voice_icons),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 40.dp
                    ),
                contentScale = ContentScale.FillWidth,
            )
            Spacer(space = 42.dp)
            Image(
                modifier = Modifier.ondoClickable {
                    onDeny()
                },
                painter = painterResource(id = R.drawable.ic_call_deny),
                contentDescription = null
            )
            Spacer(space = 64.dp)
        }
    }
}