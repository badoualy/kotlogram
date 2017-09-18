package com.github.badoualy.telegram.tl

import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import rx.Single

interface RpcQueryExecutor {
    fun <T : TLObject> executeRpcQuery(method: TLMethod<T>): Single<T>
}

interface RpcQuerySyncExecutor {
    fun <T : TLObject> executeRpcQuerySync(method: TLMethod<T>): T
}