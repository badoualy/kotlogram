package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * inputMediaUploadedPhoto#1e287d04
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaUploadedPhoto() : TLAbsInputMedia() {
    var file: TLAbsInputFile = TLInputFileBig()

    var stickers: TLObjectVector<TLAbsInputDocument>? = TLObjectVector()

    var ttlSeconds: Int? = null

    private val _constructor: String = "inputMediaUploadedPhoto#1e287d04"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            file: TLAbsInputFile,
            stickers: TLObjectVector<TLAbsInputDocument>?,
            ttlSeconds: Int?
    ) : this() {
        this.file = file
        this.stickers = stickers
        this.ttlSeconds = ttlSeconds
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(stickers, 1)
        updateFlags(ttlSeconds, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(file)
        doIfMask(stickers, 1) { writeTLVector(it) }
        doIfMask(ttlSeconds, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        file = readTLObject<TLAbsInputFile>()
        stickers = readIfMask(1) { readTLVector<TLAbsInputDocument>() }
        ttlSeconds = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += file.computeSerializedSize()
        size += getIntIfMask(stickers, 1) { it.computeSerializedSize() }
        size += getIntIfMask(ttlSeconds, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaUploadedPhoto) return false
        if (other === this) return true

        return _flags == other._flags
                && file == other.file
                && stickers == other.stickers
                && ttlSeconds == other.ttlSeconds
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1e287d04.toInt()
    }
}
