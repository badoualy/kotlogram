package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.api.account.TLAbsPassword;
import com.github.badoualy.telegram.tl.api.account.TLAuthorizations;
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings;
import com.github.badoualy.telegram.tl.api.account.TLPasswordSettings;
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules;
import com.github.badoualy.telegram.tl.api.account.TLTmpPassword;
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization;
import com.github.badoualy.telegram.tl.api.auth.TLCheckedPhone;
import com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization;
import com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery;
import com.github.badoualy.telegram.tl.api.auth.TLSentCode;
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant;
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipants;
import com.github.badoualy.telegram.tl.api.contacts.TLAbsBlocked;
import com.github.badoualy.telegram.tl.api.contacts.TLAbsContacts;
import com.github.badoualy.telegram.tl.api.contacts.TLAbsTopPeers;
import com.github.badoualy.telegram.tl.api.contacts.TLFound;
import com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts;
import com.github.badoualy.telegram.tl.api.contacts.TLLink;
import com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer;
import com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate;
import com.github.badoualy.telegram.tl.api.help.TLInviteText;
import com.github.badoualy.telegram.tl.api.help.TLSupport;
import com.github.badoualy.telegram.tl.api.help.TLTermsOfService;
import com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers;
import com.github.badoualy.telegram.tl.api.messages.TLAbsChats;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
import com.github.badoualy.telegram.tl.api.messages.TLAbsFeaturedStickers;
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages;
import com.github.badoualy.telegram.tl.api.messages.TLAbsRecentStickers;
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedGifs;
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage;
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSetInstallResult;
import com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory;
import com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages;
import com.github.badoualy.telegram.tl.api.messages.TLArchivedStickers;
import com.github.badoualy.telegram.tl.api.messages.TLBotCallbackAnswer;
import com.github.badoualy.telegram.tl.api.messages.TLBotResults;
import com.github.badoualy.telegram.tl.api.messages.TLChatFull;
import com.github.badoualy.telegram.tl.api.messages.TLFoundGifs;
import com.github.badoualy.telegram.tl.api.messages.TLHighScores;
import com.github.badoualy.telegram.tl.api.messages.TLMessageEditData;
import com.github.badoualy.telegram.tl.api.messages.TLPeerDialogs;
import com.github.badoualy.telegram.tl.api.messages.TLStickerSet;
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult;
import com.github.badoualy.telegram.tl.api.payments.TLPaymentForm;
import com.github.badoualy.telegram.tl.api.payments.TLPaymentReceipt;
import com.github.badoualy.telegram.tl.api.payments.TLSavedInfo;
import com.github.badoualy.telegram.tl.api.payments.TLValidatedRequestedInfo;
import com.github.badoualy.telegram.tl.api.phone.TLPhoneCall;
import com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos;
import com.github.badoualy.telegram.tl.api.photos.TLPhoto;
import com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference;
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference;
import com.github.badoualy.telegram.tl.api.updates.TLState;
import com.github.badoualy.telegram.tl.api.upload.TLAbsCdnFile;
import com.github.badoualy.telegram.tl.api.upload.TLAbsFile;
import com.github.badoualy.telegram.tl.api.upload.TLWebFile;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;
import com.github.badoualy.telegram.tl.core.TLVector;
import com.github.badoualy.telegram.tl.exception.RpcErrorException;

import java.io.IOException;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
@SuppressWarnings({"unused", "unchecked", "RedundantCast"})
public interface TelegramApi {

    TLAbsUser accountChangePhone(String phoneNumber, String phoneCodeHash, String phoneCode) throws RpcErrorException, IOException;

    TLBool accountCheckUsername(String username) throws RpcErrorException, IOException;

    TLBool accountConfirmPhone(String phoneCodeHash, String phoneCode) throws RpcErrorException, IOException;

    TLBool accountDeleteAccount(String reason) throws RpcErrorException, IOException;

    TLAccountDaysTTL accountGetAccountTTL() throws RpcErrorException, IOException;

