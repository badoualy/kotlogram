package com.github.badoualy.telegram.mtproto.log

import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

class Logger private constructor(val name: String) {

    private val delegate = LoggerFactory.getLogger(name)!!

    fun trace(message: String) = trace(null, message)

    fun trace(tag: LogTag?, message: String) {
        when {
            tag != null -> delegate.trace(tag.marker, message)
            else -> delegate.trace(message)
        }
    }

    fun debug(message: String) = debug(null, message)

    fun debug(tag: LogTag?, message: String) {
        when {
            tag != null -> delegate.debug(tag.marker, message)
            else -> delegate.debug(message)
        }
    }

    fun info(message: String) = info(null, message)

    fun info(tag: LogTag?, message: String) {
        when {
            tag != null -> delegate.info(tag.marker, message)
            else -> delegate.info(message)
        }
    }

    fun warn(message: String) = warn(null, message)

    fun warn(tag: LogTag?, message: String) = warn(tag, message, null)

    fun warn(tag: LogTag?, message: String, throwable: Throwable?) {
        when {
            tag != null && throwable != null -> delegate.warn(tag.marker, message, throwable)
            tag != null -> delegate.warn(tag.marker, message)
            else -> delegate.warn(message)
        }
    }

    fun error(message: String) = error(null, message)

    fun error(tag: LogTag?, message: String) = error(tag, message, null)

    fun error(tag: LogTag?, message: String, throwable: Throwable?) {
        when {
            tag != null && throwable != null -> delegate.error(tag.marker, message, throwable)
            tag != null -> delegate.error(tag.marker, message)
            else -> delegate.error(message)
        }
    }

    companion object Factory {
        fun create(name: String) = ConsoleLogger(name)
        fun create(clazz: KClass<*>) = ConsoleLogger(clazz.java.simpleName)
    }
}