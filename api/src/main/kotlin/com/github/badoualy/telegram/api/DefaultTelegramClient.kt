package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.ApiCallback
import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthKeyCreation
import com.github.badoualy.telegram.mtproto.auth.AuthResult
import com.github.badoualy.telegram.mtproto.exception.SecurityException
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.api.auth.TLSentCode
import com.github.badoualy.telegram.tl.api.request.*
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import org.slf4j.LoggerFactory
import java.io.IOException
import java.nio.channels.ClosedChannelException
import java.util.*
import java.util.concurrent.TimeoutException

internal class DefaultTelegramClient internal constructor(val application: TelegramApp, val apiStorage: TelegramApiStorage,
                                                          val preferredDataCenter: DataCenter,
                                                          val updateCallback: UpdateCallback?) : TelegramApiWrapper(), TelegramClient, ApiCallback {

    private var mtProtoHandler: MTProtoHandler? = null
    private var authKey: AuthKey? = null
    private var dataCenter: DataCenter? = null

    private var authKeyMap = HashMap<Int, AuthKey>()

    private var timeoutDuration: Long = 5000L

    private var generateAuthKey: Boolean

    init {
        authKey = apiStorage.loadAuthKey()
        dataCenter = apiStorage.loadDc()
        generateAuthKey = authKey == null

        if (dataCenter == null) {
            if (!generateAuthKey) {
                apiStorage.deleteAuthKey()
                throw RuntimeException("Found an authorization key in storage, but the DC configuration was not found, deleting authorization key")
            }
            logger.warn("No data center found in storage, using preferred ${preferredDataCenter.toString()}")
            dataCenter = preferredDataCenter
        }

        // No need to check DC if we have an authKey in storage
        init(checkNearestDc = generateAuthKey)
        logger.info(mtProtoHandler!!.sessionMarker, "Client ready")
    }

    private fun init(checkNearestDc: Boolean = true) {
        logger.debug("init() $checkNearestDc")
        mtProtoHandler =
                if (generateAuthKey) MTProtoHandler(generateAuthKey(), this)
                else MTProtoHandler(dataCenter!!, authKey!!, apiStorage.loadServerSalt(), this)
        mtProtoHandler!!.startWatchdog()

        try {
            // Call to initConnection to setup information about this app for the user to see in "active sessions"
            // Also will indicate to Telegram which layer to use through InvokeWithLayer
            // Re-call every time to ensure connection is alive and to update layer
            if (checkNearestDc)
                ensureNearestDc(initConnection(mtProtoHandler!!, TLRequestHelpGetNearestDc()))
            else {
                if (!generateAuthKey) {
                    try {
                        // GetNearestDc will not start updates: // TODO: replace with getDifference for updates
                        initConnection(mtProtoHandler!!, TLRequestUpdatesGetState())
                        return
                    } catch(e: RpcErrorException) {
                        // User may not be signed in already, in this case, ignore exception
                        if (e.code != 401)
                            throw e
                    }
                }
                initConnection(mtProtoHandler!!, TLRequestHelpGetNearestDc())
            }
        } catch(e: Exception) {
            mtProtoHandler?.close()
            if (e is RpcErrorException && e.code == -404)
                throw SecurityException("Your authorization key is invalid (error ${e.code})")
            throw e
        }
    }

    private fun generateAuthKey(): AuthResult {
        val authResult = AuthKeyCreation.createAuthKey(dataCenter!!) ?: throw RuntimeException("Couldn't generate authorization key")
        authKey = authResult.authKey
        apiStorage.saveAuthKey(authKey!!)
        apiStorage.saveDc(dataCenter!!)
        return authResult
    }

    @Throws(RpcErrorException::class, IOException::class)
    private fun <T : TLObject> initConnection(mtProtoHandler: MTProtoHandler, method: TLMethod<T>): T {
        logger.debug("Init connection with method ${method.toString()}")
        val initConnectionRequest = TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, method)
        val result = executeRpcQuery(TLRequestInvokeWithLayer(Kotlogram.API_LAYER, initConnectionRequest), mtProtoHandler)
        return result
    }

    @Throws(RpcErrorException::class, IOException::class)
    private fun ensureNearestDc(nearestDc: TLNearestDc) {
        logger.debug("ensureNearestDc()")
        if (nearestDc.thisDc != nearestDc.nearestDc) {
            logger.warn("Current DC${nearestDc.thisDc} is not the nearest (DC${nearestDc.nearestDc})")
            if (!generateAuthKey) {
                // Key was provided, yet selected DC is not the nearest
                // TODO: Should handle authKey migration via auth.exportAuthorization
                mtProtoHandler?.close()
                throw RuntimeException("You tried to connect to an incorrect data center (DC${nearestDc.thisDc}) with an authorization key in storage, please connect to the nearest (DC${nearestDc.nearestDc})")
            }
            migrate(nearestDc.nearestDc)
        } else {
            logger.info("Connected to the nearest DC${nearestDc.thisDc}")
        }
    }

    override fun setTimeout(timeout: Long) {
        this.timeoutDuration = timeout
    }

    override fun close() = close(true)

    override fun close(cleanUp: Boolean) {
        mtProtoHandler?.close()
        if (cleanUp)
            Kotlogram.cleanUp()
    }

    override fun <T : TLObject> queueMethod(method: TLMethod<T>, timeout: Long) = mtProtoHandler?.queueMethod(method, timeout)

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> executeRpcQuery(method: TLMethod<T>) = executeRpcQuery(method, mtProtoHandler!!)

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> executeRpcQuery(method: TLMethod<T>, dcId: Int): T {
        logger.debug("executeRpcQuery ${method.toString()} on DC$dcId")
        if (Kotlogram.getDcById(dcId).equals(dataCenter))
            return executeRpcQuery(method)

        logger.info("Need to export handler")
        val migratedHandler = getExportedMTProtoHandler(dcId)
        try {
            return executeRpcQuery(method, migratedHandler)
        } finally {
            migratedHandler.close()
        }
    }

    @Throws(RpcErrorException::class, IOException::class)
    private fun <T : TLObject> executeRpcQuery(method: TLMethod<T>, mtProtoHandler: MTProtoHandler, attemptCount: Int = 0): T {
        // BlockingObservable.first() will throw a RuntimeException if onError() is called by observable
        try {
            return mtProtoHandler.executeMethodSync(method, timeoutDuration)
        } catch(exception: RuntimeException) {
            when (exception.cause) {
                is RpcErrorException -> {
                    val rpcException = (exception.cause as RpcErrorException)
                    if (rpcException.code == 303) {
                        // DC error
                        logger.error("Received DC error: ${rpcException.toString()}")
                        if (rpcException.tag.startsWith("PHONE_MIGRATE_") || rpcException.tag.startsWith("NETWORK_MIGRATE_")) {
                            val dcId = rpcException.tagInteger
                            logger.info("Repeat request after migration on DC$dcId")
                            migrate(dcId)
                            return executeRpcQuery(method)
                        } else if (rpcException.tag.startsWith("FILE_MIGRATE_")) {
                            val dcId = rpcException.tagInteger
                            logger.info("Repeat request with new handler on DC$dcId")
                            val exportedHandler = getExportedMTProtoHandler(dcId)
                            try {
                                return executeRpcQuery(method, exportedHandler)
                            } finally {
                                exportedHandler.close()
                            }
                        }
                    }
                    logger.error("Unhandled RpcError ${rpcException.toString()}")
                    throw RpcErrorException(rpcException.code, rpcException.tag) // Better stack trace
                }
                is TimeoutException, is ClosedChannelException -> {
                    if (attemptCount < 2) {
                        // Experimental, try to resend request ...
                        logger.error("Attempting MtProtoHandler reset after failure")
                        mtProtoHandler.resetConnection()
                        val result = executeRpcQuery(method, mtProtoHandler, attemptCount + 1)
                        logger.debug("Reset worked")
                        return result
                    }
                    throw TimeoutException("Request timed out")
                }
                is IOException -> throw exception.cause as IOException
                else -> throw exception
            }
        }
    }

    override fun authSendCode(allowFlashcall: Boolean, phoneNumber: String, currentNumber: Boolean): TLSentCode {
        throw UnsupportedOperationException()
    }

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSendCode(phoneNumber: String, smsType: Int) = super.authSendCode(false, phoneNumber, false, application.apiId, application.apiHash, application.langCode)

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> initConnection(query: TLMethod<T>) = executeRpcQuery(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendMessage(peer: TLAbsInputPeer, message: String, randomId: Long) = super.messagesSendMessage(true, false, false, false, peer, null, message, randomId, null, null)

    private fun migrate(dcId: Int) {
        logger.info("Migrating to DC$dcId")
        mtProtoHandler?.close()
        authKey = null
        dataCenter = Kotlogram.getDcById(dcId)
        apiStorage.deleteAuthKey()
        apiStorage.deleteDc()
        generateAuthKey = true

        init(checkNearestDc = false)
    }

    @Throws(RpcErrorException::class, IOException::class)
    private fun getExportedMTProtoHandler(dcId: Int): MTProtoHandler {
        logger.trace("getExportedMTProtoHandler(DC$dcId)")
        return if (authKeyMap.contains(dcId)) {
            logger.debug("Already have key for DC$dcId")
            val authKey = authKeyMap[dcId]!!
            val mtProtoHandler = MTProtoHandler(Kotlogram.getDcById(dcId), authKey, null, null)
            mtProtoHandler.startWatchdog()
            initConnection(mtProtoHandler, TLRequestHelpGetNearestDc())
            mtProtoHandler
        } else {
            logger.debug("Creating new handler on DC$dcId")
            val dc = Kotlogram.getDcById(dcId)
            val exportedAuthorization = authExportAuthorization(dcId)
            val authResult = AuthKeyCreation.createAuthKey(dc) ?: throw IOException("Couldn't create authorization key on DC$dcId")
            val mtProtoHandler = MTProtoHandler(authResult, null)
            mtProtoHandler.startWatchdog()
            initConnection(mtProtoHandler, TLRequestAuthImportAuthorization(exportedAuthorization.id, exportedAuthorization.bytes))
            authKeyMap.put(dcId, authResult.authKey)
            mtProtoHandler
        }
    }

    override fun onUpdates(update: TLAbsUpdates) {
        when (update) {
            is TLUpdates -> updateCallback?.onUpdates(this, update) // Multiple messages
            is TLUpdatesCombined -> updateCallback?.onUpdatesCombined(this, update)
            is TLUpdateShort -> updateCallback?.onUpdateShort(this, update)
            is TLUpdateShortChatMessage -> updateCallback?.onShortChatMessage(this, update) // group new message
            is TLUpdateShortMessage -> updateCallback?.onShortMessage(this, update) // 1v1 new message
            is TLUpdateShortSentMessage -> updateCallback?.onShortSentMessage(this, update)
            is TLUpdatesTooLong -> updateCallback?.onUpdateTooLong(this) // Warn that the client should refresh manually
        }
    }

    override fun onSalt(salt: Long) = apiStorage.saveServerSalt(salt)

    companion object {
        private val logger = LoggerFactory.getLogger(TelegramClient::class.java)
    }
}