package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.RpcQueryExecutor
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.account.TLAbsPassword
import com.github.badoualy.telegram.tl.api.account.TLAuthorizationForm
import com.github.badoualy.telegram.tl.api.account.TLAuthorizations
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings
import com.github.badoualy.telegram.tl.api.account.TLPasswordSettings
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules
import com.github.badoualy.telegram.tl.api.account.TLSentEmailCode
import com.github.badoualy.telegram.tl.api.account.TLTakeout
import com.github.badoualy.telegram.tl.api.account.TLTmpPassword
import com.github.badoualy.telegram.tl.api.account.TLWebAuthorizations
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization
import com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization
import com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery
import com.github.badoualy.telegram.tl.api.auth.TLSentCode
import com.github.badoualy.telegram.tl.api.channels.TLAbsChannelParticipants
import com.github.badoualy.telegram.tl.api.channels.TLAdminLogResults
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipant
import com.github.badoualy.telegram.tl.api.contacts.TLAbsBlocked
import com.github.badoualy.telegram.tl.api.contacts.TLAbsContacts
import com.github.badoualy.telegram.tl.api.contacts.TLAbsTopPeers
import com.github.badoualy.telegram.tl.api.contacts.TLFound
import com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts
import com.github.badoualy.telegram.tl.api.contacts.TLLink
import com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer
import com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate
import com.github.badoualy.telegram.tl.api.help.TLAbsDeepLinkInfo
import com.github.badoualy.telegram.tl.api.help.TLAbsProxyData
import com.github.badoualy.telegram.tl.api.help.TLAbsTermsOfServiceUpdate
import com.github.badoualy.telegram.tl.api.help.TLInviteText
import com.github.badoualy.telegram.tl.api.help.TLRecentMeUrls
import com.github.badoualy.telegram.tl.api.help.TLSupport
import com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsChats
import com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs
import com.github.badoualy.telegram.tl.api.messages.TLAbsFavedStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsFeaturedStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsFoundStickerSets
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages
import com.github.badoualy.telegram.tl.api.messages.TLAbsRecentStickers
import com.github.badoualy.telegram.tl.api.messages.TLAbsSavedGifs
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSetInstallResult
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickers
import com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory
import com.github.badoualy.telegram.tl.api.messages.TLAffectedMessages
import com.github.badoualy.telegram.tl.api.messages.TLArchivedStickers
import com.github.badoualy.telegram.tl.api.messages.TLBotCallbackAnswer
import com.github.badoualy.telegram.tl.api.messages.TLBotResults
import com.github.badoualy.telegram.tl.api.messages.TLChatFull
import com.github.badoualy.telegram.tl.api.messages.TLFoundGifs
import com.github.badoualy.telegram.tl.api.messages.TLHighScores
import com.github.badoualy.telegram.tl.api.messages.TLMessageEditData
import com.github.badoualy.telegram.tl.api.messages.TLPeerDialogs
import com.github.badoualy.telegram.tl.api.messages.TLStickerSet
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult
import com.github.badoualy.telegram.tl.api.payments.TLPaymentForm
import com.github.badoualy.telegram.tl.api.payments.TLPaymentReceipt
import com.github.badoualy.telegram.tl.api.payments.TLSavedInfo
import com.github.badoualy.telegram.tl.api.payments.TLValidatedRequestedInfo
import com.github.badoualy.telegram.tl.api.phone.TLPhoneCall
import com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos
import com.github.badoualy.telegram.tl.api.photos.TLPhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountAcceptAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountChangePhone
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountCheckUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountConfirmPhone
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeleteAccount
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountDeleteSecureValue
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountFinishTakeoutSession
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAccountTTL
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAllSecureValues
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAuthorizationForm
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetAuthorizations
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetNotifySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetPasswordSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetPrivacy
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetSecureValue
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetTmpPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetWallPapers
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountGetWebAuthorizations
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountInitTakeoutSession
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountRegisterDevice
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountReportPeer
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetNotifySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetWebAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountResetWebAuthorizations
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSaveSecureValue
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendChangePhoneCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendConfirmPhoneCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendVerifyEmailCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSendVerifyPhoneCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetAccountTTL
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountSetPrivacy
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUnregisterDevice
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateDeviceLocked
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateNotifySettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdatePasswordSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateProfile
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateStatus
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountUpdateUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountVerifyEmail
import com.github.badoualy.telegram.tl.api.request.TLRequestAccountVerifyPhone
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthBindTempAuthKey
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthCancelCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthCheckPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthDropTempAuthKeys
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthExportAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthImportAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthImportBotAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthLogOut
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthRecoverPassword
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthRequestPasswordRecovery
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthResendCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthResetAuthorizations
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthSendCode
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthSignIn
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthSignUp
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsAnswerWebhookJSONQuery
import com.github.badoualy.telegram.tl.api.request.TLRequestBotsSendCustomRequest
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsCheckUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsCreateChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsDeleteUserHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditAbout
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditAdmin
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditBanned
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditPhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsEditTitle
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsExportInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsExportMessageLink
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetAdminLog
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetAdminedPublicChannels
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetChannels
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetFullChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetLeftChannels
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetParticipant
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsGetParticipants
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsInviteToChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsJoinChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsLeaveChannel
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReadHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReadMessageContents
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsReportSpam
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsSetStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleInvites
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsTogglePreHistoryHidden
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsToggleSignatures
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsUpdatePinnedMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestChannelsUpdateUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsBlock
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsDeleteContact
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsDeleteContacts
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsExportCard
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetBlocked
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetContacts
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetSaved
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetStatuses
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsGetTopPeers
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsImportCard
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsImportContacts
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResetSaved
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResetTopPeerRating
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsResolveUsername
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsSearch
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsToggleTopPeers
import com.github.badoualy.telegram.tl.api.request.TLRequestContactsUnblock
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpAcceptTermsOfService
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetAppChangelog
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetAppUpdate
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetCdnConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetDeepLinkInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetInviteText
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetNearestDc
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetProxyData
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetRecentMeUrls
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetSupport
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpGetTermsOfServiceUpdate
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpSaveAppLog
import com.github.badoualy.telegram.tl.api.request.TLRequestHelpSetBotUpdatesStatus
import com.github.badoualy.telegram.tl.api.request.TLRequestInitConnection
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeAfterMsg
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeAfterMsgs
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithLayer
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithMessagesRange
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithTakeout
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithoutUpdates
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetDifference
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetLangPack
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetLanguages
import com.github.badoualy.telegram.tl.api.request.TLRequestLangpackGetStrings
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesAcceptEncryption
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesAddChatUser
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCheckChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesClearRecentStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesCreateChat
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteChatUser
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDeleteMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesDiscardEncryption
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatAdmin
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatPhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditChatTitle
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditInlineBotMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesEditMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesExportChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesFaveSticker
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesForwardMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAllChats
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAllDrafts
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAllStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetArchivedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetAttachedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetBotCallbackAnswer
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetChats
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetCommonChats
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDhConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDialogUnreadMarks
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetDocumentByHash
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFavedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFeaturedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetFullChat
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetGameHighScores
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetInlineBotResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetInlineGameHighScores
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMaskStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessageEditData
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetMessagesViews
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPeerDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPeerSettings
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetPinnedDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetRecentLocations
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetRecentStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSavedGifs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetSplitRanges
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetUnreadMentions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetWebPage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesGetWebPagePreview
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesHideReportSpam
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesImportChatInvite
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesInstallStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesMarkDialogUnread
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesMigrateChat
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadEncryptedHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadFeaturedStickers
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadHistory
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadMentions
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReadMessageContents
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReceivedMessages
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReceivedQueue
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReorderPinnedDialogs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReorderStickerSets
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReport
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReportEncryptedSpam
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesReportSpam
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesRequestEncryption
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveDraft
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveGif
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSaveRecentSticker
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearch
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchGifs
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchGlobal
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSearchStickerSets
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendEncrypted
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendEncryptedFile
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendEncryptedService
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendInlineBotResult
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendMessage
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendMultiMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSendScreenshotNotification
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetBotCallbackAnswer
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetBotPrecheckoutResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetBotShippingResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetEncryptedTyping
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetGameScore
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetInlineBotResults
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetInlineGameScore
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesSetTyping
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesStartBot
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleChatAdmins
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesToggleDialogPin
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUninstallStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUploadEncryptedFile
import com.github.badoualy.telegram.tl.api.request.TLRequestMessagesUploadMedia
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsClearSavedInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetPaymentForm
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetPaymentReceipt
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsGetSavedInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsSendPaymentForm
import com.github.badoualy.telegram.tl.api.request.TLRequestPaymentsValidateRequestedInfo
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneAcceptCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneConfirmCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneDiscardCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneGetCallConfig
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneReceivedCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneRequestCall
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSaveCallDebug
import com.github.badoualy.telegram.tl.api.request.TLRequestPhoneSetCallRating
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosDeletePhotos
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosGetUserPhotos
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosUpdateProfilePhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestPhotosUploadProfilePhoto
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersAddStickerToSet
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersChangeStickerPosition
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersCreateStickerSet
import com.github.badoualy.telegram.tl.api.request.TLRequestStickersRemoveStickerFromSet
import com.github.badoualy.telegram.tl.api.request.TLRequestUpdatesGetChannelDifference
import com.github.badoualy.telegram.tl.api.request.TLRequestUpdatesGetDifference
import com.github.badoualy.telegram.tl.api.request.TLRequestUpdatesGetState
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetCdnFile
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetCdnFileHashes
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetFile
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetFileHashes
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetWebFile
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadReuploadCdnFile
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadSaveBigFilePart
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadSaveFilePart
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersGetFullUser
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersGetUsers
import com.github.badoualy.telegram.tl.api.request.TLRequestUsersSetSecureValueErrors
import com.github.badoualy.telegram.tl.api.updates.TLAbsChannelDifference
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference
import com.github.badoualy.telegram.tl.api.updates.TLState
import com.github.badoualy.telegram.tl.api.upload.TLAbsCdnFile
import com.github.badoualy.telegram.tl.api.upload.TLAbsFile
import com.github.badoualy.telegram.tl.api.upload.TLWebFile
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLStringVector
import io.reactivex.Single
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String

