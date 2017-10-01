package com.github.badoualy.telegram.tl.exception

class RpcErrorException(val code: Int, val tag: String) : Exception("$code: $tag") {

    override fun toString() = message.orEmpty()

    /**
     * Parse the tag to extract the integer value at the end (ex: FILE_MIGRATE_X, FLOOD_WAIT_X, ...)
     *
     * @return extracted integer value
     */
    val tagInteger: Int
        get() {
            val chunks = tag.split("_".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return Integer.parseInt(chunks[chunks.size - 1])
        }
}
