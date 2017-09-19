package com.github.badoualy.telegram.tl

import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject

import java.nio.charset.Charset
import kotlin.reflect.KClass

object TLObjectUtils {

    const val SIZE_INT32 = 4
    const val SIZE_CONSTRUCTOR_ID = SIZE_INT32
    const val SIZE_BOOLEAN = SIZE_CONSTRUCTOR_ID
    const val SIZE_INT64 = 8
    const val SIZE_DOUBLE = 8

    fun computeTLBytesSerializedSize(length: Int): Int {
        var size = length + if (length >= 254) 4 else 1
        val offset = size % 4
        if (offset != 0)
            size += 4 - offset // Padding
        return size
    }

    fun computeTLBytesSerializedSize(bytes: TLBytes) = computeTLBytesSerializedSize(bytes.length)

    fun computeTLStringSerializedSize(string: String) =
            computeTLBytesSerializedSize(string.toByteArray(Charset.forName("UTF-8")).size)

    /**
     * Checks if the given object is content-related (useful for seqNo generation)
     * @param clazz object type to check
     * @return true if the object is content related, else false
     */
    fun isContentRelated(clazz: Class<out TLObject>) = !clazz.simpleName.startsWith("MT", true)

    fun isContentRelated(clazz: KClass<out TLObject>) = isContentRelated(clazz.java)

    fun <T : TLObject> isContentRelated(`object`: T) = isContentRelated(`object`.javaClass)
}
