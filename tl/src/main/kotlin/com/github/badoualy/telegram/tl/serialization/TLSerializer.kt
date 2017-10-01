package com.github.badoualy.telegram.tl.serialization

import com.github.badoualy.telegram.tl.core.*

/**
 * Interface describing a set of functions to serialize types of the TL Language
 */
interface TLSerializer {

    fun writeByte(b: Int)
    fun writeByte(b: Byte)
    fun writeByteArray(byteArray: ByteArray, offset: Int = 0, length: Int = byteArray.size)

    fun writeInt(v: Int) {
        writeByte(v and 0xFF)
        writeByte(v shr 8 and 0xFF)
        writeByte(v shr 16 and 0xFF)
        writeByte(v shr 24 and 0xFF)
    }

    fun writeLong(v: Long) {
        writeInt((v and 0xFFFFFFFF).toInt())
        writeInt((v shr 32 and 0xFFFFFFFF).toInt())
    }

    fun writeDouble(v: Double) {
        writeLong(java.lang.Double.doubleToRawLongBits(v))
    }

    fun writeBoolean(v: Boolean) {
        TLBool.serialize(v, this)
    }

    fun writeString(v: String) {
        writeTLBytes(v.toByteArray(Charsets.UTF_8))
    }

    fun writeTLBytes(b: ByteArray) = writeTLBytes(TLBytes(b))
    fun writeTLBytes(b: TLBytes)

    fun writeTLObject(v: TLObject) = v.serialize(this)
    fun writeTLMethod(v: TLMethod<*>) = writeTLObject(v)
    fun writeTLVector(v: TLVector<*>) = writeTLObject(v)
}