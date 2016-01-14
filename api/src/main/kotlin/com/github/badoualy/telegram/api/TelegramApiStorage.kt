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
     * Save the nearest data center information
     * @param dataCenter nearest data center
     */
    fun saveNearestDc(dataCenter: DataCenter)

    /**
     * Load a previously saved nearest data center information
     * @return the nearest data center information saved, or null if nothing previously saved
     */
    fun loadNearestDc(): DataCenter?

    /**
     * Delete the given nearest data center information from persistent memory
     */
    fun deleteNearestDc()

    /**
     * Save the given server salts to a persistent memory
     * @param salts all known valid server salts
     */
    //fun saveServerSalts(salts: Array<MTFutureSalt>)

    /**
     * Save the given server salts to a persistent memory
     * @return all previously saved server salts (whether they are valid or not), or empty array of none previously saved
     */
    //fun saveServerSalts(salts: LongArray): Array<MTFutureSalt>
}