abstract class TelegramApiWrapper : TelegramApi, RpcQueryExecutor {
    override fun accountAcceptAuthorization(
            botId: Int,
            scope: String,
            publicKey: String,
            valueHashes: TLObjectVector<TLSecureValueHash>,
            credentials: TLSecureCredentialsEncrypted
    ): Single<TLBool> = executeMethod(TLRequestAccountAcceptAuthorization(botId, scope, publicKey, valueHashes, credentials))

    override fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAbsUser> = executeMethod(TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode))

    override fun accountCheckUsername(username: String): Single<TLBool> = executeMethod(TLRequestAccountCheckUsername(username))

    override fun accountConfirmPhone(phoneCodeHash: String, phoneCode: String): Single<TLBool> = executeMethod(TLRequestAccountConfirmPhone(phoneCodeHash, phoneCode))

    override fun accountDeleteAccount(reason: String): Single<TLBool> = executeMethod(TLRequestAccountDeleteAccount(reason))

    override fun accountDeleteSecureValue(types: TLObjectVector<TLAbsSecureValueType>): Single<TLBool> = executeMethod(TLRequestAccountDeleteSecureValue(types))

    override fun accountFinishTakeoutSession(success: Boolean): Single<TLBool> = executeMethod(TLRequestAccountFinishTakeoutSession(success))

    override fun accountGetAccountTTL(): Single<TLAccountDaysTTL> = executeMethod(TLRequestAccountGetAccountTTL())

    override fun accountGetAllSecureValues(): Single<TLObjectVector<TLSecureValue>> = executeMethod(TLRequestAccountGetAllSecureValues())

    override fun accountGetAuthorizationForm(
            botId: Int,
            scope: String,
            publicKey: String
    ): Single<TLAuthorizationForm> = executeMethod(TLRequestAccountGetAuthorizationForm(botId, scope, publicKey))

    override fun accountGetAuthorizations(): Single<TLAuthorizations> = executeMethod(TLRequestAccountGetAuthorizations())

    override fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): Single<TLAbsPeerNotifySettings> = executeMethod(TLRequestAccountGetNotifySettings(peer)).map { it as TLAbsPeerNotifySettings }

    override fun accountGetPassword(): Single<TLAbsPassword> = executeMethod(TLRequestAccountGetPassword())

    override fun accountGetPasswordSettings(currentPasswordHash: TLBytes): Single<TLPasswordSettings> = executeMethod(TLRequestAccountGetPasswordSettings(currentPasswordHash))

    override fun accountGetPrivacy(key: TLAbsInputPrivacyKey): Single<TLPrivacyRules> = executeMethod(TLRequestAccountGetPrivacy(key))

    override fun accountGetSecureValue(types: TLObjectVector<TLAbsSecureValueType>): Single<TLObjectVector<TLSecureValue>> = executeMethod(TLRequestAccountGetSecureValue(types))

    override fun accountGetTmpPassword(passwordHash: TLBytes, period: Int): Single<TLTmpPassword> = executeMethod(TLRequestAccountGetTmpPassword(passwordHash, period))

    override fun accountGetWallPapers(): Single<TLObjectVector<TLAbsWallPaper>> = executeMethod(TLRequestAccountGetWallPapers())

    override fun accountGetWebAuthorizations(): Single<TLWebAuthorizations> = executeMethod(TLRequestAccountGetWebAuthorizations())

    override fun accountInitTakeoutSession(
            contacts: Boolean,
            messageUsers: Boolean,
            messageChats: Boolean,
            messageMegagroups: Boolean,
            messageChannels: Boolean,
            files: Boolean,
            fileMaxSize: Int?
    ): Single<TLTakeout> = executeMethod(TLRequestAccountInitTakeoutSession(contacts, messageUsers, messageChats, messageMegagroups, messageChannels, files, fileMaxSize))

    override fun accountRegisterDevice(
            tokenType: Int,
            token: String,
            appSandbox: Boolean,
            secret: TLBytes,
            otherUids: TLIntVector
    ): Single<TLBool> = executeMethod(TLRequestAccountRegisterDevice(tokenType, token, appSandbox, secret, otherUids))

    override fun accountReportPeer(peer: TLAbsInputPeer, reason: TLAbsReportReason): Single<TLBool> = executeMethod(TLRequestAccountReportPeer(peer, reason))

    override fun accountResetAuthorization(hash: Long): Single<TLBool> = executeMethod(TLRequestAccountResetAuthorization(hash))

    override fun accountResetNotifySettings(): Single<TLBool> = executeMethod(TLRequestAccountResetNotifySettings())

    override fun accountResetWebAuthorization(hash: Long): Single<TLBool> = executeMethod(TLRequestAccountResetWebAuthorization(hash))

    override fun accountResetWebAuthorizations(): Single<TLBool> = executeMethod(TLRequestAccountResetWebAuthorizations())

    override fun accountSaveSecureValue(value: TLInputSecureValue, secureSecretId: Long): Single<TLSecureValue> = executeMethod(TLRequestAccountSaveSecureValue(value, secureSecretId))

    override fun accountSendChangePhoneCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?
    ): Single<TLSentCode> = executeMethod(TLRequestAccountSendChangePhoneCode(allowFlashcall, phoneNumber, currentNumber))

    override fun accountSendConfirmPhoneCode(
            allowFlashcall: Boolean,
            hash: String,
            currentNumber: Boolean?
    ): Single<TLSentCode> = executeMethod(TLRequestAccountSendConfirmPhoneCode(allowFlashcall, hash, currentNumber))

    override fun accountSendVerifyEmailCode(email: String): Single<TLSentEmailCode> = executeMethod(TLRequestAccountSendVerifyEmailCode(email))

    override fun accountSendVerifyPhoneCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?
    ): Single<TLSentCode> = executeMethod(TLRequestAccountSendVerifyPhoneCode(allowFlashcall, phoneNumber, currentNumber))

    override fun accountSetAccountTTL(ttl: TLAccountDaysTTL): Single<TLBool> = executeMethod(TLRequestAccountSetAccountTTL(ttl))

    override fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): Single<TLPrivacyRules> = executeMethod(TLRequestAccountSetPrivacy(key, rules))

    override fun accountUnregisterDevice(
            tokenType: Int,
            token: String,
            otherUids: TLIntVector
    ): Single<TLBool> = executeMethod(TLRequestAccountUnregisterDevice(tokenType, token, otherUids))

    override fun accountUpdateDeviceLocked(period: Int): Single<TLBool> = executeMethod(TLRequestAccountUpdateDeviceLocked(period))

    override fun accountUpdateNotifySettings(peer: TLAbsInputNotifyPeer, settings: TLInputPeerNotifySettings): Single<TLBool> = executeMethod(TLRequestAccountUpdateNotifySettings(peer, settings))

    override fun accountUpdatePasswordSettings(currentPasswordHash: TLBytes, newSettings: TLPasswordInputSettings): Single<TLBool> = executeMethod(TLRequestAccountUpdatePasswordSettings(currentPasswordHash, newSettings))

    override fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): Single<TLAbsUser> = executeMethod(TLRequestAccountUpdateProfile(firstName, lastName, about))

    override fun accountUpdateStatus(offline: Boolean): Single<TLBool> = executeMethod(TLRequestAccountUpdateStatus(offline))

    override fun accountUpdateUsername(username: String): Single<TLAbsUser> = executeMethod(TLRequestAccountUpdateUsername(username))

    override fun accountVerifyEmail(email: String, code: String): Single<TLBool> = executeMethod(TLRequestAccountVerifyEmail(email, code))

    override fun accountVerifyPhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLBool> = executeMethod(TLRequestAccountVerifyPhone(phoneNumber, phoneCodeHash, phoneCode))

    override fun authBindTempAuthKey(
            permAuthKeyId: Long,
            nonce: Long,
            expiresAt: Int,
            encryptedMessage: TLBytes
    ): Single<TLBool> = executeMethod(TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage))

    override fun authCancelCode(phoneNumber: String, phoneCodeHash: String): Single<TLBool> = executeMethod(TLRequestAuthCancelCode(phoneNumber, phoneCodeHash))

    override fun authCheckPassword(passwordHash: TLBytes): Single<TLAuthorization> = executeMethod(TLRequestAuthCheckPassword(passwordHash))

    override fun authDropTempAuthKeys(exceptAuthKeys: TLLongVector): Single<TLBool> = executeMethod(TLRequestAuthDropTempAuthKeys(exceptAuthKeys))

    override fun authExportAuthorization(dcId: Int): Single<TLExportedAuthorization> = executeMethod(TLRequestAuthExportAuthorization(dcId))

    override fun authImportAuthorization(id: Int, bytes: TLBytes): Single<TLAuthorization> = executeMethod(TLRequestAuthImportAuthorization(id, bytes))

    override fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): Single<TLAuthorization> = executeMethod(TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken))

    override fun authLogOut(): Single<TLBool> = executeMethod(TLRequestAuthLogOut())

    override fun authRecoverPassword(code: String): Single<TLAuthorization> = executeMethod(TLRequestAuthRecoverPassword(code))

    override fun authRequestPasswordRecovery(): Single<TLPasswordRecovery> = executeMethod(TLRequestAuthRequestPasswordRecovery())

    override fun authResendCode(phoneNumber: String, phoneCodeHash: String): Single<TLSentCode> = executeMethod(TLRequestAuthResendCode(phoneNumber, phoneCodeHash))

    override fun authResetAuthorizations(): Single<TLBool> = executeMethod(TLRequestAuthResetAuthorizations())

    override fun authSendCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?,
            apiId: Int,
            apiHash: String
    ): Single<TLSentCode> = executeMethod(TLRequestAuthSendCode(allowFlashcall, phoneNumber, currentNumber, apiId, apiHash))

    override fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): Single<TLAuthorization> = executeMethod(TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode))

    override fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String,
            firstName: String,
            lastName: String
    ): Single<TLAuthorization> = executeMethod(TLRequestAuthSignUp(phoneNumber, phoneCodeHash, phoneCode, firstName, lastName))

    override fun botsAnswerWebhookJSONQuery(queryId: Long, data: TLDataJSON): Single<TLBool> = executeMethod(TLRequestBotsAnswerWebhookJSONQuery(queryId, data))

    override fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): Single<TLDataJSON> = executeMethod(TLRequestBotsSendCustomRequest(customMethod, params))

    override fun channelsCheckUsername(channel: TLAbsInputChannel, username: String): Single<TLBool> = executeMethod(TLRequestChannelsCheckUsername(channel, username))

    override fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            title: String,
            about: String
    ): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsCreateChannel(broadcast, megagroup, title, about))

    override fun channelsDeleteChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsDeleteChannel(channel))

    override fun channelsDeleteHistory(channel: TLAbsInputChannel, maxId: Int): Single<TLBool> = executeMethod(TLRequestChannelsDeleteHistory(channel, maxId))

    override fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): Single<TLAffectedMessages> = executeMethod(TLRequestChannelsDeleteMessages(channel, id))

    override fun channelsDeleteUserHistory(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLAffectedHistory> = executeMethod(TLRequestChannelsDeleteUserHistory(channel, userId))

    override fun channelsEditAbout(channel: TLAbsInputChannel, about: String): Single<TLBool> = executeMethod(TLRequestChannelsEditAbout(channel, about))

    override fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChannelAdminRights
    ): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditAdmin(channel, userId, adminRights))

    override fun channelsEditBanned(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            bannedRights: TLChannelBannedRights
    ): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditBanned(channel, userId, bannedRights))

    override fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditPhoto(channel, photo))

    override fun channelsEditTitle(channel: TLAbsInputChannel, title: String): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsEditTitle(channel, title))

    override fun channelsExportInvite(channel: TLAbsInputChannel): Single<TLAbsExportedChatInvite> = executeMethod(TLRequestChannelsExportInvite(channel))

    override fun channelsExportMessageLink(
            channel: TLAbsInputChannel,
            id: Int,
            grouped: Boolean
    ): Single<TLExportedMessageLink> = executeMethod(TLRequestChannelsExportMessageLink(channel, id, grouped))

    override fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): Single<TLAdminLogResults> = executeMethod(TLRequestChannelsGetAdminLog(channel, q, eventsFilter, admins, maxId, minId, limit))

    override fun channelsGetAdminedPublicChannels(): Single<TLAbsChats> = executeMethod(TLRequestChannelsGetAdminedPublicChannels())

    override fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): Single<TLAbsChats> = executeMethod(TLRequestChannelsGetChannels(id))

    override fun channelsGetFullChannel(channel: TLAbsInputChannel): Single<TLChatFull> = executeMethod(TLRequestChannelsGetFullChannel(channel))

    override fun channelsGetLeftChannels(offset: Int): Single<TLAbsChats> = executeMethod(TLRequestChannelsGetLeftChannels(offset))

    override fun channelsGetMessages(channel: TLAbsInputChannel, id: TLObjectVector<TLAbsInputMessage>): Single<TLAbsMessages> = executeMethod(TLRequestChannelsGetMessages(channel, id))

    override fun channelsGetParticipant(channel: TLAbsInputChannel, userId: TLAbsInputUser): Single<TLChannelParticipant> = executeMethod(TLRequestChannelsGetParticipant(channel, userId))

    override fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int,
            hash: Int
    ): Single<TLAbsChannelParticipants> = executeMethod(TLRequestChannelsGetParticipants(channel, filter, offset, limit, hash))

    override fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsInviteToChannel(channel, users))

    override fun channelsJoinChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsJoinChannel(channel))

    override fun channelsLeaveChannel(channel: TLAbsInputChannel): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsLeaveChannel(channel))

    override fun channelsReadHistory(channel: TLAbsInputChannel, maxId: Int): Single<TLBool> = executeMethod(TLRequestChannelsReadHistory(channel, maxId))

    override fun channelsReadMessageContents(channel: TLAbsInputChannel, id: TLIntVector): Single<TLBool> = executeMethod(TLRequestChannelsReadMessageContents(channel, id))

    override fun channelsReportSpam(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            id: TLIntVector
    ): Single<TLBool> = executeMethod(TLRequestChannelsReportSpam(channel, userId, id))

    override fun channelsSetStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): Single<TLBool> = executeMethod(TLRequestChannelsSetStickers(channel, stickerset))

    override fun channelsToggleInvites(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsToggleInvites(channel, enabled))

    override fun channelsTogglePreHistoryHidden(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsTogglePreHistoryHidden(channel, enabled))

    override fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsToggleSignatures(channel, enabled))

    override fun channelsUpdatePinnedMessage(
            silent: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): Single<TLAbsUpdates> = executeMethod(TLRequestChannelsUpdatePinnedMessage(silent, channel, id))

    override fun channelsUpdateUsername(channel: TLAbsInputChannel, username: String): Single<TLBool> = executeMethod(TLRequestChannelsUpdateUsername(channel, username))

    override fun contactsBlock(id: TLAbsInputUser): Single<TLBool> = executeMethod(TLRequestContactsBlock(id))

    override fun contactsDeleteContact(id: TLAbsInputUser): Single<TLLink> = executeMethod(TLRequestContactsDeleteContact(id))

    override fun contactsDeleteContacts(id: TLObjectVector<TLAbsInputUser>): Single<TLBool> = executeMethod(TLRequestContactsDeleteContacts(id))

    override fun contactsExportCard(): Single<TLIntVector> = executeMethod(TLRequestContactsExportCard())

    override fun contactsGetBlocked(offset: Int, limit: Int): Single<TLAbsBlocked> = executeMethod(TLRequestContactsGetBlocked(offset, limit))

    override fun contactsGetContacts(hash: Int): Single<TLAbsContacts> = executeMethod(TLRequestContactsGetContacts(hash))

    override fun contactsGetSaved(): Single<TLObjectVector<TLSavedPhoneContact>> = executeMethod(TLRequestContactsGetSaved())

    override fun contactsGetStatuses(): Single<TLObjectVector<TLContactStatus>> = executeMethod(TLRequestContactsGetStatuses())

    override fun contactsGetTopPeers(
            correspondents: Boolean,
            botsPm: Boolean,
            botsInline: Boolean,
            phoneCalls: Boolean,
            groups: Boolean,
            channels: Boolean,
            offset: Int,
            limit: Int,
            hash: Int
    ): Single<TLAbsTopPeers> = executeMethod(TLRequestContactsGetTopPeers(correspondents, botsPm, botsInline, phoneCalls, groups, channels, offset, limit, hash))

    override fun contactsImportCard(exportCard: TLIntVector): Single<TLAbsUser> = executeMethod(TLRequestContactsImportCard(exportCard))

    override fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): Single<TLImportedContacts> = executeMethod(TLRequestContactsImportContacts(contacts))

    override fun contactsResetSaved(): Single<TLBool> = executeMethod(TLRequestContactsResetSaved())

    override fun contactsResetTopPeerRating(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestContactsResetTopPeerRating(category, peer))

    override fun contactsResolveUsername(username: String): Single<TLResolvedPeer> = executeMethod(TLRequestContactsResolveUsername(username))

    override fun contactsSearch(q: String, limit: Int): Single<TLFound> = executeMethod(TLRequestContactsSearch(q, limit))

    override fun contactsToggleTopPeers(enabled: Boolean): Single<TLBool> = executeMethod(TLRequestContactsToggleTopPeers(enabled))

    override fun contactsUnblock(id: TLAbsInputUser): Single<TLBool> = executeMethod(TLRequestContactsUnblock(id))

    override fun helpAcceptTermsOfService(id: TLDataJSON): Single<TLBool> = executeMethod(TLRequestHelpAcceptTermsOfService(id))

    override fun helpGetAppChangelog(prevAppVersion: String): Single<TLAbsUpdates> = executeMethod(TLRequestHelpGetAppChangelog(prevAppVersion))

    override fun helpGetAppUpdate(): Single<TLAbsAppUpdate> = executeMethod(TLRequestHelpGetAppUpdate())

    override fun helpGetCdnConfig(): Single<TLCdnConfig> = executeMethod(TLRequestHelpGetCdnConfig())

    override fun helpGetConfig(): Single<TLConfig> = executeMethod(TLRequestHelpGetConfig())

    override fun helpGetDeepLinkInfo(path: String): Single<TLAbsDeepLinkInfo> = executeMethod(TLRequestHelpGetDeepLinkInfo(path))

    override fun helpGetInviteText(): Single<TLInviteText> = executeMethod(TLRequestHelpGetInviteText())

    override fun helpGetNearestDc(): Single<TLNearestDc> = executeMethod(TLRequestHelpGetNearestDc())

    override fun helpGetProxyData(): Single<TLAbsProxyData> = executeMethod(TLRequestHelpGetProxyData())

    override fun helpGetRecentMeUrls(referer: String): Single<TLRecentMeUrls> = executeMethod(TLRequestHelpGetRecentMeUrls(referer))

    override fun helpGetSupport(): Single<TLSupport> = executeMethod(TLRequestHelpGetSupport())

    override fun helpGetTermsOfServiceUpdate(): Single<TLAbsTermsOfServiceUpdate> = executeMethod(TLRequestHelpGetTermsOfServiceUpdate())

    override fun helpSaveAppLog(events: TLObjectVector<TLInputAppEvent>): Single<TLBool> = executeMethod(TLRequestHelpSaveAppLog(events))

    override fun helpSetBotUpdatesStatus(pendingUpdatesCount: Int, message: String): Single<TLBool> = executeMethod(TLRequestHelpSetBotUpdatesStatus(pendingUpdatesCount, message))

    override fun <T : TLObject> initConnection(
            apiId: Int,
            deviceModel: String,
            systemVersion: String,
            appVersion: String,
            systemLangCode: String,
            langPack: String,
            langCode: String,
            proxy: TLInputClientProxy?,
            query: TLMethod<T>?
    ): Single<T> = executeMethod(TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, systemLangCode, langPack, langCode, proxy, query))

    override fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeAfterMsg(msgId, query))

    override fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeAfterMsgs(msgIds, query))

    override fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeWithLayer(layer, query))

    override fun <T : TLObject> invokeWithMessagesRange(range: TLMessageRange, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeWithMessagesRange(range, query))

    override fun <T : TLObject> invokeWithTakeout(takeoutId: Long, query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeWithTakeout(takeoutId, query))

    override fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>?): Single<T> = executeMethod(TLRequestInvokeWithoutUpdates(query))

    override fun langpackGetDifference(fromVersion: Int): Single<TLLangPackDifference> = executeMethod(TLRequestLangpackGetDifference(fromVersion))

    override fun langpackGetLangPack(langCode: String): Single<TLLangPackDifference> = executeMethod(TLRequestLangpackGetLangPack(langCode))

    override fun langpackGetLanguages(): Single<TLObjectVector<TLLangPackLanguage>> = executeMethod(TLRequestLangpackGetLanguages())

    override fun langpackGetStrings(langCode: String, keys: TLStringVector): Single<TLObjectVector<TLAbsLangPackString>> = executeMethod(TLRequestLangpackGetStrings(langCode, keys))

    override fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): Single<TLAbsEncryptedChat> = executeMethod(TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint))

    override fun messagesAddChatUser(
            chatId: Int,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesAddChatUser(chatId, userId, fwdLimit))

    override fun messagesCheckChatInvite(hash: String): Single<TLAbsChatInvite> = executeMethod(TLRequestMessagesCheckChatInvite(hash))

    override fun messagesClearRecentStickers(attached: Boolean): Single<TLBool> = executeMethod(TLRequestMessagesClearRecentStickers(attached))

    override fun messagesCreateChat(users: TLObjectVector<TLAbsInputUser>, title: String): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesCreateChat(users, title))

    override fun messagesDeleteChatUser(chatId: Int, userId: TLAbsInputUser): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesDeleteChatUser(chatId, userId))

    override fun messagesDeleteHistory(
            justClear: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int
    ): Single<TLAffectedHistory> = executeMethod(TLRequestMessagesDeleteHistory(justClear, peer, maxId))

    override fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): Single<TLAffectedMessages> = executeMethod(TLRequestMessagesDeleteMessages(revoke, id))

    override fun messagesDiscardEncryption(chatId: Int): Single<TLBool> = executeMethod(TLRequestMessagesDiscardEncryption(chatId))

    override fun messagesEditChatAdmin(
            chatId: Int,
            userId: TLAbsInputUser,
            isAdmin: Boolean
    ): Single<TLBool> = executeMethod(TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin))

    override fun messagesEditChatPhoto(chatId: Int, photo: TLAbsInputChatPhoto): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesEditChatPhoto(chatId, photo))

    override fun messagesEditChatTitle(chatId: Int, title: String): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesEditChatTitle(chatId, title))

    override fun messagesEditInlineBotMessage(
            noWebpage: Boolean,
            stopGeoLive: Boolean,
            id: TLInputBotInlineMessageID,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            geoPoint: TLAbsInputGeoPoint?
    ): Single<TLBool> = executeMethod(TLRequestMessagesEditInlineBotMessage(noWebpage, stopGeoLive, id, message, media, replyMarkup, entities, geoPoint))

    override fun messagesEditMessage(
            noWebpage: Boolean,
            stopGeoLive: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            geoPoint: TLAbsInputGeoPoint?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesEditMessage(noWebpage, stopGeoLive, peer, id, message, media, replyMarkup, entities, geoPoint))

    override fun messagesExportChatInvite(chatId: Int): Single<TLAbsExportedChatInvite> = executeMethod(TLRequestMessagesExportChatInvite(chatId))

    override fun messagesFaveSticker(id: TLAbsInputDocument, unfave: Boolean): Single<TLBool> = executeMethod(TLRequestMessagesFaveSticker(id, unfave))

    override fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            grouped: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesForwardMessages(silent, background, withMyScore, grouped, fromPeer, id, randomId, toPeer))

    override fun messagesGetAllChats(exceptIds: TLIntVector): Single<TLAbsChats> = executeMethod(TLRequestMessagesGetAllChats(exceptIds))

    override fun messagesGetAllDrafts(): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesGetAllDrafts())

    override fun messagesGetAllStickers(hash: Int): Single<TLAbsAllStickers> = executeMethod(TLRequestMessagesGetAllStickers(hash))

    override fun messagesGetArchivedStickers(
            masks: Boolean,
            offsetId: Long,
            limit: Int
    ): Single<TLArchivedStickers> = executeMethod(TLRequestMessagesGetArchivedStickers(masks, offsetId, limit))

    override fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): Single<TLObjectVector<TLAbsStickerSetCovered>> = executeMethod(TLRequestMessagesGetAttachedStickers(media))

    override fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?
    ): Single<TLBotCallbackAnswer> = executeMethod(TLRequestMessagesGetBotCallbackAnswer(game, peer, msgId, data))

    override fun messagesGetChats(id: TLIntVector): Single<TLAbsChats> = executeMethod(TLRequestMessagesGetChats(id))

    override fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Int,
            limit: Int
    ): Single<TLAbsChats> = executeMethod(TLRequestMessagesGetCommonChats(userId, maxId, limit))

    override fun messagesGetDhConfig(version: Int, randomLength: Int): Single<TLAbsDhConfig> = executeMethod(TLRequestMessagesGetDhConfig(version, randomLength))

    override fun messagesGetDialogUnreadMarks(): Single<TLObjectVector<TLDialogPeer>> = executeMethod(TLRequestMessagesGetDialogUnreadMarks())

    override fun messagesGetDialogs(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int,
            hash: Int
    ): Single<TLAbsDialogs> = executeMethod(TLRequestMessagesGetDialogs(excludePinned, offsetDate, offsetId, offsetPeer, limit, hash))

    override fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Int,
            mimeType: String
    ): Single<TLAbsDocument> = executeMethod(TLRequestMessagesGetDocumentByHash(sha256, size, mimeType))

    override fun messagesGetFavedStickers(hash: Int): Single<TLAbsFavedStickers> = executeMethod(TLRequestMessagesGetFavedStickers(hash))

    override fun messagesGetFeaturedStickers(hash: Int): Single<TLAbsFeaturedStickers> = executeMethod(TLRequestMessagesGetFeaturedStickers(hash))

    override fun messagesGetFullChat(chatId: Int): Single<TLChatFull> = executeMethod(TLRequestMessagesGetFullChat(chatId))

    override fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): Single<TLHighScores> = executeMethod(TLRequestMessagesGetGameHighScores(peer, id, userId))

    override fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Int
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId, hash))

    override fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): Single<TLBotResults> = executeMethod(TLRequestMessagesGetInlineBotResults(bot, peer, geoPoint, query, offset))

    override fun messagesGetInlineGameHighScores(id: TLInputBotInlineMessageID, userId: TLAbsInputUser): Single<TLHighScores> = executeMethod(TLRequestMessagesGetInlineGameHighScores(id, userId))

    override fun messagesGetMaskStickers(hash: Int): Single<TLAbsAllStickers> = executeMethod(TLRequestMessagesGetMaskStickers(hash))

    override fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): Single<TLMessageEditData> = executeMethod(TLRequestMessagesGetMessageEditData(peer, id))

    override fun messagesGetMessages(id: TLObjectVector<TLAbsInputMessage>): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetMessages(id))

    override fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): Single<TLIntVector> = executeMethod(TLRequestMessagesGetMessagesViews(peer, id, increment))

    override fun messagesGetPeerDialogs(peers: TLObjectVector<TLInputDialogPeer>): Single<TLPeerDialogs> = executeMethod(TLRequestMessagesGetPeerDialogs(peers))

    override fun messagesGetPeerSettings(peer: TLAbsInputPeer): Single<TLPeerSettings> = executeMethod(TLRequestMessagesGetPeerSettings(peer))

    override fun messagesGetPinnedDialogs(): Single<TLPeerDialogs> = executeMethod(TLRequestMessagesGetPinnedDialogs())

    override fun messagesGetRecentLocations(
            peer: TLAbsInputPeer,
            limit: Int,
            hash: Int
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetRecentLocations(peer, limit, hash))

    override fun messagesGetRecentStickers(attached: Boolean, hash: Int): Single<TLAbsRecentStickers> = executeMethod(TLRequestMessagesGetRecentStickers(attached, hash))

    override fun messagesGetSavedGifs(hash: Int): Single<TLAbsSavedGifs> = executeMethod(TLRequestMessagesGetSavedGifs(hash))

    override fun messagesGetSplitRanges(): Single<TLObjectVector<TLMessageRange>> = executeMethod(TLRequestMessagesGetSplitRanges())

    override fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet): Single<TLStickerSet> = executeMethod(TLRequestMessagesGetStickerSet(stickerset))

    override fun messagesGetStickers(emoticon: String, hash: Int): Single<TLAbsStickers> = executeMethod(TLRequestMessagesGetStickers(emoticon, hash))

    override fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesGetUnreadMentions(peer, offsetId, addOffset, limit, maxId, minId))

    override fun messagesGetWebPage(url: String, hash: Int): Single<TLAbsWebPage> = executeMethod(TLRequestMessagesGetWebPage(url, hash))

    override fun messagesGetWebPagePreview(message: String, entities: TLObjectVector<TLAbsMessageEntity>?): Single<TLAbsMessageMedia> = executeMethod(TLRequestMessagesGetWebPagePreview(message, entities))

    override fun messagesHideReportSpam(peer: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestMessagesHideReportSpam(peer))

    override fun messagesImportChatInvite(hash: String): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesImportChatInvite(hash))

    override fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): Single<TLAbsStickerSetInstallResult> = executeMethod(TLRequestMessagesInstallStickerSet(stickerset, archived))

    override fun messagesMarkDialogUnread(unread: Boolean, peer: TLInputDialogPeer): Single<TLBool> = executeMethod(TLRequestMessagesMarkDialogUnread(unread, peer))

    override fun messagesMigrateChat(chatId: Int): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesMigrateChat(chatId))

    override fun messagesReadEncryptedHistory(peer: TLInputEncryptedChat, maxDate: Int): Single<TLBool> = executeMethod(TLRequestMessagesReadEncryptedHistory(peer, maxDate))

    override fun messagesReadFeaturedStickers(id: TLLongVector): Single<TLBool> = executeMethod(TLRequestMessagesReadFeaturedStickers(id))

    override fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): Single<TLAffectedMessages> = executeMethod(TLRequestMessagesReadHistory(peer, maxId))

    override fun messagesReadMentions(peer: TLAbsInputPeer): Single<TLAffectedHistory> = executeMethod(TLRequestMessagesReadMentions(peer))

    override fun messagesReadMessageContents(id: TLIntVector): Single<TLAffectedMessages> = executeMethod(TLRequestMessagesReadMessageContents(id))

    override fun messagesReceivedMessages(maxId: Int): Single<TLObjectVector<TLReceivedNotifyMessage>> = executeMethod(TLRequestMessagesReceivedMessages(maxId))

    override fun messagesReceivedQueue(maxQts: Int): Single<TLLongVector> = executeMethod(TLRequestMessagesReceivedQueue(maxQts))

    override fun messagesReorderPinnedDialogs(force: Boolean, order: TLObjectVector<TLInputDialogPeer>): Single<TLBool> = executeMethod(TLRequestMessagesReorderPinnedDialogs(force, order))

    override fun messagesReorderStickerSets(masks: Boolean, order: TLLongVector): Single<TLBool> = executeMethod(TLRequestMessagesReorderStickerSets(masks, order))

    override fun messagesReport(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            reason: TLAbsReportReason
    ): Single<TLBool> = executeMethod(TLRequestMessagesReport(peer, id, reason))

    override fun messagesReportEncryptedSpam(peer: TLInputEncryptedChat): Single<TLBool> = executeMethod(TLRequestMessagesReportEncryptedSpam(peer))

    override fun messagesReportSpam(peer: TLAbsInputPeer): Single<TLBool> = executeMethod(TLRequestMessagesReportSpam(peer))

    override fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): Single<TLAbsEncryptedChat> = executeMethod(TLRequestMessagesRequestEncryption(userId, randomId, gA))

    override fun messagesSaveDraft(
            noWebpage: Boolean,
            replyToMsgId: Int?,
            peer: TLAbsInputPeer,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLBool> = executeMethod(TLRequestMessagesSaveDraft(noWebpage, replyToMsgId, peer, message, entities))

    override fun messagesSaveGif(id: TLAbsInputDocument, unsave: Boolean): Single<TLBool> = executeMethod(TLRequestMessagesSaveGif(id, unsave))

    override fun messagesSaveRecentSticker(
            attached: Boolean,
            id: TLAbsInputDocument,
            unsave: Boolean
    ): Single<TLBool> = executeMethod(TLRequestMessagesSaveRecentSticker(attached, id, unsave))

    override fun messagesSearch(
            peer: TLAbsInputPeer,
            q: String,
            fromId: TLAbsInputUser?,
            filter: TLAbsMessagesFilter,
            minDate: Int,
            maxDate: Int,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Int
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesSearch(peer, q, fromId, filter, minDate, maxDate, offsetId, addOffset, limit, maxId, minId, hash))

    override fun messagesSearchGifs(q: String, offset: Int): Single<TLFoundGifs> = executeMethod(TLRequestMessagesSearchGifs(q, offset))

    override fun messagesSearchGlobal(
            q: String,
            offsetDate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): Single<TLAbsMessages> = executeMethod(TLRequestMessagesSearchGlobal(q, offsetDate, offsetPeer, offsetId, limit))

    override fun messagesSearchStickerSets(
            excludeFeatured: Boolean,
            q: String,
            hash: Int
    ): Single<TLAbsFoundStickerSets> = executeMethod(TLRequestMessagesSearchStickerSets(excludeFeatured, q, hash))

    override fun messagesSendEncrypted(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage> = executeMethod(TLRequestMessagesSendEncrypted(peer, randomId, data))

    override fun messagesSendEncryptedFile(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): Single<TLAbsSentEncryptedMessage> = executeMethod(TLRequestMessagesSendEncryptedFile(peer, randomId, data, file))

    override fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): Single<TLAbsSentEncryptedMessage> = executeMethod(TLRequestMessagesSendEncryptedService(peer, randomId, data))

    override fun messagesSendInlineBotResult(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            randomId: Long,
            queryId: Long,
            id: String
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendInlineBotResult(silent, background, clearDraft, peer, replyToMsgId, randomId, queryId, id))

    override fun messagesSendMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            media: TLAbsInputMedia,
            message: String,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendMedia(silent, background, clearDraft, peer, replyToMsgId, media, message, randomId, replyMarkup, entities))

    override fun messagesSendMessage(
            noWebpage: Boolean,
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            message: String,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendMessage(noWebpage, silent, background, clearDraft, peer, replyToMsgId, message, randomId, replyMarkup, entities))

    override fun messagesSendMultiMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            multiMedia: TLObjectVector<TLInputSingleMedia>
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendMultiMedia(silent, background, clearDraft, peer, replyToMsgId, multiMedia))

    override fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyToMsgId: Int,
            randomId: Long
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSendScreenshotNotification(peer, replyToMsgId, randomId))

    override fun messagesSetBotCallbackAnswer(
            alert: Boolean,
            queryId: Long,
            message: String?,
            url: String?,
            cacheTime: Int
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetBotCallbackAnswer(alert, queryId, message, url, cacheTime))

    override fun messagesSetBotPrecheckoutResults(
            success: Boolean,
            queryId: Long,
            error: String?
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetBotPrecheckoutResults(success, queryId, error))

    override fun messagesSetBotShippingResults(
            queryId: Long,
            error: String?,
            shippingOptions: TLObjectVector<TLShippingOption>?
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetBotShippingResults(queryId, error, shippingOptions))

    override fun messagesSetEncryptedTyping(peer: TLInputEncryptedChat, typing: Boolean): Single<TLBool> = executeMethod(TLRequestMessagesSetEncryptedTyping(peer, typing))

    override fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesSetGameScore(editMessage, force, peer, id, userId, score))

    override fun messagesSetInlineBotResults(
            gallery: Boolean,
            _private: Boolean,
            queryId: Long,
            results: TLObjectVector<TLAbsInputBotInlineResult>,
            cacheTime: Int,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetInlineBotResults(gallery, _private, queryId, results, cacheTime, nextOffset, switchPm))

    override fun messagesSetInlineGameScore(
            editMessage: Boolean,
            force: Boolean,
            id: TLInputBotInlineMessageID,
            userId: TLAbsInputUser,
            score: Int
    ): Single<TLBool> = executeMethod(TLRequestMessagesSetInlineGameScore(editMessage, force, id, userId, score))

    override fun messagesSetTyping(peer: TLAbsInputPeer, action: TLAbsSendMessageAction): Single<TLBool> = executeMethod(TLRequestMessagesSetTyping(peer, action))

    override fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesStartBot(bot, peer, randomId, startParam))

    override fun messagesToggleChatAdmins(chatId: Int, enabled: Boolean): Single<TLAbsUpdates> = executeMethod(TLRequestMessagesToggleChatAdmins(chatId, enabled))

    override fun messagesToggleDialogPin(pinned: Boolean, peer: TLInputDialogPeer): Single<TLBool> = executeMethod(TLRequestMessagesToggleDialogPin(pinned, peer))

    override fun messagesUninstallStickerSet(stickerset: TLAbsInputStickerSet): Single<TLBool> = executeMethod(TLRequestMessagesUninstallStickerSet(stickerset))

    override fun messagesUploadEncryptedFile(peer: TLInputEncryptedChat, file: TLAbsInputEncryptedFile): Single<TLAbsEncryptedFile> = executeMethod(TLRequestMessagesUploadEncryptedFile(peer, file))

    override fun messagesUploadMedia(peer: TLAbsInputPeer, media: TLAbsInputMedia): Single<TLAbsMessageMedia> = executeMethod(TLRequestMessagesUploadMedia(peer, media))

    override fun paymentsClearSavedInfo(credentials: Boolean, info: Boolean): Single<TLBool> = executeMethod(TLRequestPaymentsClearSavedInfo(credentials, info))

    override fun paymentsGetPaymentForm(msgId: Int): Single<TLPaymentForm> = executeMethod(TLRequestPaymentsGetPaymentForm(msgId))

    override fun paymentsGetPaymentReceipt(msgId: Int): Single<TLPaymentReceipt> = executeMethod(TLRequestPaymentsGetPaymentReceipt(msgId))

    override fun paymentsGetSavedInfo(): Single<TLSavedInfo> = executeMethod(TLRequestPaymentsGetSavedInfo())

    override fun paymentsSendPaymentForm(
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials
    ): Single<TLAbsPaymentResult> = executeMethod(TLRequestPaymentsSendPaymentForm(msgId, requestedInfoId, shippingOptionId, credentials))

    override fun paymentsValidateRequestedInfo(
            save: Boolean,
            msgId: Int,
            info: TLPaymentRequestedInfo
    ): Single<TLValidatedRequestedInfo> = executeMethod(TLRequestPaymentsValidateRequestedInfo(save, msgId, info))

    override fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeMethod(TLRequestPhoneAcceptCall(peer, gB, protocol))

    override fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeMethod(TLRequestPhoneConfirmCall(peer, gA, keyFingerprint, protocol))

    override fun phoneDiscardCall(
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneDiscardCall(peer, duration, reason, connectionId))

    override fun phoneGetCallConfig(): Single<TLDataJSON> = executeMethod(TLRequestPhoneGetCallConfig())

    override fun phoneReceivedCall(peer: TLInputPhoneCall): Single<TLBool> = executeMethod(TLRequestPhoneReceivedCall(peer))

    override fun phoneRequestCall(
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): Single<TLPhoneCall> = executeMethod(TLRequestPhoneRequestCall(userId, randomId, gAHash, protocol))

    override fun phoneSaveCallDebug(peer: TLInputPhoneCall, debug: TLDataJSON): Single<TLBool> = executeMethod(TLRequestPhoneSaveCallDebug(peer, debug))

    override fun phoneSetCallRating(
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): Single<TLAbsUpdates> = executeMethod(TLRequestPhoneSetCallRating(peer, rating, comment))

    override fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): Single<TLLongVector> = executeMethod(TLRequestPhotosDeletePhotos(id))

    override fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): Single<TLAbsPhotos> = executeMethod(TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit))

    override fun photosUpdateProfilePhoto(id: TLAbsInputPhoto): Single<TLAbsUserProfilePhoto> = executeMethod(TLRequestPhotosUpdateProfilePhoto(id))

    override fun photosUploadProfilePhoto(file: TLAbsInputFile): Single<TLPhoto> = executeMethod(TLRequestPhotosUploadProfilePhoto(file))

    override fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): Single<TLStickerSet> = executeMethod(TLRequestStickersAddStickerToSet(stickerset, sticker))

    override fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): Single<TLStickerSet> = executeMethod(TLRequestStickersChangeStickerPosition(sticker, position))

    override fun stickersCreateStickerSet(
            masks: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            stickers: TLObjectVector<TLInputStickerSetItem>
    ): Single<TLStickerSet> = executeMethod(TLRequestStickersCreateStickerSet(masks, userId, title, shortName, stickers))

    override fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): Single<TLStickerSet> = executeMethod(TLRequestStickersRemoveStickerFromSet(sticker))

    override fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): Single<TLAbsChannelDifference> = executeMethod(TLRequestUpdatesGetChannelDifference(force, channel, filter, pts, limit))

    override fun updatesGetDifference(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ): Single<TLAbsDifference> = executeMethod(TLRequestUpdatesGetDifference(pts, ptsTotalLimit, date, qts))

    override fun updatesGetState(): Single<TLState> = executeMethod(TLRequestUpdatesGetState())

    override fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Int,
            limit: Int
    ): Single<TLAbsCdnFile> = executeMethod(TLRequestUploadGetCdnFile(fileToken, offset, limit))

    override fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Int): Single<TLObjectVector<TLFileHash>> = executeMethod(TLRequestUploadGetCdnFileHashes(fileToken, offset))

    override fun uploadGetFile(
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLAbsFile> = executeMethod(TLRequestUploadGetFile(location, offset, limit))

    override fun uploadGetFileHashes(location: TLAbsInputFileLocation, offset: Int): Single<TLObjectVector<TLFileHash>> = executeMethod(TLRequestUploadGetFileHashes(location, offset))

    override fun uploadGetWebFile(
            location: TLAbsInputWebFileLocation,
            offset: Int,
            limit: Int
    ): Single<TLWebFile> = executeMethod(TLRequestUploadGetWebFile(location, offset, limit))

    override fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): Single<TLObjectVector<TLFileHash>> = executeMethod(TLRequestUploadReuploadCdnFile(fileToken, requestToken))

    override fun uploadSaveBigFilePart(
            fileId: Long,
            filePart: Int,
            fileTotalParts: Int,
            bytes: TLBytes
    ): Single<TLBool> = executeMethod(TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes))

    override fun uploadSaveFilePart(
            fileId: Long,
            filePart: Int,
            bytes: TLBytes
    ): Single<TLBool> = executeMethod(TLRequestUploadSaveFilePart(fileId, filePart, bytes))

    override fun usersGetFullUser(id: TLAbsInputUser): Single<TLUserFull> = executeMethod(TLRequestUsersGetFullUser(id))

    override fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): Single<TLObjectVector<TLAbsUser>> = executeMethod(TLRequestUsersGetUsers(id))

    override fun usersSetSecureValueErrors(id: TLAbsInputUser, errors: TLObjectVector<TLAbsSecureValueError>): Single<TLBool> = executeMethod(TLRequestUsersSetSecureValueErrors(id, errors))
}
