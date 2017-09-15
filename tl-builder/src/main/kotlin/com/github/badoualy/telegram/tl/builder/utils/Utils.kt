package com.github.badoualy.telegram.tl.builder.utils

import java.util.*

fun Int.hexString() = Integer.toHexString(this)

fun String.uFirstLetter() = this[0].toString().toUpperCase() + substring(1)

fun String.lFirstLetter() = this[0].toString().toLowerCase() + substring(1)

fun String.javaEscape(): String = when (this) {
    "private", "public", "protected", "long", "assert", "final" -> "_$this"
    else -> this
}

fun String.lCamelCase() = uCamelCase().lFirstLetter()

fun String.uCamelCase() = divideByWords().fold("", { r, t -> r + t.uFirstLetter() })

private fun String.divideByWords(): List<String> {
    val dividers = arrayOf('.', '_')
    val words = ArrayList<String>()

    var buffer = this

    outer@ while (buffer != "") {
        for (index in 0..(buffer.length - 1)) {
            for (div in dividers) {
                // Std split
                try {
                    if (buffer[index] == div) {
                        buffer = if (index > 0) {
                            words.add(buffer.substring(0, index))
                            buffer.substring(index + 1)
                        } else {
                            buffer.substring(1)
                        }

                        continue@outer
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            // Split on lowercase followed by uppercase
            if (index > 0) {
                if (buffer[index - 1].isLowerCase() && buffer[index].isUpperCase()) {
                    words.add(buffer.substring(0, index))
                    buffer = buffer.substring(index)

                    continue@outer
                }
            }
        }

        // If anything left in buffer
        if (buffer != "") {
            words.add(buffer)
            buffer = ""
        }
    }

    return words
}
