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

    TLBool accountDeleteAccount(String reason) throws RpcErrorException, IOException;

    TLAccountDaysTTL accountGetAccountTTL() throws RpcErrorException, IOException;

    TLAuthorizations accountGetAuthorizations() throws RpcErrorException, IOException;

    TLAbsPeerNotifySettings accountGetNotifySettings(TLAbsInputNotifyPeer peer) throws RpcErrorException, IOException;

    TLAbsPassword accountGetPassword() throws RpcErrorException, IOException;

    TLPasswordSettings accountGetPasswordSettings(TLBytes currentPasswordHash) throws RpcErrorException, IOException;

    TLPrivacyRules accountGetPrivacy(TLInputPrivacyKeyStatusTimestamp key) throws RpcErrorException, IOException;

    TLVector<TLAbsWallPaper> accountGetWallPapers() throws RpcErrorException, IOException;

    TLBool accountRegisterDevice(int tokenType, String token, String deviceModel, String systemVersion, String appVersion, boolean appSandbox, String langCode) throws RpcErrorException, IOException;

    TLBool accountReportPeer(TLAbsInputPeer peer, TLAbsReportReason reason) throws RpcErrorException, IOException;

    TLBool accountResetAuthorization(long hash) throws RpcErrorException, IOException;

    TLBool accountResetNotifySettings() throws RpcErrorException, IOException;

    TLSentChangePhoneCode accountSendChangePhoneCode(String phoneNumber) throws RpcErrorException, IOException;

    TLBool accountSetAccountTTL(TLAccountDaysTTL ttl) throws RpcErrorException, IOException;

    TLPrivacyRules accountSetPrivacy(TLInputPrivacyKeyStatusTimestamp key, TLVector<TLAbsInputPrivacyRule> rules) throws RpcErrorException, IOException;

    TLBool accountUnregisterDevice(int tokenType, String token) throws RpcErrorException, IOException;

    TLBool accountUpdateDeviceLocked(int period) throws RpcErrorException, IOException;

    TLBool accountUpdateNotifySettings(TLAbsInputNotifyPeer peer, TLInputPeerNotifySettings settings) throws RpcErrorException, IOException;

    TLBool accountUpdatePasswordSettings(TLBytes currentPasswordHash, TLPasswordInputSettings newSettings) throws RpcErrorException, IOException;

    TLAbsUser accountUpdateProfile(String firstName, String lastName) throws RpcErrorException, IOException;

    TLBool accountUpdateStatus(boolean offline) throws RpcErrorException, IOException;

    TLAbsUser accountUpdateUsername(String username) throws RpcErrorException, IOException;

    TLBool authBindTempAuthKey(long permAuthKeyId, long nonce, int expiresAt, TLBytes encryptedMessage) throws RpcErrorException, IOException;

    TLAuthorization authCheckPassword(TLBytes passwordHash) throws RpcErrorException, IOException;

    TLCheckedPhone authCheckPhone(String phoneNumber) throws RpcErrorException, IOException;

    TLExportedAuthorization authExportAuthorization(int dcId) throws RpcErrorException, IOException;

    TLAuthorization authImportAuthorization(int id, TLBytes bytes) throws RpcErrorException, IOException;

    TLAuthorization authImportBotAuthorization(int flags, int apiId, String apiHash, String botAuthToken) throws RpcErrorException, IOException;

    TLBool authLogOut() throws RpcErrorException, IOException;

    TLAuthorization authRecoverPassword(String code) throws RpcErrorException, IOException;

    TLPasswordRecovery authRequestPasswordRecovery() throws RpcErrorException, IOException;

    TLBool authResetAuthorizations() throws RpcErrorException, IOException;

    TLBool authSendCall(String phoneNumber, String phoneCodeHash) throws RpcErrorException, IOException;

    TLAbsSentCode authSendCode(String phoneNumber, int smsType, int apiId, String apiHash, String langCode) throws RpcErrorException, IOException;

    TLBool authSendInvites(TLStringVector phoneNumbers, String message) throws RpcErrorException, IOException;

    TLBool authSendSms(String phoneNumber, String phoneCodeHash) throws RpcErrorException, IOException;

    TLAuthorization authSignIn(String phoneNumber, String phoneCodeHash, String phoneCode) throws RpcErrorException, IOException;

    TLAuthorization authSignUp(String phoneNumber, String phoneCodeHash, String phoneCode, String firstName, String lastName) throws RpcErrorException, IOException;

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

    TLChats channelsGetChannels(TLVector<TLAbsInputChannel> id) throws RpcErrorException, IOException;

    TLAbsDialogs channelsGetDialogs(int offset, int limit) throws RpcErrorException, IOException;

    TLChatFull channelsGetFullChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException;

    TLAbsMessages channelsGetImportantHistory(TLAbsInputChannel channel, int offsetId, int addOffset, int limit, int maxId, int minId) throws RpcErrorException, IOException;

    TLAbsMessages channelsGetMessages(TLAbsInputChannel channel, TLIntVector id) throws RpcErrorException, IOException;

    TLChannelParticipant channelsGetParticipant(TLAbsInputChannel channel, TLAbsInputUser userId) throws RpcErrorException, IOException;

    TLChannelParticipants channelsGetParticipants(TLAbsInputChannel channel, TLAbsChannelParticipantsFilter filter, int offset, int limit) throws RpcErrorException, IOException;

    TLAbsUpdates channelsInviteToChannel(TLAbsInputChannel channel, TLVector<TLAbsInputUser> users) throws RpcErrorException, IOException;

    TLAbsUpdates channelsJoinChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException;

    TLAbsUpdates channelsKickFromChannel(TLAbsInputChannel channel, TLAbsInputUser userId, boolean kicked) throws RpcErrorException, IOException;

    TLAbsUpdates channelsLeaveChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException;

    TLBool channelsReadHistory(TLAbsInputChannel channel, int maxId) throws RpcErrorException, IOException;

    TLBool channelsReportSpam(TLAbsInputChannel channel, TLAbsInputUser userId, TLIntVector id) throws RpcErrorException, IOException;

    TLAbsUpdates channelsToggleComments(TLAbsInputChannel channel, boolean enabled) throws RpcErrorException, IOException;

    TLBool channelsUpdateUsername(TLAbsInputChannel channel, String username) throws RpcErrorException, IOException;

    TLBool contactsBlock(TLAbsInputUser id) throws RpcErrorException, IOException;

    TLLink contactsDeleteContact(TLAbsInputUser id) throws RpcErrorException, IOException;

    TLBool contactsDeleteContacts(TLVector<TLAbsInputUser> id) throws RpcErrorException, IOException;

    TLIntVector contactsExportCard() throws RpcErrorException, IOException;

    TLAbsBlocked contactsGetBlocked(int offset, int limit) throws RpcErrorException, IOException;

    TLAbsContacts contactsGetContacts(String hash) throws RpcErrorException, IOException;

    TLVector<TLContactStatus> contactsGetStatuses() throws RpcErrorException, IOException;

    TLSuggested contactsGetSuggested(int limit) throws RpcErrorException, IOException;

    TLAbsUser contactsImportCard(TLIntVector exportCard) throws RpcErrorException, IOException;

    TLImportedContacts contactsImportContacts(TLVector<TLInputPhoneContact> contacts, boolean replace) throws RpcErrorException, IOException;

    TLResolvedPeer contactsResolveUsername(String username) throws RpcErrorException, IOException;

    TLFound contactsSearch(String q, int limit) throws RpcErrorException, IOException;

    TLBool contactsUnblock(TLAbsInputUser id) throws RpcErrorException, IOException;

    TLAbsAppChangelog helpGetAppChangelog(String deviceModel, String systemVersion, String appVersion, String langCode) throws RpcErrorException, IOException;

    TLAbsAppUpdate helpGetAppUpdate(String deviceModel, String systemVersion, String appVersion, String langCode) throws RpcErrorException, IOException;

    TLConfig helpGetConfig() throws RpcErrorException, IOException;

    TLInviteText helpGetInviteText(String langCode) throws RpcErrorException, IOException;

    TLNearestDc helpGetNearestDc() throws RpcErrorException, IOException;

    TLSupport helpGetSupport() throws RpcErrorException, IOException;

    TLTermsOfService helpGetTermsOfService(String langCode) throws RpcErrorException, IOException;

    TLBool helpSaveAppLog(TLVector<TLInputAppEvent> events) throws RpcErrorException, IOException;

    <T extends TLObject> T initConnection(int apiId, String deviceModel, String systemVersion, String appVersion, String langCode, TLMethod<T> query) throws RpcErrorException, IOException;

    <T extends TLObject> T invokeAfterMsg(long msgId, TLMethod<T> query) throws RpcErrorException, IOException;

    <T extends TLObject> T invokeAfterMsgs(TLLongVector msgIds, TLMethod<T> query) throws RpcErrorException, IOException;

    <T extends TLObject> T invokeWithLayer(int layer, TLMethod<T> query) throws RpcErrorException, IOException;

    <T extends TLObject> T invokeWithoutUpdates(TLMethod<T> query) throws RpcErrorException, IOException;

    TLAbsEncryptedChat messagesAcceptEncryption(TLInputEncryptedChat peer, TLBytes gB, long keyFingerprint) throws RpcErrorException, IOException;

    TLAbsUpdates messagesAddChatUser(int chatId, TLAbsInputUser userId, int fwdLimit) throws RpcErrorException, IOException;

    TLAbsChatInvite messagesCheckChatInvite(String hash) throws RpcErrorException, IOException;

    TLAbsUpdates messagesCreateChat(TLVector<TLAbsInputUser> users, String title) throws RpcErrorException, IOException;

    TLAbsUpdates messagesDeleteChatUser(int chatId, TLAbsInputUser userId) throws RpcErrorException, IOException;

    TLAffectedHistory messagesDeleteHistory(TLAbsInputPeer peer, int maxId) throws RpcErrorException, IOException;

    TLAffectedMessages messagesDeleteMessages(TLIntVector id) throws RpcErrorException, IOException;

    TLBool messagesDiscardEncryption(int chatId) throws RpcErrorException, IOException;

    TLBool messagesEditChatAdmin(int chatId, TLAbsInputUser userId, boolean isAdmin) throws RpcErrorException, IOException;

    TLAbsUpdates messagesEditChatPhoto(int chatId, TLAbsInputChatPhoto photo) throws RpcErrorException, IOException;

    TLAbsUpdates messagesEditChatTitle(int chatId, String title) throws RpcErrorException, IOException;

    TLAbsExportedChatInvite messagesExportChatInvite(int chatId) throws RpcErrorException, IOException;

    TLAbsUpdates messagesForwardMessage(TLAbsInputPeer peer, int id, long randomId) throws RpcErrorException, IOException;

    TLAbsUpdates messagesForwardMessages(boolean broadcast, TLAbsInputPeer fromPeer, TLIntVector id, TLLongVector randomId, TLAbsInputPeer toPeer) throws RpcErrorException, IOException;

    TLAbsAllStickers messagesGetAllStickers(int hash) throws RpcErrorException, IOException;

    TLChats messagesGetChats(TLIntVector id) throws RpcErrorException, IOException;

    TLAbsDhConfig messagesGetDhConfig(int version, int randomLength) throws RpcErrorException, IOException;

    TLAbsDialogs messagesGetDialogs(int offsetDate, int offsetId, TLAbsInputPeer offsetPeer, int limit) throws RpcErrorException, IOException;

    TLAbsDocument messagesGetDocumentByHash(TLBytes sha256, int size, String mimeType) throws RpcErrorException, IOException;

    TLChatFull messagesGetFullChat(int chatId) throws RpcErrorException, IOException;

    TLAbsMessages messagesGetHistory(TLAbsInputPeer peer, int offsetId, int addOffset, int limit, int maxId, int minId) throws RpcErrorException, IOException;

    TLBotResults messagesGetInlineBotResults(TLAbsInputUser bot, String query, String offset) throws RpcErrorException, IOException;

    TLAbsMessages messagesGetMessages(TLIntVector id) throws RpcErrorException, IOException;

    TLIntVector messagesGetMessagesViews(TLAbsInputPeer peer, TLIntVector id, boolean increment) throws RpcErrorException, IOException;

    TLAbsSavedGifs messagesGetSavedGifs(int hash) throws RpcErrorException, IOException;

    TLStickerSet messagesGetStickerSet(TLAbsInputStickerSet stickerset) throws RpcErrorException, IOException;

    TLAbsStickers messagesGetStickers(String emoticon, String hash) throws RpcErrorException, IOException;

    TLAbsMessageMedia messagesGetWebPagePreview(String message) throws RpcErrorException, IOException;

    TLAbsUpdates messagesImportChatInvite(String hash) throws RpcErrorException, IOException;

    TLBool messagesInstallStickerSet(TLAbsInputStickerSet stickerset, boolean disabled) throws RpcErrorException, IOException;

    TLAbsUpdates messagesMigrateChat(int chatId) throws RpcErrorException, IOException;

    TLBool messagesReadEncryptedHistory(TLInputEncryptedChat peer, int maxDate) throws RpcErrorException, IOException;

    TLAffectedMessages messagesReadHistory(TLAbsInputPeer peer, int maxId) throws RpcErrorException, IOException;

    TLAffectedMessages messagesReadMessageContents(TLIntVector id) throws RpcErrorException, IOException;

    TLVector<TLReceivedNotifyMessage> messagesReceivedMessages(int maxId) throws RpcErrorException, IOException;

    TLLongVector messagesReceivedQueue(int maxQts) throws RpcErrorException, IOException;

    TLBool messagesReorderStickerSets(TLLongVector order) throws RpcErrorException, IOException;

    TLBool messagesReportSpam(TLAbsInputPeer peer) throws RpcErrorException, IOException;

    TLAbsEncryptedChat messagesRequestEncryption(TLAbsInputUser userId, int randomId, TLBytes gA) throws RpcErrorException, IOException;

    TLBool messagesSaveGif(TLAbsInputDocument id, boolean unsave) throws RpcErrorException, IOException;

    TLAbsMessages messagesSearch(boolean importantOnly, TLAbsInputPeer peer, String q, TLAbsMessagesFilter filter, int minDate, int maxDate, int offset, int maxId, int limit) throws RpcErrorException, IOException;

    TLFoundGifs messagesSearchGifs(String q, int offset) throws RpcErrorException, IOException;

    TLAbsMessages messagesSearchGlobal(String q, int offsetDate, TLAbsInputPeer offsetPeer, int offsetId, int limit) throws RpcErrorException, IOException;

    TLAbsUpdates messagesSendBroadcast(TLVector<TLAbsInputUser> contacts, TLLongVector randomId, String message, TLAbsInputMedia media) throws RpcErrorException, IOException;

    TLAbsSentEncryptedMessage messagesSendEncrypted(TLInputEncryptedChat peer, long randomId, TLBytes data) throws RpcErrorException, IOException;

    TLAbsSentEncryptedMessage messagesSendEncryptedFile(TLInputEncryptedChat peer, long randomId, TLBytes data, TLAbsInputEncryptedFile file) throws RpcErrorException, IOException;

    TLAbsSentEncryptedMessage messagesSendEncryptedService(TLInputEncryptedChat peer, long randomId, TLBytes data) throws RpcErrorException, IOException;

    TLAbsUpdates messagesSendInlineBotResult(boolean broadcast, TLAbsInputPeer peer, Integer replyToMsgId, long randomId, long queryId, String id) throws RpcErrorException, IOException;

    TLAbsUpdates messagesSendMedia(boolean broadcast, TLAbsInputPeer peer, Integer replyToMsgId, TLAbsInputMedia media, long randomId, TLAbsReplyMarkup replyMarkup) throws RpcErrorException, IOException;

    TLAbsUpdates messagesSendMessage(boolean noWebpage, boolean broadcast, TLAbsInputPeer peer, Integer replyToMsgId, String message, long randomId, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException;

    TLBool messagesSetEncryptedTyping(TLInputEncryptedChat peer, boolean typing) throws RpcErrorException, IOException;

    TLBool messagesSetInlineBotResults(boolean gallery, boolean _private, long queryId, TLVector<TLInputBotInlineResult> results, int cacheTime, String nextOffset) throws RpcErrorException, IOException;

    TLBool messagesSetTyping(TLAbsInputPeer peer, TLAbsSendMessageAction action) throws RpcErrorException, IOException;

    TLAbsUpdates messagesStartBot(TLAbsInputUser bot, TLAbsInputPeer peer, long randomId, String startParam) throws RpcErrorException, IOException;

    TLAbsUpdates messagesToggleChatAdmins(int chatId, boolean enabled) throws RpcErrorException, IOException;

    TLBool messagesUninstallStickerSet(TLAbsInputStickerSet stickerset) throws RpcErrorException, IOException;

    TLLongVector photosDeletePhotos(TLVector<TLAbsInputPhoto> id) throws RpcErrorException, IOException;

    TLAbsPhotos photosGetUserPhotos(TLAbsInputUser userId, int offset, long maxId, int limit) throws RpcErrorException, IOException;

    TLAbsUserProfilePhoto photosUpdateProfilePhoto(TLAbsInputPhoto id, TLAbsInputPhotoCrop crop) throws RpcErrorException, IOException;

    TLPhoto photosUploadProfilePhoto(TLAbsInputFile file, String caption, TLAbsInputGeoPoint geoPoint, TLAbsInputPhotoCrop crop) throws RpcErrorException, IOException;

    TLAbsChannelDifference updatesGetChannelDifference(TLAbsInputChannel channel, TLAbsChannelMessagesFilter filter, int pts, int limit) throws RpcErrorException, IOException;

    TLAbsDifference updatesGetDifference(int pts, int date, int qts) throws RpcErrorException, IOException;

    TLState updatesGetState() throws RpcErrorException, IOException;

    TLFile uploadGetFile(TLAbsInputFileLocation location, int offset, int limit) throws RpcErrorException, IOException;

    TLBool uploadSaveBigFilePart(long fileId, int filePart, int fileTotalParts, TLBytes bytes) throws RpcErrorException, IOException;

    TLBool uploadSaveFilePart(long fileId, int filePart, TLBytes bytes) throws RpcErrorException, IOException;

    TLUserFull usersGetFullUser(TLAbsInputUser id) throws RpcErrorException, IOException;

    TLVector<TLAbsUser> usersGetUsers(TLVector<TLAbsInputUser> id) throws RpcErrorException, IOException;
}
