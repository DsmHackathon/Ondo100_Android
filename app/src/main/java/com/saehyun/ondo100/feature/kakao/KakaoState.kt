package com.saehyun.ondo100.feature.kakao

import androidx.annotation.DrawableRes
import com.saehyun.ondo100.feature.Message
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class KakaoState(
    val messages: ImmutableList<Message> = persistentListOf(),
)

