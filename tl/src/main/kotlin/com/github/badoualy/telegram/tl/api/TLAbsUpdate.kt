package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [updateBotCallbackQuery#e73547e1][TLUpdateBotCallbackQuery]
 * * [updateBotInlineQuery#54826690][TLUpdateBotInlineQuery]
 * * [updateBotInlineSend#e48f964][TLUpdateBotInlineSend]
 * * [updateBotPrecheckoutQuery#5d2f3aa9][TLUpdateBotPrecheckoutQuery]
 * * [updateBotShippingQuery#e0cdc940][TLUpdateBotShippingQuery]
 * * [updateBotWebhookJSON#8317c0c3][TLUpdateBotWebhookJSON]
 * * [updateBotWebhookJSONQuery#9b9240a6][TLUpdateBotWebhookJSONQuery]
 * * [updateChannel#b6d45656][TLUpdateChannel]
 * * [updateChannelAvailableMessages#70db6837][TLUpdateChannelAvailableMessages]
 * * [updateChannelMessageViews#98a12b4b][TLUpdateChannelMessageViews]
 * * [updateChannelPinnedMessage#98592475][TLUpdateChannelPinnedMessage]
 * * [updateChannelReadMessagesContents#89893b45][TLUpdateChannelReadMessagesContents]
 * * [updateChannelTooLong#eb0467fb][TLUpdateChannelTooLong]
 * * [updateChannelWebPage#40771900][TLUpdateChannelWebPage]
 * * [updateChatAdmins#6e947941][TLUpdateChatAdmins]
 * * [updateChatParticipantAdd#ea4b0e5c][TLUpdateChatParticipantAdd]
 * * [updateChatParticipantAdmin#b6901959][TLUpdateChatParticipantAdmin]
 * * [updateChatParticipantDelete#6e5f8c22][TLUpdateChatParticipantDelete]
 * * [updateChatParticipants#7761198][TLUpdateChatParticipants]
 * * [updateChatUserTyping#9a65ea1f][TLUpdateChatUserTyping]
 * * [updateConfig#a229dd06][TLUpdateConfig]
 * * [updateContactLink#9d2e67c5][TLUpdateContactLink]
 * * [updateContactRegistered#2575bbb9][TLUpdateContactRegistered]
 * * [updateContactsReset#7084a7be][TLUpdateContactsReset]
 * * [updateDcOptions#8e5e9873][TLUpdateDcOptions]
 * * [updateDeleteChannelMessages#c37521c9][TLUpdateDeleteChannelMessages]
 * * [updateDeleteMessages#a20db0e5][TLUpdateDeleteMessages]
 * * [updateDialogPinned#19d27f3c][TLUpdateDialogPinned]
 * * [updateDialogUnreadMark#e16459c3][TLUpdateDialogUnreadMark]
 * * [updateDraftMessage#ee2bb969][TLUpdateDraftMessage]
 * * [updateEditChannelMessage#1b3f4df7][TLUpdateEditChannelMessage]
 * * [updateEditMessage#e40370a3][TLUpdateEditMessage]
 * * [updateEncryptedChatTyping#1710f156][TLUpdateEncryptedChatTyping]
 * * [updateEncryptedMessagesRead#38fe25b7][TLUpdateEncryptedMessagesRead]
 * * [updateEncryption#b4a2e88d][TLUpdateEncryption]
 * * [updateFavedStickers#e511996d][TLUpdateFavedStickers]
 * * [updateInlineBotCallbackQuery#f9d27a5a][TLUpdateInlineBotCallbackQuery]
 * * [updateLangPack#56022f4d][TLUpdateLangPack]
 * * [updateLangPackTooLong#10c2404b][TLUpdateLangPackTooLong]
 * * [updateMessageID#4e90bfd6][TLUpdateMessageID]
 * * [updateNewChannelMessage#62ba04d9][TLUpdateNewChannelMessage]
 * * [updateNewEncryptedMessage#12bcbd9a][TLUpdateNewEncryptedMessage]
 * * [updateNewMessage#1f2b0afd][TLUpdateNewMessage]
 * * [updateNewStickerSet#688a30aa][TLUpdateNewStickerSet]
 * * [updateNotifySettings#bec268ef][TLUpdateNotifySettings]
 * * [updatePhoneCall#ab0f6b1e][TLUpdatePhoneCall]
 * * [updatePinnedDialogs#ea4cb65b][TLUpdatePinnedDialogs]
 * * [updatePrivacy#ee3b272a][TLUpdatePrivacy]
 * * [updatePtsChanged#3354678f][TLUpdatePtsChanged]
 * * [updateReadChannelInbox#4214f37f][TLUpdateReadChannelInbox]
 * * [updateReadChannelOutbox#25d6c9c7][TLUpdateReadChannelOutbox]
 * * [updateReadFeaturedStickers#571d2742][TLUpdateReadFeaturedStickers]
 * * [updateReadHistoryInbox#9961fd5c][TLUpdateReadHistoryInbox]
 * * [updateReadHistoryOutbox#2f2f21bf][TLUpdateReadHistoryOutbox]
 * * [updateReadMessagesContents#68c13933][TLUpdateReadMessagesContents]
 * * [updateRecentStickers#9a422c20][TLUpdateRecentStickers]
 * * [updateSavedGifs#9375341e][TLUpdateSavedGifs]
 * * [updateServiceNotification#ebe46819][TLUpdateServiceNotification]
 * * [updateStickerSets#43ae3dec][TLUpdateStickerSets]
 * * [updateStickerSetsOrder#bb2d201][TLUpdateStickerSetsOrder]
 * * [updateUserBlocked#80ece81a][TLUpdateUserBlocked]
 * * [updateUserName#a7332b73][TLUpdateUserName]
 * * [updateUserPhone#12b9417b][TLUpdateUserPhone]
 * * [updateUserPhoto#95313b0c][TLUpdateUserPhoto]
 * * [updateUserStatus#1bfbd823][TLUpdateUserStatus]
 * * [updateUserTyping#5c486927][TLUpdateUserTyping]
 * * [updateWebPage#7f891213][TLUpdateWebPage]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsUpdate : TLObject()
