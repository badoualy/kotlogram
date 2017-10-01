package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * phoneCallWaiting#1b8f4ad1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneCallWaiting() : TLAbsPhoneCall() {
    override var id: Long = 0L

    var accessHash: Long = 0L

    var date: Int = 0

    var adminId: Int = 0

    var participantId: Int = 0

    var protocol: TLPhoneCallProtocol = TLPhoneCallProtocol()

    var receiveDate: Int? = null

    private val _constructor: String = "phoneCallWaiting#1b8f4ad1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            accessHash: Long,
            date: Int,
            adminId: Int,
            participantId: Int,
            protocol: TLPhoneCallProtocol,
            receiveDate: Int?
    ) : this() {
        this.id = id
        this.accessHash = accessHash
        this.date = date
        this.adminId = adminId
        this.participantId = participantId
        this.protocol = protocol
        this.receiveDate = receiveDate
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(receiveDate, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeLong(accessHash)
        writeInt(date)
        writeInt(adminId)
        writeInt(participantId)
        writeTLObject(protocol)
        doIfMask(receiveDate, 1) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        id = readLong()
        accessHash = readLong()
        date = readInt()
        adminId = readInt()
        participantId = readInt()
        protocol = readTLObject<TLPhoneCallProtocol>(TLPhoneCallProtocol::class, TLPhoneCallProtocol.CONSTRUCTOR_ID)
        receiveDate = readIfMask(1) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += protocol.computeSerializedSize()
        size += getIntIfMask(receiveDate, 1) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneCallWaiting) return false
        if (other === this) return true

        return _flags == other._flags
                && id == other.id
                && accessHash == other.accessHash
                && date == other.date
                && adminId == other.adminId
                && participantId == other.participantId
                && protocol == other.protocol
                && receiveDate == other.receiveDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1b8f4ad1.toInt()
    }
}
