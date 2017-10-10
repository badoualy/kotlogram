package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.mtproto.log.Logger
import com.github.badoualy.telegram.mtproto.net.MTProtoSelectableConnection
import com.github.badoualy.telegram.mtproto.util.NamedThreadFactory
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.nio.channels.SelectionKey
import java.nio.channels.Selector
import java.util.concurrent.Executors

/**
 * Permanently listen for messages on registered connections and wrap everything in an Observable,
 * every received messages will be send to the subscribers.
 * If no connections are registered, the thread will stop itself
 * (but still be usable, and restart itself when a new connection is registered).
 * */
internal object MTProtoWatchdog : Runnable {

    private val logger = Logger(MTProtoWatchdog::class)

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
        logger.trace("Starting watchdog")
        while (running) {
            if (selector.select(SELECT_TIMEOUT_DELAY) > 0) {
                logger.trace("select() returned with results")
                // We have key(s) ready to read
                synchronized(this) {
                    selector.selectedKeys().forEach { key ->
                        key.noOps()
                        subject.onNext(key)
                    }
                }
                selector.selectedKeys().clear()
            }
            logger.trace("select() returned with nothing")

            // Check if should stop
            // Avoid synchronizing each loop
            // TODO: selectorKeys() is not thread-safe, check if isEmpty can really be called like this
            if (selector.selectedKeys().isEmpty()) {
                synchronized(this) {
                    if (selector.selectedKeys().isEmpty()) {
                        running = false
                        logger.trace("Stopping watchdog")
                        return
                    }
                }
            }
        }
    }

    fun getMessageObservable(connection: MTProtoSelectableConnection) = subject
            .filter { it.attachment() === connection }
            .observeOn(Schedulers.from(pool))
            .map { key -> connection.readMessage().also { listen(key) } }
            .doOnSubscribe {
                // TODO: ensure first subscribe only?
                logger.info(connection.tag, "onSubscribe")
                register(connection)
                runOrWakeup()
            }
            .doOnError {
                logger.error(connection.tag, "onError: cancel selectionKey")
                cancelByTag(connection)
            }
            .doOnDispose {
                logger.debug(connection.tag, "onDispose: cancel selectionKey")
                cancelByTag(connection)
            }
            .observeOn(Schedulers.computation())!! // Ensure pool private usage

    fun shutdown() {
        logger.warn("==================== SHUTTING DOWN WATCHDOG ====================")
        subject.onComplete()
        executor.shutdownNow()
        pool.shutdownNow()
    }

    private fun runOrWakeup() {
        synchronized(this) {
            if (!running) {
                running = true
                executor.execute(this)
            } else {
                selector.wakeup()
            }
        }
    }

    private fun register(connection: MTProtoSelectableConnection): SelectionKey {
        var key: SelectionKey
        synchronized(this) {
            key = connection.register(selector, SelectionKey.OP_READ).apply {
                attach(connection)
            }
            logger.debug("has ${selector.keys().size} keys")
            return key
        }
    }

    private fun listen(key: SelectionKey) {
        synchronized(this) {
            key.readOp()
            runOrWakeup()
        }
    }

    private fun cancelByTag(connection: MTProtoSelectableConnection) = selector.keys().firstOrNull {
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

    private fun MTProtoSelectableConnection.register(selector: Selector, ops: Int): SelectionKey {
        channel.configureBlocking(false)
        return channel.register(selector, ops)!!
    }
}