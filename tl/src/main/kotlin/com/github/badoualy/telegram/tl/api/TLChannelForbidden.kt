package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelForbidden#289da732
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelForbidden() : TLAbsChat() {
    @Transient
    var broadcast: Boolean = false

    @Transient
    var megagroup: Boolean = false

    override var id: Int = 0

    var accessHash: Long = 0L

    var title: String = ""

    var untilDate: Int? = null

    private val _constructor: String = "channelForbidden#289da732"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            broadcast: Boolean,
            megagroup: Boolean,
            id: Int,
            accessHash: Long,
            title: String,
            untilDate: Int?
    ) : this() {
        this.broadcast = broadcast
        this.megagroup = megagroup
        this.id = id
        this.accessHash = accessHash
        this.title = title
        this.untilDate = untilDate
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(broadcast, 32)
        updateFlags(megagroup, 256)
        updateFlags(untilDate, 65536)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeLong(accessHash)
        writeString(title)
        doIfMask(untilDate, 65536) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        broadcast = isMask(32)
        megagroup = isMask(256)
        id = readInt()
        accessHash = readLong()
        title = readString()
        untilDate = readIfMask(65536) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT64
        size += computeTLStringSerializedSize(title)
        size += getIntIfMask(untilDate, 65536) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelForbidden) return false
        if (other === this) return true

        return _flags == other._flags
                && broadcast == other.broadcast
                && megagroup == other.megagroup
                && id == other.id
                && accessHash == other.accessHash
                && title == other.title
                && untilDate == other.untilDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x289da732.toInt()
    }
}
