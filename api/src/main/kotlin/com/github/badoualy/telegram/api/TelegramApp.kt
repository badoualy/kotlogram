package com.github.badoualy.telegram.api

/** Info about the application created on Telegram's console and using this API */
data class TelegramApp(val apiId: Int, val apiHash: String,
                       val deviceModel: String, val systemVersion: String, val appVersion: String,
                       val systemLangCode: String,
                       /** DO NOT USE YET */
                       val langPack: String = "",
                       val langCode: String)