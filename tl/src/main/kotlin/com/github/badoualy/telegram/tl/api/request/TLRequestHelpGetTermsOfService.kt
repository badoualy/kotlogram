package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.help.TLTermsOfService
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestHelpGetTermsOfService : TLMethod<TLTermsOfService>() {
    private val _constructor: String = "help.getTermsOfService#350170f3"

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLTermsOfService = tlDeserializer.readTLObject(TLTermsOfService::class, TLTermsOfService.CONSTRUCTOR_ID)

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestHelpGetTermsOfService) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x350170f3.toInt()
    }
}
