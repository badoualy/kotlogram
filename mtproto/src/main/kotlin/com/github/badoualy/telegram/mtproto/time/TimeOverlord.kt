package com.github.badoualy.telegram.mtproto.time

import com.github.badoualy.telegram.mtproto.log.Logger
import com.github.badoualy.telegram.mtproto.model.DataCenter
import java.util.*

/**
 * Handles the current server time to be able to generate valid **weak** message id.
 * (Actually remembers the delta between device time and server time).
 */
internal object TimeOverlord {

    private val logger = Logger(TimeOverlord::class)

    /** Delta between server time and client time in ms for each [DataCenter] */
    private val deltaByDcMap = HashMap<DataCenter, Long>()

    /** Current device time in ms */
    private val localTime: Long
        get() = System.currentTimeMillis()

    /** @return current server time in ms */
    fun getServerTime(dataCenter: DataCenter) = localTime + deltaByDcMap.getOrDefault(dataCenter, 0L)

    /** @return a weak message id generated from server time (time in seconds with 32 bits left shift) */
    fun generateMessageId(dataCenter: DataCenter) = (getServerTime(dataCenter) / 1000) shl 32

    /** Set the current server time for the given to the given time in ms */
    fun setServerTime(dataCenter: DataCenter, serverTime: Long) {
        deltaByDcMap.put(dataCenter, serverTime - localTime)
        logger.warn("New server time for $dataCenter is $serverTime")
        logger.warn("New time delta for $dataCenter is ${deltaByDcMap[dataCenter]}")
    }

    /** Update server time for the given [DataCenter] from the given messageId (supposed to be received just now) */
    fun synchronizeTime(dataCenter: DataCenter, messageId: Long) {
        setServerTime(dataCenter, (messageId ushr 32) * 1000)
    }
}