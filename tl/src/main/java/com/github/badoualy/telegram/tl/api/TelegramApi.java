package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.api.account.TLAbsPassword;
import com.github.badoualy.telegram.tl.api.account.TLAuthorizations;
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings;
import com.github.badoualy.telegram.tl.api.account.TLPasswordSettings;
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules;
import com.github.badoualy.telegram.tl.api.account.TLSentChangePhoneCode;
import com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode;
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization;
import com.github.badoualy.telegram.tl.api.auth.TLCheckedPhone;
import com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization;
import com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery;
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant;
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipants;
import com.github.badoualy.telegram.tl.api.contacts.TLAbsBlocked;
import com.github.badoualy.telegram.tl.api.contacts.TLAbsContacts;
import com.github.badoualy.telegram.tl.api.contacts.TLFound;
import com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts;
import com.github.badoualy.telegram.tl.api.contacts.TLLink;
import com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer;
import com.github.badoualy.telegram.tl.api.contacts.TLSuggested;
import com.github.badoualy.telegram.tl.api.help.TLAbsAppChangelog;
import com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate;
import com.github.badoualy.telegram.tl.api.help.TLInviteText;
import com.github.badoualy.telegram.tl.api.help.TLSupport;
import com.github.badoualy.telegram.tl.api.help.TLTermsOfService;
import com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages;
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedGifs;
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage;
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickers;
import com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory;
import com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages;
import com.github.badoualy.telegram.tl.api.messages.TLBotResults;
import com.github.badoualy.telegram.tl.api.messages.TLChatFull;
import com.github.badoualy.telegram.tl.api.messages.TLChats;
import com.github.badoualy.telegram.tl.api.messages.TLFoundGifs;
import com.github.badoualy.telegram.tl.api.messages.TLStickerSet;
import com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos;
import com.github.badoualy.telegram.tl.api.photos.TLPhoto;
import com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference;
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference;
import com.github.badoualy.telegram.tl.api.updates.TLState;
import com.github.badoualy.telegram.tl.api.upload.TLFile;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
@SuppressWarnings({"unused", "unchecked", "RedundantCast"})
public interface TelegramApi {
    TLAbsUser accountChangePhone(String phoneNumber, String phoneCodeHash, String phoneCode) throws IOException;

    TLBool accountCheckUsername(String username) throws IOException;

    TLBool accountDeleteAccount(String reason) throws IOException;

    TLAccountDaysTTL accountGetAccountTTL() throws IOException;

    TLAuthorizations accountGetAuthorizations() throws IOException;

    TLAbsPeerNotifySettings accountGetNotifySettings(TLAbsInputNotifyPeer peer) throws IOException;

    TLAbsPassword accountGetPassword() throws IOException;

    TLPasswordSettings accountGetPasswordSettings(TLBytes currentPasswordHash) throws IOException;

    TLPrivacyRules accountGetPrivacy(TLInputPrivacyKeyStatusTimestamp key) throws IOException;

    TLVector<TLAbsWallPaper> accountGetWallPapers() throws IOException;

    TLBool accountRegisterDevice(int tokenType, String token, String deviceModel, String systemVersion, String appVersion, boolean appSandbox, String langCode) throws IOException;

    TLBool accountReportPeer(TLAbsInputPeer peer, TLAbsReportReason reason) throws IOException;

    TLBool accountResetAuthorization(long hash) throws IOException;

    TLBool accountResetNotifySettings() throws IOException;

    TLSentChangePhoneCode accountSendChangePhoneCode(String phoneNumber) throws IOException;

    TLBool accountSetAccountTTL(TLAccountDaysTTL ttl) throws IOException;

    TLPrivacyRules accountSetPrivacy(TLInputPrivacyKeyStatusTimestamp key, TLVector<TLAbsInputPrivacyRule> rules) throws IOException;

    TLBool accountUnregisterDevice(int tokenType, String token) throws IOException;

