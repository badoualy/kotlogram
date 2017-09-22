package com.github.badoualy.telegram.tl.api

fun main(args: Array<String>) {
    val b = 255.toByte()
    println(b)
    println(b.toInt())
    println(b.toInt().and(0xFF))
}