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
 * help.appUpdate#8987f311
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAppUpdate() : TLAbsAppUpdate() {
    var id: Int = 0

    var critical: Boolean = false

    var url: String = ""

    var text: String = ""

    private val _constructor: String = "help.appUpdate#8987f311"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Int,
            critical: Boolean,
            url: String,
            text: String
    ) : this() {
        this.id = id
        this.critical = critical
        this.url = url
        this.text = text
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(id)
        writeBoolean(critical)
        writeString(url)
        writeString(text)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readInt()
        critical = readBoolean()
        url = readString()
        text = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_BOOLEAN
        size += computeTLStringSerializedSize(url)
        size += computeTLStringSerializedSize(text)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAppUpdate) return false
        if (other === this) return true

        return id == other.id
                && critical == other.critical
                && url == other.url
                && text == other.text
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8987f311.toInt()
    }
}
