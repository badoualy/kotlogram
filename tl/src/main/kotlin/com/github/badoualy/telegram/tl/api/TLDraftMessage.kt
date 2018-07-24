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
import kotlin.jvm.Transient

/**
 * draftMessage#fd8e711f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDraftMessage() : TLAbsDraftMessage() {
    @Transient
    var noWebpage: Boolean = false

    var replyToMsgId: Int? = null

    var message: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var date: Int = 0

    private val _constructor: String = "draftMessage#fd8e711f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            noWebpage: Boolean,
            replyToMsgId: Int?,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            date: Int
    ) : this() {
        this.noWebpage = noWebpage
        this.replyToMsgId = replyToMsgId
        this.message = message
        this.entities = entities
        this.date = date
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(noWebpage, 2)
        updateFlags(replyToMsgId, 1)
        updateFlags(entities, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(replyToMsgId, 1) { writeInt(it) }
        writeString(message)
        doIfMask(entities, 8) { writeTLVector(it) }
        writeInt(date)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        noWebpage = isMask(2)
        replyToMsgId = readIfMask(1) { readInt() }
        message = readString()
        entities = readIfMask(8) { readTLVector<TLAbsMessageEntity>() }
        date = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(replyToMsgId, 1) { SIZE_INT32 }
        size += computeTLStringSerializedSize(message)
        size += getIntIfMask(entities, 8) { it.computeSerializedSize() }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDraftMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && noWebpage == other.noWebpage
                && replyToMsgId == other.replyToMsgId
                && message == other.message
                && entities == other.entities
                && date == other.date
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfd8e711f.toInt()
    }
}
