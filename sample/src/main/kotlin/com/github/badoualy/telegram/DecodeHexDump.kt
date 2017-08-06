package com.github.badoualy.telegram

import com.github.badoualy.telegram.tl.api.TLApiContext
import com.google.gson.GsonBuilder
import org.apache.commons.codec.DecoderException
import org.apache.commons.codec.binary.Hex
import java.io.File
import java.io.IOException

object DecodeHexDump {

    private val gson = GsonBuilder().setPrettyPrinting().serializeNulls().create()

    @Throws(IOException::class, DecoderException::class)
    @JvmStatic fun main(args: Array<String>) {
        if (args.size != 1) {
            System.err.println("Usage: java -jar tl-decoder.jar <input>")
            System.exit(-1)
        }
        val file = File(args[0])
        println("Using input ${file.absolutePath}")

        val payload = Hex(Charsets.UTF_8).decode(file.readText()) as ByteArray
        val tlObject = TLApiContext.getInstance().deserializeMessage(payload)

        println("Found ${tlObject.javaClass.canonicalName}\n\n")
        println(gson.toJson(tlObject))
    }
}
