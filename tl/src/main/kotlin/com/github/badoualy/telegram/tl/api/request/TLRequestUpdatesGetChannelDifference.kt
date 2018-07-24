package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChannelMessagesFilter
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLChannelMessagesFilterEmpty
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference
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
class TLRequestUpdatesGetChannelDifference() : TLMethod<TLAbsChannelDifference>() {
    @Transient
    var force: Boolean = false

    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var filter: TLAbsChannelMessagesFilter = TLChannelMessagesFilterEmpty()

    var pts: Int = 0

    var limit: Int = 0

    private val _constructor: String = "updates.getChannelDifference#3173d78"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ) : this() {
        this.force = force
        this.channel = channel
        this.filter = filter
        this.pts = pts
        this.limit = limit
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(force, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(channel)
        writeTLObject(filter)
        writeInt(pts)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        force = isMask(1)
        channel = readTLObject<TLAbsInputChannel>()
        filter = readTLObject<TLAbsChannelMessagesFilter>()
        pts = readInt()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += channel.computeSerializedSize()
        size += filter.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestUpdatesGetChannelDifference) return false
        if (other === this) return true

        return _flags == other._flags
                && force == other.force
                && channel == other.channel
                && filter == other.filter
                && pts == other.pts
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3173d78.toInt()
    }
}
