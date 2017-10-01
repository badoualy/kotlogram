package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * disabledFeature#ae636f24
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDisabledFeature() : TLObject() {
    var feature: String = ""

    var description: String = ""

    private val _constructor: String = "disabledFeature#ae636f24"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(feature: String, description: String) : this() {
        this.feature = feature
        this.description = description
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(feature)
        writeString(description)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        feature = readString()
        description = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(feature)
        size += computeTLStringSerializedSize(description)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDisabledFeature) return false
        if (other === this) return true

        return feature == other.feature
                && description == other.description
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xae636f24.toInt()
    }
}
