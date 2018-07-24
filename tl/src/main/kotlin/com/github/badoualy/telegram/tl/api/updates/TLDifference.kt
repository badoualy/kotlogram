package com.github.badoualy.telegram.tl.api.updates

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage
import com.github.badoualy.telegram.tl.api.TLAbsMessage
import com.github.badoualy.telegram.tl.api.TLAbsUpdate
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * updates.difference#f49ca0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDifference() : TLAbsDifference() {
    var newMessages: TLObjectVector<TLAbsMessage> = TLObjectVector()

    var newEncryptedMessages: TLObjectVector<TLAbsEncryptedMessage> = TLObjectVector()

    var otherUpdates: TLObjectVector<TLAbsUpdate> = TLObjectVector()

    var chats: TLObjectVector<TLAbsChat> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    var state: TLState = TLState()

    private val _constructor: String = "updates.difference#f49ca0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            newMessages: TLObjectVector<TLAbsMessage>,
            newEncryptedMessages: TLObjectVector<TLAbsEncryptedMessage>,
            otherUpdates: TLObjectVector<TLAbsUpdate>,
            chats: TLObjectVector<TLAbsChat>,
            users: TLObjectVector<TLAbsUser>,
            state: TLState
    ) : this() {
        this.newMessages = newMessages
        this.newEncryptedMessages = newEncryptedMessages
        this.otherUpdates = otherUpdates
        this.chats = chats
        this.users = users
        this.state = state
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(newMessages)
        writeTLVector(newEncryptedMessages)
        writeTLVector(otherUpdates)
        writeTLVector(chats)
        writeTLVector(users)
        writeTLObject(state)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        newMessages = readTLVector<TLAbsMessage>()
        newEncryptedMessages = readTLVector<TLAbsEncryptedMessage>()
        otherUpdates = readTLVector<TLAbsUpdate>()
        chats = readTLVector<TLAbsChat>()
        users = readTLVector<TLAbsUser>()
        state = readTLObject<TLState>(TLState::class, TLState.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += newMessages.computeSerializedSize()
        size += newEncryptedMessages.computeSerializedSize()
        size += otherUpdates.computeSerializedSize()
        size += chats.computeSerializedSize()
        size += users.computeSerializedSize()
        size += state.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDifference) return false
        if (other === this) return true

        return newMessages == other.newMessages
                && newEncryptedMessages == other.newEncryptedMessages
                && otherUpdates == other.otherUpdates
                && chats == other.chats
                && users == other.users
                && state == other.state
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf49ca0.toInt()
    }
}
