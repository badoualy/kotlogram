package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
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
class TLRequestInvokeAfterMsgs<T : TLObject>() : TLMethod<T>() {
    var msgIds: TLLongVector = TLLongVector()

    var query: TLMethod<T>? = null

    private val _constructor: String = "invokeAfterMsgs#3dc4b4f0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(msgIds: TLLongVector, query: TLMethod<T>?) : this() {
        this.msgIds = msgIds
        this.query = query
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): T = query!!.deserializeResponse(tlDeserializer)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(msgIds)
        writeTLMethod(query!!)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        msgIds = readTLLongVector()
        query = readTLMethod()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += msgIds.computeSerializedSize()
        size += query!!.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestInvokeAfterMsgs<*>) return false
        if (other === this) return true

        return msgIds == other.msgIds
                && query == other.query
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3dc4b4f0.toInt()
    }
}
