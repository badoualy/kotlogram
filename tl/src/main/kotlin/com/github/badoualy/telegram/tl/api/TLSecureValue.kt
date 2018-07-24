package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject
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
 * secureValue#b4b4b699
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureValue() : TLObject() {
    var type: TLAbsSecureValueType = TLSecureValueTypeAddress()

    var data: TLSecureData? = null

    var frontSide: TLAbsSecureFile? = null

    var reverseSide: TLAbsSecureFile? = null

    var selfie: TLAbsSecureFile? = null

    var files: TLObjectVector<TLAbsSecureFile>? = TLObjectVector()

    var plainData: TLAbsSecurePlainData? = null

    var hash: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "secureValue#b4b4b699"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            type: TLAbsSecureValueType,
            data: TLSecureData?,
            frontSide: TLAbsSecureFile?,
            reverseSide: TLAbsSecureFile?,
            selfie: TLAbsSecureFile?,
            files: TLObjectVector<TLAbsSecureFile>?,
            plainData: TLAbsSecurePlainData?,
            hash: TLBytes
    ) : this() {
        this.type = type
        this.data = data
        this.frontSide = frontSide
        this.reverseSide = reverseSide
        this.selfie = selfie
        this.files = files
        this.plainData = plainData
        this.hash = hash
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(data, 1)
        updateFlags(frontSide, 2)
        updateFlags(reverseSide, 4)
        updateFlags(selfie, 8)
        updateFlags(files, 16)
        updateFlags(plainData, 32)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(type)
        doIfMask(data, 1) { writeTLObject(it) }
        doIfMask(frontSide, 2) { writeTLObject(it) }
        doIfMask(reverseSide, 4) { writeTLObject(it) }
        doIfMask(selfie, 8) { writeTLObject(it) }
        doIfMask(files, 16) { writeTLVector(it) }
        doIfMask(plainData, 32) { writeTLObject(it) }
        writeTLBytes(hash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        type = readTLObject<TLAbsSecureValueType>()
        data = readIfMask(1) { readTLObject<TLSecureData>(TLSecureData::class, TLSecureData.CONSTRUCTOR_ID) }
        frontSide = readIfMask(2) { readTLObject<TLAbsSecureFile>() }
        reverseSide = readIfMask(4) { readTLObject<TLAbsSecureFile>() }
        selfie = readIfMask(8) { readTLObject<TLAbsSecureFile>() }
        files = readIfMask(16) { readTLVector<TLAbsSecureFile>() }
        plainData = readIfMask(32) { readTLObject<TLAbsSecurePlainData>() }
        hash = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += type.computeSerializedSize()
        size += getIntIfMask(data, 1) { it.computeSerializedSize() }
        size += getIntIfMask(frontSide, 2) { it.computeSerializedSize() }
        size += getIntIfMask(reverseSide, 4) { it.computeSerializedSize() }
        size += getIntIfMask(selfie, 8) { it.computeSerializedSize() }
        size += getIntIfMask(files, 16) { it.computeSerializedSize() }
        size += getIntIfMask(plainData, 32) { it.computeSerializedSize() }
        size += computeTLBytesSerializedSize(hash)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureValue) return false
        if (other === this) return true

        return _flags == other._flags
                && type == other.type
                && data == other.data
                && frontSide == other.frontSide
                && reverseSide == other.reverseSide
                && selfie == other.selfie
                && files == other.files
                && plainData == other.plainData
                && hash == other.hash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb4b4b699.toInt()
    }
}
