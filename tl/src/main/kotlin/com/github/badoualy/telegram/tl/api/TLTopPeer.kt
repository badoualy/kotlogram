package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * topPeer#edcdc05b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTopPeer() : TLObject() {
    var peer: TLAbsPeer = TLPeerChannel()

    var rating: Double = 0.0

    private val _constructor: String = "topPeer#edcdc05b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(peer: TLAbsPeer, rating: Double) : this() {
        this.peer = peer
        this.rating = rating
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeDouble(rating)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsPeer>()
        rating = readDouble()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_DOUBLE
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTopPeer) return false
        if (other === this) return true

        return peer == other.peer
                && rating == other.rating
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xedcdc05b.toInt()
    }
}