    TLBool accountUpdateDeviceLocked(int period) throws IOException;

    TLBool accountUpdateNotifySettings(TLAbsInputNotifyPeer peer, TLInputPeerNotifySettings settings) throws IOException;

    TLBool accountUpdatePasswordSettings(TLBytes currentPasswordHash, TLPasswordInputSettings newSettings) throws IOException;

    TLAbsUser accountUpdateProfile(String firstName, String lastName) throws IOException;

    TLBool accountUpdateStatus(boolean offline) throws IOException;

    TLAbsUser accountUpdateUsername(String username) throws IOException;

    TLBool authBindTempAuthKey(long permAuthKeyId, long nonce, int expiresAt, TLBytes encryptedMessage) throws IOException;

    TLAuthorization authCheckPassword(TLBytes passwordHash) throws IOException;

    TLCheckedPhone authCheckPhone(String phoneNumber) throws IOException;

    TLExportedAuthorization authExportAuthorization(int dcId) throws IOException;

    TLAuthorization authImportAuthorization(int id, TLBytes bytes) throws IOException;

    TLAuthorization authImportBotAuthorization(int flags, int apiId, String apiHash, String botAuthToken) throws IOException;

    TLBool authLogOut() throws IOException;

    TLAuthorization authRecoverPassword(String code) throws IOException;

    TLPasswordRecovery authRequestPasswordRecovery() throws IOException;

    TLBool authResetAuthorizations() throws IOException;

    TLBool authSendCall(String phoneNumber, String phoneCodeHash) throws IOException;

    TLAbsSentCode authSendCode(String phoneNumber, int smsType, int apiId, String apiHash, String langCode) throws IOException;

    TLBool authSendInvites(TLStringVector phoneNumbers, String message) throws IOException;

    TLBool authSendSms(String phoneNumber, String phoneCodeHash) throws IOException;

    TLAuthorization authSignIn(String phoneNumber, String phoneCodeHash, String phoneCode) throws IOException;

    TLAuthorization authSignUp(String phoneNumber, String phoneCodeHash, String phoneCode, String firstName, String lastName) throws IOException;

    TLBool channelsCheckUsername(TLAbsInputChannel channel, String username) throws IOException;

    TLAbsUpdates channelsCreateChannel(boolean broadcast, boolean megagroup, String title, String about) throws IOException;

    TLAbsUpdates channelsDeleteChannel(TLAbsInputChannel channel) throws IOException;

    TLAffectedMessages channelsDeleteMessages(TLAbsInputChannel channel, TLIntVector id) throws IOException;

    TLAffectedHistory channelsDeleteUserHistory(TLAbsInputChannel channel, TLAbsInputUser userId) throws IOException;

    TLBool channelsEditAbout(TLAbsInputChannel channel, String about) throws IOException;

    TLAbsUpdates channelsEditAdmin(TLAbsInputChannel channel, TLAbsInputUser userId, TLAbsChannelParticipantRole role) throws IOException;

    TLAbsUpdates channelsEditPhoto(TLAbsInputChannel channel, TLAbsInputChatPhoto photo) throws IOException;

    TLAbsUpdates channelsEditTitle(TLAbsInputChannel channel, String title) throws IOException;

    TLAbsExportedChatInvite channelsExportInvite(TLAbsInputChannel channel) throws IOException;

    TLChats channelsGetChannels(TLVector<TLAbsInputChannel> id) throws IOException;

    TLAbsDialogs channelsGetDialogs(int offset, int limit) throws IOException;

    TLChatFull channelsGetFullChannel(TLAbsInputChannel channel) throws IOException;

    TLAbsMessages channelsGetImportantHistory(TLAbsInputChannel channel, int offsetId, int addOffset, int limit, int maxId, int minId) throws IOException;

    TLAbsMessages channelsGetMessages(TLAbsInputChannel channel, TLIntVector id) throws IOException;

    TLChannelParticipant channelsGetParticipant(TLAbsInputChannel channel, TLAbsInputUser userId) throws IOException;

