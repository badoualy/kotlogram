package com.github.badoualy.telegram.mtproto.rx

import rx.Observable
import rx.Scheduler
import rx.Subscriber
import rx.observers.SerializedSubscriber
import rx.subscriptions.SerialSubscription
import rx.subscriptions.Subscriptions
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Add a timeout feature to an observable, starting when <b>the first item was added</b>. The existing timeout() just flush the buffer if no
 * elements are added in a given amount of time.
 */
class OperatorBufferTimeout<T>(val timeout: Long, val unit: TimeUnit,
                               val scheduler: Scheduler, val maxSize: Int,
                               val shouldFlush: (T) -> Boolean = { true },
                               val shouldAdd: (T) -> Boolean = { true }) : Observable.Operator<List<T>, T> {

    override fun call(t: Subscriber<in List<T>>): Subscriber<in T> {
        val parent = BufferSubscriber(SerializedSubscriber(t),
                                      timeout, unit,
                                      scheduler.createWorker(), maxSize, shouldFlush, shouldAdd)
        t.add(parent)
        return parent
    }

    private class BufferSubscriber<T>(val actual: Subscriber<in List<T>>,
                                      val timeout: Long, val unit: TimeUnit,
                                      val w: Scheduler.Worker, val maxSize: Int,
                                      val shouldFlush: (T) -> Boolean = { true },
                                      val shouldAdd: (T) -> Boolean = { true }) : Subscriber<T>() {

        val timer: SerialSubscription
        var buffer: MutableList<T>
        var index: Long = 0 // Run index

        init {
            this.buffer = ArrayList<T>()
            this.timer = SerialSubscription()
            this.add(timer)
            this.add(w)
        }

        override fun onNext(t: T) {
            var b: MutableList<T>? = null
            var startTimer = false
            var emit = false
            var idx: Long = 0

            synchronized(this) {
                b = buffer
                if (shouldAdd(t))
                    b!!.add(t)
                idx = index

                if (shouldFlush(t)) {
                    buffer = ArrayList<T>()
                    index = ++idx
                    emit = true
                } else {
                    val n = b!!.size
                    if (n == 1) {
                        startTimer = true
                    } else if (n < maxSize) {
                        return
                    } else {
                        buffer = ArrayList<T>()
                        index = ++idx
                        emit = true
                    }
                }
            }

            if (startTimer)
                timer.set(w.schedule({ timeout(idx) }, timeout, unit))

            if (emit) {
                timer.set(Subscriptions.unsubscribed())
                actual.onNext(b)
            }
        }

        override fun onError(e: Throwable) {
            actual.onError(e)
        }

        override fun onCompleted() {
            timer.unsubscribe()

            var b: List<T>? = null
            synchronized(this) {
                b = buffer
                buffer = ArrayList<T>()
                index++
            }
            if (!b!!.isEmpty())
                actual.onNext(b)

            actual.onCompleted()
        }

        fun timeout(idx: Long) {
            var b: List<T>? = null
            synchronized(this) {
                if (idx != index) {
                    // Buffer was full or pushed before it timed out
                    return
                }
                b = buffer
                buffer = ArrayList<T>()
                index = idx + 1
            }

            actual.onNext(b)
        }
    }
}