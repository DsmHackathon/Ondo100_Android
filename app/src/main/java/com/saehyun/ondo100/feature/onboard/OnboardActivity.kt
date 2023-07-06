package com.saehyun.ondo100.feature.onboard

import android.media.MediaPlayer
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saehyun.ondo100.R
import com.saehyun.ondo100.component.OndoLargeButton
import com.saehyun.ondo100.component.OndoSimpleLayout
import com.saehyun.ondo100.component.OndoTextField
import com.saehyun.ondo100.component.Spacer
import com.saehyun.ondo100.style.pretendardFamily
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var step by remember { mutableStateOf(0) }
            var name by remember { mutableStateOf("") }

            when (step) {
                0 -> OnboardScreen {
                    step = 1
                }

                1 -> OnboardScreen2(name = name, onNameChanged = {
                    name = it
                }) {
                    finish()
                }
            }
        }
    }
}

@Composable
fun OnboardScreen(
    modifier: Modifier = Modifier,
    navigateToNext: () -> Unit,
) {

    OndoSimpleLayout(
        content = {
            Column(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
            ) {
                Spacer(space = 90.dp)
                Text(
                    text = "청소년 온라인 도박\n당신은 얼마나 알고 있나요?",
                    fontFamily = pretendardFamily,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(space = 30.dp)
                Text(
                    text = """
            남자 청소년 259명 중에서 '불법 인터넷 도박'
            사이트에 방문해 본 경험이 있다고 응답한 비율은
            23.6%로 나타났고,

            인터넷 도박게임을 해본 경험이 있는 청소년
            또한 25.5%에 이르렀다.

            도박중독의 과정 속에서 필히 경험하게 되는 돈을
            잃게 되는 손실기부터는 도박으로 잃은 돈을 만회하는데
            모든 사고가 집중돼 자신이 엄청난 피해를 입더라도
            돈을 빌리면서 도박에 몰입하는 상태가 됩니다.

            이러한 행동이 반복될수록 도박의 굴레에서 더욱 벗어나기
            힘들어 집니다. 결국, 대인기피, 자신감의 상실,
            피해적인 사고, 학업문제 등이 발생하여
            학교 적응이 어려워집니다.
        """.trimIndent(),
                    fontFamily = pretendardFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
            }
        },
        bottomContent = {
            OndoLargeButton(text = "다음으로", enabled = true) {
                navigateToNext()
            }
        }
    )
}

@Composable
fun OnboardScreen2(
    name: String,
    onNameChanged: (String) -> Unit,
    navigateToNext: () -> Unit,
) {
    OndoSimpleLayout(
        content = {
            Column(
                modifier = Modifier.padding(horizontal = 30.dp)
            ) {
                Spacer(space = 90.dp)
                Text(
                    text = "지금부터 당신은\n온라인 도박 중독자가 됩니다.",
                    fontFamily = pretendardFamily,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(space = 30.dp)
                Text(
                    text = """
        이 앱은 실제 학생들이 겼었던
        온라인 도력을 바탕으로 재구성되었습니다.
        직접 겪어보지 않으면 누구도 모르는 도박,
        단 몇 분만이라도 도박을 체험해 보세요.
        """.trimIndent(),
                    fontFamily = pretendardFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
                Spacer(space = 36.dp)
                Text(
                    text = "체험을 위해 당신의 이름을 입력해주세요", fontFamily = pretendardFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                )
                Spacer(space = 12.dp)
                OndoTextField(value = name, onValueChange = onNameChanged)
            }
        },
        bottomContent = {
            OndoLargeButton(text = "다음으로", enabled = true) {
                navigateToNext()
            }
        }
    )
}