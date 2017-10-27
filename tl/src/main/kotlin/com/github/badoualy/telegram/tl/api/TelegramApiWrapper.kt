package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.RpcQueryExecutor
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
import io.reactivex.Single

abstract class TelegramApiWrapper : TelegramApi, RpcQueryExecutor {
    override fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAbsUser> = executeRpcQuery(TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode))

    override fun accountCheckUsername(username: String): Single<TLBool> = executeRpcQuery(TLRequestAccountCheckUsername(username))

    override fun accountConfirmPhone(phoneCodeHash: String, phoneCode: String): Single<TLBool> = executeRpcQuery(TLRequestAccountConfirmPhone(phoneCodeHash, phoneCode))

    override fun accountDeleteAccount(reason: String): Single<TLBool> = executeRpcQuery(TLRequestAccountDeleteAccount(reason))

    override fun accountGetAccountTTL(): Single<TLAccountDaysTTL> = executeRpcQuery(TLRequestAccountGetAccountTTL())

    override fun accountGetAuthorizations(): Single<TLAuthorizations> = executeRpcQuery(TLRequestAccountGetAuthorizations())

    override fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): Single<TLAbsPeerNotifySettings> = executeRpcQuery(TLRequestAccountGetNotifySettings(peer))

    override fun accountGetPassword(): Single<TLAbsPassword> = executeRpcQuery(TLRequestAccountGetPassword())

    override fun accountGetPasswordSettings(currentPasswordHash: TLBytes): Single<TLPasswordSettings> = executeRpcQuery(TLRequestAccountGetPasswordSettings(currentPasswordHash))

    override fun accountGetPrivacy(key: TLAbsInputPrivacyKey): Single<TLPrivacyRules> = executeRpcQuery(TLRequestAccountGetPrivacy(key))

    override fun accountGetTmpPassword(passwordHash: TLBytes, period: Int): Single<TLTmpPassword> = executeRpcQuery(TLRequestAccountGetTmpPassword(passwordHash, period))

    override fun accountGetWallPapers(): Single<TLObjectVector<TLAbsWallPaper>> = executeRpcQuery(TLRequestAccountGetWallPapers())

    override fun accountRegisterDevice(tokenType: Int, token: String): Single<TLBool> = executeRpcQuery(TLRequestAccountRegisterDevice(tokenType, token))

    override fun accountReportPeer(peer: TLAbsInputPeer, reason: TLAbsReportReason): Single<TLBool> = executeRpcQuery(TLRequestAccountReportPeer(peer, reason))

    override fun accountResetAuthorization(hash: Long): Single<TLBool> = executeRpcQuery(TLRequestAccountResetAuthorization(hash))

    override fun accountResetNotifySettings(): Single<TLBool> = executeRpcQuery(TLRequestAccountResetNotifySettings())

    override fun accountSendChangePhoneCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?
    ): Single<TLSentCode> = executeRpcQuery(TLRequestAccountSendChangePhoneCode(allowFlashcall, phoneNumber, currentNumber))

    override fun accountSendConfirmPhoneCode(
            allowFlashcall: Boolean,
            hash: String,
            currentNumber: Boolean?
    ): Single<TLSentCode> = executeRpcQuery(TLRequestAccountSendConfirmPhoneCode(allowFlashcall, hash, currentNumber))

    override fun accountSetAccountTTL(ttl: TLAccountDaysTTL): Single<TLBool> = executeRpcQuery(TLRequestAccountSetAccountTTL(ttl))

    override fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): Single<TLPrivacyRules> = executeRpcQuery(TLRequestAccountSetPrivacy(key, rules))

    override fun accountUnregisterDevice(tokenType: Int, token: String): Single<TLBool> = executeRpcQuery(TLRequestAccountUnregisterDevice(tokenType, token))

    override fun accountUpdateDeviceLocked(period: Int): Single<TLBool> = executeRpcQuery(TLRequestAccountUpdateDeviceLocked(period))

    override fun accountUpdateNotifySettings(peer: TLAbsInputNotifyPeer, settings: TLInputPeerNotifySettings): Single<TLBool> = executeRpcQuery(TLRequestAccountUpdateNotifySettings(peer, settings))

    override fun accountUpdatePasswordSettings(currentPasswordHash: TLBytes, newSettings: TLPasswordInputSettings): Single<TLBool> = executeRpcQuery(TLRequestAccountUpdatePasswordSettings(currentPasswordHash, newSettings))

    override fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): Single<TLAbsUser> = executeRpcQuery(TLRequestAccountUpdateProfile(firstName, lastName, about))

    override fun accountUpdateStatus(offline: Boolean): Single<TLBool> = executeRpcQuery(TLRequestAccountUpdateStatus(offline))

    override fun accountUpdateUsername(username: String): Single<TLAbsUser> = executeRpcQuery(TLRequestAccountUpdateUsername(username))

    override fun authBindTempAuthKey(
            permAuthKeyId: Long,
            nonce: Long,
            expiresAt: Int,
            encryptedMessage: TLBytes
    ): Single<TLBool> = executeRpcQuery(TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage))

    override fun authCancelCode(phoneNumber: String, phoneCodeHash: String): Single<TLBool> = executeRpcQuery(TLRequestAuthCancelCode(phoneNumber, phoneCodeHash))

    override fun authCheckPassword(passwordHash: TLBytes): Single<TLAuthorization> = executeRpcQuery(TLRequestAuthCheckPassword(passwordHash))

    override fun authCheckPhone(phoneNumber: String): Single<TLCheckedPhone> = executeRpcQuery(TLRequestAuthCheckPhone(phoneNumber))

    override fun authDropTempAuthKeys(exceptAuthKeys: TLLongVector): Single<TLBool> = executeRpcQuery(TLRequestAuthDropTempAuthKeys(exceptAuthKeys))

    override fun authExportAuthorization(dcId: Int): Single<TLExportedAuthorization> = executeRpcQuery(TLRequestAuthExportAuthorization(dcId))

    override fun authImportAuthorization(id: Int, bytes: TLBytes): Single<TLAuthorization> = executeRpcQuery(TLRequestAuthImportAuthorization(id, bytes))

    override fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): Single<TLAuthorization> = executeRpcQuery(TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken))

    override fun authLogOut(): Single<TLBool> = executeRpcQuery(TLRequestAuthLogOut())

    override fun authRecoverPassword(code: String): Single<TLAuthorization> = executeRpcQuery(TLRequestAuthRecoverPassword(code))

    override fun authRequestPasswordRecovery(): Single<TLPasswordRecovery> = executeRpcQuery(TLRequestAuthRequestPasswordRecovery())

    override fun authResendCode(phoneNumber: String, phoneCodeHash: String): Single<TLSentCode> = executeRpcQuery(TLRequestAuthResendCode(phoneNumber, phoneCodeHash))

    override fun authResetAuthorizations(): Single<TLBool> = executeRpcQuery(TLRequestAuthResetAuthorizations())

    override fun authSendCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?,
            apiId: Int,
            apiHash: String
    ): Single<TLSentCode> = executeRpcQuery(TLRequestAuthSendCode(allowFlashcall, phoneNumber, currentNumber, apiId, apiHash))

    override fun authSendInvites(phoneNumbers: TLStringVector, message: String): Single<TLBool> = executeRpcQuery(TLRequestAuthSendInvites(phoneNumbers, message))

    override fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAuthorization> = executeRpcQuery(TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode))

    override fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String,
            firstName: String,
            lastName: String
    ): Single<TLAuthorization> = executeRpcQuery(TLRequestAuthSignUp(phoneNumber, phoneCodeHash, phoneCode, firstName, lastName))

    override fun botsAnswerWebhookJSONQuery(queryId: Long, data: TLDataJSON): Single<TLBool> = executeRpcQuery(TLRequestBotsAnswerWebhookJSONQuery(queryId, data))

    override fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): Single<TLDataJSON> = executeRpcQuery(TLRequestBotsSendCustomRequest(customMethod, params))

    override fun channelsCheckUsername(channel: TLAbsInputChannel, username: String): Single<TLBool> = executeRpcQuery(TLRequestChannelsCheckUsername(channel, username))

    override fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            title: String,
            about: String
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsCreateChannel(broadcast, megagroup, title, about))

    override fun channelsDeleteChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsDeleteChannel(channel))

    override fun channelsDeleteHistory(channel: TLAbsInputChannel, maxId: Int): Single<TLBool> = executeRpcQuery(TLRequestChannelsDeleteHistory(channel, maxId))

    override fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAffectedMessages> = executeRpcQuery(TLRequestChannelsDeleteMessages(channel, id))

    override fun channelsDeleteUserHistory(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLAffectedHistory> = executeRpcQuery(TLRequestChannelsDeleteUserHistory(channel, userId))

    override fun channelsEditAbout(channel: TLAbsInputChannel, about: String): Single<TLBool> = executeRpcQuery(TLRequestChannelsEditAbout(channel, about))

    override fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChannelAdminRights
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsEditAdmin(channel, userId, adminRights))

    override fun channelsEditBanned(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            bannedRights: TLChannelBannedRights
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsEditBanned(channel, userId, bannedRights))

    override fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsEditPhoto(channel, photo))

    override fun channelsEditTitle(channel: TLAbsInputChannel, title: String): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsEditTitle(channel, title))

    override fun channelsExportInvite(channel: TLAbsInputChannel): Single<TLAbsExportedChatInvite> = executeRpcQuery(TLRequestChannelsExportInvite(channel))

    override fun channelsExportMessageLink(channel: TLAbsInputChannel, id: Int): Single<TLExportedMessageLink> = executeRpcQuery(TLRequestChannelsExportMessageLink(channel, id))

    override fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): Single<TLAdminLogResults> = executeRpcQuery(TLRequestChannelsGetAdminLog(channel, q, eventsFilter, admins, maxId, minId, limit))

    override fun channelsGetAdminedPublicChannels(): Single<TLAbsChats> = executeRpcQuery(TLRequestChannelsGetAdminedPublicChannels())

    override fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): Single<TLAbsChats> = executeRpcQuery(TLRequestChannelsGetChannels(id))

    override fun channelsGetFullChannel(channel: TLAbsInputChannel): Single<TLChatFull> = executeRpcQuery(TLRequestChannelsGetFullChannel(channel))

    override fun channelsGetMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAbsMessages> = executeRpcQuery(TLRequestChannelsGetMessages(channel, id))

    override fun channelsGetParticipant(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLChannelParticipant> = executeRpcQuery(TLRequestChannelsGetParticipant(channel, userId))

    override fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int,
            hash: Int
    ): Single<TLAbsChannelParticipants> = executeRpcQuery(TLRequestChannelsGetParticipants(channel, filter, offset, limit, hash))

    override fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsInviteToChannel(channel, users))

    override fun channelsJoinChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsJoinChannel(channel))

    override fun channelsLeaveChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsLeaveChannel(channel))

    override fun channelsReadHistory(channel: TLAbsInputChannel, maxId: Int): Single<TLBool> = executeRpcQuery(TLRequestChannelsReadHistory(channel, maxId))

    override fun channelsReadMessageContents(channel: TLAbsInputChannel, id: TLIntVector): Single<TLBool> = executeRpcQuery(TLRequestChannelsReadMessageContents(channel, id))

    override fun channelsReportSpam(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            id: TLIntVector
    ): Single<TLBool> = executeRpcQuery(TLRequestChannelsReportSpam(channel, userId, id))

    override fun channelsSetStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): Single<TLBool> = executeRpcQuery(TLRequestChannelsSetStickers(channel, stickerset))

    override fun channelsToggleInvites(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsToggleInvites(channel, enabled))

    override fun channelsTogglePreHistoryHidden(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsTogglePreHistoryHidden(channel, enabled))

    override fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsToggleSignatures(channel, enabled))

    override fun channelsUpdatePinnedMessage(
            silent: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsUpdatePinnedMessage(silent, channel, id))

    override fun channelsUpdateUsername(channel: TLAbsInputChannel, username: String): Single<TLBool> = executeRpcQuery(TLRequestChannelsUpdateUsername(channel, username))

    override fun contactsBlock(id: TLAbsInputUser): Single<TLBool> = executeRpcQuery(TLRequestContactsBlock(id))

    override fun contactsDeleteContact(id: TLAbsInputUser): Single<TLLink> = executeRpcQuery(TLRequestContactsDeleteContact(id))

    override fun contactsDeleteContacts(id: TLObjectVector<TLAbsInputUser>): Single<TLBool> = executeRpcQuery(TLRequestContactsDeleteContacts(id))

    override fun contactsExportCard(): Single<TLIntVector> = executeRpcQuery(TLRequestContactsExportCard())

    override fun contactsGetBlocked(offset: Int, limit: Int): Single<TLAbsBlocked> = executeRpcQuery(TLRequestContactsGetBlocked(offset, limit))

    override fun contactsGetContacts(hash: Int): Single<TLAbsContacts> = executeRpcQuery(TLRequestContactsGetContacts(hash))

    override fun contactsGetStatuses(): Single<TLObjectVector<TLContactStatus>> = executeRpcQuery(TLRequestContactsGetStatuses())

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
    ): Single<TLAbsTopPeers> = executeRpcQuery(TLRequestContactsGetTopPeers(correspondents, botsPm, botsInline, phoneCalls, groups, channels, offset, limit, hash))

    override fun contactsImportCard(exportCard: TLIntVector): Single<TLAbsUser> = executeRpcQuery(TLRequestContactsImportCard(exportCard))

    override fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): Single<TLImportedContacts> = executeRpcQuery(TLRequestContactsImportContacts(contacts))

    override fun contactsResetSaved(): Single<TLBool> = executeRpcQuery(TLRequestContactsResetSaved())

    override fun contactsResetTopPeerRating(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer): Single<TLBool> = executeRpcQuery(TLRequestContactsResetTopPeerRating(category, peer))

    override fun contactsResolveUsername(username: String): Single<TLResolvedPeer> = executeRpcQuery(TLRequestContactsResolveUsername(username))

    override fun contactsSearch(q: String, limit: Int): Single<TLFound> = executeRpcQuery(TLRequestContactsSearch(q, limit))

    override fun contactsUnblock(id: TLAbsInputUser): Single<TLBool> = executeRpcQuery(TLRequestContactsUnblock(id))

    override fun helpGetAppChangelog(prevAppVersion: String): Single<TLAbsUpdates> = executeRpcQuery(TLRequestHelpGetAppChangelog(prevAppVersion))

    override fun helpGetAppUpdate(): Single<TLAbsAppUpdate> = executeRpcQuery(TLRequestHelpGetAppUpdate())

    override fun helpGetCdnConfig(): Single<TLCdnConfig> = executeRpcQuery(TLRequestHelpGetCdnConfig())

    override fun helpGetConfig(): Single<TLConfig> = executeRpcQuery(TLRequestHelpGetConfig())

    override fun helpGetInviteText(): Single<TLInviteText> = executeRpcQuery(TLRequestHelpGetInviteText())

    override fun helpGetNearestDc(): Single<TLNearestDc> = executeRpcQuery(TLRequestHelpGetNearestDc())

    override fun helpGetRecentMeUrls(referer: String): Single<TLRecentMeUrls> = executeRpcQuery(TLRequestHelpGetRecentMeUrls(referer))

    override fun helpGetSupport(): Single<TLSupport> = executeRpcQuery(TLRequestHelpGetSupport())

    override fun helpGetTermsOfService(): Single<TLTermsOfService> = executeRpcQuery(TLRequestHelpGetTermsOfService())

    override fun helpSaveAppLog(events: TLObjectVector<TLInputAppEvent>): Single<TLBool> = executeRpcQuery(TLRequestHelpSaveAppLog(events))

    override fun helpSetBotUpdatesStatus(pendingUpdatesCount: Int, message: String): Single<TLBool> = executeRpcQuery(TLRequestHelpSetBotUpdatesStatus(pendingUpdatesCount, message))

    override fun <T : TLObject> initConnection(
            apiId: Int,
            deviceModel: String,
            systemVersion: String,
            appVersion: String,
            systemLangCode: String,
            langPack: String,
            langCode: String,
            query: TLMethod<T>?
    ): Single<T> = executeRpcQuery(TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, systemLangCode, langPack, langCode, query))

    override fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>?): Single<T> = executeRpcQuery(TLRequestInvokeAfterMsg(msgId, query))

    override fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>?): Single<T> = executeRpcQuery(TLRequestInvokeAfterMsgs(msgIds, query))

    override fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>?): Single<T> = executeRpcQuery(TLRequestInvokeWithLayer(layer, query))

    override fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>?): Single<T> = executeRpcQuery(TLRequestInvokeWithoutUpdates(query))

    override fun langpackGetDifference(fromVersion: Int): Single<TLLangPackDifference> = executeRpcQuery(TLRequestLangpackGetDifference(fromVersion))

    override fun langpackGetLangPack(langCode: String): Single<TLLangPackDifference> = executeRpcQuery(TLRequestLangpackGetLangPack(langCode))

    override fun langpackGetLanguages(): Single<TLObjectVector<TLLangPackLanguage>> = executeRpcQuery(TLRequestLangpackGetLanguages())

    override fun langpackGetStrings(langCode: String, keys: TLStringVector): Single<TLObjectVector<TLAbsLangPackString>> = executeRpcQuery(TLRequestLangpackGetStrings(langCode, keys))

    override fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): Single<TLAbsEncryptedChat> = executeRpcQuery(TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint))

    override fun messagesAddChatUser(
            chatId: Int,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesAddChatUser(chatId, userId, fwdLimit))

    override fun messagesCheckChatInvite(hash: String): Single<TLAbsChatInvite> = executeRpcQuery(TLRequestMessagesCheckChatInvite(hash))

    override fun messagesClearRecentStickers(attached: Boolean): Single<TLBool> = executeRpcQuery(TLRequestMessagesClearRecentStickers(attached))

    override fun messagesCreateChat(users: TLObjectVector<TLAbsInputUser>, title: String): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesCreateChat(users, title))

    override fun messagesDeleteChatUser(chatId: Int, userId: TLAbsInputUser): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesDeleteChatUser(chatId, userId))

    override fun messagesDeleteHistory(
            justClear: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int
    ): Single<TLAffectedHistory> = executeRpcQuery(TLRequestMessagesDeleteHistory(justClear, peer, maxId))

    override fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): Single<TLAffectedMessages> = executeRpcQuery(TLRequestMessagesDeleteMessages(revoke, id))

    override fun messagesDiscardEncryption(chatId: Int): Single<TLBool> = executeRpcQuery(TLRequestMessagesDiscardEncryption(chatId))

    override fun messagesEditChatAdmin(
            chatId: Int,
            userId: TLAbsInputUser,
            isAdmin: Boolean
    ): Single<TLBool> = executeRpcQuery(TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin))

    override fun messagesEditChatPhoto(chatId: Int, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesEditChatPhoto(chatId, photo))

    override fun messagesEditChatTitle(chatId: Int, title: String): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesEditChatTitle(chatId, title))

    override fun messagesEditInlineBotMessage(
            noWebpage: Boolean,
            id: TLInputBotInlineMessageID,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLBool> = executeRpcQuery(TLRequestMessagesEditInlineBotMessage(noWebpage, id, message, replyMarkup, entities))

    override fun messagesEditMessage(
            noWebpage: Boolean,
            stopGeoLive: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            geoPoint: TLAbsInputGeoPoint?
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesEditMessage(noWebpage, stopGeoLive, peer, id, message, replyMarkup, entities, geoPoint))

    override fun messagesExportChatInvite(chatId: Int): Single<TLAbsExportedChatInvite> = executeRpcQuery(TLRequestMessagesExportChatInvite(chatId))

    override fun messagesFaveSticker(id: TLAbsInputDocument, unfave: Boolean): Single<TLBool> = executeRpcQuery(TLRequestMessagesFaveSticker(id, unfave))

    override fun messagesForwardMessage(
            peer: TLAbsInputPeer,
            id: Int,
            randomId: Long
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesForwardMessage(peer, id, randomId))

    override fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesForwardMessages(silent, background, withMyScore, fromPeer, id, randomId, toPeer))

    override fun messagesGetAllChats(exceptIds: TLIntVector): Single<TLAbsChats> = executeRpcQuery(TLRequestMessagesGetAllChats(exceptIds))

    override fun messagesGetAllDrafts(): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesGetAllDrafts())

    override fun messagesGetAllStickers(hash: Int): Single<TLAbsAllStickers> = executeRpcQuery(TLRequestMessagesGetAllStickers(hash))

    override fun messagesGetArchivedStickers(
            masks: Boolean,
            offsetId: Long,
            limit: Int
    ): Single<TLArchivedStickers> = executeRpcQuery(TLRequestMessagesGetArchivedStickers(masks, offsetId, limit))

    override fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): Single<TLObjectVector<TLAbsStickerSetCovered>> = executeRpcQuery(TLRequestMessagesGetAttachedStickers(media))

    override fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?
    ): Single<TLBotCallbackAnswer> = executeRpcQuery(TLRequestMessagesGetBotCallbackAnswer(game, peer, msgId, data))

    override fun messagesGetChats(id: TLIntVector): Single<TLAbsChats> = executeRpcQuery(TLRequestMessagesGetChats(id))

    override fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Int,
            limit: Int
    ): Single<TLAbsChats> = executeRpcQuery(TLRequestMessagesGetCommonChats(userId, maxId, limit))

    override fun messagesGetDhConfig(version: Int, randomLength: Int): Single<TLAbsDhConfig> = executeRpcQuery(TLRequestMessagesGetDhConfig(version, randomLength))

    override fun messagesGetDialogs(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int
    ): Single<TLAbsDialogs> = executeRpcQuery(TLRequestMessagesGetDialogs(excludePinned, offsetDate, offsetId, offsetPeer, limit))

    override fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Int,
            mimeType: String
    ): Single<TLAbsDocument> = executeRpcQuery(TLRequestMessagesGetDocumentByHash(sha256, size, mimeType))

    override fun messagesGetFavedStickers(hash: Int): Single<TLAbsFavedStickers> = executeRpcQuery(TLRequestMessagesGetFavedStickers(hash))

    override fun messagesGetFeaturedStickers(hash: Int): Single<TLAbsFeaturedStickers> = executeRpcQuery(TLRequestMessagesGetFeaturedStickers(hash))

    override fun messagesGetFullChat(chatId: Int): Single<TLChatFull> = executeRpcQuery(TLRequestMessagesGetFullChat(chatId))

    override fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): Single<TLHighScores> = executeRpcQuery(TLRequestMessagesGetGameHighScores(peer, id, userId))

    override fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages> = executeRpcQuery(TLRequestMessagesGetHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId))

    override fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): Single<TLBotResults> = executeRpcQuery(TLRequestMessagesGetInlineBotResults(bot, peer, geoPoint, query, offset))

    override fun messagesGetInlineGameHighScores(id: TLInputBotInlineMessageID, userId: TLAbsInputUser): Single<TLHighScores> = executeRpcQuery(TLRequestMessagesGetInlineGameHighScores(id, userId))

    override fun messagesGetMaskStickers(hash: Int): Single<TLAbsAllStickers> = executeRpcQuery(TLRequestMessagesGetMaskStickers(hash))

    override fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): Single<TLMessageEditData> = executeRpcQuery(TLRequestMessagesGetMessageEditData(peer, id))

    override fun messagesGetMessages(id: TLIntVector): Single<TLAbsMessages> = executeRpcQuery(TLRequestMessagesGetMessages(id))

    override fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): Single<TLIntVector> = executeRpcQuery(TLRequestMessagesGetMessagesViews(peer, id, increment))

    override fun messagesGetPeerDialogs(peers: TLObjectVector<TLAbsInputPeer>): Single<TLPeerDialogs> = executeRpcQuery(TLRequestMessagesGetPeerDialogs(peers))

    override fun messagesGetPeerSettings(peer: TLAbsInputPeer): Single<TLPeerSettings> = executeRpcQuery(TLRequestMessagesGetPeerSettings(peer))

    override fun messagesGetPinnedDialogs(): Single<TLPeerDialogs> = executeRpcQuery(TLRequestMessagesGetPinnedDialogs())

    override fun messagesGetRecentLocations(peer: TLAbsInputPeer, limit: Int): Single<TLAbsMessages> = executeRpcQuery(TLRequestMessagesGetRecentLocations(peer, limit))

    override fun messagesGetRecentStickers(attached: Boolean, hash: Int): Single<TLAbsRecentStickers> = executeRpcQuery(TLRequestMessagesGetRecentStickers(attached, hash))

    override fun messagesGetSavedGifs(hash: Int): Single<TLAbsSavedGifs> = executeRpcQuery(TLRequestMessagesGetSavedGifs(hash))

    override fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet): Single<TLStickerSet> = executeRpcQuery(TLRequestMessagesGetStickerSet(stickerset))

    override fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages> = executeRpcQuery(TLRequestMessagesGetUnreadMentions(peer, offsetId, addOffset, limit, maxId, minId))

    override fun messagesGetWebPage(url: String, hash: Int): Single<TLAbsWebPage> = executeRpcQuery(TLRequestMessagesGetWebPage(url, hash))

    override fun messagesGetWebPagePreview(message: String): Single<TLAbsMessageMedia> = executeRpcQuery(TLRequestMessagesGetWebPagePreview(message))

    override fun messagesHideReportSpam(peer: TLAbsInputPeer): Single<TLBool> = executeRpcQuery(TLRequestMessagesHideReportSpam(peer))

    override fun messagesImportChatInvite(hash: String): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesImportChatInvite(hash))

    override fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): Single<TLAbsStickerSetInstallResult> = executeRpcQuery(TLRequestMessagesInstallStickerSet(stickerset, archived))

    override fun messagesMigrateChat(chatId: Int): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesMigrateChat(chatId))

    override fun messagesReadEncryptedHistory(peer: TLInputEncryptedChat, maxDate: Int): Single<TLBool> = executeRpcQuery(TLRequestMessagesReadEncryptedHistory(peer, maxDate))

    override fun messagesReadFeaturedStickers(id: TLLongVector): Single<TLBool> = executeRpcQuery(TLRequestMessagesReadFeaturedStickers(id))

    override fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): Single<TLAffectedMessages> = executeRpcQuery(TLRequestMessagesReadHistory(peer, maxId))

    override fun messagesReadMentions(peer: TLAbsInputPeer): Single<TLAffectedHistory> = executeRpcQuery(TLRequestMessagesReadMentions(peer))

    override fun messagesReadMessageContents(id: TLIntVector): Single<TLAffectedMessages> = executeRpcQuery(TLRequestMessagesReadMessageContents(id))

    override fun messagesReceivedMessages(maxId: Int): Single<TLObjectVector<TLReceivedNotifyMessage>> = executeRpcQuery(TLRequestMessagesReceivedMessages(maxId))

    override fun messagesReceivedQueue(maxQts: Int): Single<TLLongVector> = executeRpcQuery(TLRequestMessagesReceivedQueue(maxQts))

    override fun messagesReorderPinnedDialogs(force: Boolean, order: TLObjectVector<TLAbsInputPeer>): Single<TLBool> = executeRpcQuery(TLRequestMessagesReorderPinnedDialogs(force, order))

    override fun messagesReorderStickerSets(masks: Boolean, order: TLLongVector): Single<TLBool> = executeRpcQuery(TLRequestMessagesReorderStickerSets(masks, order))

    override fun messagesReportEncryptedSpam(peer: TLInputEncryptedChat): Single<TLBool> = executeRpcQuery(TLRequestMessagesReportEncryptedSpam(peer))

    override fun messagesReportSpam(peer: TLAbsInputPeer): Single<TLBool> = executeRpcQuery(TLRequestMessagesReportSpam(peer))

    override fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): Single<TLAbsEncryptedChat> = executeRpcQuery(TLRequestMessagesRequestEncryption(userId, randomId, gA))

    override fun messagesSaveDraft(
            noWebpage: Boolean,
            replyToMsgId: Int?,
            peer: TLAbsInputPeer,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLBool> = executeRpcQuery(TLRequestMessagesSaveDraft(noWebpage, replyToMsgId, peer, message, entities))

    override fun messagesSaveGif(id: TLAbsInputDocument, unsave: Boolean): Single<TLBool> = executeRpcQuery(TLRequestMessagesSaveGif(id, unsave))

    override fun messagesSaveRecentSticker(
            attached: Boolean,
            id: TLAbsInputDocument,
            unsave: Boolean
    ): Single<TLBool> = executeRpcQuery(TLRequestMessagesSaveRecentSticker(attached, id, unsave))

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
    ): Single<TLAbsMessages> = executeRpcQuery(TLRequestMessagesSearch(peer, q, fromId, filter, minDate, maxDate, offsetId, addOffset, limit, maxId, minId))

    override fun messagesSearchGifs(q: String, offset: Int): Single<TLFoundGifs> = executeRpcQuery(TLRequestMessagesSearchGifs(q, offset))

    override fun messagesSearchGlobal(
            q: String,
            offsetDate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): Single<TLAbsMessages> = executeRpcQuery(TLRequestMessagesSearchGlobal(q, offsetDate, offsetPeer, offsetId, limit))

    override fun messagesSendEncrypted(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage> = executeRpcQuery(TLRequestMessagesSendEncrypted(peer, randomId, data))

    override fun messagesSendEncryptedFile(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): Single<TLAbsSentEncryptedMessage> = executeRpcQuery(TLRequestMessagesSendEncryptedFile(peer, randomId, data, file))

    override fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage> = executeRpcQuery(TLRequestMessagesSendEncryptedService(peer, randomId, data))

    override fun messagesSendInlineBotResult(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            randomId: Long,
            queryId: Long,
            id: String
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesSendInlineBotResult(silent, background, clearDraft, peer, replyToMsgId, randomId, queryId, id))

    override fun messagesSendMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            media: TLAbsInputMedia,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesSendMedia(silent, background, clearDraft, peer, replyToMsgId, media, randomId, replyMarkup))

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
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesSendMessage(noWebpage, silent, background, clearDraft, peer, replyToMsgId, message, randomId, replyMarkup, entities))

    override fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyToMsgId: Int,
            randomId: Long
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesSendScreenshotNotification(peer, replyToMsgId, randomId))

    override fun messagesSetBotCallbackAnswer(
            alert: Boolean,
            queryId: Long,
            message: String?,
            url: String?,
            cacheTime: Int
    ): Single<TLBool> = executeRpcQuery(TLRequestMessagesSetBotCallbackAnswer(alert, queryId, message, url, cacheTime))

    override fun messagesSetBotPrecheckoutResults(
            success: Boolean,
            queryId: Long,
            error: String?
    ): Single<TLBool> = executeRpcQuery(TLRequestMessagesSetBotPrecheckoutResults(success, queryId, error))

    override fun messagesSetBotShippingResults(
            queryId: Long,
            error: String?,
            shippingOptions: TLObjectVector<TLShippingOption>?
    ): Single<TLBool> = executeRpcQuery(TLRequestMessagesSetBotShippingResults(queryId, error, shippingOptions))

    override fun messagesSetEncryptedTyping(peer: TLInputEncryptedChat, typing: Boolean): Single<TLBool> = executeRpcQuery(TLRequestMessagesSetEncryptedTyping(peer, typing))

    override fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesSetGameScore(editMessage, force, peer, id, userId, score))

    override fun messagesSetInlineBotResults(
            gallery: Boolean,
            _private: Boolean,
            queryId: Long,
            results: TLObjectVector<TLAbsInputBotInlineResult>,
            cacheTime: Int,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?
    ): Single<TLBool> = executeRpcQuery(TLRequestMessagesSetInlineBotResults(gallery, _private, queryId, results, cacheTime, nextOffset, switchPm))

    override fun messagesSetInlineGameScore(
            editMessage: Boolean,
            force: Boolean,
            id: TLInputBotInlineMessageID,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLBool> = executeRpcQuery(TLRequestMessagesSetInlineGameScore(editMessage, force, id, userId, score))

    override fun messagesSetTyping(peer: TLAbsInputPeer, action: TLAbsSendMessageAction): Single<TLBool> = executeRpcQuery(TLRequestMessagesSetTyping(peer, action))

    override fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesStartBot(bot, peer, randomId, startParam))

    override fun messagesToggleChatAdmins(chatId: Int, enabled: Boolean): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesToggleChatAdmins(chatId, enabled))

    override fun messagesToggleDialogPin(pinned: Boolean, peer: TLAbsInputPeer): Single<TLBool> = executeRpcQuery(TLRequestMessagesToggleDialogPin(pinned, peer))

    override fun messagesUninstallStickerSet(stickerset: TLAbsInputStickerSet): Single<TLBool> = executeRpcQuery(TLRequestMessagesUninstallStickerSet(stickerset))

    override fun messagesUploadMedia(peer: TLAbsInputPeer, media: TLAbsInputMedia): Single<TLAbsMessageMedia> = executeRpcQuery(TLRequestMessagesUploadMedia(peer, media))

    override fun paymentsClearSavedInfo(credentials: Boolean, info: Boolean): Single<TLBool> = executeRpcQuery(TLRequestPaymentsClearSavedInfo(credentials, info))

    override fun paymentsGetPaymentForm(msgId: Int): Single<TLPaymentForm> = executeRpcQuery(TLRequestPaymentsGetPaymentForm(msgId))

    override fun paymentsGetPaymentReceipt(msgId: Int): Single<TLPaymentReceipt> = executeRpcQuery(TLRequestPaymentsGetPaymentReceipt(msgId))

    override fun paymentsGetSavedInfo(): Single<TLSavedInfo> = executeRpcQuery(TLRequestPaymentsGetSavedInfo())

    override fun paymentsSendPaymentForm(
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials
    ): Single<TLAbsPaymentResult> = executeRpcQuery(TLRequestPaymentsSendPaymentForm(msgId, requestedInfoId, shippingOptionId, credentials))

    override fun paymentsValidateRequestedInfo(
            save: Boolean,
            msgId: Int,
            info: TLPaymentRequestedInfo
    ): Single<TLValidatedRequestedInfo> = executeRpcQuery(TLRequestPaymentsValidateRequestedInfo(save, msgId, info))

    override fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeRpcQuery(TLRequestPhoneAcceptCall(peer, gB, protocol))

    override fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeRpcQuery(TLRequestPhoneConfirmCall(peer, gA, keyFingerprint, protocol))

    override fun phoneDiscardCall(
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestPhoneDiscardCall(peer, duration, reason, connectionId))

    override fun phoneGetCallConfig(): Single<TLDataJSON> = executeRpcQuery(TLRequestPhoneGetCallConfig())

    override fun phoneReceivedCall(peer: TLInputPhoneCall): Single<TLBool> = executeRpcQuery(TLRequestPhoneReceivedCall(peer))

    override fun phoneRequestCall(
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeRpcQuery(TLRequestPhoneRequestCall(userId, randomId, gAHash, protocol))

    override fun phoneSaveCallDebug(peer: TLInputPhoneCall, debug: TLDataJSON): Single<TLBool> = executeRpcQuery(TLRequestPhoneSaveCallDebug(peer, debug))

    override fun phoneSetCallRating(
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestPhoneSetCallRating(peer, rating, comment))

    override fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): Single<TLLongVector> = executeRpcQuery(TLRequestPhotosDeletePhotos(id))

    override fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): Single<TLAbsPhotos> = executeRpcQuery(TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit))

    override fun photosUpdateProfilePhoto(id: TLAbsInputPhoto): Single<TLAbsUserProfilePhoto> = executeRpcQuery(TLRequestPhotosUpdateProfilePhoto(id))

    override fun photosUploadProfilePhoto(file: TLAbsInputFile): Single<TLPhoto> = executeRpcQuery(TLRequestPhotosUploadProfilePhoto(file))

    override fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): Single<TLStickerSet> = executeRpcQuery(TLRequestStickersAddStickerToSet(stickerset, sticker))

    override fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): Single<TLStickerSet> = executeRpcQuery(TLRequestStickersChangeStickerPosition(sticker, position))

    override fun stickersCreateStickerSet(
            masks: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            stickers: TLObjectVector<TLInputStickerSetItem>
    ): Single<TLStickerSet> = executeRpcQuery(TLRequestStickersCreateStickerSet(masks, userId, title, shortName, stickers))

    override fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): Single<TLStickerSet> = executeRpcQuery(TLRequestStickersRemoveStickerFromSet(sticker))

    override fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): Single<TLAbsChannelDifference> = executeRpcQuery(TLRequestUpdatesGetChannelDifference(force, channel, filter, pts, limit))

    override fun updatesGetDifference(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ): Single<TLAbsDifference> = executeRpcQuery(TLRequestUpdatesGetDifference(pts, ptsTotalLimit, date, qts))

    override fun updatesGetState(): Single<TLState> = executeRpcQuery(TLRequestUpdatesGetState())

    override fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Int,
            limit: Int
    ): Single<TLAbsCdnFile> = executeRpcQuery(TLRequestUploadGetCdnFile(fileToken, offset, limit))

    override fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Int): Single<TLObjectVector<TLCdnFileHash>> = executeRpcQuery(TLRequestUploadGetCdnFileHashes(fileToken, offset))

    override fun uploadGetFile(
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLAbsFile> = executeRpcQuery(TLRequestUploadGetFile(location, offset, limit))

    override fun uploadGetWebFile(
            location: TLInputWebFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLWebFile> = executeRpcQuery(TLRequestUploadGetWebFile(location, offset, limit))

    override fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): Single<TLObjectVector<TLCdnFileHash>> = executeRpcQuery(TLRequestUploadReuploadCdnFile(fileToken, requestToken))

    override fun uploadSaveBigFilePart(
            fileId: Long,
            filePart: Int,
            fileTotalParts: Int,
            bytes: TLBytes
    ): Single<TLBool> = executeRpcQuery(TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes))

    override fun uploadSaveFilePart(
            fileId: Long,
            filePart: Int,
            bytes: TLBytes
    ): Single<TLBool> = executeRpcQuery(TLRequestUploadSaveFilePart(fileId, filePart, bytes))

    override fun usersGetFullUser(id: TLAbsInputUser): Single<TLUserFull> = executeRpcQuery(TLRequestUsersGetFullUser(id))

    override fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): Single<TLObjectVector<TLAbsUser>> = executeRpcQuery(TLRequestUsersGetUsers(id))
}
