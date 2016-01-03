package com.github.badoualy.telegram.mtproto.time


object TimeOverlord {

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

    fun onMethodExecuted(responseId: Long) = setServerTime((responseId shr 32) * 1000)
}