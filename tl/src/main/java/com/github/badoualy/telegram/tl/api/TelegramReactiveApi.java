
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;

import rx.Observable;

public interface TelegramReactiveApi {

    Observable<TLObject> invokeAfterMsg(long msgId, TLMethod query) throws IOException;

    Observable<TLObject> invokeAfterMsgs(com.github.badoualy.telegram.tl.core.TLLongVector msgIds, TLMethod query) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.auth.TLCheckedPhone> authCheckPhone(String phoneNumber) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode> authSendCode(String phoneNumber, int smsType, int apiId, String apiHash, String langCode) throws IOException;

    Observable<TLBool> authSendCall(String phoneNumber, String phoneCodeHash) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.auth.TLAuthorization> authSignUp(String phoneNumber, String phoneCodeHash, String phoneCode, String firstName, String lastName) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.auth.TLAuthorization> authSignIn(String phoneNumber, String phoneCodeHash, String phoneCode) throws IOException;

    Observable<TLBool> authLogOut() throws IOException;

    Observable<TLBool> authResetAuthorizations() throws IOException;

    Observable<TLBool> authSendInvites(com.github.badoualy.telegram.tl.core.TLStringVector phoneNumbers, String message) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization> authExportAuthorization(int dcId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.auth.TLAuthorization> authImportAuthorization(int id, TLBytes bytes) throws IOException;

    Observable<TLBool> authBindTempAuthKey(long permAuthKeyId, long nonce, int expiresAt, TLBytes encryptedMessage) throws IOException;

    Observable<TLBool> accountRegisterDevice(int tokenType, String token, String deviceModel, String systemVersion, String appVersion, boolean appSandbox, String langCode) throws IOException;

    Observable<TLBool> accountUnregisterDevice(int tokenType, String token) throws IOException;

    Observable<TLBool> accountUpdateNotifySettings(com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer peer, com.github.badoualy.telegram.tl.api.TLInputPeerNotifySettings settings) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings> accountGetNotifySettings(com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer peer) throws IOException;

    Observable<TLBool> accountResetNotifySettings() throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUser> accountUpdateProfile(String firstName, String lastName) throws IOException;

    Observable<TLBool> accountUpdateStatus(boolean offline) throws IOException;

    Observable<com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsWallPaper>> accountGetWallPapers() throws IOException;

    Observable<TLBool> accountReportPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.api.TLAbsReportReason reason) throws IOException;

