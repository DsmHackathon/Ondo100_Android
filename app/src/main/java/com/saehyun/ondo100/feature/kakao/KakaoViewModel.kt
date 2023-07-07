package com.saehyun.ondo100.feature.kakao

import androidx.lifecycle.ViewModel
import com.saehyun.ondo100.R
import com.saehyun.ondo100.feature.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.delay
import okhttp3.internal.immutableListOf
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

private object KakaoTalkList {
    val first = immutableListOf(
        Message(
            "야 ㅋㅋㅋ 아니 소연아",
        ),
        Message(
            "나 여기서 돈 3에서 300까지 뿔리고 마감쳤거든?"
        ),
        Message(
            isText = false,
            image = R.drawable.bg_kakao_toss,
        ),
        Message(
            "이거 개쩐다.."
        ),
        Message(
            "오 그거 뭐냐?",
            true
        ),
        Message(
            "나도 좀 벌어보자",
            true
        ),
        Message(
            "공유 ㄱㄱ",
            true
        ),
        Message(
            "형이 알려줄테니까 너도 접속해라"
        ),
        Message(
            "도박사이트 이름은 스마일이야"
        ),
        Message(
            "ㅃㄹ 인터넷키고 스마일로 접속해"
        )
    )
    val second = immutableListOf(
        Message(
            "아.. 진짜 30에서 100까지 뿔렸는데",
            true
        ),
        Message(
            "풀배팅해서 다 잃었어;;;",
            true,
        ),
        Message(
            "내가 그럴 줄 알았다 ㅋㅋㅋㅋ"
        ),
        Message(
            "ㅋㅋㅋㅋㅋㅋㅋ"
        ),
        Message(
            "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ"
        ),
        Message(
            "그럼 그렇지 그러게 풀배팅을 왜 해 ㅋㅋ"
        ),
        Message(
            "아 X나 한 번만 더 하면 200출 가능한데...",
            true
        ),
        Message(
            "돈 좀 빌려주ㅜㅜ 내가 따서 배로 갚음",
            true
        ),
        Message(
            "야 니 정신 차려라"
        ),
        Message(
            "친구끼리 돈 빌리는게 뭐 어때서 ㅋㅋ",
            true
        ),
        Message(
            "아 진짜 갚을게 빌려줭 ㅠㅠㅠ",
            true,
        ),
        Message(
            "하... 이번만이다"
        ),
        Message(
            "얼마 필요헌디"
        ),
        Message(
            "100만 빌려주랑 ㅜ",
            true
        ),
        Message(
            "진짜 니 꼭 갚아라 이거 내 생활비다"
        ),
        Message(
            "오키오킹 넌 내가 150으로 갚을겡 ㅎㅎ",
            true
        )
    )
}

@HiltViewModel
class KakaoViewModel(

) : ContainerHost<KakaoState, KakaoSideEffect>, ViewModel() {

    override val container = container<KakaoState, KakaoSideEffect>(KakaoState())

    private val TalkDelay: Long = 700L

    fun startTalk(step: Int) = intent {
        val talks = if (step == 1) KakaoTalkList.first else KakaoTalkList.second

        talks.forEach { talk ->
            delay(TalkDelay)
            reduce {
                val addTalk = state.messages.toPersistentList().add(talk)
                state.copy(messages = addTalk)
            }
        }
    }
}