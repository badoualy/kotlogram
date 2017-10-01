package com.github.badoualy.telegram.mtproto.exception

import java.io.IOException

class AuthorizationException : IOException {
    constructor()
    constructor(message: String) : super(message)
    constructor(message: String, throwable: Throwable) : super(message, throwable)
    constructor(throwable: Throwable) : super(throwable)
}
