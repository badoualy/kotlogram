package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.auth.AuthKey

interface TelegramApiStorage {

    /**
     * Save the given permanent authorization key to a persistent memory
     * @param authKey key to save
     */
    fun saveAuthKey(authKey: AuthKey)

    /**
     * Load a previously saved permanent authorization key from persistent memory
     * @return the authorization key loaded from memory, or null if no authorization key was previously saved
     */
    fun loadAuthKey(): AuthKey?

    /**
     * Delete the given permanent authorization key from persistent memory
     */
    fun deleteAuthKey()

    /**
     * Save the data center information
     * @param dataCenter nearest data center
     */
    fun saveDc(dataCenter: DataCenter)

    /**
     * Load a previously saved data center information
     * @return the nearest data center information saved, or null if nothing previously saved
     */
    fun loadDc(): DataCenter?

    /** Delete the data center information from persistent memory */
    fun deleteDc()

    /** Save the given server salt to a persistent memory */
    fun saveServerSalt(salt: Long)

    /**
     * Load a previously server salt from persistent memory
     * @return the server salt, or null if none was saved
     */
    fun loadServerSalt(): Long?
}