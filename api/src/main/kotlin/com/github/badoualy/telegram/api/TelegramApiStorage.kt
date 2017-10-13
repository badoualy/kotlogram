package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.TempAuthKey
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.model.MTSession

interface TelegramApiStorage {

    /** Permanent authorization key */
    var authKey: AuthKey?

    /** Temp authorization key */
    var tempAuthKey: TempAuthKey?

    /** [DataCenter] on which the auth key is linked */
    var dataCenter: DataCenter?

    /** Last used session */
    var session: MTSession?
}

class ReadOnlyApiStorage(private val delegate: TelegramApiStorage) : TelegramApiStorage {
    override var authKey: AuthKey?
        get() = delegate.authKey
        set(value) {}
    override var tempAuthKey: TempAuthKey?
        get() = delegate.tempAuthKey
        set(value) {
        }
    override var dataCenter: DataCenter?
        get() = delegate.dataCenter
        set(value) {}
    override var session: MTSession?
        get() = null
        set(value) {}
}