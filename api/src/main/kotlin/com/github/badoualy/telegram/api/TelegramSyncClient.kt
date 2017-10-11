package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.tl.api.TelegramSyncApiWrapper
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException

/**
 * A Telegram client to make synchronous rpc calls.
 */
abstract class TelegramSyncClient : TelegramSyncApiWrapper() {
    // TODO: add convenience methods
}

/**
 * A [TelegramSyncClient] implementation that'll delegate the request execution to a [TelegramClient]
 * and transform the calls to a synchronous behavior using
 * [io.reactivex.Single.blockingGet] or [io.reactivex.Observable.blockingIterable]
 */
internal class TelegramSyncClientImpl(val client: TelegramClient) : TelegramSyncClient() {
    override fun <T : TLObject> executeRpcQuerySync(method: TLMethod<T>): T = try {
        client.executeRpcQuery(method).blockingGet()
    } catch (e: RuntimeException) {
        if (e.cause is RpcErrorException)
            throw e.cause as RpcErrorException
        throw e
    }
}