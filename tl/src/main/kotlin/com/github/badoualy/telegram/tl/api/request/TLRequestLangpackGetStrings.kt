package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsLangPackString
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLStringVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestLangpackGetStrings() : TLMethod<TLObjectVector<TLAbsLangPackString>>() {
    var langCode: String = ""

    var keys: TLStringVector = TLStringVector()

    private val _constructor: String = "langpack.getStrings#2e1ee318"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(langCode: String, keys: TLStringVector) : this() {
        this.langCode = langCode
        this.keys = keys
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLObjectVector<TLAbsLangPackString> = tlDeserializer.readTLVector<TLAbsLangPackString>()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(langCode)
        writeTLVector(keys)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        langCode = readString()
        keys = readTLStringVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(langCode)
        size += keys.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestLangpackGetStrings) return false
        if (other === this) return true

        return langCode == other.langCode
                && keys == other.keys
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2e1ee318.toInt()
    }
}
