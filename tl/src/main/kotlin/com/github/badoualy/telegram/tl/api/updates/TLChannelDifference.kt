package com.github.badoualy.telegram.tl.api.updates

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsMessage
import com.github.badoualy.telegram.tl.api.TLAbsUpdate
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updates.channelDifference#2064674e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelDifference() : TLAbsChannelDifference() {
    @Transient
    override var _final: Boolean = false

    override var pts: Int = 0

    override var timeout: Int? = null

    var newMessages: TLObjectVector<TLAbsMessage> = TLObjectVector()

    var otherUpdates: TLObjectVector<TLAbsUpdate> = TLObjectVector()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "updates.channelDifference#2064674e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            _final: Boolean,
            pts: Int,
            timeout: Int?,
            newMessages: TLObjectVector<TLAbsMessage>,
            otherUpdates: TLObjectVector<TLAbsUpdate>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this._final = _final
        this.pts = pts
        this.timeout = timeout
        this.newMessages = newMessages
        this.otherUpdates = otherUpdates
        this.chats = chats
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(_final, 1)
        updateFlags(timeout, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(pts)
        doIfMask(timeout, 2) { writeInt(it) }
        writeTLVector(newMessages)
        writeTLVector(otherUpdates)
        writeTLVector(chats)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        _final = isMask(1)
        pts = readInt()
        timeout = readIfMask(2) { readInt() }
        newMessages = readTLVector<TLAbsMessage>()
        otherUpdates = readTLVector<TLAbsUpdate>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(timeout, 2) { SIZE_INT32 }
        size += newMessages.computeSerializedSize()
        size += otherUpdates.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelDifference) return false
        if (other === this) return true

        return _flags == other._flags
                && _final == other._final
                && pts == other.pts
                && timeout == other.timeout
                && newMessages == other.newMessages
                && otherUpdates == other.otherUpdates
                && chats == other.chats
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2064674e.toInt()
    }
}
