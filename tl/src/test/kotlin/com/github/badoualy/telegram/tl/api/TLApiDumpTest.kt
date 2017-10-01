package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLStreamDeserializer
import com.github.badoualy.telegram.tl.utils.DumpUtils
import org.apache.commons.codec.DecoderException
import org.apache.commons.io.FilenameUtils
import org.testng.Assert
import org.testng.ITest
import org.testng.annotations.Factory
import org.testng.annotations.Test
import java.io.File
import java.io.IOException

/**
 * Unit test that will read all dump and try to de-serialize then re-serialize then, checking each time if the content
 * and the bytes are equals
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
class TLApiDumpTest private constructor(private val file: File) : ITest {

    @Test
    @Throws(IOException::class, DecoderException::class)
    fun runTest() {
        val dumpSerialization = DumpUtils.load(file)
        val dumpJson = DumpUtils.loadJson(file)

        // Deserialize and check if json is identical
        val tlDeserializer = TLStreamDeserializer(dumpSerialization,
                                                  TLApiTestContext)
        val tlObject = tlDeserializer.readTLObject<TLObject>()
        val json = DumpUtils.toJson(tlObject)
        Assert.assertEquals(json, dumpJson, file.name)

        // Re-serialize and check bytes
        val serialized = tlObject.serialize()
        Assert.assertEquals(serialized, dumpSerialization, file.name)
    }

    override fun getTestName() = FilenameUtils.removeExtension(file.name)!!

    /**
     * Deserialize each previously dumped TL types and ensure that the result is correct
     */
    class TestFactory {

        @Factory
        @Throws(IOException::class, DecoderException::class)
        fun generateTestSuite(): Array<Any> = DumpUtils.loadAll().map { TLApiDumpTest(it) }.toTypedArray()
    }
}
