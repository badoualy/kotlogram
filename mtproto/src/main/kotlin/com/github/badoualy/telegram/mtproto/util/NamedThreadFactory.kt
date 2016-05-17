package com.github.badoualy.telegram.mtproto.util

import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger

class NamedThreadFactory(val name: String, val singleThread: Boolean = false) : ThreadFactory {

    private val group = System.getSecurityManager()?.threadGroup ?: Thread.currentThread().threadGroup
    private val threadNumber = AtomicInteger(1)
    private val namePrefix = "$name-thread-"

    override fun newThread(r: Runnable): Thread {
        val t = Thread(group, r, if (singleThread) name else namePrefix + threadNumber.andIncrement, 0)
        if (t.isDaemon)
            t.isDaemon = false
        if (t.priority != Thread.NORM_PRIORITY)
            t.priority = Thread.NORM_PRIORITY
        return t
    }
}