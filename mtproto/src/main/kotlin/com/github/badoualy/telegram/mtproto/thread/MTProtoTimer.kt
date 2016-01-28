package com.github.badoualy.telegram.mtproto.thread

import java.util.*
import kotlin.concurrent.schedule

internal object MTProtoTimer {

    private var timer: Timer? = null

    fun schedule(delay: Long, action: TimerTask.() -> Unit): TimerTask {
        if (timer == null)
            timer = Timer()
        return timer!!.schedule(delay, action)
    }

    fun shutdown() {
        timer?.cancel()
        timer = null
    }
}