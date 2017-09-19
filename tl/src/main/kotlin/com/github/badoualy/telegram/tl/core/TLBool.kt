package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.exception.InvalidConstructorIdException

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

import com.github.badoualy.telegram.tl.StreamUtils.readInt

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
sealed class TLBool : TLObject() {

    override fun equals(other: Any?): Boolean {
        return this === other // Singleton, 1 instance
    }

    override fun hashCode() = javaClass.hashCode()

    private object TLBoolTrue : TLBool() {
        const val CONSTRUCTOR_ID = 0x997275b5.toInt()

        override val constructorId: Int
            get() = CONSTRUCTOR_ID

        override fun toString() = "boolTrue#997275b5"
    }

    private object TLBoolFalse : TLBool() {
        const val CONSTRUCTOR_ID = 0xbc799737.toInt()

        override val constructorId: Int
            get() = CONSTRUCTOR_ID

        override fun toString() = "boolFalse#bc799737"
    }

    companion object {

        val TRUE: TLBool = TLBoolTrue
        val FALSE: TLBool = TLBoolFalse

        operator fun get(value: Boolean) = if (value) TRUE else FALSE

        @Throws(IOException::class)
        fun serialize(value: Boolean, stream: OutputStream) {
            get(value).serialize(stream)
        }

        @Throws(IOException::class)
        fun deserialize(stream: InputStream): Boolean {
            val constructorId = readInt(stream)
            if (constructorId == TLBoolTrue.CONSTRUCTOR_ID)
                return true
            if (constructorId == TLBoolFalse.CONSTRUCTOR_ID)
                return false

            throw InvalidConstructorIdException("Wrong TLBool constructor id. Found " +
                                                        Integer.toHexString(constructorId))
        }
    }

}
