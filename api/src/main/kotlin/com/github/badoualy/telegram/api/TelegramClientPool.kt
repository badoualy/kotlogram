package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.util.Log
import java.util.*
import kotlin.concurrent.schedule

/**
 * Util class to cache clients some time before closing them to be able to re-use them if it's likely that
 * they'll be used again soon
 */
object TelegramClientPool {

    private val TAG = "TelegramClientPool"

    private val DEFAULT_EXPIRATION_DELAY = 5L * 60L * 1000L // 5 minutes

    private val map = HashMap<Int, TelegramClient>()
    private val expireMap = HashMap<Int, Long>()

    private val timer = Timer()

    /**
     * Cache the given client for a fixed amount of time before closing it if not used during that time
     *
     * @param id id associated with the client (used in {@link getAndRemove}
     * @param client client to keep open
     * @param expiresIn time before expiration (in ms)
     */
    @JvmOverloads @JvmStatic
    fun put(id: Int, client: TelegramClient, expiresIn: Long = DEFAULT_EXPIRATION_DELAY) {
        Log.d(TAG, "Adding client with id $id")
        synchronized(this) {
            // Already have a client with this id, close the new one and reset timer
            expireMap.put(id, System.currentTimeMillis() + expiresIn)
            if (map.containsKey(id) && map[id] != client)
                client.close(false)
            else {
                map.put(id, client)
                Unit // Fix warning...
            }
        }

        timer.schedule(expiresIn, { onTimeout(id) })
    }

    /**
     * Retrieve a previously cached client associated with the id
     * @param id id used to cache the client
     * @return cached client, or null if no client cached for the given id
     */
    @JvmStatic
    fun getAndRemove(id: Int): TelegramClient? {
        synchronized(this) {
            expireMap.remove(id)
            return map.remove(id)
        }
    }

    /** Clean up the threads used */
    @JvmStatic
    fun cleanUp() {
        timer.cancel()
    }

    @JvmStatic
    fun onTimeout(id: Int) {
        synchronized(this) {
            if (expireMap.getOrDefault(id, 0) <= System.currentTimeMillis()) {
                Log.d(TAG, "$id client timeout")
                getAndRemove(id)?.close(false)
            }
        }
    }
}