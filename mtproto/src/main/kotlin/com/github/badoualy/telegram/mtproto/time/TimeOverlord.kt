package com.github.badoualy.telegram.mtproto.time


internal object TimeOverlord {

    var timeDelta: Long = 0
        private set
    val localTime: Long // ms
        get() = System.currentTimeMillis()
    val serverTime: Long
        get() = localTime + timeDelta

    fun setServerTime(serverTime: Long) {
        timeDelta = serverTime - localTime
    }

    // Reverse operation, shift right then multiply by 1000
    fun synchronizeTime(messageId: Long){
        setServerTime((messageId ushr 32) * 1000)
    }

    // Take time in seconds and shift left
    fun generateMessageId() = (serverTime / 1000) shl 32
}