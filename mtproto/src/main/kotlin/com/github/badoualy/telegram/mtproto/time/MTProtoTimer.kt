package com.github.badoualy.telegram.mtproto.time

import java.util.*
import kotlin.concurrent.schedule

object MTProtoTimer {

    private var timer = Timer(javaClass.simpleName)

    fun schedule(delay: Long, action: TimerTask.() -> Unit) = timer.schedule(delay, action)

    fun shutdown() = timer.cancel()
}