    TLChannelParticipants channelsGetParticipants(TLAbsInputChannel channel, TLAbsChannelParticipantsFilter filter, int offset, int limit) throws IOException;

    TLAbsUpdates channelsInviteToChannel(TLAbsInputChannel channel, TLVector<TLAbsInputUser> users) throws IOException;

    TLAbsUpdates channelsJoinChannel(TLAbsInputChannel channel) throws IOException;

    TLAbsUpdates channelsKickFromChannel(TLAbsInputChannel channel, TLAbsInputUser userId, boolean kicked) throws IOException;

    TLAbsUpdates channelsLeaveChannel(TLAbsInputChannel channel) throws IOException;

    TLBool channelsReadHistory(TLAbsInputChannel channel, int maxId) throws IOException;

    TLBool channelsReportSpam(TLAbsInputChannel channel, TLAbsInputUser userId, TLIntVector id) throws IOException;

    TLAbsUpdates channelsToggleComments(TLAbsInputChannel channel, boolean enabled) throws IOException;

    TLBool channelsUpdateUsername(TLAbsInputChannel channel, String username) throws IOException;

    TLBool contactsBlock(TLAbsInputUser id) throws IOException;

    TLLink contactsDeleteContact(TLAbsInputUser id) throws IOException;

    TLBool contactsDeleteContacts(TLVector<TLAbsInputUser> id) throws IOException;

    TLIntVector contactsExportCard() throws IOException;

    TLAbsBlocked contactsGetBlocked(int offset, int limit) throws IOException;

    TLAbsContacts contactsGetContacts(String hash) throws IOException;

    TLVector<TLContactStatus> contactsGetStatuses() throws IOException;

    TLSuggested contactsGetSuggested(int limit) throws IOException;

    TLAbsUser contactsImportCard(TLIntVector exportCard) throws IOException;

    TLImportedContacts contactsImportContacts(TLVector<TLInputPhoneContact> contacts, boolean replace) throws IOException;

    TLResolvedPeer contactsResolveUsername(String username) throws IOException;

    TLFound contactsSearch(String q, int limit) throws IOException;

    TLBool contactsUnblock(TLAbsInputUser id) throws IOException;

    TLAbsAppChangelog helpGetAppChangelog(String deviceModel, String systemVersion, String appVersion, String langCode) throws IOException;

    TLAbsAppUpdate helpGetAppUpdate(String deviceModel, String systemVersion, String appVersion, String langCode) throws IOException;

    TLConfig helpGetConfig() throws IOException;

    TLInviteText helpGetInviteText(String langCode) throws IOException;

    TLNearestDc helpGetNearestDc() throws IOException;

    TLSupport helpGetSupport() throws IOException;

    TLTermsOfService helpGetTermsOfService(String langCode) throws IOException;

    TLBool helpSaveAppLog(TLVector<TLInputAppEvent> events) throws IOException;

    <T extends TLObject> T initConnection(int apiId, String deviceModel, String systemVersion, String appVersion, String langCode, TLMethod<T> query) throws IOException;

    <T extends TLObject> T invokeAfterMsg(long msgId, TLMethod<T> query) throws IOException;

    <T extends TLObject> T invokeAfterMsgs(TLLongVector msgIds, TLMethod<T> query) throws IOException;

    <T extends TLObject> T invokeWithLayer(int layer, TLMethod<T> query) throws IOException;

    <T extends TLObject> T invokeWithoutUpdates(TLMethod<T> query) throws IOException;

    TLAbsEncryptedChat messagesAcceptEncryption(TLInputEncryptedChat peer, TLBytes gB, long keyFingerprint) throws IOException;

    TLAbsUpdates messagesAddChatUser(int chatId, TLAbsInputUser userId, int fwdLimit) throws IOException;

    TLAbsChatInvite messagesCheckChatInvite(String hash) throws IOException;

    TLAbsUpdates messagesCreateChat(TLVector<TLAbsInputUser> users, String title) throws IOException;

