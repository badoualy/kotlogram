package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.exception.InvalidConstructorIdException
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

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
        fun serialize(value: Boolean, tlSerializer: TLSerializer) {
            get(value).serialize(tlSerializer)
        }

        @Throws(IOException::class)
        fun deserialize(tlDeserializer: TLDeserializer) = tlDeserializer.readInt().let {
            when (it) {
                TLBoolTrue.CONSTRUCTOR_ID -> true
                TLBoolFalse.CONSTRUCTOR_ID -> false
                else -> throw InvalidConstructorIdException(it,
                                                            TLBoolTrue.CONSTRUCTOR_ID,
                                                            TLBoolFalse.constructorId)
            }
        }
    }

}
