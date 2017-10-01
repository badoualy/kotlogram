package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * phoneCall#ffe6ab67
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneCall() : TLAbsPhoneCall() {
    override var id: Long = 0L

    var accessHash: Long = 0L

    var date: Int = 0

    var adminId: Int = 0

    var participantId: Int = 0

    var gAOrB: TLBytes = TLBytes.EMPTY

    var keyFingerprint: Long = 0L

    var protocol: TLPhoneCallProtocol = TLPhoneCallProtocol()

    var connection: TLPhoneConnection = TLPhoneConnection()

    var alternativeConnections: TLObjectVector<TLPhoneConnection> = TLObjectVector()

    var startDate: Int = 0

    private val _constructor: String = "phoneCall#ffe6ab67"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            accessHash: Long,
            date: Int,
            adminId: Int,
            participantId: Int,
            gAOrB: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol,
            connection: TLPhoneConnection,
            alternativeConnections: TLObjectVector<TLPhoneConnection>,
            startDate: Int
    ) : this() {
        this.id = id
        this.accessHash = accessHash
        this.date = date
        this.adminId = adminId
        this.participantId = participantId
        this.gAOrB = gAOrB
        this.keyFingerprint = keyFingerprint
        this.protocol = protocol
        this.connection = connection
        this.alternativeConnections = alternativeConnections
        this.startDate = startDate
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeLong(accessHash)
        writeInt(date)
        writeInt(adminId)
        writeInt(participantId)
        writeTLBytes(gAOrB)
        writeLong(keyFingerprint)
        writeTLObject(protocol)
        writeTLObject(connection)
        writeTLVector(alternativeConnections)
        writeInt(startDate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        accessHash = readLong()
        date = readInt()
        adminId = readInt()
        participantId = readInt()
        gAOrB = readTLBytes()
        keyFingerprint = readLong()
        protocol = readTLObject<TLPhoneCallProtocol>(TLPhoneCallProtocol::class, TLPhoneCallProtocol.CONSTRUCTOR_ID)
        connection = readTLObject<TLPhoneConnection>(TLPhoneConnection::class, TLPhoneConnection.CONSTRUCTOR_ID)
        alternativeConnections = readTLVector<TLPhoneConnection>()
        startDate = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(gAOrB)
        size += SIZE_INT64
        size += protocol.computeSerializedSize()
        size += connection.computeSerializedSize()
        size += alternativeConnections.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneCall) return false
        if (other === this) return true

        return id == other.id
                && accessHash == other.accessHash
                && date == other.date
                && adminId == other.adminId
                && participantId == other.participantId
                && gAOrB == other.gAOrB
                && keyFingerprint == other.keyFingerprint
                && protocol == other.protocol
                && connection == other.connection
                && alternativeConnections == other.alternativeConnections
                && startDate == other.startDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xffe6ab67.toInt()
    }
}
