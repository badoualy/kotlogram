
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.api.requests.*;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;

/** Generated class that implements TelegramApi methods with a default synchronous behavior, and make the implementation more
convenient by just having to implement a method to execute the RPC (Remote Procedure Call) query */
public abstract class TelegramApiWrapper implements TelegramApi {

    public abstract <T extends TLObject> T executeRpcQuery(TLMethod<T> method) throws IOException;

    @Override
    public TLObject invokeAfterMsg(long msgId, TLMethod query) throws IOException {
        return executeRpcQuery(new TLRequestInvokeAfterMsg(msgId, query));
    }

    @Override
    public TLObject invokeAfterMsgs(com.github.badoualy.telegram.tl.core.TLLongVector msgIds, TLMethod query) throws IOException {
        return executeRpcQuery(new TLRequestInvokeAfterMsgs(msgIds, query));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.auth.TLCheckedPhone authCheckPhone(String phoneNumber) throws IOException {
        return executeRpcQuery(new TLRequestAuthCheckPhone(phoneNumber));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode authSendCode(String phoneNumber, int smsType, int apiId, String apiHash, String langCode) throws IOException {
        return executeRpcQuery(new TLRequestAuthSendCode(phoneNumber, smsType, apiId, apiHash, langCode));
    }

    @Override
    public TLBool authSendCall(String phoneNumber, String phoneCodeHash) throws IOException {
        return executeRpcQuery(new TLRequestAuthSendCall(phoneNumber, phoneCodeHash));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.auth.TLAuthorization authSignUp(String phoneNumber, String phoneCodeHash, String phoneCode, String firstName, String lastName) throws IOException {
        return executeRpcQuery(new TLRequestAuthSignUp(phoneNumber, phoneCodeHash, phoneCode, firstName, lastName));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.auth.TLAuthorization authSignIn(String phoneNumber, String phoneCodeHash, String phoneCode) throws IOException {
        return executeRpcQuery(new TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode));
    }

    @Override
    public TLBool authLogOut() throws IOException {
        return executeRpcQuery(new TLRequestAuthLogOut());
    }

    @Override
    public TLBool authResetAuthorizations() throws IOException {
        return executeRpcQuery(new TLRequestAuthResetAuthorizations());
    }

    @Override
    public TLBool authSendInvites(com.github.badoualy.telegram.tl.core.TLStringVector phoneNumbers, String message) throws IOException {
        return executeRpcQuery(new TLRequestAuthSendInvites(phoneNumbers, message));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization authExportAuthorization(int dcId) throws IOException {
        return executeRpcQuery(new TLRequestAuthExportAuthorization(dcId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.auth.TLAuthorization authImportAuthorization(int id, TLBytes bytes) throws IOException {
        return executeRpcQuery(new TLRequestAuthImportAuthorization(id, bytes));
    }

    @Override
    public TLBool authBindTempAuthKey(long permAuthKeyId, long nonce, int expiresAt, TLBytes encryptedMessage) throws IOException {
        return executeRpcQuery(new TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage));
    }

    @Override
    public TLBool accountRegisterDevice(int tokenType, String token, String deviceModel, String systemVersion, String appVersion, boolean appSandbox, String langCode) throws IOException {
        return executeRpcQuery(new TLRequestAccountRegisterDevice(tokenType, token, deviceModel, systemVersion, appVersion, appSandbox, langCode));
    }

    @Override
    public TLBool accountUnregisterDevice(int tokenType, String token) throws IOException {
        return executeRpcQuery(new TLRequestAccountUnregisterDevice(tokenType, token));
    }

    @Override
    public TLBool accountUpdateNotifySettings(com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer peer, com.github.badoualy.telegram.tl.api.TLInputPeerNotifySettings settings) throws IOException {
        return executeRpcQuery(new TLRequestAccountUpdateNotifySettings(peer, settings));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings accountGetNotifySettings(com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer peer) throws IOException {
        return executeRpcQuery(new TLRequestAccountGetNotifySettings(peer));
    }

    @Override
    public TLBool accountResetNotifySettings() throws IOException {
        return executeRpcQuery(new TLRequestAccountResetNotifySettings());
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUser accountUpdateProfile(String firstName, String lastName) throws IOException {
        return executeRpcQuery(new TLRequestAccountUpdateProfile(firstName, lastName));
    }

    @Override
    public TLBool accountUpdateStatus(boolean offline) throws IOException {
        return executeRpcQuery(new TLRequestAccountUpdateStatus(offline));
    }

    @Override
    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsWallPaper> accountGetWallPapers() throws IOException {
        return executeRpcQuery(new TLRequestAccountGetWallPapers());
    }

    @Override
    public TLBool accountReportPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.api.TLAbsReportReason reason) throws IOException {
        return executeRpcQuery(new TLRequestAccountReportPeer(peer, reason));
    }

    @Override
    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> usersGetUsers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> id) throws IOException {
        return executeRpcQuery(new TLRequestUsersGetUsers(id));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLUserFull usersGetFullUser(com.github.badoualy.telegram.tl.api.TLAbsInputUser id) throws IOException {
        return executeRpcQuery(new TLRequestUsersGetFullUser(id));
    }

    @Override
    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLContactStatus> contactsGetStatuses() throws IOException {
        return executeRpcQuery(new TLRequestContactsGetStatuses());
    }

    @Override
    public com.github.badoualy.telegram.tl.api.contacts.TLAbsContacts contactsGetContacts(String hash) throws IOException {
        return executeRpcQuery(new TLRequestContactsGetContacts(hash));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts contactsImportContacts(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputContact> contacts, boolean replace) throws IOException {
        return executeRpcQuery(new TLRequestContactsImportContacts(contacts, replace));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.contacts.TLSuggested contactsGetSuggested(int limit) throws IOException {
        return executeRpcQuery(new TLRequestContactsGetSuggested(limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.contacts.TLLink contactsDeleteContact(com.github.badoualy.telegram.tl.api.TLAbsInputUser id) throws IOException {
        return executeRpcQuery(new TLRequestContactsDeleteContact(id));
    }

    @Override
    public TLBool contactsDeleteContacts(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> id) throws IOException {
        return executeRpcQuery(new TLRequestContactsDeleteContacts(id));
    }

    @Override
    public TLBool contactsBlock(com.github.badoualy.telegram.tl.api.TLAbsInputUser id) throws IOException {
        return executeRpcQuery(new TLRequestContactsBlock(id));
    }

    @Override
    public TLBool contactsUnblock(com.github.badoualy.telegram.tl.api.TLAbsInputUser id) throws IOException {
        return executeRpcQuery(new TLRequestContactsUnblock(id));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.contacts.TLAbsBlocked contactsGetBlocked(int offset, int limit) throws IOException {
        return executeRpcQuery(new TLRequestContactsGetBlocked(offset, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.core.TLIntVector contactsExportCard() throws IOException {
        return executeRpcQuery(new TLRequestContactsExportCard());
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUser contactsImportCard(com.github.badoualy.telegram.tl.core.TLIntVector exportCard) throws IOException {
        return executeRpcQuery(new TLRequestContactsImportCard(exportCard));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsMessages messagesGetMessages(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetMessages(id));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs messagesGetDialogs(int offset, int maxId, int limit) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetDialogs(offset, maxId, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsMessages messagesGetHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int offset, int maxId, int limit) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetHistory(peer, offset, maxId, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsMessages messagesSearch(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, String q, com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter filter, int minDate, int maxDate, int offset, int maxId, int limit) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSearch(peer, q, filter, minDate, maxDate, offset, maxId, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory messagesReadHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int maxId, int offset, boolean readContents) throws IOException {
        return executeRpcQuery(new TLRequestMessagesReadHistory(peer, maxId, offset, readContents));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory messagesDeleteHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int offset) throws IOException {
        return executeRpcQuery(new TLRequestMessagesDeleteHistory(peer, offset));
    }

    @Override
    public com.github.badoualy.telegram.tl.core.TLIntVector messagesDeleteMessages(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException {
        return executeRpcQuery(new TLRequestMessagesDeleteMessages(id));
    }

    @Override
    public com.github.badoualy.telegram.tl.core.TLIntVector messagesReceivedMessages(int maxId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesReceivedMessages(maxId));
    }

    @Override
    public TLBool messagesSetTyping(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction action) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSetTyping(peer, action));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsSentMessage messagesSendMessage(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, String message, long randomId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSendMessage(peer, message, randomId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesSendMedia(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.api.TLAbsInputMedia media, long randomId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSendMedia(peer, media, randomId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages messagesForwardMessages(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException {
        return executeRpcQuery(new TLRequestMessagesForwardMessages(peer, id));
    }

    @Override
    public TLBool messagesReportSpam(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer) throws IOException {
        return executeRpcQuery(new TLRequestMessagesReportSpam(peer));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLChats messagesGetChats(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetChats(id));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLChatFull messagesGetFullChat(int chatId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetFullChat(chatId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesEditChatTitle(int chatId, String title) throws IOException {
        return executeRpcQuery(new TLRequestMessagesEditChatTitle(chatId, title));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesEditChatPhoto(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto photo) throws IOException {
        return executeRpcQuery(new TLRequestMessagesEditChatPhoto(chatId, photo));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesAddChatUser(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int fwdLimit) throws IOException {
        return executeRpcQuery(new TLRequestMessagesAddChatUser(chatId, userId, fwdLimit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesDeleteChatUser(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesDeleteChatUser(chatId, userId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesCreateChat(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> users, String title) throws IOException {
        return executeRpcQuery(new TLRequestMessagesCreateChat(users, title));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.updates.TLState updatesGetState() throws IOException {
        return executeRpcQuery(new TLRequestUpdatesGetState());
    }

    @Override
    public com.github.badoualy.telegram.tl.api.updates.TLAbsDifference updatesGetDifference(int pts, int date, int qts) throws IOException {
        return executeRpcQuery(new TLRequestUpdatesGetDifference(pts, date, qts));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto photosUpdateProfilePhoto(com.github.badoualy.telegram.tl.api.TLAbsInputPhoto id, com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop crop) throws IOException {
        return executeRpcQuery(new TLRequestPhotosUpdateProfilePhoto(id, crop));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.photos.TLPhoto photosUploadProfilePhoto(com.github.badoualy.telegram.tl.api.TLAbsInputFile file, String caption, com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint geoPoint, com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop crop) throws IOException {
        return executeRpcQuery(new TLRequestPhotosUploadProfilePhoto(file, caption, geoPoint, crop));
    }

    @Override
    public com.github.badoualy.telegram.tl.core.TLLongVector photosDeletePhotos(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPhoto> id) throws IOException {
        return executeRpcQuery(new TLRequestPhotosDeletePhotos(id));
    }

    @Override
    public TLBool uploadSaveFilePart(long fileId, int filePart, TLBytes bytes) throws IOException {
        return executeRpcQuery(new TLRequestUploadSaveFilePart(fileId, filePart, bytes));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.upload.TLFile uploadGetFile(com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation location, int offset, int limit) throws IOException {
        return executeRpcQuery(new TLRequestUploadGetFile(location, offset, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLConfig helpGetConfig() throws IOException {
        return executeRpcQuery(new TLRequestHelpGetConfig());
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLNearestDc helpGetNearestDc() throws IOException {
        return executeRpcQuery(new TLRequestHelpGetNearestDc());
    }

    @Override
    public com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate helpGetAppUpdate(String deviceModel, String systemVersion, String appVersion, String langCode) throws IOException {
        return executeRpcQuery(new TLRequestHelpGetAppUpdate(deviceModel, systemVersion, appVersion, langCode));
    }

    @Override
    public TLBool helpSaveAppLog(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputAppEvent> events) throws IOException {
        return executeRpcQuery(new TLRequestHelpSaveAppLog(events));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.help.TLInviteText helpGetInviteText(String langCode) throws IOException {
        return executeRpcQuery(new TLRequestHelpGetInviteText(langCode));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos photosGetUserPhotos(com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int offset, int maxId, int limit) throws IOException {
        return executeRpcQuery(new TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesForwardMessage(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int id, long randomId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesForwardMessage(peer, id, randomId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages messagesSendBroadcast(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> contacts, String message, com.github.badoualy.telegram.tl.api.TLAbsInputMedia media) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSendBroadcast(contacts, message, media));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig messagesGetDhConfig(int version, int randomLength) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetDhConfig(version, randomLength));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat messagesRequestEncryption(com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int randomId, TLBytes gA) throws IOException {
        return executeRpcQuery(new TLRequestMessagesRequestEncryption(userId, randomId, gA));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat messagesAcceptEncryption(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, TLBytes gB, long keyFingerprint) throws IOException {
        return executeRpcQuery(new TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint));
    }

    @Override
    public TLBool messagesDiscardEncryption(int chatId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesDiscardEncryption(chatId));
    }

    @Override
    public TLBool messagesSetEncryptedTyping(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, boolean typing) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSetEncryptedTyping(peer, typing));
    }

    @Override
    public TLBool messagesReadEncryptedHistory(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, int maxDate) throws IOException {
        return executeRpcQuery(new TLRequestMessagesReadEncryptedHistory(peer, maxDate));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage messagesSendEncrypted(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, long randomId, TLBytes data) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSendEncrypted(peer, randomId, data));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage messagesSendEncryptedFile(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, long randomId, TLBytes data, com.github.badoualy.telegram.tl.api.TLAbsInputEncryptedFile file) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSendEncryptedFile(peer, randomId, data, file));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage messagesSendEncryptedService(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, long randomId, TLBytes data) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSendEncryptedService(peer, randomId, data));
    }

    @Override
    public com.github.badoualy.telegram.tl.core.TLLongVector messagesReceivedQueue(int maxQts) throws IOException {
        return executeRpcQuery(new TLRequestMessagesReceivedQueue(maxQts));
    }

    @Override
    public TLBool uploadSaveBigFilePart(long fileId, int filePart, int fileTotalParts, TLBytes bytes) throws IOException {
        return executeRpcQuery(new TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes));
    }

    @Override
    public <T extends TLObject> T initConnection(int apiId, String deviceModel, String systemVersion, String appVersion, String langCode, TLMethod<T> query) throws IOException {
        return executeRpcQuery(new TLRequestInitConnection<>(apiId, deviceModel, systemVersion, appVersion, langCode, query));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.help.TLSupport helpGetSupport() throws IOException {
        return executeRpcQuery(new TLRequestHelpGetSupport());
    }

    @Override
    public TLBool authSendSms(String phoneNumber, String phoneCodeHash) throws IOException {
        return executeRpcQuery(new TLRequestAuthSendSms(phoneNumber, phoneCodeHash));
    }

    @Override
    public com.github.badoualy.telegram.tl.core.TLIntVector messagesReadMessageContents(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException {
        return executeRpcQuery(new TLRequestMessagesReadMessageContents(id));
    }

    @Override
    public TLBool accountCheckUsername(String username) throws IOException {
        return executeRpcQuery(new TLRequestAccountCheckUsername(username));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUser accountUpdateUsername(String username) throws IOException {
        return executeRpcQuery(new TLRequestAccountUpdateUsername(username));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.contacts.TLFound contactsSearch(String q, int limit) throws IOException {
        return executeRpcQuery(new TLRequestContactsSearch(q, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.account.TLPrivacyRules accountGetPrivacy(com.github.badoualy.telegram.tl.api.TLInputPrivacyKey key) throws IOException {
        return executeRpcQuery(new TLRequestAccountGetPrivacy(key));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.account.TLPrivacyRules accountSetPrivacy(com.github.badoualy.telegram.tl.api.TLInputPrivacyKey key, com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyRule> rules) throws IOException {
        return executeRpcQuery(new TLRequestAccountSetPrivacy(key, rules));
    }

    @Override
    public TLBool accountDeleteAccount(String reason) throws IOException {
        return executeRpcQuery(new TLRequestAccountDeleteAccount(reason));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAccountDaysTTL accountGetAccountTTL() throws IOException {
        return executeRpcQuery(new TLRequestAccountGetAccountTTL());
    }

    @Override
    public TLBool accountSetAccountTTL(com.github.badoualy.telegram.tl.api.TLAccountDaysTTL ttl) throws IOException {
        return executeRpcQuery(new TLRequestAccountSetAccountTTL(ttl));
    }

    @Override
    public <T extends TLObject> T invokeWithLayer(int layer, TLMethod<T> query) throws IOException {
        return executeRpcQuery(new TLRequestInvokeWithLayer<>(layer, query));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUser contactsResolveUsername(String username) throws IOException {
        return executeRpcQuery(new TLRequestContactsResolveUsername(username));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.account.TLSentChangePhoneCode accountSendChangePhoneCode(String phoneNumber) throws IOException {
        return executeRpcQuery(new TLRequestAccountSendChangePhoneCode(phoneNumber));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUser accountChangePhone(String phoneNumber, String phoneCodeHash, String phoneCode) throws IOException {
        return executeRpcQuery(new TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsStickers messagesGetStickers(String emoticon, String hash) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetStickers(emoticon, hash));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers messagesGetAllStickers(String hash) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetAllStickers(hash));
    }

    @Override
    public TLBool accountUpdateDeviceLocked(int period) throws IOException {
        return executeRpcQuery(new TLRequestAccountUpdateDeviceLocked(period));
    }

}
