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
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import rx.Single
import java.io.IOException

abstract class TelegramApiWrapper : TelegramApi, RpcQueryExecutor {
    @Throws(RpcErrorException::class,IOException::class)
    override fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAbsUser> = executeRpcQuery(TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountGetAccountTTL(): Single<TLAccountDaysTTL> = executeRpcQuery(TLRequestAccountGetAccountTTL())

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountGetAuthorizations(): Single<TLAuthorizations> = executeRpcQuery(TLRequestAccountGetAuthorizations())

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): Single<TLAbsPeerNotifySettings> = executeRpcQuery(TLRequestAccountGetNotifySettings(peer))

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountGetPassword(): Single<TLAbsPassword> = executeRpcQuery(TLRequestAccountGetPassword())

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountGetPasswordSettings(currentPasswordHash: TLBytes): Single<TLPasswordSettings> = executeRpcQuery(TLRequestAccountGetPasswordSettings(currentPasswordHash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountGetPrivacy(key: TLAbsInputPrivacyKey): Single<TLPrivacyRules> = executeRpcQuery(TLRequestAccountGetPrivacy(key))

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountGetTmpPassword(passwordHash: TLBytes, period: Int): Single<TLTmpPassword> = executeRpcQuery(TLRequestAccountGetTmpPassword(passwordHash, period))

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountGetWallPapers(): Single<TLObjectVector<TLAbsWallPaper>> = executeRpcQuery(TLRequestAccountGetWallPapers())

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountSendChangePhoneCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean
    ): Single<TLSentCode> = executeRpcQuery(TLRequestAccountSendChangePhoneCode(allowFlashcall, phoneNumber, currentNumber))

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountSendConfirmPhoneCode(
            allowFlashcall: Boolean,
            hash: String,
            currentNumber: Boolean
    ): Single<TLSentCode> = executeRpcQuery(TLRequestAccountSendConfirmPhoneCode(allowFlashcall, hash, currentNumber))

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): Single<TLPrivacyRules> = executeRpcQuery(TLRequestAccountSetPrivacy(key, rules))

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): Single<TLAbsUser> = executeRpcQuery(TLRequestAccountUpdateProfile(firstName, lastName, about))

    @Throws(RpcErrorException::class,IOException::class)
    override fun accountUpdateUsername(username: String): Single<TLAbsUser> = executeRpcQuery(TLRequestAccountUpdateUsername(username))

    @Throws(RpcErrorException::class,IOException::class)
    override fun authCheckPassword(passwordHash: TLBytes): Single<TLAuthorization> = executeRpcQuery(TLRequestAuthCheckPassword(passwordHash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun authCheckPhone(phoneNumber: String): Single<TLCheckedPhone> = executeRpcQuery(TLRequestAuthCheckPhone(phoneNumber))

    @Throws(RpcErrorException::class,IOException::class)
    override fun authExportAuthorization(dcId: Int): Single<TLExportedAuthorization> = executeRpcQuery(TLRequestAuthExportAuthorization(dcId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun authImportAuthorization(id: Int, bytes: TLBytes): Single<TLAuthorization> = executeRpcQuery(TLRequestAuthImportAuthorization(id, bytes))

    @Throws(RpcErrorException::class,IOException::class)
    override fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): Single<TLAuthorization> = executeRpcQuery(TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken))

    @Throws(RpcErrorException::class,IOException::class)
    override fun authRecoverPassword(code: String): Single<TLAuthorization> = executeRpcQuery(TLRequestAuthRecoverPassword(code))

    @Throws(RpcErrorException::class,IOException::class)
    override fun authRequestPasswordRecovery(): Single<TLPasswordRecovery> = executeRpcQuery(TLRequestAuthRequestPasswordRecovery())

    @Throws(RpcErrorException::class,IOException::class)
    override fun authResendCode(phoneNumber: String, phoneCodeHash: String): Single<TLSentCode> = executeRpcQuery(TLRequestAuthResendCode(phoneNumber, phoneCodeHash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun authSendCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean,
            apiId: Int,
            apiHash: String
    ): Single<TLSentCode> = executeRpcQuery(TLRequestAuthSendCode(allowFlashcall, phoneNumber, currentNumber, apiId, apiHash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAuthorization> = executeRpcQuery(TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class,IOException::class)
    override fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String,
            firstName: String,
            lastName: String
    ): Single<TLAuthorization> = executeRpcQuery(TLRequestAuthSignUp(phoneNumber, phoneCodeHash, phoneCode, firstName, lastName))

    @Throws(RpcErrorException::class,IOException::class)
    override fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): Single<TLDataJSON> = executeRpcQuery(TLRequestBotsSendCustomRequest(customMethod, params))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            title: String,
            about: String
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsCreateChannel(broadcast, megagroup, title, about))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsDeleteChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsDeleteChannel(channel))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAffectedMessages> = executeRpcQuery(TLRequestChannelsDeleteMessages(channel, id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsDeleteUserHistory(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLAffectedHistory> = executeRpcQuery(TLRequestChannelsDeleteUserHistory(channel, userId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChannelAdminRights
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsEditAdmin(channel, userId, adminRights))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsEditBanned(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            bannedRights: TLChannelBannedRights
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsEditBanned(channel, userId, bannedRights))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsEditPhoto(channel, photo))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsEditTitle(channel: TLAbsInputChannel, title: String): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsEditTitle(channel, title))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsExportInvite(channel: TLAbsInputChannel): Single<TLAbsExportedChatInvite> = executeRpcQuery(TLRequestChannelsExportInvite(channel))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsExportMessageLink(channel: TLAbsInputChannel, id: Int): Single<TLExportedMessageLink> = executeRpcQuery(TLRequestChannelsExportMessageLink(channel, id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): Single<TLAdminLogResults> = executeRpcQuery(TLRequestChannelsGetAdminLog(channel, q, eventsFilter, admins, maxId, minId, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsGetAdminedPublicChannels(): Single<TLAbsChats> = executeRpcQuery(TLRequestChannelsGetAdminedPublicChannels())

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): Single<TLAbsChats> = executeRpcQuery(TLRequestChannelsGetChannels(id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsGetFullChannel(channel: TLAbsInputChannel): Single<TLChatFull> = executeRpcQuery(TLRequestChannelsGetFullChannel(channel))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsGetMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAbsMessages> = executeRpcQuery(TLRequestChannelsGetMessages(channel, id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsGetParticipant(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLChannelParticipant> = executeRpcQuery(TLRequestChannelsGetParticipant(channel, userId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int
    ): Single<TLChannelParticipants> = executeRpcQuery(TLRequestChannelsGetParticipants(channel, filter, offset, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsInviteToChannel(channel, users))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsJoinChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsJoinChannel(channel))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsLeaveChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsLeaveChannel(channel))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsToggleInvites(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsToggleInvites(channel, enabled))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsToggleSignatures(channel, enabled))

    @Throws(RpcErrorException::class,IOException::class)
    override fun channelsUpdatePinnedMessage(
            silent: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestChannelsUpdatePinnedMessage(silent, channel, id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun contactsDeleteContact(id: TLAbsInputUser): Single<TLLink> = executeRpcQuery(TLRequestContactsDeleteContact(id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun contactsExportCard(): Single<TLIntVector> = executeRpcQuery(TLRequestContactsExportCard())

    @Throws(RpcErrorException::class,IOException::class)
    override fun contactsGetBlocked(offset: Int, limit: Int): Single<TLAbsBlocked> = executeRpcQuery(TLRequestContactsGetBlocked(offset, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun contactsGetContacts(hash: Int): Single<TLAbsContacts> = executeRpcQuery(TLRequestContactsGetContacts(hash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun contactsGetStatuses(): Single<TLObjectVector<TLContactStatus>> = executeRpcQuery(TLRequestContactsGetStatuses())

    @Throws(RpcErrorException::class,IOException::class)
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

    @Throws(RpcErrorException::class,IOException::class)
    override fun contactsImportCard(exportCard: TLIntVector): Single<TLAbsUser> = executeRpcQuery(TLRequestContactsImportCard(exportCard))

    @Throws(RpcErrorException::class,IOException::class)
    override fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): Single<TLImportedContacts> = executeRpcQuery(TLRequestContactsImportContacts(contacts))

    @Throws(RpcErrorException::class,IOException::class)
    override fun contactsResolveUsername(username: String): Single<TLResolvedPeer> = executeRpcQuery(TLRequestContactsResolveUsername(username))

    @Throws(RpcErrorException::class,IOException::class)
    override fun contactsSearch(q: String, limit: Int): Single<TLFound> = executeRpcQuery(TLRequestContactsSearch(q, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun helpGetAppChangelog(prevAppVersion: String): Single<TLAbsUpdates> = executeRpcQuery(TLRequestHelpGetAppChangelog(prevAppVersion))

    @Throws(RpcErrorException::class,IOException::class)
    override fun helpGetAppUpdate(): Single<TLAbsAppUpdate> = executeRpcQuery(TLRequestHelpGetAppUpdate())

    @Throws(RpcErrorException::class,IOException::class)
    override fun helpGetCdnConfig(): Single<TLCdnConfig> = executeRpcQuery(TLRequestHelpGetCdnConfig())

    @Throws(RpcErrorException::class,IOException::class)
    override fun helpGetConfig(): Single<TLConfig> = executeRpcQuery(TLRequestHelpGetConfig())

    @Throws(RpcErrorException::class,IOException::class)
    override fun helpGetInviteText(): Single<TLInviteText> = executeRpcQuery(TLRequestHelpGetInviteText())

    @Throws(RpcErrorException::class,IOException::class)
    override fun helpGetNearestDc(): Single<TLNearestDc> = executeRpcQuery(TLRequestHelpGetNearestDc())

    @Throws(RpcErrorException::class,IOException::class)
    override fun helpGetSupport(): Single<TLSupport> = executeRpcQuery(TLRequestHelpGetSupport())

    @Throws(RpcErrorException::class,IOException::class)
    override fun helpGetTermsOfService(): Single<TLTermsOfService> = executeRpcQuery(TLRequestHelpGetTermsOfService())

    @Throws(RpcErrorException::class,IOException::class)
    override fun <T : TLObject> initConnection(
            apiId: Int,
            deviceModel: String,
            systemVersion: String,
            appVersion: String,
            systemLangCode: String,
            langPack: String,
            langCode: String,
            query: TLMethod<T>
    ): Single<T> = executeRpcQuery(TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, systemLangCode, langPack, langCode, query))

    @Throws(RpcErrorException::class,IOException::class)
    override fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>): Single<T> = executeRpcQuery(TLRequestInvokeAfterMsg(msgId, query))

    @Throws(RpcErrorException::class,IOException::class)
    override fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>): Single<T> = executeRpcQuery(TLRequestInvokeAfterMsgs(msgIds, query))

    @Throws(RpcErrorException::class,IOException::class)
    override fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>): Single<T> = executeRpcQuery(TLRequestInvokeWithLayer(layer, query))

    @Throws(RpcErrorException::class,IOException::class)
    override fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>): Single<T> = executeRpcQuery(TLRequestInvokeWithoutUpdates(query))

    @Throws(RpcErrorException::class,IOException::class)
    override fun langpackGetDifference(fromVersion: Int): Single<TLLangPackDifference> = executeRpcQuery(TLRequestLangpackGetDifference(fromVersion))

    @Throws(RpcErrorException::class,IOException::class)
    override fun langpackGetLangPack(langCode: String): Single<TLLangPackDifference> = executeRpcQuery(TLRequestLangpackGetLangPack(langCode))

    @Throws(RpcErrorException::class,IOException::class)
    override fun langpackGetLanguages(): Single<TLObjectVector<TLLangPackLanguage>> = executeRpcQuery(TLRequestLangpackGetLanguages())

    @Throws(RpcErrorException::class,IOException::class)
    override fun langpackGetStrings(langCode: String, keys: TLStringVector): Single<TLObjectVector<TLAbsLangPackString>> = executeRpcQuery(TLRequestLangpackGetStrings(langCode, keys))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): Single<TLAbsEncryptedChat> = executeRpcQuery(TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesAddChatUser(
            chatId: Int,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesAddChatUser(chatId, userId, fwdLimit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesCheckChatInvite(hash: String): Single<TLAbsChatInvite> = executeRpcQuery(TLRequestMessagesCheckChatInvite(hash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesCreateChat(users: TLObjectVector<TLAbsInputUser>, title: String): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesCreateChat(users, title))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesDeleteChatUser(chatId: Int, userId: TLAbsInputUser): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesDeleteChatUser(chatId, userId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesDeleteHistory(
            justClear: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int
    ): Single<TLAffectedHistory> = executeRpcQuery(TLRequestMessagesDeleteHistory(justClear, peer, maxId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): Single<TLAffectedMessages> = executeRpcQuery(TLRequestMessagesDeleteMessages(revoke, id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesEditChatPhoto(chatId: Int, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesEditChatPhoto(chatId, photo))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesEditChatTitle(chatId: Int, title: String): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesEditChatTitle(chatId, title))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesEditMessage(
            noWebpage: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesEditMessage(noWebpage, peer, id, message, replyMarkup, entities))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesExportChatInvite(chatId: Int): Single<TLAbsExportedChatInvite> = executeRpcQuery(TLRequestMessagesExportChatInvite(chatId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesForwardMessage(
            peer: TLAbsInputPeer,
            id: Int,
            randomId: Long
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesForwardMessage(peer, id, randomId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesForwardMessages(silent, background, withMyScore, fromPeer, id, randomId, toPeer))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetAllChats(exceptIds: TLIntVector): Single<TLAbsChats> = executeRpcQuery(TLRequestMessagesGetAllChats(exceptIds))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetAllDrafts(): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesGetAllDrafts())

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetAllStickers(hash: Int): Single<TLAbsAllStickers> = executeRpcQuery(TLRequestMessagesGetAllStickers(hash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetArchivedStickers(
            masks: Boolean,
            offsetId: Long,
            limit: Int
    ): Single<TLArchivedStickers> = executeRpcQuery(TLRequestMessagesGetArchivedStickers(masks, offsetId, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): Single<TLObjectVector<TLAbsStickerSetCovered>> = executeRpcQuery(TLRequestMessagesGetAttachedStickers(media))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?
    ): Single<TLBotCallbackAnswer> = executeRpcQuery(TLRequestMessagesGetBotCallbackAnswer(game, peer, msgId, data))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetChats(id: TLIntVector): Single<TLAbsChats> = executeRpcQuery(TLRequestMessagesGetChats(id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Int,
            limit: Int
    ): Single<TLAbsChats> = executeRpcQuery(TLRequestMessagesGetCommonChats(userId, maxId, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetDhConfig(version: Int, randomLength: Int): Single<TLAbsDhConfig> = executeRpcQuery(TLRequestMessagesGetDhConfig(version, randomLength))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetDialogs(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int
    ): Single<TLAbsDialogs> = executeRpcQuery(TLRequestMessagesGetDialogs(excludePinned, offsetDate, offsetId, offsetPeer, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Int,
            mimeType: String
    ): Single<TLAbsDocument> = executeRpcQuery(TLRequestMessagesGetDocumentByHash(sha256, size, mimeType))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetFavedStickers(hash: Int): Single<TLAbsFavedStickers> = executeRpcQuery(TLRequestMessagesGetFavedStickers(hash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetFeaturedStickers(hash: Int): Single<TLAbsFeaturedStickers> = executeRpcQuery(TLRequestMessagesGetFeaturedStickers(hash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetFullChat(chatId: Int): Single<TLChatFull> = executeRpcQuery(TLRequestMessagesGetFullChat(chatId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): Single<TLHighScores> = executeRpcQuery(TLRequestMessagesGetGameHighScores(peer, id, userId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages> = executeRpcQuery(TLRequestMessagesGetHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): Single<TLBotResults> = executeRpcQuery(TLRequestMessagesGetInlineBotResults(bot, peer, geoPoint, query, offset))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetInlineGameHighScores(id: TLInputBotInlineMessageID, userId: TLAbsInputUser): Single<TLHighScores> = executeRpcQuery(TLRequestMessagesGetInlineGameHighScores(id, userId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetMaskStickers(hash: Int): Single<TLAbsAllStickers> = executeRpcQuery(TLRequestMessagesGetMaskStickers(hash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): Single<TLMessageEditData> = executeRpcQuery(TLRequestMessagesGetMessageEditData(peer, id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetMessages(id: TLIntVector): Single<TLAbsMessages> = executeRpcQuery(TLRequestMessagesGetMessages(id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): Single<TLIntVector> = executeRpcQuery(TLRequestMessagesGetMessagesViews(peer, id, increment))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetPeerDialogs(peers: TLObjectVector<TLAbsInputPeer>): Single<TLPeerDialogs> = executeRpcQuery(TLRequestMessagesGetPeerDialogs(peers))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetPeerSettings(peer: TLAbsInputPeer): Single<TLPeerSettings> = executeRpcQuery(TLRequestMessagesGetPeerSettings(peer))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetPinnedDialogs(): Single<TLPeerDialogs> = executeRpcQuery(TLRequestMessagesGetPinnedDialogs())

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetRecentStickers(attached: Boolean, hash: Int): Single<TLAbsRecentStickers> = executeRpcQuery(TLRequestMessagesGetRecentStickers(attached, hash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetSavedGifs(hash: Int): Single<TLAbsSavedGifs> = executeRpcQuery(TLRequestMessagesGetSavedGifs(hash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet): Single<TLStickerSet> = executeRpcQuery(TLRequestMessagesGetStickerSet(stickerset))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages> = executeRpcQuery(TLRequestMessagesGetUnreadMentions(peer, offsetId, addOffset, limit, maxId, minId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetWebPage(url: String, hash: Int): Single<TLAbsWebPage> = executeRpcQuery(TLRequestMessagesGetWebPage(url, hash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesGetWebPagePreview(message: String): Single<TLAbsMessageMedia> = executeRpcQuery(TLRequestMessagesGetWebPagePreview(message))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesImportChatInvite(hash: String): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesImportChatInvite(hash))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): Single<TLAbsStickerSetInstallResult> = executeRpcQuery(TLRequestMessagesInstallStickerSet(stickerset, archived))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesMigrateChat(chatId: Int): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesMigrateChat(chatId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): Single<TLAffectedMessages> = executeRpcQuery(TLRequestMessagesReadHistory(peer, maxId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesReadMessageContents(id: TLIntVector): Single<TLAffectedMessages> = executeRpcQuery(TLRequestMessagesReadMessageContents(id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesReceivedMessages(maxId: Int): Single<TLObjectVector<TLReceivedNotifyMessage>> = executeRpcQuery(TLRequestMessagesReceivedMessages(maxId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesReceivedQueue(maxQts: Int): Single<TLLongVector> = executeRpcQuery(TLRequestMessagesReceivedQueue(maxQts))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): Single<TLAbsEncryptedChat> = executeRpcQuery(TLRequestMessagesRequestEncryption(userId, randomId, gA))

    @Throws(RpcErrorException::class,IOException::class)
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

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesSearchGifs(q: String, offset: Int): Single<TLFoundGifs> = executeRpcQuery(TLRequestMessagesSearchGifs(q, offset))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesSearchGlobal(
            q: String,
            offsetDate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): Single<TLAbsMessages> = executeRpcQuery(TLRequestMessagesSearchGlobal(q, offsetDate, offsetPeer, offsetId, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesSendEncrypted(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage> = executeRpcQuery(TLRequestMessagesSendEncrypted(peer, randomId, data))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesSendEncryptedFile(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): Single<TLAbsSentEncryptedMessage> = executeRpcQuery(TLRequestMessagesSendEncryptedFile(peer, randomId, data, file))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage> = executeRpcQuery(TLRequestMessagesSendEncryptedService(peer, randomId, data))

    @Throws(RpcErrorException::class,IOException::class)
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

    @Throws(RpcErrorException::class,IOException::class)
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

    @Throws(RpcErrorException::class,IOException::class)
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

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyToMsgId: Int,
            randomId: Long
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesSendScreenshotNotification(peer, replyToMsgId, randomId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesSetGameScore(editMessage, force, peer, id, userId, score))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesStartBot(bot, peer, randomId, startParam))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesToggleChatAdmins(chatId: Int, enabled: Boolean): Single<TLAbsUpdates> = executeRpcQuery(TLRequestMessagesToggleChatAdmins(chatId, enabled))

    @Throws(RpcErrorException::class,IOException::class)
    override fun messagesUploadMedia(peer: TLAbsInputPeer, media: TLAbsInputMedia): Single<TLAbsMessageMedia> = executeRpcQuery(TLRequestMessagesUploadMedia(peer, media))

    @Throws(RpcErrorException::class,IOException::class)
    override fun paymentsGetPaymentForm(msgId: Int): Single<TLPaymentForm> = executeRpcQuery(TLRequestPaymentsGetPaymentForm(msgId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun paymentsGetPaymentReceipt(msgId: Int): Single<TLPaymentReceipt> = executeRpcQuery(TLRequestPaymentsGetPaymentReceipt(msgId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun paymentsGetSavedInfo(): Single<TLSavedInfo> = executeRpcQuery(TLRequestPaymentsGetSavedInfo())

    @Throws(RpcErrorException::class,IOException::class)
    override fun paymentsSendPaymentForm(
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials
    ): Single<TLAbsPaymentResult> = executeRpcQuery(TLRequestPaymentsSendPaymentForm(msgId, requestedInfoId, shippingOptionId, credentials))

    @Throws(RpcErrorException::class,IOException::class)
    override fun paymentsValidateRequestedInfo(
            save: Boolean,
            msgId: Int,
            info: TLPaymentRequestedInfo
    ): Single<TLValidatedRequestedInfo> = executeRpcQuery(TLRequestPaymentsValidateRequestedInfo(save, msgId, info))

    @Throws(RpcErrorException::class,IOException::class)
    override fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeRpcQuery(TLRequestPhoneAcceptCall(peer, gB, protocol))

    @Throws(RpcErrorException::class,IOException::class)
    override fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeRpcQuery(TLRequestPhoneConfirmCall(peer, gA, keyFingerprint, protocol))

    @Throws(RpcErrorException::class,IOException::class)
    override fun phoneDiscardCall(
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestPhoneDiscardCall(peer, duration, reason, connectionId))

    @Throws(RpcErrorException::class,IOException::class)
    override fun phoneGetCallConfig(): Single<TLDataJSON> = executeRpcQuery(TLRequestPhoneGetCallConfig())

    @Throws(RpcErrorException::class,IOException::class)
    override fun phoneRequestCall(
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeRpcQuery(TLRequestPhoneRequestCall(userId, randomId, gAHash, protocol))

    @Throws(RpcErrorException::class,IOException::class)
    override fun phoneSetCallRating(
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): Single<TLAbsUpdates> = executeRpcQuery(TLRequestPhoneSetCallRating(peer, rating, comment))

    @Throws(RpcErrorException::class,IOException::class)
    override fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): Single<TLLongVector> = executeRpcQuery(TLRequestPhotosDeletePhotos(id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): Single<TLAbsPhotos> = executeRpcQuery(TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun photosUpdateProfilePhoto(id: TLAbsInputPhoto): Single<TLAbsUserProfilePhoto> = executeRpcQuery(TLRequestPhotosUpdateProfilePhoto(id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun photosUploadProfilePhoto(file: TLAbsInputFile): Single<TLPhoto> = executeRpcQuery(TLRequestPhotosUploadProfilePhoto(file))

    @Throws(RpcErrorException::class,IOException::class)
    override fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): Single<TLStickerSet> = executeRpcQuery(TLRequestStickersAddStickerToSet(stickerset, sticker))

    @Throws(RpcErrorException::class,IOException::class)
    override fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): Single<TLStickerSet> = executeRpcQuery(TLRequestStickersChangeStickerPosition(sticker, position))

    @Throws(RpcErrorException::class,IOException::class)
    override fun stickersCreateStickerSet(
            masks: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            stickers: TLObjectVector<TLInputStickerSetItem>
    ): Single<TLStickerSet> = executeRpcQuery(TLRequestStickersCreateStickerSet(masks, userId, title, shortName, stickers))

    @Throws(RpcErrorException::class,IOException::class)
    override fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): Single<TLStickerSet> = executeRpcQuery(TLRequestStickersRemoveStickerFromSet(sticker))

    @Throws(RpcErrorException::class,IOException::class)
    override fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): Single<TLAbsChannelDifference> = executeRpcQuery(TLRequestUpdatesGetChannelDifference(force, channel, filter, pts, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun updatesGetDifference(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ): Single<TLAbsDifference> = executeRpcQuery(TLRequestUpdatesGetDifference(pts, ptsTotalLimit, date, qts))

    @Throws(RpcErrorException::class,IOException::class)
    override fun updatesGetState(): Single<TLState> = executeRpcQuery(TLRequestUpdatesGetState())

    @Throws(RpcErrorException::class,IOException::class)
    override fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Int,
            limit: Int
    ): Single<TLAbsCdnFile> = executeRpcQuery(TLRequestUploadGetCdnFile(fileToken, offset, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Int): Single<TLObjectVector<TLCdnFileHash>> = executeRpcQuery(TLRequestUploadGetCdnFileHashes(fileToken, offset))

    @Throws(RpcErrorException::class,IOException::class)
    override fun uploadGetFile(
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLAbsFile> = executeRpcQuery(TLRequestUploadGetFile(location, offset, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun uploadGetWebFile(
            location: TLInputWebFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLWebFile> = executeRpcQuery(TLRequestUploadGetWebFile(location, offset, limit))

    @Throws(RpcErrorException::class,IOException::class)
    override fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): Single<TLObjectVector<TLCdnFileHash>> = executeRpcQuery(TLRequestUploadReuploadCdnFile(fileToken, requestToken))

    @Throws(RpcErrorException::class,IOException::class)
    override fun usersGetFullUser(id: TLAbsInputUser): Single<TLUserFull> = executeRpcQuery(TLRequestUsersGetFullUser(id))

    @Throws(RpcErrorException::class,IOException::class)
    override fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): Single<TLObjectVector<TLAbsUser>> = executeRpcQuery(TLRequestUsersGetUsers(id))
}
