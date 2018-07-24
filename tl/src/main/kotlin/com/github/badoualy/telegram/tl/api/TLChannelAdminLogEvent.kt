package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * channelAdminLogEvent#3b5a3e40
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEvent() : TLObject() {
    var id: Long = 0L

    var date: Int = 0

    var userId: Int = 0

    var action: TLAbsChannelAdminLogEventAction = TLChannelAdminLogEventActionParticipantLeave()

    private val _constructor: String = "channelAdminLogEvent#3b5a3e40"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            date: Int,
            userId: Int,
            action: TLAbsChannelAdminLogEventAction
    ) : this() {
        this.id = id
        this.date = date
        this.userId = userId
        this.action = action
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeInt(date)
        writeInt(userId)
        writeTLObject(action)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        date = readInt()
        userId = readInt()
        action = readTLObject<TLAbsChannelAdminLogEventAction>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        size += action.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEvent) return false
        if (other === this) return true

        return id == other.id
                && date == other.date
                && userId == other.userId
                && action == other.action
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3b5a3e40.toInt()
    }
}
