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
import com.github.badoualy.telegram.tl.api.request.*;
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
public abstract class TelegramApiWrapper implements TelegramApi {

    public abstract <T extends TLObject> T executeRpcQuery(TLMethod<T> method) throws RpcErrorException, IOException;

    @Override
    public TLAbsUser accountChangePhone(String phoneNumber, String phoneCodeHash, String phoneCode) throws RpcErrorException, IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode));
    }

    @Override
    public TLBool accountCheckUsername(String username) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountCheckUsername(username));
    }

    @Override
    public TLBool accountConfirmPhone(String phoneCodeHash, String phoneCode) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountConfirmPhone(phoneCodeHash, phoneCode));
    }

    @Override
    public TLBool accountDeleteAccount(String reason) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountDeleteAccount(reason));
    }

    @Override
    public TLAccountDaysTTL accountGetAccountTTL() throws RpcErrorException, IOException {
        return (TLAccountDaysTTL) executeRpcQuery(new TLRequestAccountGetAccountTTL());
    }

    @Override
    public TLAuthorizations accountGetAuthorizations() throws RpcErrorException, IOException {
        return (TLAuthorizations) executeRpcQuery(new TLRequestAccountGetAuthorizations());
    }

    @Override
    public TLAbsPeerNotifySettings accountGetNotifySettings(TLAbsInputNotifyPeer peer) throws RpcErrorException, IOException {
        return (TLAbsPeerNotifySettings) executeRpcQuery(new TLRequestAccountGetNotifySettings(peer));
    }

    @Override
    public TLAbsPassword accountGetPassword() throws RpcErrorException, IOException {
        return (TLAbsPassword) executeRpcQuery(new TLRequestAccountGetPassword());
    }

    @Override
    public TLPasswordSettings accountGetPasswordSettings(TLBytes currentPasswordHash) throws RpcErrorException, IOException {
        return (TLPasswordSettings) executeRpcQuery(new TLRequestAccountGetPasswordSettings(currentPasswordHash));
    }

    @Override
    public TLPrivacyRules accountGetPrivacy(TLAbsInputPrivacyKey key) throws RpcErrorException, IOException {
        return (TLPrivacyRules) executeRpcQuery(new TLRequestAccountGetPrivacy(key));
    }

    @Override
    public TLTmpPassword accountGetTmpPassword(TLBytes passwordHash, int period) throws RpcErrorException, IOException {
        return (TLTmpPassword) executeRpcQuery(new TLRequestAccountGetTmpPassword(passwordHash, period));
    }

    @Override
    public TLVector<TLAbsWallPaper> accountGetWallPapers() throws RpcErrorException, IOException {
        return (TLVector<TLAbsWallPaper>) executeRpcQuery(new TLRequestAccountGetWallPapers());
    }

    @Override
    public TLBool accountRegisterDevice(int tokenType, String token) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountRegisterDevice(tokenType, token));
    }

    @Override
    public TLBool accountReportPeer(TLAbsInputPeer peer, TLAbsReportReason reason) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountReportPeer(peer, reason));
    }

    @Override
    public TLBool accountResetAuthorization(long hash) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetAuthorization(hash));
    }

    @Override
    public TLBool accountResetNotifySettings() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountResetNotifySettings());
    }

    @Override
    public TLSentCode accountSendChangePhoneCode(boolean allowFlashcall, String phoneNumber, boolean currentNumber) throws RpcErrorException, IOException {
        return (TLSentCode) executeRpcQuery(
                new TLRequestAccountSendChangePhoneCode(allowFlashcall, phoneNumber, currentNumber));
    }

    @Override
    public TLSentCode accountSendConfirmPhoneCode(boolean allowFlashcall, String hash, boolean currentNumber) throws RpcErrorException, IOException {
        return (TLSentCode) executeRpcQuery(
                new TLRequestAccountSendConfirmPhoneCode(allowFlashcall, hash, currentNumber));
    }

    @Override
    public TLBool accountSetAccountTTL(TLAccountDaysTTL ttl) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountSetAccountTTL(ttl));
    }

    @Override
    public TLPrivacyRules accountSetPrivacy(TLAbsInputPrivacyKey key, TLVector<TLAbsInputPrivacyRule> rules) throws RpcErrorException, IOException {
        return (TLPrivacyRules) executeRpcQuery(new TLRequestAccountSetPrivacy(key, rules));
    }

    @Override
    public TLBool accountUnregisterDevice(int tokenType, String token) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUnregisterDevice(tokenType, token));
    }

    @Override
    public TLBool accountUpdateDeviceLocked(int period) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateDeviceLocked(period));
    }

    @Override
    public TLBool accountUpdateNotifySettings(TLAbsInputNotifyPeer peer, TLInputPeerNotifySettings settings) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateNotifySettings(peer, settings));
    }

    @Override
    public TLBool accountUpdatePasswordSettings(TLBytes currentPasswordHash, TLPasswordInputSettings newSettings) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdatePasswordSettings(currentPasswordHash, newSettings));
    }

    @Override
    public TLAbsUser accountUpdateProfile(String firstName, String lastName, String about) throws RpcErrorException, IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestAccountUpdateProfile(firstName, lastName, about));
    }

    @Override
    public TLBool accountUpdateStatus(boolean offline) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAccountUpdateStatus(offline));
    }

    @Override
    public TLAbsUser accountUpdateUsername(String username) throws RpcErrorException, IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestAccountUpdateUsername(username));
    }

    @Override
    public TLBool authBindTempAuthKey(long permAuthKeyId, long nonce, int expiresAt, TLBytes encryptedMessage) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(
                new TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage));
    }

    @Override
    public TLBool authCancelCode(String phoneNumber, String phoneCodeHash) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthCancelCode(phoneNumber, phoneCodeHash));
    }

    @Override
    public TLAuthorization authCheckPassword(TLBytes passwordHash) throws RpcErrorException, IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthCheckPassword(passwordHash));
    }

    @Override
    public TLCheckedPhone authCheckPhone(String phoneNumber) throws RpcErrorException, IOException {
        return (TLCheckedPhone) executeRpcQuery(new TLRequestAuthCheckPhone(phoneNumber));
    }

    @Override
    public TLBool authDropTempAuthKeys(TLLongVector exceptAuthKeys) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthDropTempAuthKeys(exceptAuthKeys));
    }

    @Override
    public TLExportedAuthorization authExportAuthorization(int dcId) throws RpcErrorException, IOException {
        return (TLExportedAuthorization) executeRpcQuery(new TLRequestAuthExportAuthorization(dcId));
    }

    @Override
    public TLAuthorization authImportAuthorization(int id, TLBytes bytes) throws RpcErrorException, IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthImportAuthorization(id, bytes));
    }

    @Override
    public TLAuthorization authImportBotAuthorization(int flags, int apiId, String apiHash, String botAuthToken) throws RpcErrorException, IOException {
        return (TLAuthorization) executeRpcQuery(
                new TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken));
    }

    @Override
    public TLBool authLogOut() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthLogOut());
    }

    @Override
    public TLAuthorization authRecoverPassword(String code) throws RpcErrorException, IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthRecoverPassword(code));
    }

    @Override
    public TLPasswordRecovery authRequestPasswordRecovery() throws RpcErrorException, IOException {
        return (TLPasswordRecovery) executeRpcQuery(new TLRequestAuthRequestPasswordRecovery());
    }

    @Override
    public TLSentCode authResendCode(String phoneNumber, String phoneCodeHash) throws RpcErrorException, IOException {
        return (TLSentCode) executeRpcQuery(new TLRequestAuthResendCode(phoneNumber, phoneCodeHash));
    }

    @Override
    public TLBool authResetAuthorizations() throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthResetAuthorizations());
    }

    @Override
    public TLSentCode authSendCode(boolean allowFlashcall, String phoneNumber, boolean currentNumber, int apiId, String apiHash) throws RpcErrorException, IOException {
        return (TLSentCode) executeRpcQuery(
                new TLRequestAuthSendCode(allowFlashcall, phoneNumber, currentNumber, apiId, apiHash));
    }

    @Override
    public TLBool authSendInvites(TLStringVector phoneNumbers, String message) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestAuthSendInvites(phoneNumbers, message));
    }

    @Override
    public TLAuthorization authSignIn(String phoneNumber, String phoneCodeHash, String phoneCode) throws RpcErrorException, IOException {
        return (TLAuthorization) executeRpcQuery(new TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode));
    }

    @Override
    public TLAuthorization authSignUp(String phoneNumber, String phoneCodeHash, String phoneCode, String firstName, String lastName) throws RpcErrorException, IOException {
        return (TLAuthorization) executeRpcQuery(
                new TLRequestAuthSignUp(phoneNumber, phoneCodeHash, phoneCode, firstName, lastName));
    }

    @Override
    public TLBool botsAnswerWebhookJSONQuery(long queryId, TLDataJSON data) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestBotsAnswerWebhookJSONQuery(queryId, data));
    }

    @Override
    public TLDataJSON botsSendCustomRequest(String customMethod, TLDataJSON params) throws RpcErrorException, IOException {
        return (TLDataJSON) executeRpcQuery(new TLRequestBotsSendCustomRequest(customMethod, params));
    }

    @Override
    public TLBool channelsCheckUsername(TLAbsInputChannel channel, String username) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsCheckUsername(channel, username));
    }

    @Override
    public TLAbsUpdates channelsCreateChannel(boolean broadcast, boolean megagroup, String title, String about) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsCreateChannel(broadcast, megagroup, title, about));
    }

    @Override
    public TLAbsUpdates channelsDeleteChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsDeleteChannel(channel));
    }

    @Override
    public TLAffectedMessages channelsDeleteMessages(TLAbsInputChannel channel, TLIntVector id) throws RpcErrorException, IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestChannelsDeleteMessages(channel, id));
    }

    @Override
    public TLAffectedHistory channelsDeleteUserHistory(TLAbsInputChannel channel, TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestChannelsDeleteUserHistory(channel, userId));
    }

    @Override
    public TLBool channelsEditAbout(TLAbsInputChannel channel, String about) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsEditAbout(channel, about));
    }

    @Override
    public TLAbsUpdates channelsEditAdmin(TLAbsInputChannel channel, TLAbsInputUser userId, TLAbsChannelParticipantRole role) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditAdmin(channel, userId, role));
    }

    @Override
    public TLAbsUpdates channelsEditPhoto(TLAbsInputChannel channel, TLAbsInputChatPhoto photo) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditPhoto(channel, photo));
    }

    @Override
    public TLAbsUpdates channelsEditTitle(TLAbsInputChannel channel, String title) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsEditTitle(channel, title));
    }

    @Override
    public TLAbsExportedChatInvite channelsExportInvite(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLAbsExportedChatInvite) executeRpcQuery(new TLRequestChannelsExportInvite(channel));
    }

    @Override
    public TLExportedMessageLink channelsExportMessageLink(TLAbsInputChannel channel, int id) throws RpcErrorException, IOException {
        return (TLExportedMessageLink) executeRpcQuery(new TLRequestChannelsExportMessageLink(channel, id));
    }

    @Override
    public TLAbsChats channelsGetAdminedPublicChannels() throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestChannelsGetAdminedPublicChannels());
    }

    @Override
    public TLAbsChats channelsGetChannels(TLVector<TLAbsInputChannel> id) throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestChannelsGetChannels(id));
    }

    @Override
    public TLChatFull channelsGetFullChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLChatFull) executeRpcQuery(new TLRequestChannelsGetFullChannel(channel));
    }

    @Override
    public TLAbsMessages channelsGetMessages(TLAbsInputChannel channel, TLIntVector id) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestChannelsGetMessages(channel, id));
    }

    @Override
    public TLChannelParticipant channelsGetParticipant(TLAbsInputChannel channel, TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLChannelParticipant) executeRpcQuery(new TLRequestChannelsGetParticipant(channel, userId));
    }

    @Override
    public TLChannelParticipants channelsGetParticipants(TLAbsInputChannel channel, TLAbsChannelParticipantsFilter filter, int offset, int limit) throws RpcErrorException, IOException {
        return (TLChannelParticipants) executeRpcQuery(
                new TLRequestChannelsGetParticipants(channel, filter, offset, limit));
    }

    @Override
    public TLAbsUpdates channelsInviteToChannel(TLAbsInputChannel channel, TLVector<TLAbsInputUser> users) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsInviteToChannel(channel, users));
    }

    @Override
    public TLAbsUpdates channelsJoinChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsJoinChannel(channel));
    }

    @Override
    public TLAbsUpdates channelsKickFromChannel(TLAbsInputChannel channel, TLAbsInputUser userId, boolean kicked) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsKickFromChannel(channel, userId, kicked));
    }

    @Override
    public TLAbsUpdates channelsLeaveChannel(TLAbsInputChannel channel) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsLeaveChannel(channel));
    }

    @Override
    public TLBool channelsReadHistory(TLAbsInputChannel channel, int maxId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsReadHistory(channel, maxId));
    }

    @Override
    public TLBool channelsReportSpam(TLAbsInputChannel channel, TLAbsInputUser userId, TLIntVector id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsReportSpam(channel, userId, id));
    }

    @Override
    public TLAbsUpdates channelsToggleInvites(TLAbsInputChannel channel, boolean enabled) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleInvites(channel, enabled));
    }

    @Override
    public TLAbsUpdates channelsToggleSignatures(TLAbsInputChannel channel, boolean enabled) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsToggleSignatures(channel, enabled));
    }

    @Override
    public TLAbsUpdates channelsUpdatePinnedMessage(boolean silent, TLAbsInputChannel channel, int id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestChannelsUpdatePinnedMessage(silent, channel, id));
    }

    @Override
    public TLBool channelsUpdateUsername(TLAbsInputChannel channel, String username) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestChannelsUpdateUsername(channel, username));
    }

    @Override
    public TLBool contactsBlock(TLAbsInputUser id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsBlock(id));
    }

    @Override
    public TLLink contactsDeleteContact(TLAbsInputUser id) throws RpcErrorException, IOException {
        return (TLLink) executeRpcQuery(new TLRequestContactsDeleteContact(id));
    }

    @Override
    public TLBool contactsDeleteContacts(TLVector<TLAbsInputUser> id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsDeleteContacts(id));
    }

    @Override
    public TLIntVector contactsExportCard() throws RpcErrorException, IOException {
        return (TLIntVector) executeRpcQuery(new TLRequestContactsExportCard());
    }

    @Override
    public TLAbsBlocked contactsGetBlocked(int offset, int limit) throws RpcErrorException, IOException {
        return (TLAbsBlocked) executeRpcQuery(new TLRequestContactsGetBlocked(offset, limit));
    }

    @Override
    public TLAbsContacts contactsGetContacts(String hash) throws RpcErrorException, IOException {
        return (TLAbsContacts) executeRpcQuery(new TLRequestContactsGetContacts(hash));
    }

    @Override
    public TLVector<TLContactStatus> contactsGetStatuses() throws RpcErrorException, IOException {
        return (TLVector<TLContactStatus>) executeRpcQuery(new TLRequestContactsGetStatuses());
    }

    @Override
    public TLAbsTopPeers contactsGetTopPeers(boolean correspondents, boolean botsPm, boolean botsInline, boolean groups, boolean channels, int offset, int limit, int hash) throws RpcErrorException, IOException {
        return (TLAbsTopPeers) executeRpcQuery(
                new TLRequestContactsGetTopPeers(correspondents, botsPm, botsInline, groups, channels, offset, limit,
                                                 hash));
    }

    @Override
    public TLAbsUser contactsImportCard(TLIntVector exportCard) throws RpcErrorException, IOException {
        return (TLAbsUser) executeRpcQuery(new TLRequestContactsImportCard(exportCard));
    }

    @Override
    public TLImportedContacts contactsImportContacts(TLVector<TLInputPhoneContact> contacts, boolean replace) throws RpcErrorException, IOException {
        return (TLImportedContacts) executeRpcQuery(new TLRequestContactsImportContacts(contacts, replace));
    }

    @Override
    public TLBool contactsResetTopPeerRating(TLAbsTopPeerCategory category, TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsResetTopPeerRating(category, peer));
    }

    @Override
    public TLResolvedPeer contactsResolveUsername(String username) throws RpcErrorException, IOException {
        return (TLResolvedPeer) executeRpcQuery(new TLRequestContactsResolveUsername(username));
    }

    @Override
    public TLFound contactsSearch(String q, int limit) throws RpcErrorException, IOException {
        return (TLFound) executeRpcQuery(new TLRequestContactsSearch(q, limit));
    }

    @Override
    public TLBool contactsUnblock(TLAbsInputUser id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContactsUnblock(id));
    }

    @Override
    public TLBool contestSaveDeveloperInfo(int vkId, String name, String phoneNumber, int age, String city) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestContestSaveDeveloperInfo(vkId, name, phoneNumber, age, city));
    }

    @Override
    public TLAbsUpdates helpGetAppChangelog(String prevAppVersion) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestHelpGetAppChangelog(prevAppVersion));
    }

    @Override
    public TLAbsAppUpdate helpGetAppUpdate() throws RpcErrorException, IOException {
        return (TLAbsAppUpdate) executeRpcQuery(new TLRequestHelpGetAppUpdate());
    }

    @Override
    public TLCdnConfig helpGetCdnConfig() throws RpcErrorException, IOException {
        return (TLCdnConfig) executeRpcQuery(new TLRequestHelpGetCdnConfig());
    }

    @Override
    public TLConfig helpGetConfig() throws RpcErrorException, IOException {
        return (TLConfig) executeRpcQuery(new TLRequestHelpGetConfig());
    }

    @Override
    public TLInviteText helpGetInviteText() throws RpcErrorException, IOException {
        return (TLInviteText) executeRpcQuery(new TLRequestHelpGetInviteText());
    }

    @Override
    public TLNearestDc helpGetNearestDc() throws RpcErrorException, IOException {
        return (TLNearestDc) executeRpcQuery(new TLRequestHelpGetNearestDc());
    }

    @Override
    public TLSupport helpGetSupport() throws RpcErrorException, IOException {
        return (TLSupport) executeRpcQuery(new TLRequestHelpGetSupport());
    }

    @Override
    public TLTermsOfService helpGetTermsOfService() throws RpcErrorException, IOException {
        return (TLTermsOfService) executeRpcQuery(new TLRequestHelpGetTermsOfService());
    }

    @Override
    public TLBool helpSaveAppLog(TLVector<TLInputAppEvent> events) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestHelpSaveAppLog(events));
    }

    @Override
    public TLBool helpSetBotUpdatesStatus(int pendingUpdatesCount, String message) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestHelpSetBotUpdatesStatus(pendingUpdatesCount, message));
    }

    @Override
    public <T extends TLObject> T initConnection(int apiId, String deviceModel, String systemVersion, String appVersion, String langCode, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(
                new TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, langCode, query));
    }

    @Override
    public <T extends TLObject> T invokeAfterMsg(long msgId, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeAfterMsg(msgId, query));
    }

    @Override
    public <T extends TLObject> T invokeAfterMsgs(TLLongVector msgIds, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeAfterMsgs(msgIds, query));
    }

    @Override
    public <T extends TLObject> T invokeWithLayer(int layer, TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithLayer(layer, query));
    }

    @Override
    public <T extends TLObject> T invokeWithoutUpdates(TLMethod<T> query) throws RpcErrorException, IOException {
        return (T) executeRpcQuery(new TLRequestInvokeWithoutUpdates(query));
    }

    @Override
    public TLAbsEncryptedChat messagesAcceptEncryption(TLInputEncryptedChat peer, TLBytes gB, long keyFingerprint) throws RpcErrorException, IOException {
        return (TLAbsEncryptedChat) executeRpcQuery(new TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint));
    }

    @Override
    public TLAbsUpdates messagesAddChatUser(int chatId, TLAbsInputUser userId, int fwdLimit) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesAddChatUser(chatId, userId, fwdLimit));
    }

    @Override
    public TLAbsChatInvite messagesCheckChatInvite(String hash) throws RpcErrorException, IOException {
        return (TLAbsChatInvite) executeRpcQuery(new TLRequestMessagesCheckChatInvite(hash));
    }

    @Override
    public TLBool messagesClearRecentStickers(boolean attached) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesClearRecentStickers(attached));
    }

    @Override
    public TLAbsUpdates messagesCreateChat(TLVector<TLAbsInputUser> users, String title) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesCreateChat(users, title));
    }

    @Override
    public TLAbsUpdates messagesDeleteChatUser(int chatId, TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesDeleteChatUser(chatId, userId));
    }

    @Override
    public TLAffectedHistory messagesDeleteHistory(boolean justClear, TLAbsInputPeer peer, int maxId) throws RpcErrorException, IOException {
        return (TLAffectedHistory) executeRpcQuery(new TLRequestMessagesDeleteHistory(justClear, peer, maxId));
    }

    @Override
    public TLAffectedMessages messagesDeleteMessages(boolean revoke, TLIntVector id) throws RpcErrorException, IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestMessagesDeleteMessages(revoke, id));
    }

    @Override
    public TLBool messagesDiscardEncryption(int chatId) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesDiscardEncryption(chatId));
    }

    @Override
    public TLBool messagesEditChatAdmin(int chatId, TLAbsInputUser userId, boolean isAdmin) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin));
    }

    @Override
    public TLAbsUpdates messagesEditChatPhoto(int chatId, TLAbsInputChatPhoto photo) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesEditChatPhoto(chatId, photo));
    }

    @Override
    public TLAbsUpdates messagesEditChatTitle(int chatId, String title) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesEditChatTitle(chatId, title));
    }

    @Override
    public TLBool messagesEditInlineBotMessage(boolean noWebpage, TLInputBotInlineMessageID id, String message, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(
                new TLRequestMessagesEditInlineBotMessage(noWebpage, id, message, replyMarkup, entities));
    }

    @Override
    public TLAbsUpdates messagesEditMessage(boolean noWebpage, TLAbsInputPeer peer, int id, String message, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(
                new TLRequestMessagesEditMessage(noWebpage, peer, id, message, replyMarkup, entities));
    }

    @Override
    public TLAbsExportedChatInvite messagesExportChatInvite(int chatId) throws RpcErrorException, IOException {
        return (TLAbsExportedChatInvite) executeRpcQuery(new TLRequestMessagesExportChatInvite(chatId));
    }

    @Override
    public TLAbsUpdates messagesForwardMessage(TLAbsInputPeer peer, int id, long randomId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesForwardMessage(peer, id, randomId));
    }

    @Override
    public TLAbsUpdates messagesForwardMessages(boolean silent, boolean background, boolean withMyScore, TLAbsInputPeer fromPeer, TLIntVector id, TLLongVector randomId, TLAbsInputPeer toPeer) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(
                new TLRequestMessagesForwardMessages(silent, background, withMyScore, fromPeer, id, randomId, toPeer));
    }

    @Override
    public TLAbsChats messagesGetAllChats(TLIntVector exceptIds) throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestMessagesGetAllChats(exceptIds));
    }

    @Override
    public TLAbsUpdates messagesGetAllDrafts() throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesGetAllDrafts());
    }

    @Override
    public TLAbsAllStickers messagesGetAllStickers(int hash) throws RpcErrorException, IOException {
        return (TLAbsAllStickers) executeRpcQuery(new TLRequestMessagesGetAllStickers(hash));
    }

    @Override
    public TLArchivedStickers messagesGetArchivedStickers(boolean masks, long offsetId, int limit) throws RpcErrorException, IOException {
        return (TLArchivedStickers) executeRpcQuery(new TLRequestMessagesGetArchivedStickers(masks, offsetId, limit));
    }

    @Override
    public TLVector<TLAbsStickerSetCovered> messagesGetAttachedStickers(TLAbsInputStickeredMedia media) throws RpcErrorException, IOException {
        return (TLVector<TLAbsStickerSetCovered>) executeRpcQuery(new TLRequestMessagesGetAttachedStickers(media));
    }

    @Override
    public TLBotCallbackAnswer messagesGetBotCallbackAnswer(boolean game, TLAbsInputPeer peer, int msgId, TLBytes data) throws RpcErrorException, IOException {
        return (TLBotCallbackAnswer) executeRpcQuery(
                new TLRequestMessagesGetBotCallbackAnswer(game, peer, msgId, data));
    }

    @Override
    public TLAbsChats messagesGetChats(TLIntVector id) throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestMessagesGetChats(id));
    }

    @Override
    public TLAbsChats messagesGetCommonChats(TLAbsInputUser userId, int maxId, int limit) throws RpcErrorException, IOException {
        return (TLAbsChats) executeRpcQuery(new TLRequestMessagesGetCommonChats(userId, maxId, limit));
    }

    @Override
    public TLAbsDhConfig messagesGetDhConfig(int version, int randomLength) throws RpcErrorException, IOException {
        return (TLAbsDhConfig) executeRpcQuery(new TLRequestMessagesGetDhConfig(version, randomLength));
    }

    @Override
    public TLAbsDialogs messagesGetDialogs(boolean excludePinned, int offsetDate, int offsetId, TLAbsInputPeer offsetPeer, int limit) throws RpcErrorException, IOException {
        return (TLAbsDialogs) executeRpcQuery(
                new TLRequestMessagesGetDialogs(excludePinned, offsetDate, offsetId, offsetPeer, limit));
    }

    @Override
    public TLAbsDocument messagesGetDocumentByHash(TLBytes sha256, int size, String mimeType) throws RpcErrorException, IOException {
        return (TLAbsDocument) executeRpcQuery(new TLRequestMessagesGetDocumentByHash(sha256, size, mimeType));
    }

    @Override
    public TLAbsFeaturedStickers messagesGetFeaturedStickers(int hash) throws RpcErrorException, IOException {
        return (TLAbsFeaturedStickers) executeRpcQuery(new TLRequestMessagesGetFeaturedStickers(hash));
    }

    @Override
    public TLChatFull messagesGetFullChat(int chatId) throws RpcErrorException, IOException {
        return (TLChatFull) executeRpcQuery(new TLRequestMessagesGetFullChat(chatId));
    }

    @Override
    public TLHighScores messagesGetGameHighScores(TLAbsInputPeer peer, int id, TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLHighScores) executeRpcQuery(new TLRequestMessagesGetGameHighScores(peer, id, userId));
    }

    @Override
    public TLAbsMessages messagesGetHistory(TLAbsInputPeer peer, int offsetId, int offsetDate, int addOffset, int limit, int maxId, int minId) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(
                new TLRequestMessagesGetHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId));
    }

    @Override
    public TLBotResults messagesGetInlineBotResults(TLAbsInputUser bot, TLAbsInputPeer peer, TLAbsInputGeoPoint geoPoint, String query, String offset) throws RpcErrorException, IOException {
        return (TLBotResults) executeRpcQuery(
                new TLRequestMessagesGetInlineBotResults(bot, peer, geoPoint, query, offset));
    }

    @Override
    public TLHighScores messagesGetInlineGameHighScores(TLInputBotInlineMessageID id, TLAbsInputUser userId) throws RpcErrorException, IOException {
        return (TLHighScores) executeRpcQuery(new TLRequestMessagesGetInlineGameHighScores(id, userId));
    }

    @Override
    public TLAbsAllStickers messagesGetMaskStickers(int hash) throws RpcErrorException, IOException {
        return (TLAbsAllStickers) executeRpcQuery(new TLRequestMessagesGetMaskStickers(hash));
    }

    @Override
    public TLMessageEditData messagesGetMessageEditData(TLAbsInputPeer peer, int id) throws RpcErrorException, IOException {
        return (TLMessageEditData) executeRpcQuery(new TLRequestMessagesGetMessageEditData(peer, id));
    }

    @Override
    public TLAbsMessages messagesGetMessages(TLIntVector id) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(new TLRequestMessagesGetMessages(id));
    }

    @Override
    public TLIntVector messagesGetMessagesViews(TLAbsInputPeer peer, TLIntVector id, boolean increment) throws RpcErrorException, IOException {
        return (TLIntVector) executeRpcQuery(new TLRequestMessagesGetMessagesViews(peer, id, increment));
    }

    @Override
    public TLPeerDialogs messagesGetPeerDialogs(TLVector<TLAbsInputPeer> peers) throws RpcErrorException, IOException {
        return (TLPeerDialogs) executeRpcQuery(new TLRequestMessagesGetPeerDialogs(peers));
    }

    @Override
    public TLPeerSettings messagesGetPeerSettings(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLPeerSettings) executeRpcQuery(new TLRequestMessagesGetPeerSettings(peer));
    }

    @Override
    public TLPeerDialogs messagesGetPinnedDialogs() throws RpcErrorException, IOException {
        return (TLPeerDialogs) executeRpcQuery(new TLRequestMessagesGetPinnedDialogs());
    }

    @Override
    public TLAbsRecentStickers messagesGetRecentStickers(boolean attached, int hash) throws RpcErrorException, IOException {
        return (TLAbsRecentStickers) executeRpcQuery(new TLRequestMessagesGetRecentStickers(attached, hash));
    }

    @Override
    public TLAbsSavedGifs messagesGetSavedGifs(int hash) throws RpcErrorException, IOException {
        return (TLAbsSavedGifs) executeRpcQuery(new TLRequestMessagesGetSavedGifs(hash));
    }

    @Override
    public TLStickerSet messagesGetStickerSet(TLAbsInputStickerSet stickerset) throws RpcErrorException, IOException {
        return (TLStickerSet) executeRpcQuery(new TLRequestMessagesGetStickerSet(stickerset));
    }

    @Override
    public TLAbsWebPage messagesGetWebPage(String url, int hash) throws RpcErrorException, IOException {
        return (TLAbsWebPage) executeRpcQuery(new TLRequestMessagesGetWebPage(url, hash));
    }

    @Override
    public TLAbsMessageMedia messagesGetWebPagePreview(String message) throws RpcErrorException, IOException {
        return (TLAbsMessageMedia) executeRpcQuery(new TLRequestMessagesGetWebPagePreview(message));
    }

    @Override
    public TLBool messagesHideReportSpam(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesHideReportSpam(peer));
    }

    @Override
    public TLAbsUpdates messagesImportChatInvite(String hash) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesImportChatInvite(hash));
    }

    @Override
    public TLAbsStickerSetInstallResult messagesInstallStickerSet(TLAbsInputStickerSet stickerset, boolean archived) throws RpcErrorException, IOException {
        return (TLAbsStickerSetInstallResult) executeRpcQuery(
                new TLRequestMessagesInstallStickerSet(stickerset, archived));
    }

    @Override
    public TLAbsUpdates messagesMigrateChat(int chatId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesMigrateChat(chatId));
    }

    @Override
    public TLBool messagesReadEncryptedHistory(TLInputEncryptedChat peer, int maxDate) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReadEncryptedHistory(peer, maxDate));
    }

    @Override
    public TLBool messagesReadFeaturedStickers(TLLongVector id) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReadFeaturedStickers(id));
    }

    @Override
    public TLAffectedMessages messagesReadHistory(TLAbsInputPeer peer, int maxId) throws RpcErrorException, IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestMessagesReadHistory(peer, maxId));
    }

    @Override
    public TLAffectedMessages messagesReadMessageContents(TLIntVector id) throws RpcErrorException, IOException {
        return (TLAffectedMessages) executeRpcQuery(new TLRequestMessagesReadMessageContents(id));
    }

    @Override
    public TLVector<TLReceivedNotifyMessage> messagesReceivedMessages(int maxId) throws RpcErrorException, IOException {
        return (TLVector<TLReceivedNotifyMessage>) executeRpcQuery(new TLRequestMessagesReceivedMessages(maxId));
    }

    @Override
    public TLLongVector messagesReceivedQueue(int maxQts) throws RpcErrorException, IOException {
        return (TLLongVector) executeRpcQuery(new TLRequestMessagesReceivedQueue(maxQts));
    }

    @Override
    public TLBool messagesReorderPinnedDialogs(boolean force, TLVector<TLAbsInputPeer> order) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReorderPinnedDialogs(force, order));
    }

    @Override
    public TLBool messagesReorderStickerSets(boolean masks, TLLongVector order) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReorderStickerSets(masks, order));
    }

    @Override
    public TLBool messagesReportEncryptedSpam(TLInputEncryptedChat peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReportEncryptedSpam(peer));
    }

    @Override
    public TLBool messagesReportSpam(TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesReportSpam(peer));
    }

    @Override
    public TLAbsEncryptedChat messagesRequestEncryption(TLAbsInputUser userId, int randomId, TLBytes gA) throws RpcErrorException, IOException {
        return (TLAbsEncryptedChat) executeRpcQuery(new TLRequestMessagesRequestEncryption(userId, randomId, gA));
    }

    @Override
    public TLBool messagesSaveDraft(boolean noWebpage, Integer replyToMsgId, TLAbsInputPeer peer, String message, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(
                new TLRequestMessagesSaveDraft(noWebpage, replyToMsgId, peer, message, entities));
    }

    @Override
    public TLBool messagesSaveGif(TLAbsInputDocument id, boolean unsave) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSaveGif(id, unsave));
    }

    @Override
    public TLBool messagesSaveRecentSticker(boolean attached, TLAbsInputDocument id, boolean unsave) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSaveRecentSticker(attached, id, unsave));
    }

    @Override
    public TLAbsMessages messagesSearch(TLAbsInputPeer peer, String q, TLAbsMessagesFilter filter, int minDate, int maxDate, int offset, int maxId, int limit) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(
                new TLRequestMessagesSearch(peer, q, filter, minDate, maxDate, offset, maxId, limit));
    }

    @Override
    public TLFoundGifs messagesSearchGifs(String q, int offset) throws RpcErrorException, IOException {
        return (TLFoundGifs) executeRpcQuery(new TLRequestMessagesSearchGifs(q, offset));
    }

    @Override
    public TLAbsMessages messagesSearchGlobal(String q, int offsetDate, TLAbsInputPeer offsetPeer, int offsetId, int limit) throws RpcErrorException, IOException {
        return (TLAbsMessages) executeRpcQuery(
                new TLRequestMessagesSearchGlobal(q, offsetDate, offsetPeer, offsetId, limit));
    }

    @Override
    public TLAbsSentEncryptedMessage messagesSendEncrypted(TLInputEncryptedChat peer, long randomId, TLBytes data) throws RpcErrorException, IOException {
        return (TLAbsSentEncryptedMessage) executeRpcQuery(new TLRequestMessagesSendEncrypted(peer, randomId, data));
    }

    @Override
    public TLAbsSentEncryptedMessage messagesSendEncryptedFile(TLInputEncryptedChat peer, long randomId, TLBytes data, TLAbsInputEncryptedFile file) throws RpcErrorException, IOException {
        return (TLAbsSentEncryptedMessage) executeRpcQuery(
                new TLRequestMessagesSendEncryptedFile(peer, randomId, data, file));
    }

    @Override
    public TLAbsSentEncryptedMessage messagesSendEncryptedService(TLInputEncryptedChat peer, long randomId, TLBytes data) throws RpcErrorException, IOException {
        return (TLAbsSentEncryptedMessage) executeRpcQuery(
                new TLRequestMessagesSendEncryptedService(peer, randomId, data));
    }

    @Override
    public TLAbsUpdates messagesSendInlineBotResult(boolean silent, boolean background, boolean clearDraft, TLAbsInputPeer peer, Integer replyToMsgId, long randomId, long queryId, String id) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(
                new TLRequestMessagesSendInlineBotResult(silent, background, clearDraft, peer, replyToMsgId, randomId,
                                                         queryId, id));
    }

    @Override
    public TLAbsUpdates messagesSendMedia(boolean silent, boolean background, boolean clearDraft, TLAbsInputPeer peer, Integer replyToMsgId, TLAbsInputMedia media, long randomId, TLAbsReplyMarkup replyMarkup) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(
                new TLRequestMessagesSendMedia(silent, background, clearDraft, peer, replyToMsgId, media, randomId,
                                               replyMarkup));
    }

    @Override
    public TLAbsUpdates messagesSendMessage(boolean noWebpage, boolean silent, boolean background, boolean clearDraft, TLAbsInputPeer peer, Integer replyToMsgId, String message, long randomId, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(
                new TLRequestMessagesSendMessage(noWebpage, silent, background, clearDraft, peer, replyToMsgId, message,
                                                 randomId, replyMarkup, entities));
    }

    @Override
    public TLBool messagesSetBotCallbackAnswer(boolean alert, long queryId, String message, String url, int cacheTime) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(
                new TLRequestMessagesSetBotCallbackAnswer(alert, queryId, message, url, cacheTime));
    }

    @Override
    public TLBool messagesSetBotPrecheckoutResults(boolean success, long queryId, String error) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetBotPrecheckoutResults(success, queryId, error));
    }

    @Override
    public TLBool messagesSetBotShippingResults(long queryId, String error, TLVector<TLShippingOption> shippingOptions) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetBotShippingResults(queryId, error, shippingOptions));
    }

    @Override
    public TLBool messagesSetEncryptedTyping(TLInputEncryptedChat peer, boolean typing) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetEncryptedTyping(peer, typing));
    }

    @Override
    public TLAbsUpdates messagesSetGameScore(boolean editMessage, boolean force, TLAbsInputPeer peer, int id, TLAbsInputUser userId, int score) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(
                new TLRequestMessagesSetGameScore(editMessage, force, peer, id, userId, score));
    }

    @Override
    public TLBool messagesSetInlineBotResults(boolean gallery, boolean _private, long queryId, TLVector<TLAbsInputBotInlineResult> results, int cacheTime, String nextOffset, TLInlineBotSwitchPM switchPm) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(
                new TLRequestMessagesSetInlineBotResults(gallery, _private, queryId, results, cacheTime, nextOffset,
                                                         switchPm));
    }

    @Override
    public TLBool messagesSetInlineGameScore(boolean editMessage, boolean force, TLInputBotInlineMessageID id, TLAbsInputUser userId, int score) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetInlineGameScore(editMessage, force, id, userId, score));
    }

    @Override
    public TLBool messagesSetTyping(TLAbsInputPeer peer, TLAbsSendMessageAction action) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesSetTyping(peer, action));
    }

    @Override
    public TLAbsUpdates messagesStartBot(TLAbsInputUser bot, TLAbsInputPeer peer, long randomId, String startParam) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesStartBot(bot, peer, randomId, startParam));
    }

    @Override
    public TLAbsUpdates messagesToggleChatAdmins(int chatId, boolean enabled) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestMessagesToggleChatAdmins(chatId, enabled));
    }

    @Override
    public TLBool messagesToggleDialogPin(boolean pinned, TLAbsInputPeer peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesToggleDialogPin(pinned, peer));
    }

    @Override
    public TLBool messagesUninstallStickerSet(TLAbsInputStickerSet stickerset) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestMessagesUninstallStickerSet(stickerset));
    }

    @Override
    public TLBool paymentsClearSavedInfo(boolean credentials, boolean info) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPaymentsClearSavedInfo(credentials, info));
    }

    @Override
    public TLPaymentForm paymentsGetPaymentForm(int msgId) throws RpcErrorException, IOException {
        return (TLPaymentForm) executeRpcQuery(new TLRequestPaymentsGetPaymentForm(msgId));
    }

    @Override
    public TLPaymentReceipt paymentsGetPaymentReceipt(int msgId) throws RpcErrorException, IOException {
        return (TLPaymentReceipt) executeRpcQuery(new TLRequestPaymentsGetPaymentReceipt(msgId));
    }

    @Override
    public TLSavedInfo paymentsGetSavedInfo() throws RpcErrorException, IOException {
        return (TLSavedInfo) executeRpcQuery(new TLRequestPaymentsGetSavedInfo());
    }

    @Override
    public TLAbsPaymentResult paymentsSendPaymentForm(int msgId, String requestedInfoId, String shippingOptionId, TLAbsInputPaymentCredentials credentials) throws RpcErrorException, IOException {
        return (TLAbsPaymentResult) executeRpcQuery(
                new TLRequestPaymentsSendPaymentForm(msgId, requestedInfoId, shippingOptionId, credentials));
    }

    @Override
    public TLValidatedRequestedInfo paymentsValidateRequestedInfo(boolean save, int msgId, TLPaymentRequestedInfo info) throws RpcErrorException, IOException {
        return (TLValidatedRequestedInfo) executeRpcQuery(
                new TLRequestPaymentsValidateRequestedInfo(save, msgId, info));
    }

    @Override
    public TLPhoneCall phoneAcceptCall(TLInputPhoneCall peer, TLBytes gB, TLPhoneCallProtocol protocol) throws RpcErrorException, IOException {
        return (TLPhoneCall) executeRpcQuery(new TLRequestPhoneAcceptCall(peer, gB, protocol));
    }

    @Override
    public TLPhoneCall phoneConfirmCall(TLInputPhoneCall peer, TLBytes gA, long keyFingerprint, TLPhoneCallProtocol protocol) throws RpcErrorException, IOException {
        return (TLPhoneCall) executeRpcQuery(new TLRequestPhoneConfirmCall(peer, gA, keyFingerprint, protocol));
    }

    @Override
    public TLAbsUpdates phoneDiscardCall(TLInputPhoneCall peer, int duration, TLAbsPhoneCallDiscardReason reason, long connectionId) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneDiscardCall(peer, duration, reason, connectionId));
    }

    @Override
    public TLDataJSON phoneGetCallConfig() throws RpcErrorException, IOException {
        return (TLDataJSON) executeRpcQuery(new TLRequestPhoneGetCallConfig());
    }

    @Override
    public TLBool phoneReceivedCall(TLInputPhoneCall peer) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPhoneReceivedCall(peer));
    }

    @Override
    public TLPhoneCall phoneRequestCall(TLAbsInputUser userId, int randomId, TLBytes gAHash, TLPhoneCallProtocol protocol) throws RpcErrorException, IOException {
        return (TLPhoneCall) executeRpcQuery(new TLRequestPhoneRequestCall(userId, randomId, gAHash, protocol));
    }

    @Override
    public TLBool phoneSaveCallDebug(TLInputPhoneCall peer, TLDataJSON debug) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestPhoneSaveCallDebug(peer, debug));
    }

    @Override
    public TLAbsUpdates phoneSetCallRating(TLInputPhoneCall peer, int rating, String comment) throws RpcErrorException, IOException {
        return (TLAbsUpdates) executeRpcQuery(new TLRequestPhoneSetCallRating(peer, rating, comment));
    }

    @Override
    public TLLongVector photosDeletePhotos(TLVector<TLAbsInputPhoto> id) throws RpcErrorException, IOException {
        return (TLLongVector) executeRpcQuery(new TLRequestPhotosDeletePhotos(id));
    }

    @Override
    public TLAbsPhotos photosGetUserPhotos(TLAbsInputUser userId, int offset, long maxId, int limit) throws RpcErrorException, IOException {
        return (TLAbsPhotos) executeRpcQuery(new TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit));
    }

    @Override
    public TLAbsUserProfilePhoto photosUpdateProfilePhoto(TLAbsInputPhoto id) throws RpcErrorException, IOException {
        return (TLAbsUserProfilePhoto) executeRpcQuery(new TLRequestPhotosUpdateProfilePhoto(id));
    }

    @Override
    public TLPhoto photosUploadProfilePhoto(TLAbsInputFile file) throws RpcErrorException, IOException {
        return (TLPhoto) executeRpcQuery(new TLRequestPhotosUploadProfilePhoto(file));
    }

    @Override
    public TLAbsChannelDifference updatesGetChannelDifference(boolean force, TLAbsInputChannel channel, TLAbsChannelMessagesFilter filter, int pts, int limit) throws RpcErrorException, IOException {
        return (TLAbsChannelDifference) executeRpcQuery(
                new TLRequestUpdatesGetChannelDifference(force, channel, filter, pts, limit));
    }

    @Override
    public TLAbsDifference updatesGetDifference(int pts, Integer ptsTotalLimit, int date, int qts) throws RpcErrorException, IOException {
        return (TLAbsDifference) executeRpcQuery(new TLRequestUpdatesGetDifference(pts, ptsTotalLimit, date, qts));
    }

    @Override
    public TLState updatesGetState() throws RpcErrorException, IOException {
        return (TLState) executeRpcQuery(new TLRequestUpdatesGetState());
    }

    @Override
    public TLAbsCdnFile uploadGetCdnFile(TLBytes fileToken, int offset, int limit) throws RpcErrorException, IOException {
        return (TLAbsCdnFile) executeRpcQuery(new TLRequestUploadGetCdnFile(fileToken, offset, limit));
    }

    @Override
    public TLAbsFile uploadGetFile(TLAbsInputFileLocation location, int offset, int limit) throws RpcErrorException, IOException {
        return (TLAbsFile) executeRpcQuery(new TLRequestUploadGetFile(location, offset, limit));
    }

    @Override
    public TLWebFile uploadGetWebFile(TLInputWebFileLocation location, int offset, int limit) throws RpcErrorException, IOException {
        return (TLWebFile) executeRpcQuery(new TLRequestUploadGetWebFile(location, offset, limit));
    }

    @Override
    public TLBool uploadReuploadCdnFile(TLBytes fileToken, TLBytes requestToken) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestUploadReuploadCdnFile(fileToken, requestToken));
    }

    @Override
    public TLBool uploadSaveBigFilePart(long fileId, int filePart, int fileTotalParts, TLBytes bytes) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes));
    }

    @Override
    public TLBool uploadSaveFilePart(long fileId, int filePart, TLBytes bytes) throws RpcErrorException, IOException {
        return (TLBool) executeRpcQuery(new TLRequestUploadSaveFilePart(fileId, filePart, bytes));
    }

    @Override
    public TLUserFull usersGetFullUser(TLAbsInputUser id) throws RpcErrorException, IOException {
        return (TLUserFull) executeRpcQuery(new TLRequestUsersGetFullUser(id));
    }

    @Override
    public TLVector<TLAbsUser> usersGetUsers(TLVector<TLAbsInputUser> id) throws RpcErrorException, IOException {
        return (TLVector<TLAbsUser>) executeRpcQuery(new TLRequestUsersGetUsers(id));
    }
}
