package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateChatAdmins#6e947941
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChatAdmins() : TLAbsUpdate() {
    var chatId: Int = 0

    var enabled: Boolean = false

    var version: Int = 0

    private val _constructor: String = "updateChatAdmins#6e947941"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            chatId: Int,
            enabled: Boolean,
            version: Int
    ) : this() {
        this.chatId = chatId
        this.enabled = enabled
        this.version = version
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(chatId)
        writeBoolean(enabled)
        writeInt(version)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        chatId = readInt()
        enabled = readBoolean()
        version = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_BOOLEAN
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChatAdmins) return false
        if (other === this) return true

        return chatId == other.chatId
                && enabled == other.enabled
                && version == other.version
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6e947941.toInt()
    }
}
