package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * messageActionSecureValuesSentMe#1b287353
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionSecureValuesSentMe() : TLAbsMessageAction() {
    var values: TLObjectVector<TLSecureValue> = TLObjectVector()

    var credentials: TLSecureCredentialsEncrypted = TLSecureCredentialsEncrypted()

    private val _constructor: String = "messageActionSecureValuesSentMe#1b287353"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(values: TLObjectVector<TLSecureValue>, credentials: TLSecureCredentialsEncrypted) : this() {
        this.values = values
        this.credentials = credentials
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(values)
        writeTLObject(credentials)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        values = readTLVector<TLSecureValue>()
        credentials = readTLObject<TLSecureCredentialsEncrypted>(TLSecureCredentialsEncrypted::class, TLSecureCredentialsEncrypted.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += values.computeSerializedSize()
        size += credentials.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionSecureValuesSentMe) return false
        if (other === this) return true

        return values == other.values
                && credentials == other.credentials
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1b287353.toInt()
    }
}
