package com.github.badoualy.telegram.api

import org.slf4j.LoggerFactory
import java.util.*
import kotlin.concurrent.schedule

/**
 * Util class to cache clients some time before closing them to be able to re-use them if it's likely that
 * they'll be used again soon
 */
object TelegramClientPool {

    private val logger = LoggerFactory.getLogger(TelegramClientPool::class.java)

    private val DEFAULT_EXPIRATION_DELAY = 5L * 60L * 1000L // 5 minutes

    private val map = HashMap<Long, TelegramClient>()
    private val listenerMap = HashMap<Long, OnClientTimeoutListener>()
    private val expireMap = HashMap<Long, Long>()

    private var timer = Timer()

    /**
     * Cache the given client for a fixed amount of time before closing it if not used during that time
     *
     * @param id id associated with the client (used in {@link getAndRemove}
     * @param client client to keep open
     * @param expiresIn time before expiration (in ms)
     */
    @JvmOverloads @JvmStatic
    fun put(id: Long, client: TelegramClient, listener: OnClientTimeoutListener?, expiresIn: Long = DEFAULT_EXPIRATION_DELAY) {
        logger.debug("Adding client with id $id")
        synchronized(this) {
            // Already have a client with this id, close the new one and reset timer
            expireMap.put(id, System.currentTimeMillis() + expiresIn)

            if (listener != null)
                listenerMap.put(id, listener)
            else listenerMap.remove(id)

            if (map.containsKey(id) && map[id] != client)
                client.close(false)
            else {
                map.put(id, client)
                Unit // Fix warning...
            }
        }

        try {
            timer.schedule(expiresIn, { onTimeout(id) })
        } catch (e: IllegalStateException) {
            timer = Timer()
            timer.schedule(expiresIn, { onTimeout(id) })
        }
    }

    /**
     * Retrieve a previously cached client associated with the id
     * @param id id used to cache the client
     * @return cached client, or null if no client cached for the given id
     */
    @JvmStatic
    fun getAndRemove(id: Long): TelegramClient? {
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
    fun onTimeout(id: Long) {
        val timeout =
                synchronized(this) {
                    if (expireMap.getOrDefault(id, 0) <= System.currentTimeMillis()) {
                        logger.info("$id client timeout")
                        val client = getAndRemove(id)
                        if (client != null) {
                            client.close(false)
                            true
                        } else false
                    } else false
                }
        if (timeout)
            listenerMap.remove(id)?.onClientTimeout(id)

    }
}

interface OnClientTimeoutListener {
    fun onClientTimeout(id: Long)
}