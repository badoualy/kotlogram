package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization
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
class TLRequestAuthImportBotAuthorization() : TLMethod<TLAuthorization>() {
    var flags: Int = 0

    var apiId: Int = 0

    var apiHash: String = ""

    var botAuthToken: String = ""

    private val _constructor: String = "auth.importBotAuthorization#67a3ff2c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ) : this() {
        this.flags = flags
        this.apiId = apiId
        this.apiHash = apiHash
        this.botAuthToken = botAuthToken
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLAuthorization = tlDeserializer.readTLObject(TLAuthorization::class, TLAuthorization.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(flags)
        writeInt(apiId)
        writeString(apiHash)
        writeString(botAuthToken)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        flags = readInt()
        apiId = readInt()
        apiHash = readString()
        botAuthToken = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(apiHash)
        size += computeTLStringSerializedSize(botAuthToken)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthImportBotAuthorization) return false
        if (other === this) return true

        return flags == other.flags
                && apiId == other.apiId
                && apiHash == other.apiHash
                && botAuthToken == other.botAuthToken
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x67a3ff2c.toInt()
    }
}
