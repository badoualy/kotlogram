package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation
import com.github.badoualy.telegram.tl.api.TLInputEncryptedFileLocation
import com.github.badoualy.telegram.tl.api.upload.TLAbsFile
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestUploadGetFile() : TLMethod<TLAbsFile>() {
    var location: TLAbsInputFileLocation = TLInputEncryptedFileLocation()

    var offset: Int = 0

    var limit: Int = 0

    private val _constructor: String = "upload.getFile#e3a6cfb5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ) : this() {
        this.location = location
        this.offset = offset
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(location)
        writeInt(offset)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        location = readTLObject<TLAbsInputFileLocation>()
        offset = readInt()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += location.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestUploadGetFile) return false
        if (other === this) return true

        return location == other.location
                && offset == other.offset
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe3a6cfb5.toInt()
    }
}
