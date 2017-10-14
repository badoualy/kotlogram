package com.github.badoualy.telegram.tl.exception

class RpcErrorException(val code: Int, val type: String) : Exception("$code: $type") {

    constructor(e: RpcErrorException) : this(e.code, e.type)

    override fun toString() = message.orEmpty()

    /**
     * Parse the type to extract the integer value (ex: FILE_MIGRATE_X, FLOOD_WAIT_X, ...)
     *
     * @return extracted integer value
     */
    val typeValue: Int by lazy {
        type.split('_').last().toIntOrNull() ?: 0
    }
}
