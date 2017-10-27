package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.RpcQuerySyncExecutor
import com.github.badoualy.telegram.tl.api.account.*
import com.github.badoualy.telegram.tl.api.auth.*
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization
import com.github.badoualy.telegram.tl.api.channels.TLAbsChannelParticipants
import com.github.badoualy.telegram.tl.api.channels.TLAdminLogResults
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant
import com.github.badoualy.telegram.tl.api.contacts.*
import com.github.badoualy.telegram.tl.api.help.*
import com.github.badoualy.telegram.tl.api.messages.*
import com.github.badoualy.telegram.tl.api.messages.TLChatFull
import com.github.badoualy.telegram.tl.api.messages.TLStickerSet
import com.github.badoualy.telegram.tl.api.payments.*
import com.github.badoualy.telegram.tl.api.phone.TLPhoneCall
import com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos
import com.github.badoualy.telegram.tl.api.photos.TLPhoto
import com.github.badoualy.telegram.tl.api.request.*
import com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference
import com.github.badoualy.telegram.tl.api.updates.TLState
import com.github.badoualy.telegram.tl.api.upload.TLAbsCdnFile
import com.github.badoualy.telegram.tl.api.upload.TLAbsFile
import com.github.badoualy.telegram.tl.api.upload.TLWebFile
import com.github.badoualy.telegram.tl.core.*
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.IOException

