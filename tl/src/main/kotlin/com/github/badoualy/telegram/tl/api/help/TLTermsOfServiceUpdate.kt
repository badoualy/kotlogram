package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * help.termsOfServiceUpdate#28ecf961
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTermsOfServiceUpdate() : TLAbsTermsOfServiceUpdate() {
    override var expires: Int = 0

    var termsOfService: TLTermsOfService = TLTermsOfService()

    private val _constructor: String = "help.termsOfServiceUpdate#28ecf961"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(expires: Int, termsOfService: TLTermsOfService) : this() {
        this.expires = expires
        this.termsOfService = termsOfService
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(expires)
        writeTLObject(termsOfService)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        expires = readInt()
        termsOfService = readTLObject<TLTermsOfService>(TLTermsOfService::class, TLTermsOfService.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += termsOfService.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTermsOfServiceUpdate) return false
        if (other === this) return true

        return expires == other.expires
                && termsOfService == other.termsOfService
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x28ecf961.toInt()
    }
}
