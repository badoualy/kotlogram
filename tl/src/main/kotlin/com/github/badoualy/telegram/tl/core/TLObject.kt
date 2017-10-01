package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.TLObjectUtils
import com.github.badoualy.telegram.tl.exception.InvalidConstructorIdException
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import com.github.badoualy.telegram.tl.serialization.TLStreamSerializer
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.Serializable

/**
 * Basic class for all tl-objects. Contains methods for serializing and deserializing object.
 * Each tl-object has its own class id to identify object class for deserialization.
 * This number might be unique and often equals to crc32 of tl-record of tl-constructor.
 * See more at [https://core.telegram.org/mtproto/TL](https://core.telegram.org/mtproto/TL)
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
@Suppress("NOTHING_TO_INLINE")
abstract class TLObject : Serializable {

    /**
     * the constructor id of the constructor represented by this class
     */
    abstract val constructorId: Int

    /**
     * the flags field of this constructor, if this constructor has no flags, equals to 0
     */
    protected var _flags: Int = 0

    /**
     * Compute the flags field value. Each constructor that have a flags field should override this method
     */
    protected open fun computeFlags() {

    }

    // region toremove
    /**
     * Serialize object to byte array (including constructor id)
     *
     * @return serialized object with header (constructor id)
     * @throws IOException
     */
    @Deprecated(message = "You should use overload with tlSerializer instead",
                replaceWith = ReplaceWith("serialize(tlSerializer)"))
    @Throws(IOException::class)
    fun serialize(): ByteArray {
        val stream = ByteArrayOutputStream(computeSerializedSize())
        serialize(TLStreamSerializer(stream))
        return stream.toByteArray()
    }
    // endregion

    /**
     * Deserialize object (including reading constructor id)
     *
     * @param tlDeserializer the deserializer instance to use to read from
     * @throws IOException
     */
    @Throws(IOException::class)
    fun deserialize(tlDeserializer: TLDeserializer) {
        val constructorId = tlDeserializer.readInt()
        if (constructorId != this.constructorId)
            throw InvalidConstructorIdException(constructorId, this.constructorId)
        deserializeBody(tlDeserializer)
    }

    /**
     * Serialize object to the given serializer
     *
     * @param tlSerializer instance of the serializer to write to
     * @throws IOException
     */
    @Throws(IOException::class)
    fun serialize(tlSerializer: TLSerializer) {
        tlSerializer.writeInt(constructorId)
        serializeBody(tlSerializer)
    }

    /**
     * Serialize object body to stream (excluding the constructor id)
     *
     * @param tlSerializer instance of the serializer to use
     * @throws IOException
     */
    @Throws(IOException::class)
    open fun serializeBody(tlSerializer: TLSerializer) {

    }

    /**
     * Deserialize object body (without reading the constructor id)
     *
     * @throws IOException
     */
    @Throws(IOException::class)
    open fun deserializeBody(tlDeserializer: TLDeserializer) {

    }

    /**
     * Compute the size in bytes of the serialized object
     *
     * @return size in bytes
     */
    open fun computeSerializedSize(): Int = TLObjectUtils.SIZE_CONSTRUCTOR_ID // Constructor is 4-byte (int32)

    /**
     * Ensure that the value is not null, throw an exception otherwise
     *
     * @param value value to check
     * @throws NullPointerException if value is null
     * @return not null asserted value
     */
    @Throws(NullPointerException::class)
    inline protected fun <T> ensureNotNull(value: T?): T =
            value ?: throw NullPointerException(
                    "Attempt to serialize null field. value: $value, flags: $_flags)")

    /**
     * Update the flags value bit by setting the given bitmask to 1 if value is true, or to 0 otherwise
     * @param value if true, the flags will set the bitmask to 1, else 0
     * @param maskValue bitmask to update
     */
    inline protected fun updateFlags(value: Boolean, maskValue: Int) {
        _flags = if (value) _flags.or(maskValue) else _flags.and(maskValue.inv())
    }

    /**
     * Update the flags value bit by setting the given bitmask to 1 if value is not null, or to 0 otherwise
     * @param value if not null, the flags will set the bitmask to 1, else 0
     * @param maskValue bitmask to update
     */
    inline protected fun updateFlags(value: Any?, maskValue: Int) = updateFlags(value != null,
                                                                                maskValue)

    /**
     * @return true if the bitmask is true (all bits to 1) on the flags
     */
    inline protected fun isMask(maskValue: Int) = (_flags and maskValue) != 0

    /**
     * Execute the given function is the mask is true
     * @param maskValue bitmask to check
     * @param provider function to execute if the bitmask is true
     * @return return value from provider if the bitmask is true, null otherwise
     */
    inline protected fun <T> readIfMask(maskValue: Int, provider: () -> T): T? =
            if (isMask(maskValue)) provider.invoke() else null

    /**
     * Execute the given function with value ensured not null as argument is the mask is true
     * @param value argument to the action function, which will be ensured as not null
     * @param maskValue bitmask to check
     * @param action function to execute if the bitmask is true
     */
    inline protected fun <T> doIfMask(value: T?, maskValue: Int, action: (T) -> Unit) {
        if (isMask(maskValue)) action.invoke(ensureNotNull(value))
    }

    /**
     * Execute the given function with value ensured not null as argument is the mask is true
     * @param value argument to the action function, which will be ensured as not null
     * @param maskValue bitmask to check
     * @param provider function to execute if the bitmask is true
     * @return return value from provider if the bitmask is true, 0 otherwise
     */
    inline protected fun <T> getIntIfMask(value: T?, maskValue: Int, provider: (T) -> Int) =
            if (isMask(maskValue)) provider.invoke(ensureNotNull(value)) else 0
}
