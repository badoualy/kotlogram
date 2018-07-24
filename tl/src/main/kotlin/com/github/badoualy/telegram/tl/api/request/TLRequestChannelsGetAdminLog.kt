package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLChannelAdminLogEventsFilter
import com.github.badoualy.telegram.tl.api.TLInputChannelEmpty
import com.github.badoualy.telegram.tl.api.channels.TLAdminLogResults
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestChannelsGetAdminLog() : TLMethod<TLAdminLogResults>() {
    var channel: TLAbsInputChannel = TLInputChannelEmpty()

    var q: String = ""

    var eventsFilter: TLChannelAdminLogEventsFilter? = null

    var admins: TLObjectVector<TLAbsInputUser>? = TLObjectVector()

    var maxId: Long = 0L

    var minId: Long = 0L

    var limit: Int = 0

    private val _constructor: String = "channels.getAdminLog#33ddf480"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ) : this() {
        this.channel = channel
        this.q = q
        this.eventsFilter = eventsFilter
        this.admins = admins
        this.maxId = maxId
        this.minId = minId
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLAdminLogResults = tlDeserializer.readTLObject(TLAdminLogResults::class, TLAdminLogResults.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(eventsFilter, 1)
        updateFlags(admins, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(channel)
        writeString(q)
        doIfMask(eventsFilter, 1) { writeTLObject(it) }
        doIfMask(admins, 2) { writeTLVector(it) }
        writeLong(maxId)
        writeLong(minId)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        channel = readTLObject<TLAbsInputChannel>()
        q = readString()
        eventsFilter = readIfMask(1) { readTLObject<TLChannelAdminLogEventsFilter>(TLChannelAdminLogEventsFilter::class, TLChannelAdminLogEventsFilter.CONSTRUCTOR_ID) }
        admins = readIfMask(2) { readTLVector<TLAbsInputUser>() }
        maxId = readLong()
        minId = readLong()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += channel.computeSerializedSize()
        size += computeTLStringSerializedSize(q)
        size += getIntIfMask(eventsFilter, 1) { it.computeSerializedSize() }
        size += getIntIfMask(admins, 2) { it.computeSerializedSize() }
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestChannelsGetAdminLog) return false
        if (other === this) return true

        return _flags == other._flags
                && channel == other.channel
                && q == other.q
                && eventsFilter == other.eventsFilter
                && admins == other.admins
                && maxId == other.maxId
                && minId == other.minId
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x33ddf480.toInt()
    }
}
