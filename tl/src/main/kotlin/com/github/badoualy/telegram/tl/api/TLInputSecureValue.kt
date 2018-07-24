package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * inputSecureValue#67872e8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputSecureValue() : TLObject() {
    var type: TLAbsSecureValueType = TLSecureValueTypeAddress()

    var data: TLSecureData? = null

    var frontSide: TLAbsInputSecureFile? = null

    var reverseSide: TLAbsInputSecureFile? = null

    var selfie: TLAbsInputSecureFile? = null

    var files: TLObjectVector<TLAbsInputSecureFile>? = TLObjectVector()

    var plainData: TLAbsSecurePlainData? = null

    private val _constructor: String = "inputSecureValue#67872e8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            type: TLAbsSecureValueType,
            data: TLSecureData?,
            frontSide: TLAbsInputSecureFile?,
            reverseSide: TLAbsInputSecureFile?,
            selfie: TLAbsInputSecureFile?,
            files: TLObjectVector<TLAbsInputSecureFile>?,
            plainData: TLAbsSecurePlainData?
    ) : this() {
        this.type = type
        this.data = data
        this.frontSide = frontSide
        this.reverseSide = reverseSide
        this.selfie = selfie
        this.files = files
        this.plainData = plainData
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
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        type = readTLObject<TLAbsSecureValueType>()
        data = readIfMask(1) { readTLObject<TLSecureData>(TLSecureData::class, TLSecureData.CONSTRUCTOR_ID) }
        frontSide = readIfMask(2) { readTLObject<TLAbsInputSecureFile>() }
        reverseSide = readIfMask(4) { readTLObject<TLAbsInputSecureFile>() }
        selfie = readIfMask(8) { readTLObject<TLAbsInputSecureFile>() }
        files = readIfMask(16) { readTLVector<TLAbsInputSecureFile>() }
        plainData = readIfMask(32) { readTLObject<TLAbsSecurePlainData>() }
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
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputSecureValue) return false
        if (other === this) return true

        return _flags == other._flags
                && type == other.type
                && data == other.data
                && frontSide == other.frontSide
                && reverseSide == other.reverseSide
                && selfie == other.selfie
                && files == other.files
                && plainData == other.plainData
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x67872e8.toInt()
    }
}
