package com.github.badoualy.telegram.mtproto.log

import java.text.SimpleDateFormat
import java.util.*

class ConsoleLogger(val name: String) {

    private val simpleDateFormat = SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM)

    fun trace(message: String) = trace(null, message)

    fun trace(tag: LogTag?, message: String) {
        log("trace", tag, message)
    }

    fun debug(message: String) = debug(null, message)

    fun debug(tag: LogTag?, message: String) {
        log("debug", tag, message)
    }

    fun info(message: String) = info(null, message)

    fun info(tag: LogTag?, message: String) {
        log("info", tag, message)
    }

    fun warn(message: String) = warn(null, message)

    fun warn(tag: LogTag?, message: String) = warn(tag, message, null)

    fun warn(tag: LogTag?, message: String, throwable: Throwable?) {
        log("warn", tag, message, throwable)
    }

    fun error(message: String) = error(null, message)

    fun error(tag: LogTag?, message: String) = error(tag, message, null)

    fun error(tag: LogTag?, message: String, throwable: Throwable?) {
        log("error", tag, message, throwable)
    }

    private fun log(level: String, tag: LogTag?, message: String, exception: Throwable? = null) {
        val date = simpleDateFormat.format(Date())
        val logContent = "$date - [${Thread.currentThread().name}] ${level.toUpperCase()} $name - ${tag?.marker?.name ?: ""} - $message"
        if (level.equals("error", true))
            System.err.println(logContent)
        else
            println(logContent)

        exception?.printStackTrace()
    }
}