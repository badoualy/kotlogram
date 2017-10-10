package com.github.badoualy.telegram.mtproto.auth


import com.github.badoualy.telegram.mtproto.MTProtoHandler
import java.io.IOException
import java.util.*


/**
 * Helper class to execute the "Bind a temporary authorization key" flow
 * @see [bindTempAuthKey](https://core.telegram.org/method/auth.bindTempAuthKey)
 */
object TempAuthKeyBinding {

    private val TAG = "TempAuthKeyBinding"

    /**
     * Binds a temporary authorization key temp_auth_key_id to the permanent authorization key perm_auth_key_id.
     * Each permanent key may only be bound to one temporary key at a time, binding a new temporary key overwrites the previous one.
     * @param tempAuthKey temporary key to be bound
     * *
     * @param authKey permanent key
     * *
     * @param mtProtoHandler current handler using the temporary auth key
     * *
     * @return true if the key was bound, false else
     */
    @Throws(IOException::class)
    @JvmStatic
    fun bindKey(tempAuthKey: TempAuthKey, authKey: AuthKey, mtProtoHandler: MTProtoHandler): Boolean {
        if (!Arrays.equals(mtProtoHandler.authKey.keyId, tempAuthKey.keyId))
            throw IllegalStateException("The MTProtoHandler must use the temporary authorization key that you want to bind")

        return false
    }
}
