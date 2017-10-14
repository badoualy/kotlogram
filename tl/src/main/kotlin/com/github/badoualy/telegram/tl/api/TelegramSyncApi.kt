package com.github.badoualy.telegram.tl.api

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
import com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference
import com.github.badoualy.telegram.tl.api.updates.TLState
import com.github.badoualy.telegram.tl.api.upload.TLAbsCdnFile
import com.github.badoualy.telegram.tl.api.upload.TLAbsFile
import com.github.badoualy.telegram.tl.api.upload.TLWebFile
import com.github.badoualy.telegram.tl.core.*
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.IOException

interface TelegramSyncApi {
    @Throws(RpcErrorException::class, IOException::class)
    fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): TLAbsUser

    @Throws(RpcErrorException::class, IOException::class)
    fun accountCheckUsername(username: String): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountConfirmPhone(phoneCodeHash: String, phoneCode: String): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountDeleteAccount(reason: String): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountGetAccountTTL(): TLAccountDaysTTL

    @Throws(RpcErrorException::class, IOException::class)
    fun accountGetAuthorizations(): TLAuthorizations

    @Throws(RpcErrorException::class, IOException::class)
    fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): TLAbsPeerNotifySettings

    @Throws(RpcErrorException::class, IOException::class)
    fun accountGetPassword(): TLAbsPassword

    @Throws(RpcErrorException::class, IOException::class)
    fun accountGetPasswordSettings(currentPasswordHash: TLBytes): TLPasswordSettings

    @Throws(RpcErrorException::class, IOException::class)
    fun accountGetPrivacy(key: TLAbsInputPrivacyKey): TLPrivacyRules

    @Throws(RpcErrorException::class, IOException::class)
    fun accountGetTmpPassword(passwordHash: TLBytes, period: Int): TLTmpPassword

    @Throws(RpcErrorException::class, IOException::class)
    fun accountGetWallPapers(): TLObjectVector<TLAbsWallPaper>

    @Throws(RpcErrorException::class, IOException::class)
    fun accountRegisterDevice(tokenType: Int, token: String): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountReportPeer(peer: TLAbsInputPeer, reason: TLAbsReportReason): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountResetAuthorization(hash: Long): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountResetNotifySettings(): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountSendChangePhoneCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?
    ): TLSentCode

    @Throws(RpcErrorException::class, IOException::class)
    fun accountSendConfirmPhoneCode(
            allowFlashcall: Boolean,
            hash: String,
            currentNumber: Boolean?
    ): TLSentCode

    @Throws(RpcErrorException::class, IOException::class)
    fun accountSetAccountTTL(ttl: TLAccountDaysTTL): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): TLPrivacyRules

    @Throws(RpcErrorException::class, IOException::class)
    fun accountUnregisterDevice(tokenType: Int, token: String): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountUpdateDeviceLocked(period: Int): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountUpdateNotifySettings(peer: TLAbsInputNotifyPeer, settings: TLInputPeerNotifySettings): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountUpdatePasswordSettings(currentPasswordHash: TLBytes, newSettings: TLPasswordInputSettings): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): TLAbsUser

    @Throws(RpcErrorException::class, IOException::class)
    fun accountUpdateStatus(offline: Boolean): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun accountUpdateUsername(username: String): TLAbsUser

    @Throws(RpcErrorException::class, IOException::class)
    fun authBindTempAuthKey(
            permAuthKeyId: Long,
            nonce: Long,
            expiresAt: Int,
            encryptedMessage: TLBytes
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun authCancelCode(phoneNumber: String, phoneCodeHash: String): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun authCheckPassword(passwordHash: TLBytes): TLAuthorization

    @Throws(RpcErrorException::class, IOException::class)
    fun authCheckPhone(phoneNumber: String): TLCheckedPhone

    @Throws(RpcErrorException::class, IOException::class)
    fun authDropTempAuthKeys(exceptAuthKeys: TLLongVector): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun authExportAuthorization(dcId: Int): TLExportedAuthorization

    @Throws(RpcErrorException::class, IOException::class)
    fun authImportAuthorization(id: Int, bytes: TLBytes): TLAuthorization

    @Throws(RpcErrorException::class, IOException::class)
    fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): TLAuthorization

    @Throws(RpcErrorException::class, IOException::class)
    fun authLogOut(): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun authRecoverPassword(code: String): TLAuthorization

    @Throws(RpcErrorException::class, IOException::class)
    fun authRequestPasswordRecovery(): TLPasswordRecovery

    @Throws(RpcErrorException::class, IOException::class)
    fun authResendCode(phoneNumber: String, phoneCodeHash: String): TLSentCode

    @Throws(RpcErrorException::class, IOException::class)
    fun authResetAuthorizations(): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun authSendCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?,
            apiId: Int,
            apiHash: String
    ): TLSentCode

    @Throws(RpcErrorException::class, IOException::class)
    fun authSendInvites(phoneNumbers: TLStringVector, message: String): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): TLAuthorization

    @Throws(RpcErrorException::class, IOException::class)
    fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String,
            firstName: String,
            lastName: String
    ): TLAuthorization

    @Throws(RpcErrorException::class, IOException::class)
    fun botsAnswerWebhookJSONQuery(queryId: Long, data: TLDataJSON): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): TLDataJSON

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsCheckUsername(channel: TLAbsInputChannel, username: String): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            title: String,
            about: String
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsDeleteChannel(channel: TLAbsInputChannel): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): TLAffectedMessages

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsDeleteUserHistory(channel: TLAbsInputChannel, userId: TLAbsInputUser): TLAffectedHistory

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsEditAbout(channel: TLAbsInputChannel, about: String): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChannelAdminRights
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsEditBanned(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            bannedRights: TLChannelBannedRights
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsEditTitle(channel: TLAbsInputChannel, title: String): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsExportInvite(channel: TLAbsInputChannel): TLAbsExportedChatInvite

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsExportMessageLink(channel: TLAbsInputChannel, id: Int): TLExportedMessageLink

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): TLAdminLogResults

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsGetAdminedPublicChannels(): TLAbsChats

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): TLAbsChats

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsGetFullChannel(channel: TLAbsInputChannel): TLChatFull

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsGetMessages(channel: TLAbsInputChannel, id: TLIntVector): TLAbsMessages

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsGetParticipant(channel: TLAbsInputChannel, userId: TLAbsInputUser): TLChannelParticipant

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int
    ): TLChannelParticipants

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsJoinChannel(channel: TLAbsInputChannel): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsLeaveChannel(channel: TLAbsInputChannel): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsReadHistory(channel: TLAbsInputChannel, maxId: Int): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsReadMessageContents(channel: TLAbsInputChannel, id: TLIntVector): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsReportSpam(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            id: TLIntVector
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsSetStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsToggleInvites(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsUpdatePinnedMessage(
            silent: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun channelsUpdateUsername(channel: TLAbsInputChannel, username: String): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsBlock(id: TLAbsInputUser): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsDeleteContact(id: TLAbsInputUser): TLLink

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsDeleteContacts(id: TLObjectVector<TLAbsInputUser>): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsExportCard(): TLIntVector

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsGetBlocked(offset: Int, limit: Int): TLAbsBlocked

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsGetContacts(hash: Int): TLAbsContacts

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsGetStatuses(): TLObjectVector<TLContactStatus>

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsGetTopPeers(
            correspondents: Boolean,
            botsPm: Boolean,
            botsInline: Boolean,
            phoneCalls: Boolean,
            groups: Boolean,
            channels: Boolean,
            offset: Int,
            limit: Int,
            hash: Int
    ): TLAbsTopPeers

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsImportCard(exportCard: TLIntVector): TLAbsUser

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): TLImportedContacts

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsResetSaved(): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsResetTopPeerRating(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsResolveUsername(username: String): TLResolvedPeer

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsSearch(q: String, limit: Int): TLFound

    @Throws(RpcErrorException::class, IOException::class)
    fun contactsUnblock(id: TLAbsInputUser): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun helpGetAppChangelog(prevAppVersion: String): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun helpGetAppUpdate(): TLAbsAppUpdate

    @Throws(RpcErrorException::class, IOException::class)
    fun helpGetCdnConfig(): TLCdnConfig

    @Throws(RpcErrorException::class, IOException::class)
    fun helpGetConfig(): TLConfig

    @Throws(RpcErrorException::class, IOException::class)
    fun helpGetInviteText(): TLInviteText

    @Throws(RpcErrorException::class, IOException::class)
    fun helpGetNearestDc(): TLNearestDc

    @Throws(RpcErrorException::class, IOException::class)
    fun helpGetSupport(): TLSupport

    @Throws(RpcErrorException::class, IOException::class)
    fun helpGetTermsOfService(): TLTermsOfService

    @Throws(RpcErrorException::class, IOException::class)
    fun helpSaveAppLog(events: TLObjectVector<TLInputAppEvent>): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun helpSetBotUpdatesStatus(pendingUpdatesCount: Int, message: String): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun <T : TLObject> initConnection(
            apiId: Int,
            deviceModel: String,
            systemVersion: String,
            appVersion: String,
            systemLangCode: String,
            langPack: String,
            langCode: String,
            query: TLMethod<T>?
    ): T

    @Throws(RpcErrorException::class, IOException::class)
    fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>?): T

    @Throws(RpcErrorException::class, IOException::class)
    fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>?): T

    @Throws(RpcErrorException::class, IOException::class)
    fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>?): T

    @Throws(RpcErrorException::class, IOException::class)
    fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>?): T

    @Throws(RpcErrorException::class, IOException::class)
    fun langpackGetDifference(fromVersion: Int): TLLangPackDifference

    @Throws(RpcErrorException::class, IOException::class)
    fun langpackGetLangPack(langCode: String): TLLangPackDifference

    @Throws(RpcErrorException::class, IOException::class)
    fun langpackGetLanguages(): TLObjectVector<TLLangPackLanguage>

    @Throws(RpcErrorException::class, IOException::class)
    fun langpackGetStrings(langCode: String, keys: TLStringVector): TLObjectVector<TLAbsLangPackString>

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): TLAbsEncryptedChat

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesAddChatUser(
            chatId: Int,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesCheckChatInvite(hash: String): TLAbsChatInvite

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesClearRecentStickers(attached: Boolean): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesCreateChat(users: TLObjectVector<TLAbsInputUser>, title: String): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesDeleteChatUser(chatId: Int, userId: TLAbsInputUser): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesDeleteHistory(
            justClear: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int
    ): TLAffectedHistory

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): TLAffectedMessages

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesDiscardEncryption(chatId: Int): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesEditChatAdmin(
            chatId: Int,
            userId: TLAbsInputUser,
            isAdmin: Boolean
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesEditChatPhoto(chatId: Int, photo: TLAbsInputChatPhoto): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesEditChatTitle(chatId: Int, title: String): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesEditInlineBotMessage(
            noWebpage: Boolean,
            id: TLInputBotInlineMessageID,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesEditMessage(
            noWebpage: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesExportChatInvite(chatId: Int): TLAbsExportedChatInvite

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesFaveSticker(id: TLAbsInputDocument, unfave: Boolean): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesForwardMessage(
            peer: TLAbsInputPeer,
            id: Int,
            randomId: Long
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetAllChats(exceptIds: TLIntVector): TLAbsChats

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetAllDrafts(): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetAllStickers(hash: Int): TLAbsAllStickers

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetArchivedStickers(
            masks: Boolean,
            offsetId: Long,
            limit: Int
    ): TLArchivedStickers

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): TLObjectVector<TLAbsStickerSetCovered>

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?
    ): TLBotCallbackAnswer

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetChats(id: TLIntVector): TLAbsChats

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Int,
            limit: Int
    ): TLAbsChats

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetDhConfig(version: Int, randomLength: Int): TLAbsDhConfig

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetDialogs(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int
    ): TLAbsDialogs

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Int,
            mimeType: String
    ): TLAbsDocument

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetFavedStickers(hash: Int): TLAbsFavedStickers

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetFeaturedStickers(hash: Int): TLAbsFeaturedStickers

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetFullChat(chatId: Int): TLChatFull

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): TLHighScores

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): TLAbsMessages

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): TLBotResults

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetInlineGameHighScores(id: TLInputBotInlineMessageID, userId: TLAbsInputUser): TLHighScores

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetMaskStickers(hash: Int): TLAbsAllStickers

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): TLMessageEditData

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetMessages(id: TLIntVector): TLAbsMessages

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): TLIntVector

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetPeerDialogs(peers: TLObjectVector<TLAbsInputPeer>): TLPeerDialogs

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetPeerSettings(peer: TLAbsInputPeer): TLPeerSettings

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetPinnedDialogs(): TLPeerDialogs

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetRecentStickers(attached: Boolean, hash: Int): TLAbsRecentStickers

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetSavedGifs(hash: Int): TLAbsSavedGifs

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet): TLStickerSet

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): TLAbsMessages

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetWebPage(url: String, hash: Int): TLAbsWebPage

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesGetWebPagePreview(message: String): TLAbsMessageMedia

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesHideReportSpam(peer: TLAbsInputPeer): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesImportChatInvite(hash: String): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): TLAbsStickerSetInstallResult

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesMigrateChat(chatId: Int): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesReadEncryptedHistory(peer: TLInputEncryptedChat, maxDate: Int): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesReadFeaturedStickers(id: TLLongVector): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): TLAffectedMessages

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesReadMessageContents(id: TLIntVector): TLAffectedMessages

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesReceivedMessages(maxId: Int): TLObjectVector<TLReceivedNotifyMessage>

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesReceivedQueue(maxQts: Int): TLLongVector

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesReorderPinnedDialogs(force: Boolean, order: TLObjectVector<TLAbsInputPeer>): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesReorderStickerSets(masks: Boolean, order: TLLongVector): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesReportEncryptedSpam(peer: TLInputEncryptedChat): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesReportSpam(peer: TLAbsInputPeer): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): TLAbsEncryptedChat

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSaveDraft(
            noWebpage: Boolean,
            replyToMsgId: Int?,
            peer: TLAbsInputPeer,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSaveGif(id: TLAbsInputDocument, unsave: Boolean): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSaveRecentSticker(
            attached: Boolean,
            id: TLAbsInputDocument,
            unsave: Boolean
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSearch(
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
    ): TLAbsMessages

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSearchGifs(q: String, offset: Int): TLFoundGifs

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSearchGlobal(
            q: String,
            offsetDate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): TLAbsMessages

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSendEncrypted(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): TLAbsSentEncryptedMessage

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSendEncryptedFile(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): TLAbsSentEncryptedMessage

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): TLAbsSentEncryptedMessage

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSendInlineBotResult(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            randomId: Long,
            queryId: Long,
            id: String
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSendMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            media: TLAbsInputMedia,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSendMessage(
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
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyToMsgId: Int,
            randomId: Long
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSetBotCallbackAnswer(
            alert: Boolean,
            queryId: Long,
            message: String?,
            url: String?,
            cacheTime: Int
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSetBotPrecheckoutResults(
            success: Boolean,
            queryId: Long,
            error: String?
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSetBotShippingResults(
            queryId: Long,
            error: String?,
            shippingOptions: TLObjectVector<TLShippingOption>?
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSetEncryptedTyping(peer: TLInputEncryptedChat, typing: Boolean): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSetInlineBotResults(
            gallery: Boolean,
            _private: Boolean,
            queryId: Long,
            results: TLObjectVector<TLAbsInputBotInlineResult>,
            cacheTime: Int,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSetInlineGameScore(
            editMessage: Boolean,
            force: Boolean,
            id: TLInputBotInlineMessageID,
            userId: TLAbsInputUser,
            score: Int
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesSetTyping(peer: TLAbsInputPeer, action: TLAbsSendMessageAction): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesToggleChatAdmins(chatId: Int, enabled: Boolean): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesToggleDialogPin(pinned: Boolean, peer: TLAbsInputPeer): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesUninstallStickerSet(stickerset: TLAbsInputStickerSet): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun messagesUploadMedia(peer: TLAbsInputPeer, media: TLAbsInputMedia): TLAbsMessageMedia

    @Throws(RpcErrorException::class, IOException::class)
    fun paymentsClearSavedInfo(credentials: Boolean, info: Boolean): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun paymentsGetPaymentForm(msgId: Int): TLPaymentForm

    @Throws(RpcErrorException::class, IOException::class)
    fun paymentsGetPaymentReceipt(msgId: Int): TLPaymentReceipt

    @Throws(RpcErrorException::class, IOException::class)
    fun paymentsGetSavedInfo(): TLSavedInfo

    @Throws(RpcErrorException::class, IOException::class)
    fun paymentsSendPaymentForm(
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials
    ): TLAbsPaymentResult

    @Throws(RpcErrorException::class, IOException::class)
    fun paymentsValidateRequestedInfo(
            save: Boolean,
            msgId: Int,
            info: TLPaymentRequestedInfo
    ): TLValidatedRequestedInfo

    @Throws(RpcErrorException::class, IOException::class)
    fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall

    @Throws(RpcErrorException::class, IOException::class)
    fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall

    @Throws(RpcErrorException::class, IOException::class)
    fun phoneDiscardCall(
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun phoneGetCallConfig(): TLDataJSON

    @Throws(RpcErrorException::class, IOException::class)
    fun phoneReceivedCall(peer: TLInputPhoneCall): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun phoneRequestCall(
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall

    @Throws(RpcErrorException::class, IOException::class)
    fun phoneSaveCallDebug(peer: TLInputPhoneCall, debug: TLDataJSON): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun phoneSetCallRating(
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): TLAbsUpdates

    @Throws(RpcErrorException::class, IOException::class)
    fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): TLLongVector

    @Throws(RpcErrorException::class, IOException::class)
    fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): TLAbsPhotos

    @Throws(RpcErrorException::class, IOException::class)
    fun photosUpdateProfilePhoto(id: TLAbsInputPhoto): TLAbsUserProfilePhoto

    @Throws(RpcErrorException::class, IOException::class)
    fun photosUploadProfilePhoto(file: TLAbsInputFile): TLPhoto

    @Throws(RpcErrorException::class, IOException::class)
    fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): TLStickerSet

    @Throws(RpcErrorException::class, IOException::class)
    fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): TLStickerSet

    @Throws(RpcErrorException::class, IOException::class)
    fun stickersCreateStickerSet(
            masks: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            stickers: TLObjectVector<TLInputStickerSetItem>
    ): TLStickerSet

    @Throws(RpcErrorException::class, IOException::class)
    fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): TLStickerSet

    @Throws(RpcErrorException::class, IOException::class)
    fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): TLAbsChannelDifference

    @Throws(RpcErrorException::class, IOException::class)
    fun updatesGetDifference(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ): TLAbsDifference

    @Throws(RpcErrorException::class, IOException::class)
    fun updatesGetState(): TLState

    @Throws(RpcErrorException::class, IOException::class)
    fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Int,
            limit: Int
    ): TLAbsCdnFile

    @Throws(RpcErrorException::class, IOException::class)
    fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Int): TLObjectVector<TLCdnFileHash>

    @Throws(RpcErrorException::class, IOException::class)
    fun uploadGetFile(
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ): TLAbsFile

    @Throws(RpcErrorException::class, IOException::class)
    fun uploadGetWebFile(
            location: TLInputWebFileLocation,
            offset: Int,
            limit: Int
    ): TLWebFile

    @Throws(RpcErrorException::class, IOException::class)
    fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): TLObjectVector<TLCdnFileHash>

    @Throws(RpcErrorException::class, IOException::class)
    fun uploadSaveBigFilePart(
            fileId: Long,
            filePart: Int,
            fileTotalParts: Int,
            bytes: TLBytes
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun uploadSaveFilePart(
            fileId: Long,
            filePart: Int,
            bytes: TLBytes
    ): TLBool

    @Throws(RpcErrorException::class, IOException::class)
    fun usersGetFullUser(id: TLAbsInputUser): TLUserFull

    @Throws(RpcErrorException::class, IOException::class)
    fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): TLObjectVector<TLAbsUser>
}
