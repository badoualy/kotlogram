package com.github.badoualy.telegram.tl.api.help

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity
import com.github.badoualy.telegram.tl.api.TLDataJSON
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
import kotlin.jvm.Transient

/**
 * help.termsOfService#780a0310
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTermsOfService() : TLObject() {
    @Transient
    var popup: Boolean = false

    var id: TLDataJSON = TLDataJSON()

    var text: String = ""

    var entities: TLObjectVector<TLAbsMessageEntity> = TLObjectVector()

    var minAgeConfirm: Int? = null

    private val _constructor: String = "help.termsOfService#780a0310"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            popup: Boolean,
            id: TLDataJSON,
            text: String,
            entities: TLObjectVector<TLAbsMessageEntity>,
            minAgeConfirm: Int?
    ) : this() {
        this.popup = popup
        this.id = id
        this.text = text
        this.entities = entities
        this.minAgeConfirm = minAgeConfirm
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(popup, 1)
        updateFlags(minAgeConfirm, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(id)
        writeString(text)
        writeTLVector(entities)
        doIfMask(minAgeConfirm, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        popup = isMask(1)
        id = readTLObject<TLDataJSON>(TLDataJSON::class, TLDataJSON.CONSTRUCTOR_ID)
        text = readString()
        entities = readTLVector<TLAbsMessageEntity>()
        minAgeConfirm = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += id.computeSerializedSize()
        size += computeTLStringSerializedSize(text)
        size += entities.computeSerializedSize()
        size += getIntIfMask(minAgeConfirm, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTermsOfService) return false
        if (other === this) return true

        return _flags == other._flags
                && popup == other.popup
                && id == other.id
                && text == other.text
                && entities == other.entities
                && minAgeConfirm == other.minAgeConfirm
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x780a0310.toInt()
    }
}
