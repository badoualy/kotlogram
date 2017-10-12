package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLAbsTopPeerCategory
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLTopPeerCategoryChannels
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestContactsResetTopPeerRating() : TLMethod<TLBool>() {
    var category: TLAbsTopPeerCategory = TLTopPeerCategoryChannels()

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    private val _constructor: String = "contacts.resetTopPeerRating#1ae373ac"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer) : this() {
        this.category = category
        this.peer = peer
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(category)
        writeTLObject(peer)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        category = readTLObject<TLAbsTopPeerCategory>()
        peer = readTLObject<TLAbsInputPeer>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += category.computeSerializedSize()
        size += peer.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestContactsResetTopPeerRating) return false
        if (other === this) return true

        return category == other.category
                && peer == other.peer
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1ae373ac.toInt()
    }
}
