package com.saehyun.ondo100.feature.think

sealed class ThinkSideEffect {
    object Back: ThinkSideEffect()
    object Ending: ThinkSideEffect()
}
