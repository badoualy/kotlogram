package com.github.badoualy.telegram.tl.builder

import java.util.*

fun hex(value: Int) = Integer.toHexString(value)

fun String.uFirstLetter() = if (this[0].isUpperCase()) this
else this[0].toString().toUpperCase() + this.substring(1)

fun String.lFirstLetter() = if (!this[0].isUpperCase()) this
else this[0].toString().toLowerCase() + this.substring(1)

fun String.lCamelCase(): String {
    var words = divideByWords(this)
    return words.drop(1).fold(words[0].lFirstLetter(), { r, t -> r + t.uFirstLetter() });
}

fun String.uCamelCase(): String {
    var words = divideByWords(this)
    return words.fold("", { r, t -> r + t.uFirstLetter() });
}

private fun divideByWords(value: String): List<String> {
    val dividers = arrayOf('.', '_')
    var workingValue = value;
    var words = ArrayList<String>()

    outer@ while (workingValue != "") {
        for (index in 0..(workingValue.length - 1)) {
            for (div in dividers) {
                try {
                    if (workingValue[index] == div) {
                        if (index > 0) {
                            words.add(workingValue.substring(0, index));
                            workingValue = workingValue.substring(index + 1)
                        } else {
                            workingValue = workingValue.substring(1)
                        }

                        continue@outer
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            if (index > 0) {
                if (workingValue[index - 1].isLowerCase() && workingValue[index].isUpperCase()) {
                    words.add(workingValue.substring(0, index));
                    workingValue = workingValue.substring(index)

                    continue@outer
                }
            }
        }

        if (workingValue != "") {
            words.add(workingValue);
            workingValue = "";
        }
    }
    return words
}

fun String.javaEscape(): String = when (this) {
    "private", "public", "long", "assert", "final" -> "_$this"
    else -> this
}