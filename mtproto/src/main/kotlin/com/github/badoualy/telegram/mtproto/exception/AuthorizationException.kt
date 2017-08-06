package com.github.badoualy.telegram.mtproto.exception

import java.io.IOException

class AuthorizationException : IOException {
    constructor()
    constructor(s: String) : super(s)
    constructor(s: String, throwable: Throwable) : super(s, throwable)
    constructor(throwable: Throwable) : super(throwable)
}
