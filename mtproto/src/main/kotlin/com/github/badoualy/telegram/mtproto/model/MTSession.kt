package com.github.badoualy.telegram.mtproto.model

import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.secure.RandomUtils
import com.github.badoualy.telegram.mtproto.time.TimeOverlord
import com.github.badoualy.telegram.tl.TLObjectUtils
import com.github.badoualy.telegram.tl.core.TLObject
import java.math.BigInteger
import kotlin.reflect.KClass

/**
 * This class encapsulate all data related to an MTProto session (id, salt, number of content related message sent, ...)
 * // TODO: handles updates/diff state
 * @see <a href="https://core.telegram.org/mtproto/description#session">MTProto description - Session</a>
 */
class MTSession(var dataCenter: DataCenter,
                var id: ByteArray = RandomUtils.randomSessionId(),
                var salt: Long = 0,
                var contentRelatedCount: Int = 0,
                var lastMessageId: Long = 0) {

    @Transient
    val tag = LogTag(BigInteger(id).toLong().toString())

    /**
     * Generate a valid seqNo value for the given payload type
     * @param clazz payload type
     * @return a valid seqNo value to send
     * @see <a href="https://core.telegram.org/mtproto/description#message-sequence-number-msg-seqno">MTProto description</a>
     */
    fun generateSeqNo(clazz: Class<out TLObject>) =
            generateSeqNo(TLObjectUtils.isContentRelated(clazz))

    /**
     * Generate a valid seqNo value for the given payload type
     * @param clazz payload type
     * @return a valid seqNo value to send
     * @see <a href="https://core.telegram.org/mtproto/description#message-sequence-number-msg-seqno">MTProto description</a>
     */
    fun generateSeqNo(clazz: KClass<out TLObject>) =
            generateSeqNo(TLObjectUtils.isContentRelated(clazz))

    /**
     * Generate a valid seqNo value for the given payload type
     * @param payload payload instance
     * @return a valid seqNo value to send
     * @see <a href="https://core.telegram.org/mtproto/description#payload-sequence-number-msg-seqno">MTProto description</a>
     */
    fun generateSeqNo(payload: TLObject) = generateSeqNo(payload::class)

    /**
     * Generate a valid seqNo value for the given message type
     * @param contentRelated whether the message is content related or not
     * @return a valid seqNo value to send
     * @see <a href="https://core.telegram.org/mtproto/description#message-sequence-number-msg-seqno">MTProto description</a>
     */
    private fun generateSeqNo(contentRelated: Boolean): Int {
        var seqNo = -1
        synchronized(this) {
            seqNo = if (contentRelated) {
                seqNo = contentRelatedCount * 2 + 1
                contentRelatedCount++
                seqNo
            } else {
                contentRelatedCount * 2
            }
        }
        return seqNo
    }

    /**
     * Generate a valid messageId from the current server time. This messageId will be unique
     * @return a valid and unique messageId for the next message to send
     * @see <a href="https://core.telegram.org/mtproto/description#message-sequence-number-msg-seqno">MTProto description</a>
     */
    fun generateMessageId(): Long {
        val weakMessageId = TimeOverlord.generateMessageId(dataCenter)
        synchronized(this) {
            lastMessageId = Math.max(weakMessageId, lastMessageId + 4)
        }
        return lastMessageId
    }
}