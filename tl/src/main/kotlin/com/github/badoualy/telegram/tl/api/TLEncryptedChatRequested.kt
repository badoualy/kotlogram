package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
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
 * encryptedChatRequested#c878527e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEncryptedChatRequested() : TLAbsEncryptedChat() {
    override var id: Int = 0

    var accessHash: Long = 0L

    var date: Int = 0

    var adminId: Int = 0

    var participantId: Int = 0

    var gA: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "encryptedChatRequested#c878527e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Int,
            accessHash: Long,
            date: Int,
            adminId: Int,
            participantId: Int,
            gA: TLBytes
    ) : this() {
        this.id = id
        this.accessHash = accessHash
        this.date = date
        this.adminId = adminId
        this.participantId = participantId
        this.gA = gA
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(id)
        writeLong(accessHash)
        writeInt(date)
        writeInt(adminId)
        writeInt(participantId)
        writeTLBytes(gA)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readInt()
        accessHash = readLong()
        date = readInt()
        adminId = readInt()
        participantId = readInt()
        gA = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(gA)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEncryptedChatRequested) return false
        if (other === this) return true

        return id == other.id
                && accessHash == other.accessHash
                && date == other.date
                && adminId == other.adminId
                && participantId == other.participantId
                && gA == other.gA
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc878527e.toInt()
    }
}
