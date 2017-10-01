package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateNewEncryptedMessage#12bcbd9a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateNewEncryptedMessage() : TLAbsUpdate() {
    var message: TLAbsEncryptedMessage = TLEncryptedMessageService()

    var qts: Int = 0

    private val _constructor: String = "updateNewEncryptedMessage#12bcbd9a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(message: TLAbsEncryptedMessage, qts: Int) : this() {
        this.message = message
        this.qts = qts
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(message)
        writeInt(qts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        message = readTLObject<TLAbsEncryptedMessage>()
        qts = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += message.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateNewEncryptedMessage) return false
        if (other === this) return true

        return message == other.message
                && qts == other.qts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x12bcbd9a.toInt()
    }
}
