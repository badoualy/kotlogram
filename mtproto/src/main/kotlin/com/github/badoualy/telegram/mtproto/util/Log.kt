package com.github.badoualy.telegram.mtproto.util

class Log {
    companion object {

        @JvmStatic
        @JvmOverloads
        fun d(tag: String, message: String, tabCount: Int = 0) {
            for (i in 0..tabCount - 1) print("    ")
            println(tag + "# " + message)
        }

        @JvmStatic fun w(tag: String, message: String) = println(tag + "! " + message)


        @JvmStatic
        @JvmOverloads
        fun e(tag: String, message: String, tabCount: Int = 0) {
            for (i in 0..tabCount - 1) System.err.print("    ")
            System.err.println(tag + "# " + message)
        }
    }
}
