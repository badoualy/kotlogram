package com.github.badoualy.telegram.mtproto.exception

class SecurityException : MTProtoException {
    constructor()
    constructor(s: String) : super(s)
    constructor(s: String, throwable: Throwable) : super(s, throwable)
    constructor(throwable: Throwable) : super(throwable)
}