    TLAuthorizations accountGetAuthorizations() throws RpcErrorException, IOException;

    TLAbsPeerNotifySettings accountGetNotifySettings(TLAbsInputNotifyPeer peer) throws RpcErrorException, IOException;

    TLAbsPassword accountGetPassword() throws RpcErrorException, IOException;

    TLPasswordSettings accountGetPasswordSettings(TLBytes currentPasswordHash) throws RpcErrorException, IOException;

    TLPrivacyRules accountGetPrivacy(TLAbsInputPrivacyKey key) throws RpcErrorException, IOException;

    TLTmpPassword accountGetTmpPassword(TLBytes passwordHash, int period) throws RpcErrorException, IOException;

    TLVector<TLAbsWallPaper> accountGetWallPapers() throws RpcErrorException, IOException;

    TLBool accountRegisterDevice(int tokenType, String token) throws RpcErrorException, IOException;

    TLBool accountReportPeer(TLAbsInputPeer peer, TLAbsReportReason reason) throws RpcErrorException, IOException;

    TLBool accountResetAuthorization(long hash) throws RpcErrorException, IOException;

    TLBool accountResetNotifySettings() throws RpcErrorException, IOException;

    TLSentCode accountSendChangePhoneCode(boolean allowFlashcall, String phoneNumber, boolean currentNumber) throws RpcErrorException, IOException;

    TLSentCode accountSendConfirmPhoneCode(boolean allowFlashcall, String hash, boolean currentNumber) throws RpcErrorException, IOException;

    TLBool accountSetAccountTTL(TLAccountDaysTTL ttl) throws RpcErrorException, IOException;

    TLPrivacyRules accountSetPrivacy(TLAbsInputPrivacyKey key, TLVector<TLAbsInputPrivacyRule> rules) throws RpcErrorException, IOException;

    TLBool accountUnregisterDevice(int tokenType, String token) throws RpcErrorException, IOException;

    TLBool accountUpdateDeviceLocked(int period) throws RpcErrorException, IOException;

    TLBool accountUpdateNotifySettings(TLAbsInputNotifyPeer peer, TLInputPeerNotifySettings settings) throws RpcErrorException, IOException;

    TLBool accountUpdatePasswordSettings(TLBytes currentPasswordHash, TLPasswordInputSettings newSettings) throws RpcErrorException, IOException;

    TLAbsUser accountUpdateProfile(String firstName, String lastName, String about) throws RpcErrorException, IOException;

    TLBool accountUpdateStatus(boolean offline) throws RpcErrorException, IOException;

    TLAbsUser accountUpdateUsername(String username) throws RpcErrorException, IOException;

    TLBool authBindTempAuthKey(long permAuthKeyId, long nonce, int expiresAt, TLBytes encryptedMessage) throws RpcErrorException, IOException;

    TLBool authCancelCode(String phoneNumber, String phoneCodeHash) throws RpcErrorException, IOException;

    TLAuthorization authCheckPassword(TLBytes passwordHash) throws RpcErrorException, IOException;

    TLCheckedPhone authCheckPhone(String phoneNumber) throws RpcErrorException, IOException;

    TLBool authDropTempAuthKeys(TLLongVector exceptAuthKeys) throws RpcErrorException, IOException;

    TLExportedAuthorization authExportAuthorization(int dcId) throws RpcErrorException, IOException;

    TLAuthorization authImportAuthorization(int id, TLBytes bytes) throws RpcErrorException, IOException;

    TLAuthorization authImportBotAuthorization(int flags, int apiId, String apiHash, String botAuthToken) throws RpcErrorException, IOException;

    TLBool authLogOut() throws RpcErrorException, IOException;

    TLAuthorization authRecoverPassword(String code) throws RpcErrorException, IOException;

    TLPasswordRecovery authRequestPasswordRecovery() throws RpcErrorException, IOException;

    TLSentCode authResendCode(String phoneNumber, String phoneCodeHash) throws RpcErrorException, IOException;

    TLBool authResetAuthorizations() throws RpcErrorException, IOException;

