package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAuthorization
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * account.authorizations#1250abde
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAuthorizations() : TLObject() {
    var authorizations: TLObjectVector<TLAuthorization> = TLObjectVector()

    private val _constructor: String = "account.authorizations#1250abde"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(authorizations: TLObjectVector<TLAuthorization>) : this() {
        this.authorizations = authorizations
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(authorizations)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        authorizations = readTLVector<TLAuthorization>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += authorizations.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAuthorizations) return false
        if (other === this) return true

        return authorizations == other.authorizations
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1250abde.toInt()
    }
}
