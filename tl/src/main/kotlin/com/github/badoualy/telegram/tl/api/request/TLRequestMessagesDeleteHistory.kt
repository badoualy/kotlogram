package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesDeleteHistory() : TLMethod<TLAffectedHistory>() {
    @Transient
    var justClear: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var maxId: Int = 0

    private val _constructor: String = "messages.deleteHistory#1c015b09"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            justClear: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int
    ) : this() {
        this.justClear = justClear
        this.peer = peer
        this.maxId = maxId
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLAffectedHistory = tlDeserializer.readTLObject(TLAffectedHistory::class, TLAffectedHistory.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(justClear, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(maxId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        justClear = isMask(1)
        peer = readTLObject<TLAbsInputPeer>()
        maxId = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesDeleteHistory) return false
        if (other === this) return true

        return _flags == other._flags
                && justClear == other.justClear
                && peer == other.peer
                && maxId == other.maxId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1c015b09.toInt()
    }
}
