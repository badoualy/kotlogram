package com.github.badoualy.telegram.mtproto.time

import java.util.*
import kotlin.concurrent.schedule

internal object MTProtoTimer {

    private var timer = Timer()

    fun schedule(delay: Long, action: TimerTask.() -> Unit) = timer.schedule(delay, action)

    fun shutdown() = timer.cancel()
}