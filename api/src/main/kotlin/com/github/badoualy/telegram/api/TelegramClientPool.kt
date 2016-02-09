package com.github.badoualy.telegram.api

import java.util.*
import kotlin.concurrent.schedule

object TelegramClientPool {

    private val DEFAULT_EXPIRATION_DELAY = 5L * 60L * 1000L // 5 minutes

    private val map = HashMap<Int, TelegramClient>()
    private val expireMap = HashMap<Int, Long>()

    private var timer: Timer? = null

    @JvmOverloads @JvmStatic
    fun put(id: Int, client: TelegramClient, expiresIn: Long = DEFAULT_EXPIRATION_DELAY) {
        synchronized(this) {
            if (map.containsKey(id) && map[id] != client)
                throw IllegalStateException("A client with the id $id already exists")
            map.put(id, client)
            expireMap.put(id, System.currentTimeMillis() + expiresIn)
        }

        if (timer == null)
            timer = Timer()

        timer!!.schedule(expiresIn, { onTimeout(id) })
        //        Observable.timer(expiresIn, TimeUnit.MILLISECONDS)
        //                .doOnNext { onTimeout(id) }.subscribe()
    }

    @JvmStatic
    fun getAndRemove(id: Int): TelegramClient?{
        synchronized(this) {
            return map.remove(id)
        }
    }

    @JvmStatic
    fun cleanUp() {
        synchronized(this) {
            map.values.forEach { client -> client.close(false) }
        }
        timer?.cancel()
        timer = null
    }

    @JvmStatic
    fun onTimeout(id: Int) {
        synchronized(this) {
            if (expireMap.getOrDefault(id, 0) <= System.currentTimeMillis()) {
                expireMap.remove(id)
                map.remove(id)?.close(false)
            }
        }
    }
}