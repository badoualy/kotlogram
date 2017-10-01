package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateServiceNotification#ebe46819
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateServiceNotification() : TLAbsUpdate() {
    @Transient
    var popup: Boolean = false

    var inboxDate: Int? = null

    var type: String = ""

    var message: String = ""

    var media: TLAbsMessageMedia = TLMessageMediaEmpty()

    var entities: TLObjectVector<TLAbsMessageEntity> = TLObjectVector()

    private val _constructor: String = "updateServiceNotification#ebe46819"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            popup: Boolean,
            inboxDate: Int?,
            type: String,
            message: String,
            media: TLAbsMessageMedia,
            entities: TLObjectVector<TLAbsMessageEntity>
    ) : this() {
        this.popup = popup
        this.inboxDate = inboxDate
        this.type = type
        this.message = message
        this.media = media
        this.entities = entities
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(popup, 1)
        updateFlags(inboxDate, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(inboxDate, 2) { writeInt(it) }
        writeString(type)
        writeString(message)
        writeTLObject(media)
        writeTLVector(entities)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        popup = isMask(1)
        inboxDate = readIfMask(2) { readInt() }
        type = readString()
        message = readString()
        media = readTLObject<TLAbsMessageMedia>()
        entities = readTLVector<TLAbsMessageEntity>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(inboxDate, 2) { SIZE_INT32 }
        size += computeTLStringSerializedSize(type)
        size += computeTLStringSerializedSize(message)
        size += media.computeSerializedSize()
        size += entities.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateServiceNotification) return false
        if (other === this) return true

        return _flags == other._flags
                && popup == other.popup
                && inboxDate == other.inboxDate
                && type == other.type
                && message == other.message
                && media == other.media
                && entities == other.entities
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xebe46819.toInt()
    }
}
