
package com.saehyun.ondo100.feature

import androidx.annotation.DrawableRes

data class Message(
    val message: String? = null,
    val isMine: Boolean = false,
    val isText: Boolean = true,
    @DrawableRes val image: Int? = null,
    val time: String? = null,
)