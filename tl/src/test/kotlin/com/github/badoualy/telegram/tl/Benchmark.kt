package com.github.badoualy.telegram.tl

import com.github.badoualy.telegram.tl.api.TLApiTestContext
import com.github.badoualy.telegram.tl.utils.DumpUtils
import org.apache.commons.codec.DecoderException
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException
import java.nio.charset.Charset

object Benchmark {

    private val TEST_COUNT = 10000

    @Throws(IOException::class, DecoderException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val files = DumpUtils.loadAll("tl/" + DumpUtils.dumpDir)
        val context = TLApiTestContext
        val builder = StringBuilder()
        var totalTimeSerialize: Long = 0
        var totalTimeDeserialize: Long = 0
        var totalTimeComplete: Long = 0
        val totalTestCount = files.size * TEST_COUNT

        for (file in files) {
            val serialized = DumpUtils.load(file)
            // Deserialize and check if json is identical
            val tlObject = context.deserializeMessage(serialized)
            builder.append("Starting benchmark for constructor: $tlObject \n")

            var start = System.nanoTime()
            for (i in 0 until TEST_COUNT)
                tlObject.serialize()
            var duration = System.nanoTime() - start
            totalTimeSerialize += duration
            builder.append(String.format("\tSerialized %d times in %d µs",
                                         TEST_COUNT,
                                         duration / 1000)).append('\n')

            start = System.nanoTime()
            for (i in 0 until TEST_COUNT)
                context.deserializeMessage(serialized)
            duration = System.nanoTime() - start
            totalTimeDeserialize += duration
            builder.append(String.format("\tDeserialized %d times in %d µs",
                                         TEST_COUNT,
                                         duration / 1000)).append('\n')

            start = System.nanoTime()
            for (i in 0 until TEST_COUNT)
                context.deserializeMessage(tlObject.serialize())
            duration = System.nanoTime() - start
            totalTimeComplete += duration
            builder.append(String.format("\tSerialized then deserialized %d times in %d µs",
                                         TEST_COUNT,
                                         duration / 1000)).append('\n')
        }

        val file = File("./result.txt")
        println("Write results to " + file.absolutePath)
        FileUtils.writeStringToFile(file, builder.toString(), Charset.forName("UTF-8"))

        var averageSerialize = totalTimeSerialize.toDouble() / totalTestCount
        var averageDeserialize = totalTimeDeserialize.toDouble() / totalTestCount
        var averageComplete = totalTimeComplete.toDouble() / totalTestCount
        averageSerialize /= 1000.0
        averageDeserialize /= 1000.0
        averageComplete /= 1000.0

        println("Final results: ")
        println("\tSerialize $totalTestCount objects in average (ms) $averageSerialize")
        println("\tDeserialized $totalTestCount objects in average (ms) $averageDeserialize")
        println("\tSerialize and Deserialized $totalTestCount objects in average (ms) $averageComplete")
    }
}
