package com.saehyun.ondo100.feature.message

import com.saehyun.ondo100.feature.Message
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class MessageState(
    val message: ImmutableList<Message> = persistentListOf()
)
