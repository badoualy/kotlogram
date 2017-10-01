package com.github.badoualy.telegram.mtproto.exception

open class SecurityException : MTProtoException {
    constructor()
    constructor(message: String) : super(message)
    constructor(message: String, throwable: Throwable) : super(message, throwable)
    constructor(throwable: Throwable) : super(throwable)
}