    TLSentCode authSendCode(boolean allowFlashcall, String phoneNumber, boolean currentNumber, int apiId, String apiHash) throws RpcErrorException, IOException;

    TLBool authSendInvites(TLStringVector phoneNumbers, String message) throws RpcErrorException, IOException;

    TLAuthorization authSignIn(String phoneNumber, String phoneCodeHash, String phoneCode) throws RpcErrorException, IOException;

    TLAuthorization authSignUp(String phoneNumber, String phoneCodeHash, String phoneCode, String firstName, String lastName) throws RpcErrorException, IOException;

    TLBool botsAnswerWebhookJSONQuery(long queryId, TLDataJSON data) throws RpcErrorException, IOException;

    TLDataJSON botsSendCustomRequest(String customMethod, TLDataJSON params) throws RpcErrorException, IOException;

    TLBool channelsCheckUsername(TLAbsInputChannel channel, String username) throws RpcErrorException, IOException;

    TLAbsUpdates channelsCreateChannel(boolean broadcast, boolean megagroup, String title, String about) throws RpcErrorException, IOException;

    TLAbsUpdates channelsDeleteChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException;

    TLAffectedMessages channelsDeleteMessages(TLAbsInputChannel channel, TLIntVector id) throws RpcErrorException, IOException;

    TLAffectedHistory channelsDeleteUserHistory(TLAbsInputChannel channel, TLAbsInputUser userId) throws RpcErrorException, IOException;

    TLBool channelsEditAbout(TLAbsInputChannel channel, String about) throws RpcErrorException, IOException;

    TLAbsUpdates channelsEditAdmin(TLAbsInputChannel channel, TLAbsInputUser userId, TLAbsChannelParticipantRole role) throws RpcErrorException, IOException;

    TLAbsUpdates channelsEditPhoto(TLAbsInputChannel channel, TLAbsInputChatPhoto photo) throws RpcErrorException, IOException;

    TLAbsUpdates channelsEditTitle(TLAbsInputChannel channel, String title) throws RpcErrorException, IOException;

    TLAbsExportedChatInvite channelsExportInvite(TLAbsInputChannel channel) throws RpcErrorException, IOException;

    TLExportedMessageLink channelsExportMessageLink(TLAbsInputChannel channel, int id) throws RpcErrorException, IOException;

    TLAbsChats channelsGetAdminedPublicChannels() throws RpcErrorException, IOException;

    TLAbsChats channelsGetChannels(TLVector<TLAbsInputChannel> id) throws RpcErrorException, IOException;

    TLChatFull channelsGetFullChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException;

    TLAbsMessages channelsGetMessages(TLAbsInputChannel channel, TLIntVector id) throws RpcErrorException, IOException;

    TLChannelParticipant channelsGetParticipant(TLAbsInputChannel channel, TLAbsInputUser userId) throws RpcErrorException, IOException;

    TLChannelParticipants channelsGetParticipants(TLAbsInputChannel channel, TLAbsChannelParticipantsFilter filter, int offset, int limit) throws RpcErrorException, IOException;

    TLAbsUpdates channelsInviteToChannel(TLAbsInputChannel channel, TLVector<TLAbsInputUser> users) throws RpcErrorException, IOException;

    TLAbsUpdates channelsJoinChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException;

    TLAbsUpdates channelsKickFromChannel(TLAbsInputChannel channel, TLAbsInputUser userId, boolean kicked) throws RpcErrorException, IOException;

    TLAbsUpdates channelsLeaveChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException;

    TLBool channelsReadHistory(TLAbsInputChannel channel, int maxId) throws RpcErrorException, IOException;

    TLBool channelsReportSpam(TLAbsInputChannel channel, TLAbsInputUser userId, TLIntVector id) throws RpcErrorException, IOException;

    TLAbsUpdates channelsToggleInvites(TLAbsInputChannel channel, boolean enabled) throws RpcErrorException, IOException;