abstract class TelegramSyncApiWrapper : TelegramSyncApi, RpcQuerySyncExecutor {
    @Throws(RpcErrorException::class, IOException::class)
    override fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): TLAbsUser = executeRpcQuerySync(TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountCheckUsername(username: String): TLBool = executeRpcQuerySync(TLRequestAccountCheckUsername(username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountConfirmPhone(phoneCodeHash: String, phoneCode: String): TLBool = executeRpcQuerySync(TLRequestAccountConfirmPhone(phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountDeleteAccount(reason: String): TLBool = executeRpcQuerySync(TLRequestAccountDeleteAccount(reason))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAccountTTL(): TLAccountDaysTTL = executeRpcQuerySync(TLRequestAccountGetAccountTTL())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAuthorizations(): TLAuthorizations = executeRpcQuerySync(TLRequestAccountGetAuthorizations())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): TLAbsPeerNotifySettings = executeRpcQuerySync(TLRequestAccountGetNotifySettings(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetPassword(): TLAbsPassword = executeRpcQuerySync(TLRequestAccountGetPassword())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetPasswordSettings(currentPasswordHash: TLBytes): TLPasswordSettings = executeRpcQuerySync(TLRequestAccountGetPasswordSettings(currentPasswordHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetPrivacy(key: TLAbsInputPrivacyKey): TLPrivacyRules = executeRpcQuerySync(TLRequestAccountGetPrivacy(key))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetTmpPassword(passwordHash: TLBytes, period: Int): TLTmpPassword = executeRpcQuerySync(TLRequestAccountGetTmpPassword(passwordHash, period))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetWallPapers(): TLObjectVector<TLAbsWallPaper> = executeRpcQuerySync(TLRequestAccountGetWallPapers())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountRegisterDevice(tokenType: Int, token: String): TLBool = executeRpcQuerySync(TLRequestAccountRegisterDevice(tokenType, token))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountReportPeer(peer: TLAbsInputPeer, reason: TLAbsReportReason): TLBool = executeRpcQuerySync(TLRequestAccountReportPeer(peer, reason))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetAuthorization(hash: Long): TLBool = executeRpcQuerySync(TLRequestAccountResetAuthorization(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetNotifySettings(): TLBool = executeRpcQuerySync(TLRequestAccountResetNotifySettings())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSendChangePhoneCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?
    ): TLSentCode = executeRpcQuerySync(TLRequestAccountSendChangePhoneCode(allowFlashcall, phoneNumber, currentNumber))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSendConfirmPhoneCode(
            allowFlashcall: Boolean,
            hash: String,
            currentNumber: Boolean?
    ): TLSentCode = executeRpcQuerySync(TLRequestAccountSendConfirmPhoneCode(allowFlashcall, hash, currentNumber))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetAccountTTL(ttl: TLAccountDaysTTL): TLBool = executeRpcQuerySync(TLRequestAccountSetAccountTTL(ttl))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): TLPrivacyRules = executeRpcQuerySync(TLRequestAccountSetPrivacy(key, rules))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUnregisterDevice(tokenType: Int, token: String): TLBool = executeRpcQuerySync(TLRequestAccountUnregisterDevice(tokenType, token))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateDeviceLocked(period: Int): TLBool = executeRpcQuerySync(TLRequestAccountUpdateDeviceLocked(period))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateNotifySettings(peer: TLAbsInputNotifyPeer, settings: TLInputPeerNotifySettings): TLBool = executeRpcQuerySync(TLRequestAccountUpdateNotifySettings(peer, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdatePasswordSettings(currentPasswordHash: TLBytes, newSettings: TLPasswordInputSettings): TLBool = executeRpcQuerySync(TLRequestAccountUpdatePasswordSettings(currentPasswordHash, newSettings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): TLAbsUser = executeRpcQuerySync(TLRequestAccountUpdateProfile(firstName, lastName, about))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateStatus(offline: Boolean): TLBool = executeRpcQuerySync(TLRequestAccountUpdateStatus(offline))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateUsername(username: String): TLAbsUser = executeRpcQuerySync(TLRequestAccountUpdateUsername(username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authBindTempAuthKey(
            permAuthKeyId: Long,
            nonce: Long,
            expiresAt: Int,
            encryptedMessage: TLBytes
    ): TLBool = executeRpcQuerySync(TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authCancelCode(phoneNumber: String, phoneCodeHash: String): TLBool = executeRpcQuerySync(TLRequestAuthCancelCode(phoneNumber, phoneCodeHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authCheckPassword(passwordHash: TLBytes): TLAuthorization = executeRpcQuerySync(TLRequestAuthCheckPassword(passwordHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authCheckPhone(phoneNumber: String): TLCheckedPhone = executeRpcQuerySync(TLRequestAuthCheckPhone(phoneNumber))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authDropTempAuthKeys(exceptAuthKeys: TLLongVector): TLBool = executeRpcQuerySync(TLRequestAuthDropTempAuthKeys(exceptAuthKeys))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authExportAuthorization(dcId: Int): TLExportedAuthorization = executeRpcQuerySync(TLRequestAuthExportAuthorization(dcId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authImportAuthorization(id: Int, bytes: TLBytes): TLAuthorization = executeRpcQuerySync(TLRequestAuthImportAuthorization(id, bytes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): TLAuthorization = executeRpcQuerySync(TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authLogOut(): TLBool = executeRpcQuerySync(TLRequestAuthLogOut())

    @Throws(RpcErrorException::class, IOException::class)
    override fun authRecoverPassword(code: String): TLAuthorization = executeRpcQuerySync(TLRequestAuthRecoverPassword(code))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authRequestPasswordRecovery(): TLPasswordRecovery = executeRpcQuerySync(TLRequestAuthRequestPasswordRecovery())

    @Throws(RpcErrorException::class, IOException::class)
    override fun authResendCode(phoneNumber: String, phoneCodeHash: String): TLSentCode = executeRpcQuerySync(TLRequestAuthResendCode(phoneNumber, phoneCodeHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authResetAuthorizations(): TLBool = executeRpcQuerySync(TLRequestAuthResetAuthorizations())

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSendCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?,
            apiId: Int,
            apiHash: String
    ): TLSentCode = executeRpcQuerySync(TLRequestAuthSendCode(allowFlashcall, phoneNumber, currentNumber, apiId, apiHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSendInvites(phoneNumbers: TLStringVector, message: String): TLBool = executeRpcQuerySync(TLRequestAuthSendInvites(phoneNumbers, message))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): TLAuthorization = executeRpcQuerySync(TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String,
            firstName: String,
            lastName: String
    ): TLAuthorization = executeRpcQuerySync(TLRequestAuthSignUp(phoneNumber, phoneCodeHash, phoneCode, firstName, lastName))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsAnswerWebhookJSONQuery(queryId: Long, data: TLDataJSON): TLBool = executeRpcQuerySync(TLRequestBotsAnswerWebhookJSONQuery(queryId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): TLDataJSON = executeRpcQuerySync(TLRequestBotsSendCustomRequest(customMethod, params))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsCheckUsername(channel: TLAbsInputChannel, username: String): TLBool = executeRpcQuerySync(TLRequestChannelsCheckUsername(channel, username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            title: String,
            about: String
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsCreateChannel(broadcast, megagroup, title, about))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteChannel(channel: TLAbsInputChannel): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsDeleteChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteHistory(channel: TLAbsInputChannel, maxId: Int): TLBool = executeRpcQuerySync(TLRequestChannelsDeleteHistory(channel, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): TLAffectedMessages = executeRpcQuerySync(TLRequestChannelsDeleteMessages(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteUserHistory(channel: TLAbsInputChannel, userId: TLAbsInputUser): TLAffectedHistory = executeRpcQuerySync(TLRequestChannelsDeleteUserHistory(channel, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditAbout(channel: TLAbsInputChannel, about: String): TLBool = executeRpcQuerySync(TLRequestChannelsEditAbout(channel, about))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChannelAdminRights
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsEditAdmin(channel, userId, adminRights))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditBanned(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            bannedRights: TLChannelBannedRights
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsEditBanned(channel, userId, bannedRights))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsEditPhoto(channel, photo))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditTitle(channel: TLAbsInputChannel, title: String): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsEditTitle(channel, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsExportInvite(channel: TLAbsInputChannel): TLAbsExportedChatInvite = executeRpcQuerySync(TLRequestChannelsExportInvite(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsExportMessageLink(channel: TLAbsInputChannel, id: Int): TLExportedMessageLink = executeRpcQuerySync(TLRequestChannelsExportMessageLink(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): TLAdminLogResults = executeRpcQuerySync(TLRequestChannelsGetAdminLog(channel, q, eventsFilter, admins, maxId, minId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetAdminedPublicChannels(): TLAbsChats = executeRpcQuerySync(TLRequestChannelsGetAdminedPublicChannels())

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): TLAbsChats = executeRpcQuerySync(TLRequestChannelsGetChannels(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetFullChannel(channel: TLAbsInputChannel): TLChatFull = executeRpcQuerySync(TLRequestChannelsGetFullChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetMessages(channel: TLAbsInputChannel, id: TLIntVector): TLAbsMessages = executeRpcQuerySync(TLRequestChannelsGetMessages(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetParticipant(channel: TLAbsInputChannel, userId: TLAbsInputUser): TLChannelParticipant = executeRpcQuerySync(TLRequestChannelsGetParticipant(channel, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int,
            hash: Int
    ): TLAbsChannelParticipants = executeRpcQuerySync(TLRequestChannelsGetParticipants(channel, filter, offset, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsInviteToChannel(channel, users))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsJoinChannel(channel: TLAbsInputChannel): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsJoinChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsLeaveChannel(channel: TLAbsInputChannel): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsLeaveChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReadHistory(channel: TLAbsInputChannel, maxId: Int): TLBool = executeRpcQuerySync(TLRequestChannelsReadHistory(channel, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReadMessageContents(channel: TLAbsInputChannel, id: TLIntVector): TLBool = executeRpcQuerySync(TLRequestChannelsReadMessageContents(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReportSpam(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            id: TLIntVector
    ): TLBool = executeRpcQuerySync(TLRequestChannelsReportSpam(channel, userId, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsSetStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): TLBool = executeRpcQuerySync(TLRequestChannelsSetStickers(channel, stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleInvites(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsToggleInvites(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsTogglePreHistoryHidden(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsTogglePreHistoryHidden(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsToggleSignatures(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsUpdatePinnedMessage(
            silent: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestChannelsUpdatePinnedMessage(silent, channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsUpdateUsername(channel: TLAbsInputChannel, username: String): TLBool = executeRpcQuerySync(TLRequestChannelsUpdateUsername(channel, username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsBlock(id: TLAbsInputUser): TLBool = executeRpcQuerySync(TLRequestContactsBlock(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsDeleteContact(id: TLAbsInputUser): TLLink = executeRpcQuerySync(TLRequestContactsDeleteContact(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsDeleteContacts(id: TLObjectVector<TLAbsInputUser>): TLBool = executeRpcQuerySync(TLRequestContactsDeleteContacts(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsExportCard(): TLIntVector = executeRpcQuerySync(TLRequestContactsExportCard())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetBlocked(offset: Int, limit: Int): TLAbsBlocked = executeRpcQuerySync(TLRequestContactsGetBlocked(offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetContacts(hash: Int): TLAbsContacts = executeRpcQuerySync(TLRequestContactsGetContacts(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetStatuses(): TLObjectVector<TLContactStatus> = executeRpcQuerySync(TLRequestContactsGetStatuses())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetTopPeers(
            correspondents: Boolean,
            botsPm: Boolean,
            botsInline: Boolean,
            phoneCalls: Boolean,
            groups: Boolean,
            channels: Boolean,
            offset: Int,
            limit: Int,
            hash: Int
    ): TLAbsTopPeers = executeRpcQuerySync(TLRequestContactsGetTopPeers(correspondents, botsPm, botsInline, phoneCalls, groups, channels, offset, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsImportCard(exportCard: TLIntVector): TLAbsUser = executeRpcQuerySync(TLRequestContactsImportCard(exportCard))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): TLImportedContacts = executeRpcQuerySync(TLRequestContactsImportContacts(contacts))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResetSaved(): TLBool = executeRpcQuerySync(TLRequestContactsResetSaved())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResetTopPeerRating(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer): TLBool = executeRpcQuerySync(TLRequestContactsResetTopPeerRating(category, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResolveUsername(username: String): TLResolvedPeer = executeRpcQuerySync(TLRequestContactsResolveUsername(username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsSearch(q: String, limit: Int): TLFound = executeRpcQuerySync(TLRequestContactsSearch(q, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsUnblock(id: TLAbsInputUser): TLBool = executeRpcQuerySync(TLRequestContactsUnblock(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetAppChangelog(prevAppVersion: String): TLAbsUpdates = executeRpcQuerySync(TLRequestHelpGetAppChangelog(prevAppVersion))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetAppUpdate(): TLAbsAppUpdate = executeRpcQuerySync(TLRequestHelpGetAppUpdate())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetCdnConfig(): TLCdnConfig = executeRpcQuerySync(TLRequestHelpGetCdnConfig())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetConfig(): TLConfig = executeRpcQuerySync(TLRequestHelpGetConfig())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetInviteText(): TLInviteText = executeRpcQuerySync(TLRequestHelpGetInviteText())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetNearestDc(): TLNearestDc = executeRpcQuerySync(TLRequestHelpGetNearestDc())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetRecentMeUrls(referer: String): TLRecentMeUrls = executeRpcQuerySync(TLRequestHelpGetRecentMeUrls(referer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetSupport(): TLSupport = executeRpcQuerySync(TLRequestHelpGetSupport())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetTermsOfService(): TLTermsOfService = executeRpcQuerySync(TLRequestHelpGetTermsOfService())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpSaveAppLog(events: TLObjectVector<TLInputAppEvent>): TLBool = executeRpcQuerySync(TLRequestHelpSaveAppLog(events))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpSetBotUpdatesStatus(pendingUpdatesCount: Int, message: String): TLBool = executeRpcQuerySync(TLRequestHelpSetBotUpdatesStatus(pendingUpdatesCount, message))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> initConnection(
            apiId: Int,
            deviceModel: String,
            systemVersion: String,
            appVersion: String,
            systemLangCode: String,
            langPack: String,
            langCode: String,
            query: TLMethod<T>?
    ): T = executeRpcQuerySync(TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, systemLangCode, langPack, langCode, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>?): T = executeRpcQuerySync(TLRequestInvokeAfterMsg(msgId, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>?): T = executeRpcQuerySync(TLRequestInvokeAfterMsgs(msgIds, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>?): T = executeRpcQuerySync(TLRequestInvokeWithLayer(layer, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>?): T = executeRpcQuerySync(TLRequestInvokeWithoutUpdates(query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetDifference(fromVersion: Int): TLLangPackDifference = executeRpcQuerySync(TLRequestLangpackGetDifference(fromVersion))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetLangPack(langCode: String): TLLangPackDifference = executeRpcQuerySync(TLRequestLangpackGetLangPack(langCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetLanguages(): TLObjectVector<TLLangPackLanguage> = executeRpcQuerySync(TLRequestLangpackGetLanguages())

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetStrings(langCode: String, keys: TLStringVector): TLObjectVector<TLAbsLangPackString> = executeRpcQuerySync(TLRequestLangpackGetStrings(langCode, keys))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): TLAbsEncryptedChat = executeRpcQuerySync(TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesAddChatUser(
            chatId: Int,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesAddChatUser(chatId, userId, fwdLimit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesCheckChatInvite(hash: String): TLAbsChatInvite = executeRpcQuerySync(TLRequestMessagesCheckChatInvite(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesClearRecentStickers(attached: Boolean): TLBool = executeRpcQuerySync(TLRequestMessagesClearRecentStickers(attached))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesCreateChat(users: TLObjectVector<TLAbsInputUser>, title: String): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesCreateChat(users, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteChatUser(chatId: Int, userId: TLAbsInputUser): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesDeleteChatUser(chatId, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteHistory(
            justClear: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int
    ): TLAffectedHistory = executeRpcQuerySync(TLRequestMessagesDeleteHistory(justClear, peer, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): TLAffectedMessages = executeRpcQuerySync(TLRequestMessagesDeleteMessages(revoke, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDiscardEncryption(chatId: Int): TLBool = executeRpcQuerySync(TLRequestMessagesDiscardEncryption(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatAdmin(
            chatId: Int,
            userId: TLAbsInputUser,
            isAdmin: Boolean
    ): TLBool = executeRpcQuerySync(TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatPhoto(chatId: Int, photo: TLAbsInputChatPhoto): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesEditChatPhoto(chatId, photo))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatTitle(chatId: Int, title: String): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesEditChatTitle(chatId, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditInlineBotMessage(
            noWebpage: Boolean,
            id: TLInputBotInlineMessageID,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): TLBool = executeRpcQuerySync(TLRequestMessagesEditInlineBotMessage(noWebpage, id, message, replyMarkup, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditMessage(
            noWebpage: Boolean,
            stopGeoLive: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            geoPoint: TLAbsInputGeoPoint?
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesEditMessage(noWebpage, stopGeoLive, peer, id, message, replyMarkup, entities, geoPoint))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesExportChatInvite(chatId: Int): TLAbsExportedChatInvite = executeRpcQuerySync(TLRequestMessagesExportChatInvite(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesFaveSticker(id: TLAbsInputDocument, unfave: Boolean): TLBool = executeRpcQuerySync(TLRequestMessagesFaveSticker(id, unfave))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesForwardMessage(
            peer: TLAbsInputPeer,
            id: Int,
            randomId: Long
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesForwardMessage(peer, id, randomId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesForwardMessages(silent, background, withMyScore, fromPeer, id, randomId, toPeer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAllChats(exceptIds: TLIntVector): TLAbsChats = executeRpcQuerySync(TLRequestMessagesGetAllChats(exceptIds))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAllDrafts(): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesGetAllDrafts())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAllStickers(hash: Int): TLAbsAllStickers = executeRpcQuerySync(TLRequestMessagesGetAllStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetArchivedStickers(
            masks: Boolean,
            offsetId: Long,
            limit: Int
    ): TLArchivedStickers = executeRpcQuerySync(TLRequestMessagesGetArchivedStickers(masks, offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): TLObjectVector<TLAbsStickerSetCovered> = executeRpcQuerySync(TLRequestMessagesGetAttachedStickers(media))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?
    ): TLBotCallbackAnswer = executeRpcQuerySync(TLRequestMessagesGetBotCallbackAnswer(game, peer, msgId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetChats(id: TLIntVector): TLAbsChats = executeRpcQuerySync(TLRequestMessagesGetChats(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Int,
            limit: Int
    ): TLAbsChats = executeRpcQuerySync(TLRequestMessagesGetCommonChats(userId, maxId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDhConfig(version: Int, randomLength: Int): TLAbsDhConfig = executeRpcQuerySync(TLRequestMessagesGetDhConfig(version, randomLength))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDialogs(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int
    ): TLAbsDialogs = executeRpcQuerySync(TLRequestMessagesGetDialogs(excludePinned, offsetDate, offsetId, offsetPeer, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Int,
            mimeType: String
    ): TLAbsDocument = executeRpcQuerySync(TLRequestMessagesGetDocumentByHash(sha256, size, mimeType))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFavedStickers(hash: Int): TLAbsFavedStickers = executeRpcQuerySync(TLRequestMessagesGetFavedStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFeaturedStickers(hash: Int): TLAbsFeaturedStickers = executeRpcQuerySync(TLRequestMessagesGetFeaturedStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFullChat(chatId: Int): TLChatFull = executeRpcQuerySync(TLRequestMessagesGetFullChat(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): TLHighScores = executeRpcQuerySync(TLRequestMessagesGetGameHighScores(peer, id, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): TLAbsMessages = executeRpcQuerySync(TLRequestMessagesGetHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): TLBotResults = executeRpcQuerySync(TLRequestMessagesGetInlineBotResults(bot, peer, geoPoint, query, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetInlineGameHighScores(id: TLInputBotInlineMessageID, userId: TLAbsInputUser): TLHighScores = executeRpcQuerySync(TLRequestMessagesGetInlineGameHighScores(id, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMaskStickers(hash: Int): TLAbsAllStickers = executeRpcQuerySync(TLRequestMessagesGetMaskStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): TLMessageEditData = executeRpcQuerySync(TLRequestMessagesGetMessageEditData(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessages(id: TLIntVector): TLAbsMessages = executeRpcQuerySync(TLRequestMessagesGetMessages(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): TLIntVector = executeRpcQuerySync(TLRequestMessagesGetMessagesViews(peer, id, increment))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPeerDialogs(peers: TLObjectVector<TLAbsInputPeer>): TLPeerDialogs = executeRpcQuerySync(TLRequestMessagesGetPeerDialogs(peers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPeerSettings(peer: TLAbsInputPeer): TLPeerSettings = executeRpcQuerySync(TLRequestMessagesGetPeerSettings(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPinnedDialogs(): TLPeerDialogs = executeRpcQuerySync(TLRequestMessagesGetPinnedDialogs())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetRecentLocations(peer: TLAbsInputPeer, limit: Int): TLAbsMessages = executeRpcQuerySync(TLRequestMessagesGetRecentLocations(peer, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetRecentStickers(attached: Boolean, hash: Int): TLAbsRecentStickers = executeRpcQuerySync(TLRequestMessagesGetRecentStickers(attached, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSavedGifs(hash: Int): TLAbsSavedGifs = executeRpcQuerySync(TLRequestMessagesGetSavedGifs(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet): TLStickerSet = executeRpcQuerySync(TLRequestMessagesGetStickerSet(stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): TLAbsMessages = executeRpcQuerySync(TLRequestMessagesGetUnreadMentions(peer, offsetId, addOffset, limit, maxId, minId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetWebPage(url: String, hash: Int): TLAbsWebPage = executeRpcQuerySync(TLRequestMessagesGetWebPage(url, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetWebPagePreview(message: String): TLAbsMessageMedia = executeRpcQuerySync(TLRequestMessagesGetWebPagePreview(message))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesHideReportSpam(peer: TLAbsInputPeer): TLBool = executeRpcQuerySync(TLRequestMessagesHideReportSpam(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesImportChatInvite(hash: String): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesImportChatInvite(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): TLAbsStickerSetInstallResult = executeRpcQuerySync(TLRequestMessagesInstallStickerSet(stickerset, archived))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesMigrateChat(chatId: Int): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesMigrateChat(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadEncryptedHistory(peer: TLInputEncryptedChat, maxDate: Int): TLBool = executeRpcQuerySync(TLRequestMessagesReadEncryptedHistory(peer, maxDate))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadFeaturedStickers(id: TLLongVector): TLBool = executeRpcQuerySync(TLRequestMessagesReadFeaturedStickers(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): TLAffectedMessages = executeRpcQuerySync(TLRequestMessagesReadHistory(peer, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadMentions(peer: TLAbsInputPeer): TLAffectedHistory = executeRpcQuerySync(TLRequestMessagesReadMentions(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadMessageContents(id: TLIntVector): TLAffectedMessages = executeRpcQuerySync(TLRequestMessagesReadMessageContents(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReceivedMessages(maxId: Int): TLObjectVector<TLReceivedNotifyMessage> = executeRpcQuerySync(TLRequestMessagesReceivedMessages(maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReceivedQueue(maxQts: Int): TLLongVector = executeRpcQuerySync(TLRequestMessagesReceivedQueue(maxQts))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReorderPinnedDialogs(force: Boolean, order: TLObjectVector<TLAbsInputPeer>): TLBool = executeRpcQuerySync(TLRequestMessagesReorderPinnedDialogs(force, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReorderStickerSets(masks: Boolean, order: TLLongVector): TLBool = executeRpcQuerySync(TLRequestMessagesReorderStickerSets(masks, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReportEncryptedSpam(peer: TLInputEncryptedChat): TLBool = executeRpcQuerySync(TLRequestMessagesReportEncryptedSpam(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReportSpam(peer: TLAbsInputPeer): TLBool = executeRpcQuerySync(TLRequestMessagesReportSpam(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): TLAbsEncryptedChat = executeRpcQuerySync(TLRequestMessagesRequestEncryption(userId, randomId, gA))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveDraft(
            noWebpage: Boolean,
            replyToMsgId: Int?,
            peer: TLAbsInputPeer,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): TLBool = executeRpcQuerySync(TLRequestMessagesSaveDraft(noWebpage, replyToMsgId, peer, message, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveGif(id: TLAbsInputDocument, unsave: Boolean): TLBool = executeRpcQuerySync(TLRequestMessagesSaveGif(id, unsave))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveRecentSticker(
            attached: Boolean,
            id: TLAbsInputDocument,
            unsave: Boolean
    ): TLBool = executeRpcQuerySync(TLRequestMessagesSaveRecentSticker(attached, id, unsave))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearch(
            peer: TLAbsInputPeer,
            q: String,
            fromId: TLAbsInputUser?,
            filter: TLAbsMessagesFilter,
            minDate: Int,
            maxDate: Int,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): TLAbsMessages = executeRpcQuerySync(TLRequestMessagesSearch(peer, q, fromId, filter, minDate, maxDate, offsetId, addOffset, limit, maxId, minId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearchGifs(q: String, offset: Int): TLFoundGifs = executeRpcQuerySync(TLRequestMessagesSearchGifs(q, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearchGlobal(
            q: String,
            offsetDate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): TLAbsMessages = executeRpcQuerySync(TLRequestMessagesSearchGlobal(q, offsetDate, offsetPeer, offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendEncrypted(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): TLAbsSentEncryptedMessage = executeRpcQuerySync(TLRequestMessagesSendEncrypted(peer, randomId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendEncryptedFile(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): TLAbsSentEncryptedMessage = executeRpcQuerySync(TLRequestMessagesSendEncryptedFile(peer, randomId, data, file))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): TLAbsSentEncryptedMessage = executeRpcQuerySync(TLRequestMessagesSendEncryptedService(peer, randomId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendInlineBotResult(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            randomId: Long,
            queryId: Long,
            id: String
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesSendInlineBotResult(silent, background, clearDraft, peer, replyToMsgId, randomId, queryId, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            media: TLAbsInputMedia,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesSendMedia(silent, background, clearDraft, peer, replyToMsgId, media, randomId, replyMarkup))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendMessage(
            noWebpage: Boolean,
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            message: String,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesSendMessage(noWebpage, silent, background, clearDraft, peer, replyToMsgId, message, randomId, replyMarkup, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyToMsgId: Int,
            randomId: Long
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesSendScreenshotNotification(peer, replyToMsgId, randomId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetBotCallbackAnswer(
            alert: Boolean,
            queryId: Long,
            message: String?,
            url: String?,
            cacheTime: Int
    ): TLBool = executeRpcQuerySync(TLRequestMessagesSetBotCallbackAnswer(alert, queryId, message, url, cacheTime))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetBotPrecheckoutResults(
            success: Boolean,
            queryId: Long,
            error: String?
    ): TLBool = executeRpcQuerySync(TLRequestMessagesSetBotPrecheckoutResults(success, queryId, error))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetBotShippingResults(
            queryId: Long,
            error: String?,
            shippingOptions: TLObjectVector<TLShippingOption>?
    ): TLBool = executeRpcQuerySync(TLRequestMessagesSetBotShippingResults(queryId, error, shippingOptions))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetEncryptedTyping(peer: TLInputEncryptedChat, typing: Boolean): TLBool = executeRpcQuerySync(TLRequestMessagesSetEncryptedTyping(peer, typing))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesSetGameScore(editMessage, force, peer, id, userId, score))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetInlineBotResults(
            gallery: Boolean,
            _private: Boolean,
            queryId: Long,
            results: TLObjectVector<TLAbsInputBotInlineResult>,
            cacheTime: Int,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?
    ): TLBool = executeRpcQuerySync(TLRequestMessagesSetInlineBotResults(gallery, _private, queryId, results, cacheTime, nextOffset, switchPm))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetInlineGameScore(
            editMessage: Boolean,
            force: Boolean,
            id: TLInputBotInlineMessageID,
            userId: TLAbsInputUser,
            score: Int
    ): TLBool = executeRpcQuerySync(TLRequestMessagesSetInlineGameScore(editMessage, force, id, userId, score))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetTyping(peer: TLAbsInputPeer, action: TLAbsSendMessageAction): TLBool = executeRpcQuerySync(TLRequestMessagesSetTyping(peer, action))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesStartBot(bot, peer, randomId, startParam))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesToggleChatAdmins(chatId: Int, enabled: Boolean): TLAbsUpdates = executeRpcQuerySync(TLRequestMessagesToggleChatAdmins(chatId, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesToggleDialogPin(pinned: Boolean, peer: TLAbsInputPeer): TLBool = executeRpcQuerySync(TLRequestMessagesToggleDialogPin(pinned, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUninstallStickerSet(stickerset: TLAbsInputStickerSet): TLBool = executeRpcQuerySync(TLRequestMessagesUninstallStickerSet(stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUploadMedia(peer: TLAbsInputPeer, media: TLAbsInputMedia): TLAbsMessageMedia = executeRpcQuerySync(TLRequestMessagesUploadMedia(peer, media))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsClearSavedInfo(credentials: Boolean, info: Boolean): TLBool = executeRpcQuerySync(TLRequestPaymentsClearSavedInfo(credentials, info))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetPaymentForm(msgId: Int): TLPaymentForm = executeRpcQuerySync(TLRequestPaymentsGetPaymentForm(msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetPaymentReceipt(msgId: Int): TLPaymentReceipt = executeRpcQuerySync(TLRequestPaymentsGetPaymentReceipt(msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetSavedInfo(): TLSavedInfo = executeRpcQuerySync(TLRequestPaymentsGetSavedInfo())

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsSendPaymentForm(
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials
    ): TLAbsPaymentResult = executeRpcQuerySync(TLRequestPaymentsSendPaymentForm(msgId, requestedInfoId, shippingOptionId, credentials))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsValidateRequestedInfo(
            save: Boolean,
            msgId: Int,
            info: TLPaymentRequestedInfo
    ): TLValidatedRequestedInfo = executeRpcQuerySync(TLRequestPaymentsValidateRequestedInfo(save, msgId, info))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall = executeRpcQuerySync(TLRequestPhoneAcceptCall(peer, gB, protocol))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall = executeRpcQuerySync(TLRequestPhoneConfirmCall(peer, gA, keyFingerprint, protocol))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneDiscardCall(
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestPhoneDiscardCall(peer, duration, reason, connectionId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneGetCallConfig(): TLDataJSON = executeRpcQuerySync(TLRequestPhoneGetCallConfig())

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneReceivedCall(peer: TLInputPhoneCall): TLBool = executeRpcQuerySync(TLRequestPhoneReceivedCall(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneRequestCall(
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall = executeRpcQuerySync(TLRequestPhoneRequestCall(userId, randomId, gAHash, protocol))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneSaveCallDebug(peer: TLInputPhoneCall, debug: TLDataJSON): TLBool = executeRpcQuerySync(TLRequestPhoneSaveCallDebug(peer, debug))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneSetCallRating(
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): TLAbsUpdates = executeRpcQuerySync(TLRequestPhoneSetCallRating(peer, rating, comment))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): TLLongVector = executeRpcQuerySync(TLRequestPhotosDeletePhotos(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): TLAbsPhotos = executeRpcQuerySync(TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosUpdateProfilePhoto(id: TLAbsInputPhoto): TLAbsUserProfilePhoto = executeRpcQuerySync(TLRequestPhotosUpdateProfilePhoto(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosUploadProfilePhoto(file: TLAbsInputFile): TLPhoto = executeRpcQuerySync(TLRequestPhotosUploadProfilePhoto(file))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): TLStickerSet = executeRpcQuerySync(TLRequestStickersAddStickerToSet(stickerset, sticker))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): TLStickerSet = executeRpcQuerySync(TLRequestStickersChangeStickerPosition(sticker, position))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersCreateStickerSet(
            masks: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            stickers: TLObjectVector<TLInputStickerSetItem>
    ): TLStickerSet = executeRpcQuerySync(TLRequestStickersCreateStickerSet(masks, userId, title, shortName, stickers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): TLStickerSet = executeRpcQuerySync(TLRequestStickersRemoveStickerFromSet(sticker))

    @Throws(RpcErrorException::class, IOException::class)
    override fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): TLAbsChannelDifference = executeRpcQuerySync(TLRequestUpdatesGetChannelDifference(force, channel, filter, pts, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun updatesGetDifference(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ): TLAbsDifference = executeRpcQuerySync(TLRequestUpdatesGetDifference(pts, ptsTotalLimit, date, qts))

    @Throws(RpcErrorException::class, IOException::class)
    override fun updatesGetState(): TLState = executeRpcQuerySync(TLRequestUpdatesGetState())

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Int,
            limit: Int
    ): TLAbsCdnFile = executeRpcQuerySync(TLRequestUploadGetCdnFile(fileToken, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Int): TLObjectVector<TLCdnFileHash> = executeRpcQuerySync(TLRequestUploadGetCdnFileHashes(fileToken, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetFile(
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ): TLAbsFile = executeRpcQuerySync(TLRequestUploadGetFile(location, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetWebFile(
            location: TLInputWebFileLocation,
            offset: Int,
            limit: Int
    ): TLWebFile = executeRpcQuerySync(TLRequestUploadGetWebFile(location, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): TLObjectVector<TLCdnFileHash> = executeRpcQuerySync(TLRequestUploadReuploadCdnFile(fileToken, requestToken))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadSaveBigFilePart(
            fileId: Long,
            filePart: Int,
            fileTotalParts: Int,
            bytes: TLBytes
    ): TLBool = executeRpcQuerySync(TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadSaveFilePart(
            fileId: Long,
            filePart: Int,
            bytes: TLBytes
    ): TLBool = executeRpcQuerySync(TLRequestUploadSaveFilePart(fileId, filePart, bytes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun usersGetFullUser(id: TLAbsInputUser): TLUserFull = executeRpcQuerySync(TLRequestUsersGetFullUser(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): TLObjectVector<TLAbsUser> = executeRpcQuerySync(TLRequestUsersGetUsers(id))
}
