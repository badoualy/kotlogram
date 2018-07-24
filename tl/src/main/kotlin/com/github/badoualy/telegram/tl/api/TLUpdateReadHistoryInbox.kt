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

/**
 * updateReadHistoryInbox#9961fd5c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateReadHistoryInbox() : TLAbsUpdate() {
    var peer: TLAbsPeer = TLPeerUser()

    var maxId: Int = 0

    var pts: Int = 0

    var ptsCount: Int = 0

    private val _constructor: String = "updateReadHistoryInbox#9961fd5c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsPeer,
            maxId: Int,
            pts: Int,
            ptsCount: Int
    ) : this() {
        this.peer = peer
        this.maxId = maxId
        this.pts = pts
        this.ptsCount = ptsCount
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(maxId)
        writeInt(pts)
        writeInt(ptsCount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsPeer>()
        maxId = readInt()
        pts = readInt()
        ptsCount = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateReadHistoryInbox) return false
        if (other === this) return true

        return peer == other.peer
                && maxId == other.maxId
                && pts == other.pts
                && ptsCount == other.ptsCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9961fd5c.toInt()
    }
}
