package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * updateShortSentMessage#11f1331c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateShortSentMessage() : TLAbsUpdates() {
    @Transient
    var out: Boolean = false

    var id: Int = 0

    var pts: Int = 0

    var ptsCount: Int = 0

    var date: Int = 0

    var media: TLAbsMessageMedia? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    private val _constructor: String = "updateShortSentMessage#11f1331c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            out: Boolean,
            id: Int,
            pts: Int,
            ptsCount: Int,
            date: Int,
            media: TLAbsMessageMedia?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ) : this() {
        this.out = out
        this.id = id
        this.pts = pts
        this.ptsCount = ptsCount
        this.date = date
        this.media = media
        this.entities = entities
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(out, 2)
        updateFlags(media, 512)
        updateFlags(entities, 128)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeInt(pts)
        writeInt(ptsCount)
        writeInt(date)
        doIfMask(media, 512) { writeTLObject(it) }
        doIfMask(entities, 128) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        out = isMask(2)
        id = readInt()
        pts = readInt()
        ptsCount = readInt()
        date = readInt()
        media = readIfMask(512) { readTLObject<TLAbsMessageMedia>() }
        entities = readIfMask(128) { readTLVector<TLAbsMessageEntity>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(media, 512) { it.computeSerializedSize() }
        size += getIntIfMask(entities, 128) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateShortSentMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && out == other.out
                && id == other.id
                && pts == other.pts
                && ptsCount == other.ptsCount
                && date == other.date
                && media == other.media
                && entities == other.entities
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x11f1331c.toInt()
    }
}
