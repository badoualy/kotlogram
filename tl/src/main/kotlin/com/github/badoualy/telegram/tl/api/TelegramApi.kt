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
import io.reactivex.Single
import java.io.IOException

interface TelegramApi {
    @Throws(RpcErrorException::class,IOException::class)
    fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAbsUser>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountGetAccountTTL(): Single<TLAccountDaysTTL>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountGetAuthorizations(): Single<TLAuthorizations>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): Single<TLAbsPeerNotifySettings>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountGetPassword(): Single<TLAbsPassword>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountGetPasswordSettings(currentPasswordHash: TLBytes): Single<TLPasswordSettings>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountGetPrivacy(key: TLAbsInputPrivacyKey): Single<TLPrivacyRules>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountGetTmpPassword(passwordHash: TLBytes, period: Int): Single<TLTmpPassword>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountGetWallPapers(): Single<TLObjectVector<TLAbsWallPaper>>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountSendChangePhoneCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?
    ): Single<TLSentCode>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountSendConfirmPhoneCode(
            allowFlashcall: Boolean,
            hash: String,
            currentNumber: Boolean?
    ): Single<TLSentCode>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): Single<TLPrivacyRules>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): Single<TLAbsUser>

    @Throws(RpcErrorException::class,IOException::class)
    fun accountUpdateUsername(username: String): Single<TLAbsUser>

    @Throws(RpcErrorException::class,IOException::class)
    fun authCheckPassword(passwordHash: TLBytes): Single<TLAuthorization>

    @Throws(RpcErrorException::class,IOException::class)
    fun authCheckPhone(phoneNumber: String): Single<TLCheckedPhone>

    @Throws(RpcErrorException::class,IOException::class)
    fun authExportAuthorization(dcId: Int): Single<TLExportedAuthorization>

    @Throws(RpcErrorException::class,IOException::class)
    fun authImportAuthorization(id: Int, bytes: TLBytes): Single<TLAuthorization>

    @Throws(RpcErrorException::class,IOException::class)
    fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): Single<TLAuthorization>

    @Throws(RpcErrorException::class,IOException::class)
    fun authRecoverPassword(code: String): Single<TLAuthorization>

    @Throws(RpcErrorException::class,IOException::class)
    fun authRequestPasswordRecovery(): Single<TLPasswordRecovery>

    @Throws(RpcErrorException::class,IOException::class)
    fun authResendCode(phoneNumber: String, phoneCodeHash: String): Single<TLSentCode>

    @Throws(RpcErrorException::class,IOException::class)
    fun authSendCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?,
            apiId: Int,
            apiHash: String
    ): Single<TLSentCode>

    @Throws(RpcErrorException::class,IOException::class)
    fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAuthorization>

    @Throws(RpcErrorException::class,IOException::class)
    fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String,
            firstName: String,
            lastName: String
    ): Single<TLAuthorization>

    @Throws(RpcErrorException::class,IOException::class)
    fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): Single<TLDataJSON>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            title: String,
            about: String
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsDeleteChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAffectedMessages>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsDeleteUserHistory(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLAffectedHistory>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChannelAdminRights
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsEditBanned(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            bannedRights: TLChannelBannedRights
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsEditTitle(channel: TLAbsInputChannel, title: String): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsExportInvite(channel: TLAbsInputChannel): Single<TLAbsExportedChatInvite>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsExportMessageLink(channel: TLAbsInputChannel, id: Int): Single<TLExportedMessageLink>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): Single<TLAdminLogResults>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsGetAdminedPublicChannels(): Single<TLAbsChats>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): Single<TLAbsChats>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsGetFullChannel(channel: TLAbsInputChannel): Single<TLChatFull>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsGetMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAbsMessages>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsGetParticipant(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLChannelParticipant>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int
    ): Single<TLChannelParticipants>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsJoinChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsLeaveChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsToggleInvites(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun channelsUpdatePinnedMessage(
            silent: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun contactsDeleteContact(id: TLAbsInputUser): Single<TLLink>

    @Throws(RpcErrorException::class,IOException::class)
    fun contactsExportCard(): Single<TLIntVector>

    @Throws(RpcErrorException::class,IOException::class)
    fun contactsGetBlocked(offset: Int, limit: Int): Single<TLAbsBlocked>

    @Throws(RpcErrorException::class,IOException::class)
    fun contactsGetContacts(hash: Int): Single<TLAbsContacts>

    @Throws(RpcErrorException::class,IOException::class)
    fun contactsGetStatuses(): Single<TLObjectVector<TLContactStatus>>

    @Throws(RpcErrorException::class,IOException::class)
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
    ): Single<TLAbsTopPeers>

    @Throws(RpcErrorException::class,IOException::class)
    fun contactsImportCard(exportCard: TLIntVector): Single<TLAbsUser>

    @Throws(RpcErrorException::class,IOException::class)
    fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): Single<TLImportedContacts>

    @Throws(RpcErrorException::class,IOException::class)
    fun contactsResolveUsername(username: String): Single<TLResolvedPeer>

    @Throws(RpcErrorException::class,IOException::class)
    fun contactsSearch(q: String, limit: Int): Single<TLFound>

    @Throws(RpcErrorException::class,IOException::class)
    fun helpGetAppChangelog(prevAppVersion: String): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun helpGetAppUpdate(): Single<TLAbsAppUpdate>

    @Throws(RpcErrorException::class,IOException::class)
    fun helpGetCdnConfig(): Single<TLCdnConfig>

    @Throws(RpcErrorException::class,IOException::class)
    fun helpGetConfig(): Single<TLConfig>

    @Throws(RpcErrorException::class,IOException::class)
    fun helpGetInviteText(): Single<TLInviteText>

    @Throws(RpcErrorException::class,IOException::class)
    fun helpGetNearestDc(): Single<TLNearestDc>

    @Throws(RpcErrorException::class,IOException::class)
    fun helpGetSupport(): Single<TLSupport>

    @Throws(RpcErrorException::class,IOException::class)
    fun helpGetTermsOfService(): Single<TLTermsOfService>

    @Throws(RpcErrorException::class,IOException::class)
    fun <T : TLObject> initConnection(
            apiId: Int,
            deviceModel: String,
            systemVersion: String,
            appVersion: String,
            systemLangCode: String,
            langPack: String,
            langCode: String,
            query: TLMethod<T>?
    ): Single<T>

    @Throws(RpcErrorException::class,IOException::class)
    fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>?): Single<T>

    @Throws(RpcErrorException::class,IOException::class)
    fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>?): Single<T>

    @Throws(RpcErrorException::class,IOException::class)
    fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>?): Single<T>

    @Throws(RpcErrorException::class,IOException::class)
    fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>?): Single<T>

    @Throws(RpcErrorException::class,IOException::class)
    fun langpackGetDifference(fromVersion: Int): Single<TLLangPackDifference>

    @Throws(RpcErrorException::class,IOException::class)
    fun langpackGetLangPack(langCode: String): Single<TLLangPackDifference>

    @Throws(RpcErrorException::class,IOException::class)
    fun langpackGetLanguages(): Single<TLObjectVector<TLLangPackLanguage>>

    @Throws(RpcErrorException::class,IOException::class)
    fun langpackGetStrings(langCode: String, keys: TLStringVector): Single<TLObjectVector<TLAbsLangPackString>>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): Single<TLAbsEncryptedChat>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesAddChatUser(
            chatId: Int,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesCheckChatInvite(hash: String): Single<TLAbsChatInvite>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesCreateChat(users: TLObjectVector<TLAbsInputUser>, title: String): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesDeleteChatUser(chatId: Int, userId: TLAbsInputUser): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesDeleteHistory(
            justClear: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int
    ): Single<TLAffectedHistory>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): Single<TLAffectedMessages>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesEditChatPhoto(chatId: Int, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesEditChatTitle(chatId: Int, title: String): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesEditMessage(
            noWebpage: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesExportChatInvite(chatId: Int): Single<TLAbsExportedChatInvite>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesForwardMessage(
            peer: TLAbsInputPeer,
            id: Int,
            randomId: Long
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetAllChats(exceptIds: TLIntVector): Single<TLAbsChats>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetAllDrafts(): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetAllStickers(hash: Int): Single<TLAbsAllStickers>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetArchivedStickers(
            masks: Boolean,
            offsetId: Long,
            limit: Int
    ): Single<TLArchivedStickers>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): Single<TLObjectVector<TLAbsStickerSetCovered>>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?
    ): Single<TLBotCallbackAnswer>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetChats(id: TLIntVector): Single<TLAbsChats>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Int,
            limit: Int
    ): Single<TLAbsChats>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetDhConfig(version: Int, randomLength: Int): Single<TLAbsDhConfig>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetDialogs(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int
    ): Single<TLAbsDialogs>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Int,
            mimeType: String
    ): Single<TLAbsDocument>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetFavedStickers(hash: Int): Single<TLAbsFavedStickers>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetFeaturedStickers(hash: Int): Single<TLAbsFeaturedStickers>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetFullChat(chatId: Int): Single<TLChatFull>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): Single<TLHighScores>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): Single<TLBotResults>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetInlineGameHighScores(id: TLInputBotInlineMessageID, userId: TLAbsInputUser): Single<TLHighScores>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetMaskStickers(hash: Int): Single<TLAbsAllStickers>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): Single<TLMessageEditData>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetMessages(id: TLIntVector): Single<TLAbsMessages>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): Single<TLIntVector>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetPeerDialogs(peers: TLObjectVector<TLAbsInputPeer>): Single<TLPeerDialogs>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetPeerSettings(peer: TLAbsInputPeer): Single<TLPeerSettings>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetPinnedDialogs(): Single<TLPeerDialogs>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetRecentStickers(attached: Boolean, hash: Int): Single<TLAbsRecentStickers>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetSavedGifs(hash: Int): Single<TLAbsSavedGifs>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet): Single<TLStickerSet>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetWebPage(url: String, hash: Int): Single<TLAbsWebPage>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesGetWebPagePreview(message: String): Single<TLAbsMessageMedia>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesImportChatInvite(hash: String): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): Single<TLAbsStickerSetInstallResult>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesMigrateChat(chatId: Int): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): Single<TLAffectedMessages>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesReadMessageContents(id: TLIntVector): Single<TLAffectedMessages>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesReceivedMessages(maxId: Int): Single<TLObjectVector<TLReceivedNotifyMessage>>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesReceivedQueue(maxQts: Int): Single<TLLongVector>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): Single<TLAbsEncryptedChat>

    @Throws(RpcErrorException::class,IOException::class)
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
    ): Single<TLAbsMessages>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesSearchGifs(q: String, offset: Int): Single<TLFoundGifs>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesSearchGlobal(
            q: String,
            offsetDate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): Single<TLAbsMessages>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesSendEncrypted(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesSendEncryptedFile(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): Single<TLAbsSentEncryptedMessage>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesSendInlineBotResult(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            randomId: Long,
            queryId: Long,
            id: String
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesSendMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            media: TLAbsInputMedia,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
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
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyToMsgId: Int,
            randomId: Long
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesToggleChatAdmins(chatId: Int, enabled: Boolean): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun messagesUploadMedia(peer: TLAbsInputPeer, media: TLAbsInputMedia): Single<TLAbsMessageMedia>

    @Throws(RpcErrorException::class,IOException::class)
    fun paymentsGetPaymentForm(msgId: Int): Single<TLPaymentForm>

    @Throws(RpcErrorException::class,IOException::class)
    fun paymentsGetPaymentReceipt(msgId: Int): Single<TLPaymentReceipt>

    @Throws(RpcErrorException::class,IOException::class)
    fun paymentsGetSavedInfo(): Single<TLSavedInfo>

    @Throws(RpcErrorException::class,IOException::class)
    fun paymentsSendPaymentForm(
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials
    ): Single<TLAbsPaymentResult>

    @Throws(RpcErrorException::class,IOException::class)
    fun paymentsValidateRequestedInfo(
            save: Boolean,
            msgId: Int,
            info: TLPaymentRequestedInfo
    ): Single<TLValidatedRequestedInfo>

    @Throws(RpcErrorException::class,IOException::class)
    fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall>

    @Throws(RpcErrorException::class,IOException::class)
    fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall>

    @Throws(RpcErrorException::class,IOException::class)
    fun phoneDiscardCall(
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun phoneGetCallConfig(): Single<TLDataJSON>

    @Throws(RpcErrorException::class,IOException::class)
    fun phoneRequestCall(
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall>

    @Throws(RpcErrorException::class,IOException::class)
    fun phoneSetCallRating(
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): Single<TLAbsUpdates>

    @Throws(RpcErrorException::class,IOException::class)
    fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): Single<TLLongVector>

    @Throws(RpcErrorException::class,IOException::class)
    fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): Single<TLAbsPhotos>

    @Throws(RpcErrorException::class,IOException::class)
    fun photosUpdateProfilePhoto(id: TLAbsInputPhoto): Single<TLAbsUserProfilePhoto>

    @Throws(RpcErrorException::class,IOException::class)
    fun photosUploadProfilePhoto(file: TLAbsInputFile): Single<TLPhoto>

    @Throws(RpcErrorException::class,IOException::class)
    fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): Single<TLStickerSet>

    @Throws(RpcErrorException::class,IOException::class)
    fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): Single<TLStickerSet>

    @Throws(RpcErrorException::class,IOException::class)
    fun stickersCreateStickerSet(
            masks: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            stickers: TLObjectVector<TLInputStickerSetItem>
    ): Single<TLStickerSet>

    @Throws(RpcErrorException::class,IOException::class)
    fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): Single<TLStickerSet>

    @Throws(RpcErrorException::class,IOException::class)
    fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): Single<TLAbsChannelDifference>

    @Throws(RpcErrorException::class,IOException::class)
    fun updatesGetDifference(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ): Single<TLAbsDifference>

    @Throws(RpcErrorException::class,IOException::class)
    fun updatesGetState(): Single<TLState>

    @Throws(RpcErrorException::class,IOException::class)
    fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Int,
            limit: Int
    ): Single<TLAbsCdnFile>

    @Throws(RpcErrorException::class,IOException::class)
    fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Int): Single<TLObjectVector<TLCdnFileHash>>

    @Throws(RpcErrorException::class,IOException::class)
    fun uploadGetFile(
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLAbsFile>

    @Throws(RpcErrorException::class,IOException::class)
    fun uploadGetWebFile(
            location: TLInputWebFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLWebFile>

    @Throws(RpcErrorException::class,IOException::class)
    fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): Single<TLObjectVector<TLCdnFileHash>>

    @Throws(RpcErrorException::class,IOException::class)
    fun usersGetFullUser(id: TLAbsInputUser): Single<TLUserFull>

    @Throws(RpcErrorException::class,IOException::class)
    fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): Single<TLObjectVector<TLAbsUser>>
}
