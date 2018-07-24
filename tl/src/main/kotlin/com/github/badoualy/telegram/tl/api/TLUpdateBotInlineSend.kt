package com.github.badoualy.telegram.tl.api

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
 * updateBotInlineSend#e48f964
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBotInlineSend() : TLAbsUpdate() {
    var userId: Int = 0

    var query: String = ""

    var geo: TLAbsGeoPoint? = null

    var id: String = ""

    var msgId: TLInputBotInlineMessageID? = null

    private val _constructor: String = "updateBotInlineSend#e48f964"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            userId: Int,
            query: String,
            geo: TLAbsGeoPoint?,
            id: String,
            msgId: TLInputBotInlineMessageID?
    ) : this() {
        this.userId = userId
        this.query = query
        this.geo = geo
        this.id = id
        this.msgId = msgId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(geo, 1)
        updateFlags(msgId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(userId)
        writeString(query)
        doIfMask(geo, 1) { writeTLObject(it) }
        writeString(id)
        doIfMask(msgId, 2) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        userId = readInt()
        query = readString()
        geo = readIfMask(1) { readTLObject<TLAbsGeoPoint>() }
        id = readString()
        msgId = readIfMask(2) { readTLObject<TLInputBotInlineMessageID>(TLInputBotInlineMessageID::class, TLInputBotInlineMessageID.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(query)
        size += getIntIfMask(geo, 1) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(id)
        size += getIntIfMask(msgId, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBotInlineSend) return false
        if (other === this) return true

        return _flags == other._flags
                && userId == other.userId
                && query == other.query
                && geo == other.geo
                && id == other.id
                && msgId == other.msgId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe48f964.toInt()
    }
}
