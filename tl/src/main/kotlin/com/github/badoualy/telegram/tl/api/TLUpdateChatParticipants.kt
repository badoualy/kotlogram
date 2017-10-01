package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateChatParticipants#7761198
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChatParticipants() : TLAbsUpdate() {
    var participants: TLAbsChatParticipants = TLChatParticipants()

    private val _constructor: String = "updateChatParticipants#7761198"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(participants: TLAbsChatParticipants) : this() {
        this.participants = participants
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(participants)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        participants = readTLObject<TLAbsChatParticipants>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += participants.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChatParticipants) return false
        if (other === this) return true

        return participants == other.participants
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7761198.toInt()
    }
}
