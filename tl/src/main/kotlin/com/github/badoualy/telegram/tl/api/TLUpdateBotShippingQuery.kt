package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateBotShippingQuery#e0cdc940
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBotShippingQuery() : TLAbsUpdate() {
    var queryId: Long = 0L

    var userId: Int = 0

    var payload: TLBytes = TLBytes.EMPTY

    var shippingAddress: TLPostAddress = TLPostAddress()

    private val _constructor: String = "updateBotShippingQuery#e0cdc940"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            queryId: Long,
            userId: Int,
            payload: TLBytes,
            shippingAddress: TLPostAddress
    ) : this() {
        this.queryId = queryId
        this.userId = userId
        this.payload = payload
        this.shippingAddress = shippingAddress
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(queryId)
        writeInt(userId)
        writeTLBytes(payload)
        writeTLObject(shippingAddress)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        queryId = readLong()
        userId = readInt()
        payload = readTLBytes()
        shippingAddress = readTLObject<TLPostAddress>(TLPostAddress::class, TLPostAddress.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(payload)
        size += shippingAddress.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBotShippingQuery) return false
        if (other === this) return true

        return queryId == other.queryId
                && userId == other.userId
                && payload == other.payload
                && shippingAddress == other.shippingAddress
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe0cdc940.toInt()
    }
}
