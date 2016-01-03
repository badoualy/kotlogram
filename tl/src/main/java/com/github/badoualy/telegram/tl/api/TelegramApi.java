
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


import com.github.badoualy.telegram.tl.api.requests.*;

public interface TelegramApi {

    TLObject invokeAfterMsg(long msgId, TLMethod query) throws IOException;

    TLObject invokeAfterMsgs(com.github.badoualy.telegram.tl.core.TLLongVector msgIds, TLMethod query) throws IOException;

    com.github.badoualy.telegram.tl.api.auth.TLCheckedPhone authCheckPhone(String phoneNumber) throws IOException;

    com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode authSendCode(String phoneNumber, int smsType, int apiId, String apiHash, String langCode) throws IOException;

    TLBool authSendCall(String phoneNumber, String phoneCodeHash) throws IOException;

    com.github.badoualy.telegram.tl.api.auth.TLAuthorization authSignUp(String phoneNumber, String phoneCodeHash, String phoneCode, String firstName, String lastName) throws IOException;

    com.github.badoualy.telegram.tl.api.auth.TLAuthorization authSignIn(String phoneNumber, String phoneCodeHash, String phoneCode) throws IOException;

    TLBool authLogOut() throws IOException;

    TLBool authResetAuthorizations() throws IOException;

    TLBool authSendInvites(com.github.badoualy.telegram.tl.core.TLStringVector phoneNumbers, String message) throws IOException;

    com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization authExportAuthorization(int dcId) throws IOException;

    com.github.badoualy.telegram.tl.api.auth.TLAuthorization authImportAuthorization(int id, TLBytes bytes) throws IOException;

    TLBool authBindTempAuthKey(long permAuthKeyId, long nonce, int expiresAt, TLBytes encryptedMessage) throws IOException;

    TLBool accountRegisterDevice(int tokenType, String token, String deviceModel, String systemVersion, String appVersion, boolean appSandbox, String langCode) throws IOException;

    TLBool accountUnregisterDevice(int tokenType, String token) throws IOException;

    TLBool accountUpdateNotifySettings(com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer peer, com.github.badoualy.telegram.tl.api.TLInputPeerNotifySettings settings) throws IOException;

    com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings accountGetNotifySettings(com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer peer) throws IOException;

    TLBool accountResetNotifySettings() throws IOException;

    com.github.badoualy.telegram.tl.api.TLAbsUser accountUpdateProfile(String firstName, String lastName) throws IOException;

    TLBool accountUpdateStatus(boolean offline) throws IOException;

    com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsWallPaper> accountGetWallPapers() throws IOException;

