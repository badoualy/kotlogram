package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.TLObjectUtils
import com.github.badoualy.telegram.tl.exception.InvalidConstructorIdException

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.io.Serializable

import com.github.badoualy.telegram.tl.StreamUtils.readInt
import com.github.badoualy.telegram.tl.StreamUtils.writeInt
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import com.github.badoualy.telegram.tl.serialization.TLStreamSerializer

/**
 * Basic class for all tl-objects. Contains methods for serializing and deserializing object.
 * Each tl-object has its own class id to identify object class for deserialization.
 * This number might be unique and often equals to crc32 of tl-record of tl-constructor.
 * See more at [https://core.telegram.org/mtproto/TL](https://core.telegram.org/mtproto/TL)
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
@Suppress("NOTHING_TO_INLINE")
abstract class TLObject : Serializable {

    /**
     * the constructor id represented by this class
     */
    abstract val constructorId: Int

    protected var _flags: Int = 0

    /**
     * Compute and return the flags field value
     * @return flags value (or 0 if no flag for this constructor)
     */
    protected open fun computeFlags() {

    }

    /**
     * Serialize object to byte array
     *
     * @return serialized object with header
     * @throws IOException
     */
    @Throws(IOException::class)
    fun serialize(): ByteArray {
        val stream = ByteArrayOutputStream(computeSerializedSize())
        serialize(TLStreamSerializer(stream))
        return stream.toByteArray()
    }

    /**
     * Serialize object to stream
     *
     * @param tlSerializer instance of the serializer to use
     * @throws IOException
     */
    @Throws(IOException::class)
    fun serialize(tlSerializer: TLSerializer) {
        tlSerializer.writeInt(constructorId)
        serializeBody(tlSerializer)
    }

    /**
     * Deserialize object from stream and current TLContext
     *
     * @param stream  source stream
     * @param context tl context
     * @throws IOException
     */
    @Throws(IOException::class)
    fun deserialize(stream: InputStream, context: TLContext) {
        val constructorId = readInt(stream)
        if (constructorId != this.constructorId)
            throw InvalidConstructorIdException(constructorId, this.constructorId)
        deserializeBody(stream, context)
    }

    /**
     * Serialize object body to stream
     *
     * @param tlSerializer instance of the serializer to use
     * @throws IOException
     */
    @Throws(IOException::class)
    open fun serializeBody(tlSerializer: TLSerializer) {

    }

    /**
     * Deserialize object from stream and context
     *
     * @param stream  source stream
     * @param context tl context
     * @throws IOException
     */
    @Throws(IOException::class)
    open fun deserializeBody(stream: InputStream, context: TLContext) {

    }

    /**
     * Compute the size in bytes of the serialized object
     *
     * @return size in bytes
     */
    open fun computeSerializedSize(): Int = TLObjectUtils.SIZE_CONSTRUCTOR_ID // Constructor is 4-byte (int32)

    /**
     * Ensure that the value is not null, if it is throw an exception
     *
     * @param value value to check
     * @param fieldName name of the field trying to be serialized
     * @param flags flags field current value
     * @throws NullPointerException if value is null
     * @return value
     */
    @Throws(NullPointerException::class)
    inline protected fun <T> ensureNotNull(value: T?): T =
            value ?: throw NullPointerException(
                    "Attempt to serialize null field. value: $value, flags: $_flags)")

    inline protected fun updateFlags(value: Boolean, maskValue: Int) {
        _flags = if (value) _flags.or(maskValue) else _flags.and(maskValue.inv())
    }

    inline protected fun updateFlags(value: Any?, maskValue: Int) = updateFlags(value != null, maskValue)

    inline protected fun isMask(maskValue: Int) = (_flags and maskValue) != 0

    inline protected fun <reified T> readIfMask(maskValue: Int, provider: () -> T): T? =
            if (isMask(maskValue)) provider.invoke() else null

    inline protected fun <reified T> doIfMask(value: T?, maskValue: Int, action: (T) -> Unit) {
        if (isMask(maskValue)) action.invoke(ensureNotNull(value))
    }

    inline protected fun <reified T> getIntIfMask(value: T?, maskValue: Int, provider: (T) -> Int) =
            if (isMask(maskValue)) provider.invoke(ensureNotNull(value)) else 0
}
