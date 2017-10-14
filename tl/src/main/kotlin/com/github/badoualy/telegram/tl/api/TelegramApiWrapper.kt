package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.RpcQueryExecutor
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
import io.reactivex.Single

abstract class TelegramApiWrapper : TelegramApi, RpcQueryExecutor {
    override fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAbsUser> = executeMethod(TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode))

    override fun accountCheckUsername(username: String): Single<TLBool> = executeMethod(TLRequestAccountCheckUsername(username))

    override fun accountConfirmPhone(phoneCodeHash: String, phoneCode: String): Single<TLBool> = executeMethod(TLRequestAccountConfirmPhone(phoneCodeHash, phoneCode))

    override fun accountDeleteAccount(reason: String): Single<TLBool> = executeMethod(TLRequestAccountDeleteAccount(reason))

    override fun accountGetAccountTTL(): Single<TLAccountDaysTTL> = executeMethod(TLRequestAccountGetAccountTTL())

    override fun accountGetAuthorizations(): Single<TLAuthorizations> = executeMethod(TLRequestAccountGetAuthorizations())

    override fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): Single<TLAbsPeerNotifySettings> = executeMethod(TLRequestAccountGetNotifySettings(peer))

    override fun accountGetPassword(): Single<TLAbsPassword> = executeMethod(TLRequestAccountGetPassword())

    override fun accountGetPasswordSettings(currentPasswordHash: TLBytes): Single<TLPasswordSettings> = executeMethod(TLRequestAccountGetPasswordSettings(currentPasswordHash))

    override fun accountGetPrivacy(key: TLAbsInputPrivacyKey): Single<TLPrivacyRules> = executeMethod(TLRequestAccountGetPrivacy(key))

    override fun accountGetTmpPassword(passwordHash: TLBytes, period: Int): Single<TLTmpPassword> = executeMethod(TLRequestAccountGetTmpPassword(passwordHash, period))

    override fun accountGetWallPapers(): Single<TLObjectVector<TLAbsWallPaper>> = executeMethod(TLRequestAccountGetWallPapers())

    override fun accountRegisterDevice(tokenType: Int, token: String): Single<TLBool> = executeMethod(TLRequestAccountRegisterDevice(tokenType, token))

    override fun accountReportPeer(peer: TLAbsInputPeer, reason: TLAbsReportReason): Single<TLBool> = executeMethod(TLRequestAccountReportPeer(peer, reason))

    override fun accountResetAuthorization(hash: Long): Single<TLBool> = executeMethod(TLRequestAccountResetAuthorization(hash))

    override fun accountResetNotifySettings(): Single<TLBool> = executeMethod(TLRequestAccountResetNotifySettings())

    override fun accountSendChangePhoneCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?
    ): Single<TLSentCode> = executeMethod(TLRequestAccountSendChangePhoneCode(allowFlashcall, phoneNumber, currentNumber))

    override fun accountSendConfirmPhoneCode(
            allowFlashcall: Boolean,
            hash: String,
            currentNumber: Boolean?
    ): Single<TLSentCode> = executeMethod(TLRequestAccountSendConfirmPhoneCode(allowFlashcall, hash, currentNumber))

    override fun accountSetAccountTTL(ttl: TLAccountDaysTTL): Single<TLBool> = executeMethod(TLRequestAccountSetAccountTTL(ttl))

    override fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): Single<TLPrivacyRules> = executeMethod(TLRequestAccountSetPrivacy(key, rules))

    override fun accountUnregisterDevice(tokenType: Int, token: String): Single<TLBool> = executeMethod(TLRequestAccountUnregisterDevice(tokenType, token))

    override fun accountUpdateDeviceLocked(period: Int): Single<TLBool> = executeMethod(TLRequestAccountUpdateDeviceLocked(period))

    override fun accountUpdateNotifySettings(peer: TLAbsInputNotifyPeer, settings: TLInputPeerNotifySettings): Single<TLBool> = executeMethod(TLRequestAccountUpdateNotifySettings(peer, settings))

    override fun accountUpdatePasswordSettings(currentPasswordHash: TLBytes, newSettings: TLPasswordInputSettings): Single<TLBool> = executeMethod(TLRequestAccountUpdatePasswordSettings(currentPasswordHash, newSettings))

    override fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): Single<TLAbsUser> = executeMethod(TLRequestAccountUpdateProfile(firstName, lastName, about))

    override fun accountUpdateStatus(offline: Boolean): Single<TLBool> = executeMethod(TLRequestAccountUpdateStatus(offline))

    override fun accountUpdateUsername(username: String): Single<TLAbsUser> = executeMethod(TLRequestAccountUpdateUsername(username))

    override fun authBindTempAuthKey(
            permAuthKeyId: Long,
            nonce: Long,
            expiresAt: Int,
            encryptedMessage: TLBytes
    ): Single<TLBool> = executeMethod(TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage))

    override fun authCancelCode(phoneNumber: String, phoneCodeHash: String): Single<TLBool> = executeMethod(TLRequestAuthCancelCode(phoneNumber, phoneCodeHash))

    override fun authCheckPassword(passwordHash: TLBytes): Single<TLAuthorization> = executeMethod(TLRequestAuthCheckPassword(passwordHash))

    override fun authCheckPhone(phoneNumber: String): Single<TLCheckedPhone> = executeMethod(TLRequestAuthCheckPhone(phoneNumber))

    override fun authDropTempAuthKeys(exceptAuthKeys: TLLongVector): Single<TLBool> = executeMethod(TLRequestAuthDropTempAuthKeys(exceptAuthKeys))

    override fun authExportAuthorization(dcId: Int): Single<TLExportedAuthorization> = executeMethod(TLRequestAuthExportAuthorization(dcId))

    override fun authImportAuthorization(id: Int, bytes: TLBytes): Single<TLAuthorization> = executeMethod(TLRequestAuthImportAuthorization(id, bytes))

    override fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): Single<TLAuthorization> = executeMethod(TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken))

    override fun authLogOut(): Single<TLBool> = executeMethod(TLRequestAuthLogOut())

    override fun authRecoverPassword(code: String): Single<TLAuthorization> = executeMethod(TLRequestAuthRecoverPassword(code))

    override fun authRequestPasswordRecovery(): Single<TLPasswordRecovery> = executeMethod(TLRequestAuthRequestPasswordRecovery())

    override fun authResendCode(phoneNumber: String, phoneCodeHash: String): Single<TLSentCode> = executeMethod(TLRequestAuthResendCode(phoneNumber, phoneCodeHash))

    override fun authResetAuthorizations(): Single<TLBool> = executeMethod(TLRequestAuthResetAuthorizations())

    override fun authSendCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?,
            apiId: Int,
            apiHash: String
    ): Single<TLSentCode> = executeMethod(TLRequestAuthSendCode(allowFlashcall, phoneNumber, currentNumber, apiId, apiHash))

    override fun authSendInvites(phoneNumbers: TLStringVector, message: String): Single<TLBool> = executeMethod(TLRequestAuthSendInvites(phoneNumbers, message))

    override fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAuthorization> = executeMethod(TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode))

    override fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String,
            firstName: String,
            lastName: String
    ): Single<TLAuthorization> = executeMethod(TLRequestAuthSignUp(phoneNumber, phoneCodeHash, phoneCode, firstName, lastName))

    override fun botsAnswerWebhookJSONQuery(queryId: Long, data: TLDataJSON): Single<TLBool> = executeMethod(TLRequestBotsAnswerWebhookJSONQuery(queryId, data))

    override fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): Single<TLDataJSON> = executeMethod(TLRequestBotsSendCustomRequest(customMethod, params))

    override fun channelsCheckUsername(channel: TLAbsInputChannel, username: String): Single<TLBool> = executeMethod(TLRequestChannelsCheckUsername(channel, username))

    override fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            title: String,
            about: String
    ): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsCreateChannel(broadcast, megagroup, title, about))

    override fun channelsDeleteChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsDeleteChannel(channel))

    override fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAffectedMessages> = executeMethod(TLRequestChannelsDeleteMessages(channel, id))

    override fun channelsDeleteUserHistory(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLAffectedHistory> = executeMethod(TLRequestChannelsDeleteUserHistory(channel, userId))

    override fun channelsEditAbout(channel: TLAbsInputChannel, about: String): Single<TLBool> = executeMethod(TLRequestChannelsEditAbout(channel, about))

    override fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChannelAdminRights
    ): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditAdmin(channel, userId, adminRights))

    override fun channelsEditBanned(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            bannedRights: TLChannelBannedRights
    ): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditBanned(channel, userId, bannedRights))

    override fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditPhoto(channel, photo))

    override fun channelsEditTitle(channel: TLAbsInputChannel, title: String): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditTitle(channel, title))

    override fun channelsExportInvite(channel: TLAbsInputChannel): Single<TLAbsExportedChatInvite> = executeMethod(TLRequestChannelsExportInvite(channel))

    override fun channelsExportMessageLink(channel: TLAbsInputChannel, id: Int): Single<TLExportedMessageLink> = executeMethod(TLRequestChannelsExportMessageLink(channel, id))

    override fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): Single<TLAdminLogResults> = executeMethod(TLRequestChannelsGetAdminLog(channel, q, eventsFilter, admins, maxId, minId, limit))

    override fun channelsGetAdminedPublicChannels(): Single<TLAbsChats> = executeMethod(TLRequestChannelsGetAdminedPublicChannels())

    override fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): Single<TLAbsChats> = executeMethod(TLRequestChannelsGetChannels(id))

    override fun channelsGetFullChannel(channel: TLAbsInputChannel): Single<TLChatFull> = executeMethod(TLRequestChannelsGetFullChannel(channel))

    override fun channelsGetMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAbsMessages> = executeMethod(TLRequestChannelsGetMessages(channel, id))

    override fun channelsGetParticipant(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLChannelParticipant> = executeMethod(TLRequestChannelsGetParticipant(channel, userId))

    override fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int
    ): Single<TLChannelParticipants> = executeMethod(TLRequestChannelsGetParticipants(channel, filter, offset, limit))

    override fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsInviteToChannel(channel, users))

    override fun channelsJoinChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsJoinChannel(channel))

    override fun channelsLeaveChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsLeaveChannel(channel))

    override fun channelsReadHistory(channel: TLAbsInputChannel, maxId: Int): Single<TLBool> = executeMethod(TLRequestChannelsReadHistory(channel, maxId))

    override fun channelsReadMessageContents(channel: TLAbsInputChannel, id: TLIntVector): Single<TLBool> = executeMethod(TLRequestChannelsReadMessageContents(channel, id))

    override fun channelsReportSpam(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            id: TLIntVector
    ): Single<TLBool> = executeMethod(TLRequestChannelsReportSpam(channel, userId, id))

    override fun channelsSetStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): Single<TLBool> = executeMethod(TLRequestChannelsSetStickers(channel, stickerset))

    override fun channelsToggleInvites(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsToggleInvites(channel, enabled))

    override fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsToggleSignatures(channel, enabled))

    override fun channelsUpdatePinnedMessage(
            silent: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsUpdatePinnedMessage(silent, channel, id))

    override fun channelsUpdateUsername(channel: TLAbsInputChannel, username: String): Single<TLBool> = executeMethod(TLRequestChannelsUpdateUsername(channel, username))

    override fun contactsBlock(id: TLAbsInputUser): Single<TLBool> = executeMethod(TLRequestContactsBlock(id))

    override fun contactsDeleteContact(id: TLAbsInputUser): Single<TLLink> = executeMethod(TLRequestContactsDeleteContact(id))

    override fun contactsDeleteContacts(id: TLObjectVector<TLAbsInputUser>): Single<TLBool> = executeMethod(TLRequestContactsDeleteContacts(id))

    override fun contactsExportCard(): Single<TLIntVector> = executeMethod(TLRequestContactsExportCard())

    override fun contactsGetBlocked(offset: Int, limit: Int): Single<TLAbsBlocked> = executeMethod(TLRequestContactsGetBlocked(offset, limit))

    override fun contactsGetContacts(hash: Int): Single<TLAbsContacts> = executeMethod(TLRequestContactsGetContacts(hash))

    override fun contactsGetStatuses(): Single<TLObjectVector<TLContactStatus>> = executeMethod(TLRequestContactsGetStatuses())

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
    ): Single<TLAbsTopPeers> = executeMethod(TLRequestContactsGetTopPeers(correspondents, botsPm, botsInline, phoneCalls, groups, channels, offset, limit, hash))

    override fun contactsImportCard(exportCard: TLIntVector): Single<TLAbsUser> = executeMethod(TLRequestContactsImportCard(exportCard))

    override fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): Single<TLImportedContacts> = executeMethod(TLRequestContactsImportContacts(contacts))

    override fun contactsResetSaved(): Single<TLBool> = executeMethod(TLRequestContactsResetSaved())

    override fun contactsResetTopPeerRating(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestContactsResetTopPeerRating(category, peer))

    override fun contactsResolveUsername(username: String): Single<TLResolvedPeer> = executeMethod(TLRequestContactsResolveUsername(username))

    override fun contactsSearch(q: String, limit: Int): Single<TLFound> = executeMethod(TLRequestContactsSearch(q, limit))

    override fun contactsUnblock(id: TLAbsInputUser): Single<TLBool> = executeMethod(TLRequestContactsUnblock(id))

    override fun helpGetAppChangelog(prevAppVersion: String): Single<TLAbsUpdates> = executeMethod(TLRequestHelpGetAppChangelog(prevAppVersion))

    override fun helpGetAppUpdate(): Single<TLAbsAppUpdate> = executeMethod(TLRequestHelpGetAppUpdate())

    override fun helpGetCdnConfig(): Single<TLCdnConfig> = executeMethod(TLRequestHelpGetCdnConfig())

    override fun helpGetConfig(): Single<TLConfig> = executeMethod(TLRequestHelpGetConfig())

    override fun helpGetInviteText(): Single<TLInviteText> = executeMethod(TLRequestHelpGetInviteText())

    override fun helpGetNearestDc(): Single<TLNearestDc> = executeMethod(TLRequestHelpGetNearestDc())

    override fun helpGetSupport(): Single<TLSupport> = executeMethod(TLRequestHelpGetSupport())

    override fun helpGetTermsOfService(): Single<TLTermsOfService> = executeMethod(TLRequestHelpGetTermsOfService())

    override fun helpSaveAppLog(events: TLObjectVector<TLInputAppEvent>): Single<TLBool> = executeMethod(TLRequestHelpSaveAppLog(events))

    override fun helpSetBotUpdatesStatus(pendingUpdatesCount: Int, message: String): Single<TLBool> = executeMethod(TLRequestHelpSetBotUpdatesStatus(pendingUpdatesCount, message))

    override fun <T : TLObject> initConnection(
            apiId: Int,
            deviceModel: String,
            systemVersion: String,
            appVersion: String,
            systemLangCode: String,
            langPack: String,
            langCode: String,
            query: TLMethod<T>?
    ): Single<T> = executeMethod(TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, systemLangCode, langPack, langCode, query))

    override fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeAfterMsg(msgId, query))

    override fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeAfterMsgs(msgIds, query))

    override fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeWithLayer(layer, query))

    override fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeWithoutUpdates(query))

    override fun langpackGetDifference(fromVersion: Int): Single<TLLangPackDifference> = executeMethod(TLRequestLangpackGetDifference(fromVersion))

    override fun langpackGetLangPack(langCode: String): Single<TLLangPackDifference> = executeMethod(TLRequestLangpackGetLangPack(langCode))

    override fun langpackGetLanguages(): Single<TLObjectVector<TLLangPackLanguage>> = executeMethod(TLRequestLangpackGetLanguages())

    override fun langpackGetStrings(langCode: String, keys: TLStringVector): Single<TLObjectVector<TLAbsLangPackString>> = executeMethod(TLRequestLangpackGetStrings(langCode, keys))

    override fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): Single<TLAbsEncryptedChat> = executeMethod(TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint))

    override fun messagesAddChatUser(
            chatId: Int,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesAddChatUser(chatId, userId, fwdLimit))

    override fun messagesCheckChatInvite(hash: String): Single<TLAbsChatInvite> = executeMethod(TLRequestMessagesCheckChatInvite(hash))

    override fun messagesClearRecentStickers(attached: Boolean): Single<TLBool> = executeMethod(TLRequestMessagesClearRecentStickers(attached))

    override fun messagesCreateChat(users: TLObjectVector<TLAbsInputUser>, title: String): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesCreateChat(users, title))

    override fun messagesDeleteChatUser(chatId: Int, userId: TLAbsInputUser): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesDeleteChatUser(chatId, userId))

    override fun messagesDeleteHistory(
            justClear: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int
    ): Single<TLAffectedHistory> = executeMethod(TLRequestMessagesDeleteHistory(justClear, peer, maxId))

    override fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): Single<TLAffectedMessages> = executeMethod(TLRequestMessagesDeleteMessages(revoke, id))

    override fun messagesDiscardEncryption(chatId: Int): Single<TLBool> = executeMethod(TLRequestMessagesDiscardEncryption(chatId))

    override fun messagesEditChatAdmin(
            chatId: Int,
            userId: TLAbsInputUser,
            isAdmin: Boolean
    ): Single<TLBool> = executeMethod(TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin))

    override fun messagesEditChatPhoto(chatId: Int, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesEditChatPhoto(chatId, photo))

    override fun messagesEditChatTitle(chatId: Int, title: String): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesEditChatTitle(chatId, title))

    override fun messagesEditInlineBotMessage(
            noWebpage: Boolean,
            id: TLInputBotInlineMessageID,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLBool> = executeMethod(TLRequestMessagesEditInlineBotMessage(noWebpage, id, message, replyMarkup, entities))

    override fun messagesEditMessage(
            noWebpage: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesEditMessage(noWebpage, peer, id, message, replyMarkup, entities))

    override fun messagesExportChatInvite(chatId: Int): Single<TLAbsExportedChatInvite> = executeMethod(TLRequestMessagesExportChatInvite(chatId))

    override fun messagesFaveSticker(id: TLAbsInputDocument, unfave: Boolean): Single<TLBool> = executeMethod(TLRequestMessagesFaveSticker(id, unfave))

    override fun messagesForwardMessage(
            peer: TLAbsInputPeer,
            id: Int,
            randomId: Long
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesForwardMessage(peer, id, randomId))

    override fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesForwardMessages(silent, background, withMyScore, fromPeer, id, randomId, toPeer))

    override fun messagesGetAllChats(exceptIds: TLIntVector): Single<TLAbsChats> = executeMethod(TLRequestMessagesGetAllChats(exceptIds))

    override fun messagesGetAllDrafts(): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesGetAllDrafts())

    override fun messagesGetAllStickers(hash: Int): Single<TLAbsAllStickers> = executeMethod(TLRequestMessagesGetAllStickers(hash))

    override fun messagesGetArchivedStickers(
            masks: Boolean,
            offsetId: Long,
            limit: Int
    ): Single<TLArchivedStickers> = executeMethod(TLRequestMessagesGetArchivedStickers(masks, offsetId, limit))

    override fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): Single<TLObjectVector<TLAbsStickerSetCovered>> = executeMethod(TLRequestMessagesGetAttachedStickers(media))

    override fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?
    ): Single<TLBotCallbackAnswer> = executeMethod(TLRequestMessagesGetBotCallbackAnswer(game, peer, msgId, data))

    override fun messagesGetChats(id: TLIntVector): Single<TLAbsChats> = executeMethod(TLRequestMessagesGetChats(id))

    override fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Int,
            limit: Int
    ): Single<TLAbsChats> = executeMethod(TLRequestMessagesGetCommonChats(userId, maxId, limit))

    override fun messagesGetDhConfig(version: Int, randomLength: Int): Single<TLAbsDhConfig> = executeMethod(TLRequestMessagesGetDhConfig(version, randomLength))

    override fun messagesGetDialogs(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int
    ): Single<TLAbsDialogs> = executeMethod(TLRequestMessagesGetDialogs(excludePinned, offsetDate, offsetId, offsetPeer, limit))

    override fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Int,
            mimeType: String
    ): Single<TLAbsDocument> = executeMethod(TLRequestMessagesGetDocumentByHash(sha256, size, mimeType))

    override fun messagesGetFavedStickers(hash: Int): Single<TLAbsFavedStickers> = executeMethod(TLRequestMessagesGetFavedStickers(hash))

    override fun messagesGetFeaturedStickers(hash: Int): Single<TLAbsFeaturedStickers> = executeMethod(TLRequestMessagesGetFeaturedStickers(hash))

    override fun messagesGetFullChat(chatId: Int): Single<TLChatFull> = executeMethod(TLRequestMessagesGetFullChat(chatId))

    override fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): Single<TLHighScores> = executeMethod(TLRequestMessagesGetGameHighScores(peer, id, userId))

    override fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId))

    override fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): Single<TLBotResults> = executeMethod(TLRequestMessagesGetInlineBotResults(bot, peer, geoPoint, query, offset))

    override fun messagesGetInlineGameHighScores(id: TLInputBotInlineMessageID, userId: TLAbsInputUser): Single<TLHighScores> = executeMethod(TLRequestMessagesGetInlineGameHighScores(id, userId))

    override fun messagesGetMaskStickers(hash: Int): Single<TLAbsAllStickers> = executeMethod(TLRequestMessagesGetMaskStickers(hash))

    override fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): Single<TLMessageEditData> = executeMethod(TLRequestMessagesGetMessageEditData(peer, id))

    override fun messagesGetMessages(id: TLIntVector): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetMessages(id))

    override fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): Single<TLIntVector> = executeMethod(TLRequestMessagesGetMessagesViews(peer, id, increment))

    override fun messagesGetPeerDialogs(peers: TLObjectVector<TLAbsInputPeer>): Single<TLPeerDialogs> = executeMethod(TLRequestMessagesGetPeerDialogs(peers))

    override fun messagesGetPeerSettings(peer: TLAbsInputPeer): Single<TLPeerSettings> = executeMethod(TLRequestMessagesGetPeerSettings(peer))

    override fun messagesGetPinnedDialogs(): Single<TLPeerDialogs> = executeMethod(TLRequestMessagesGetPinnedDialogs())

    override fun messagesGetRecentStickers(attached: Boolean, hash: Int): Single<TLAbsRecentStickers> = executeMethod(TLRequestMessagesGetRecentStickers(attached, hash))

    override fun messagesGetSavedGifs(hash: Int): Single<TLAbsSavedGifs> = executeMethod(TLRequestMessagesGetSavedGifs(hash))

    override fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet): Single<TLStickerSet> = executeMethod(TLRequestMessagesGetStickerSet(stickerset))

    override fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetUnreadMentions(peer, offsetId, addOffset, limit, maxId, minId))

    override fun messagesGetWebPage(url: String, hash: Int): Single<TLAbsWebPage> = executeMethod(TLRequestMessagesGetWebPage(url, hash))

    override fun messagesGetWebPagePreview(message: String): Single<TLAbsMessageMedia> = executeMethod(TLRequestMessagesGetWebPagePreview(message))

    override fun messagesHideReportSpam(peer: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestMessagesHideReportSpam(peer))

    override fun messagesImportChatInvite(hash: String): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesImportChatInvite(hash))

    override fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): Single<TLAbsStickerSetInstallResult> = executeMethod(TLRequestMessagesInstallStickerSet(stickerset, archived))

    override fun messagesMigrateChat(chatId: Int): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesMigrateChat(chatId))

    override fun messagesReadEncryptedHistory(peer: TLInputEncryptedChat, maxDate: Int): Single<TLBool> = executeMethod(TLRequestMessagesReadEncryptedHistory(peer, maxDate))

    override fun messagesReadFeaturedStickers(id: TLLongVector): Single<TLBool> = executeMethod(TLRequestMessagesReadFeaturedStickers(id))

    override fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): Single<TLAffectedMessages> = executeMethod(TLRequestMessagesReadHistory(peer, maxId))

    override fun messagesReadMessageContents(id: TLIntVector): Single<TLAffectedMessages> = executeMethod(TLRequestMessagesReadMessageContents(id))

    override fun messagesReceivedMessages(maxId: Int): Single<TLObjectVector<TLReceivedNotifyMessage>> = executeMethod(TLRequestMessagesReceivedMessages(maxId))

    override fun messagesReceivedQueue(maxQts: Int): Single<TLLongVector> = executeMethod(TLRequestMessagesReceivedQueue(maxQts))

    override fun messagesReorderPinnedDialogs(force: Boolean, order: TLObjectVector<TLAbsInputPeer>): Single<TLBool> = executeMethod(TLRequestMessagesReorderPinnedDialogs(force, order))

    override fun messagesReorderStickerSets(masks: Boolean, order: TLLongVector): Single<TLBool> = executeMethod(TLRequestMessagesReorderStickerSets(masks, order))

    override fun messagesReportEncryptedSpam(peer: TLInputEncryptedChat): Single<TLBool> = executeMethod(TLRequestMessagesReportEncryptedSpam(peer))

    override fun messagesReportSpam(peer: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestMessagesReportSpam(peer))

    override fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): Single<TLAbsEncryptedChat> = executeMethod(TLRequestMessagesRequestEncryption(userId, randomId, gA))

    override fun messagesSaveDraft(
            noWebpage: Boolean,
            replyToMsgId: Int?,
            peer: TLAbsInputPeer,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLBool> = executeMethod(TLRequestMessagesSaveDraft(noWebpage, replyToMsgId, peer, message, entities))

    override fun messagesSaveGif(id: TLAbsInputDocument, unsave: Boolean): Single<TLBool> = executeMethod(TLRequestMessagesSaveGif(id, unsave))

    override fun messagesSaveRecentSticker(
            attached: Boolean,
            id: TLAbsInputDocument,
            unsave: Boolean
    ): Single<TLBool> = executeMethod(TLRequestMessagesSaveRecentSticker(attached, id, unsave))

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
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesSearch(peer, q, fromId, filter, minDate, maxDate, offsetId, addOffset, limit, maxId, minId))

    override fun messagesSearchGifs(q: String, offset: Int): Single<TLFoundGifs> = executeMethod(TLRequestMessagesSearchGifs(q, offset))

    override fun messagesSearchGlobal(
            q: String,
            offsetDate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesSearchGlobal(q, offsetDate, offsetPeer, offsetId, limit))

    override fun messagesSendEncrypted(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage> = executeMethod(TLRequestMessagesSendEncrypted(peer, randomId, data))

    override fun messagesSendEncryptedFile(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): Single<TLAbsSentEncryptedMessage> = executeMethod(TLRequestMessagesSendEncryptedFile(peer, randomId, data, file))

    override fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage> = executeMethod(TLRequestMessagesSendEncryptedService(peer, randomId, data))

    override fun messagesSendInlineBotResult(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            randomId: Long,
            queryId: Long,
            id: String
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendInlineBotResult(silent, background, clearDraft, peer, replyToMsgId, randomId, queryId, id))

    override fun messagesSendMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            media: TLAbsInputMedia,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendMedia(silent, background, clearDraft, peer, replyToMsgId, media, randomId, replyMarkup))

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
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendMessage(noWebpage, silent, background, clearDraft, peer, replyToMsgId, message, randomId, replyMarkup, entities))

    override fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyToMsgId: Int,
            randomId: Long
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendScreenshotNotification(peer, replyToMsgId, randomId))

    override fun messagesSetBotCallbackAnswer(
            alert: Boolean,
            queryId: Long,
            message: String?,
            url: String?,
            cacheTime: Int
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetBotCallbackAnswer(alert, queryId, message, url, cacheTime))

    override fun messagesSetBotPrecheckoutResults(
            success: Boolean,
            queryId: Long,
            error: String?
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetBotPrecheckoutResults(success, queryId, error))

    override fun messagesSetBotShippingResults(
            queryId: Long,
            error: String?,
            shippingOptions: TLObjectVector<TLShippingOption>?
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetBotShippingResults(queryId, error, shippingOptions))

    override fun messagesSetEncryptedTyping(peer: TLInputEncryptedChat, typing: Boolean): Single<TLBool> = executeMethod(TLRequestMessagesSetEncryptedTyping(peer, typing))

    override fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSetGameScore(editMessage, force, peer, id, userId, score))

    override fun messagesSetInlineBotResults(
            gallery: Boolean,
            _private: Boolean,
            queryId: Long,
            results: TLObjectVector<TLAbsInputBotInlineResult>,
            cacheTime: Int,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetInlineBotResults(gallery, _private, queryId, results, cacheTime, nextOffset, switchPm))

    override fun messagesSetInlineGameScore(
            editMessage: Boolean,
            force: Boolean,
            id: TLInputBotInlineMessageID,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetInlineGameScore(editMessage, force, id, userId, score))

    override fun messagesSetTyping(peer: TLAbsInputPeer, action: TLAbsSendMessageAction): Single<TLBool> = executeMethod(TLRequestMessagesSetTyping(peer, action))

    override fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesStartBot(bot, peer, randomId, startParam))

    override fun messagesToggleChatAdmins(chatId: Int, enabled: Boolean): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesToggleChatAdmins(chatId, enabled))

    override fun messagesToggleDialogPin(pinned: Boolean, peer: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestMessagesToggleDialogPin(pinned, peer))

    override fun messagesUninstallStickerSet(stickerset: TLAbsInputStickerSet): Single<TLBool> = executeMethod(TLRequestMessagesUninstallStickerSet(stickerset))

    override fun messagesUploadMedia(peer: TLAbsInputPeer, media: TLAbsInputMedia): Single<TLAbsMessageMedia> = executeMethod(TLRequestMessagesUploadMedia(peer, media))

    override fun paymentsClearSavedInfo(credentials: Boolean, info: Boolean): Single<TLBool> = executeMethod(TLRequestPaymentsClearSavedInfo(credentials, info))

    override fun paymentsGetPaymentForm(msgId: Int): Single<TLPaymentForm> = executeMethod(TLRequestPaymentsGetPaymentForm(msgId))

    override fun paymentsGetPaymentReceipt(msgId: Int): Single<TLPaymentReceipt> = executeMethod(TLRequestPaymentsGetPaymentReceipt(msgId))

    override fun paymentsGetSavedInfo(): Single<TLSavedInfo> = executeMethod(TLRequestPaymentsGetSavedInfo())

    override fun paymentsSendPaymentForm(
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials
    ): Single<TLAbsPaymentResult> = executeMethod(TLRequestPaymentsSendPaymentForm(msgId, requestedInfoId, shippingOptionId, credentials))

    override fun paymentsValidateRequestedInfo(
            save: Boolean,
            msgId: Int,
            info: TLPaymentRequestedInfo
    ): Single<TLValidatedRequestedInfo> = executeMethod(TLRequestPaymentsValidateRequestedInfo(save, msgId, info))

    override fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeMethod(TLRequestPhoneAcceptCall(peer, gB, protocol))

    override fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeMethod(TLRequestPhoneConfirmCall(peer, gA, keyFingerprint, protocol))

    override fun phoneDiscardCall(
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneDiscardCall(peer, duration, reason, connectionId))

    override fun phoneGetCallConfig(): Single<TLDataJSON> = executeMethod(TLRequestPhoneGetCallConfig())

    override fun phoneReceivedCall(peer: TLInputPhoneCall): Single<TLBool> = executeMethod(TLRequestPhoneReceivedCall(peer))

    override fun phoneRequestCall(
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeMethod(TLRequestPhoneRequestCall(userId, randomId, gAHash, protocol))

    override fun phoneSaveCallDebug(peer: TLInputPhoneCall, debug: TLDataJSON): Single<TLBool> = executeMethod(TLRequestPhoneSaveCallDebug(peer, debug))

    override fun phoneSetCallRating(
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneSetCallRating(peer, rating, comment))

    override fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): Single<TLLongVector> = executeMethod(TLRequestPhotosDeletePhotos(id))

    override fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): Single<TLAbsPhotos> = executeMethod(TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit))

    override fun photosUpdateProfilePhoto(id: TLAbsInputPhoto): Single<TLAbsUserProfilePhoto> = executeMethod(TLRequestPhotosUpdateProfilePhoto(id))

    override fun photosUploadProfilePhoto(file: TLAbsInputFile): Single<TLPhoto> = executeMethod(TLRequestPhotosUploadProfilePhoto(file))

    override fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): Single<TLStickerSet> = executeMethod(TLRequestStickersAddStickerToSet(stickerset, sticker))

    override fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): Single<TLStickerSet> = executeMethod(TLRequestStickersChangeStickerPosition(sticker, position))

    override fun stickersCreateStickerSet(
            masks: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            stickers: TLObjectVector<TLInputStickerSetItem>
    ): Single<TLStickerSet> = executeMethod(TLRequestStickersCreateStickerSet(masks, userId, title, shortName, stickers))

    override fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): Single<TLStickerSet> = executeMethod(TLRequestStickersRemoveStickerFromSet(sticker))

    override fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): Single<TLAbsChannelDifference> = executeMethod(TLRequestUpdatesGetChannelDifference(force, channel, filter, pts, limit))

    override fun updatesGetDifference(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ): Single<TLAbsDifference> = executeMethod(TLRequestUpdatesGetDifference(pts, ptsTotalLimit, date, qts))

    override fun updatesGetState(): Single<TLState> = executeMethod(TLRequestUpdatesGetState())

    override fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Int,
            limit: Int
    ): Single<TLAbsCdnFile> = executeMethod(TLRequestUploadGetCdnFile(fileToken, offset, limit))

    override fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Int): Single<TLObjectVector<TLCdnFileHash>> = executeMethod(TLRequestUploadGetCdnFileHashes(fileToken, offset))

    override fun uploadGetFile(
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLAbsFile> = executeMethod(TLRequestUploadGetFile(location, offset, limit))

    override fun uploadGetWebFile(
            location: TLInputWebFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLWebFile> = executeMethod(TLRequestUploadGetWebFile(location, offset, limit))

    override fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): Single<TLObjectVector<TLCdnFileHash>> = executeMethod(TLRequestUploadReuploadCdnFile(fileToken, requestToken))

    override fun uploadSaveBigFilePart(
            fileId: Long,
            filePart: Int,
            fileTotalParts: Int,
            bytes: TLBytes
    ): Single<TLBool> = executeMethod(TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes))

    override fun uploadSaveFilePart(
            fileId: Long,
            filePart: Int,
            bytes: TLBytes
    ): Single<TLBool> = executeMethod(TLRequestUploadSaveFilePart(fileId, filePart, bytes))

    override fun usersGetFullUser(id: TLAbsInputUser): Single<TLUserFull> = executeMethod(TLRequestUsersGetFullUser(id))

    override fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): Single<TLObjectVector<TLAbsUser>> = executeMethod(TLRequestUsersGetUsers(id))
}
