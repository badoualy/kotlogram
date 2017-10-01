package com.github.badoualy.telegram.tl.serialization

import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLVector

interface TLSerializer {

    fun writeByte(b: Int)
    fun writeByte(b: Byte)
    fun writeByteArray(byteArray: ByteArray, offset: Int = 0, length: Int = byteArray.size)

    fun writeInt(v: Int)
    fun writeLong(v: Long)
    fun writeDouble(v: Double)
    fun writeBoolean(v: Boolean)
    fun writeString(v: String)

    fun writeTLBytes(b: ByteArray) = writeTLBytes(TLBytes(b))
    fun writeTLBytes(b: TLBytes)

    fun writeTLObject(v: TLObject) = v.serialize(this)
    fun writeTLMethod(v: TLMethod<*>) = writeTLObject(v)
    fun writeTLVector(v: TLVector<*>) = writeTLObject(v)
}