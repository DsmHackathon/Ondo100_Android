package com.saehyun.ondo100.util

inline fun <T> T.runIf(
    condition: Boolean,
    run: T.() -> T,
) = if (condition) {
    run()
} else {
    this
}
