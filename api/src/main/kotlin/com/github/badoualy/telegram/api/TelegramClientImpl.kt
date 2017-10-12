package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.api.utils.InputFileLocation
import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.auth.*
import com.github.badoualy.telegram.mtproto.exception.SecurityException
import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.log.Logger
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.model.MTSession
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLNearestDc
import com.github.badoualy.telegram.tl.api.request.*
import com.github.badoualy.telegram.tl.api.upload.TLFile
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toMaybe
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import java.io.OutputStream
import java.lang.Math.ceil
import java.util.concurrent.TimeUnit

class TelegramClientImpl internal constructor(override val app: TelegramApp,
                                              val apiStorage: TelegramApiStorage,
                                              val preferredDataCenter: DataCenter,
                                              tag: String) : TelegramClient() {

    private var mtProtoHandler: MTProtoHandler? = null
    private var authKey: AuthKey? = null
    private var dataCenter: DataCenter = preferredDataCenter
    override var closed: Boolean = false

    private val authKeyMap = HashMap<Int, AuthKey>()
    private val exportedHandlerMap = HashMap<Int, MTProtoHandler>()
    private val exportedHandlerTimeoutMap = HashMap<Int, Long>()

    override var timeout: Long = TimeUnit.SECONDS.toMillis(5)
    override var exportedClientTimeout: Long = TimeUnit.MINUTES.toMillis(1)
    override var requestRetryCount: Int = DEFAULT_RETRY_COUNT
        set(value) {
            field = maxOf(0, value)
        }

    private var generateAuthKey: Boolean = false

    override var tag = LogTag(tag)

    val updatesObservable: Observable<TLAbsUpdates>
        get() = mtProtoHandler!!.updatesObservable

    init {
        init()
    }

    // TODO: move to RX
    override fun init() {
        logger.trace(tag, "init()")
        authKey = apiStorage.loadAuthKey()
        var dataCenter = apiStorage.loadDc()
        generateAuthKey = authKey == null

        if (dataCenter == null) {
            if (!generateAuthKey) {
                logger.error(tag, "Found an auth key in storage but no dc")
                apiStorage.deleteAuthKey()
                apiStorage.saveSession(null)
            }
            logger.warn(tag, "No dc found in storage, preferred: $preferredDataCenter")
            dataCenter = preferredDataCenter
        }
        this.dataCenter = dataCenter

        // No need to check DC if we have an authKey in storage
        init(checkNearestDc = generateAuthKey)
        logger.info(tag, "Client ready")
    }

    // TODO: move to RX
    private fun init(checkNearestDc: Boolean) {
        logger.trace(tag, "init(): $checkNearestDc")
        mtProtoHandler = executeSync {
            (if (generateAuthKey) {
                dataCenter.let { dataCenter ->
                    createAuthKey(dataCenter)
                            .observeOn(Schedulers.io())
                            .doOnSuccess { authResult ->
                                // Save to storage
                                authKey = authResult.authKey
                                apiStorage.saveAuthKey(authKey!!)
                                apiStorage.saveDc(dataCenter)
                            }
                            .flatMap { createHandler(it) }
                }
            } else {
                createHandler(dataCenter, authKey!!, apiStorage.loadSession())
            }).observeOn(Schedulers.io())
                    .subscribeOn(Schedulers.io())
                    .doOnSuccess { it.start() }
        }

        try {
            // Call to initConnection to setup information about this app for the user to see in "active sessions"
            // Also will indicate to Telegram which layer to use through InvokeWithLayer
            // Re-call every time to ensure connection is alive and to update layer
            when {
                checkNearestDc -> ensureNearestDc(initConnection(TLRequestHelpGetNearestDc(),
                                                                 mtProtoHandler!!))
                !generateAuthKey -> try {
                    // authKey already existed, user is probably connected, resume and start update
                    // TODO: replace with getDifference for updates
                    initConnection(TLRequestUpdatesGetState(), mtProtoHandler!!)
                    return
                } catch (e: RpcErrorException) {
                    when (e.code) {
                        401 -> logger.warn(tag, "Had auth key but user not signed in: ${e.message}")
                        else -> throw e
                    }
                }
                else -> initConnection(TLRequestHelpGetNearestDc(), mtProtoHandler!!)
            }
        } catch (e: Exception) {
            mtProtoHandler?.close()
            if (e is RpcErrorException && e.code == -404)
                throw SecurityException("Authorization key is invalid (error $e)")
            throw e
        }
    }

    override fun <T : TLObject> executeRpcQuery(method: TLMethod<T>): Single<T> =
            executeMethod(method, mtProtoHandler!!)

    override fun <T : TLObject> executeMethod(method: TLMethod<T>, dcId: Int): Single<T> =
            if (dcId == dataCenter.id) {
                executeRpcQuery(method)
            } else {
                getExportedHandler(dcId)
                        .flatMap { handler ->
                            executeMethod(method, handler)
                                    .doFinally(releaseExportedHandler(handler, dcId))
                        }
            }

    private fun <T : TLObject> executeMethod(method: TLMethod<T>, mtProtoHandler: MTProtoHandler): Single<T> =
            executeMethods(listOf(method), mtProtoHandler).singleOrError()

    override fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>): Observable<T> =
            executeMethods(methods, mtProtoHandler!!)

    override fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>, dcId: Int): Observable<T> =
            if (dcId == dataCenter.id) {
                executeMethods(methods)
            } else {
                getExportedHandler(dcId)
                        .flatMapObservable { handler ->
                            logger.error("executeMethods on new exported dc--------")
                            executeMethods(methods, handler)
                                    .doFinally(releaseExportedHandler(handler, dcId))
                        }
            }

    private fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>, mtProtoHandler: MTProtoHandler): Observable<T> =
            Thread.currentThread().stackTrace.drop(1).let { stackTrace ->
                mtProtoHandler.executeMethods(methods)
                        .timeout(timeout, TimeUnit.MILLISECONDS)
                        .retryWhen {
                            it.zipWith(Observable.range(1, requestRetryCount)) { err, i ->
                                Pair(err, i)
                            }.flatMap(retryIfNeeded(mtProtoHandler))
                        }
                        .onErrorResumeNext(resumeIfNeeded(methods))
                        .doOnError { (it as? RpcErrorException)?.stackTrace = stackTrace.toTypedArray() }
            }

    private fun releaseExportedHandler(handler: MTProtoHandler, dcId: Int): () -> Unit = {
        var closeHandler = false
        synchronized(exportedHandlerMap) {
            if (exportedHandlerMap.contains(dcId)) {
                closeHandler = true
            } else {
                exportedHandlerMap.put(dcId, handler)
            }
            exportedHandlerTimeoutMap.put(dcId, System.currentTimeMillis() + exportedClientTimeout)
        }
        if (closeHandler)
            handler.close()

        Single.timer(exportedClientTimeout, TimeUnit.MILLISECONDS)
                .subscribeBy(onSuccess = { onExportedHandlerTimeout(dcId) })
    }

    private fun retryIfNeeded(mtProtoHandler: MTProtoHandler): (Pair<Throwable, Int>) -> Observable<*> = { (error, i) ->
        logger.warn(tag,
                    "method(s) failed at attempt $i (${error.javaClass.simpleName}): ${error.message}")
        when (error) {
            is RpcErrorException -> {
                when (error.code) {
                    303 -> { // DC error
                        val dcId = error.tagInteger
                        when {
                            error.tag.startsWithAny("PHONE_MIGRATE_", "NETWORK_MIGRATE_") -> {
                                logger.info(tag, "Repeat request after migration on DC$dcId")
                                migrate(dcId).toSingleDefault(Unit)
                            }
                            else -> Single.error(error)
                        }
                    }
                    else -> Single.error(error)
                }
            }
            else -> Single.fromCallable {
                logger.error(tag, "Attempting MTProtoHandler reset")
                mtProtoHandler.resetConnection()
            }.delay(i.toLong(), TimeUnit.SECONDS)
        }.subscribeOn(Schedulers.io()).toObservable()
    }

    val partSize = 128 * 1024

    override fun downloadFile(inputFileLocation: InputFileLocation, size: Int, outputStream: OutputStream) {
        val partCount = ceil(size.toDouble() / partSize).toInt()
        println("Has $partCount part")
        (0 until partCount)
                .map { it * partSize }
                .map { TLRequestUploadGetFile(inputFileLocation.inputFileLocation, it, partSize) }
                .withIndex()
                .groupBy({ it.index % 5 }, { it.value })
                .map { executeMethods(it.value, inputFileLocation.dcId).blockingIterable() }
                .flatMap { it }
                //.flatMap { it.value }
                //.sortedBy { it.offset }
                .map { it as TLFile }
                .forEach { outputStream.write(it.bytes.data) }

        outputStream.flush()
        outputStream.close()
    }

    override fun sync(): TelegramSyncClient = TelegramSyncClientImpl(this)

    override fun close() {
        try {
            exportedHandlerMap.values.forEach { it.close() }
            mtProtoHandler?.close()
        } catch (e: Exception) {
        }
        closed = true
        mtProtoHandler?.session?.let { apiStorage.saveSession(it) }
    }

    // TODO: move to RX
    private fun <T : TLObject> initConnection(method: TLMethod<T>, mtProtoHandler: MTProtoHandler): T {
        logger.debug(tag, "Init connection with $method")
        val initConnectionRequest = with(app) {
            TLRequestInitConnection(apiId,
                                    deviceModel,
                                    systemVersion, appVersion,
                                    systemLangCode, langPack, langCode,
                                    method)
        }

        val request = TLRequestInvokeWithLayer(Kotlogram.API_LAYER, initConnectionRequest)
        return executeSync { executeMethod(request, mtProtoHandler) }
    }

    // TODO: move to RX
    private fun ensureNearestDc(nearestDc: TLNearestDc) {
        logger.trace(tag, "ensureNearestDc()")
        if (nearestDc.thisDc != nearestDc.nearestDc) {
            logger.warn(tag,
                        "Current DC${nearestDc.thisDc} is not the nearest (DC${nearestDc.nearestDc})")
            migrate(nearestDc.nearestDc).subscribe()
        } else {
            logger.debug(tag, "Connected to the nearest DC${nearestDc.thisDc}")
        }
    }

    private fun migrate(dcId: Int) = Completable.fromAction {
        logger.info(tag, "Migrating to DC$dcId")
        mtProtoHandler?.close()
        authKey = null
        dataCenter = Kotlogram.getDcById(dcId)
        apiStorage.deleteAuthKey()
        apiStorage.deleteDc()
        apiStorage.saveSession(null)
        generateAuthKey = true

        init(checkNearestDc = false)
    }

    /**
     * [Maybe.switchIfEmpty] is buggy with kotlin, have to use this syntax
     * Use [Single.defer] to avoid creating unnecessary objects
     */
    private fun getExportedHandler(dcId: Int): Single<MTProtoHandler> =
            Maybe.fromCallable<MTProtoHandler> {
                logger.trace(tag, "getExportedHandler(DC$dcId)")

                var cachedHandler: MTProtoHandler? = null
                synchronized(exportedHandlerMap) {
                    cachedHandler = exportedHandlerMap.remove(dcId)
                }

                cachedHandler?.apply { logger.debug(tag, "Using cached handler") }
            }.switchIfEmpty(Single.defer {
                // No cached handler, check for existing key
                authKeyMap[dcId].toMaybe()
                        .flatMap { createExportedHandler(dcId, it).toMaybe() }
                        // If nothing, create a new exported handler
                        .switchIfEmpty(Single.defer { createExportedHandler(dcId) })
            })

    private fun createExportedHandler(dcId: Int, key: AuthKey): Single<MTProtoHandler> =
            createHandler(Kotlogram.getDcById(dcId), key, null)
                    .doOnSubscribe {
                        logger.debug(tag, "Using existing exported auth key on DC$dcId")
                    }
                    .doAfterSuccess { it.start() }
                    .doAfterSuccess { initConnection(TLRequestHelpGetNearestDc(), it) }

    private fun createExportedHandler(dcId: Int): Single<MTProtoHandler> =
            authExportAuthorization(dcId)
                    .doOnSubscribe { logger.debug(tag, "Creating new handler on DC$dcId") }
                    .map { TLRequestAuthImportAuthorization(it.id, it.bytes) }
                    .doOnSuccess { logger.error("GATE 1 -------------------------------------") }
                    .zipWith(createAuthKey(Kotlogram.getDcById(dcId))
                                     .flatMap { createHandler(it) }
                                     .doOnSuccess { it.start() }
                                     .doOnSuccess {
                                         logger.error(
                                                 "GATE 2 -------------------------------------")
                                     })
                    .doOnSuccess { logger.error("GATE 3 -------------------------------------") }
                    .doOnSuccess { (request, handler) -> initConnection(request, handler) }
                    .doOnSuccess { (_, handler) -> authKeyMap.put(dcId, handler.authKey) }
                    .map { (_, handler) -> handler }
                    .doOnSuccess { logger.error("GATE END -------------------------------------") }

    private fun <T : TLObject> resumeIfNeeded(methods: List<TLMethod<T>>): (Throwable) -> Observable<T> = { error ->
        when (error) {
            is RpcErrorException -> when {
                error.code == 303 && error.tag.startsWith("FILE_MIGRATE_") -> {
                    getExportedHandler(error.tagInteger)
                            .flatMapObservable { executeMethods(methods, it) }
                }
                else -> Observable.error(error)
            }
            else -> Observable.error(error)
        }
    }

    private fun onExportedHandlerTimeout(dcId: Int) {
        synchronized(exportedHandlerMap) {
            if (System.currentTimeMillis() >= exportedHandlerTimeoutMap.getOrDefault(dcId, -1)) {
                exportedHandlerMap.remove(dcId)?.close()
                exportedHandlerTimeoutMap.remove(dcId)
            }
        }
    }

    override fun pfs() {
        createAuthKey(dataCenter, true)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap { createHandler(it) }
                .doOnSuccess { it.start() }
                .doOnSuccess { initConnection(TLRequestHelpGetNearestDc(), it) }
                .flatMap {
                    Single.just(it)
                            .zipWith(TempAuthKeyBinding.bindKey(it.authKey as TempAuthKey,
                                                                mtProtoHandler!!.authKey,
                                                                it))
                }
                .doOnSuccess { logger.error("PFS SUCCESS BITCH") }
                .doOnSuccess { it.first.close() }
                .blockingGet()
    }

    companion object {
        private val logger = Logger.Factory.create(TelegramClient::class)

        private const val DEFAULT_RETRY_COUNT = 2

        private fun String.startsWithAny(vararg values: String, ignoreCase: Boolean = true) = values.any {
            startsWith(it, ignoreCase)
        }

        /** Unwrap [RpcErrorException] */
        private inline fun <T> executeSync(body: () -> Single<T>): T = try {
            body.invoke().blockingGet()
        } catch (e: RuntimeException) {
            if (e.cause is RpcErrorException)
                throw e.cause as RpcErrorException
            throw e
        }

        private fun createHandler(dataCenter: DataCenter, authKey: AuthKey, session: MTSession? = null): Single<MTProtoHandler> =
                Single.fromCallable { MTProtoHandler(dataCenter, authKey, session) }

        private fun createHandler(authResult: AuthResult): Single<MTProtoHandler> =
                Single.fromCallable { MTProtoHandler(authResult) }

        private fun createAuthKey(dataCenter: DataCenter, tmpKey: Boolean = false): Single<AuthResult> =
                AuthKeyCreation.createAuthKey(dataCenter, tmpKey)
    }
}
