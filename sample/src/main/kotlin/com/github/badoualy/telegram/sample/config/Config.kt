package com.github.badoualy.telegram.sample.config

import com.github.badoualy.telegram.api.TelegramApp
import java.io.File
import java.io.FileInputStream
import java.util.*

object Config {

    val ROOT_DIR = File("sample${File.separator}")
    private val CONFIG_FILE = "config.properties"
    val AUTH_KEY_FILE = File(ROOT_DIR, "auth.key")
    val NEAREST_DC_FILE = File(ROOT_DIR, "dc.save")

    private val properties = Properties().apply {
        load(FileInputStream(File(ROOT_DIR,
                                  CONFIG_FILE)))
    }

    val apiId = getProp("apiId", "0").toIntOrNull() ?: 0
    val apiHash = getProp("apiHash", "")

    val deviceModel = getProp("deviceModel",
                              "DeviceModel")
    val systemVersion = getProp("systemVersion",
                                "SysVer")
    val appVersion = getProp("appVersion",
                             "AppVersion")
    val langCode = getProp("langCode", "en")

    val phoneNumber = getProp("phoneNumber",
                              "+33000000000")

    val application = TelegramApp(apiId,
                                  apiHash,
                                  deviceModel,
                                  systemVersion,
                                  appVersion,
                                  langCode)

    init {
        println("Application config: ${application}")
    }

    private fun getProp(key: String, default: String) = properties.getProperty(key, default)!!
}