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
import com.github.badoualy.telegram.tl.api.request.*;
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
public abstract class TelegramApiWrapper implements TelegramApi {
    public abstract <T extends TLObject> T executeRpcQuery(TLMethod<T> method) throws IOException;

    @Override
    public TLAbsUser accountChangePhone(String phoneNumber, String phoneCodeHash, String phoneCode) throws IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode));
    }

    @Override
    public TLBool accountCheckUsername(String username) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountCheckUsername(username));
    }

    @Override
    public TLBool accountDeleteAccount(String reason) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountDeleteAccount(reason));
    }

    @Override
    public TLAccountDaysTTL accountGetAccountTTL() throws IOException {
        return (TLAccountDaysTTL) executeRpcQuery(new TLRequestAccountGetAccountTTL());
    }

    @Override
    public TLAuthorizations accountGetAuthorizations() throws IOException {
        return (TLAuthorizations) executeRpcQuery(new TLRequestAccountGetAuthorizations());
    }

    @Override
    public TLAbsPeerNotifySettings accountGetNotifySettings(TLAbsInputNotifyPeer peer) throws IOException {
        return (TLAbsPeerNotifySettings) executeRpcQuery(new TLRequestAccountGetNotifySettings(peer));
    }

    @Override
    public TLAbsPassword accountGetPassword() throws IOException {
        return (TLAbsPassword) executeRpcQuery(new TLRequestAccountGetPassword());
    }

    @Override
    public TLPasswordSettings accountGetPasswordSettings(TLBytes currentPasswordHash) throws IOException {
        return (TLPasswordSettings) executeRpcQuery(new TLRequestAccountGetPasswordSettings(currentPasswordHash));
    }

    @Override
    public TLPrivacyRules accountGetPrivacy(TLInputPrivacyKeyStatusTimestamp key) throws IOException {
        return (TLPrivacyRules) executeRpcQuery(new TLRequestAccountGetPrivacy(key));
    }

    @Override
    public TLVector<TLAbsWallPaper> accountGetWallPapers() throws IOException {
        return (TLVector<TLAbsWallPaper>) executeRpcQuery(new TLRequestAccountGetWallPapers());
    }

    @Override
    public TLBool accountRegisterDevice(int tokenType, String token, String deviceModel, String systemVersion, String appVersion, boolean appSandbox, String langCode) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountRegisterDevice(tokenType, token, deviceModel, systemVersion, appVersion, appSandbox, langCode));
    }

    @Override
    public TLBool accountReportPeer(TLAbsInputPeer peer, TLAbsReportReason reason) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountReportPeer(peer, reason));
    }

    @Override
    public TLBool accountResetAuthorization(long hash) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetAuthorization(hash));
    }

    @Override
    public TLBool accountResetNotifySettings() throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetNotifySettings());
    }

    @Override
    public TLSentChangePhoneCode accountSendChangePhoneCode(String phoneNumber) throws IOException {
        return (TLSentChangePhoneCode) executeRpcQuery(new TLRequestAccountSendChangePhoneCode(phoneNumber));
    }

    @Override
    public TLBool accountSetAccountTTL(TLAccountDaysTTL ttl) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountSetAccountTTL(ttl));
    }

    @Override
    public TLPrivacyRules accountSetPrivacy(TLInputPrivacyKeyStatusTimestamp key, TLVector<? extends TLAbsInputPrivacyRule> rules) throws IOException {
        return (TLPrivacyRules) executeRpcQuery(new TLRequestAccountSetPrivacy(key, rules));
    }

    @Override
    public TLBool accountUnregisterDevice(int tokenType, String token) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUnregisterDevice(tokenType, token));
    }

    @Override
    public TLBool accountUpdateDeviceLocked(int period) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateDeviceLocked(period));
    }

    @Override
    public TLBool accountUpdateNotifySettings(TLAbsInputNotifyPeer peer, TLInputPeerNotifySettings settings) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateNotifySettings(peer, settings));
    }

    @Override
    public TLBool accountUpdatePasswordSettings(TLBytes currentPasswordHash, TLPasswordInputSettings newSettings) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdatePasswordSettings(currentPasswordHash, newSettings));
    }

    @Override
    public TLAbsUser accountUpdateProfile(String firstName, String lastName) throws IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestAccountUpdateProfile(firstName, lastName));
    }

    @Override
    public TLBool accountUpdateStatus(boolean offline) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateStatus(offline));
    }

    @Override
    public TLAbsUser accountUpdateUsername(String username) throws IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestAccountUpdateUsername(username));
    }

    @Override
    public TLBool authBindTempAuthKey(long permAuthKeyId, long nonce, int expiresAt, TLBytes encryptedMessage) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage));
    }

    @Override
    public TLAuthorization authCheckPassword(TLBytes passwordHash) throws IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthCheckPassword(passwordHash));
    }

    @Override
    public TLCheckedPhone authCheckPhone(String phoneNumber) throws IOException {
        return (TLCheckedPhone) executeRpcQuery(new TLRequestAuthCheckPhone(phoneNumber));
    }

    @Override
    public TLExportedAuthorization authExportAuthorization(int dcId) throws IOException {
        return (TLExportedAuthorization) executeRpcQuery(new TLRequestAuthExportAuthorization(dcId));
    }

    @Override
    public TLAuthorization authImportAuthorization(int id, TLBytes bytes) throws IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthImportAuthorization(id, bytes));
    }

    @Override
    public TLAuthorization authImportBotAuthorization(int flags, int apiId, String apiHash, String botAuthToken) throws IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken));
    }

    @Override
    public TLBool authLogOut() throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthLogOut());
    }

    @Override
    public TLAuthorization authRecoverPassword(String code) throws IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthRecoverPassword(code));
    }

    @Override
    public TLPasswordRecovery authRequestPasswordRecovery() throws IOException {
        return (TLPasswordRecovery) executeRpcQuery(new TLRequestAuthRequestPasswordRecovery());
    }

    @Override
    public TLBool authResetAuthorizations() throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthResetAuthorizations());
    }

    @Override
    public TLBool authSendCall(String phoneNumber, String phoneCodeHash) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthSendCall(phoneNumber, phoneCodeHash));
    }

    @Override
    public TLAbsSentCode authSendCode(String phoneNumber, int smsType, int apiId, String apiHash, String langCode) throws IOException {
        return (TLAbsSentCode) executeRpcQuery(new TLRequestAuthSendCode(phoneNumber, smsType, apiId, apiHash, langCode));
    }

    @Override
    public TLBool authSendInvites(TLStringVector phoneNumbers, String message) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthSendInvites(phoneNumbers, message));
    }

    @Override
    public TLBool authSendSms(String phoneNumber, String phoneCodeHash) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthSendSms(phoneNumber, phoneCodeHash));
    }

    @Override
    public TLAuthorization authSignIn(String phoneNumber, String phoneCodeHash, String phoneCode) throws IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode));
    }

    @Override
    public TLAuthorization authSignUp(String phoneNumber, String phoneCodeHash, String phoneCode, String firstName, String lastName) throws IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthSignUp(phoneNumber, phoneCodeHash, phoneCode, firstName, lastName));
    }

    @Override
    public TLBool channelsCheckUsername(TLAbsInputChannel channel, String username) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsCheckUsername(channel, username));
    }

    @Override
    public TLAbsUpdates channelsCreateChannel(boolean broadcast, boolean megagroup, String title, String about) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsCreateChannel(broadcast, megagroup, title, about));
    }

    @Override
    public TLAbsUpdates channelsDeleteChannel(TLAbsInputChannel channel) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsDeleteChannel(channel));
    }

    @Override
    public TLAffectedMessages channelsDeleteMessages(TLAbsInputChannel channel, TLIntVector id) throws IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestChannelsDeleteMessages(channel, id));
    }

    @Override
    public TLAffectedHistory channelsDeleteUserHistory(TLAbsInputChannel channel, TLAbsInputUser userId) throws IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestChannelsDeleteUserHistory(channel, userId));
    }

    @Override
    public TLBool channelsEditAbout(TLAbsInputChannel channel, String about) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsEditAbout(channel, about));
    }

    @Override
    public TLAbsUpdates channelsEditAdmin(TLAbsInputChannel channel, TLAbsInputUser userId, TLAbsChannelParticipantRole role) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditAdmin(channel, userId, role));
    }

    @Override
    public TLAbsUpdates channelsEditPhoto(TLAbsInputChannel channel, TLAbsInputChatPhoto photo) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditPhoto(channel, photo));
    }

    @Override
    public TLAbsUpdates channelsEditTitle(TLAbsInputChannel channel, String title) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditTitle(channel, title));
    }

    @Override
    public TLAbsExportedChatInvite channelsExportInvite(TLAbsInputChannel channel) throws IOException {
        return (TLAbsExportedChatInvite) executeRpcQuery(new TLRequestChannelsExportInvite(channel));
    }

    @Override
    public TLChats channelsGetChannels(TLVector<? extends TLAbsInputChannel> id) throws IOException {
        return (TLChats) executeRpcQuery(new TLRequestChannelsGetChannels(id));
    }

    @Override
    public TLAbsDialogs channelsGetDialogs(int offset, int limit) throws IOException {
        return (TLAbsDialogs) executeRpcQuery(new TLRequestChannelsGetDialogs(offset, limit));
    }

    @Override
    public TLChatFull channelsGetFullChannel(TLAbsInputChannel channel) throws IOException {
        return (TLChatFull) executeRpcQuery(new TLRequestChannelsGetFullChannel(channel));
    }

    @Override
    public TLAbsMessages channelsGetImportantHistory(TLAbsInputChannel channel, int offsetId, int addOffset, int limit, int maxId, int minId) throws IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestChannelsGetImportantHistory(channel, offsetId, addOffset, limit, maxId, minId));
    }

    @Override
    public TLAbsMessages channelsGetMessages(TLAbsInputChannel channel, TLIntVector id) throws IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestChannelsGetMessages(channel, id));
    }

    @Override
    public TLChannelParticipant channelsGetParticipant(TLAbsInputChannel channel, TLAbsInputUser userId) throws IOException {
        return (TLChannelParticipant) executeRpcQuery(new TLRequestChannelsGetParticipant(channel, userId));
    }

    @Override
    public TLChannelParticipants channelsGetParticipants(TLAbsInputChannel channel, TLAbsChannelParticipantsFilter filter, int offset, int limit) throws IOException {
        return (TLChannelParticipants) executeRpcQuery(new TLRequestChannelsGetParticipants(channel, filter, offset, limit));
    }

    @Override
    public TLAbsUpdates channelsInviteToChannel(TLAbsInputChannel channel, TLVector<? extends TLAbsInputUser> users) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsInviteToChannel(channel, users));
    }

    @Override
    public TLAbsUpdates channelsJoinChannel(TLAbsInputChannel channel) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsJoinChannel(channel));
    }

    @Override
    public TLAbsUpdates channelsKickFromChannel(TLAbsInputChannel channel, TLAbsInputUser userId, boolean kicked) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsKickFromChannel(channel, userId, kicked));
    }

    @Override
    public TLAbsUpdates channelsLeaveChannel(TLAbsInputChannel channel) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsLeaveChannel(channel));
    }

    @Override
    public TLBool channelsReadHistory(TLAbsInputChannel channel, int maxId) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsReadHistory(channel, maxId));
    }

    @Override
    public TLBool channelsReportSpam(TLAbsInputChannel channel, TLAbsInputUser userId, TLIntVector id) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsReportSpam(channel, userId, id));
    }

    @Override
    public TLAbsUpdates channelsToggleComments(TLAbsInputChannel channel, boolean enabled) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleComments(channel, enabled));
    }

    @Override
    public TLBool channelsUpdateUsername(TLAbsInputChannel channel, String username) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsUpdateUsername(channel, username));
    }

    @Override
    public TLBool contactsBlock(TLAbsInputUser id) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsBlock(id));
    }

    @Override
    public TLLink contactsDeleteContact(TLAbsInputUser id) throws IOException {
        return (TLLink) executeRpcQuery(new TLRequestContactsDeleteContact(id));
    }

    @Override
    public TLBool contactsDeleteContacts(TLVector<? extends TLAbsInputUser> id) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsDeleteContacts(id));
    }

    @Override
    public TLIntVector contactsExportCard() throws IOException {
        return (TLIntVector) executeRpcQuery(new TLRequestContactsExportCard());
    }

    @Override
    public TLAbsBlocked contactsGetBlocked(int offset, int limit) throws IOException {
        return (TLAbsBlocked) executeRpcQuery(new TLRequestContactsGetBlocked(offset, limit));
    }

    @Override
    public TLAbsContacts contactsGetContacts(String hash) throws IOException {
        return (TLAbsContacts) executeRpcQuery(new TLRequestContactsGetContacts(hash));
    }

    @Override
    public TLVector<TLContactStatus> contactsGetStatuses() throws IOException {
        return (TLVector<TLContactStatus>) executeRpcQuery(new TLRequestContactsGetStatuses());
    }

    @Override
    public TLSuggested contactsGetSuggested(int limit) throws IOException {
        return (TLSuggested) executeRpcQuery(new TLRequestContactsGetSuggested(limit));
    }

    @Override
    public TLAbsUser contactsImportCard(TLIntVector exportCard) throws IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestContactsImportCard(exportCard));
    }

    @Override
    public TLImportedContacts contactsImportContacts(TLVector<? extends TLInputPhoneContact> contacts, boolean replace) throws IOException {
        return (TLImportedContacts) executeRpcQuery(new TLRequestContactsImportContacts(contacts, replace));
    }

    @Override
    public TLResolvedPeer contactsResolveUsername(String username) throws IOException {
        return (TLResolvedPeer) executeRpcQuery(new TLRequestContactsResolveUsername(username));
    }

    @Override
    public TLFound contactsSearch(String q, int limit) throws IOException {
        return (TLFound) executeRpcQuery(new TLRequestContactsSearch(q, limit));
    }

    @Override
    public TLBool contactsUnblock(TLAbsInputUser id) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsUnblock(id));
    }

    @Override
    public TLAbsAppChangelog helpGetAppChangelog(String deviceModel, String systemVersion, String appVersion, String langCode) throws IOException {
        return (TLAbsAppChangelog) executeRpcQuery(new TLRequestHelpGetAppChangelog(deviceModel, systemVersion, appVersion, langCode));
    }

    @Override
    public TLAbsAppUpdate helpGetAppUpdate(String deviceModel, String systemVersion, String appVersion, String langCode) throws IOException {
        return (TLAbsAppUpdate) executeRpcQuery(new TLRequestHelpGetAppUpdate(deviceModel, systemVersion, appVersion, langCode));
    }

    @Override
    public TLConfig helpGetConfig() throws IOException {
        return (TLConfig) executeRpcQuery(new TLRequestHelpGetConfig());
    }

    @Override
    public TLInviteText helpGetInviteText(String langCode) throws IOException {
        return (TLInviteText) executeRpcQuery(new TLRequestHelpGetInviteText(langCode));
    }

    @Override
    public TLNearestDc helpGetNearestDc() throws IOException {
        return (TLNearestDc) executeRpcQuery(new TLRequestHelpGetNearestDc());
    }

    @Override
    public TLSupport helpGetSupport() throws IOException {
        return (TLSupport) executeRpcQuery(new TLRequestHelpGetSupport());
    }

    @Override
    public TLTermsOfService helpGetTermsOfService(String langCode) throws IOException {
        return (TLTermsOfService) executeRpcQuery(new TLRequestHelpGetTermsOfService(langCode));
    }

    @Override
    public TLBool helpSaveAppLog(TLVector<? extends TLInputAppEvent> events) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestHelpSaveAppLog(events));
    }

    @Override
    public <T extends TLObject> T initConnection(int apiId, String deviceModel, String systemVersion, String appVersion, String langCode, TLMethod<T> query) throws IOException {
        return (T) executeRpcQuery(new TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, langCode, query));
    }

    @Override
    public <T extends TLObject> T invokeAfterMsg(long msgId, TLMethod<T> query) throws IOException {
        return (T) executeRpcQuery(new TLRequestInvokeAfterMsg(msgId, query));
    }

    @Override
    public <T extends TLObject> T invokeAfterMsgs(TLLongVector msgIds, TLMethod<T> query) throws IOException {
        return (T) executeRpcQuery(new TLRequestInvokeAfterMsgs(msgIds, query));
    }

    @Override
    public <T extends TLObject> T invokeWithLayer(int layer, TLMethod<T> query) throws IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithLayer(layer, query));
    }

    @Override
    public <T extends TLObject> T invokeWithoutUpdates(TLMethod<T> query) throws IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithoutUpdates(query));
    }

    @Override
    public TLAbsEncryptedChat messagesAcceptEncryption(TLInputEncryptedChat peer, TLBytes gB, long keyFingerprint) throws IOException {
        return (TLAbsEncryptedChat) executeRpcQuery(new TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint));
    }

    @Override
    public TLAbsUpdates messagesAddChatUser(int chatId, TLAbsInputUser userId, int fwdLimit) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesAddChatUser(chatId, userId, fwdLimit));
    }

    @Override
    public TLAbsChatInvite messagesCheckChatInvite(String hash) throws IOException {
        return (TLAbsChatInvite) executeRpcQuery(new TLRequestMessagesCheckChatInvite(hash));
    }

    @Override
    public TLAbsUpdates messagesCreateChat(TLVector<? extends TLAbsInputUser> users, String title) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesCreateChat(users, title));
    }

    @Override
    public TLAbsUpdates messagesDeleteChatUser(int chatId, TLAbsInputUser userId) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesDeleteChatUser(chatId, userId));
    }

    @Override
    public TLAffectedHistory messagesDeleteHistory(TLAbsInputPeer peer, int maxId) throws IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestMessagesDeleteHistory(peer, maxId));
    }

    @Override
    public TLAffectedMessages messagesDeleteMessages(TLIntVector id) throws IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestMessagesDeleteMessages(id));
    }

    @Override
    public TLBool messagesDiscardEncryption(int chatId) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesDiscardEncryption(chatId));
    }

    @Override
    public TLBool messagesEditChatAdmin(int chatId, TLAbsInputUser userId, boolean isAdmin) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin));
    }

    @Override
    public TLAbsUpdates messagesEditChatPhoto(int chatId, TLAbsInputChatPhoto photo) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesEditChatPhoto(chatId, photo));
    }

    @Override
    public TLAbsUpdates messagesEditChatTitle(int chatId, String title) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesEditChatTitle(chatId, title));
    }

    @Override
    public TLAbsExportedChatInvite messagesExportChatInvite(int chatId) throws IOException {
        return (TLAbsExportedChatInvite) executeRpcQuery(new TLRequestMessagesExportChatInvite(chatId));
    }

    @Override
    public TLAbsUpdates messagesForwardMessage(TLAbsInputPeer peer, int id, long randomId) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesForwardMessage(peer, id, randomId));
    }

    @Override
    public TLAbsUpdates messagesForwardMessages(boolean broadcast, TLAbsInputPeer fromPeer, TLIntVector id, TLLongVector randomId, TLAbsInputPeer toPeer) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesForwardMessages(broadcast, fromPeer, id, randomId, toPeer));
    }

    @Override
    public TLAbsAllStickers messagesGetAllStickers(int hash) throws IOException {
        return (TLAbsAllStickers) executeRpcQuery(new TLRequestMessagesGetAllStickers(hash));
    }

    @Override
    public TLChats messagesGetChats(TLIntVector id) throws IOException {
        return (TLChats) executeRpcQuery(new TLRequestMessagesGetChats(id));
    }

    @Override
    public TLAbsDhConfig messagesGetDhConfig(int version, int randomLength) throws IOException {
        return (TLAbsDhConfig) executeRpcQuery(new TLRequestMessagesGetDhConfig(version, randomLength));
    }

    @Override
    public TLAbsDialogs messagesGetDialogs(int offsetDate, int offsetId, TLAbsInputPeer offsetPeer, int limit) throws IOException {
        return (TLAbsDialogs) executeRpcQuery(new TLRequestMessagesGetDialogs(offsetDate, offsetId, offsetPeer, limit));
    }

    @Override
    public TLAbsDocument messagesGetDocumentByHash(TLBytes sha256, int size, String mimeType) throws IOException {
        return (TLAbsDocument) executeRpcQuery(new TLRequestMessagesGetDocumentByHash(sha256, size, mimeType));
    }

    @Override
    public TLChatFull messagesGetFullChat(int chatId) throws IOException {
        return (TLChatFull) executeRpcQuery(new TLRequestMessagesGetFullChat(chatId));
    }

    @Override
    public TLAbsMessages messagesGetHistory(TLAbsInputPeer peer, int offsetId, int addOffset, int limit, int maxId, int minId) throws IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetHistory(peer, offsetId, addOffset, limit, maxId, minId));
    }

    @Override
    public TLBotResults messagesGetInlineBotResults(TLAbsInputUser bot, String query, String offset) throws IOException {
        return (TLBotResults) executeRpcQuery(new TLRequestMessagesGetInlineBotResults(bot, query, offset));
    }

    @Override
    public TLAbsMessages messagesGetMessages(TLIntVector id) throws IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetMessages(id));
    }

    @Override
    public TLIntVector messagesGetMessagesViews(TLAbsInputPeer peer, TLIntVector id, boolean increment) throws IOException {
        return (TLIntVector) executeRpcQuery(new TLRequestMessagesGetMessagesViews(peer, id, increment));
    }

    @Override
    public TLAbsSavedGifs messagesGetSavedGifs(int hash) throws IOException {
        return (TLAbsSavedGifs) executeRpcQuery(new TLRequestMessagesGetSavedGifs(hash));
    }

    @Override
    public TLStickerSet messagesGetStickerSet(TLAbsInputStickerSet stickerset) throws IOException {
        return (TLStickerSet) executeRpcQuery(new TLRequestMessagesGetStickerSet(stickerset));
    }

    @Override
    public TLAbsStickers messagesGetStickers(String emoticon, String hash) throws IOException {
        return (TLAbsStickers) executeRpcQuery(new TLRequestMessagesGetStickers(emoticon, hash));
    }

    @Override
    public TLAbsMessageMedia messagesGetWebPagePreview(String message) throws IOException {
        return (TLAbsMessageMedia) executeRpcQuery(new TLRequestMessagesGetWebPagePreview(message));
    }

    @Override
    public TLAbsUpdates messagesImportChatInvite(String hash) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesImportChatInvite(hash));
    }

    @Override
    public TLBool messagesInstallStickerSet(TLAbsInputStickerSet stickerset, boolean disabled) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesInstallStickerSet(stickerset, disabled));
    }

    @Override
    public TLAbsUpdates messagesMigrateChat(int chatId) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesMigrateChat(chatId));
    }

    @Override
    public TLBool messagesReadEncryptedHistory(TLInputEncryptedChat peer, int maxDate) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReadEncryptedHistory(peer, maxDate));
    }

    @Override
    public TLAffectedMessages messagesReadHistory(TLAbsInputPeer peer, int maxId) throws IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestMessagesReadHistory(peer, maxId));
    }

    @Override
    public TLAffectedMessages messagesReadMessageContents(TLIntVector id) throws IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestMessagesReadMessageContents(id));
    }

    @Override
    public TLVector<TLReceivedNotifyMessage> messagesReceivedMessages(int maxId) throws IOException {
        return (TLVector<TLReceivedNotifyMessage>) executeRpcQuery(new TLRequestMessagesReceivedMessages(maxId));
    }

    @Override
    public TLLongVector messagesReceivedQueue(int maxQts) throws IOException {
        return (TLLongVector) executeRpcQuery(new TLRequestMessagesReceivedQueue(maxQts));
    }

    @Override
    public TLBool messagesReorderStickerSets(TLLongVector order) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReorderStickerSets(order));
    }

    @Override
    public TLBool messagesReportSpam(TLAbsInputPeer peer) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReportSpam(peer));
    }

    @Override
    public TLAbsEncryptedChat messagesRequestEncryption(TLAbsInputUser userId, int randomId, TLBytes gA) throws IOException {
        return (TLAbsEncryptedChat) executeRpcQuery(new TLRequestMessagesRequestEncryption(userId, randomId, gA));
    }

    @Override
    public TLBool messagesSaveGif(TLAbsInputDocument id, boolean unsave) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSaveGif(id, unsave));
    }

    @Override
    public TLAbsMessages messagesSearch(boolean importantOnly, TLAbsInputPeer peer, String q, TLAbsMessagesFilter filter, int minDate, int maxDate, int offset, int maxId, int limit) throws IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesSearch(importantOnly, peer, q, filter, minDate, maxDate, offset, maxId, limit));
    }

    @Override
    public TLFoundGifs messagesSearchGifs(String q, int offset) throws IOException {
        return (TLFoundGifs) executeRpcQuery(new TLRequestMessagesSearchGifs(q, offset));
    }

    @Override
    public TLAbsMessages messagesSearchGlobal(String q, int offsetDate, TLAbsInputPeer offsetPeer, int offsetId, int limit) throws IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesSearchGlobal(q, offsetDate, offsetPeer, offsetId, limit));
    }

    @Override
    public TLAbsUpdates messagesSendBroadcast(TLVector<? extends TLAbsInputUser> contacts, TLLongVector randomId, String message, TLAbsInputMedia media) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendBroadcast(contacts, randomId, message, media));
    }

    @Override
    public TLAbsSentEncryptedMessage messagesSendEncrypted(TLInputEncryptedChat peer, long randomId, TLBytes data) throws IOException {
        return (TLAbsSentEncryptedMessage) executeRpcQuery(new TLRequestMessagesSendEncrypted(peer, randomId, data));
    }

    @Override
    public TLAbsSentEncryptedMessage messagesSendEncryptedFile(TLInputEncryptedChat peer, long randomId, TLBytes data, TLAbsInputEncryptedFile file) throws IOException {
        return (TLAbsSentEncryptedMessage) executeRpcQuery(new TLRequestMessagesSendEncryptedFile(peer, randomId, data, file));
    }

    @Override
    public TLAbsSentEncryptedMessage messagesSendEncryptedService(TLInputEncryptedChat peer, long randomId, TLBytes data) throws IOException {
        return (TLAbsSentEncryptedMessage) executeRpcQuery(new TLRequestMessagesSendEncryptedService(peer, randomId, data));
    }

    @Override
    public TLAbsUpdates messagesSendInlineBotResult(boolean broadcast, TLAbsInputPeer peer, Integer replyToMsgId, long randomId, long queryId, String id) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendInlineBotResult(broadcast, peer, replyToMsgId, randomId, queryId, id));
    }

    @Override
    public TLAbsUpdates messagesSendMedia(boolean broadcast, TLAbsInputPeer peer, Integer replyToMsgId, TLAbsInputMedia media, long randomId, TLAbsReplyMarkup replyMarkup) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendMedia(broadcast, peer, replyToMsgId, media, randomId, replyMarkup));
    }

    @Override
    public TLAbsUpdates messagesSendMessage(boolean noWebpage, boolean broadcast, TLAbsInputPeer peer, Integer replyToMsgId, String message, long randomId, TLAbsReplyMarkup replyMarkup, TLVector<? extends TLAbsMessageEntity> entities) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesSendMessage(noWebpage, broadcast, peer, replyToMsgId, message, randomId, replyMarkup, entities));
    }

    @Override
    public TLBool messagesSetEncryptedTyping(TLInputEncryptedChat peer, boolean typing) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetEncryptedTyping(peer, typing));
    }

    @Override
    public TLBool messagesSetInlineBotResults(boolean gallery, boolean _private, long queryId, TLVector<? extends TLInputBotInlineResult> results, int cacheTime, String nextOffset) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetInlineBotResults(gallery, _private, queryId, results, cacheTime, nextOffset));
    }

    @Override
    public TLBool messagesSetTyping(TLAbsInputPeer peer, TLAbsSendMessageAction action) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetTyping(peer, action));
    }

    @Override
    public TLAbsUpdates messagesStartBot(TLAbsInputUser bot, TLAbsInputPeer peer, long randomId, String startParam) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesStartBot(bot, peer, randomId, startParam));
    }

    @Override
    public TLAbsUpdates messagesToggleChatAdmins(int chatId, boolean enabled) throws IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesToggleChatAdmins(chatId, enabled));
    }

    @Override
    public TLBool messagesUninstallStickerSet(TLAbsInputStickerSet stickerset) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesUninstallStickerSet(stickerset));
    }

    @Override
    public TLLongVector photosDeletePhotos(TLVector<? extends TLAbsInputPhoto> id) throws IOException {
        return (TLLongVector) executeRpcQuery(new TLRequestPhotosDeletePhotos(id));
    }

    @Override
    public TLAbsPhotos photosGetUserPhotos(TLAbsInputUser userId, int offset, long maxId, int limit) throws IOException {
        return (TLAbsPhotos) executeRpcQuery(new TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit));
    }

    @Override
    public TLAbsUserProfilePhoto photosUpdateProfilePhoto(TLAbsInputPhoto id, TLAbsInputPhotoCrop crop) throws IOException {
        return (TLAbsUserProfilePhoto) executeRpcQuery(new TLRequestPhotosUpdateProfilePhoto(id, crop));
    }

    @Override
    public TLPhoto photosUploadProfilePhoto(TLAbsInputFile file, String caption, TLAbsInputGeoPoint geoPoint, TLAbsInputPhotoCrop crop) throws IOException {
        return (TLPhoto) executeRpcQuery(new TLRequestPhotosUploadProfilePhoto(file, caption, geoPoint, crop));
    }

    @Override
    public TLAbsChannelDifference updatesGetChannelDifference(TLAbsInputChannel channel, TLAbsChannelMessagesFilter filter, int pts, int limit) throws IOException {
        return (TLAbsChannelDifference) executeRpcQuery(new TLRequestUpdatesGetChannelDifference(channel, filter, pts, limit));
    }

    @Override
    public TLAbsDifference updatesGetDifference(int pts, int date, int qts) throws IOException {
        return (TLAbsDifference) executeRpcQuery(new TLRequestUpdatesGetDifference(pts, date, qts));
    }

    @Override
    public TLState updatesGetState() throws IOException {
        return (TLState) executeRpcQuery(new TLRequestUpdatesGetState());
    }

    @Override
    public TLFile uploadGetFile(TLAbsInputFileLocation location, int offset, int limit) throws IOException {
        return (TLFile) executeRpcQuery(new TLRequestUploadGetFile(location, offset, limit));
    }

    @Override
    public TLBool uploadSaveBigFilePart(long fileId, int filePart, int fileTotalParts, TLBytes bytes) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes));
    }

    @Override
    public TLBool uploadSaveFilePart(long fileId, int filePart, TLBytes bytes) throws IOException {
        return (TLBool) executeRpcQuery(new TLRequestUploadSaveFilePart(fileId, filePart, bytes));
    }

    @Override
    public TLUserFull usersGetFullUser(TLAbsInputUser id) throws IOException {
        return (TLUserFull) executeRpcQuery(new TLRequestUsersGetFullUser(id));
    }

    @Override
    public TLVector<TLAbsUser> usersGetUsers(TLVector<? extends TLAbsInputUser> id) throws IOException {
        return (TLVector<TLAbsUser>) executeRpcQuery(new TLRequestUsersGetUsers(id));
    }
}
