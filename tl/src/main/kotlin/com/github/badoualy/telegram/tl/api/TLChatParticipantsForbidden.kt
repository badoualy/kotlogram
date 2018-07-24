package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * chatParticipantsForbidden#fc900c2b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatParticipantsForbidden() : TLAbsChatParticipants() {
    override var chatId: Int = 0

    var selfParticipant: TLAbsChatParticipant? = null

    private val _constructor: String = "chatParticipantsForbidden#fc900c2b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(chatId: Int, selfParticipant: TLAbsChatParticipant?) : this() {
        this.chatId = chatId
        this.selfParticipant = selfParticipant
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(selfParticipant, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(chatId)
        doIfMask(selfParticipant, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        chatId = readInt()
        selfParticipant = readIfMask(1) { readTLObject<TLAbsChatParticipant>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(selfParticipant, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatParticipantsForbidden) return false
        if (other === this) return true

        return _flags == other._flags
                && chatId == other.chatId
                && selfParticipant == other.selfParticipant
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfc900c2b.toInt()
    }
}
