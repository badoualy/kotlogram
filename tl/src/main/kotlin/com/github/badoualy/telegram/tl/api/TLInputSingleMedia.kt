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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputSingleMedia#1cc6e91f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputSingleMedia() : TLObject() {
    var media: TLAbsInputMedia = TLInputMediaEmpty()

    var randomId: Long = 0L

    var message: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    private val _constructor: String = "inputSingleMedia#1cc6e91f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            media: TLAbsInputMedia,
            randomId: Long,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ) : this() {
        this.media = media
        this.randomId = randomId
        this.message = message
        this.entities = entities
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(entities, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(media)
        writeLong(randomId)
        writeString(message)
        doIfMask(entities, 1) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        media = readTLObject<TLAbsInputMedia>()
        randomId = readLong()
        message = readString()
        entities = readIfMask(1) { readTLVector<TLAbsMessageEntity>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += media.computeSerializedSize()
        size += SIZE_INT64
        size += computeTLStringSerializedSize(message)
        size += getIntIfMask(entities, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputSingleMedia) return false
        if (other === this) return true

        return _flags == other._flags
                && media == other.media
                && randomId == other.randomId
                && message == other.message
                && entities == other.entities
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1cc6e91f.toInt()
    }
}
