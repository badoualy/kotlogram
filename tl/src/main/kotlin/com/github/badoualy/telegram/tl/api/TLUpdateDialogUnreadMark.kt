package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * updateDialogUnreadMark#e16459c3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateDialogUnreadMark() : TLAbsUpdate() {
    @Transient
    var unread: Boolean = false

    var peer: TLDialogPeer = TLDialogPeer()

    private val _constructor: String = "updateDialogUnreadMark#e16459c3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(unread: Boolean, peer: TLDialogPeer) : this() {
        this.unread = unread
        this.peer = peer
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(unread, 1)
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
        unread = isMask(1)
        peer = readTLObject<TLDialogPeer>(TLDialogPeer::class, TLDialogPeer.CONSTRUCTOR_ID)
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
        if (other !is TLUpdateDialogUnreadMark) return false
        if (other === this) return true

        return _flags == other._flags
                && unread == other.unread
                && peer == other.peer
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe16459c3.toInt()
    }
}
