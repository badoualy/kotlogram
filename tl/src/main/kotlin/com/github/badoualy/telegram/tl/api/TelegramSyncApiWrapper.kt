package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.RpcQuerySyncExecutor
import com.github.badoualy.telegram.tl.api.account.*
import com.github.badoualy.telegram.tl.api.auth.*
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization
import com.github.badoualy.telegram.tl.api.channels.TLAdminLogResults
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipants
import com.github.badoualy.telegram.tl.api.contacts.*
import com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate
import com.github.badoualy.telegram.tl.api.help.TLInviteText
import com.github.badoualy.telegram.tl.api.help.TLSupport
import com.github.badoualy.telegram.tl.api.help.TLTermsOfService
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
    ): TLAbsUser = executeMethod(TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountCheckUsername(username: String): TLBool = executeMethod(TLRequestAccountCheckUsername(username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountConfirmPhone(phoneCodeHash: String, phoneCode: String): TLBool = executeMethod(TLRequestAccountConfirmPhone(phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountDeleteAccount(reason: String): TLBool = executeMethod(TLRequestAccountDeleteAccount(reason))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAccountTTL(): TLAccountDaysTTL = executeMethod(TLRequestAccountGetAccountTTL())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAuthorizations(): TLAuthorizations = executeMethod(TLRequestAccountGetAuthorizations())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): TLAbsPeerNotifySettings = executeMethod(TLRequestAccountGetNotifySettings(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetPassword(): TLAbsPassword = executeMethod(TLRequestAccountGetPassword())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetPasswordSettings(currentPasswordHash: TLBytes): TLPasswordSettings = executeMethod(TLRequestAccountGetPasswordSettings(currentPasswordHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetPrivacy(key: TLAbsInputPrivacyKey): TLPrivacyRules = executeMethod(TLRequestAccountGetPrivacy(key))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetTmpPassword(passwordHash: TLBytes, period: Int): TLTmpPassword = executeMethod(TLRequestAccountGetTmpPassword(passwordHash, period))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetWallPapers(): TLObjectVector<TLAbsWallPaper> = executeMethod(TLRequestAccountGetWallPapers())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountRegisterDevice(tokenType: Int, token: String): TLBool = executeMethod(TLRequestAccountRegisterDevice(tokenType, token))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountReportPeer(peer: TLAbsInputPeer, reason: TLAbsReportReason): TLBool = executeMethod(TLRequestAccountReportPeer(peer, reason))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetAuthorization(hash: Long): TLBool = executeMethod(TLRequestAccountResetAuthorization(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetNotifySettings(): TLBool = executeMethod(TLRequestAccountResetNotifySettings())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSendChangePhoneCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?
    ): TLSentCode = executeMethod(TLRequestAccountSendChangePhoneCode(allowFlashcall, phoneNumber, currentNumber))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSendConfirmPhoneCode(
            allowFlashcall: Boolean,
            hash: String,
            currentNumber: Boolean?
    ): TLSentCode = executeMethod(TLRequestAccountSendConfirmPhoneCode(allowFlashcall, hash, currentNumber))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetAccountTTL(ttl: TLAccountDaysTTL): TLBool = executeMethod(TLRequestAccountSetAccountTTL(ttl))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): TLPrivacyRules = executeMethod(TLRequestAccountSetPrivacy(key, rules))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUnregisterDevice(tokenType: Int, token: String): TLBool = executeMethod(TLRequestAccountUnregisterDevice(tokenType, token))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateDeviceLocked(period: Int): TLBool = executeMethod(TLRequestAccountUpdateDeviceLocked(period))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateNotifySettings(peer: TLAbsInputNotifyPeer, settings: TLInputPeerNotifySettings): TLBool = executeMethod(TLRequestAccountUpdateNotifySettings(peer, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdatePasswordSettings(currentPasswordHash: TLBytes, newSettings: TLPasswordInputSettings): TLBool = executeMethod(TLRequestAccountUpdatePasswordSettings(currentPasswordHash, newSettings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): TLAbsUser = executeMethod(TLRequestAccountUpdateProfile(firstName, lastName, about))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateStatus(offline: Boolean): TLBool = executeMethod(TLRequestAccountUpdateStatus(offline))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateUsername(username: String): TLAbsUser = executeMethod(TLRequestAccountUpdateUsername(username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authBindTempAuthKey(
            permAuthKeyId: Long,
            nonce: Long,
            expiresAt: Int,
            encryptedMessage: TLBytes
    ): TLBool = executeMethod(TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authCancelCode(phoneNumber: String, phoneCodeHash: String): TLBool = executeMethod(TLRequestAuthCancelCode(phoneNumber, phoneCodeHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authCheckPassword(passwordHash: TLBytes): TLAuthorization = executeMethod(TLRequestAuthCheckPassword(passwordHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authCheckPhone(phoneNumber: String): TLCheckedPhone = executeMethod(TLRequestAuthCheckPhone(phoneNumber))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authDropTempAuthKeys(exceptAuthKeys: TLLongVector): TLBool = executeMethod(TLRequestAuthDropTempAuthKeys(exceptAuthKeys))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authExportAuthorization(dcId: Int): TLExportedAuthorization = executeMethod(TLRequestAuthExportAuthorization(dcId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authImportAuthorization(id: Int, bytes: TLBytes): TLAuthorization = executeMethod(TLRequestAuthImportAuthorization(id, bytes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): TLAuthorization = executeMethod(TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authLogOut(): TLBool = executeMethod(TLRequestAuthLogOut())

    @Throws(RpcErrorException::class, IOException::class)
    override fun authRecoverPassword(code: String): TLAuthorization = executeMethod(TLRequestAuthRecoverPassword(code))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authRequestPasswordRecovery(): TLPasswordRecovery = executeMethod(TLRequestAuthRequestPasswordRecovery())

    @Throws(RpcErrorException::class, IOException::class)
    override fun authResendCode(phoneNumber: String, phoneCodeHash: String): TLSentCode = executeMethod(TLRequestAuthResendCode(phoneNumber, phoneCodeHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authResetAuthorizations(): TLBool = executeMethod(TLRequestAuthResetAuthorizations())

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSendCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?,
            apiId: Int,
            apiHash: String
    ): TLSentCode = executeMethod(TLRequestAuthSendCode(allowFlashcall, phoneNumber, currentNumber, apiId, apiHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSendInvites(phoneNumbers: TLStringVector, message: String): TLBool = executeMethod(TLRequestAuthSendInvites(phoneNumbers, message))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): TLAuthorization = executeMethod(TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String,
            firstName: String,
            lastName: String
    ): TLAuthorization = executeMethod(TLRequestAuthSignUp(phoneNumber, phoneCodeHash, phoneCode, firstName, lastName))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsAnswerWebhookJSONQuery(queryId: Long, data: TLDataJSON): TLBool = executeMethod(TLRequestBotsAnswerWebhookJSONQuery(queryId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): TLDataJSON = executeMethod(TLRequestBotsSendCustomRequest(customMethod, params))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsCheckUsername(channel: TLAbsInputChannel, username: String): TLBool = executeMethod(TLRequestChannelsCheckUsername(channel, username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            title: String,
            about: String
    ): TLAbsUpdates = executeMethod(TLRequestChannelsCreateChannel(broadcast, megagroup, title, about))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteChannel(channel: TLAbsInputChannel): TLAbsUpdates = executeMethod(TLRequestChannelsDeleteChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): TLAffectedMessages = executeMethod(TLRequestChannelsDeleteMessages(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteUserHistory(channel: TLAbsInputChannel, userId: TLAbsInputUser): TLAffectedHistory = executeMethod(TLRequestChannelsDeleteUserHistory(channel, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditAbout(channel: TLAbsInputChannel, about: String): TLBool = executeMethod(TLRequestChannelsEditAbout(channel, about))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChannelAdminRights
    ): TLAbsUpdates = executeMethod(TLRequestChannelsEditAdmin(channel, userId, adminRights))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditBanned(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            bannedRights: TLChannelBannedRights
    ): TLAbsUpdates = executeMethod(TLRequestChannelsEditBanned(channel, userId, bannedRights))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): TLAbsUpdates = executeMethod(TLRequestChannelsEditPhoto(channel, photo))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditTitle(channel: TLAbsInputChannel, title: String): TLAbsUpdates = executeMethod(TLRequestChannelsEditTitle(channel, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsExportInvite(channel: TLAbsInputChannel): TLAbsExportedChatInvite = executeMethod(TLRequestChannelsExportInvite(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsExportMessageLink(channel: TLAbsInputChannel, id: Int): TLExportedMessageLink = executeMethod(TLRequestChannelsExportMessageLink(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): TLAdminLogResults = executeMethod(TLRequestChannelsGetAdminLog(channel, q, eventsFilter, admins, maxId, minId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetAdminedPublicChannels(): TLAbsChats = executeMethod(TLRequestChannelsGetAdminedPublicChannels())

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): TLAbsChats = executeMethod(TLRequestChannelsGetChannels(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetFullChannel(channel: TLAbsInputChannel): TLChatFull = executeMethod(TLRequestChannelsGetFullChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetMessages(channel: TLAbsInputChannel, id: TLIntVector): TLAbsMessages = executeMethod(TLRequestChannelsGetMessages(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetParticipant(channel: TLAbsInputChannel, userId: TLAbsInputUser): TLChannelParticipant = executeMethod(TLRequestChannelsGetParticipant(channel, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int
    ): TLChannelParticipants = executeMethod(TLRequestChannelsGetParticipants(channel, filter, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): TLAbsUpdates = executeMethod(TLRequestChannelsInviteToChannel(channel, users))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsJoinChannel(channel: TLAbsInputChannel): TLAbsUpdates = executeMethod(TLRequestChannelsJoinChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsLeaveChannel(channel: TLAbsInputChannel): TLAbsUpdates = executeMethod(TLRequestChannelsLeaveChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReadHistory(channel: TLAbsInputChannel, maxId: Int): TLBool = executeMethod(TLRequestChannelsReadHistory(channel, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReadMessageContents(channel: TLAbsInputChannel, id: TLIntVector): TLBool = executeMethod(TLRequestChannelsReadMessageContents(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReportSpam(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            id: TLIntVector
    ): TLBool = executeMethod(TLRequestChannelsReportSpam(channel, userId, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsSetStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): TLBool = executeMethod(TLRequestChannelsSetStickers(channel, stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleInvites(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsToggleInvites(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsToggleSignatures(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsUpdatePinnedMessage(
            silent: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): TLAbsUpdates = executeMethod(TLRequestChannelsUpdatePinnedMessage(silent, channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsUpdateUsername(channel: TLAbsInputChannel, username: String): TLBool = executeMethod(TLRequestChannelsUpdateUsername(channel, username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsBlock(id: TLAbsInputUser): TLBool = executeMethod(TLRequestContactsBlock(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsDeleteContact(id: TLAbsInputUser): TLLink = executeMethod(TLRequestContactsDeleteContact(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsDeleteContacts(id: TLObjectVector<TLAbsInputUser>): TLBool = executeMethod(TLRequestContactsDeleteContacts(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsExportCard(): TLIntVector = executeMethod(TLRequestContactsExportCard())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetBlocked(offset: Int, limit: Int): TLAbsBlocked = executeMethod(TLRequestContactsGetBlocked(offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetContacts(hash: Int): TLAbsContacts = executeMethod(TLRequestContactsGetContacts(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetStatuses(): TLObjectVector<TLContactStatus> = executeMethod(TLRequestContactsGetStatuses())

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
    ): TLAbsTopPeers = executeMethod(TLRequestContactsGetTopPeers(correspondents, botsPm, botsInline, phoneCalls, groups, channels, offset, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsImportCard(exportCard: TLIntVector): TLAbsUser = executeMethod(TLRequestContactsImportCard(exportCard))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): TLImportedContacts = executeMethod(TLRequestContactsImportContacts(contacts))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResetSaved(): TLBool = executeMethod(TLRequestContactsResetSaved())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResetTopPeerRating(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestContactsResetTopPeerRating(category, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResolveUsername(username: String): TLResolvedPeer = executeMethod(TLRequestContactsResolveUsername(username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsSearch(q: String, limit: Int): TLFound = executeMethod(TLRequestContactsSearch(q, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsUnblock(id: TLAbsInputUser): TLBool = executeMethod(TLRequestContactsUnblock(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetAppChangelog(prevAppVersion: String): TLAbsUpdates = executeMethod(TLRequestHelpGetAppChangelog(prevAppVersion))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetAppUpdate(): TLAbsAppUpdate = executeMethod(TLRequestHelpGetAppUpdate())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetCdnConfig(): TLCdnConfig = executeMethod(TLRequestHelpGetCdnConfig())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetConfig(): TLConfig = executeMethod(TLRequestHelpGetConfig())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetInviteText(): TLInviteText = executeMethod(TLRequestHelpGetInviteText())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetNearestDc(): TLNearestDc = executeMethod(TLRequestHelpGetNearestDc())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetSupport(): TLSupport = executeMethod(TLRequestHelpGetSupport())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetTermsOfService(): TLTermsOfService = executeMethod(TLRequestHelpGetTermsOfService())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpSaveAppLog(events: TLObjectVector<TLInputAppEvent>): TLBool = executeMethod(TLRequestHelpSaveAppLog(events))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpSetBotUpdatesStatus(pendingUpdatesCount: Int, message: String): TLBool = executeMethod(TLRequestHelpSetBotUpdatesStatus(pendingUpdatesCount, message))

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
    ): T = executeMethod(TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, systemLangCode, langPack, langCode, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeAfterMsg(msgId, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeAfterMsgs(msgIds, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeWithLayer(layer, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>?): T = executeMethod(TLRequestInvokeWithoutUpdates(query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetDifference(fromVersion: Int): TLLangPackDifference = executeMethod(TLRequestLangpackGetDifference(fromVersion))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetLangPack(langCode: String): TLLangPackDifference = executeMethod(TLRequestLangpackGetLangPack(langCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetLanguages(): TLObjectVector<TLLangPackLanguage> = executeMethod(TLRequestLangpackGetLanguages())

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetStrings(langCode: String, keys: TLStringVector): TLObjectVector<TLAbsLangPackString> = executeMethod(TLRequestLangpackGetStrings(langCode, keys))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): TLAbsEncryptedChat = executeMethod(TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesAddChatUser(
            chatId: Int,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): TLAbsUpdates = executeMethod(TLRequestMessagesAddChatUser(chatId, userId, fwdLimit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesCheckChatInvite(hash: String): TLAbsChatInvite = executeMethod(TLRequestMessagesCheckChatInvite(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesClearRecentStickers(attached: Boolean): TLBool = executeMethod(TLRequestMessagesClearRecentStickers(attached))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesCreateChat(users: TLObjectVector<TLAbsInputUser>, title: String): TLAbsUpdates = executeMethod(TLRequestMessagesCreateChat(users, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteChatUser(chatId: Int, userId: TLAbsInputUser): TLAbsUpdates = executeMethod(TLRequestMessagesDeleteChatUser(chatId, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteHistory(
            justClear: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int
    ): TLAffectedHistory = executeMethod(TLRequestMessagesDeleteHistory(justClear, peer, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): TLAffectedMessages = executeMethod(TLRequestMessagesDeleteMessages(revoke, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDiscardEncryption(chatId: Int): TLBool = executeMethod(TLRequestMessagesDiscardEncryption(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatAdmin(
            chatId: Int,
            userId: TLAbsInputUser,
            isAdmin: Boolean
    ): TLBool = executeMethod(TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatPhoto(chatId: Int, photo: TLAbsInputChatPhoto): TLAbsUpdates = executeMethod(TLRequestMessagesEditChatPhoto(chatId, photo))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatTitle(chatId: Int, title: String): TLAbsUpdates = executeMethod(TLRequestMessagesEditChatTitle(chatId, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditInlineBotMessage(
            noWebpage: Boolean,
            id: TLInputBotInlineMessageID,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): TLBool = executeMethod(TLRequestMessagesEditInlineBotMessage(noWebpage, id, message, replyMarkup, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditMessage(
            noWebpage: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): TLAbsUpdates = executeMethod(TLRequestMessagesEditMessage(noWebpage, peer, id, message, replyMarkup, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesExportChatInvite(chatId: Int): TLAbsExportedChatInvite = executeMethod(TLRequestMessagesExportChatInvite(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesFaveSticker(id: TLAbsInputDocument, unfave: Boolean): TLBool = executeMethod(TLRequestMessagesFaveSticker(id, unfave))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesForwardMessage(
            peer: TLAbsInputPeer,
            id: Int,
            randomId: Long
    ): TLAbsUpdates = executeMethod(TLRequestMessagesForwardMessage(peer, id, randomId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer
    ): TLAbsUpdates = executeMethod(TLRequestMessagesForwardMessages(silent, background, withMyScore, fromPeer, id, randomId, toPeer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAllChats(exceptIds: TLIntVector): TLAbsChats = executeMethod(TLRequestMessagesGetAllChats(exceptIds))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAllDrafts(): TLAbsUpdates = executeMethod(TLRequestMessagesGetAllDrafts())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAllStickers(hash: Int): TLAbsAllStickers = executeMethod(TLRequestMessagesGetAllStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetArchivedStickers(
            masks: Boolean,
            offsetId: Long,
            limit: Int
    ): TLArchivedStickers = executeMethod(TLRequestMessagesGetArchivedStickers(masks, offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): TLObjectVector<TLAbsStickerSetCovered> = executeMethod(TLRequestMessagesGetAttachedStickers(media))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?
    ): TLBotCallbackAnswer = executeMethod(TLRequestMessagesGetBotCallbackAnswer(game, peer, msgId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetChats(id: TLIntVector): TLAbsChats = executeMethod(TLRequestMessagesGetChats(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Int,
            limit: Int
    ): TLAbsChats = executeMethod(TLRequestMessagesGetCommonChats(userId, maxId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDhConfig(version: Int, randomLength: Int): TLAbsDhConfig = executeMethod(TLRequestMessagesGetDhConfig(version, randomLength))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDialogs(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int
    ): TLAbsDialogs = executeMethod(TLRequestMessagesGetDialogs(excludePinned, offsetDate, offsetId, offsetPeer, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Int,
            mimeType: String
    ): TLAbsDocument = executeMethod(TLRequestMessagesGetDocumentByHash(sha256, size, mimeType))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFavedStickers(hash: Int): TLAbsFavedStickers = executeMethod(TLRequestMessagesGetFavedStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFeaturedStickers(hash: Int): TLAbsFeaturedStickers = executeMethod(TLRequestMessagesGetFeaturedStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFullChat(chatId: Int): TLChatFull = executeMethod(TLRequestMessagesGetFullChat(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): TLHighScores = executeMethod(TLRequestMessagesGetGameHighScores(peer, id, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): TLAbsMessages = executeMethod(TLRequestMessagesGetHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): TLBotResults = executeMethod(TLRequestMessagesGetInlineBotResults(bot, peer, geoPoint, query, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetInlineGameHighScores(id: TLInputBotInlineMessageID, userId: TLAbsInputUser): TLHighScores = executeMethod(TLRequestMessagesGetInlineGameHighScores(id, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMaskStickers(hash: Int): TLAbsAllStickers = executeMethod(TLRequestMessagesGetMaskStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): TLMessageEditData = executeMethod(TLRequestMessagesGetMessageEditData(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessages(id: TLIntVector): TLAbsMessages = executeMethod(TLRequestMessagesGetMessages(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): TLIntVector = executeMethod(TLRequestMessagesGetMessagesViews(peer, id, increment))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPeerDialogs(peers: TLObjectVector<TLAbsInputPeer>): TLPeerDialogs = executeMethod(TLRequestMessagesGetPeerDialogs(peers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPeerSettings(peer: TLAbsInputPeer): TLPeerSettings = executeMethod(TLRequestMessagesGetPeerSettings(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPinnedDialogs(): TLPeerDialogs = executeMethod(TLRequestMessagesGetPinnedDialogs())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetRecentStickers(attached: Boolean, hash: Int): TLAbsRecentStickers = executeMethod(TLRequestMessagesGetRecentStickers(attached, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSavedGifs(hash: Int): TLAbsSavedGifs = executeMethod(TLRequestMessagesGetSavedGifs(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet): TLStickerSet = executeMethod(TLRequestMessagesGetStickerSet(stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): TLAbsMessages = executeMethod(TLRequestMessagesGetUnreadMentions(peer, offsetId, addOffset, limit, maxId, minId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetWebPage(url: String, hash: Int): TLAbsWebPage = executeMethod(TLRequestMessagesGetWebPage(url, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetWebPagePreview(message: String): TLAbsMessageMedia = executeMethod(TLRequestMessagesGetWebPagePreview(message))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesHideReportSpam(peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestMessagesHideReportSpam(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesImportChatInvite(hash: String): TLAbsUpdates = executeMethod(TLRequestMessagesImportChatInvite(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): TLAbsStickerSetInstallResult = executeMethod(TLRequestMessagesInstallStickerSet(stickerset, archived))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesMigrateChat(chatId: Int): TLAbsUpdates = executeMethod(TLRequestMessagesMigrateChat(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadEncryptedHistory(peer: TLInputEncryptedChat, maxDate: Int): TLBool = executeMethod(TLRequestMessagesReadEncryptedHistory(peer, maxDate))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadFeaturedStickers(id: TLLongVector): TLBool = executeMethod(TLRequestMessagesReadFeaturedStickers(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): TLAffectedMessages = executeMethod(TLRequestMessagesReadHistory(peer, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadMessageContents(id: TLIntVector): TLAffectedMessages = executeMethod(TLRequestMessagesReadMessageContents(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReceivedMessages(maxId: Int): TLObjectVector<TLReceivedNotifyMessage> = executeMethod(TLRequestMessagesReceivedMessages(maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReceivedQueue(maxQts: Int): TLLongVector = executeMethod(TLRequestMessagesReceivedQueue(maxQts))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReorderPinnedDialogs(force: Boolean, order: TLObjectVector<TLAbsInputPeer>): TLBool = executeMethod(TLRequestMessagesReorderPinnedDialogs(force, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReorderStickerSets(masks: Boolean, order: TLLongVector): TLBool = executeMethod(TLRequestMessagesReorderStickerSets(masks, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReportEncryptedSpam(peer: TLInputEncryptedChat): TLBool = executeMethod(TLRequestMessagesReportEncryptedSpam(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReportSpam(peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestMessagesReportSpam(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): TLAbsEncryptedChat = executeMethod(TLRequestMessagesRequestEncryption(userId, randomId, gA))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveDraft(
            noWebpage: Boolean,
            replyToMsgId: Int?,
            peer: TLAbsInputPeer,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): TLBool = executeMethod(TLRequestMessagesSaveDraft(noWebpage, replyToMsgId, peer, message, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveGif(id: TLAbsInputDocument, unsave: Boolean): TLBool = executeMethod(TLRequestMessagesSaveGif(id, unsave))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveRecentSticker(
            attached: Boolean,
            id: TLAbsInputDocument,
            unsave: Boolean
    ): TLBool = executeMethod(TLRequestMessagesSaveRecentSticker(attached, id, unsave))

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
    ): TLAbsMessages = executeMethod(TLRequestMessagesSearch(peer, q, fromId, filter, minDate, maxDate, offsetId, addOffset, limit, maxId, minId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearchGifs(q: String, offset: Int): TLFoundGifs = executeMethod(TLRequestMessagesSearchGifs(q, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearchGlobal(
            q: String,
            offsetDate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): TLAbsMessages = executeMethod(TLRequestMessagesSearchGlobal(q, offsetDate, offsetPeer, offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendEncrypted(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): TLAbsSentEncryptedMessage = executeMethod(TLRequestMessagesSendEncrypted(peer, randomId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendEncryptedFile(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): TLAbsSentEncryptedMessage = executeMethod(TLRequestMessagesSendEncryptedFile(peer, randomId, data, file))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): TLAbsSentEncryptedMessage = executeMethod(TLRequestMessagesSendEncryptedService(peer, randomId, data))

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
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendInlineBotResult(silent, background, clearDraft, peer, replyToMsgId, randomId, queryId, id))

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
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendMedia(silent, background, clearDraft, peer, replyToMsgId, media, randomId, replyMarkup))

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
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendMessage(noWebpage, silent, background, clearDraft, peer, replyToMsgId, message, randomId, replyMarkup, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyToMsgId: Int,
            randomId: Long
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendScreenshotNotification(peer, replyToMsgId, randomId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetBotCallbackAnswer(
            alert: Boolean,
            queryId: Long,
            message: String?,
            url: String?,
            cacheTime: Int
    ): TLBool = executeMethod(TLRequestMessagesSetBotCallbackAnswer(alert, queryId, message, url, cacheTime))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetBotPrecheckoutResults(
            success: Boolean,
            queryId: Long,
            error: String?
    ): TLBool = executeMethod(TLRequestMessagesSetBotPrecheckoutResults(success, queryId, error))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetBotShippingResults(
            queryId: Long,
            error: String?,
            shippingOptions: TLObjectVector<TLShippingOption>?
    ): TLBool = executeMethod(TLRequestMessagesSetBotShippingResults(queryId, error, shippingOptions))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetEncryptedTyping(peer: TLInputEncryptedChat, typing: Boolean): TLBool = executeMethod(TLRequestMessagesSetEncryptedTyping(peer, typing))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSetGameScore(editMessage, force, peer, id, userId, score))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetInlineBotResults(
            gallery: Boolean,
            _private: Boolean,
            queryId: Long,
            results: TLObjectVector<TLAbsInputBotInlineResult>,
            cacheTime: Int,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?
    ): TLBool = executeMethod(TLRequestMessagesSetInlineBotResults(gallery, _private, queryId, results, cacheTime, nextOffset, switchPm))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetInlineGameScore(
            editMessage: Boolean,
            force: Boolean,
            id: TLInputBotInlineMessageID,
            userId: TLAbsInputUser,
            score: Int
    ): TLBool = executeMethod(TLRequestMessagesSetInlineGameScore(editMessage, force, id, userId, score))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetTyping(peer: TLAbsInputPeer, action: TLAbsSendMessageAction): TLBool = executeMethod(TLRequestMessagesSetTyping(peer, action))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): TLAbsUpdates = executeMethod(TLRequestMessagesStartBot(bot, peer, randomId, startParam))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesToggleChatAdmins(chatId: Int, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestMessagesToggleChatAdmins(chatId, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesToggleDialogPin(pinned: Boolean, peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestMessagesToggleDialogPin(pinned, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUninstallStickerSet(stickerset: TLAbsInputStickerSet): TLBool = executeMethod(TLRequestMessagesUninstallStickerSet(stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUploadMedia(peer: TLAbsInputPeer, media: TLAbsInputMedia): TLAbsMessageMedia = executeMethod(TLRequestMessagesUploadMedia(peer, media))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsClearSavedInfo(credentials: Boolean, info: Boolean): TLBool = executeMethod(TLRequestPaymentsClearSavedInfo(credentials, info))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetPaymentForm(msgId: Int): TLPaymentForm = executeMethod(TLRequestPaymentsGetPaymentForm(msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetPaymentReceipt(msgId: Int): TLPaymentReceipt = executeMethod(TLRequestPaymentsGetPaymentReceipt(msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetSavedInfo(): TLSavedInfo = executeMethod(TLRequestPaymentsGetSavedInfo())

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsSendPaymentForm(
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials
    ): TLAbsPaymentResult = executeMethod(TLRequestPaymentsSendPaymentForm(msgId, requestedInfoId, shippingOptionId, credentials))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsValidateRequestedInfo(
            save: Boolean,
            msgId: Int,
            info: TLPaymentRequestedInfo
    ): TLValidatedRequestedInfo = executeMethod(TLRequestPaymentsValidateRequestedInfo(save, msgId, info))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall = executeMethod(TLRequestPhoneAcceptCall(peer, gB, protocol))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall = executeMethod(TLRequestPhoneConfirmCall(peer, gA, keyFingerprint, protocol))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneDiscardCall(
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): TLAbsUpdates = executeMethod(TLRequestPhoneDiscardCall(peer, duration, reason, connectionId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneGetCallConfig(): TLDataJSON = executeMethod(TLRequestPhoneGetCallConfig())

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneReceivedCall(peer: TLInputPhoneCall): TLBool = executeMethod(TLRequestPhoneReceivedCall(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneRequestCall(
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall = executeMethod(TLRequestPhoneRequestCall(userId, randomId, gAHash, protocol))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneSaveCallDebug(peer: TLInputPhoneCall, debug: TLDataJSON): TLBool = executeMethod(TLRequestPhoneSaveCallDebug(peer, debug))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneSetCallRating(
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): TLAbsUpdates = executeMethod(TLRequestPhoneSetCallRating(peer, rating, comment))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): TLLongVector = executeMethod(TLRequestPhotosDeletePhotos(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): TLAbsPhotos = executeMethod(TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosUpdateProfilePhoto(id: TLAbsInputPhoto): TLAbsUserProfilePhoto = executeMethod(TLRequestPhotosUpdateProfilePhoto(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosUploadProfilePhoto(file: TLAbsInputFile): TLPhoto = executeMethod(TLRequestPhotosUploadProfilePhoto(file))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): TLStickerSet = executeMethod(TLRequestStickersAddStickerToSet(stickerset, sticker))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): TLStickerSet = executeMethod(TLRequestStickersChangeStickerPosition(sticker, position))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersCreateStickerSet(
            masks: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            stickers: TLObjectVector<TLInputStickerSetItem>
    ): TLStickerSet = executeMethod(TLRequestStickersCreateStickerSet(masks, userId, title, shortName, stickers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): TLStickerSet = executeMethod(TLRequestStickersRemoveStickerFromSet(sticker))

    @Throws(RpcErrorException::class, IOException::class)
    override fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): TLAbsChannelDifference = executeMethod(TLRequestUpdatesGetChannelDifference(force, channel, filter, pts, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun updatesGetDifference(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ): TLAbsDifference = executeMethod(TLRequestUpdatesGetDifference(pts, ptsTotalLimit, date, qts))

    @Throws(RpcErrorException::class, IOException::class)
    override fun updatesGetState(): TLState = executeMethod(TLRequestUpdatesGetState())

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Int,
            limit: Int
    ): TLAbsCdnFile = executeMethod(TLRequestUploadGetCdnFile(fileToken, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Int): TLObjectVector<TLCdnFileHash> = executeMethod(TLRequestUploadGetCdnFileHashes(fileToken, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetFile(
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ): TLAbsFile = executeMethod(TLRequestUploadGetFile(location, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetWebFile(
            location: TLInputWebFileLocation,
            offset: Int,
            limit: Int
    ): TLWebFile = executeMethod(TLRequestUploadGetWebFile(location, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): TLObjectVector<TLCdnFileHash> = executeMethod(TLRequestUploadReuploadCdnFile(fileToken, requestToken))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadSaveBigFilePart(
            fileId: Long,
            filePart: Int,
            fileTotalParts: Int,
            bytes: TLBytes
    ): TLBool = executeMethod(TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadSaveFilePart(
            fileId: Long,
            filePart: Int,
            bytes: TLBytes
    ): TLBool = executeMethod(TLRequestUploadSaveFilePart(fileId, filePart, bytes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun usersGetFullUser(id: TLAbsInputUser): TLUserFull = executeMethod(TLRequestUsersGetFullUser(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): TLObjectVector<TLAbsUser> = executeMethod(TLRequestUsersGetUsers(id))
}