    TLAbsUpdates messagesDeleteChatUser(int chatId, TLAbsInputUser userId) throws IOException;

    TLAffectedHistory messagesDeleteHistory(TLAbsInputPeer peer, int maxId) throws IOException;

    TLAffectedMessages messagesDeleteMessages(TLIntVector id) throws IOException;

    TLBool messagesDiscardEncryption(int chatId) throws IOException;

    TLBool messagesEditChatAdmin(int chatId, TLAbsInputUser userId, boolean isAdmin) throws IOException;

    TLAbsUpdates messagesEditChatPhoto(int chatId, TLAbsInputChatPhoto photo) throws IOException;

    TLAbsUpdates messagesEditChatTitle(int chatId, String title) throws IOException;

    TLAbsExportedChatInvite messagesExportChatInvite(int chatId) throws IOException;

    TLAbsUpdates messagesForwardMessage(TLAbsInputPeer peer, int id, long randomId) throws IOException;

    TLAbsUpdates messagesForwardMessages(boolean broadcast, TLAbsInputPeer fromPeer, TLIntVector id, TLLongVector randomId, TLAbsInputPeer toPeer) throws IOException;

    TLAbsAllStickers messagesGetAllStickers(int hash) throws IOException;

    TLChats messagesGetChats(TLIntVector id) throws IOException;

    TLAbsDhConfig messagesGetDhConfig(int version, int randomLength) throws IOException;

    TLAbsDialogs messagesGetDialogs(int offsetDate, int offsetId, TLAbsInputPeer offsetPeer, int limit) throws IOException;

    TLAbsDocument messagesGetDocumentByHash(TLBytes sha256, int size, String mimeType) throws IOException;

    TLChatFull messagesGetFullChat(int chatId) throws IOException;

    TLAbsMessages messagesGetHistory(TLAbsInputPeer peer, int offsetId, int addOffset, int limit, int maxId, int minId) throws IOException;

    TLBotResults messagesGetInlineBotResults(TLAbsInputUser bot, String query, String offset) throws IOException;

    TLAbsMessages messagesGetMessages(TLIntVector id) throws IOException;

    TLIntVector messagesGetMessagesViews(TLAbsInputPeer peer, TLIntVector id, boolean increment) throws IOException;

    TLAbsSavedGifs messagesGetSavedGifs(int hash) throws IOException;

    TLStickerSet messagesGetStickerSet(TLAbsInputStickerSet stickerset) throws IOException;

    TLAbsStickers messagesGetStickers(String emoticon, String hash) throws IOException;

    TLAbsMessageMedia messagesGetWebPagePreview(String message) throws IOException;

    TLAbsUpdates messagesImportChatInvite(String hash) throws IOException;

    TLBool messagesInstallStickerSet(TLAbsInputStickerSet stickerset, boolean disabled) throws IOException;

    TLAbsUpdates messagesMigrateChat(int chatId) throws IOException;

    TLBool messagesReadEncryptedHistory(TLInputEncryptedChat peer, int maxDate) throws IOException;

    TLAffectedMessages messagesReadHistory(TLAbsInputPeer peer, int maxId) throws IOException;

    TLAffectedMessages messagesReadMessageContents(TLIntVector id) throws IOException;

    TLVector<TLReceivedNotifyMessage> messagesReceivedMessages(int maxId) throws IOException;

    TLLongVector messagesReceivedQueue(int maxQts) throws IOException;

    TLBool messagesReorderStickerSets(TLLongVector order) throws IOException;

    TLBool messagesReportSpam(TLAbsInputPeer peer) throws IOException;

    TLAbsEncryptedChat messagesRequestEncryption(TLAbsInputUser userId, int randomId, TLBytes gA) throws IOException;

    TLBool messagesSaveGif(TLAbsInputDocument id, boolean unsave) throws IOException;