    com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> usersGetUsers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> id) throws IOException;

    com.github.badoualy.telegram.tl.api.TLUserFull usersGetFullUser(com.github.badoualy.telegram.tl.api.TLAbsInputUser id) throws IOException;

    com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLContactStatus> contactsGetStatuses() throws IOException;

    com.github.badoualy.telegram.tl.api.contacts.TLAbsContacts contactsGetContacts(String hash) throws IOException;

    com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts contactsImportContacts(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputContact> contacts, boolean replace) throws IOException;

    com.github.badoualy.telegram.tl.api.contacts.TLSuggested contactsGetSuggested(int limit) throws IOException;

    com.github.badoualy.telegram.tl.api.contacts.TLLink contactsDeleteContact(com.github.badoualy.telegram.tl.api.TLAbsInputUser id) throws IOException;

    TLBool contactsDeleteContacts(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> id) throws IOException;

    TLBool contactsBlock(com.github.badoualy.telegram.tl.api.TLAbsInputUser id) throws IOException;

    TLBool contactsUnblock(com.github.badoualy.telegram.tl.api.TLAbsInputUser id) throws IOException;

    com.github.badoualy.telegram.tl.api.contacts.TLAbsBlocked contactsGetBlocked(int offset, int limit) throws IOException;

    com.github.badoualy.telegram.tl.core.TLIntVector contactsExportCard() throws IOException;

    com.github.badoualy.telegram.tl.api.TLAbsUser contactsImportCard(com.github.badoualy.telegram.tl.core.TLIntVector exportCard) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsMessages messagesGetMessages(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs messagesGetDialogs(int offset, int maxId, int limit) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsMessages messagesGetHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int offset, int maxId, int limit) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsMessages messagesSearch(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, String q, com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter filter, int minDate, int maxDate, int offset, int maxId, int limit) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory messagesReadHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int maxId, int offset, boolean readContents) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory messagesDeleteHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int offset) throws IOException;

    com.github.badoualy.telegram.tl.core.TLIntVector messagesDeleteMessages(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    com.github.badoualy.telegram.tl.core.TLIntVector messagesReceivedMessages(int maxId) throws IOException;

    TLBool messagesSetTyping(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction action) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsSentMessage messagesSendMessage(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, String message, long randomId) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesSendMedia(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.api.TLAbsInputMedia media, long randomId) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages messagesForwardMessages(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    TLBool messagesReportSpam(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLChats messagesGetChats(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLChatFull messagesGetFullChat(int chatId) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesEditChatTitle(int chatId, String title) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesEditChatPhoto(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto photo) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesAddChatUser(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int fwdLimit) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesDeleteChatUser(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesCreateChat(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> users, String title) throws IOException;

    com.github.badoualy.telegram.tl.api.updates.TLState updatesGetState() throws IOException;

    com.github.badoualy.telegram.tl.api.updates.TLAbsDifference updatesGetDifference(int pts, int date, int qts) throws IOException;

    com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto photosUpdateProfilePhoto(com.github.badoualy.telegram.tl.api.TLAbsInputPhoto id, com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop crop) throws IOException;

    com.github.badoualy.telegram.tl.api.photos.TLPhoto photosUploadProfilePhoto(com.github.badoualy.telegram.tl.api.TLAbsInputFile file, String caption, com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint geoPoint, com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop crop) throws IOException;

    com.github.badoualy.telegram.tl.core.TLLongVector photosDeletePhotos(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPhoto> id) throws IOException;

    TLBool uploadSaveFilePart(long fileId, int filePart, TLBytes bytes) throws IOException;

    com.github.badoualy.telegram.tl.api.upload.TLFile uploadGetFile(com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation location, int offset, int limit) throws IOException;

    com.github.badoualy.telegram.tl.api.TLConfig helpGetConfig() throws IOException;

    com.github.badoualy.telegram.tl.api.TLNearestDc helpGetNearestDc() throws IOException;

    com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate helpGetAppUpdate(String deviceModel, String systemVersion, String appVersion, String langCode) throws IOException;

    TLBool helpSaveAppLog(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputAppEvent> events) throws IOException;

    com.github.badoualy.telegram.tl.api.help.TLInviteText helpGetInviteText(String langCode) throws IOException;

    com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos photosGetUserPhotos(com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int offset, int maxId, int limit) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage messagesForwardMessage(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int id, long randomId) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages messagesSendBroadcast(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> contacts, String message, com.github.badoualy.telegram.tl.api.TLAbsInputMedia media) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig messagesGetDhConfig(int version, int randomLength) throws IOException;

    com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat messagesRequestEncryption(com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int randomId, TLBytes gA) throws IOException;

    com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat messagesAcceptEncryption(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, TLBytes gB, long keyFingerprint) throws IOException;

    TLBool messagesDiscardEncryption(int chatId) throws IOException;

    TLBool messagesSetEncryptedTyping(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, boolean typing) throws IOException;

    TLBool messagesReadEncryptedHistory(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, int maxDate) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage messagesSendEncrypted(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, long randomId, TLBytes data) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage messagesSendEncryptedFile(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, long randomId, TLBytes data, com.github.badoualy.telegram.tl.api.TLAbsInputEncryptedFile file) throws IOException;

    com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage messagesSendEncryptedService(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer, long randomId, TLBytes data) throws IOException;

    com.github.badoualy.telegram.tl.core.TLLongVector messagesReceivedQueue(int maxQts) throws IOException;

    TLBool uploadSaveBigFilePart(long fileId, int filePart, int fileTotalParts, TLBytes bytes) throws IOException;

    <T extends TLObject> T initConnection(int apiId, String deviceModel, String systemVersion, String appVersion, String langCode, TLMethod<T> query) throws IOException;

    com.github.badoualy.telegram.tl.api.help.TLSupport helpGetSupport() throws IOException;

    TLBool authSendSms(String phoneNumber, String phoneCodeHash) throws IOException;

    com.github.badoualy.telegram.tl.core.TLIntVector messagesReadMessageContents(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    TLBool accountCheckUsername(String username) throws IOException;

    com.github.badoualy.telegram.tl.api.TLAbsUser accountUpdateUsername(String username) throws IOException;

    com.github.badoualy.telegram.tl.api.contacts.TLFound contactsSearch(String q, int limit) throws IOException;

    <T extends TLObject> T invokeWithLayer18(TLMethod<T> query) throws IOException;

}
