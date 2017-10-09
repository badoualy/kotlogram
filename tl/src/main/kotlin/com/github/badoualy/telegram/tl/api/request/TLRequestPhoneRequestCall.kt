package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputUser
import com.github.badoualy.telegram.tl.api.TLInputUserEmpty
import com.github.badoualy.telegram.tl.api.TLPhoneCallProtocol
import com.github.badoualy.telegram.tl.api.phone.TLPhoneCall
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPhoneRequestCall() : TLMethod<TLPhoneCall>() {
    var userId: TLAbsInputUser = TLInputUserEmpty()

    var randomId: Int = 0

    var gAHash: TLBytes = TLBytes.EMPTY

    var protocol: TLPhoneCallProtocol = TLPhoneCallProtocol()

    private val _constructor: String = "phone.requestCall#5b95b3d4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ) : this() {
        this.userId = userId
        this.randomId = randomId
        this.gAHash = gAHash
        this.protocol = protocol
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLPhoneCall = tlDeserializer.readTLObject(TLPhoneCall::class, TLPhoneCall.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(userId)
        writeInt(randomId)
        writeTLBytes(gAHash)
        writeTLObject(protocol)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        userId = readTLObject<TLAbsInputUser>()
        randomId = readInt()
        gAHash = readTLBytes()
        protocol = readTLObject<TLPhoneCallProtocol>(TLPhoneCallProtocol::class, TLPhoneCallProtocol.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += userId.computeSerializedSize()
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(gAHash)
        size += protocol.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneRequestCall) return false
        if (other === this) return true

        return userId == other.userId
                && randomId == other.randomId
                && gAHash == other.gAHash
                && protocol == other.protocol
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5b95b3d4.toInt()
    }
}
