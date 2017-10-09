package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.log.Logger
import com.github.badoualy.telegram.mtproto.time.MTProtoTimer
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.util.*
import java.util.concurrent.TimeUnit

class MTBuffer<T>(var tag: LogTag? = null) {

    private var list = ArrayList<T>(ACK_BUFFER_SIZE)

    private var timeoutTask: TimerTask? = null
    private var bufferId = 0

    private val subject: Subject<List<T>> = PublishSubject.create()
    val observable: Observable<List<T>>
        get() = subject.hide()

    fun newBuffer(cancelTask: Boolean) = synchronized(list) {
        list = ArrayList(ACK_BUFFER_SIZE)
        bufferId++
        if (cancelTask) {
            timeoutTask?.cancel()
            timeoutTask = null
        }
    }

    fun add(item: T) {
        var flush = false
        var startTimer = false
        var list: List<T> = emptyList()
        var id: Int = -1

        synchronized(this.list) {
            this.list.add(item)
            list = this.list
            id = bufferId
            logger.trace(tag, "Adding msgId $item to bufferId $bufferId")

            when {
                list.size == 1 -> startTimer = true
                list.size < ACK_BUFFER_SIZE -> return
                else -> {
                    newBuffer(true)
                    flush = true
                }
            }
        }

        if (startTimer) {
            try {
                timeoutTask = MTProtoTimer.schedule(ACK_BUFFER_TIMEOUT,
                                                    { onBufferTimeout(id) })
            } catch (e: IllegalStateException) {
                // TODO: remove Timer use
                // Timer already cancelled.
            }
        }

        if (flush) {
            logger.info(tag, "Flushing buffer $bufferId")
            flushBuffer(list)
        }
    }

    fun get(): List<T> {
        var list: List<T> = emptyList()

        synchronized(this.list) {
            if (this.list.isNotEmpty()) {
                list = this.list
                newBuffer(true)
            }
        }

        return list
    }

    fun dispose() {
        subject.onComplete()
    }

    private fun onBufferTimeout(id: Int) {
        var list: List<T> = emptyList()

        synchronized(this.list) {
            if (id != bufferId) {
                // Already flushed
                return
            }

            list = this.list
            newBuffer(false)
            timeoutTask = null
        }

        flushBuffer(list)
    }

    private fun flushBuffer(list: List<T>) {
        if (list.isNotEmpty())
            subject.onNext(list)
    }

    companion object {
        private val logger = Logger(MTBuffer::class)

        private const val ACK_BUFFER_SIZE = 30
        private val ACK_BUFFER_TIMEOUT: Long = TimeUnit.SECONDS.toMillis(5)
    }
}

fun main(args: Array<String>) {
    val mtBuffer = MTBuffer<Long>()

    mtBuffer.observable
            .observeOn(Schedulers.computation())
            .subscribe { println("Next: " + it.joinToString()) }

    for (i in 0..50)
        mtBuffer.add(i.toLong())

    Thread.sleep(10 * 1000)
    println("Done sleeping")
}