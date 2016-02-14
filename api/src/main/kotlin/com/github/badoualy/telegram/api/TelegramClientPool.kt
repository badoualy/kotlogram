package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.util.Log
import java.nio.channels.SelectionKey
import java.nio.channels.Selector
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.schedule

object TelegramClientPool : Runnable {

    private val TAG = "TelegramClientPool"

    private val DEFAULT_EXPIRATION_DELAY = 5L * 60L * 1000L // 5 minutes
    private val SELECT_TIMEOUT_DELAY = 10 * 1000L // 10 seconds

    private val map = HashMap<Int, TelegramClient>()
    private val expireMap = HashMap<Int, Long>()
    private val keyMap = HashMap<SelectionKey, TelegramClient>()
    private val lockMap = HashMap<TelegramClient, Lock>()

    private val selector = Selector.open()
    private var dirty = true
    private var running = false

    private val executor = Executors.newSingleThreadExecutor()
    private val threadPool = Executors.newFixedThreadPool(8)
    private val timer = Timer()

    override fun run() {
        while (true) {
            if (map.isEmpty()) {
                synchronized(this) {
                    if (map.isEmpty()) {
                        Log.d(TAG, "Stopping client pool...")
                        running = false
                        return
                    }
                }
            }

            if (dirty) {
                // Re-build selector by registering new clients
                synchronized(this) {
                    map.filterValues { !keyMap.containsValue(it) }
                            .values.forEach { keyMap.put(it.getConnection()!!.register(selector), it) }
                }
            }

            if (selector.select(SELECT_TIMEOUT_DELAY) > 0) {
                synchronized(this) {
                    selector.selectedKeys().forEach { key ->
                        key.interestOps(0) // Interested in nothing until ready
                        val client = keyMap[key]
                        if (client != null) {
                            val lock = ReentrantLock()
                            lockMap.put(client, lock)
                            threadPool.execute {
                                try {
                                    synchronized(this){
                                        if (keyMap[key] == null)
                                            return@execute
                                        lock.lock()
                                    }
                                    client.notifyReady()

                                    // Once done, interested in reading
                                    key.interestOps(SelectionKey.OP_READ)
                                    selector.wakeup()
                                } finally {
                                    lock.unlock()
                                    lockMap.remove(client)
                                }
                            }
                        }
                    }
                }
                selector.selectedKeys().clear()
            }
        }
    }

    @JvmOverloads @JvmStatic
    fun put(id: Int, client: TelegramClient, expiresIn: Long = DEFAULT_EXPIRATION_DELAY) {
        Log.d(TAG, "Adding client with id $id")
        client.stopListening()
        synchronized(this) {
            if (map.containsKey(id) && map[id] != client) {
                // Already have a client with this id, close the new one
                client.close(false)
            } else {
                map.put(id, client)
                dirty = true
            }
            expireMap.put(id, System.currentTimeMillis() + expiresIn)
        }

        timer.schedule(expiresIn, { onTimeout(id) })

        if (!running) {
            running = true
            executor.execute(this)
        }
    }

    @JvmStatic
    fun getAndRemove(id: Int): TelegramClient?{
        synchronized(this) {
            val client = map.remove(id)
            expireMap.remove(id)
            val key = client?.getConnection()!!.unregister()
            if (key != null) keyMap.remove(key)

            selector.wakeup()

            // Make sure no reading is being done
            val lock = lockMap.remove(client)
            lock?.lock()
            lock?.unlock()

            client?.startListening()
            return client
        }
    }

    @JvmStatic
    fun cleanUp() {
        synchronized(this) {
            selector.close()
            map.values.forEach { client -> client.close(false) }
        }
        executor.shutdownNow()
        threadPool.shutdownNow()
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