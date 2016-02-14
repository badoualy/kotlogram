package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.mtproto.transport.MTProtoConnection
import com.github.badoualy.telegram.mtproto.util.Log
import rx.Observable
import rx.Subscriber
import java.io.IOException
import java.nio.channels.Selector

/**
 * Permanently listen for messages on given MTProtoConnection and wrap everything in an Observable, each message will be send
 * to the subscriber
 */
class MTProtoWatchdog(private val connection: MTProtoConnection) {

    private val TAG = "MTProtoWatchdog"
    private var subscriber: Subscriber<in ByteArray>? = null
    private var closed = false

    fun start() = Observable.create<ByteArray> observable@ { s ->
        Log.d(TAG, "Starting watchdog...")
        subscriber = s
        val selector = Selector.open()
        connection.register(selector)

        while (!s.isUnsubscribed && selector.isOpen) {
            if (selector.select() == 0) continue // Wait until ready to read
            if (closed) continue

            try {
                val message = connection.readMessage()
                Log.d(TAG, "New message of length: " + message.size)

                if (s.isUnsubscribed) {
                    Log.e(TAG, "Subscribed already unsubscribed, dropping message and stopping watchdog")
                    continue
                }
                s.onNext(message)
            } catch (e: IOException) {
                // Silent fail if no subscriber
                if (!closed && !s.isUnsubscribed)
                    s.onError(e)
                continue
            }

            selector.selectedKeys().clear()
        }

        if (!s.isUnsubscribed) {
            s.onCompleted()
            s.unsubscribe()
        }
        if (selector.isOpen) selector.close()
        Log.d(TAG, "Watchdog really stopped")
    }

    fun stop() {
        Log.d(TAG, "Stopping watchdog...")
        closed = true
        subscriber?.onCompleted()
        subscriber?.unsubscribe()
        subscriber = null
        connection.unregister()
    }
}