package com.github.badoualy.telegram.tl.api.upload

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.api.TLCdnFileHash
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * upload.fileCdnRedirect#ea52fe5a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFileCdnRedirect() : TLAbsFile() {
    var dcId: Int = 0

    var fileToken: TLBytes = TLBytes.EMPTY

    var encryptionKey: TLBytes = TLBytes.EMPTY

    var encryptionIv: TLBytes = TLBytes.EMPTY

    var cdnFileHashes: TLObjectVector<TLCdnFileHash> = TLObjectVector()

    private val _constructor: String = "upload.fileCdnRedirect#ea52fe5a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            dcId: Int,
            fileToken: TLBytes,
            encryptionKey: TLBytes,
            encryptionIv: TLBytes,
            cdnFileHashes: TLObjectVector<TLCdnFileHash>
    ) : this() {
        this.dcId = dcId
        this.fileToken = fileToken
        this.encryptionKey = encryptionKey
        this.encryptionIv = encryptionIv
        this.cdnFileHashes = cdnFileHashes
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(dcId)
        writeTLBytes(fileToken)
        writeTLBytes(encryptionKey)
        writeTLBytes(encryptionIv)
        writeTLVector(cdnFileHashes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        dcId = readInt()
        fileToken = readTLBytes()
        encryptionKey = readTLBytes()
        encryptionIv = readTLBytes()
        cdnFileHashes = readTLVector<TLCdnFileHash>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(fileToken)
        size += computeTLBytesSerializedSize(encryptionKey)
        size += computeTLBytesSerializedSize(encryptionIv)
        size += cdnFileHashes.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFileCdnRedirect) return false
        if (other === this) return true

        return dcId == other.dcId
                && fileToken == other.fileToken
                && encryptionKey == other.encryptionKey
                && encryptionIv == other.encryptionIv
                && cdnFileHashes == other.cdnFileHashes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xea52fe5a.toInt()
    }
}
