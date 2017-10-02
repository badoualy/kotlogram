package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.messages.TLBotCallbackAnswer
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetBotCallbackAnswer() : TLMethod<TLBotCallbackAnswer>() {
    @Transient
    var game: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var msgId: Int = 0

    var data: TLBytes? = null

    private val _constructor: String = "messages.getBotCallbackAnswer#810a9fec"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?
    ) : this() {
        this.game = game
        this.peer = peer
        this.msgId = msgId
        this.data = data
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLBotCallbackAnswer = tlDeserializer.readTLObject(TLBotCallbackAnswer::class, TLBotCallbackAnswer.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(game, 2)
        updateFlags(data, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(msgId)
        doIfMask(data, 1) { writeTLBytes(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        game = isMask(2)
        peer = readTLObject<TLAbsInputPeer>()
        msgId = readInt()
        data = readIfMask(1) { readTLBytes() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(data, 1) { computeTLBytesSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetBotCallbackAnswer) return false
        if (other === this) return true

        return _flags == other._flags
                && game == other.game
                && peer == other.peer
                && msgId == other.msgId
                && data == other.data
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x810a9fec.toInt()
    }
}
