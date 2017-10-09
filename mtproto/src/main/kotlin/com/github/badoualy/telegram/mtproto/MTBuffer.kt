package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.log.Logger
import io.reactivex.Observable
import io.reactivex.rxkotlin.toMaybe
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.util.concurrent.TimeUnit

class MTBuffer<T>(var bufferSize: Int,
                  var bufferTimeout: Long, var bufferTimeoutUnit: TimeUnit,
                  var tag: LogTag? = null) {

    private val logger = Logger(MTBuffer::class)

    private var bufferId = 0
    private var list = ArrayList<T>(bufferSize)

    private val subject: Subject<List<T>> = PublishSubject.create()
    val observable: Observable<List<T>>
        get() = subject.hide()
                .doOnNext { logger.trace(tag, "doOnNext ${it.joinToString()}") }

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
                list.size < bufferSize -> return
                else -> {
                    newBuffer()
                    flush = true
                }
            }
        }

        if (startTimer) {
            Observable.just(id)
                    .delay(bufferTimeout, bufferTimeoutUnit)
                    .observeOn(Schedulers.computation())
                    .flatMapMaybe { get(it).takeIf { it.isNotEmpty() }.toMaybe() }
                    .subscribe(subject)
        }

        if (flush) {
            logger.info(tag, "Flushing buffer $bufferId")
            subject.onNext(list)
        }
    }

    fun get() = get(bufferId)

    fun reset() = synchronized(list) {
        list = ArrayList(bufferSize)
        bufferId = 0
    }

    private fun newBuffer() = synchronized(list) {
        list = ArrayList(bufferSize)
        bufferId++
    }

    private operator fun get(id: Int): List<T> {
        var list: List<T> = emptyList()

        synchronized(this.list) {
            if (id != bufferId) {
                // Already flushed
                return emptyList()
            }

            list = this.list
            newBuffer()
        }

        return list
    }
}