package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation
import com.github.badoualy.telegram.tl.api.TLFileHash
import com.github.badoualy.telegram.tl.api.TLInputTakeoutFileLocation
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestUploadGetFileHashes() : TLMethod<TLObjectVector<TLFileHash>>() {
    var location: TLAbsInputFileLocation = TLInputTakeoutFileLocation()

    var offset: Int = 0

    private val _constructor: String = "upload.getFileHashes#c7025931"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(location: TLAbsInputFileLocation, offset: Int) : this() {
        this.location = location
        this.offset = offset
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLObjectVector<TLFileHash> = tlDeserializer.readTLVector<TLFileHash>()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(location)
        writeInt(offset)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        location = readTLObject<TLAbsInputFileLocation>()
        offset = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += location.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestUploadGetFileHashes) return false
        if (other === this) return true

        return location == other.location
                && offset == other.offset
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc7025931.toInt()
    }
}
