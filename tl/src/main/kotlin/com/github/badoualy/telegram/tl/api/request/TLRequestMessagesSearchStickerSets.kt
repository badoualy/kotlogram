package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.messages.TLAbsFoundStickerSets
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSearchStickerSets() : TLMethod<TLAbsFoundStickerSets>() {
    @Transient
    var excludeFeatured: Boolean = false

    var q: String = ""

    var hash: Int = 0

    private val _constructor: String = "messages.searchStickerSets#c2b7d08b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            excludeFeatured: Boolean,
            q: String,
            hash: Int
    ) : this() {
        this.excludeFeatured = excludeFeatured
        this.q = q
        this.hash = hash
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(excludeFeatured, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(q)
        writeInt(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        excludeFeatured = isMask(1)
        q = readString()
        hash = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(q)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSearchStickerSets) return false
        if (other === this) return true

        return _flags == other._flags
                && excludeFeatured == other.excludeFeatured
                && q == other.q
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc2b7d08b.toInt()
    }
}
