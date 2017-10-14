package com.github.badoualy.telegram.mtproto.rx

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.rxkotlin.zipWith

fun <T, U> Single<T>.flatZip(other: (T) -> SingleSource<U>): Single<Pair<T, U>> = flatMap {
    Single.just(it).zipWith(other.invoke(it))
}