    TLAbsMessages messagesSearch(boolean importantOnly, TLAbsInputPeer peer, String q, TLAbsMessagesFilter filter, int minDate, int maxDate, int offset, int maxId, int limit) throws IOException;

    TLFoundGifs messagesSearchGifs(String q, int offset) throws IOException;

    TLAbsMessages messagesSearchGlobal(String q, int offsetDate, TLAbsInputPeer offsetPeer, int offsetId, int limit) throws IOException;

    TLAbsUpdates messagesSendBroadcast(TLVector<TLAbsInputUser> contacts, TLLongVector randomId, String message, TLAbsInputMedia media) throws IOException;

    TLAbsSentEncryptedMessage messagesSendEncrypted(TLInputEncryptedChat peer, long randomId, TLBytes data) throws IOException;

    TLAbsSentEncryptedMessage messagesSendEncryptedFile(TLInputEncryptedChat peer, long randomId, TLBytes data, TLAbsInputEncryptedFile file) throws IOException;

    TLAbsSentEncryptedMessage messagesSendEncryptedService(TLInputEncryptedChat peer, long randomId, TLBytes data) throws IOException;

    TLAbsUpdates messagesSendInlineBotResult(boolean broadcast, TLAbsInputPeer peer, Integer replyToMsgId, long randomId, long queryId, String id) throws IOException;

    TLAbsUpdates messagesSendMedia(boolean broadcast, TLAbsInputPeer peer, Integer replyToMsgId, TLAbsInputMedia media, long randomId, TLAbsReplyMarkup replyMarkup) throws IOException;

    TLAbsUpdates messagesSendMessage(boolean noWebpage, boolean broadcast, TLAbsInputPeer peer, Integer replyToMsgId, String message, long randomId, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities) throws IOException;

    TLBool messagesSetEncryptedTyping(TLInputEncryptedChat peer, boolean typing) throws IOException;

    TLBool messagesSetInlineBotResults(boolean gallery, boolean _private, long queryId, TLVector<TLInputBotInlineResult> results, int cacheTime, String nextOffset) throws IOException;

    TLBool messagesSetTyping(TLAbsInputPeer peer, TLAbsSendMessageAction action) throws IOException;

    TLAbsUpdates messagesStartBot(TLAbsInputUser bot, TLAbsInputPeer peer, long randomId, String startParam) throws IOException;

    TLAbsUpdates messagesToggleChatAdmins(int chatId, boolean enabled) throws IOException;

    TLBool messagesUninstallStickerSet(TLAbsInputStickerSet stickerset) throws IOException;

    TLLongVector photosDeletePhotos(TLVector<TLAbsInputPhoto> id) throws IOException;

    TLAbsPhotos photosGetUserPhotos(TLAbsInputUser userId, int offset, long maxId, int limit) throws IOException;

    TLAbsUserProfilePhoto photosUpdateProfilePhoto(TLAbsInputPhoto id, TLAbsInputPhotoCrop crop) throws IOException;

    TLPhoto photosUploadProfilePhoto(TLAbsInputFile file, String caption, TLAbsInputGeoPoint geoPoint, TLAbsInputPhotoCrop crop) throws IOException;

    TLAbsChannelDifference updatesGetChannelDifference(TLAbsInputChannel channel, TLAbsChannelMessagesFilter filter, int pts, int limit) throws IOException;

    TLAbsDifference updatesGetDifference(int pts, int date, int qts) throws IOException;

    TLState updatesGetState() throws IOException;

    TLFile uploadGetFile(TLAbsInputFileLocation location, int offset, int limit) throws IOException;

    TLBool uploadSaveBigFilePart(long fileId, int filePart, int fileTotalParts, TLBytes bytes) throws IOException;

    TLBool uploadSaveFilePart(long fileId, int filePart, TLBytes bytes) throws IOException;

    TLUserFull usersGetFullUser(TLAbsInputUser id) throws IOException;

    TLVector<TLAbsUser> usersGetUsers(TLVector<TLAbsInputUser> id) throws IOException;
}
