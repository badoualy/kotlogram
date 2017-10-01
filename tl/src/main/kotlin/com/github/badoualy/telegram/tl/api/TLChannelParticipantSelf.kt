package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelParticipantSelf#a3289a6d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipantSelf() : TLAbsChannelParticipant() {
    override var userId: Int = 0

    var inviterId: Int = 0

    var date: Int = 0

    private val _constructor: String = "channelParticipantSelf#a3289a6d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Int,
            inviterId: Int,
            date: Int
    ) : this() {
        this.userId = userId
        this.inviterId = inviterId
        this.date = date
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(userId)
        writeInt(inviterId)
        writeInt(date)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readInt()
        inviterId = readInt()
        date = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipantSelf) return false
        if (other === this) return true

        return userId == other.userId
                && inviterId == other.inviterId
                && date == other.date
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa3289a6d.toInt()
    }
}
