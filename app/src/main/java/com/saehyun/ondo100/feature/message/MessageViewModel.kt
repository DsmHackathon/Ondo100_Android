package com.saehyun.ondo100.feature.message

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

@HiltViewModel
class MessageViewModel(

) : ContainerHost<MessageState, MessageSideEffect>, ViewModel() {

    private val message = immutableListOf(
        Message(
            "저... 안녕하세요...",
            isMine = true,
            time = "14:00"
        ),
        Message(
            "저 돈 좀 빌리려고 하는데요",
            isMine = true,
            time = "14:00"
        ),
        Message(
            "너 몇 살이야?",
            time = "14:02"
        ),
        Message(
            "저 19살이요...",
            isMine = true,
            time = "14:03"
        ),
        Message(
            "어린놈의 새키가 돈은 어디다 쓰려고?",
            time = "14:06"
        ),
        Message(
            "아... 그건 알아서 뭐하시게요",
            isMine = true,
            time = "14:07"
        ),
        Message(
            "한 1000만원정도만 빌려주세요.",
            isMine = true,
            time = "14:07"
        ),
        Message(
            "하.. 뭐 불가능한건 아닌데 대신에",
            time = "14:08"
        ),
        Message(
            "너희 아버지 신분증이랑 집 등기권리증 가져와",
            time = "14:08"
        ),
        Message(
            "알았어요.",
            isMine = true,
            time = "14:10",
        ),
        Message(
            isMine = true,
            isText = false,
            image = R.drawable.bg_message_1
        ),
        Message(
            isMine = true,
            isText = false,
            image = R.drawable.bg_message_2
        ),
        Message(
            "1000만원 입금했다."
        ),
        Message(
            "이자는 하루에 10% 두 달 준다."
        ),
        Message(
            "니 집 담보니까 꼭 갚길 바란다.",
        )
    )

    override val container = container<MessageState, MessageSideEffect>(MessageState())

    private val TalkDelay: Long = 700L

    fun startTalk() = intent {
        message.forEach { talk ->
            delay(TalkDelay)
            reduce {
                val addTalk = state.message.toPersistentList().add(talk)
                state.copy(message = addTalk)
            }
        }
    }
}