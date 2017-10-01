package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.api.TLLangPackLanguage
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestLangpackGetLanguages : TLMethod<TLObjectVector<TLLangPackLanguage>>() {
    private val _constructor: String = "langpack.getLanguages#800fd57d"

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLObjectVector<TLLangPackLanguage> = tlDeserializer.readTLVector<TLLangPackLanguage>()

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestLangpackGetLanguages) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x800fd57d.toInt()
    }
}
