package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.mtproto.transport.MTProtoConnection
import com.github.badoualy.telegram.mtproto.util.Log
import rx.Subscriber
import rx.lang.kotlin.observable
import java.io.IOException

/**
 * Permanently listen for messages on given MTProtoConnection and wrap everything in an Obersable, each message will be send
 * to the subscriber
 */
class MTProtoWatchdog(private val connection: MTProtoConnection) {

    private val TAG = "MTProtoWatchdog"
    private var subscriber: Subscriber<in ByteArray>? = null

    fun start() = observable<ByteArray> { s ->
        Log.d(TAG, "Starting watchdog...")
        subscriber = s
        while (!s.isUnsubscribed) {
            try {
                val message = connection.readMessage()
                Log.d(TAG, "New message of length: " + message.size)

                if (s.isUnsubscribed) {
                    Log.e(TAG, "Subscribed already unsubscribed, dropping message and stopping watchdog")
                    return@observable
                }
                s.onNext(message)
            } catch (e: IOException) {
                if (!s.isUnsubscribed)
                    s.onError(e)
                return@observable
            }
        }
    }

    fun stop() {
        Log.d(TAG, "Stopping watchdog...")
        subscriber?.unsubscribe()
    }
}