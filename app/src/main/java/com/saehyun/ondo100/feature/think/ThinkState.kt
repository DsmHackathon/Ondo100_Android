package com.saehyun.ondo100.feature.think

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class ThinkState(
    val thinks: ImmutableList<String> = persistentListOf(),
)
