package com.github.badoualy.telegram.mtproto.util

class Log {
    companion object {

        var enabled = false

        @JvmStatic
        @JvmOverloads
        fun d(tag: String, message: String, tabCount: Int = 0) {
            if (enabled) {
                for (i in 0..tabCount - 1) print("    ")
                println("[${Thread.currentThread().name}] $tag# $message")
            }
        }

        @JvmStatic fun w(tag: String, message: String) {
            if (enabled) println("[${Thread.currentThread().name}] $tag! $message")
        }

        @JvmStatic
        @JvmOverloads
        fun e(tag: String, message: String, tabCount: Int = 0) {
            if (enabled) {
                for (i in 0..tabCount - 1) System.err.print("    ")
                System.err.println("[${Thread.currentThread().name}] $tag# $message")
            }
        }
    }
}
