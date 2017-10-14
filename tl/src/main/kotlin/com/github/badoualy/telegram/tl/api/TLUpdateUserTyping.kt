package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateUserTyping#5c486927
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateUserTyping() : TLAbsUpdate() {
    var userId: Int = 0

    var action: TLAbsSendMessageAction = TLSendMessageRecordVideoAction()

    private val _constructor: String = "updateUserTyping#5c486927"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(userId: Int, action: TLAbsSendMessageAction) : this() {
        this.userId = userId
        this.action = action
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(userId)
        writeTLObject(action)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readInt()
        action = readTLObject<TLAbsSendMessageAction>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += action.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateUserTyping) return false
        if (other === this) return true

        return userId == other.userId
                && action == other.action
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5c486927.toInt()
    }
}
