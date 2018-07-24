package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLInputPhoneCall
import com.github.badoualy.telegram.tl.api.TLPhoneCallProtocol
import com.github.badoualy.telegram.tl.api.phone.TLPhoneCall
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPhoneConfirmCall() : TLMethod<TLPhoneCall>() {
    var peer: TLInputPhoneCall = TLInputPhoneCall()

    var gA: TLBytes = TLBytes.EMPTY

    var keyFingerprint: Long = 0L

    var protocol: TLPhoneCallProtocol = TLPhoneCallProtocol()

    private val _constructor: String = "phone.confirmCall#2efe1722"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ) : this() {
        this.peer = peer
        this.gA = gA
        this.keyFingerprint = keyFingerprint
        this.protocol = protocol
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLPhoneCall = tlDeserializer.readTLObject(TLPhoneCall::class, TLPhoneCall.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeTLBytes(gA)
        writeLong(keyFingerprint)
        writeTLObject(protocol)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLInputPhoneCall>(TLInputPhoneCall::class, TLInputPhoneCall.CONSTRUCTOR_ID)
        gA = readTLBytes()
        keyFingerprint = readLong()
        protocol = readTLObject<TLPhoneCallProtocol>(TLPhoneCallProtocol::class, TLPhoneCallProtocol.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += computeTLBytesSerializedSize(gA)
        size += SIZE_INT64
        size += protocol.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneConfirmCall) return false
        if (other === this) return true

        return peer == other.peer
                && gA == other.gA
                && keyFingerprint == other.keyFingerprint
                && protocol == other.protocol
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2efe1722.toInt()
    }
}
