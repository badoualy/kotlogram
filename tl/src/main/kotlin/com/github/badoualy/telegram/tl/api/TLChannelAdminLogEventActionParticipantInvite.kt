package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelAdminLogEventActionParticipantInvite#e31c34d8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionParticipantInvite() : TLAbsChannelAdminLogEventAction() {
    var participant: TLAbsChannelParticipant = TLChannelParticipantCreator()

    private val _constructor: String = "channelAdminLogEventActionParticipantInvite#e31c34d8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(participant: TLAbsChannelParticipant) : this() {
        this.participant = participant
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(participant)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        participant = readTLObject<TLAbsChannelParticipant>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += participant.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionParticipantInvite) return false
        if (other === this) return true

        return participant == other.participant
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe31c34d8.toInt()
    }
}
