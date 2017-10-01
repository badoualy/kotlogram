package com.github.badoualy.telegram.tl.serialization

import com.github.badoualy.telegram.tl.core.*
import kotlin.reflect.KClass

// TODO: javadoc
interface TLDeserializer {

    fun available(): Int

    fun readByte(): Int
    fun readBytes(len: Int) = readBytes(ByteArray(len), 0, len)
    fun readBytes(buffer: ByteArray, offset: Int, len: Int): ByteArray

    fun readInt(): Int
    fun readUInt(): Long
    fun readLong(): Long
    fun readDouble(): Double
    fun readBoolean(): Boolean
    fun readString(): String

    fun readTLBytes(): TLBytes
    fun readTLBytesAsBytes() = readTLBytes().data

    fun <T : TLObject> readTLObject(): T
    fun <T : TLObject> readTLObject(clazz: KClass<T>, constructorId: Int): T
    fun <T : TLObject> readTLMethod(): TLMethod<T> = readTLObject()

    fun <T : TLObject> readTLVector(): TLObjectVector<T>
    fun readTLIntVector(): TLIntVector
    fun readTLLongVector(): TLLongVector
    fun readTLStringVector(): TLStringVector
}