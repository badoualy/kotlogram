package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.TLDataJSON
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPhoneGetCallConfig : TLMethod<TLDataJSON>() {
    private val _constructor: String = "phone.getCallConfig#55451fa9"

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLDataJSON = tlDeserializer.readTLObject(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID)

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneGetCallConfig) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x55451fa9.toInt()
    }
}
