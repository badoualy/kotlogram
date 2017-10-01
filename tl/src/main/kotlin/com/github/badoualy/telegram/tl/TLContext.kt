package com.github.badoualy.telegram.tl

import com.github.badoualy.telegram.tl.core.*
import com.github.badoualy.telegram.tl.exception.DeserializationException
import com.github.badoualy.telegram.tl.exception.InvalidConstructorIdException
import com.github.badoualy.telegram.tl.exception.UnsupportedConstructorException
import com.github.badoualy.telegram.tl.serialization.TLStreamDeserializer
import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.util.*
import java.util.zip.GZIPInputStream

/**
 * TypeLanguage context object. It performs deserialization of objects and vectors. All known classes might be
 * registered in context for deserialization. Often this might be performed from inherited class in registerClasses() method call.
 * If TL-Object contains static int field CONSTRUCTOR_ID, then it might be used for registration, but it uses reflection
 * so it might be slow in some cases. It recommended to manually pass CONSTRUCTOR_ID to registerClass method.
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
abstract class TLContext(size: Int = 10) {

    private var registeredClasses: HashMap<Int, Class<out TLObject>> = HashMap(size)

    init {
        registerClasses()
    }

    protected abstract fun registerClasses()

    fun isSupportedObject(tlObject: TLObject) = isSupportedObject(tlObject.constructorId)

    fun isSupportedObject(constructorId: Int) = registeredClasses.containsKey(constructorId)

    fun <T : TLObject> registerClass(constructorId: Int, clazz: Class<T>) {
        registeredClasses.put(constructorId, clazz)
    }

    @Throws(IOException::class)
    @JvmOverloads
    fun <T : TLObject> deserializeMessage(data: ByteArray, expectedClazz: Class<T>? = null, expectedConstructorId: Int = -1) =
            deserializeMessage(ByteArrayInputStream(data), expectedClazz, expectedConstructorId)

    /**
     * Deserialize a TLObject from the given input stream
     *
     * @param stream        input stream ready to by read
     * @param expectedClazz expected TLObject expectedClazz or null
     * @param expectedConstructorId expected expectedConstructorId or -1 if unknown
     * @param <T>           expected TLObject's type
     * @return the deserialized TLObject
     * @throws IOException
     */
    @Throws(DeserializationException::class, IOException::class)
    @JvmOverloads
    fun <T : TLObject> deserializeMessage(stream: InputStream, expectedClazz: Class<T>? = null, expectedConstructorId: Int = -1): T {
        var clazz = expectedClazz
        var constructorId = expectedConstructorId

        val realConstructorId = StreamUtils.readInt(stream)
        if (constructorId != -1 && realConstructorId != constructorId)
            throw InvalidConstructorIdException(realConstructorId, constructorId)

        if (constructorId == -1) {
            constructorId = realConstructorId
            clazz = null
        }

        @Suppress("UNCHECKED_CAST")
        return when (constructorId) {
            TLGzipObject.CONSTRUCTOR_ID -> deserializeMessage(unzipStream(stream))
            TLBool.TRUE.constructorId -> TLBool.TRUE as T
            TLBool.FALSE.constructorId -> TLBool.FALSE as T
            TLVector.CONSTRUCTOR_ID -> {
                /* Vector should be deserialized directly via the appropriate method, a vector was not expected here,
                we must assume it's not any of vector<int>, vector<long>, vector<string>.
                This is caused by vectors all sharing the same constructor id */
                TLObjectVector<TLObject>().deserializeBody(stream) as T
            }
            else -> try {
                if (clazz == null) {
                    clazz = registeredClasses[constructorId] as? Class<T>? ?:
                            throw UnsupportedConstructorException(constructorId)
                }

                clazz.getConstructor().newInstance().apply {
                    deserializeBody(TLStreamDeserializer(stream, this@TLContext))
                }
            } catch (e: ReflectiveOperationException) {
                // !! Should never happen
                throw RuntimeException("Unable to deserialize data", e)
            }
        }

    }

    @Throws(IOException::class)
    fun <T : TLObject> deserializeObjectVector(stream: InputStream): TLObjectVector<T> =
            deserializeVector(stream, TLObjectVector())

    @Throws(IOException::class)
    fun deserializeIntVector(stream: InputStream): TLIntVector =
            deserializeVector(stream, TLIntVector())

    @Throws(IOException::class)
    fun deserializeLongVector(stream: InputStream): TLLongVector =
            deserializeVector(stream, TLLongVector())

    @Throws(IOException::class)
    fun deserializeStringVector(stream: InputStream): TLStringVector =
            deserializeVector(stream, TLStringVector())

    @Throws(IOException::class)
    private fun <T, V : TLVector<T>> deserializeVector(stream: InputStream, vector: V): V {
        return StreamUtils.readInt(stream).let { constructorId ->
            when (constructorId) {
                TLVector.CONSTRUCTOR_ID -> vector.deserializeBody(stream)
                else -> throw InvalidConstructorIdException(constructorId, TLVector.CONSTRUCTOR_ID)
            }
        }
    }

    @Throws(IOException::class)
    private fun <T, V : TLVector<T>> V.deserializeBody(stream: InputStream) = apply {
        deserializeBody(TLStreamDeserializer(stream, this@TLContext))
    }

    @Throws(IOException::class)
    private fun unzipStream(stream: InputStream): InputStream = TLGzipObject().let {
        it.deserializeBody(TLStreamDeserializer(stream, this))
        val packedDataStream = ByteArrayInputStream(it.packedData)
        BufferedInputStream(GZIPInputStream(packedDataStream))
    }
}
