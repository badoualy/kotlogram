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
 * chatPhoto#6153276a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatPhoto() : TLAbsChatPhoto() {
    var photoSmall: TLAbsFileLocation = TLFileLocationUnavailable()

    var photoBig: TLAbsFileLocation = TLFileLocationUnavailable()

    private val _constructor: String = "chatPhoto#6153276a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(photoSmall: TLAbsFileLocation, photoBig: TLAbsFileLocation) : this() {
        this.photoSmall = photoSmall
        this.photoBig = photoBig
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(photoSmall)
        writeTLObject(photoBig)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        photoSmall = readTLObject<TLAbsFileLocation>()
        photoBig = readTLObject<TLAbsFileLocation>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += photoSmall.computeSerializedSize()
        size += photoBig.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatPhoto) return false
        if (other === this) return true

        return photoSmall == other.photoSmall
                && photoBig == other.photoBig
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6153276a.toInt()
    }
}
