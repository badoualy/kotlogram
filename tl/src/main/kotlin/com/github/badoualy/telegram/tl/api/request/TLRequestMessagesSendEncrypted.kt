package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.api.TLInputEncryptedChat
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSendEncrypted() : TLMethod<TLAbsSentEncryptedMessage>() {
    var peer: TLInputEncryptedChat = TLInputEncryptedChat()

    var randomId: Long = 0L

    var data: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "messages.sendEncrypted#a9776773"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ) : this() {
        this.peer = peer
        this.randomId = randomId
        this.data = data
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeLong(randomId)
        writeTLBytes(data)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLInputEncryptedChat>(TLInputEncryptedChat::class, TLInputEncryptedChat.CONSTRUCTOR_ID)
        randomId = readLong()
        data = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(data)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSendEncrypted) return false
        if (other === this) return true

        return peer == other.peer
                && randomId == other.randomId
                && data == other.data
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa9776773.toInt()
    }
}