    TLAbsUpdates channelsToggleSignatures(TLAbsInputChannel channel, boolean enabled) throws RpcErrorException, IOException;

    TLAbsUpdates channelsUpdatePinnedMessage(boolean silent, TLAbsInputChannel channel, int id) throws RpcErrorException, IOException;

    TLBool channelsUpdateUsername(TLAbsInputChannel channel, String username) throws RpcErrorException, IOException;

    TLBool contactsBlock(TLAbsInputUser id) throws RpcErrorException, IOException;

    TLLink contactsDeleteContact(TLAbsInputUser id) throws RpcErrorException, IOException;

    TLBool contactsDeleteContacts(TLVector<TLAbsInputUser> id) throws RpcErrorException, IOException;

    TLIntVector contactsExportCard() throws RpcErrorException, IOException;

    TLAbsBlocked contactsGetBlocked(int offset, int limit) throws RpcErrorException, IOException;

    TLAbsContacts contactsGetContacts(String hash) throws RpcErrorException, IOException;

    TLVector<TLContactStatus> contactsGetStatuses() throws RpcErrorException, IOException;

    TLAbsTopPeers contactsGetTopPeers(boolean correspondents, boolean botsPm, boolean botsInline, boolean groups, boolean channels, int offset, int limit, int hash) throws RpcErrorException, IOException;

    TLAbsUser contactsImportCard(TLIntVector exportCard) throws RpcErrorException, IOException;

    TLImportedContacts contactsImportContacts(TLVector<TLInputPhoneContact> contacts, boolean replace) throws RpcErrorException, IOException;

    TLBool contactsResetTopPeerRating(TLAbsTopPeerCategory category, TLAbsInputPeer peer) throws RpcErrorException, IOException;

    TLResolvedPeer contactsResolveUsername(String username) throws RpcErrorException, IOException;

    TLFound contactsSearch(String q, int limit) throws RpcErrorException, IOException;

    TLBool contactsUnblock(TLAbsInputUser id) throws RpcErrorException, IOException;

    TLBool contestSaveDeveloperInfo(int vkId, String name, String phoneNumber, int age, String city) throws RpcErrorException, IOException;

    TLAbsUpdates helpGetAppChangelog(String prevAppVersion) throws RpcErrorException, IOException;

    TLAbsAppUpdate helpGetAppUpdate() throws RpcErrorException, IOException;

    TLCdnConfig helpGetCdnConfig() throws RpcErrorException, IOException;

    TLConfig helpGetConfig() throws RpcErrorException, IOException;

    TLInviteText helpGetInviteText() throws RpcErrorException, IOException;

    TLNearestDc helpGetNearestDc() throws RpcErrorException, IOException;

    TLSupport helpGetSupport() throws RpcErrorException, IOException;

    TLTermsOfService helpGetTermsOfService() throws RpcErrorException, IOException;

    TLBool helpSaveAppLog(TLVector<TLInputAppEvent> events) throws RpcErrorException, IOException;

    TLBool helpSetBotUpdatesStatus(int pendingUpdatesCount, String message) throws RpcErrorException, IOException;

    <T extends TLObject> T initConnection(int apiId, String deviceModel, String systemVersion, String appVersion, String langCode, TLMethod<T> query) throws RpcErrorException, IOException;

    <T extends TLObject> T invokeAfterMsg(long msgId, TLMethod<T> query) throws RpcErrorException, IOException;

    <T extends TLObject> T invokeAfterMsgs(TLLongVector msgIds, TLMethod<T> query) throws RpcErrorException, IOException;

    <T extends TLObject> T invokeWithLayer(int layer, TLMethod<T> query) throws RpcErrorException, IOException;

    <T extends TLObject> T invokeWithoutUpdates(TLMethod<T> query) throws RpcErrorException, IOException;

    TLAbsEncryptedChat messagesAcceptEncryption(TLInputEncryptedChat peer, TLBytes gB, long keyFingerprint) throws RpcErrorException, IOException;

