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
 * channelParticipantAdmin#a82fa898
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipantAdmin() : TLAbsChannelParticipant() {
    @Transient
    var canEdit: Boolean = false

    override var userId: Int = 0

    var inviterId: Int = 0

    var promotedBy: Int = 0

    var date: Int = 0

    var adminRights: TLChannelAdminRights = TLChannelAdminRights()

    private val _constructor: String = "channelParticipantAdmin#a82fa898"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            canEdit: Boolean,
            userId: Int,
            inviterId: Int,
            promotedBy: Int,
            date: Int,
            adminRights: TLChannelAdminRights
    ) : this() {
        this.canEdit = canEdit
        this.userId = userId
        this.inviterId = inviterId
        this.promotedBy = promotedBy
        this.date = date
        this.adminRights = adminRights
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(canEdit, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(userId)
        writeInt(inviterId)
        writeInt(promotedBy)
        writeInt(date)
        writeTLObject(adminRights)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        canEdit = isMask(1)
        userId = readInt()
        inviterId = readInt()
        promotedBy = readInt()
        date = readInt()
        adminRights = readTLObject<TLChannelAdminRights>(TLChannelAdminRights::class, TLChannelAdminRights.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += adminRights.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipantAdmin) return false
        if (other === this) return true

        return _flags == other._flags
                && canEdit == other.canEdit
                && userId == other.userId
                && inviterId == other.inviterId
                && promotedBy == other.promotedBy
                && date == other.date
                && adminRights == other.adminRights
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa82fa898.toInt()
    }
}
