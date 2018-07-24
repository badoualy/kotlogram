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
 * updateChatParticipantAdd#ea4b0e5c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChatParticipantAdd() : TLAbsUpdate() {
    var chatId: Int = 0

    var userId: Int = 0

    var inviterId: Int = 0

    var date: Int = 0

    var version: Int = 0

    private val _constructor: String = "updateChatParticipantAdd#ea4b0e5c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            chatId: Int,
            userId: Int,
            inviterId: Int,
            date: Int,
            version: Int
    ) : this() {
        this.chatId = chatId
        this.userId = userId
        this.inviterId = inviterId
        this.date = date
        this.version = version
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(chatId)
        writeInt(userId)
        writeInt(inviterId)
        writeInt(date)
        writeInt(version)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        chatId = readInt()
        userId = readInt()
        inviterId = readInt()
        date = readInt()
        version = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChatParticipantAdd) return false
        if (other === this) return true

        return chatId == other.chatId
                && userId == other.userId
                && inviterId == other.inviterId
                && date == other.date
                && version == other.version
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xea4b0e5c.toInt()
    }
}