    Observable<com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser>> usersGetUsers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> id) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLUserFull> usersGetFullUser(com.github.badoualy.telegram.tl.api.TLAbsInputUser id) throws IOException;

    Observable<com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLContactStatus>> contactsGetStatuses() throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.contacts.TLAbsContacts> contactsGetContacts(String hash) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts> contactsImportContacts(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputContact> contacts, boolean replace) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.contacts.TLSuggested> contactsGetSuggested(int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.contacts.TLLink> contactsDeleteContact(com.github.badoualy.telegram.tl.api.TLAbsInputUser id) throws IOException;

    Observable<TLBool> contactsDeleteContacts(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> id) throws IOException;

    Observable<TLBool> contactsBlock(com.github.badoualy.telegram.tl.api.TLAbsInputUser id) throws IOException;

    Observable<TLBool> contactsUnblock(com.github.badoualy.telegram.tl.api.TLAbsInputUser id) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.contacts.TLAbsBlocked> contactsGetBlocked(int offset, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.core.TLIntVector> contactsExportCard() throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUser> contactsImportCard(com.github.badoualy.telegram.tl.core.TLIntVector exportCard) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsMessages> messagesGetMessages(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs> messagesGetDialogs(int offset, int maxId, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsMessages> messagesGetHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int offset, int maxId, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsMessages> messagesSearch(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, String q, com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter filter, int minDate, int maxDate, int offset, int maxId, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory> messagesReadHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int maxId, int offset, boolean readContents) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory> messagesDeleteHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int offset) throws IOException;

    Observable<com.github.badoualy.telegram.tl.core.TLIntVector> messagesDeleteMessages(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    Observable<com.github.badoualy.telegram.tl.core.TLIntVector> messagesReceivedMessages(int maxId) throws IOException;

    Observable<TLBool> messagesSetTyping(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction action) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsSentMessage> messagesSendMessage(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, String message, long randomId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage> messagesSendMedia(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.api.TLAbsInputMedia media, long randomId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages> messagesForwardMessages(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    Observable<TLBool> messagesReportSpam(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLChats> messagesGetChats(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLChatFull> messagesGetFullChat(int chatId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage> messagesEditChatTitle(int chatId, String title) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage> messagesEditChatPhoto(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto photo) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage> messagesAddChatUser(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int fwdLimit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage> messagesDeleteChatUser(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage> messagesCreateChat(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> users, String title) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.updates.TLState> updatesGetState() throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.updates.TLAbsDifference> updatesGetDifference(int pts, int date, int qts) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto> photosUpdateProfilePhoto(com.github.badoualy.telegram.tl.api.TLAbsInputPhoto id, com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop crop) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.photos.TLPhoto> photosUploadProfilePhoto(com.github.badoualy.telegram.tl.api.TLAbsInputFile file, String caption, com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint geoPoint, com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop crop) throws IOException;

    Observable<com.github.badoualy.telegram.tl.core.TLLongVector> photosDeletePhotos(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPhoto> id) throws IOException;

    Observable<TLBool> uploadSaveFilePart(long fileId, int filePart, TLBytes bytes) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.upload.TLFile> uploadGetFile(com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation location, int offset, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLConfig> helpGetConfig() throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLNearestDc> helpGetNearestDc() throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate> helpGetAppUpdate(String deviceModel, String systemVersion, String appVersion, String langCode) throws IOException;

    Observable<TLBool> helpSaveAppLog(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputAppEvent> events) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.help.TLInviteText> helpGetInviteText(String langCode) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos> photosGetUserPhotos(com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int offset, int maxId, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage> messagesForwardMessage(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int id, long randomId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages> messagesSendBroadcast(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> contacts, String message, com.github.badoualy.telegram.tl.api.TLAbsInputMedia media) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig> messagesGetDhConfig(int version, int randomLength) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat> messagesRequestEncryption(com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int randomId, TLBytes gA) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat> messagesAcceptEncryption(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, TLBytes gB, long keyFingerprint) throws IOException;

    Observable<TLBool> messagesDiscardEncryption(int chatId) throws IOException;

    Observable<TLBool> messagesSetEncryptedTyping(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, boolean typing) throws IOException;

    Observable<TLBool> messagesReadEncryptedHistory(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, int maxDate) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage> messagesSendEncrypted(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, long randomId, TLBytes data) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage> messagesSendEncryptedFile(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, long randomId, TLBytes data, com.github.badoualy.telegram.tl.api.TLAbsInputEncryptedFile file) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage> messagesSendEncryptedService(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, long randomId, TLBytes data) throws IOException;

    Observable<com.github.badoualy.telegram.tl.core.TLLongVector> messagesReceivedQueue(int maxQts) throws IOException;

    Observable<TLBool> uploadSaveBigFilePart(long fileId, int filePart, int fileTotalParts, TLBytes bytes) throws IOException;

    <T extends TLObject> Observable<T> initConnection(int apiId, String deviceModel, String systemVersion, String appVersion, String langCode, TLMethod<T> query) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.help.TLSupport> helpGetSupport() throws IOException;

    Observable<TLBool> authSendSms(String phoneNumber, String phoneCodeHash) throws IOException;

    Observable<com.github.badoualy.telegram.tl.core.TLIntVector> messagesReadMessageContents(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    Observable<TLBool> accountCheckUsername(String username) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUser> accountUpdateUsername(String username) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.contacts.TLFound> contactsSearch(String q, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.account.TLPrivacyRules> accountGetPrivacy(com.github.badoualy.telegram.tl.api.TLInputPrivacyKey key) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.account.TLPrivacyRules> accountSetPrivacy(com.github.badoualy.telegram.tl.api.TLInputPrivacyKey key, com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyRule> rules) throws IOException;

    Observable<TLBool> accountDeleteAccount(String reason) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAccountDaysTTL> accountGetAccountTTL() throws IOException;

    Observable<TLBool> accountSetAccountTTL(com.github.badoualy.telegram.tl.api.TLAccountDaysTTL ttl) throws IOException;

    <T extends TLObject> Observable<T> invokeWithLayer(int layer, TLMethod<T> query) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUser> contactsResolveUsername(String username) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.account.TLSentChangePhoneCode> accountSendChangePhoneCode(String phoneNumber) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUser> accountChangePhone(String phoneNumber, String phoneCodeHash, String phoneCode) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsStickers> messagesGetStickers(String emoticon, String hash) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers> messagesGetAllStickers(String hash) throws IOException;

    Observable<TLBool> accountUpdateDeviceLocked(int period) throws IOException;

}
