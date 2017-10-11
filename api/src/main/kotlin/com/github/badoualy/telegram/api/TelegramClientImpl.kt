package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthKeyCreation
import com.github.badoualy.telegram.mtproto.auth.AuthResult
import com.github.badoualy.telegram.mtproto.exception.SecurityException
import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.log.Logger
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.mtproto.model.MTSession
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLNearestDc
import com.github.badoualy.telegram.tl.api.request.*
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class TelegramClientImpl internal constructor(override val app: TelegramApp,
                                              val apiStorage: TelegramApiStorage,
                                              val preferredDataCenter: DataCenter,
                                              tag: String) : TelegramClient() {

    private var mtProtoHandler: MTProtoHandler? = null
    private var authKey: AuthKey? = null
    private var dataCenter: DataCenter? = null
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

    override fun init() {
        logger.trace(tag, "init()")
        authKey = apiStorage.loadAuthKey()
        dataCenter = apiStorage.loadDc()
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

        // No need to check DC if we have an authKey in storage
        init(checkNearestDc = generateAuthKey)
        logger.info(tag, "Client ready")
    }

    // Move to RX?
    private fun init(checkNearestDc: Boolean) {
        logger.trace(tag, "init(): $checkNearestDc")
        mtProtoHandler = executeSync {
            (if (generateAuthKey) getNewHandler()
            else getNewHandler(dataCenter!!, authKey!!, apiStorage.loadSession()))
        }
        mtProtoHandler!!.start()

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

    override fun <T : TLObject> executeMethod(method: TLMethod<T>, dcId: Int): Single<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun <T : TLObject> executeMethod(method: TLMethod<T>, mtProtoHandler: MTProtoHandler): Single<T> =
            executeMethods(listOf(method), mtProtoHandler).singleOrError()

    override fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>): Observable<T> =
            executeMethods(methods, mtProtoHandler!!)

    override fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>, dcId: Int): Observable<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>, mtProtoHandler: MTProtoHandler): Observable<T> =
            Thread.currentThread().stackTrace.let { stackTrace ->
                mtProtoHandler.executeMethods(methods)
                        .timeout(timeout, TimeUnit.MILLISECONDS)
                        .retryWhen {
                            it.zipWith(Observable.range(1, requestRetryCount)) { err, i ->
                                Pair(err, i)
                            }.flatMap(retryIfNeeded(mtProtoHandler))
                        }
                        .doOnError { (it as? RpcErrorException)?.stackTrace = stackTrace }
            }

    override fun sync(): TelegramSyncClient = TelegramSyncClientImpl(this)

    override fun close() {
        try {
            mtProtoHandler?.close()
        } catch (e: Exception) {
        }
        closed = true
        mtProtoHandler?.session?.let { apiStorage.saveSession(it) }
    }

    private fun getNewHandler(): Single<MTProtoHandler> = getNewAuthKey().map { MTProtoHandler(it) }

    private fun getNewHandler(dataCenter: DataCenter, authKey: AuthKey, session: MTSession? = null): Single<MTProtoHandler> =
            Single.fromCallable { MTProtoHandler(dataCenter, authKey, session) }

    private fun getNewAuthKey(): Single<AuthResult> = AuthKeyCreation.createAuthKey(dataCenter!!)
            .doOnSuccess { authResult ->
                authKey = authResult.authKey
                apiStorage.saveAuthKey(authKey!!)
                apiStorage.saveDc(dataCenter!!)
            }

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

    private fun getExportedHandler(dcId: Int): MTProtoHandler {
        logger.trace(tag, "getExportedHandler(DC$dcId)")

        var cachedHandler: MTProtoHandler? = null
        synchronized(exportedHandlerMap) {
            cachedHandler = exportedHandlerMap.remove(dcId)
        }

        cachedHandler?.let { logger.debug(tag, "Using cached handler") }

        return cachedHandler ?: if (authKeyMap.containsKey(dcId)) {
            logger.debug(tag, "Already have key for DC$dcId")
            executeSync {
                getNewHandler(Kotlogram.getDcById(dcId), authKeyMap[dcId]!!, null)
                        .doAfterSuccess {
                            it.start()
                            initConnection(TLRequestHelpGetNearestDc(), it)
                        }
            }
        } else {
            executeSync {
                logger.debug(tag, "Creating new handler on DC$dcId")
                authExportAuthorization(dcId)
                        .zipWith(AuthKeyCreation.createAuthKey(Kotlogram.getDcById(dcId))
                                         .map { MTProtoHandler(it).apply { start() } })
                        .doOnSuccess {
                            initConnection(TLRequestAuthImportAuthorization(it.first.id,
                                                                            it.first.bytes),
                                           it.second)
                        }
                        .doOnSuccess { authKeyMap.put(dcId, it.second.authKey) }
                        .map { it.second }
            }
        }
    }

    private fun retryIfNeeded(mtProtoHandler: MTProtoHandler): (Pair<Throwable, Int>) -> Observable<*> = { (err, i) ->
        logger.warn(tag,
                    "method(s) failed at attempt $i (${err.javaClass.simpleName}): ${err.message}")
        when (err) {
            is RpcErrorException -> {
                when (err.code) {
                    303 -> { // DC error
                        val dcId = err.tagInteger
                        when {
                            err.tag.startsWithAny("PHONE_MIGRATE_", "NETWORK_MIGRATE_") -> {
                                logger.info(tag, "Repeat request after migration on DC$dcId")
                                migrate(dcId).toSingleDefault(Unit)
                            }
                            err.tag.startsWith("FILE_MIGRATE_") -> {
                                logger.info(tag, "Repeat request on DC$dcId")
                                // TODO
                                //Single.fromCallable { getExportedHandler(dcId) }
                                Single.error(err)
                            }
                            else -> Single.error(err)
                        }
                    }
                    else -> Single.error(err)
                }
            }
            else -> Single.fromCallable {
                logger.error(tag, "Attempting MTProtoHandler reset")
                mtProtoHandler.resetConnection()
            }.delay(i.toLong(), TimeUnit.SECONDS)
        }.subscribeOn(Schedulers.io()).toObservable()
    }

    companion object {
        private val logger = Logger(TelegramClient::class)

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
    }
}
