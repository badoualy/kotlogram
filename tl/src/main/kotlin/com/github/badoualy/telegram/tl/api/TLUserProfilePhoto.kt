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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * userProfilePhoto#d559d8c8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUserProfilePhoto() : TLAbsUserProfilePhoto() {
    var photoId: Long = 0L

    var photoSmall: TLAbsFileLocation = TLFileLocationUnavailable()

    var photoBig: TLAbsFileLocation = TLFileLocationUnavailable()

    private val _constructor: String = "userProfilePhoto#d559d8c8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            photoId: Long,
            photoSmall: TLAbsFileLocation,
            photoBig: TLAbsFileLocation
    ) : this() {
        this.photoId = photoId
        this.photoSmall = photoSmall
        this.photoBig = photoBig
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(photoId)
        writeTLObject(photoSmall)
        writeTLObject(photoBig)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        photoId = readLong()
        photoSmall = readTLObject<TLAbsFileLocation>()
        photoBig = readTLObject<TLAbsFileLocation>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += photoSmall.computeSerializedSize()
        size += photoBig.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUserProfilePhoto) return false
        if (other === this) return true

        return photoId == other.photoId
                && photoSmall == other.photoSmall
                && photoBig == other.photoBig
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd559d8c8.toInt()
    }
}
