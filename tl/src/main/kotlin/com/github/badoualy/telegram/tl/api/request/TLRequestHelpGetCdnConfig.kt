package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.TLCdnConfig
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestHelpGetCdnConfig : TLMethod<TLCdnConfig>() {
    private val _constructor: String = "help.getCdnConfig#52029342"

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLCdnConfig = tlDeserializer.readTLObject()

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestHelpGetCdnConfig) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x52029342.toInt()
    }
}
