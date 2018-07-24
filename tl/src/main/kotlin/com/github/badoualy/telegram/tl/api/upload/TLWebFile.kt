package com.github.badoualy.telegram.tl.api.upload

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.storage.TLAbsFileType
import com.github.badoualy.telegram.tl.api.storage.TLFileMov
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * upload.webFile#21e753bc
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWebFile() : TLObject() {
    var size: Int = 0

    var mimeType: String = ""

    var fileType: TLAbsFileType = TLFileMov()

    var mtime: Int = 0

    var bytes: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "upload.webFile#21e753bc"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            size: Int,
            mimeType: String,
            fileType: TLAbsFileType,
            mtime: Int,
            bytes: TLBytes
    ) : this() {
        this.size = size
        this.mimeType = mimeType
        this.fileType = fileType
        this.mtime = mtime
        this.bytes = bytes
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(size)
        writeString(mimeType)
        writeTLObject(fileType)
        writeInt(mtime)
        writeTLBytes(bytes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        size = readInt()
        mimeType = readString()
        fileType = readTLObject<TLAbsFileType>()
        mtime = readInt()
        bytes = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(mimeType)
        size += fileType.computeSerializedSize()
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(bytes)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWebFile) return false
        if (other === this) return true

        return size == other.size
                && mimeType == other.mimeType
                && fileType == other.fileType
                && mtime == other.mtime
                && bytes == other.bytes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x21e753bc.toInt()
    }
}
