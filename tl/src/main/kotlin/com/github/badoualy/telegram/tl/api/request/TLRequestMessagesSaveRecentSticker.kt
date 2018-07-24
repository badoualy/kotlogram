package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputDocument
import com.github.badoualy.telegram.tl.api.TLInputDocumentEmpty
import com.github.badoualy.telegram.tl.core.TLBool
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
class TLRequestMessagesSaveRecentSticker() : TLMethod<TLBool>() {
    @Transient
    var attached: Boolean = false

    var id: TLAbsInputDocument = TLInputDocumentEmpty()

    var unsave: Boolean = false

    private val _constructor: String = "messages.saveRecentSticker#392718f8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            attached: Boolean,
            id: TLAbsInputDocument,
            unsave: Boolean
    ) : this() {
        this.attached = attached
        this.id = id
        this.unsave = unsave
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(attached, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(id)
        writeBoolean(unsave)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        attached = isMask(1)
        id = readTLObject<TLAbsInputDocument>()
        unsave = readBoolean()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += id.computeSerializedSize()
        size += SIZE_BOOLEAN
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSaveRecentSticker) return false
        if (other === this) return true

        return _flags == other._flags
                && attached == other.attached
                && id == other.id
                && unsave == other.unsave
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x392718f8.toInt()
    }
}
