package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesEditMessage() : TLMethod<TLAbsUpdates>() {
    @Transient
    var noWebpage: Boolean = false

    @Transient
    var stopGeoLive: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var id: Int = 0

    var message: String? = null

    var replyMarkup: TLAbsReplyMarkup? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var geoPoint: TLAbsInputGeoPoint? = null

    private val _constructor: String = "messages.editMessage#5d1b8dd"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            noWebpage: Boolean,
            stopGeoLive: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            geoPoint: TLAbsInputGeoPoint?
    ) : this() {
        this.noWebpage = noWebpage
        this.stopGeoLive = stopGeoLive
        this.peer = peer
        this.id = id
        this.message = message
        this.replyMarkup = replyMarkup
        this.entities = entities
        this.geoPoint = geoPoint
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(noWebpage, 2)
        updateFlags(stopGeoLive, 4096)
        updateFlags(message, 2048)
        updateFlags(replyMarkup, 4)
        updateFlags(entities, 8)
        updateFlags(geoPoint, 8192)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeInt(id)
        doIfMask(message, 2048) { writeString(it) }
        doIfMask(replyMarkup, 4) { writeTLObject(it) }
        doIfMask(entities, 8) { writeTLVector(it) }
        doIfMask(geoPoint, 8192) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        noWebpage = isMask(2)
        stopGeoLive = isMask(4096)
        peer = readTLObject<TLAbsInputPeer>()
        id = readInt()
        message = readIfMask(2048) { readString() }
        replyMarkup = readIfMask(4) { readTLObject<TLAbsReplyMarkup>() }
        entities = readIfMask(8) { readTLVector<TLAbsMessageEntity>() }
        geoPoint = readIfMask(8192) { readTLObject<TLAbsInputGeoPoint>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(message, 2048) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(replyMarkup, 4) { it.computeSerializedSize() }
        size += getIntIfMask(entities, 8) { it.computeSerializedSize() }
        size += getIntIfMask(geoPoint, 8192) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesEditMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && noWebpage == other.noWebpage
                && stopGeoLive == other.stopGeoLive
                && peer == other.peer
                && id == other.id
                && message == other.message
                && replyMarkup == other.replyMarkup
                && entities == other.entities
                && geoPoint == other.geoPoint
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5d1b8dd.toInt()
    }
}
