package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.utils.DumpUtils
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLStreamDeserializer

import org.testng.Assert
import org.testng.ITest
import org.testng.annotations.Factory
import org.testng.annotations.Test

import java.io.ByteArrayInputStream

/**
 * Unit test to generate random TLObject for each type, and serialize then deserialize it and check if still equals.
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
class TLApiTest private constructor(private val clazz: Class<out TLObject>) : AbsTLApiTest(), ITest {

    @Test
    @Throws(Exception::class)
    fun <T : TLObject> runTest() {
        val tlObject = getRandomTLObject(clazz as Class<TLObject>) as T

        val serializedSize = tlObject.computeSerializedSize()
        val bytes = tlObject.serialize()
        Assert.assertEquals(serializedSize, bytes.size,
                            "Serialized size is different from computed size")

        val deserializedObject = newInstanceOf(clazz)
        val inputStream = ByteArrayInputStream(bytes)
        deserializedObject.deserialize(TLStreamDeserializer(inputStream,
                                                            TLApiTestContext))
        Assert.assertEquals(inputStream.available(), 0,
                            "Deserialization did not consume whole payload of ${bytes.size} bytes")
        Assert.assertEquals(DumpUtils.toJson(deserializedObject),
                            DumpUtils.toJson(tlObject),
                            "Deserialization of serialized object returned an object non-equals")

        DumpUtils.dump(tlObject, bytes)
    }

    override fun getTestName() = clazz.canonicalName.removePrefix(AbsTLApiTest.BASE_PACKAGE + ".")

    /**
     * Serialize and deserialize each TL types and check equality
     */
    class TLApiTestFactory {

        @Factory
        fun generateTestSuite(): Array<Any> = AbsTLApiTest.constructorList.map { TLApiTest(it) }.toTypedArray()
    }
}
