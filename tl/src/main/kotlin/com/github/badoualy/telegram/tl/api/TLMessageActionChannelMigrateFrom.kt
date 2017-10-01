package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageActionChannelMigrateFrom#b055eaee
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionChannelMigrateFrom() : TLAbsMessageAction() {
    var title: String = ""

    var chatId: Int = 0

    private val _constructor: String = "messageActionChannelMigrateFrom#b055eaee"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(title: String, chatId: Int) : this() {
        this.title = title
        this.chatId = chatId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(title)
        writeInt(chatId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        title = readString()
        chatId = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(title)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionChannelMigrateFrom) return false
        if (other === this) return true

        return title == other.title
                && chatId == other.chatId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb055eaee.toInt()
    }
}
