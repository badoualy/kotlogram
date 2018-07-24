package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
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
 * langPackDifference#f385c1f6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLLangPackDifference() : TLObject() {
    var langCode: String = ""

    var fromVersion: Int = 0

    var version: Int = 0

    var strings: TLObjectVector<TLAbsLangPackString> = TLObjectVector()

    private val _constructor: String = "langPackDifference#f385c1f6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            langCode: String,
            fromVersion: Int,
            version: Int,
            strings: TLObjectVector<TLAbsLangPackString>
    ) : this() {
        this.langCode = langCode
        this.fromVersion = fromVersion
        this.version = version
        this.strings = strings
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(langCode)
        writeInt(fromVersion)
        writeInt(version)
        writeTLVector(strings)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        langCode = readString()
        fromVersion = readInt()
        version = readInt()
        strings = readTLVector<TLAbsLangPackString>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(langCode)
        size += SIZE_INT32
        size += SIZE_INT32
        size += strings.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLLangPackDifference) return false
        if (other === this) return true

        return langCode == other.langCode
                && fromVersion == other.fromVersion
                && version == other.version
                && strings == other.strings
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf385c1f6.toInt()
    }
}
