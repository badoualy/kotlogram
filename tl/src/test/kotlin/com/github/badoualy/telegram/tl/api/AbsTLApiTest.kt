package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLStringVector
import com.github.badoualy.telegram.tl.core.TLVector

import org.apache.commons.lang3.RandomStringUtils
import org.reflections.Reflections
import org.reflections.util.ClasspathHelper

import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.net.URL
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.Random

abstract class AbsTLApiTest {

    fun <T : TLObject> randomize(`object`: T): T {
        val clazz = `object`.javaClass

        // Get class + superclass fields
        val fields = ArrayList<Field>()
        Collections.addAll(fields, *clazz.declaredFields)
        if (clazz.superclass != TLObject::class.java) {
            Collections.addAll(fields, *clazz.superclass.declaredFields)
        }

        for (field in fields) {
            if (field.name.equals("flags", ignoreCase = true)) {
                continue
            }
            if (field.modifiers and Modifier.TRANSIENT != 0) {
                continue
            }
            if (field.modifiers and Modifier.STATIC != 0) {
                continue
            }
            if (field.modifiers and Modifier.FINAL != 0) {
                continue
            }

            field.isAccessible = true
            try {
                field.set(`object`, getRandom(field.type, field))
            } catch (e: Exception) {
                throw RuntimeException(e)
            }

        }

        return `object`
    }

    @Throws(Exception::class)
    fun <T : TLObject> newInstanceOf(clazz: Class<T>): T {
        for (c in clazz.constructors) {
            if (c.parameterTypes.isEmpty()) {
                c.isAccessible = true
                return c.newInstance() as T
            }
        }

        throw RuntimeException("No constructor found for type " + clazz.simpleName)
    }

    @Throws(Exception::class)
    fun getRandomTLObject(clazz: Class<TLObject>): TLObject {
        if (clazz == TLBool.FALSE.javaClass) return TLBool.FALSE
        if (clazz == TLBool.TRUE.javaClass) return TLBool.TRUE

        val `object` = newInstanceOf(clazz)
        randomize(`object`)

        return `object`
    }

    @Throws(Exception::class)
    fun <T> getRandomTLVector(clazz: Class<T>): TLVector<T> {
        val obj: TLVector<T>
        if (`is`(clazz, Int::class.java)) {
            obj = TLIntVector() as TLVector<T>
        } else if (`is`(clazz, Long::class.java)) {
            obj = TLLongVector() as TLVector<T>
        } else if (`is`(clazz, String::class.java)) {
            obj = TLStringVector() as TLVector<T>
        } else {
            obj = TLObjectVector<TLObject>() as TLVector<T>
        }

        val size = random.nextInt(3)
        for (i in 0 until size) {
            obj.add(getRandom(clazz, null))
        }

        return obj
    }

    @Throws(Exception::class)
    fun <T> getRandom(type: Class<T>, field: Field?): T {
        var type = type
        // Base types
        if (`is`(type, Int::class.javaPrimitiveType!!, Int::class.java, java.lang.Integer::class.java)) {
            return Integer.valueOf(random.nextInt()) as T
        }
        if (`is`(type, Long::class.javaPrimitiveType!!, Long::class.java, java.lang.Long::class.java)) {
            return java.lang.Long.valueOf(random.nextLong()) as T
        }
        if (`is`(type, Float::class.javaPrimitiveType!!, Float::class.java, java.lang.Float::class.java)) {
            return java.lang.Float.valueOf(random.nextFloat()) as T
        }
        if (`is`(type, Double::class.javaPrimitiveType!!, Double::class.java, java.lang.Double::class.java)) {
            return java.lang.Double.valueOf(random.nextDouble()) as T
        }
        if (`is`(type, Boolean::class.javaPrimitiveType!!, Boolean::class.java, java.lang.Boolean::class.java)) {
            return java.lang.Boolean.valueOf(random.nextBoolean()) as T
        }
        if (`is`(type, String::class.java)) {
            return RandomStringUtils.random(random.nextInt(25) + 5, true, true) as T
        }
        if (`is`(type, TLBytes::class.java)) {
            val bytes = ByteArray(random.nextInt(256))
            random.nextBytes(bytes)
            return TLBytes(bytes) as T
        }

        // Vector
        if (`is`(type, TLIntVector::class.java)) {
            return getRandomTLVector(Int::class.java) as T
        }
        if (`is`(type, TLLongVector::class.java)) {
            return getRandomTLVector(Long::class.java) as T
        }
        if (`is`(type, TLStringVector::class.java)) {
            return getRandomTLVector(String::class.java) as T
        }
        if (`is`(type, TLObjectVector::class.java)) {
            val genericType = field!!.genericType as ParameterizedType
            val vectorType = genericType.actualTypeArguments[0]
            return getRandomTLVector(vectorType as Class<*>) as T
        }

        // TLObject
        if (TLObject::class.java.isAssignableFrom(type)) {
            if (type.modifiers and Modifier.ABSTRACT != 0) {
                // Abstract, not a real constructor, get a random one
                val subtypes = reflections.getSubTypesOf(type)
                val randomIndex = random.nextInt(subtypes.size)
                type = subtypes.toTypedArray()[randomIndex] as Class<T>
            }

            return getRandomTLObject(type as Class<TLObject>) as T
        }

        throw RuntimeException("Unsupported type " + type.name)
    }

    fun `is`(type: Class<*>, vararg types: Class<*>) = types.contains(type)

    private class PositiveRandom(seed: Long) : Random(seed) {

        override fun nextInt(): Int {
            return super.next(Integer.MAX_VALUE - 1)
        }

        override fun nextLong(): Long {
            return super.next(Integer.MAX_VALUE - 1).toLong()
        }

        override fun nextDouble(): Double {
            return java.lang.Double.longBitsToDouble(nextLong())
        }

        override fun nextFloat(): Float {
            return nextDouble().toFloat()
        }
    }

    companion object {

        val BASE_PACKAGE = "com.github.badoualy.telegram.tl.api"

        var constructorList: MutableList<Class<out TLObject>>
        var random: Random = PositiveRandom(System.currentTimeMillis())
        var reflections: Reflections

        init {

            println("Looking for tl api classes in package " + BASE_PACKAGE)
            val urls = ArrayList<URL>()
            urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE))
            urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".account"))
            urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".auth"))
            urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".channels"))
            urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".contacts"))
            urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".help"))
            urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".messages"))
            urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".photos"))
            urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".request"))
            urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".storage"))
            urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".updates"))
            urls.addAll(ClasspathHelper.forPackage(BASE_PACKAGE + ".upload"))
            reflections = Reflections(urls)

            val classList = reflections.getSubTypesOf(TLObject::class.java)
            println("Found " + classList.size + " classes")
            constructorList = ArrayList()

            classList
                    .filter {
                        it.modifiers and Modifier.ABSTRACT == 0 &&
                                !it.`package`.name.equals("com.github.badoualy.telegram.tl.core",
                                                          ignoreCase = true)
                    }
                    .toCollection(constructorList)
            Collections.sort(constructorList) { o1, o2 -> o1.simpleName.compareTo(o2.simpleName) }

            println("Found " + constructorList.size + " non abstract classes")
        }
    }
}
