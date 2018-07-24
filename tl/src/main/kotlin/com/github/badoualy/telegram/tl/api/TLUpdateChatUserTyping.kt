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
 * updateChatUserTyping#9a65ea1f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChatUserTyping() : TLAbsUpdate() {
    var chatId: Int = 0

    var userId: Int = 0

    var action: TLAbsSendMessageAction = TLSendMessageRecordVideoAction()

    private val _constructor: String = "updateChatUserTyping#9a65ea1f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            chatId: Int,
            userId: Int,
            action: TLAbsSendMessageAction
    ) : this() {
        this.chatId = chatId
        this.userId = userId
        this.action = action
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(chatId)
        writeInt(userId)
        writeTLObject(action)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        chatId = readInt()
        userId = readInt()
        action = readTLObject<TLAbsSendMessageAction>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += action.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChatUserTyping) return false
        if (other === this) return true

        return chatId == other.chatId
                && userId == other.userId
                && action == other.action
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9a65ea1f.toInt()
    }
}
