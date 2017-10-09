package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesForwardMessages() : TLMethod<TLAbsUpdates>() {
    @Transient
    var silent: Boolean = false

    @Transient
    var background: Boolean = false

    @Transient
    var withMyScore: Boolean = false

    var fromPeer: TLAbsInputPeer = TLInputPeerEmpty()

    var id: TLIntVector = TLIntVector()

    var randomId: TLLongVector = TLLongVector()

    var toPeer: TLAbsInputPeer = TLInputPeerEmpty()

    private val _constructor: String = "messages.forwardMessages#708e0195"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer
    ) : this() {
        this.silent = silent
        this.background = background
        this.withMyScore = withMyScore
        this.fromPeer = fromPeer
        this.id = id
        this.randomId = randomId
        this.toPeer = toPeer
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(silent, 32)
        updateFlags(background, 64)
        updateFlags(withMyScore, 256)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(fromPeer)
        writeTLVector(id)
        writeTLVector(randomId)
        writeTLObject(toPeer)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        silent = isMask(32)
        background = isMask(64)
        withMyScore = isMask(256)
        fromPeer = readTLObject<TLAbsInputPeer>()
        id = readTLIntVector()
        randomId = readTLLongVector()
        toPeer = readTLObject<TLAbsInputPeer>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += fromPeer.computeSerializedSize()
        size += id.computeSerializedSize()
        size += randomId.computeSerializedSize()
        size += toPeer.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesForwardMessages) return false
        if (other === this) return true

        return _flags == other._flags
                && silent == other.silent
                && background == other.background
                && withMyScore == other.withMyScore
                && fromPeer == other.fromPeer
                && id == other.id
                && randomId == other.randomId
                && toPeer == other.toPeer
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x708e0195.toInt()
    }
}
