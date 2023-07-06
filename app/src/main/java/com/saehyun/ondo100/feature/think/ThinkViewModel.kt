package com.saehyun.ondo100.feature.think

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

@HiltViewModel
class ThinkViewModel(

) : ContainerHost<ThinkState, ThinkSideEffect>, ViewModel() {

    override val container = container<ThinkState, ThinkSideEffect>(ThinkState())

    private val message1 = mutableListOf(
        "아... X발",
        "거기서 풀배팅을 하면 안됐는데...",
        "이거 좀만 더 따면 될거 같은데",
        "한 번만...",
        "한 번만 더 하면...",
        "원금 다 복구할 수 있어.",
        "어..?",
        "그런데 돈이 없네? 어떡하지??",
        "어차피 딸건데.. ㅋ",
        "빌려서 갚으면 되겠지?",
        "애들한테 빌려서 본전 찾아야겠다.",
        "내 돈 다 복구하고 300출 한다."
    )

    private val message2 = mutableListOf(
        "하... 주완이 돈인데 X됐네",
        "복구해야 하는ㄴ데...",
        "복구해야 하는데......",
        "돈.. 한 번만 더 빌려볼까?",
        "내 돈도 찾고! 주완이 돈도 찾고!",
        "X발 모르겠다",
        "어차피 아까도 원점이었는데...",
        "또... 따지 않을까?",
        "복구할 때 까지만 하는거야..!",
        "대출 한 번만 더 받자"
    )

    private val message3 = mutableListOf(
        "이걸 갚을 자신이 없는데",
        "우리 집은 어쩌지?",
        "내 가족들은..?",
        "내가 죽는게 모두에게 행복할거야",
    )

    fun nextStep1() = intent {
        if (message1.isNotEmpty()) {
            val element = message1.removeAt(0)

            reduce {
                state.copy(thinks = state.thinks.toPersistentList().add(element))
            }
        } else {
            postSideEffect(ThinkSideEffect.Back)
        }
    }

    fun nextStep2() = intent {
        if (message2.isNotEmpty()) {
            val element = message2.removeAt(0)

            reduce {
                state.copy(thinks = state.thinks.toPersistentList().add(element))
            }
        } else {
            postSideEffect(ThinkSideEffect.Back)
        }
    }

    fun nextStep3() = intent {
        if (message3.isNotEmpty()) {
            val element = message3.removeAt(0)

            reduce {
                state.copy(thinks = state.thinks.toPersistentList().add(element))
            }
        } else {
            postSideEffect(ThinkSideEffect.Back)
        }
    }
}