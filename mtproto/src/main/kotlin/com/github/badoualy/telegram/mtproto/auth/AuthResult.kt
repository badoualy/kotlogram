package com.github.badoualy.telegram.mtproto.auth

import com.github.badoualy.telegram.mtproto.transport.MTProtoConnection

/**
 * Result of the "Creating an Authorization Key" flow execution
 * @see <a href="https://core.telegram.org/mtproto/auth_key">Creating an Authorization Key</a>
 * */
class AuthResult(val authKey: AuthKey, val serverSalt: Long, val connection: MTProtoConnection)