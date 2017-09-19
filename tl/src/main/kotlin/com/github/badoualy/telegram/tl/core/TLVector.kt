package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.*

/**
 * Basic vector type in TL language
 * For working with primitive internal types you might instantiate class TLIntVector, TLStringVector, TLLongVector for
 * vector of integer, strings or long.
 *
 * @param <T> type of elements in vector
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
open class TLVector<T> : TLObject, MutableList<T> {

    protected val itemClazz: Class<*>
    protected val items = ArrayList<T>()

    override val constructorId: Int
        get() = CONSTRUCTOR_ID

    constructor() {
        itemClazz = TLObject::class.java
    }

    constructor(destClass: Class<T>?) {
        itemClazz =
                if (destClass != null) {
                    if (destClass != Int::class.java && destClass != Long::class.java
                            && destClass != String::class.java
                            && !TLObject::class.java.isAssignableFrom(destClass)) {
                        throw RuntimeException("Unsupported vector type: " + destClass.simpleName)
                    }
                    destClass
                } else {
                    TLObject::class.java
                }
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeInt(items.size, stream)
        items.forEach { serializeItem(it, stream) }
    }

    @Throws(IOException::class)
    protected open fun serializeItem(item: T, stream: OutputStream) {
        writeTLObject(item as TLObject, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        val count = readInt(stream)
        for (i in 0 until count)
            items.add(deserializeItem(stream, context))
    }

    @Suppress("UNCHECKED_CAST")
    @Throws(IOException::class)
    protected open fun deserializeItem(stream: InputStream, context: TLContext): T =
            context.deserializeMessage(stream) as T

    override fun computeSerializedSize() = SIZE_CONSTRUCTOR_ID + SIZE_INT32 +
            items.sumBy { (it as TLObject).computeSerializedSize() }

    override fun toString() = "vector#1cb5c415"

    ////////////////////////////////////////////////////////////
    ///////////////////////// DELEGATE /////////////////////////
    ////////////////////////////////////////////////////////////

    override val size: Int
        get() = items.size

    override fun contains(element: T) = items.contains(element)
    override fun containsAll(elements: Collection<T>) = items.containsAll(elements)
    override fun get(index: Int) = items[index]
    override fun indexOf(element: T) = items.indexOf(element)
    override fun isEmpty() = items.isEmpty()
    override fun iterator() = items.iterator()
    override fun lastIndexOf(element: T) = items.lastIndexOf(element)
    override fun add(element: T) = items.add(element)
    override fun add(index: Int, element: T) = items.add(index, element)
    override fun addAll(index: Int, elements: Collection<T>) = items.addAll(index, elements)
    override fun addAll(elements: Collection<T>) = items.addAll(elements)
    override fun clear() = items.clear()
    override fun listIterator() = items.listIterator()
    override fun listIterator(index: Int) = items.listIterator(index)
    override fun remove(element: T) = items.remove(element)
    override fun removeAll(elements: Collection<T>) = items.removeAll(elements)
    override fun removeAt(index: Int) = items.removeAt(index)
    override fun retainAll(elements: Collection<T>) = items.retainAll(elements)
    override fun set(index: Int, element: T) = items.set(index, element)
    override fun subList(fromIndex: Int, toIndex: Int) = items.subList(fromIndex, toIndex)

    companion object {
        val EMPTY_ARRAY = TLVector<TLObject>()

        const val CONSTRUCTOR_ID = 0x1cb5c415
    }
}