    TLAbsUpdates messagesAddChatUser(int chatId, TLAbsInputUser userId, int fwdLimit) throws RpcErrorException, IOException;

    TLAbsChatInvite messagesCheckChatInvite(String hash) throws RpcErrorException, IOException;

    TLBool messagesClearRecentStickers(boolean attached) throws RpcErrorException, IOException;

    TLAbsUpdates messagesCreateChat(TLVector<TLAbsInputUser> users, String title) throws RpcErrorException, IOException;

    TLAbsUpdates messagesDeleteChatUser(int chatId, TLAbsInputUser userId) throws RpcErrorException, IOException;

    TLAffectedHistory messagesDeleteHistory(boolean justClear, TLAbsInputPeer peer, int maxId) throws RpcErrorException, IOException;

    TLAffectedMessages messagesDeleteMessages(boolean revoke, TLIntVector id) throws RpcErrorException, IOException;

    TLBool messagesDiscardEncryption(int chatId) throws RpcErrorException, IOException;

    TLBool messagesEditChatAdmin(int chatId, TLAbsInputUser userId, boolean isAdmin) throws RpcErrorException, IOException;

    TLAbsUpdates messagesEditChatPhoto(int chatId, TLAbsInputChatPhoto photo) throws RpcErrorException, IOException;

    TLAbsUpdates messagesEditChatTitle(int chatId, String title) throws RpcErrorException, IOException;

