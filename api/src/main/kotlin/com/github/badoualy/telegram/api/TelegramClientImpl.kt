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
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetNearestDc
import com.github.badoualy.telegram.tl.api.request.TLRequestInitConnection
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithLayer
import com.github.badoualy.telegram.tl.api.request.TLRequestUpdatesGetState
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class TelegramClientImpl internal constructor(override val app: TelegramApp,
                                              val apiStorage: TelegramApiStorage,
                                              val preferredDataCenter: DataCenter,
                                              tag: String) : TelegramClient() {

    private var mtProtoHandler: MTProtoHandler? = null
    private var authKey: AuthKey? = null
    private var dataCenter: DataCenter? = null
    override var closed: Boolean = false

    override var timeout: Long = TimeUnit.SECONDS.toMillis(5)
    override var exportedClientTimeout: Long = TimeUnit.MINUTES.toMillis(1)

    private var generateAuthKey: Boolean = false

    override var tag = LogTag(tag)

    val updatesObservable: Observable<TLAbsUpdates>
        get() = mtProtoHandler!!.updatesObservable

    override fun init() {
        logger.trace(tag, "init()")
        authKey = apiStorage.loadAuthKey()
        dataCenter = apiStorage.loadDc()
        generateAuthKey = authKey == null

        if (dataCenter == null) {
            if (!generateAuthKey) {
                apiStorage.deleteAuthKey()
                apiStorage.saveSession(null)
                logger.error(tag, "Found an auth key in storage but no dc")
            }
            logger.warn(tag,
                        "No data center found in storage, using preferred $preferredDataCenter")
            dataCenter = preferredDataCenter
        }

        // No need to check DC if we have an authKey in storage
        init(checkNearestDc = generateAuthKey)
        logger.info(tag, "Client ready")
    }

    // Move to RX?
    private fun init(checkNearestDc: Boolean) {
        logger.trace(tag, "init() $checkNearestDc")
        mtProtoHandler =
                (if (generateAuthKey) getNewHandler()
                else getNewHandler(dataCenter!!, authKey!!, apiStorage.loadSession())).blockingGet()
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
                    // Ignore 401 error (user not signed in)
                    if (e.code != 401)
                        throw e
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

    private fun <T : TLObject> executeMethod(method: TLMethod<T>, mtProtoHandler: MTProtoHandler): Single<T> =
            executeMethods(listOf(method), mtProtoHandler).singleOrError()

    override fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>): Observable<T> =
            executeMethods(methods, mtProtoHandler!!)

    override fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>, dcId: Int): Observable<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // TODO: handles errors
    private fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>, mtProtoHandler: MTProtoHandler): Observable<T> =
            mtProtoHandler.executeMethods(methods)
                    .timeout(timeout, TimeUnit.MILLISECONDS)

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
        return executeMethod(request, mtProtoHandler).blockingGet()
    }

    private fun ensureNearestDc(nearestDc: TLNearestDc) {
        logger.trace(tag, "ensureNearestDc()")
        if (nearestDc.thisDc != nearestDc.nearestDc) {
            logger.warn(tag,
                        "Current DC${nearestDc.thisDc} is not the nearest (DC${nearestDc.nearestDc})")
            migrate(nearestDc.nearestDc)
        } else {
            logger.debug(tag, "Connected to the nearest DC${nearestDc.thisDc}")
        }
    }

    private fun migrate(dcId: Int) {
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

    companion object {
        private val logger = Logger(TelegramClient::class)
    }
}