package com.github.badoualy.telegram.mtproto.time

import com.github.badoualy.telegram.mtproto.model.DataCenter
import org.slf4j.LoggerFactory
import java.util.*


internal object TimeOverlord {

    private val logger = LoggerFactory.getLogger(TimeOverlord::class.java)

    // Delta between server time and client time in ms
    private val deltaMap = HashMap<DataCenter, Long>()

    private val localTime: Long // ms
        get() = System.currentTimeMillis()

    fun getServerTime(dataCenter: DataCenter) = localTime + deltaMap.getOrDefault(dataCenter, 0L)

    // Take time in seconds and shift left
    fun generateMessageId(dataCenter: DataCenter) = (getServerTime(dataCenter) / 1000) shl 32

    fun setServerTime(dataCenter: DataCenter, serverTime: Long) {
        deltaMap.put(dataCenter, serverTime - localTime)
        logger.warn("New server time for $dataCenter is $serverTime")
        logger.warn("New time delta for $dataCenter is ${deltaMap[dataCenter]}")
    }

    // Reverse operation, shift right then multiply by 1000
    fun synchronizeTime(dataCenter: DataCenter, messageId: Long) {
        setServerTime(dataCenter, (messageId ushr 32) * 1000)
    }
}