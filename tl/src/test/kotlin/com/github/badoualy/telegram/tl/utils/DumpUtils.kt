package com.github.badoualy.telegram.tl.utils

import com.github.badoualy.telegram.tl.StreamUtils
import com.github.badoualy.telegram.tl.api.AbsTLApiTest
import com.github.badoualy.telegram.tl.core.TLObject
import com.google.gson.GsonBuilder

import org.apache.commons.codec.DecoderException
import org.apache.commons.codec.binary.Hex
import org.apache.commons.io.FileUtils
import org.apache.commons.io.HexDump

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.nio.charset.Charset

object DumpUtils {

    val dumpDir = "./src/test/resources/dump/"
    private val gson = GsonBuilder().setPrettyPrinting().serializeNulls().create()

    @JvmOverloads
    @JvmStatic
    fun loadAll(path: String = dumpDir): Collection<File> =
            if (File(path).exists()) {
                FileUtils.listFiles(File(path),
                                    arrayOf("dump"),
                                    true)
            } else emptyList()

    @Throws(IOException::class, DecoderException::class)
    fun load(file: File) = Hex(Charsets.UTF_8).decode(FileUtils.readFileToString(file,
                                                                                 Charsets.UTF_8)) as ByteArray

    @Throws(IOException::class, DecoderException::class)
    fun loadJson(file: File) = FileUtils.readFileToString(File(file.absolutePath.replace(".dump",
                                                                                         ".json")),
                                                          Charsets.UTF_8)!!

    fun <T : TLObject> dump(`object`: T, serialized: ByteArray) {
        try {
            val path = getFilePath(`object`.javaClass)
            FileUtils.writeStringToFile(File(dumpDir + path + ".json"),
                                        toJson(`object`),
                                        Charset.forName("UTF-8"))
            FileUtils.writeStringToFile(File(dumpDir + path + ".dump"),
                                        StreamUtils.toHexString(serialized),
                                        Charset.forName("UTF-8"))
            HexDump.dump(serialized,
                         0,
                         FileOutputStream(dumpDir + path + ".dump2"),
                         0) // More friendly dump
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun <T : TLObject> toJson(tlObject: T) = gson.toJson(tlObject)!!

    private fun getFilePath(clazz: Class<*>): String {
        var fileName = clazz.simpleName
        val packageName = clazz.`package`.name
        val folder = packageName
                .replace(AbsTLApiTest.BASE_PACKAGE, "")
                .replace(".", "").trim()
        if (!folder.isEmpty())
            fileName = folder + File.separatorChar + fileName
        return fileName
    }
}
