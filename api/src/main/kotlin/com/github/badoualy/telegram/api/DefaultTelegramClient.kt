package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.ApiCallback
import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthKeyCreation
import com.github.badoualy.telegram.mtproto.auth.AuthResult
import com.github.badoualy.telegram.mtproto.exception.SecurityException
import com.github.badoualy.telegram.mtproto.util.Log
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.api.request.*
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.IOException
import java.math.BigInteger
import java.nio.channels.ClosedChannelException
import java.util.concurrent.TimeoutException

internal class DefaultTelegramClient internal constructor(val application: TelegramApp, val apiStorage: TelegramApiStorage,
                                                          val preferredDataCenter: DataCenter,
                                                          val updateCallback: UpdateCallback?,
                                                          val debugListener: DebugListener?) : TelegramApiWrapper(), TelegramClient, ApiCallback {

    private val TAG = "TelegramClient"

    private var mtProtoHandler: MTProtoHandler? = null
    private var authKey: AuthKey? = null
    private var dataCenter: DataCenter? = null

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
            Log.d(TAG, "No data center found in storage, using preferred ${preferredDataCenter.toString()}")
            dataCenter = preferredDataCenter
        }

        // No need to check DC if we have an authKey in storage
        init(checkNearestDc = generateAuthKey)
        Log.d(TAG, "Client ready with MTProto#${BigInteger(mtProtoHandler!!.sessionId).toLong()}")
    }

    private fun init(checkNearestDc: Boolean = true) {
        mtProtoHandler = if (generateAuthKey) MTProtoHandler(generateAuthKey(), this) else MTProtoHandler(dataCenter!!, authKey!!, apiStorage.loadServerSalt(), this)
        debugListener?.onSocketCreated()
        mtProtoHandler!!.startWatchdog()

        try {
            // Call to initConnection to setup information about this app for the user to see in "active sessions"
            // Also will indicate to Telegram which layer to use through InvokeWithLayer
            // Re-call every time to ensure connection is alive and to update layer
            if (checkNearestDc)
                ensureNearestDc(initConnection(mtProtoHandler!!, TLRequestHelpGetNearestDc()))
            else // GetNearestDc will not start updates: // TODO: replace with getDifference for updates
                initConnection(mtProtoHandler!!, TLRequestUpdatesGetState())
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
        val initConnectionRequest = TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, method)
        val result = executeRpcQuery(TLRequestInvokeWithLayer(Kotlogram.API_LAYER, initConnectionRequest), mtProtoHandler)
        return result
    }

    @Throws(RpcErrorException::class, IOException::class)
    private fun ensureNearestDc(nearestDc: TLNearestDc) {
        if (nearestDc.thisDc != nearestDc.nearestDc) {
            if (!generateAuthKey) {
                // Key was provided, yet selected DC is not the nearest
                // TODO: Should handle authKey migration via auth.exportAuthorization
                mtProtoHandler?.close()
                throw RuntimeException("You tried to connect to an incorrect data center (DC${nearestDc.thisDc}) with an authorization key in storage, please connect to the nearest (DC${nearestDc.nearestDc})")
            }
            migrate(nearestDc.nearestDc)
        } else {
            Log.d(TAG, "Connected to the nearest DC${nearestDc.thisDc}")
        }
    }

    override fun setTimeout(timeout: Long) {
        this.timeoutDuration = timeout
    }

    override fun close() = close(true)

    override fun close(cleanUp: Boolean) {
        debugListener?.onSocketDestroyed()
        mtProtoHandler?.close() ?: Unit
        if (cleanUp)
            Kotlogram.cleanUp()
    }

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> executeRpcQuery(method: TLMethod<T>) = executeRpcQuery(method, mtProtoHandler!!)

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> executeRpcQuery(method: TLMethod<T>, dcId: Int): T {
        if (Kotlogram.getDcById(dcId).equals(dataCenter))
            return executeRpcQuery(method)

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
                        Log.e(TAG, "Received DC error: ${rpcException.toString()}")
                        if (rpcException.tag.startsWith("PHONE_MIGRATE_") || rpcException.tag.startsWith("NETWORK_MIGRATE_")) {
                            migrate(rpcException.tag.removePrefix("PHONE_MIGRATE_").removePrefix("NETWORK_MIGRATE_").toInt())
                            return executeRpcQuery(method)
                        } else if (rpcException.tag.startsWith("FILE_MIGRATE_")) {
                            val migratedHandler = getExportedMTProtoHandler(rpcException.tag.removePrefix("FILE_MIGRATE_").toInt())
                            try {
                                return executeRpcQuery(method, migratedHandler)
                            } finally {
                                migratedHandler.close()
                            }
                        }
                    }
                    throw RpcErrorException(rpcException.code, rpcException.message) // Better stack trace
                }
                is TimeoutException, is ClosedChannelException -> {
                    if (attemptCount < 2) {
                        // Experimental, try to resend request ...
                        Log.e(TAG, "Attempting MtProtoHandler reset after failure")
                        debugListener?.onTimeoutBeforeReset()
                        mtProtoHandler.resetConnection()
                        val result = executeRpcQuery(method, mtProtoHandler, attemptCount + 1)
                        Log.d(TAG, "Reset worked")
                        return result
                    }
                    debugListener?.onTimeoutAfterReset()
                    throw TimeoutException("Request timed out")
                }
                is IOException -> throw exception.cause as IOException
                else -> throw exception
            }
        }
    }

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSendCode(phoneNumber: String, smsType: Int) = super.authSendCode(phoneNumber, smsType, application.apiId, application.apiHash, application.langCode)

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> initConnection(query: TLMethod<T>) = executeRpcQuery(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendMessage(peer: TLAbsInputPeer, message: String, randomId: Long) = super.messagesSendMessage(true, false, peer, null, message, randomId, null, null)

    private fun migrate(dcId: Int) {
        Log.d(TAG, "Migrating to DC$dcId")
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
        Log.d(TAG, "Creating handler on DC$dcId")
        val dc = Kotlogram.getDcById(dcId)
        val exportedAuthorization = authExportAuthorization(dcId)
        val authResult = AuthKeyCreation.createAuthKey(dc) ?: throw IOException("Couldn't create authorization key on DC$dcId")
        val mtProtoHandler = MTProtoHandler(authResult, null)
        mtProtoHandler.startWatchdog()
        debugListener?.onSocketCreated()
        initConnection(mtProtoHandler, TLRequestAuthImportAuthorization(exportedAuthorization.id, exportedAuthorization.bytes))
        return mtProtoHandler
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
}