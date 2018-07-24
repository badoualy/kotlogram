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
import kotlin.String
import kotlin.jvm.Throws

/**
 * topPeerCategoryPeers#fb834291
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTopPeerCategoryPeers() : TLObject() {
    var category: TLAbsTopPeerCategory = TLTopPeerCategoryChannels()

    var count: Int = 0

    var peers: TLObjectVector<TLTopPeer> = TLObjectVector()

    private val _constructor: String = "topPeerCategoryPeers#fb834291"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            category: TLAbsTopPeerCategory,
            count: Int,
            peers: TLObjectVector<TLTopPeer>
    ) : this() {
        this.category = category
        this.count = count
        this.peers = peers
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(category)
        writeInt(count)
        writeTLVector(peers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        category = readTLObject<TLAbsTopPeerCategory>()
        count = readInt()
        peers = readTLVector<TLTopPeer>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += category.computeSerializedSize()
        size += SIZE_INT32
        size += peers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTopPeerCategoryPeers) return false
        if (other === this) return true

        return category == other.category
                && count == other.count
                && peers == other.peers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfb834291.toInt()
    }
}
