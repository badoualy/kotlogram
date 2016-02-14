package com.github.badoualy.telegram.mtproto.time


internal object TimeOverlord {

    var timeDelta: Long = 0
        private set
    val localTime: Long
        get() = System.currentTimeMillis()
    val serverTime: Long
        get() = localTime + timeDelta

    fun setServerTime(serverTime: Long) {
        timeDelta = serverTime - localTime
    }

    fun generateMessageId() = (serverTime / 1000) shl 32
}