package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.api.TLCdnFileHash
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestUploadReuploadCdnFile() : TLMethod<TLObjectVector<TLCdnFileHash>>() {
    var fileToken: TLBytes = TLBytes.EMPTY

    var requestToken: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "upload.reuploadCdnFile#1af91c09"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(fileToken: TLBytes, requestToken: TLBytes) : this() {
        this.fileToken = fileToken
        this.requestToken = requestToken
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLObjectVector<TLCdnFileHash> = tlDeserializer.readTLVector<TLCdnFileHash>()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLBytes(fileToken)
        writeTLBytes(requestToken)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        fileToken = readTLBytes()
        requestToken = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLBytesSerializedSize(fileToken)
        size += computeTLBytesSerializedSize(requestToken)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestUploadReuploadCdnFile) return false
        if (other === this) return true

        return fileToken == other.fileToken
                && requestToken == other.requestToken
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1af91c09.toInt()
    }
}