    TLBool messagesEditInlineBotMessage(boolean noWebpage, TLInputBotInlineMessageID id, String message, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException;

    TLAbsUpdates messagesEditMessage(boolean noWebpage, TLAbsInputPeer peer, int id, String message, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException;

    TLAbsExportedChatInvite messagesExportChatInvite(int chatId) throws RpcErrorException, IOException;

    TLAbsUpdates messagesForwardMessage(TLAbsInputPeer peer, int id, long randomId) throws RpcErrorException, IOException;

    TLAbsUpdates messagesForwardMessages(boolean silent, boolean background, boolean withMyScore, TLAbsInputPeer fromPeer, TLIntVector id, TLLongVector randomId, TLAbsInputPeer toPeer) throws RpcErrorException, IOException;

    TLAbsChats messagesGetAllChats(TLIntVector exceptIds) throws RpcErrorException, IOException;

    TLAbsUpdates messagesGetAllDrafts() throws RpcErrorException, IOException;

    TLAbsAllStickers messagesGetAllStickers(int hash) throws RpcErrorException, IOException;

    TLArchivedStickers messagesGetArchivedStickers(boolean masks, long offsetId, int limit) throws RpcErrorException, IOException;

    TLVector<TLAbsStickerSetCovered> messagesGetAttachedStickers(TLAbsInputStickeredMedia media) throws RpcErrorException, IOException;

    TLBotCallbackAnswer messagesGetBotCallbackAnswer(boolean game, TLAbsInputPeer peer, int msgId, TLBytes data) throws RpcErrorException, IOException;

    TLAbsChats messagesGetChats(TLIntVector id) throws RpcErrorException, IOException;

    TLAbsChats messagesGetCommonChats(TLAbsInputUser userId, int maxId, int limit) throws RpcErrorException, IOException;

    TLAbsDhConfig messagesGetDhConfig(int version, int randomLength) throws RpcErrorException, IOException;

    TLAbsDialogs messagesGetDialogs(boolean excludePinned, int offsetDate, int offsetId, TLAbsInputPeer offsetPeer, int limit) throws RpcErrorException, IOException;

    TLAbsDocument messagesGetDocumentByHash(TLBytes sha256, int size, String mimeType) throws RpcErrorException, IOException;

    TLAbsFeaturedStickers messagesGetFeaturedStickers(int hash) throws RpcErrorException, IOException;

    TLChatFull messagesGetFullChat(int chatId) throws RpcErrorException, IOException;

    TLHighScores messagesGetGameHighScores(TLAbsInputPeer peer, int id, TLAbsInputUser userId) throws RpcErrorException, IOException;

    TLAbsMessages messagesGetHistory(TLAbsInputPeer peer, int offsetId, int offsetDate, int addOffset, int limit, int maxId, int minId) throws RpcErrorException, IOException;

    TLBotResults messagesGetInlineBotResults(TLAbsInputUser bot, TLAbsInputPeer peer, TLAbsInputGeoPoint geoPoint, String query, String offset) throws RpcErrorException, IOException;

    TLHighScores messagesGetInlineGameHighScores(TLInputBotInlineMessageID id, TLAbsInputUser userId) throws RpcErrorException, IOException;

    TLAbsAllStickers messagesGetMaskStickers(int hash) throws RpcErrorException, IOException;

    TLMessageEditData messagesGetMessageEditData(TLAbsInputPeer peer, int id) throws RpcErrorException, IOException;

    TLAbsMessages messagesGetMessages(TLIntVector id) throws RpcErrorException, IOException;

    TLIntVector messagesGetMessagesViews(TLAbsInputPeer peer, TLIntVector id, boolean increment) throws RpcErrorException, IOException;

    TLPeerDialogs messagesGetPeerDialogs(TLVector<TLAbsInputPeer> peers) throws RpcErrorException, IOException;

    TLPeerSettings messagesGetPeerSettings(TLAbsInputPeer peer) throws RpcErrorException, IOException;

    TLPeerDialogs messagesGetPinnedDialogs() throws RpcErrorException, IOException;

    TLAbsRecentStickers messagesGetRecentStickers(boolean attached, int hash) throws RpcErrorException, IOException;

    TLAbsSavedGifs messagesGetSavedGifs(int hash) throws RpcErrorException, IOException;

    TLStickerSet messagesGetStickerSet(TLAbsInputStickerSet stickerset) throws RpcErrorException, IOException;

    TLAbsWebPage messagesGetWebPage(String url, int hash) throws RpcErrorException, IOException;

    TLAbsMessageMedia messagesGetWebPagePreview(String message) throws RpcErrorException, IOException;

    TLBool messagesHideReportSpam(TLAbsInputPeer peer) throws RpcErrorException, IOException;

    TLAbsUpdates messagesImportChatInvite(String hash) throws RpcErrorException, IOException;

    TLAbsStickerSetInstallResult messagesInstallStickerSet(TLAbsInputStickerSet stickerset, boolean archived) throws RpcErrorException, IOException;

    TLAbsUpdates messagesMigrateChat(int chatId) throws RpcErrorException, IOException;

    TLBool messagesReadEncryptedHistory(TLInputEncryptedChat peer, int maxDate) throws RpcErrorException, IOException;

    TLBool messagesReadFeaturedStickers(TLLongVector id) throws RpcErrorException, IOException;

    TLAffectedMessages messagesReadHistory(TLAbsInputPeer peer, int maxId) throws RpcErrorException, IOException;

    TLAffectedMessages messagesReadMessageContents(TLIntVector id) throws RpcErrorException, IOException;

    TLVector<TLReceivedNotifyMessage> messagesReceivedMessages(int maxId) throws RpcErrorException, IOException;

    TLLongVector messagesReceivedQueue(int maxQts) throws RpcErrorException, IOException;

    TLBool messagesReorderPinnedDialogs(boolean force, TLVector<TLAbsInputPeer> order) throws RpcErrorException, IOException;

    TLBool messagesReorderStickerSets(boolean masks, TLLongVector order) throws RpcErrorException, IOException;

    TLBool messagesReportEncryptedSpam(TLInputEncryptedChat peer) throws RpcErrorException, IOException;

    TLBool messagesReportSpam(TLAbsInputPeer peer) throws RpcErrorException, IOException;

    TLAbsEncryptedChat messagesRequestEncryption(TLAbsInputUser userId, int randomId, TLBytes gA) throws RpcErrorException, IOException;

    TLBool messagesSaveDraft(boolean noWebpage, Integer replyToMsgId, TLAbsInputPeer peer, String message, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException;

    TLBool messagesSaveGif(TLAbsInputDocument id, boolean unsave) throws RpcErrorException, IOException;

    TLBool messagesSaveRecentSticker(boolean attached, TLAbsInputDocument id, boolean unsave) throws RpcErrorException, IOException;

    TLAbsMessages messagesSearch(TLAbsInputPeer peer, String q, TLAbsMessagesFilter filter, int minDate, int maxDate, int offset, int maxId, int limit) throws RpcErrorException, IOException;

    TLFoundGifs messagesSearchGifs(String q, int offset) throws RpcErrorException, IOException;

    TLAbsMessages messagesSearchGlobal(String q, int offsetDate, TLAbsInputPeer offsetPeer, int offsetId, int limit) throws RpcErrorException, IOException;

    TLAbsSentEncryptedMessage messagesSendEncrypted(TLInputEncryptedChat peer, long randomId, TLBytes data) throws RpcErrorException, IOException;

    TLAbsSentEncryptedMessage messagesSendEncryptedFile(TLInputEncryptedChat peer, long randomId, TLBytes data, TLAbsInputEncryptedFile file) throws RpcErrorException, IOException;

    TLAbsSentEncryptedMessage messagesSendEncryptedService(TLInputEncryptedChat peer, long randomId, TLBytes data) throws RpcErrorException, IOException;

    TLAbsUpdates messagesSendInlineBotResult(boolean silent, boolean background, boolean clearDraft, TLAbsInputPeer peer, Integer replyToMsgId, long randomId, long queryId, String id) throws RpcErrorException, IOException;

    TLAbsUpdates messagesSendMedia(boolean silent, boolean background, boolean clearDraft, TLAbsInputPeer peer, Integer replyToMsgId, TLAbsInputMedia media, long randomId, TLAbsReplyMarkup replyMarkup) throws RpcErrorException, IOException;

    TLAbsUpdates messagesSendMessage(boolean noWebpage, boolean silent, boolean background, boolean clearDraft, TLAbsInputPeer peer, Integer replyToMsgId, String message, long randomId, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException;

    TLBool messagesSetBotCallbackAnswer(boolean alert, long queryId, String message, String url, int cacheTime) throws RpcErrorException, IOException;

    TLBool messagesSetBotPrecheckoutResults(boolean success, long queryId, String error) throws RpcErrorException, IOException;

    TLBool messagesSetBotShippingResults(long queryId, String error, TLVector<TLShippingOption> shippingOptions) throws RpcErrorException, IOException;

    TLBool messagesSetEncryptedTyping(TLInputEncryptedChat peer, boolean typing) throws RpcErrorException, IOException;

    TLAbsUpdates messagesSetGameScore(boolean editMessage, boolean force, TLAbsInputPeer peer, int id, TLAbsInputUser userId, int score) throws RpcErrorException, IOException;

    TLBool messagesSetInlineBotResults(boolean gallery, boolean _private, long queryId, TLVector<TLAbsInputBotInlineResult> results, int cacheTime, String nextOffset, TLInlineBotSwitchPM switchPm) throws RpcErrorException, IOException;

    TLBool messagesSetInlineGameScore(boolean editMessage, boolean force, TLInputBotInlineMessageID id, TLAbsInputUser userId, int score) throws RpcErrorException, IOException;

    TLBool messagesSetTyping(TLAbsInputPeer peer, TLAbsSendMessageAction action) throws RpcErrorException, IOException;

    TLAbsUpdates messagesStartBot(TLAbsInputUser bot, TLAbsInputPeer peer, long randomId, String startParam) throws RpcErrorException, IOException;

    TLAbsUpdates messagesToggleChatAdmins(int chatId, boolean enabled) throws RpcErrorException, IOException;

    TLBool messagesToggleDialogPin(boolean pinned, TLAbsInputPeer peer) throws RpcErrorException, IOException;

    TLBool messagesUninstallStickerSet(TLAbsInputStickerSet stickerset) throws RpcErrorException, IOException;

    TLBool paymentsClearSavedInfo(boolean credentials, boolean info) throws RpcErrorException, IOException;

    TLPaymentForm paymentsGetPaymentForm(int msgId) throws RpcErrorException, IOException;

    TLPaymentReceipt paymentsGetPaymentReceipt(int msgId) throws RpcErrorException, IOException;

    TLSavedInfo paymentsGetSavedInfo() throws RpcErrorException, IOException;

    TLAbsPaymentResult paymentsSendPaymentForm(int msgId, String requestedInfoId, String shippingOptionId, TLAbsInputPaymentCredentials credentials) throws RpcErrorException, IOException;

    TLValidatedRequestedInfo paymentsValidateRequestedInfo(boolean save, int msgId, TLPaymentRequestedInfo info) throws RpcErrorException, IOException;

    TLPhoneCall phoneAcceptCall(TLInputPhoneCall peer, TLBytes gB, TLPhoneCallProtocol protocol) throws RpcErrorException, IOException;

    TLPhoneCall phoneConfirmCall(TLInputPhoneCall peer, TLBytes gA, long keyFingerprint, TLPhoneCallProtocol protocol) throws RpcErrorException, IOException;

    TLAbsUpdates phoneDiscardCall(TLInputPhoneCall peer, int duration, TLAbsPhoneCallDiscardReason reason, long connectionId) throws RpcErrorException, IOException;

    TLDataJSON phoneGetCallConfig() throws RpcErrorException, IOException;

    TLBool phoneReceivedCall(TLInputPhoneCall peer) throws RpcErrorException, IOException;

    TLPhoneCall phoneRequestCall(TLAbsInputUser userId, int randomId, TLBytes gAHash, TLPhoneCallProtocol protocol) throws RpcErrorException, IOException;

    TLBool phoneSaveCallDebug(TLInputPhoneCall peer, TLDataJSON debug) throws RpcErrorException, IOException;

    TLAbsUpdates phoneSetCallRating(TLInputPhoneCall peer, int rating, String comment) throws RpcErrorException, IOException;

    TLLongVector photosDeletePhotos(TLVector<TLAbsInputPhoto> id) throws RpcErrorException, IOException;

    TLAbsPhotos photosGetUserPhotos(TLAbsInputUser userId, int offset, long maxId, int limit) throws RpcErrorException, IOException;

    TLAbsUserProfilePhoto photosUpdateProfilePhoto(TLAbsInputPhoto id) throws RpcErrorException, IOException;

    TLPhoto photosUploadProfilePhoto(TLAbsInputFile file) throws RpcErrorException, IOException;

    TLAbsChannelDifference updatesGetChannelDifference(boolean force, TLAbsInputChannel channel, TLAbsChannelMessagesFilter filter, int pts, int limit) throws RpcErrorException, IOException;

    TLAbsDifference updatesGetDifference(int pts, Integer ptsTotalLimit, int date, int qts) throws RpcErrorException, IOException;

    TLState updatesGetState() throws RpcErrorException, IOException;

    TLAbsCdnFile uploadGetCdnFile(TLBytes fileToken, int offset, int limit) throws RpcErrorException, IOException;

    TLAbsFile uploadGetFile(TLAbsInputFileLocation location, int offset, int limit) throws RpcErrorException, IOException;

    TLWebFile uploadGetWebFile(TLInputWebFileLocation location, int offset, int limit) throws RpcErrorException, IOException;

    TLBool uploadReuploadCdnFile(TLBytes fileToken, TLBytes requestToken) throws RpcErrorException, IOException;

    TLBool uploadSaveBigFilePart(long fileId, int filePart, int fileTotalParts, TLBytes bytes) throws RpcErrorException, IOException;

    TLBool uploadSaveFilePart(long fileId, int filePart, TLBytes bytes) throws RpcErrorException, IOException;

    TLUserFull usersGetFullUser(TLAbsInputUser id) throws RpcErrorException, IOException;

    TLVector<TLAbsUser> usersGetUsers(TLVector<TLAbsInputUser> id) throws RpcErrorException, IOException;
}
