package com.github.badoualy.telegram.api

import org.slf4j.LoggerFactory
import org.slf4j.MarkerFactory
import java.util.*
import kotlin.concurrent.schedule

/**
 * Util class to cache clients some time before closing them to be able to re-use them if it's likely that
 * they'll be used again soon
 */
class TelegramClientPool private constructor(name: String) {

    private val marker = MarkerFactory.getMarker(name)

    private val DEFAULT_EXPIRATION_DELAY = 5L * 60L * 1000L // 5 minutes

    private var timer = Timer("Timer-${TelegramClientPool::class.java.simpleName}-$name")
    private val map = HashMap<Long, TelegramClient>()
    private val listenerMap = HashMap<Long, OnClientTimeoutListener>()
    private val expireMap = HashMap<Long, Long>()

    /**
     * Cache the given client for a fixed amount of time before closing it if not used during that time
     *
     * @param id id associated with the client (used in {@link getAndRemove}
     * @param client client to keep open
     * @param expiresIn time before expiration (in ms)
     */
    @JvmOverloads
    fun put(id: Long, client: TelegramClient, listener: OnClientTimeoutListener?, expiresIn: Long = DEFAULT_EXPIRATION_DELAY) {
        logger.debug(marker, "Adding client with id $id")
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
            timer = Timer("${javaClass.simpleName}")
            timer.schedule(expiresIn, { onTimeout(id) })
        }
    }

    /**
     * Retrieve a previously cached client associated with the id
     * @param id id used to cache the client
     * @return cached client, or null if no client cached for the given id
     */
    fun peek(id: Long): TelegramClient? {
        synchronized(this) {
            return map[id]
        }
    }

    /**
     * Retrieve a previously cached client associated with the id and remove it from this pool
     * @param id id used to cache the client
     * @return cached client, or null if no client cached for the given id
     */
    fun getAndRemove(id: Long): TelegramClient? {
        synchronized(this) {
            expireMap.remove(id)
            return map.remove(id)
        }
    }

    fun onTimeout(id: Long) {
        val timeout =
                synchronized(this) {
                    if (expireMap.getOrDefault(id, 0) <= System.currentTimeMillis()) {
                        val client = getAndRemove(id)
                        if (client != null) {
                            logger.info(marker, "$id client timeout")
                            client.close(false)
                            true
                        } else false
                    } else false
                }
        if (timeout)
            listenerMap.remove(id)?.onClientTimeout(id)
    }

    fun shutdown() {
        timer.cancel()
    }

    fun getKeys() = map.keys

    fun getClients() = map.values

    companion object {
        private val logger = LoggerFactory.getLogger(TelegramClientPool::class.java)

        @JvmField
        val DEFAULT_POOL = TelegramClientPool("DefaultPool")

        @JvmField
        val DOWNLOADER_POOL = TelegramClientPool("DownloaderPool")
    }
}

interface OnClientTimeoutListener {
    fun onClientTimeout(id: Long)
}