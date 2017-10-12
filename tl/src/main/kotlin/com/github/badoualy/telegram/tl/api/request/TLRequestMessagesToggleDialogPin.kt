package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesToggleDialogPin() : TLMethod<TLBool>() {
    @Transient
    var pinned: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    private val _constructor: String = "messages.toggleDialogPin#3289be6a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(pinned: Boolean, peer: TLAbsInputPeer) : this() {
        this.pinned = pinned
        this.peer = peer
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(pinned, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pinned = isMask(1)
        peer = readTLObject<TLAbsInputPeer>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesToggleDialogPin) return false
        if (other === this) return true

        return _flags == other._flags
                && pinned == other.pinned
                && peer == other.peer
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3289be6a.toInt()
    }
}
