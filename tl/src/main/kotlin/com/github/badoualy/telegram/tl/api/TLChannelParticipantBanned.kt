package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelParticipantBanned#222c1886
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipantBanned() : TLAbsChannelParticipant() {
    @Transient
    var left: Boolean = false

    override var userId: Int = 0

    var kickedBy: Int = 0

    var date: Int = 0

    var bannedRights: TLChannelBannedRights = TLChannelBannedRights()

    private val _constructor: String = "channelParticipantBanned#222c1886"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            left: Boolean,
            userId: Int,
            kickedBy: Int,
            date: Int,
            bannedRights: TLChannelBannedRights
    ) : this() {
        this.left = left
        this.userId = userId
        this.kickedBy = kickedBy
        this.date = date
        this.bannedRights = bannedRights
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(left, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(userId)
        writeInt(kickedBy)
        writeInt(date)
        writeTLObject(bannedRights)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        left = isMask(1)
        userId = readInt()
        kickedBy = readInt()
        date = readInt()
        bannedRights = readTLObject<TLChannelBannedRights>(TLChannelBannedRights::class, TLChannelBannedRights.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += bannedRights.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipantBanned) return false
        if (other === this) return true

        return _flags == other._flags
                && left == other.left
                && userId == other.userId
                && kickedBy == other.kickedBy
                && date == other.date
                && bannedRights == other.bannedRights
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x222c1886.toInt()
    }
}
