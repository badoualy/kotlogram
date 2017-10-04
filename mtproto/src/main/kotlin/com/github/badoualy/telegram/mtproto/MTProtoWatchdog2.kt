package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.mtproto.log.Logger
import com.github.badoualy.telegram.mtproto.net.MTProtoConnection
import com.github.badoualy.telegram.mtproto.net.SelectableConnection
import com.github.badoualy.telegram.mtproto.util.NamedThreadFactory
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.nio.channels.SelectionKey
import java.nio.channels.Selector
import java.util.concurrent.Executors

/**
 * Permanently listen for messages on given MTProtoConnection and wrap everything in an Observable,
 * every received messages will be send to the subscriber
 */
internal object MTProtoWatchdog2 : Runnable {

    private val logger = Logger(MTProtoWatchdog2::class)

    // select operation timeout
    private val SELECT_TIMEOUT_DELAY = 10 * 1000L // 10 seconds

    private val selector = Selector.open()
    private val subject: Subject<SelectionKey> = PublishSubject.create()

    private val executor = Executors.newSingleThreadExecutor(
            NamedThreadFactory(javaClass.simpleName, true))
    private val pool = Executors.newCachedThreadPool(
            NamedThreadFactory("${javaClass.simpleName}-exec"))

    private var running = false

    override fun run() {
        logger.info("Starting watchdog")
        while (running) {
            if (selector.select(SELECT_TIMEOUT_DELAY) > 0) {
                // We have key(s) ready to read
                synchronized(this) {
                    selector.selectedKeys().forEach { key ->
                        key.noOps()
                        subject.onNext(key)
                    }
                }
                selector.selectedKeys().clear()
            }

            // Check if should stop
            // Avoid synchronizing each loop
            // TODO: selectorKeys() is not thread-safe, check if isEmpty can really be called like this
            if (selector.selectedKeys().isEmpty()) {
                synchronized(this) {
                    if (selector.selectedKeys().isEmpty()) {
                        running = false
                        logger.info("Stopping watchdog")
                        return
                    }
                }
            }
        }
    }

    fun getMessageObservable(connection: MTProtoConnection) = subject
            .filter { it.attachment() === connection }
            .observeOn(Schedulers.from(pool))
            .map { key -> connection.readMessage().also { listen(key) } }
            .doOnSubscribe {
                register(connection)
                runIfNeeded()
            }
            .doOnError { cancelByTag(connection) }
            .doOnDispose { cancelByTag(connection) }
            .observeOn(Schedulers.computation())

    fun shutdown() {
        logger.warn("==================== SHUTTING DOWN WATCHDOG ====================")
        subject.onComplete()
        executor.shutdownNow()
        pool.shutdownNow()
    }

    private fun runIfNeeded() {
        synchronized(this) {
            if (!running) {
                running = true
                executor.execute(this)
            }
        }
    }

    private fun register(connection: SelectableConnection): SelectionKey {
        var key: SelectionKey
        synchronized(this) {
            key = connection.register(selector, SelectionKey.OP_READ).apply {
                attach(connection)
            }
            selector.wakeup()
            return key
        }
    }

    private fun listen(key: SelectionKey) {
        synchronized(this) {
            key.readOp()
            selector.wakeup()
        }
    }

    private fun cancelByTag(connection: SelectableConnection) = selector.keys().firstOrNull {
        it.attachment() === connection
    }?.let { cancel(it) }

    private fun cancel(key: SelectionKey) {
        synchronized(this) {
            key.attach(null)
            key.cancel()
            selector.wakeup()
        }
    }

    private fun SelectionKey.noOps() = interestOps(0)

    private fun SelectionKey.readOp() = interestOps(SelectionKey.OP_READ)
}