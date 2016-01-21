
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

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs> messagesGetDialogs(int offsetDate, int offsetId, com.github.badoualy.telegram.tl.api.TLAbsInputPeer offsetPeer, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsMessages> messagesGetHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int offsetId, int addOffset, int limit, int maxId, int minId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsMessages> messagesSearch(int flags, boolean importantOnly, com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, String q, com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter filter, int minDate, int maxDate, int offset, int maxId, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages> messagesReadHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int maxId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory> messagesDeleteHistory(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int maxId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages> messagesDeleteMessages(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    Observable<com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLReceivedNotifyMessage>> messagesReceivedMessages(int maxId) throws IOException;

    Observable<TLBool> messagesSetTyping(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction action) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesSendMessage(int flags, boolean noWebpage, boolean broadcast, com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int replyToMsgId, String message, long randomId, com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup replyMarkup, com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> entities) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesSendMedia(int flags, boolean broadcast, com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int replyToMsgId, com.github.badoualy.telegram.tl.api.TLAbsInputMedia media, long randomId, com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup replyMarkup) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesForwardMessages(int flags, boolean broadcast, com.github.badoualy.telegram.tl.api.TLAbsInputPeer fromPeer, com.github.badoualy.telegram.tl.core.TLIntVector id, com.github.badoualy.telegram.tl.core.TLLongVector randomId, com.github.badoualy.telegram.tl.api.TLAbsInputPeer toPeer) throws IOException;

    Observable<TLBool> messagesReportSpam(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLChats> messagesGetChats(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLChatFull> messagesGetFullChat(int chatId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesEditChatTitle(int chatId, String title) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesEditChatPhoto(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto photo) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesAddChatUser(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int fwdLimit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesDeleteChatUser(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesCreateChat(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> users, String title) throws IOException;

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

    Observable<com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos> photosGetUserPhotos(com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, int offset, long maxId, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesForwardMessage(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int id, long randomId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesSendBroadcast(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> contacts, com.github.badoualy.telegram.tl.core.TLLongVector randomId, String message, com.github.badoualy.telegram.tl.api.TLAbsInputMedia media) throws IOException;

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

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages> messagesReadMessageContents(com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    Observable<TLBool> accountCheckUsername(String username) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUser> accountUpdateUsername(String username) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.contacts.TLFound> contactsSearch(String q, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.account.TLPrivacyRules> accountGetPrivacy(com.github.badoualy.telegram.tl.api.TLInputPrivacyKey key) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.account.TLPrivacyRules> accountSetPrivacy(com.github.badoualy.telegram.tl.api.TLInputPrivacyKey key, com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyRule> rules) throws IOException;

    Observable<TLBool> accountDeleteAccount(String reason) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAccountDaysTTL> accountGetAccountTTL() throws IOException;

    Observable<TLBool> accountSetAccountTTL(com.github.badoualy.telegram.tl.api.TLAccountDaysTTL ttl) throws IOException;

    <T extends TLObject> Observable<T> invokeWithLayer(int layer, TLMethod<T> query) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer> contactsResolveUsername(String username) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.account.TLSentChangePhoneCode> accountSendChangePhoneCode(String phoneNumber) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUser> accountChangePhone(String phoneNumber, String phoneCodeHash, String phoneCode) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsStickers> messagesGetStickers(String emoticon, String hash) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers> messagesGetAllStickers(int hash) throws IOException;

    Observable<TLBool> accountUpdateDeviceLocked(int period) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.auth.TLAuthorization> authImportBotAuthorization(int flags, int apiId, String apiHash, String botAuthToken) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsMessageMedia> messagesGetWebPagePreview(String message) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.account.TLAuthorizations> accountGetAuthorizations() throws IOException;

    Observable<TLBool> accountResetAuthorization(long hash) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.account.TLAbsPassword> accountGetPassword() throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.account.TLPasswordSettings> accountGetPasswordSettings(TLBytes currentPasswordHash) throws IOException;

    Observable<TLBool> accountUpdatePasswordSettings(TLBytes currentPasswordHash, com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings newSettings) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.auth.TLAuthorization> authCheckPassword(TLBytes passwordHash) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery> authRequestPasswordRecovery() throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.auth.TLAuthorization> authRecoverPassword(String code) throws IOException;

    Observable<TLObject> invokeWithoutUpdates(TLMethod query) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite> messagesExportChatInvite(int chatId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsChatInvite> messagesCheckChatInvite(String hash) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesImportChatInvite(String hash) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLStickerSet> messagesGetStickerSet(com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet stickerset) throws IOException;

    Observable<TLBool> messagesInstallStickerSet(com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet stickerset, boolean disabled) throws IOException;

    Observable<TLBool> messagesUninstallStickerSet(com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet stickerset) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesStartBot(com.github.badoualy.telegram.tl.api.TLAbsInputUser bot, com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, long randomId, String startParam) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.help.TLAbsAppChangelog> helpGetAppChangelog(String deviceModel, String systemVersion, String appVersion, String langCode) throws IOException;

    Observable<com.github.badoualy.telegram.tl.core.TLIntVector> messagesGetMessagesViews(com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, com.github.badoualy.telegram.tl.core.TLIntVector id, boolean increment) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs> channelsGetDialogs(int offset, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsMessages> channelsGetImportantHistory(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, int offsetId, int addOffset, int limit, int maxId, int minId) throws IOException;

    Observable<TLBool> channelsReadHistory(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, int maxId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages> channelsDeleteMessages(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory> channelsDeleteUserHistory(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId) throws IOException;

    Observable<TLBool> channelsReportSpam(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsMessages> channelsGetMessages(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.core.TLIntVector id) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.channels.TLChannelParticipants> channelsGetParticipants(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantsFilter filter, int offset, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant> channelsGetParticipant(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLChats> channelsGetChannels(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputChannel> id) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLChatFull> channelsGetFullChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> channelsCreateChannel(int flags, boolean broadcast, boolean megagroup, String title, String about) throws IOException;

    Observable<TLBool> channelsEditAbout(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, String about) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> channelsEditAdmin(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantRole role) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> channelsEditTitle(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, String title) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> channelsEditPhoto(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto photo) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> channelsToggleComments(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, boolean enabled) throws IOException;

    Observable<TLBool> channelsCheckUsername(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, String username) throws IOException;

    Observable<TLBool> channelsUpdateUsername(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, String username) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> channelsJoinChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> channelsLeaveChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> channelsInviteToChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> users) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> channelsKickFromChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, boolean kicked) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite> channelsExportInvite(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> channelsDeleteChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference> updatesGetChannelDifference(com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel, com.github.badoualy.telegram.tl.api.TLAbsChannelMessagesFilter filter, int pts, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesToggleChatAdmins(int chatId, boolean enabled) throws IOException;

    Observable<TLBool> messagesEditChatAdmin(int chatId, com.github.badoualy.telegram.tl.api.TLAbsInputUser userId, boolean isAdmin) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesMigrateChat(int chatId) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsMessages> messagesSearchGlobal(String q, int offsetDate, com.github.badoualy.telegram.tl.api.TLAbsInputPeer offsetPeer, int offsetId, int limit) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.help.TLTermsOfService> helpGetTermsOfService(String langCode) throws IOException;

    Observable<TLBool> messagesReorderStickerSets(com.github.badoualy.telegram.tl.core.TLLongVector order) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsDocument> messagesGetDocumentByHash(TLBytes sha256, int size, String mimeType) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLFoundGifs> messagesSearchGifs(String q, int offset) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLAbsSavedGifs> messagesGetSavedGifs(int hash) throws IOException;

    Observable<TLBool> messagesSaveGif(com.github.badoualy.telegram.tl.api.TLAbsInputDocument id, boolean unsave) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.messages.TLBotResults> messagesGetInlineBotResults(com.github.badoualy.telegram.tl.api.TLAbsInputUser bot, String query, String offset) throws IOException;

    Observable<TLBool> messagesSetInlineBotResults(int flags, boolean gallery, boolean privat, long queryId, com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputBotInlineResult> results, int cacheTime, String nextOffset) throws IOException;

    Observable<com.github.badoualy.telegram.tl.api.TLAbsUpdates> messagesSendInlineBotResult(int flags, boolean broadcast, com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer, int replyToMsgId, long randomId, long queryId, String id) throws IOException;

}
