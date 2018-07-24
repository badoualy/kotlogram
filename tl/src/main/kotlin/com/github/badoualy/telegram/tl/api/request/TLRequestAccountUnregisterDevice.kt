package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountUnregisterDevice() : TLMethod<TLBool>() {
    var tokenType: Int = 0

    var token: String = ""

    var otherUids: TLIntVector = TLIntVector()

    private val _constructor: String = "account.unregisterDevice#3076c4bf"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            tokenType: Int,
            token: String,
            otherUids: TLIntVector
    ) : this() {
        this.tokenType = tokenType
        this.token = token
        this.otherUids = otherUids
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(tokenType)
        writeString(token)
        writeTLVector(otherUids)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        tokenType = readInt()
        token = readString()
        otherUids = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(token)
        size += otherUids.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountUnregisterDevice) return false
        if (other === this) return true

        return tokenType == other.tokenType
                && token == other.token
                && otherUids == other.otherUids
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3076c4bf.toInt()
    }
}
