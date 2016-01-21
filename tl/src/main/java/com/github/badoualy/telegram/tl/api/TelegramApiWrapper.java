
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
    public com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs messagesGetDialogs(int offsetDate, int offsetId, com.github.badoualy.telegram.tl.api.TLAbsInputPeer offsetPeer, int limit) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetDialogs(offsetDate, offsetId, offsetPeer, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsMessages messagesGetHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int offsetId, int addOffset, int limit, int maxId, int minId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetHistory(peer, offsetId, addOffset, limit, maxId, minId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsMessages messagesSearch(int flags, boolean importantOnly, com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, String q, com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter filter, int minDate, int maxDate, int offset, int maxId, int limit) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSearch(flags, importantOnly, peer, q, filter, minDate, maxDate, offset, maxId, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages messagesReadHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int maxId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesReadHistory(peer, maxId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory messagesDeleteHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int maxId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesDeleteHistory(peer, maxId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages messagesDeleteMessages(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException {
        return executeRpcQuery(new TLRequestMessagesDeleteMessages(id));
    }

    @Override
    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLReceivedNotifyMessage> messagesReceivedMessages(int maxId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesReceivedMessages(maxId));
    }

    @Override
    public TLBool messagesSetTyping(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction action) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSetTyping(peer, action));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesSendMessage(int flags, boolean noWebpage, boolean broadcast, com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int replyToMsgId, String message, long randomId, com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup replyMarkup, com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> entities) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSendMessage(flags, noWebpage, broadcast, peer, replyToMsgId, message, randomId, replyMarkup, entities));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesSendMedia(int flags, boolean broadcast, com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int replyToMsgId, com.github.badoualy.telegram.tl.api.TLAbsInputMedia media, long randomId, com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup replyMarkup) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSendMedia(flags, broadcast, peer, replyToMsgId, media, randomId, replyMarkup));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesForwardMessages(int flags, boolean broadcast, com.github.badoualy.telegram.tl.api.TLAbsInputPeer fromPeer, com.github.badoualy.telegram.tl.core.TLIntVector id, com.github.badoualy.telegram.tl.core.TLLongVector randomId, com.github.badoualy.telegram.tl.api.TLAbsInputPeer toPeer) throws IOException {
        return executeRpcQuery(new TLRequestMessagesForwardMessages(flags, broadcast, fromPeer, id, randomId, toPeer));
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
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesEditChatTitle(int chatId, String title) throws IOException {
        return executeRpcQuery(new TLRequestMessagesEditChatTitle(chatId, title));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesEditChatPhoto(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto photo) throws IOException {
        return executeRpcQuery(new TLRequestMessagesEditChatPhoto(chatId, photo));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesAddChatUser(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int fwdLimit) throws IOException {
        return executeRpcQuery(new TLRequestMessagesAddChatUser(chatId, userId, fwdLimit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesDeleteChatUser(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesDeleteChatUser(chatId, userId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesCreateChat(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> users, String title) throws IOException {
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
    public com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos photosGetUserPhotos(com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int offset, long maxId, int limit) throws IOException {
        return executeRpcQuery(new TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesForwardMessage(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int id, long randomId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesForwardMessage(peer, id, randomId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesSendBroadcast(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> contacts, com.github.badoualy.telegram.tl.core.TLLongVector randomId, String message, com.github.badoualy.telegram.tl.api.TLAbsInputMedia media) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSendBroadcast(contacts, randomId, message, media));
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
    public com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages messagesReadMessageContents(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException {
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
    public com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer contactsResolveUsername(String username) throws IOException {
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
    public com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers messagesGetAllStickers(int hash) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetAllStickers(hash));
    }

    @Override
    public TLBool accountUpdateDeviceLocked(int period) throws IOException {
        return executeRpcQuery(new TLRequestAccountUpdateDeviceLocked(period));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.auth.TLAuthorization authImportBotAuthorization(int flags, int apiId, String apiHash, String botAuthToken) throws IOException {
        return executeRpcQuery(new TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsMessageMedia messagesGetWebPagePreview(String message) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetWebPagePreview(message));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.account.TLAuthorizations accountGetAuthorizations() throws IOException {
        return executeRpcQuery(new TLRequestAccountGetAuthorizations());
    }

    @Override
    public TLBool accountResetAuthorization(long hash) throws IOException {
        return executeRpcQuery(new TLRequestAccountResetAuthorization(hash));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.account.TLAbsPassword accountGetPassword() throws IOException {
        return executeRpcQuery(new TLRequestAccountGetPassword());
    }

    @Override
    public com.github.badoualy.telegram.tl.api.account.TLPasswordSettings accountGetPasswordSettings(TLBytes currentPasswordHash) throws IOException {
        return executeRpcQuery(new TLRequestAccountGetPasswordSettings(currentPasswordHash));
    }

    @Override
    public TLBool accountUpdatePasswordSettings(TLBytes currentPasswordHash, com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings newSettings) throws IOException {
        return executeRpcQuery(new TLRequestAccountUpdatePasswordSettings(currentPasswordHash, newSettings));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.auth.TLAuthorization authCheckPassword(TLBytes passwordHash) throws IOException {
        return executeRpcQuery(new TLRequestAuthCheckPassword(passwordHash));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery authRequestPasswordRecovery() throws IOException {
        return executeRpcQuery(new TLRequestAuthRequestPasswordRecovery());
    }

    @Override
    public com.github.badoualy.telegram.tl.api.auth.TLAuthorization authRecoverPassword(String code) throws IOException {
        return executeRpcQuery(new TLRequestAuthRecoverPassword(code));
    }

    @Override
    public TLObject invokeWithoutUpdates(TLMethod query) throws IOException {
        return executeRpcQuery(new TLRequestInvokeWithoutUpdates(query));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite messagesExportChatInvite(int chatId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesExportChatInvite(chatId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsChatInvite messagesCheckChatInvite(String hash) throws IOException {
        return executeRpcQuery(new TLRequestMessagesCheckChatInvite(hash));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesImportChatInvite(String hash) throws IOException {
        return executeRpcQuery(new TLRequestMessagesImportChatInvite(hash));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLStickerSet messagesGetStickerSet(com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet stickerset) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetStickerSet(stickerset));
    }

    @Override
    public TLBool messagesInstallStickerSet(com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet stickerset, boolean disabled) throws IOException {
        return executeRpcQuery(new TLRequestMessagesInstallStickerSet(stickerset, disabled));
    }

    @Override
    public TLBool messagesUninstallStickerSet(com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet stickerset) throws IOException {
        return executeRpcQuery(new TLRequestMessagesUninstallStickerSet(stickerset));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesStartBot(com.github.badoualy.telegram.tl.api.TLAbsInputUser bot, com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, long randomId, String startParam) throws IOException {
        return executeRpcQuery(new TLRequestMessagesStartBot(bot, peer, randomId, startParam));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.help.TLAbsAppChangelog helpGetAppChangelog(String deviceModel, String systemVersion, String appVersion, String langCode) throws IOException {
        return executeRpcQuery(new TLRequestHelpGetAppChangelog(deviceModel, systemVersion, appVersion, langCode));
    }

    @Override
    public com.github.badoualy.telegram.tl.core.TLIntVector messagesGetMessagesViews(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.core.TLIntVector id, boolean increment) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetMessagesViews(peer, id, increment));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs channelsGetDialogs(int offset, int limit) throws IOException {
        return executeRpcQuery(new TLRequestChannelsGetDialogs(offset, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsMessages channelsGetImportantHistory(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, int offsetId, int addOffset, int limit, int maxId, int minId) throws IOException {
        return executeRpcQuery(new TLRequestChannelsGetImportantHistory(channel, offsetId, addOffset, limit, maxId, minId));
    }

    @Override
    public TLBool channelsReadHistory(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, int maxId) throws IOException {
        return executeRpcQuery(new TLRequestChannelsReadHistory(channel, maxId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages channelsDeleteMessages(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException {
        return executeRpcQuery(new TLRequestChannelsDeleteMessages(channel, id));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory channelsDeleteUserHistory(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId) throws IOException {
        return executeRpcQuery(new TLRequestChannelsDeleteUserHistory(channel, userId));
    }

    @Override
    public TLBool channelsReportSpam(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException {
        return executeRpcQuery(new TLRequestChannelsReportSpam(channel, userId, id));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsMessages channelsGetMessages(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException {
        return executeRpcQuery(new TLRequestChannelsGetMessages(channel, id));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.channels.TLChannelParticipants channelsGetParticipants(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantsFilter filter, int offset, int limit) throws IOException {
        return executeRpcQuery(new TLRequestChannelsGetParticipants(channel, filter, offset, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant channelsGetParticipant(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId) throws IOException {
        return executeRpcQuery(new TLRequestChannelsGetParticipant(channel, userId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLChats channelsGetChannels(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputChannel> id) throws IOException {
        return executeRpcQuery(new TLRequestChannelsGetChannels(id));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLChatFull channelsGetFullChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel) throws IOException {
        return executeRpcQuery(new TLRequestChannelsGetFullChannel(channel));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates channelsCreateChannel(int flags, boolean broadcast, boolean megagroup, String title, String about) throws IOException {
        return executeRpcQuery(new TLRequestChannelsCreateChannel(flags, broadcast, megagroup, title, about));
    }

    @Override
    public TLBool channelsEditAbout(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, String about) throws IOException {
        return executeRpcQuery(new TLRequestChannelsEditAbout(channel, about));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates channelsEditAdmin(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantRole role) throws IOException {
        return executeRpcQuery(new TLRequestChannelsEditAdmin(channel, userId, role));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates channelsEditTitle(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, String title) throws IOException {
        return executeRpcQuery(new TLRequestChannelsEditTitle(channel, title));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates channelsEditPhoto(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto photo) throws IOException {
        return executeRpcQuery(new TLRequestChannelsEditPhoto(channel, photo));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates channelsToggleComments(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, boolean enabled) throws IOException {
        return executeRpcQuery(new TLRequestChannelsToggleComments(channel, enabled));
    }

    @Override
    public TLBool channelsCheckUsername(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, String username) throws IOException {
        return executeRpcQuery(new TLRequestChannelsCheckUsername(channel, username));
    }

    @Override
    public TLBool channelsUpdateUsername(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, String username) throws IOException {
        return executeRpcQuery(new TLRequestChannelsUpdateUsername(channel, username));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates channelsJoinChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel) throws IOException {
        return executeRpcQuery(new TLRequestChannelsJoinChannel(channel));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates channelsLeaveChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel) throws IOException {
        return executeRpcQuery(new TLRequestChannelsLeaveChannel(channel));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates channelsInviteToChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> users) throws IOException {
        return executeRpcQuery(new TLRequestChannelsInviteToChannel(channel, users));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates channelsKickFromChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, boolean kicked) throws IOException {
        return executeRpcQuery(new TLRequestChannelsKickFromChannel(channel, userId, kicked));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite channelsExportInvite(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel) throws IOException {
        return executeRpcQuery(new TLRequestChannelsExportInvite(channel));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates channelsDeleteChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel) throws IOException {
        return executeRpcQuery(new TLRequestChannelsDeleteChannel(channel));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference updatesGetChannelDifference(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsChannelMessagesFilter filter, int pts, int limit) throws IOException {
        return executeRpcQuery(new TLRequestUpdatesGetChannelDifference(channel, filter, pts, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesToggleChatAdmins(int chatId, boolean enabled) throws IOException {
        return executeRpcQuery(new TLRequestMessagesToggleChatAdmins(chatId, enabled));
    }

    @Override
    public TLBool messagesEditChatAdmin(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, boolean isAdmin) throws IOException {
        return executeRpcQuery(new TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesMigrateChat(int chatId) throws IOException {
        return executeRpcQuery(new TLRequestMessagesMigrateChat(chatId));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsMessages messagesSearchGlobal(String q, int offsetDate, com.github.badoualy.telegram.tl.api.TLAbsInputPeer offsetPeer, int offsetId, int limit) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSearchGlobal(q, offsetDate, offsetPeer, offsetId, limit));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.help.TLTermsOfService helpGetTermsOfService(String langCode) throws IOException {
        return executeRpcQuery(new TLRequestHelpGetTermsOfService(langCode));
    }

    @Override
    public TLBool messagesReorderStickerSets(com.github.badoualy.telegram.tl.core.TLLongVector order) throws IOException {
        return executeRpcQuery(new TLRequestMessagesReorderStickerSets(order));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsDocument messagesGetDocumentByHash(TLBytes sha256, int size, String mimeType) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetDocumentByHash(sha256, size, mimeType));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLFoundGifs messagesSearchGifs(String q, int offset) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSearchGifs(q, offset));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLAbsSavedGifs messagesGetSavedGifs(int hash) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetSavedGifs(hash));
    }

    @Override
    public TLBool messagesSaveGif(com.github.badoualy.telegram.tl.api.TLAbsInputDocument id, boolean unsave) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSaveGif(id, unsave));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.messages.TLBotResults messagesGetInlineBotResults(com.github.badoualy.telegram.tl.api.TLAbsInputUser bot, String query, String offset) throws IOException {
        return executeRpcQuery(new TLRequestMessagesGetInlineBotResults(bot, query, offset));
    }

    @Override
    public TLBool messagesSetInlineBotResults(int flags, boolean gallery, boolean privat, long queryId, com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputBotInlineResult> results, int cacheTime, String nextOffset) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSetInlineBotResults(flags, gallery, privat, queryId, results, cacheTime, nextOffset));
    }

    @Override
    public com.github.badoualy.telegram.tl.api.TLAbsUpdates messagesSendInlineBotResult(int flags, boolean broadcast, com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int replyToMsgId, long randomId, long queryId, String id) throws IOException {
        return executeRpcQuery(new TLRequestMessagesSendInlineBotResult(flags, broadcast, peer, replyToMsgId, randomId, queryId, id));
    }

}
