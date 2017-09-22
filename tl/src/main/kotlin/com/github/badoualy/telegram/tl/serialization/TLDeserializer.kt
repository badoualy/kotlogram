package com.github.badoualy.telegram.tl.serialization

import com.github.badoualy.telegram.tl.core.*
import kotlin.reflect.KClass

interface TLDeserializer {

    fun readByte(): Int
    fun readBytes(len: Int): ByteArray
    fun readBytes(byteArray: ByteArray, offset: Int, len: Int)
    fun readInt(): Int
    fun readUInt(): Long
    fun readLong(): Long
    fun readDouble(): Double
    fun readBool(): Boolean
    fun readString(): String

    fun readTLBytes(): TLBytes
    fun readTLBytesAsBytes() = readTLBytes().data

    @Deprecated("Remove and use overloads")
    fun <T : TLObject> readTLObject(): T

    fun <T : TLObject> readTLObject(clazz: KClass<T>, constructorId: Int): T
    fun <T : TLObject> readTLMethod(): TLMethod<T> = readTLObject()

    fun <T : TLObject> readTLVector(): TLVector<T>
    fun readTLIntVector(): TLIntVector
    fun readTLLongVector(): TLLongVector
    fun readTLStringVector(): TLStringVector

    fun readTLBool(): TLBool
}