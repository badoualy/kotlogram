package com.github.badoualy.telegram.tl.serialization

import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.*
import com.github.badoualy.telegram.tl.exception.InvalidConstructorIdException
import java.io.IOException
import kotlin.reflect.KClass

/**
 * Interface describing a set of functions to deserialize types of the TL Language
 */
interface TLDeserializer {

    val context: TLContext

    fun available(): Int

    fun readByte(): Int
    fun readBytes(len: Int) = readBytes(ByteArray(len), 0, len)
    fun readBytes(buffer: ByteArray, offset: Int, len: Int): ByteArray

    fun readInt(): Int {
        val a = readByte()
        val b = readByte()
        val c = readByte()
        val d = readByte()

        return a + (b shl 8) + (c shl 16) + (d shl 24)
    }

    fun readUInt(): Long {
        val a = readByte().toLong()
        val b = readByte().toLong()
        val c = readByte().toLong()
        val d = readByte().toLong()

        return a + (b shl 8) + (c shl 16) + (d shl 24)
    }

    fun readLong(): Long {
        val a = readUInt()
        val b = readUInt()

        return a + (b shl 32)
    }

    fun readDouble(): Double = java.lang.Double.longBitsToDouble(readLong())
    fun readBoolean(): Boolean = TLBool.deserialize(this)
    fun readString(): String = String(readTLBytesAsBytes(), Charsets.UTF_8)

    fun readTLBytes(): TLBytes
    fun readTLBytesAsBytes() = readTLBytes().data

    fun <T : TLObject> readTLObject(): T = readTLObject(null, -1)

    fun <T : TLObject> readTLObject(expectedClazz: KClass<T>? = null, expectedConstructorId: Int = -1): T {
        var clazz = expectedClazz?.java
        var constructorId = expectedConstructorId

        val realConstructorId = readInt()
        if (constructorId != -1 && realConstructorId != constructorId)
            throw InvalidConstructorIdException(realConstructorId, constructorId)

        if (constructorId == -1) {
            constructorId = realConstructorId
            clazz = null
        }

        @Suppress("UNCHECKED_CAST")
        return when (constructorId) {
            TLGzipObject.CONSTRUCTOR_ID -> {
                unzip()
                readTLObject(expectedClazz, expectedConstructorId)
            }
            TLBool.TRUE.constructorId -> TLBool.TRUE as T
            TLBool.FALSE.constructorId -> TLBool.FALSE as T
            TLVector.CONSTRUCTOR_ID -> {
                /* Vector should be deserialized directly via the appropriate method, a vector was not expected here,
                we must assume it's not any of vector<int>, vector<long>, vector<string>.
                This is caused by vectors all sharing the same constructor id */
                readTLVector<TLObject>() as T
            }
            else -> try {
                if (clazz == null) {
                    clazz = context[constructorId]
                }

                clazz.getConstructor().newInstance().apply {
                    deserializeBody(this@TLDeserializer)
                }
            } catch (e: ReflectiveOperationException) {
                // !! Should never happen
                throw RuntimeException("Unable to deserialize data", e)
            }
        }
    }

    fun <T : TLObject> readTLMethod(): TLMethod<T> = readTLObject()

    fun <T : TLObject> readTLVector(): TLObjectVector<T> = deserializeVector(TLObjectVector())
    fun readTLIntVector(): TLIntVector = deserializeVector(TLIntVector())
    fun readTLLongVector(): TLLongVector = deserializeVector(TLLongVector())
    fun readTLStringVector(): TLStringVector = deserializeVector(TLStringVector())

    fun unzip()

    @Throws(IOException::class)
    private fun <T, V : TLVector<T>> deserializeVector(vector: V): V = readInt().let { constructorId ->
        when (constructorId) {
            TLVector.CONSTRUCTOR_ID -> deserializeVectorBody(vector)
            else -> throw InvalidConstructorIdException(constructorId, TLVector.CONSTRUCTOR_ID)
        }
    }

    @Throws(IOException::class)
    private fun <T, V : TLVector<T>> deserializeVectorBody(vector: V) = vector.apply {
        deserializeBody(this@TLDeserializer)
    }
}