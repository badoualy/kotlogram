package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.ApiCallback
import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthKeyCreation
import com.github.badoualy.telegram.mtproto.auth.AuthResult
import com.github.badoualy.telegram.mtproto.exception.RpcErrorException
import com.github.badoualy.telegram.mtproto.util.Log
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetNearestDc
import com.github.badoualy.telegram.tl.api.request.TLRequestInitConnection
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithLayer
import java.io.IOException

internal interface TelegramClientDelegate {
    val application: TelegramApp

    var mtProtoHandler: MTProtoHandler?
    var authKey: AuthKey?
    var dataCenter: DataCenter?

    val apiStorage: TelegramApiStorage?
    val preferredDataCenter: DataCenter

    var updateCallback: UpdateCallback?

    /**
     * Disconnect from current data center and connect to the new one
     * @param dcId id of the new data center [1, 5]
     */
    fun migrate(dcId: Int)

    /** Closes all connections and stop all threads used by the client. */
    fun close()
}

internal class TelegramClientDelegateImpl(override val application: TelegramApp, override val apiStorage: TelegramApiStorage,
                                          override val preferredDataCenter: DataCenter, override var updateCallback: UpdateCallback?) : TelegramClientDelegate, ApiCallback {

    private val TAG = "TelegramClientDelegateImpl"

    override var mtProtoHandler: MTProtoHandler? = null
    override var authKey: AuthKey? = null
    override var dataCenter: DataCenter? = null

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

        init(generateAuthKey)
    }

    private fun init(checkNearestDc: Boolean = true) {
        mtProtoHandler = if (generateAuthKey) MTProtoHandler(generateAuthKey(), this) else MTProtoHandler(dataCenter!!, authKey!!, apiStorage.loadServerSalt(), this)
        mtProtoHandler!!.startWatchdog()

        try {
            // Call to initConnection to setup information about this app for the user to see in "active sessions"
            // Also will indicate to Telegram which layer to use through InvokeWithLayer
            val nearestDc = mtProtoHandler!!
                    .executeMethod(TLRequestInvokeWithLayer(45, TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, TLRequestHelpGetNearestDc())))
                    .toBlocking().first()
            if (checkNearestDc)
                checkNearestDc(nearestDc)
        } catch(e: Exception) {
            mtProtoHandler?.close()
            if (e is RpcErrorException && e.error.errorCode == -404)
                throw RuntimeException("Your authorization key seems to be invalid (error " + e.error.errorCode + ")")
            throw RuntimeException("An unknown error has occurred", e)
        }
    }

    private fun generateAuthKey(): AuthResult {
        val authResult = AuthKeyCreation.createAuthKey(dataCenter!!) ?: throw RuntimeException("Couldn't generate authorization key")
        authKey = authResult.authKey
        apiStorage.saveAuthKey(authKey!!)
        apiStorage.saveDc(dataCenter!!)
        return authResult
    }

    @Throws(IOException::class)
    private fun checkNearestDc(nearestDc: TLNearestDc) {
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

    override fun migrate(dcId: Int) {
        Log.d(TAG, "Migrating to DC$dcId")
        mtProtoHandler?.close()
        authKey = null
        dataCenter = Kotlogram.PROD_DCS[dcId - 1]
        apiStorage.deleteAuthKey()
        apiStorage.deleteDc()
        generateAuthKey = true

        init(checkNearestDc = false)
    }

    override fun close() = mtProtoHandler?.close() ?: Unit

    override fun onUpdates(update: TLAbsUpdates) {
        when (update) {
            is TLUpdatesTooLong -> updateCallback?.onUpdateTooLong()
            is TLUpdateShortMessage -> updateCallback?.onShortMessage(update)
            is TLUpdateShortChatMessage -> updateCallback?.onShortChatMessage(update)
            is TLUpdateShort -> handleUpdate(update.update)
            is TLUpdatesCombined -> update.updates.forEach { u -> handleUpdate(u) }
            is TLUpdates -> update.updates.forEach { u -> handleUpdate(u) }
        }
    }

    fun handleUpdate(update: TLAbsUpdate): Unit? = when (update) {
        is TLUpdateNewMessage -> updateCallback?.onNewMessage(update)
        is TLUpdateMessageID -> Unit
        //is TLUpdateReadMessages -> Unit
        is TLUpdateDeleteMessages -> Unit
    //is TLUpdateRestoreMessages -> Unit
        is TLUpdateUserTyping -> Unit
        is TLUpdateChatUserTyping -> Unit
        is TLUpdateChatParticipants -> Unit
        is TLUpdateUserStatus -> Unit
        is TLUpdateUserName -> Unit
        is TLUpdateUserPhoto -> Unit
        is TLUpdateContactRegistered -> Unit
        is TLUpdateContactLink -> Unit
    //is TLUpdateActivation -> Unit
        is TLUpdateNewAuthorization -> Unit
    //is TLUpdateNewGeoChatMessage -> Unit
        is TLUpdateNewEncryptedMessage -> Unit
        is TLUpdateEncryptedChatTyping -> Unit
        is TLUpdateEncryption -> Unit
        is TLUpdateEncryptedMessagesRead -> Unit
        is TLUpdateChatParticipantAdd -> Unit
        is TLUpdateChatParticipantDelete -> Unit
        is TLUpdateDcOptions -> Unit
        is TLUpdateUserBlocked -> Unit
        is TLUpdateNotifySettings -> Unit
        is TLUpdateServiceNotification -> Unit
        else -> Unit
    }

    override fun onSalt(salt: Long) = apiStorage.saveServerSalt(salt)
}