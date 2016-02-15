package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.mtproto.transport.MTProtoConnection
import com.github.badoualy.telegram.mtproto.util.Log
import rx.Observable
import rx.Subscriber
import java.io.IOException
import java.nio.channels.SelectionKey
import java.nio.channels.Selector
import java.util.*
import java.util.concurrent.Executors

/**
 * Permanently listen for messages on given MTProtoConnection and wrap everything in an Observable, each message will be send
 * to the subscriber
 */
internal object MTProtoWatchdog : Runnable {

    private val TAG = "MTProtoWatchdog"

    private val SELECT_TIMEOUT_DELAY = 10 * 1000L // 10 seconds

    private val selector = Selector.open()
    private val keyMap = HashMap<SelectionKey, MTProtoConnection>()

    private val connectionList = ArrayList<MTProtoConnection>()
    private val subscriberMap = HashMap<MTProtoConnection, Subscriber<in ByteArray>>()

    private val executor = Executors.newSingleThreadExecutor()
    private val pool = Executors.newCachedThreadPool() // TODO fixed pool?

    private var dirty = false
    private var running = false

    override fun run() {
        while (true) {
            if (dirty) {
                synchronized(this) {
                    connectionList
                            .filterNot { keyMap.containsValue(it) }
                            .forEach { keyMap.put(it.register(selector), it) }
                    dirty = false
                }
            }

            if (selector.select(SELECT_TIMEOUT_DELAY) > 0) {
                synchronized(this) {
                    selector.selectedKeys().forEach { key ->
                        key.interestOps(0)
                        val connection = keyMap[key]
                        if (connection != null) {
                            pool.execute {
                                if (!connection.isOpen())
                                    return@execute
                                //connection.setBlocking(true)
                                readMessage(connection)
                                //connection.setBlocking(false)

                                // Done reading
                                if (key.isValid) {
                                    key.interestOps(SelectionKey.OP_READ)
                                    selector.wakeup()
                                }
                            }
                        }
                    }
                }
                selector.selectedKeys().clear()
            }

            // Avoid synchronizing each loop
            if (connectionList.isEmpty()) {
                synchronized(this) {
                    if (connectionList.isEmpty()) {
                        running = false
                        Log.d(TAG, "Stopping watchdog...")
                        return
                    }
                }
            }
        }
    }

    private fun readMessage(connection: MTProtoConnection) {
        val subscriber = subscriberMap[connection]
        if (subscriber == null || subscriber.isUnsubscribed || !connectionList.contains(connection)) {
            Log.e(TAG, "Subscribed already unsubscribed, dropping")
            stop(connection)
            return
        }

        try {
            val message = connection.readMessage()
            Log.d(TAG, "New message of length: " + message.size)
            subscriber.onNext(message)
        } catch (e: IOException) {
            // Silent fail if no subscriber
            if (!subscriber.isUnsubscribed)
                subscriber.onError(e)
        }
    }

    fun start(connection: MTProtoConnection) = Observable.create<ByteArray> { s ->
        synchronized(this) {
            connectionList.add(connection)
            subscriberMap.put(connection, s)

            dirty = true
            if (!running) {
                running = true
                executor.execute(this)
            }
        }
        selector.wakeup()
    }

    fun stop(connection: MTProtoConnection) {
        synchronized(this) {
            connectionList.remove(connection)
            subscriberMap.remove(connection)?.onCompleted()
            val key = connection.unregister()
            if (key != null) keyMap.remove(key)
        }
    }

    fun cleanUp() {
        executor.shutdownNow()
        pool.shutdownNow()
    }
}