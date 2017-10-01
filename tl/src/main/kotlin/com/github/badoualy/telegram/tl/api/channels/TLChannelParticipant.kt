package com.github.badoualy.telegram.tl.api.channels

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsChannelParticipant
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLChannelParticipantCreator
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channels.channelParticipant#d0d9b163
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipant() : TLObject() {
    var participant: TLAbsChannelParticipant = TLChannelParticipantCreator()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "channels.channelParticipant#d0d9b163"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(participant: TLAbsChannelParticipant, users: TLObjectVector<TLAbsUser>) : this() {
        this.participant = participant
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(participant)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        participant = readTLObject<TLAbsChannelParticipant>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += participant.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipant) return false
        if (other === this) return true

        return participant == other.participant
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd0d9b163.toInt()
    }
}
