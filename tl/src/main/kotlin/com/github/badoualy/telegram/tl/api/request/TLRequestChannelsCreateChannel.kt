package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChannelsCreateChannel() : TLMethod<TLAbsUpdates>() {
    @Transient
    var broadcast: Boolean = false

    @Transient
    var megagroup: Boolean = false

    var title: String = ""

    var about: String = ""

    private val _constructor: String = "channels.createChannel#f4893d7f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            broadcast: Boolean,
            megagroup: Boolean,
            title: String,
            about: String
    ) : this() {
        this.broadcast = broadcast
        this.megagroup = megagroup
        this.title = title
        this.about = about
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(broadcast, 1)
        updateFlags(megagroup, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(title)
        writeString(about)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        broadcast = isMask(1)
        megagroup = isMask(2)
        title = readString()
        about = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(about)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsCreateChannel) return false
        if (other === this) return true

        return _flags == other._flags
                && broadcast == other.broadcast
                && megagroup == other.megagroup
                && title == other.title
                && about == other.about
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf4893d7f.toInt()
    }
}
