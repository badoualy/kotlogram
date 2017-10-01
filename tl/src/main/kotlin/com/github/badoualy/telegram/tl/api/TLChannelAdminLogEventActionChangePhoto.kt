package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * channelAdminLogEventActionChangePhoto#b82f55c3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionChangePhoto() : TLAbsChannelAdminLogEventAction() {
    var prevPhoto: TLAbsChatPhoto = TLChatPhotoEmpty()

    var newPhoto: TLAbsChatPhoto = TLChatPhotoEmpty()

    private val _constructor: String = "channelAdminLogEventActionChangePhoto#b82f55c3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(prevPhoto: TLAbsChatPhoto, newPhoto: TLAbsChatPhoto) : this() {
        this.prevPhoto = prevPhoto
        this.newPhoto = newPhoto
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(prevPhoto)
        writeTLObject(newPhoto)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        prevPhoto = readTLObject<TLAbsChatPhoto>()
        newPhoto = readTLObject<TLAbsChatPhoto>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += prevPhoto.computeSerializedSize()
        size += newPhoto.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionChangePhoto) return false
        if (other === this) return true

        return prevPhoto == other.prevPhoto
                && newPhoto == other.newPhoto
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb82f55c3.toInt()
    }
}
