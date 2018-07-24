package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.account.TLAuthorizationForm
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
class TLRequestAccountGetAuthorizationForm() : TLMethod<TLAuthorizationForm>() {
    var botId: Int = 0

    var scope: String = ""

    var publicKey: String = ""

    private val _constructor: String = "account.getAuthorizationForm#b86ba8e1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            botId: Int,
            scope: String,
            publicKey: String
    ) : this() {
        this.botId = botId
        this.scope = scope
        this.publicKey = publicKey
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLAuthorizationForm = tlDeserializer.readTLObject(TLAuthorizationForm::class, TLAuthorizationForm.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(botId)
        writeString(scope)
        writeString(publicKey)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        botId = readInt()
        scope = readString()
        publicKey = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(scope)
        size += computeTLStringSerializedSize(publicKey)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetAuthorizationForm) return false
        if (other === this) return true

        return botId == other.botId
                && scope == other.scope
                && publicKey == other.publicKey
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb86ba8e1.toInt()
    }
}
