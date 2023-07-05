package com.saehyun.ondo100.feature.kakao

import androidx.annotation.DrawableRes
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class KakaoState(
    val messages: ImmutableList<Message> = persistentListOf(),
)

data class Message(
    val message: String? = null,
    val isMine: Boolean = false,
    val isText: Boolean = true,
    @DrawableRes val image: Int? = null,
)
