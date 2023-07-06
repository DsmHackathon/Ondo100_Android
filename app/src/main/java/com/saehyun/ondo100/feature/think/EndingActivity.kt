package com.saehyun.ondo100.feature.think

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.saehyun.ondo100.R
import com.saehyun.ondo100.util.finishWithAnimation
import com.saehyun.ondo100.util.ondoClickable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EndingActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EndingScreen {
                finishWithAnimation()
            }
        }
    }
}


@Composable
fun EndingScreen(
    onPrevious: () -> Unit
) {
    val imageRes = remember { mutableStateOf(R.drawable.bg_ending_1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .ondoClickable {
                if (imageRes.value == R.drawable.bg_ending_1) {
                    imageRes.value = R.drawable.bg_ending_2
                }
                if (imageRes.value == R.drawable.bg_ending_2) {
                    imageRes.value = R.drawable.bg_ending_3
                }
                if (imageRes.value == R.drawable.bg_ending_3) {
                    onPrevious()
                }
            }
    ) {
        Image(
            painter = painterResource(id = imageRes.value),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}