package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat
import com.github.badoualy.telegram.tl.api.TLInputEncryptedChat
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesAcceptEncryption() : TLMethod<TLAbsEncryptedChat>() {
    var peer: TLInputEncryptedChat = TLInputEncryptedChat()

    var gB: TLBytes = TLBytes.EMPTY

    var keyFingerprint: Long = 0L

    private val _constructor: String = "messages.acceptEncryption#3dbc0415"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ) : this() {
        this.peer = peer
        this.gB = gB
        this.keyFingerprint = keyFingerprint
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeTLBytes(gB)
        writeLong(keyFingerprint)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLInputEncryptedChat>(TLInputEncryptedChat::class, TLInputEncryptedChat.CONSTRUCTOR_ID)
        gB = readTLBytes()
        keyFingerprint = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += computeTLBytesSerializedSize(gB)
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesAcceptEncryption) return false
        if (other === this) return true

        return peer == other.peer
                && gB == other.gB
                && keyFingerprint == other.keyFingerprint
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3dbc0415.toInt()
    }
}
