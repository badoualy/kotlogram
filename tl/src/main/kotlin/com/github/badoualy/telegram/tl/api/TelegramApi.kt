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
import io.reactivex.Single

interface TelegramApi {
    fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAbsUser>

    fun accountCheckUsername(username: String): Single<TLBool>

    fun accountConfirmPhone(phoneCodeHash: String, phoneCode: String): Single<TLBool>

    fun accountDeleteAccount(reason: String): Single<TLBool>

    fun accountGetAccountTTL(): Single<TLAccountDaysTTL>

    fun accountGetAuthorizations(): Single<TLAuthorizations>

    fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): Single<TLAbsPeerNotifySettings>

    fun accountGetPassword(): Single<TLAbsPassword>

    fun accountGetPasswordSettings(currentPasswordHash: TLBytes): Single<TLPasswordSettings>

    fun accountGetPrivacy(key: TLAbsInputPrivacyKey): Single<TLPrivacyRules>

    fun accountGetTmpPassword(passwordHash: TLBytes, period: Int): Single<TLTmpPassword>

    fun accountGetWallPapers(): Single<TLObjectVector<TLAbsWallPaper>>

    fun accountRegisterDevice(tokenType: Int, token: String): Single<TLBool>

    fun accountReportPeer(peer: TLAbsInputPeer, reason: TLAbsReportReason): Single<TLBool>

    fun accountResetAuthorization(hash: Long): Single<TLBool>

    fun accountResetNotifySettings(): Single<TLBool>

    fun accountSendChangePhoneCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?
    ): Single<TLSentCode>

    fun accountSendConfirmPhoneCode(
            allowFlashcall: Boolean,
            hash: String,
            currentNumber: Boolean?
    ): Single<TLSentCode>

    fun accountSetAccountTTL(ttl: TLAccountDaysTTL): Single<TLBool>

    fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): Single<TLPrivacyRules>

    fun accountUnregisterDevice(tokenType: Int, token: String): Single<TLBool>

    fun accountUpdateDeviceLocked(period: Int): Single<TLBool>

    fun accountUpdateNotifySettings(peer: TLAbsInputNotifyPeer, settings: TLInputPeerNotifySettings): Single<TLBool>

    fun accountUpdatePasswordSettings(currentPasswordHash: TLBytes, newSettings: TLPasswordInputSettings): Single<TLBool>

    fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): Single<TLAbsUser>

    fun accountUpdateStatus(offline: Boolean): Single<TLBool>

    fun accountUpdateUsername(username: String): Single<TLAbsUser>

    fun authBindTempAuthKey(
            permAuthKeyId: Long,
            nonce: Long,
            expiresAt: Int,
            encryptedMessage: TLBytes
    ): Single<TLBool>

    fun authCancelCode(phoneNumber: String, phoneCodeHash: String): Single<TLBool>

    fun authCheckPassword(passwordHash: TLBytes): Single<TLAuthorization>

    fun authCheckPhone(phoneNumber: String): Single<TLCheckedPhone>

    fun authDropTempAuthKeys(exceptAuthKeys: TLLongVector): Single<TLBool>

    fun authExportAuthorization(dcId: Int): Single<TLExportedAuthorization>

    fun authImportAuthorization(id: Int, bytes: TLBytes): Single<TLAuthorization>

    fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): Single<TLAuthorization>

    fun authLogOut(): Single<TLBool>

    fun authRecoverPassword(code: String): Single<TLAuthorization>

    fun authRequestPasswordRecovery(): Single<TLPasswordRecovery>

    fun authResendCode(phoneNumber: String, phoneCodeHash: String): Single<TLSentCode>

    fun authResetAuthorizations(): Single<TLBool>

    fun authSendCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?,
            apiId: Int,
            apiHash: String
    ): Single<TLSentCode>

    fun authSendInvites(phoneNumbers: TLStringVector, message: String): Single<TLBool>

    fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAuthorization>

    fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String,
            firstName: String,
            lastName: String
    ): Single<TLAuthorization>

    fun botsAnswerWebhookJSONQuery(queryId: Long, data: TLDataJSON): Single<TLBool>

    fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): Single<TLDataJSON>

    fun channelsCheckUsername(channel: TLAbsInputChannel, username: String): Single<TLBool>

    fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            title: String,
            about: String
    ): Single<TLAbsUpdates>

    fun channelsDeleteChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAffectedMessages>

    fun channelsDeleteUserHistory(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLAffectedHistory>

    fun channelsEditAbout(channel: TLAbsInputChannel, about: String): Single<TLBool>

    fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChannelAdminRights
    ): Single<TLAbsUpdates>

    fun channelsEditBanned(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            bannedRights: TLChannelBannedRights
    ): Single<TLAbsUpdates>

    fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates>

    fun channelsEditTitle(channel: TLAbsInputChannel, title: String): Single<TLAbsUpdates>

    fun channelsExportInvite(channel: TLAbsInputChannel): Single<TLAbsExportedChatInvite>

    fun channelsExportMessageLink(channel: TLAbsInputChannel, id: Int): Single<TLExportedMessageLink>

    fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): Single<TLAdminLogResults>

    fun channelsGetAdminedPublicChannels(): Single<TLAbsChats>

    fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): Single<TLAbsChats>

    fun channelsGetFullChannel(channel: TLAbsInputChannel): Single<TLChatFull>

    fun channelsGetMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAbsMessages>

    fun channelsGetParticipant(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLChannelParticipant>

    fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int
    ): Single<TLChannelParticipants>

    fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates>

    fun channelsJoinChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    fun channelsLeaveChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates>

    fun channelsReadHistory(channel: TLAbsInputChannel, maxId: Int): Single<TLBool>

    fun channelsReadMessageContents(channel: TLAbsInputChannel, id: TLIntVector): Single<TLBool>

    fun channelsReportSpam(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            id: TLIntVector
    ): Single<TLBool>

    fun channelsSetStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): Single<TLBool>

    fun channelsToggleInvites(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates>

    fun channelsUpdatePinnedMessage(
            silent: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): Single<TLAbsUpdates>

    fun channelsUpdateUsername(channel: TLAbsInputChannel, username: String): Single<TLBool>

    fun contactsBlock(id: TLAbsInputUser): Single<TLBool>

    fun contactsDeleteContact(id: TLAbsInputUser): Single<TLLink>

    fun contactsDeleteContacts(id: TLObjectVector<TLAbsInputUser>): Single<TLBool>

    fun contactsExportCard(): Single<TLIntVector>

    fun contactsGetBlocked(offset: Int, limit: Int): Single<TLAbsBlocked>

    fun contactsGetContacts(hash: Int): Single<TLAbsContacts>

    fun contactsGetStatuses(): Single<TLObjectVector<TLContactStatus>>

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

    fun contactsImportCard(exportCard: TLIntVector): Single<TLAbsUser>

    fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): Single<TLImportedContacts>

    fun contactsResetSaved(): Single<TLBool>

    fun contactsResetTopPeerRating(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer): Single<TLBool>

    fun contactsResolveUsername(username: String): Single<TLResolvedPeer>

    fun contactsSearch(q: String, limit: Int): Single<TLFound>

    fun contactsUnblock(id: TLAbsInputUser): Single<TLBool>

    fun helpGetAppChangelog(prevAppVersion: String): Single<TLAbsUpdates>

    fun helpGetAppUpdate(): Single<TLAbsAppUpdate>

    fun helpGetCdnConfig(): Single<TLCdnConfig>

    fun helpGetConfig(): Single<TLConfig>

    fun helpGetInviteText(): Single<TLInviteText>

    fun helpGetNearestDc(): Single<TLNearestDc>

    fun helpGetSupport(): Single<TLSupport>

    fun helpGetTermsOfService(): Single<TLTermsOfService>

    fun helpSaveAppLog(events: TLObjectVector<TLInputAppEvent>): Single<TLBool>

    fun helpSetBotUpdatesStatus(pendingUpdatesCount: Int, message: String): Single<TLBool>

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

    fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>?): Single<T>

    fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>?): Single<T>

    fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>?): Single<T>

    fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>?): Single<T>

    fun langpackGetDifference(fromVersion: Int): Single<TLLangPackDifference>

    fun langpackGetLangPack(langCode: String): Single<TLLangPackDifference>

    fun langpackGetLanguages(): Single<TLObjectVector<TLLangPackLanguage>>

    fun langpackGetStrings(langCode: String, keys: TLStringVector): Single<TLObjectVector<TLAbsLangPackString>>

    fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): Single<TLAbsEncryptedChat>

    fun messagesAddChatUser(
            chatId: Int,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): Single<TLAbsUpdates>

    fun messagesCheckChatInvite(hash: String): Single<TLAbsChatInvite>

    fun messagesClearRecentStickers(attached: Boolean): Single<TLBool>

    fun messagesCreateChat(users: TLObjectVector<TLAbsInputUser>, title: String): Single<TLAbsUpdates>

    fun messagesDeleteChatUser(chatId: Int, userId: TLAbsInputUser): Single<TLAbsUpdates>

    fun messagesDeleteHistory(
            justClear: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int
    ): Single<TLAffectedHistory>

    fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): Single<TLAffectedMessages>

    fun messagesDiscardEncryption(chatId: Int): Single<TLBool>

    fun messagesEditChatAdmin(
            chatId: Int,
            userId: TLAbsInputUser,
            isAdmin: Boolean
    ): Single<TLBool>

    fun messagesEditChatPhoto(chatId: Int, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates>

    fun messagesEditChatTitle(chatId: Int, title: String): Single<TLAbsUpdates>

    fun messagesEditInlineBotMessage(
            noWebpage: Boolean,
            id: TLInputBotInlineMessageID,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLBool>

    fun messagesEditMessage(
            noWebpage: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLAbsUpdates>

    fun messagesExportChatInvite(chatId: Int): Single<TLAbsExportedChatInvite>

    fun messagesFaveSticker(id: TLAbsInputDocument, unfave: Boolean): Single<TLBool>

    fun messagesForwardMessage(
            peer: TLAbsInputPeer,
            id: Int,
            randomId: Long
    ): Single<TLAbsUpdates>

    fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer
    ): Single<TLAbsUpdates>

    fun messagesGetAllChats(exceptIds: TLIntVector): Single<TLAbsChats>

    fun messagesGetAllDrafts(): Single<TLAbsUpdates>

    fun messagesGetAllStickers(hash: Int): Single<TLAbsAllStickers>

    fun messagesGetArchivedStickers(
            masks: Boolean,
            offsetId: Long,
            limit: Int
    ): Single<TLArchivedStickers>

    fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): Single<TLObjectVector<TLAbsStickerSetCovered>>

    fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?
    ): Single<TLBotCallbackAnswer>

    fun messagesGetChats(id: TLIntVector): Single<TLAbsChats>

    fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Int,
            limit: Int
    ): Single<TLAbsChats>

    fun messagesGetDhConfig(version: Int, randomLength: Int): Single<TLAbsDhConfig>

    fun messagesGetDialogs(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int
    ): Single<TLAbsDialogs>

    fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Int,
            mimeType: String
    ): Single<TLAbsDocument>

    fun messagesGetFavedStickers(hash: Int): Single<TLAbsFavedStickers>

    fun messagesGetFeaturedStickers(hash: Int): Single<TLAbsFeaturedStickers>

    fun messagesGetFullChat(chatId: Int): Single<TLChatFull>

    fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): Single<TLHighScores>

    fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages>

    fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): Single<TLBotResults>

    fun messagesGetInlineGameHighScores(id: TLInputBotInlineMessageID, userId: TLAbsInputUser): Single<TLHighScores>

    fun messagesGetMaskStickers(hash: Int): Single<TLAbsAllStickers>

    fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): Single<TLMessageEditData>

    fun messagesGetMessages(id: TLIntVector): Single<TLAbsMessages>

    fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): Single<TLIntVector>

    fun messagesGetPeerDialogs(peers: TLObjectVector<TLAbsInputPeer>): Single<TLPeerDialogs>

    fun messagesGetPeerSettings(peer: TLAbsInputPeer): Single<TLPeerSettings>

    fun messagesGetPinnedDialogs(): Single<TLPeerDialogs>

    fun messagesGetRecentStickers(attached: Boolean, hash: Int): Single<TLAbsRecentStickers>

    fun messagesGetSavedGifs(hash: Int): Single<TLAbsSavedGifs>

    fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet): Single<TLStickerSet>

    fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages>

    fun messagesGetWebPage(url: String, hash: Int): Single<TLAbsWebPage>

    fun messagesGetWebPagePreview(message: String): Single<TLAbsMessageMedia>

    fun messagesHideReportSpam(peer: TLAbsInputPeer): Single<TLBool>

    fun messagesImportChatInvite(hash: String): Single<TLAbsUpdates>

    fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): Single<TLAbsStickerSetInstallResult>

    fun messagesMigrateChat(chatId: Int): Single<TLAbsUpdates>

    fun messagesReadEncryptedHistory(peer: TLInputEncryptedChat, maxDate: Int): Single<TLBool>

    fun messagesReadFeaturedStickers(id: TLLongVector): Single<TLBool>

    fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): Single<TLAffectedMessages>

    fun messagesReadMessageContents(id: TLIntVector): Single<TLAffectedMessages>

    fun messagesReceivedMessages(maxId: Int): Single<TLObjectVector<TLReceivedNotifyMessage>>

    fun messagesReceivedQueue(maxQts: Int): Single<TLLongVector>

    fun messagesReorderPinnedDialogs(force: Boolean, order: TLObjectVector<TLAbsInputPeer>): Single<TLBool>

    fun messagesReorderStickerSets(masks: Boolean, order: TLLongVector): Single<TLBool>

    fun messagesReportEncryptedSpam(peer: TLInputEncryptedChat): Single<TLBool>

    fun messagesReportSpam(peer: TLAbsInputPeer): Single<TLBool>

    fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): Single<TLAbsEncryptedChat>

    fun messagesSaveDraft(
            noWebpage: Boolean,
            replyToMsgId: Int?,
            peer: TLAbsInputPeer,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLBool>

    fun messagesSaveGif(id: TLAbsInputDocument, unsave: Boolean): Single<TLBool>

    fun messagesSaveRecentSticker(
            attached: Boolean,
            id: TLAbsInputDocument,
            unsave: Boolean
    ): Single<TLBool>

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

    fun messagesSearchGifs(q: String, offset: Int): Single<TLFoundGifs>

    fun messagesSearchGlobal(
            q: String,
            offsetDate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): Single<TLAbsMessages>

    fun messagesSendEncrypted(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage>

    fun messagesSendEncryptedFile(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): Single<TLAbsSentEncryptedMessage>

    fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage>

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

    fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyToMsgId: Int,
            randomId: Long
    ): Single<TLAbsUpdates>

    fun messagesSetBotCallbackAnswer(
            alert: Boolean,
            queryId: Long,
            message: String?,
            url: String?,
            cacheTime: Int
    ): Single<TLBool>

    fun messagesSetBotPrecheckoutResults(
            success: Boolean,
            queryId: Long,
            error: String?
    ): Single<TLBool>

    fun messagesSetBotShippingResults(
            queryId: Long,
            error: String?,
            shippingOptions: TLObjectVector<TLShippingOption>?
    ): Single<TLBool>

    fun messagesSetEncryptedTyping(peer: TLInputEncryptedChat, typing: Boolean): Single<TLBool>

    fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLAbsUpdates>

    fun messagesSetInlineBotResults(
            gallery: Boolean,
            _private: Boolean,
            queryId: Long,
            results: TLObjectVector<TLAbsInputBotInlineResult>,
            cacheTime: Int,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?
    ): Single<TLBool>

    fun messagesSetInlineGameScore(
            editMessage: Boolean,
            force: Boolean,
            id: TLInputBotInlineMessageID,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLBool>

    fun messagesSetTyping(peer: TLAbsInputPeer, action: TLAbsSendMessageAction): Single<TLBool>

    fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): Single<TLAbsUpdates>

    fun messagesToggleChatAdmins(chatId: Int, enabled: Boolean): Single<TLAbsUpdates>

    fun messagesToggleDialogPin(pinned: Boolean, peer: TLAbsInputPeer): Single<TLBool>

    fun messagesUninstallStickerSet(stickerset: TLAbsInputStickerSet): Single<TLBool>

    fun messagesUploadMedia(peer: TLAbsInputPeer, media: TLAbsInputMedia): Single<TLAbsMessageMedia>

    fun paymentsClearSavedInfo(credentials: Boolean, info: Boolean): Single<TLBool>

    fun paymentsGetPaymentForm(msgId: Int): Single<TLPaymentForm>

    fun paymentsGetPaymentReceipt(msgId: Int): Single<TLPaymentReceipt>

    fun paymentsGetSavedInfo(): Single<TLSavedInfo>

    fun paymentsSendPaymentForm(
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials
    ): Single<TLAbsPaymentResult>

    fun paymentsValidateRequestedInfo(
            save: Boolean,
            msgId: Int,
            info: TLPaymentRequestedInfo
    ): Single<TLValidatedRequestedInfo>

    fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall>

    fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall>

    fun phoneDiscardCall(
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): Single<TLAbsUpdates>

    fun phoneGetCallConfig(): Single<TLDataJSON>

    fun phoneReceivedCall(peer: TLInputPhoneCall): Single<TLBool>

    fun phoneRequestCall(
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall>

    fun phoneSaveCallDebug(peer: TLInputPhoneCall, debug: TLDataJSON): Single<TLBool>

    fun phoneSetCallRating(
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): Single<TLAbsUpdates>

    fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): Single<TLLongVector>

    fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): Single<TLAbsPhotos>

    fun photosUpdateProfilePhoto(id: TLAbsInputPhoto): Single<TLAbsUserProfilePhoto>

    fun photosUploadProfilePhoto(file: TLAbsInputFile): Single<TLPhoto>

    fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): Single<TLStickerSet>

    fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): Single<TLStickerSet>

    fun stickersCreateStickerSet(
            masks: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            stickers: TLObjectVector<TLInputStickerSetItem>
    ): Single<TLStickerSet>

    fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): Single<TLStickerSet>

    fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): Single<TLAbsChannelDifference>

    fun updatesGetDifference(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ): Single<TLAbsDifference>

    fun updatesGetState(): Single<TLState>

    fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Int,
            limit: Int
    ): Single<TLAbsCdnFile>

    fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Int): Single<TLObjectVector<TLCdnFileHash>>

    fun uploadGetFile(
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLAbsFile>

    fun uploadGetWebFile(
            location: TLInputWebFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLWebFile>

    fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): Single<TLObjectVector<TLCdnFileHash>>

    fun uploadSaveBigFilePart(
            fileId: Long,
            filePart: Int,
            fileTotalParts: Int,
            bytes: TLBytes
    ): Single<TLBool>

    fun uploadSaveFilePart(
            fileId: Long,
            filePart: Int,
            bytes: TLBytes
    ): Single<TLBool>

    fun usersGetFullUser(id: TLAbsInputUser): Single<TLUserFull>

    fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): Single<TLObjectVector<TLAbsUser>>
}
