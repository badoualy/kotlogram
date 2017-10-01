package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * fileLocation#53d69076
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFileLocation() : TLAbsFileLocation() {
    var dcId: Int = 0

    override var volumeId: Long = 0L

    override var localId: Int = 0

    override var secret: Long = 0L

    private val _constructor: String = "fileLocation#53d69076"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            dcId: Int,
            volumeId: Long,
            localId: Int,
            secret: Long
    ) : this() {
        this.dcId = dcId
        this.volumeId = volumeId
        this.localId = localId
        this.secret = secret
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(dcId)
        writeLong(volumeId)
        writeInt(localId)
        writeLong(secret)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        dcId = readInt()
        volumeId = readLong()
        localId = readInt()
        secret = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFileLocation) return false
        if (other === this) return true

        return dcId == other.dcId
                && volumeId == other.volumeId
                && localId == other.localId
                && secret == other.secret
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x53d69076.toInt()
    }
}
