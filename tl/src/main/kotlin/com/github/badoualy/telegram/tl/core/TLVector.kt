package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
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
abstract class TLVector<T> internal constructor() : TLObject(), MutableList<T> {

    private val items = ArrayList<T>()

    override val constructorId: Int
        get() = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) {
        tlSerializer.writeInt(items.size)
        items.forEach { serializeItem(it, tlSerializer) }
    }

    @Throws(IOException::class)
    protected abstract fun serializeItem(item: T, tlSerializer: TLSerializer)

    @Throws(IOException::class)
    override final fun deserializeBody(stream: InputStream, context: TLContext) {
        val count = readInt(stream)
        for (i in 0 until count)
            items.add(deserializeItem(stream, context))
    }

    @Suppress("UNCHECKED_CAST")
    @Throws(IOException::class)
    protected abstract fun deserializeItem(stream: InputStream, context: TLContext): T

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
        const val CONSTRUCTOR_ID = 0x1cb5c415

        val EMPTY_ARRAY = TLObjectVector<TLObject>()
    }
}
