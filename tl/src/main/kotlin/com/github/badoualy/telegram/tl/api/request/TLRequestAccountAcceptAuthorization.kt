package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLSecureCredentialsEncrypted
import com.github.badoualy.telegram.tl.api.TLSecureValueHash
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountAcceptAuthorization() : TLMethod<TLBool>() {
    var botId: Int = 0

    var scope: String = ""

    var publicKey: String = ""

    var valueHashes: TLObjectVector<TLSecureValueHash> = TLObjectVector()

    var credentials: TLSecureCredentialsEncrypted = TLSecureCredentialsEncrypted()

    private val _constructor: String = "account.acceptAuthorization#e7027c94"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            botId: Int,
            scope: String,
            publicKey: String,
            valueHashes: TLObjectVector<TLSecureValueHash>,
            credentials: TLSecureCredentialsEncrypted
    ) : this() {
        this.botId = botId
        this.scope = scope
        this.publicKey = publicKey
        this.valueHashes = valueHashes
        this.credentials = credentials
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(botId)
        writeString(scope)
        writeString(publicKey)
        writeTLVector(valueHashes)
        writeTLObject(credentials)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        botId = readInt()
        scope = readString()
        publicKey = readString()
        valueHashes = readTLVector<TLSecureValueHash>()
        credentials = readTLObject<TLSecureCredentialsEncrypted>(TLSecureCredentialsEncrypted::class, TLSecureCredentialsEncrypted.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(scope)
        size += computeTLStringSerializedSize(publicKey)
        size += valueHashes.computeSerializedSize()
        size += credentials.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountAcceptAuthorization) return false
        if (other === this) return true

        return botId == other.botId
                && scope == other.scope
                && publicKey == other.publicKey
                && valueHashes == other.valueHashes
                && credentials == other.credentials
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe7027c94.toInt()
    }
}
