package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.RpcQuerySyncExecutor
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
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.IOException
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

abstract class TelegramSyncApiWrapper : TelegramSyncApi, RpcQuerySyncExecutor {
    @Throws(RpcErrorException::class, IOException::class)
    override fun accountAcceptAuthorization(
            botId: Int,
            scope: String,
            publicKey: String,
            valueHashes: TLObjectVector<TLSecureValueHash>,
            credentials: TLSecureCredentialsEncrypted
    ): TLBool = executeMethod(TLRequestAccountAcceptAuthorization(botId, scope, publicKey, valueHashes, credentials))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountChangePhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): TLAbsUser = executeMethod(TLRequestAccountChangePhone(phoneNumber, phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountCheckUsername(username: String): TLBool = executeMethod(TLRequestAccountCheckUsername(username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountConfirmPhone(phoneCodeHash: String, phoneCode: String): TLBool = executeMethod(TLRequestAccountConfirmPhone(phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountDeleteAccount(reason: String): TLBool = executeMethod(TLRequestAccountDeleteAccount(reason))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountDeleteSecureValue(types: TLObjectVector<TLAbsSecureValueType>): TLBool = executeMethod(TLRequestAccountDeleteSecureValue(types))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountFinishTakeoutSession(success: Boolean): TLBool = executeMethod(TLRequestAccountFinishTakeoutSession(success))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAccountTTL(): TLAccountDaysTTL = executeMethod(TLRequestAccountGetAccountTTL())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAllSecureValues(): TLObjectVector<TLSecureValue> = executeMethod(TLRequestAccountGetAllSecureValues())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAuthorizationForm(
            botId: Int,
            scope: String,
            publicKey: String
    ): TLAuthorizationForm = executeMethod(TLRequestAccountGetAuthorizationForm(botId, scope, publicKey))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetAuthorizations(): TLAuthorizations = executeMethod(TLRequestAccountGetAuthorizations())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetNotifySettings(peer: TLAbsInputNotifyPeer): TLPeerNotifySettings = executeMethod(TLRequestAccountGetNotifySettings(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetPassword(): TLAbsPassword = executeMethod(TLRequestAccountGetPassword())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetPasswordSettings(currentPasswordHash: TLBytes): TLPasswordSettings = executeMethod(TLRequestAccountGetPasswordSettings(currentPasswordHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetPrivacy(key: TLAbsInputPrivacyKey): TLPrivacyRules = executeMethod(TLRequestAccountGetPrivacy(key))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetSecureValue(types: TLObjectVector<TLAbsSecureValueType>): TLObjectVector<TLSecureValue> = executeMethod(TLRequestAccountGetSecureValue(types))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetTmpPassword(passwordHash: TLBytes, period: Int): TLTmpPassword = executeMethod(TLRequestAccountGetTmpPassword(passwordHash, period))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetWallPapers(): TLObjectVector<TLAbsWallPaper> = executeMethod(TLRequestAccountGetWallPapers())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountGetWebAuthorizations(): TLWebAuthorizations = executeMethod(TLRequestAccountGetWebAuthorizations())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountInitTakeoutSession(
            contacts: Boolean,
            messageUsers: Boolean,
            messageChats: Boolean,
            messageMegagroups: Boolean,
            messageChannels: Boolean,
            files: Boolean,
            fileMaxSize: Int?
    ): TLTakeout = executeMethod(TLRequestAccountInitTakeoutSession(contacts, messageUsers, messageChats, messageMegagroups, messageChannels, files, fileMaxSize))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountRegisterDevice(
            tokenType: Int,
            token: String,
            appSandbox: Boolean,
            secret: TLBytes,
            otherUids: TLIntVector
    ): TLBool = executeMethod(TLRequestAccountRegisterDevice(tokenType, token, appSandbox, secret, otherUids))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountReportPeer(peer: TLAbsInputPeer, reason: TLAbsReportReason): TLBool = executeMethod(TLRequestAccountReportPeer(peer, reason))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetAuthorization(hash: Long): TLBool = executeMethod(TLRequestAccountResetAuthorization(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetNotifySettings(): TLBool = executeMethod(TLRequestAccountResetNotifySettings())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetWebAuthorization(hash: Long): TLBool = executeMethod(TLRequestAccountResetWebAuthorization(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountResetWebAuthorizations(): TLBool = executeMethod(TLRequestAccountResetWebAuthorizations())

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSaveSecureValue(value: TLInputSecureValue, secureSecretId: Long): TLSecureValue = executeMethod(TLRequestAccountSaveSecureValue(value, secureSecretId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSendChangePhoneCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?
    ): TLSentCode = executeMethod(TLRequestAccountSendChangePhoneCode(allowFlashcall, phoneNumber, currentNumber))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSendConfirmPhoneCode(
            allowFlashcall: Boolean,
            hash: String,
            currentNumber: Boolean?
    ): TLSentCode = executeMethod(TLRequestAccountSendConfirmPhoneCode(allowFlashcall, hash, currentNumber))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSendVerifyEmailCode(email: String): TLSentEmailCode = executeMethod(TLRequestAccountSendVerifyEmailCode(email))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSendVerifyPhoneCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?
    ): TLSentCode = executeMethod(TLRequestAccountSendVerifyPhoneCode(allowFlashcall, phoneNumber, currentNumber))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetAccountTTL(ttl: TLAccountDaysTTL): TLBool = executeMethod(TLRequestAccountSetAccountTTL(ttl))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountSetPrivacy(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>): TLPrivacyRules = executeMethod(TLRequestAccountSetPrivacy(key, rules))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUnregisterDevice(
            tokenType: Int,
            token: String,
            otherUids: TLIntVector
    ): TLBool = executeMethod(TLRequestAccountUnregisterDevice(tokenType, token, otherUids))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateDeviceLocked(period: Int): TLBool = executeMethod(TLRequestAccountUpdateDeviceLocked(period))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateNotifySettings(peer: TLAbsInputNotifyPeer, settings: TLInputPeerNotifySettings): TLBool = executeMethod(TLRequestAccountUpdateNotifySettings(peer, settings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdatePasswordSettings(currentPasswordHash: TLBytes, newSettings: TLPasswordInputSettings): TLBool = executeMethod(TLRequestAccountUpdatePasswordSettings(currentPasswordHash, newSettings))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateProfile(
            firstName: String?,
            lastName: String?,
            about: String?
    ): TLAbsUser = executeMethod(TLRequestAccountUpdateProfile(firstName, lastName, about))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateStatus(offline: Boolean): TLBool = executeMethod(TLRequestAccountUpdateStatus(offline))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountUpdateUsername(username: String): TLAbsUser = executeMethod(TLRequestAccountUpdateUsername(username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountVerifyEmail(email: String, code: String): TLBool = executeMethod(TLRequestAccountVerifyEmail(email, code))

    @Throws(RpcErrorException::class, IOException::class)
    override fun accountVerifyPhone(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): TLBool = executeMethod(TLRequestAccountVerifyPhone(phoneNumber, phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authBindTempAuthKey(
            permAuthKeyId: Long,
            nonce: Long,
            expiresAt: Int,
            encryptedMessage: TLBytes
    ): TLBool = executeMethod(TLRequestAuthBindTempAuthKey(permAuthKeyId, nonce, expiresAt, encryptedMessage))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authCancelCode(phoneNumber: String, phoneCodeHash: String): TLBool = executeMethod(TLRequestAuthCancelCode(phoneNumber, phoneCodeHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authCheckPassword(passwordHash: TLBytes): TLAuthorization = executeMethod(TLRequestAuthCheckPassword(passwordHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authDropTempAuthKeys(exceptAuthKeys: TLLongVector): TLBool = executeMethod(TLRequestAuthDropTempAuthKeys(exceptAuthKeys))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authExportAuthorization(dcId: Int): TLExportedAuthorization = executeMethod(TLRequestAuthExportAuthorization(dcId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authImportAuthorization(id: Int, bytes: TLBytes): TLAuthorization = executeMethod(TLRequestAuthImportAuthorization(id, bytes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authImportBotAuthorization(
            flags: Int,
            apiId: Int,
            apiHash: String,
            botAuthToken: String
    ): TLAuthorization = executeMethod(TLRequestAuthImportBotAuthorization(flags, apiId, apiHash, botAuthToken))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authLogOut(): TLBool = executeMethod(TLRequestAuthLogOut())

    @Throws(RpcErrorException::class, IOException::class)
    override fun authRecoverPassword(code: String): TLAuthorization = executeMethod(TLRequestAuthRecoverPassword(code))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authRequestPasswordRecovery(): TLPasswordRecovery = executeMethod(TLRequestAuthRequestPasswordRecovery())

    @Throws(RpcErrorException::class, IOException::class)
    override fun authResendCode(phoneNumber: String, phoneCodeHash: String): TLSentCode = executeMethod(TLRequestAuthResendCode(phoneNumber, phoneCodeHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authResetAuthorizations(): TLBool = executeMethod(TLRequestAuthResetAuthorizations())

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSendCode(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?,
            apiId: Int,
            apiHash: String
    ): TLSentCode = executeMethod(TLRequestAuthSendCode(allowFlashcall, phoneNumber, currentNumber, apiId, apiHash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSignIn(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String
    ): TLAuthorization = executeMethod(TLRequestAuthSignIn(phoneNumber, phoneCodeHash, phoneCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun authSignUp(
            phoneNumber: String,
            phoneCodeHash: String,
            phoneCode: String,
            firstName: String,
            lastName: String
    ): TLAuthorization = executeMethod(TLRequestAuthSignUp(phoneNumber, phoneCodeHash, phoneCode, firstName, lastName))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsAnswerWebhookJSONQuery(queryId: Long, data: TLDataJSON): TLBool = executeMethod(TLRequestBotsAnswerWebhookJSONQuery(queryId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun botsSendCustomRequest(customMethod: String, params: TLDataJSON): TLDataJSON = executeMethod(TLRequestBotsSendCustomRequest(customMethod, params))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsCheckUsername(channel: TLAbsInputChannel, username: String): TLBool = executeMethod(TLRequestChannelsCheckUsername(channel, username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsCreateChannel(
            broadcast: Boolean,
            megagroup: Boolean,
            title: String,
            about: String
    ): TLAbsUpdates = executeMethod(TLRequestChannelsCreateChannel(broadcast, megagroup, title, about))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteChannel(channel: TLAbsInputChannel): TLAbsUpdates = executeMethod(TLRequestChannelsDeleteChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteHistory(channel: TLAbsInputChannel, maxId: Int): TLBool = executeMethod(TLRequestChannelsDeleteHistory(channel, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteMessages(channel: TLAbsInputChannel, id: TLIntVector): TLAffectedMessages = executeMethod(TLRequestChannelsDeleteMessages(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsDeleteUserHistory(channel: TLAbsInputChannel, userId: TLAbsInputUser): TLAffectedHistory = executeMethod(TLRequestChannelsDeleteUserHistory(channel, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditAbout(channel: TLAbsInputChannel, about: String): TLBool = executeMethod(TLRequestChannelsEditAbout(channel, about))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditAdmin(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            adminRights: TLChannelAdminRights
    ): TLAbsUpdates = executeMethod(TLRequestChannelsEditAdmin(channel, userId, adminRights))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditBanned(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            bannedRights: TLChannelBannedRights
    ): TLAbsUpdates = executeMethod(TLRequestChannelsEditBanned(channel, userId, bannedRights))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditPhoto(channel: TLAbsInputChannel, photo: TLAbsInputChatPhoto): TLAbsUpdates = executeMethod(TLRequestChannelsEditPhoto(channel, photo))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsEditTitle(channel: TLAbsInputChannel, title: String): TLAbsUpdates = executeMethod(TLRequestChannelsEditTitle(channel, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsExportInvite(channel: TLAbsInputChannel): TLAbsExportedChatInvite = executeMethod(TLRequestChannelsExportInvite(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsExportMessageLink(
            channel: TLAbsInputChannel,
            id: Int,
            grouped: Boolean
    ): TLExportedMessageLink = executeMethod(TLRequestChannelsExportMessageLink(channel, id, grouped))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetAdminLog(
            channel: TLAbsInputChannel,
            q: String,
            eventsFilter: TLChannelAdminLogEventsFilter?,
            admins: TLObjectVector<TLAbsInputUser>?,
            maxId: Long,
            minId: Long,
            limit: Int
    ): TLAdminLogResults = executeMethod(TLRequestChannelsGetAdminLog(channel, q, eventsFilter, admins, maxId, minId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetAdminedPublicChannels(): TLAbsChats = executeMethod(TLRequestChannelsGetAdminedPublicChannels())

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetChannels(id: TLObjectVector<TLAbsInputChannel>): TLAbsChats = executeMethod(TLRequestChannelsGetChannels(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetFullChannel(channel: TLAbsInputChannel): TLChatFull = executeMethod(TLRequestChannelsGetFullChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetLeftChannels(offset: Int): TLAbsChats = executeMethod(TLRequestChannelsGetLeftChannels(offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetMessages(channel: TLAbsInputChannel, id: TLObjectVector<TLAbsInputMessage>): TLAbsMessages = executeMethod(TLRequestChannelsGetMessages(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetParticipant(channel: TLAbsInputChannel, userId: TLAbsInputUser): TLChannelParticipant = executeMethod(TLRequestChannelsGetParticipant(channel, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsGetParticipants(
            channel: TLAbsInputChannel,
            filter: TLAbsChannelParticipantsFilter,
            offset: Int,
            limit: Int,
            hash: Int
    ): TLAbsChannelParticipants = executeMethod(TLRequestChannelsGetParticipants(channel, filter, offset, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsInviteToChannel(channel: TLAbsInputChannel, users: TLObjectVector<TLAbsInputUser>): TLAbsUpdates = executeMethod(TLRequestChannelsInviteToChannel(channel, users))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsJoinChannel(channel: TLAbsInputChannel): TLAbsUpdates = executeMethod(TLRequestChannelsJoinChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsLeaveChannel(channel: TLAbsInputChannel): TLAbsUpdates = executeMethod(TLRequestChannelsLeaveChannel(channel))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReadHistory(channel: TLAbsInputChannel, maxId: Int): TLBool = executeMethod(TLRequestChannelsReadHistory(channel, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReadMessageContents(channel: TLAbsInputChannel, id: TLIntVector): TLBool = executeMethod(TLRequestChannelsReadMessageContents(channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsReportSpam(
            channel: TLAbsInputChannel,
            userId: TLAbsInputUser,
            id: TLIntVector
    ): TLBool = executeMethod(TLRequestChannelsReportSpam(channel, userId, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsSetStickers(channel: TLAbsInputChannel, stickerset: TLAbsInputStickerSet): TLBool = executeMethod(TLRequestChannelsSetStickers(channel, stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleInvites(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsToggleInvites(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsTogglePreHistoryHidden(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsTogglePreHistoryHidden(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsToggleSignatures(channel: TLAbsInputChannel, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestChannelsToggleSignatures(channel, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsUpdatePinnedMessage(
            silent: Boolean,
            channel: TLAbsInputChannel,
            id: Int
    ): TLAbsUpdates = executeMethod(TLRequestChannelsUpdatePinnedMessage(silent, channel, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun channelsUpdateUsername(channel: TLAbsInputChannel, username: String): TLBool = executeMethod(TLRequestChannelsUpdateUsername(channel, username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsBlock(id: TLAbsInputUser): TLBool = executeMethod(TLRequestContactsBlock(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsDeleteContact(id: TLAbsInputUser): TLLink = executeMethod(TLRequestContactsDeleteContact(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsDeleteContacts(id: TLObjectVector<TLAbsInputUser>): TLBool = executeMethod(TLRequestContactsDeleteContacts(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsExportCard(): TLIntVector = executeMethod(TLRequestContactsExportCard())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetBlocked(offset: Int, limit: Int): TLAbsBlocked = executeMethod(TLRequestContactsGetBlocked(offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetContacts(hash: Int): TLAbsContacts = executeMethod(TLRequestContactsGetContacts(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetSaved(): TLObjectVector<TLSavedPhoneContact> = executeMethod(TLRequestContactsGetSaved())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsGetStatuses(): TLObjectVector<TLContactStatus> = executeMethod(TLRequestContactsGetStatuses())

    @Throws(RpcErrorException::class, IOException::class)
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
    ): TLAbsTopPeers = executeMethod(TLRequestContactsGetTopPeers(correspondents, botsPm, botsInline, phoneCalls, groups, channels, offset, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsImportCard(exportCard: TLIntVector): TLAbsUser = executeMethod(TLRequestContactsImportCard(exportCard))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsImportContacts(contacts: TLObjectVector<TLInputPhoneContact>): TLImportedContacts = executeMethod(TLRequestContactsImportContacts(contacts))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResetSaved(): TLBool = executeMethod(TLRequestContactsResetSaved())

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResetTopPeerRating(category: TLAbsTopPeerCategory, peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestContactsResetTopPeerRating(category, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsResolveUsername(username: String): TLResolvedPeer = executeMethod(TLRequestContactsResolveUsername(username))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsSearch(q: String, limit: Int): TLFound = executeMethod(TLRequestContactsSearch(q, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsToggleTopPeers(enabled: Boolean): TLBool = executeMethod(TLRequestContactsToggleTopPeers(enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun contactsUnblock(id: TLAbsInputUser): TLBool = executeMethod(TLRequestContactsUnblock(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpAcceptTermsOfService(id: TLDataJSON): TLBool = executeMethod(TLRequestHelpAcceptTermsOfService(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetAppChangelog(prevAppVersion: String): TLAbsUpdates = executeMethod(TLRequestHelpGetAppChangelog(prevAppVersion))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetAppUpdate(): TLAbsAppUpdate = executeMethod(TLRequestHelpGetAppUpdate())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetCdnConfig(): TLCdnConfig = executeMethod(TLRequestHelpGetCdnConfig())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetConfig(): TLConfig = executeMethod(TLRequestHelpGetConfig())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetDeepLinkInfo(path: String): TLAbsDeepLinkInfo = executeMethod(TLRequestHelpGetDeepLinkInfo(path))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetInviteText(): TLInviteText = executeMethod(TLRequestHelpGetInviteText())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetNearestDc(): TLNearestDc = executeMethod(TLRequestHelpGetNearestDc())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetProxyData(): TLAbsProxyData = executeMethod(TLRequestHelpGetProxyData())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetRecentMeUrls(referer: String): TLRecentMeUrls = executeMethod(TLRequestHelpGetRecentMeUrls(referer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetSupport(): TLSupport = executeMethod(TLRequestHelpGetSupport())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpGetTermsOfServiceUpdate(): TLAbsTermsOfServiceUpdate = executeMethod(TLRequestHelpGetTermsOfServiceUpdate())

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpSaveAppLog(events: TLObjectVector<TLInputAppEvent>): TLBool = executeMethod(TLRequestHelpSaveAppLog(events))

    @Throws(RpcErrorException::class, IOException::class)
    override fun helpSetBotUpdatesStatus(pendingUpdatesCount: Int, message: String): TLBool = executeMethod(TLRequestHelpSetBotUpdatesStatus(pendingUpdatesCount, message))

    @Throws(RpcErrorException::class, IOException::class)
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
    ): T = executeMethod(TLRequestInitConnection(apiId, deviceModel, systemVersion, appVersion, systemLangCode, langPack, langCode, proxy, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeAfterMsg(msgId: Long, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeAfterMsg(msgId, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeAfterMsgs(msgIds: TLLongVector, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeAfterMsgs(msgIds, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithLayer(layer: Int, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeWithLayer(layer, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithMessagesRange(range: TLMessageRange, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeWithMessagesRange(range, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithTakeout(takeoutId: Long, query: TLMethod<T>?): T = executeMethod(TLRequestInvokeWithTakeout(takeoutId, query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject> invokeWithoutUpdates(query: TLMethod<T>?): T = executeMethod(TLRequestInvokeWithoutUpdates(query))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetDifference(fromVersion: Int): TLLangPackDifference = executeMethod(TLRequestLangpackGetDifference(fromVersion))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetLangPack(langCode: String): TLLangPackDifference = executeMethod(TLRequestLangpackGetLangPack(langCode))

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetLanguages(): TLObjectVector<TLLangPackLanguage> = executeMethod(TLRequestLangpackGetLanguages())

    @Throws(RpcErrorException::class, IOException::class)
    override fun langpackGetStrings(langCode: String, keys: TLStringVector): TLObjectVector<TLAbsLangPackString> = executeMethod(TLRequestLangpackGetStrings(langCode, keys))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesAcceptEncryption(
            peer: TLInputEncryptedChat,
            gB: TLBytes,
            keyFingerprint: Long
    ): TLAbsEncryptedChat = executeMethod(TLRequestMessagesAcceptEncryption(peer, gB, keyFingerprint))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesAddChatUser(
            chatId: Int,
            userId: TLAbsInputUser,
            fwdLimit: Int
    ): TLAbsUpdates = executeMethod(TLRequestMessagesAddChatUser(chatId, userId, fwdLimit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesCheckChatInvite(hash: String): TLAbsChatInvite = executeMethod(TLRequestMessagesCheckChatInvite(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesClearRecentStickers(attached: Boolean): TLBool = executeMethod(TLRequestMessagesClearRecentStickers(attached))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesCreateChat(users: TLObjectVector<TLAbsInputUser>, title: String): TLAbsUpdates = executeMethod(TLRequestMessagesCreateChat(users, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteChatUser(chatId: Int, userId: TLAbsInputUser): TLAbsUpdates = executeMethod(TLRequestMessagesDeleteChatUser(chatId, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteHistory(
            justClear: Boolean,
            peer: TLAbsInputPeer,
            maxId: Int
    ): TLAffectedHistory = executeMethod(TLRequestMessagesDeleteHistory(justClear, peer, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDeleteMessages(revoke: Boolean, id: TLIntVector): TLAffectedMessages = executeMethod(TLRequestMessagesDeleteMessages(revoke, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesDiscardEncryption(chatId: Int): TLBool = executeMethod(TLRequestMessagesDiscardEncryption(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatAdmin(
            chatId: Int,
            userId: TLAbsInputUser,
            isAdmin: Boolean
    ): TLBool = executeMethod(TLRequestMessagesEditChatAdmin(chatId, userId, isAdmin))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatPhoto(chatId: Int, photo: TLAbsInputChatPhoto): TLAbsUpdates = executeMethod(TLRequestMessagesEditChatPhoto(chatId, photo))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditChatTitle(chatId: Int, title: String): TLAbsUpdates = executeMethod(TLRequestMessagesEditChatTitle(chatId, title))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesEditInlineBotMessage(
            noWebpage: Boolean,
            stopGeoLive: Boolean,
            id: TLInputBotInlineMessageID,
            message: String?,
            media: TLAbsInputMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            geoPoint: TLAbsInputGeoPoint?
    ): TLBool = executeMethod(TLRequestMessagesEditInlineBotMessage(noWebpage, stopGeoLive, id, message, media, replyMarkup, entities, geoPoint))

    @Throws(RpcErrorException::class, IOException::class)
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
    ): TLAbsUpdates = executeMethod(TLRequestMessagesEditMessage(noWebpage, stopGeoLive, peer, id, message, media, replyMarkup, entities, geoPoint))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesExportChatInvite(chatId: Int): TLAbsExportedChatInvite = executeMethod(TLRequestMessagesExportChatInvite(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesFaveSticker(id: TLAbsInputDocument, unfave: Boolean): TLBool = executeMethod(TLRequestMessagesFaveSticker(id, unfave))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesForwardMessages(
            silent: Boolean,
            background: Boolean,
            withMyScore: Boolean,
            grouped: Boolean,
            fromPeer: TLAbsInputPeer,
            id: TLIntVector,
            randomId: TLLongVector,
            toPeer: TLAbsInputPeer
    ): TLAbsUpdates = executeMethod(TLRequestMessagesForwardMessages(silent, background, withMyScore, grouped, fromPeer, id, randomId, toPeer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAllChats(exceptIds: TLIntVector): TLAbsChats = executeMethod(TLRequestMessagesGetAllChats(exceptIds))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAllDrafts(): TLAbsUpdates = executeMethod(TLRequestMessagesGetAllDrafts())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAllStickers(hash: Int): TLAbsAllStickers = executeMethod(TLRequestMessagesGetAllStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetArchivedStickers(
            masks: Boolean,
            offsetId: Long,
            limit: Int
    ): TLArchivedStickers = executeMethod(TLRequestMessagesGetArchivedStickers(masks, offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetAttachedStickers(media: TLAbsInputStickeredMedia): TLObjectVector<TLAbsStickerSetCovered> = executeMethod(TLRequestMessagesGetAttachedStickers(media))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetBotCallbackAnswer(
            game: Boolean,
            peer: TLAbsInputPeer,
            msgId: Int,
            data: TLBytes?
    ): TLBotCallbackAnswer = executeMethod(TLRequestMessagesGetBotCallbackAnswer(game, peer, msgId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetChats(id: TLIntVector): TLAbsChats = executeMethod(TLRequestMessagesGetChats(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetCommonChats(
            userId: TLAbsInputUser,
            maxId: Int,
            limit: Int
    ): TLAbsChats = executeMethod(TLRequestMessagesGetCommonChats(userId, maxId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDhConfig(version: Int, randomLength: Int): TLAbsDhConfig = executeMethod(TLRequestMessagesGetDhConfig(version, randomLength))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDialogUnreadMarks(): TLObjectVector<TLDialogPeer> = executeMethod(TLRequestMessagesGetDialogUnreadMarks())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDialogs(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int,
            hash: Int
    ): TLAbsDialogs = executeMethod(TLRequestMessagesGetDialogs(excludePinned, offsetDate, offsetId, offsetPeer, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetDocumentByHash(
            sha256: TLBytes,
            size: Int,
            mimeType: String
    ): TLAbsDocument = executeMethod(TLRequestMessagesGetDocumentByHash(sha256, size, mimeType))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFavedStickers(hash: Int): TLAbsFavedStickers = executeMethod(TLRequestMessagesGetFavedStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFeaturedStickers(hash: Int): TLAbsFeaturedStickers = executeMethod(TLRequestMessagesGetFeaturedStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetFullChat(chatId: Int): TLChatFull = executeMethod(TLRequestMessagesGetFullChat(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetGameHighScores(
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser
    ): TLHighScores = executeMethod(TLRequestMessagesGetGameHighScores(peer, id, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetHistory(
            peer: TLAbsInputPeer,
            offsetId: Int,
            offsetDate: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int,
            hash: Int
    ): TLAbsMessages = executeMethod(TLRequestMessagesGetHistory(peer, offsetId, offsetDate, addOffset, limit, maxId, minId, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetInlineBotResults(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            geoPoint: TLAbsInputGeoPoint?,
            query: String,
            offset: String
    ): TLBotResults = executeMethod(TLRequestMessagesGetInlineBotResults(bot, peer, geoPoint, query, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetInlineGameHighScores(id: TLInputBotInlineMessageID, userId: TLAbsInputUser): TLHighScores = executeMethod(TLRequestMessagesGetInlineGameHighScores(id, userId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMaskStickers(hash: Int): TLAbsAllStickers = executeMethod(TLRequestMessagesGetMaskStickers(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessageEditData(peer: TLAbsInputPeer, id: Int): TLMessageEditData = executeMethod(TLRequestMessagesGetMessageEditData(peer, id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessages(id: TLObjectVector<TLAbsInputMessage>): TLAbsMessages = executeMethod(TLRequestMessagesGetMessages(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetMessagesViews(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            increment: Boolean
    ): TLIntVector = executeMethod(TLRequestMessagesGetMessagesViews(peer, id, increment))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPeerDialogs(peers: TLObjectVector<TLInputDialogPeer>): TLPeerDialogs = executeMethod(TLRequestMessagesGetPeerDialogs(peers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPeerSettings(peer: TLAbsInputPeer): TLPeerSettings = executeMethod(TLRequestMessagesGetPeerSettings(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetPinnedDialogs(): TLPeerDialogs = executeMethod(TLRequestMessagesGetPinnedDialogs())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetRecentLocations(
            peer: TLAbsInputPeer,
            limit: Int,
            hash: Int
    ): TLAbsMessages = executeMethod(TLRequestMessagesGetRecentLocations(peer, limit, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetRecentStickers(attached: Boolean, hash: Int): TLAbsRecentStickers = executeMethod(TLRequestMessagesGetRecentStickers(attached, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSavedGifs(hash: Int): TLAbsSavedGifs = executeMethod(TLRequestMessagesGetSavedGifs(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetSplitRanges(): TLObjectVector<TLMessageRange> = executeMethod(TLRequestMessagesGetSplitRanges())

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetStickerSet(stickerset: TLAbsInputStickerSet): TLStickerSet = executeMethod(TLRequestMessagesGetStickerSet(stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetStickers(emoticon: String, hash: Int): TLAbsStickers = executeMethod(TLRequestMessagesGetStickers(emoticon, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetUnreadMentions(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ): TLAbsMessages = executeMethod(TLRequestMessagesGetUnreadMentions(peer, offsetId, addOffset, limit, maxId, minId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetWebPage(url: String, hash: Int): TLAbsWebPage = executeMethod(TLRequestMessagesGetWebPage(url, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesGetWebPagePreview(message: String, entities: TLObjectVector<TLAbsMessageEntity>?): TLAbsMessageMedia = executeMethod(TLRequestMessagesGetWebPagePreview(message, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesHideReportSpam(peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestMessagesHideReportSpam(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesImportChatInvite(hash: String): TLAbsUpdates = executeMethod(TLRequestMessagesImportChatInvite(hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesInstallStickerSet(stickerset: TLAbsInputStickerSet, archived: Boolean): TLAbsStickerSetInstallResult = executeMethod(TLRequestMessagesInstallStickerSet(stickerset, archived))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesMarkDialogUnread(unread: Boolean, peer: TLInputDialogPeer): TLBool = executeMethod(TLRequestMessagesMarkDialogUnread(unread, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesMigrateChat(chatId: Int): TLAbsUpdates = executeMethod(TLRequestMessagesMigrateChat(chatId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadEncryptedHistory(peer: TLInputEncryptedChat, maxDate: Int): TLBool = executeMethod(TLRequestMessagesReadEncryptedHistory(peer, maxDate))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadFeaturedStickers(id: TLLongVector): TLBool = executeMethod(TLRequestMessagesReadFeaturedStickers(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadHistory(peer: TLAbsInputPeer, maxId: Int): TLAffectedMessages = executeMethod(TLRequestMessagesReadHistory(peer, maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadMentions(peer: TLAbsInputPeer): TLAffectedHistory = executeMethod(TLRequestMessagesReadMentions(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReadMessageContents(id: TLIntVector): TLAffectedMessages = executeMethod(TLRequestMessagesReadMessageContents(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReceivedMessages(maxId: Int): TLObjectVector<TLReceivedNotifyMessage> = executeMethod(TLRequestMessagesReceivedMessages(maxId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReceivedQueue(maxQts: Int): TLLongVector = executeMethod(TLRequestMessagesReceivedQueue(maxQts))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReorderPinnedDialogs(force: Boolean, order: TLObjectVector<TLInputDialogPeer>): TLBool = executeMethod(TLRequestMessagesReorderPinnedDialogs(force, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReorderStickerSets(masks: Boolean, order: TLLongVector): TLBool = executeMethod(TLRequestMessagesReorderStickerSets(masks, order))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReport(
            peer: TLAbsInputPeer,
            id: TLIntVector,
            reason: TLAbsReportReason
    ): TLBool = executeMethod(TLRequestMessagesReport(peer, id, reason))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReportEncryptedSpam(peer: TLInputEncryptedChat): TLBool = executeMethod(TLRequestMessagesReportEncryptedSpam(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesReportSpam(peer: TLAbsInputPeer): TLBool = executeMethod(TLRequestMessagesReportSpam(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesRequestEncryption(
            userId: TLAbsInputUser,
            randomId: Int,
            gA: TLBytes
    ): TLAbsEncryptedChat = executeMethod(TLRequestMessagesRequestEncryption(userId, randomId, gA))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveDraft(
            noWebpage: Boolean,
            replyToMsgId: Int?,
            peer: TLAbsInputPeer,
            message: String,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ): TLBool = executeMethod(TLRequestMessagesSaveDraft(noWebpage, replyToMsgId, peer, message, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveGif(id: TLAbsInputDocument, unsave: Boolean): TLBool = executeMethod(TLRequestMessagesSaveGif(id, unsave))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSaveRecentSticker(
            attached: Boolean,
            id: TLAbsInputDocument,
            unsave: Boolean
    ): TLBool = executeMethod(TLRequestMessagesSaveRecentSticker(attached, id, unsave))

    @Throws(RpcErrorException::class, IOException::class)
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
    ): TLAbsMessages = executeMethod(TLRequestMessagesSearch(peer, q, fromId, filter, minDate, maxDate, offsetId, addOffset, limit, maxId, minId, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearchGifs(q: String, offset: Int): TLFoundGifs = executeMethod(TLRequestMessagesSearchGifs(q, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearchGlobal(
            q: String,
            offsetDate: Int,
            offsetPeer: TLAbsInputPeer,
            offsetId: Int,
            limit: Int
    ): TLAbsMessages = executeMethod(TLRequestMessagesSearchGlobal(q, offsetDate, offsetPeer, offsetId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSearchStickerSets(
            excludeFeatured: Boolean,
            q: String,
            hash: Int
    ): TLAbsFoundStickerSets = executeMethod(TLRequestMessagesSearchStickerSets(excludeFeatured, q, hash))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendEncrypted(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): TLAbsSentEncryptedMessage = executeMethod(TLRequestMessagesSendEncrypted(peer, randomId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendEncryptedFile(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes,
            file: TLAbsInputEncryptedFile
    ): TLAbsSentEncryptedMessage = executeMethod(TLRequestMessagesSendEncryptedFile(peer, randomId, data, file))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendEncryptedService(
            peer: TLInputEncryptedChat,
            randomId: Long,
            data: TLBytes
    ): TLAbsSentEncryptedMessage = executeMethod(TLRequestMessagesSendEncryptedService(peer, randomId, data))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendInlineBotResult(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            randomId: Long,
            queryId: Long,
            id: String
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendInlineBotResult(silent, background, clearDraft, peer, replyToMsgId, randomId, queryId, id))

    @Throws(RpcErrorException::class, IOException::class)
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
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendMedia(silent, background, clearDraft, peer, replyToMsgId, media, message, randomId, replyMarkup, entities))

    @Throws(RpcErrorException::class, IOException::class)
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
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendMessage(noWebpage, silent, background, clearDraft, peer, replyToMsgId, message, randomId, replyMarkup, entities))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendMultiMedia(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            multiMedia: TLObjectVector<TLInputSingleMedia>
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendMultiMedia(silent, background, clearDraft, peer, replyToMsgId, multiMedia))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSendScreenshotNotification(
            peer: TLAbsInputPeer,
            replyToMsgId: Int,
            randomId: Long
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSendScreenshotNotification(peer, replyToMsgId, randomId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetBotCallbackAnswer(
            alert: Boolean,
            queryId: Long,
            message: String?,
            url: String?,
            cacheTime: Int
    ): TLBool = executeMethod(TLRequestMessagesSetBotCallbackAnswer(alert, queryId, message, url, cacheTime))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetBotPrecheckoutResults(
            success: Boolean,
            queryId: Long,
            error: String?
    ): TLBool = executeMethod(TLRequestMessagesSetBotPrecheckoutResults(success, queryId, error))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetBotShippingResults(
            queryId: Long,
            error: String?,
            shippingOptions: TLObjectVector<TLShippingOption>?
    ): TLBool = executeMethod(TLRequestMessagesSetBotShippingResults(queryId, error, shippingOptions))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetEncryptedTyping(peer: TLInputEncryptedChat, typing: Boolean): TLBool = executeMethod(TLRequestMessagesSetEncryptedTyping(peer, typing))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetGameScore(
            editMessage: Boolean,
            force: Boolean,
            peer: TLAbsInputPeer,
            id: Int,
            userId: TLAbsInputUser,
            score: Int
    ): TLAbsUpdates = executeMethod(TLRequestMessagesSetGameScore(editMessage, force, peer, id, userId, score))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetInlineBotResults(
            gallery: Boolean,
            _private: Boolean,
            queryId: Long,
            results: TLObjectVector<TLAbsInputBotInlineResult>,
            cacheTime: Int,
            nextOffset: String?,
            switchPm: TLInlineBotSwitchPM?
    ): TLBool = executeMethod(TLRequestMessagesSetInlineBotResults(gallery, _private, queryId, results, cacheTime, nextOffset, switchPm))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetInlineGameScore(
            editMessage: Boolean,
            force: Boolean,
            id: TLInputBotInlineMessageID,
            userId: TLAbsInputUser,
            score: Int
    ): TLBool = executeMethod(TLRequestMessagesSetInlineGameScore(editMessage, force, id, userId, score))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesSetTyping(peer: TLAbsInputPeer, action: TLAbsSendMessageAction): TLBool = executeMethod(TLRequestMessagesSetTyping(peer, action))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesStartBot(
            bot: TLAbsInputUser,
            peer: TLAbsInputPeer,
            randomId: Long,
            startParam: String
    ): TLAbsUpdates = executeMethod(TLRequestMessagesStartBot(bot, peer, randomId, startParam))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesToggleChatAdmins(chatId: Int, enabled: Boolean): TLAbsUpdates = executeMethod(TLRequestMessagesToggleChatAdmins(chatId, enabled))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesToggleDialogPin(pinned: Boolean, peer: TLInputDialogPeer): TLBool = executeMethod(TLRequestMessagesToggleDialogPin(pinned, peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUninstallStickerSet(stickerset: TLAbsInputStickerSet): TLBool = executeMethod(TLRequestMessagesUninstallStickerSet(stickerset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUploadEncryptedFile(peer: TLInputEncryptedChat, file: TLAbsInputEncryptedFile): TLAbsEncryptedFile = executeMethod(TLRequestMessagesUploadEncryptedFile(peer, file))

    @Throws(RpcErrorException::class, IOException::class)
    override fun messagesUploadMedia(peer: TLAbsInputPeer, media: TLAbsInputMedia): TLAbsMessageMedia = executeMethod(TLRequestMessagesUploadMedia(peer, media))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsClearSavedInfo(credentials: Boolean, info: Boolean): TLBool = executeMethod(TLRequestPaymentsClearSavedInfo(credentials, info))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetPaymentForm(msgId: Int): TLPaymentForm = executeMethod(TLRequestPaymentsGetPaymentForm(msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetPaymentReceipt(msgId: Int): TLPaymentReceipt = executeMethod(TLRequestPaymentsGetPaymentReceipt(msgId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsGetSavedInfo(): TLSavedInfo = executeMethod(TLRequestPaymentsGetSavedInfo())

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsSendPaymentForm(
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials
    ): TLAbsPaymentResult = executeMethod(TLRequestPaymentsSendPaymentForm(msgId, requestedInfoId, shippingOptionId, credentials))

    @Throws(RpcErrorException::class, IOException::class)
    override fun paymentsValidateRequestedInfo(
            save: Boolean,
            msgId: Int,
            info: TLPaymentRequestedInfo
    ): TLValidatedRequestedInfo = executeMethod(TLRequestPaymentsValidateRequestedInfo(save, msgId, info))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneAcceptCall(
            peer: TLInputPhoneCall,
            gB: TLBytes,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall = executeMethod(TLRequestPhoneAcceptCall(peer, gB, protocol))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneConfirmCall(
            peer: TLInputPhoneCall,
            gA: TLBytes,
            keyFingerprint: Long,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall = executeMethod(TLRequestPhoneConfirmCall(peer, gA, keyFingerprint, protocol))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneDiscardCall(
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ): TLAbsUpdates = executeMethod(TLRequestPhoneDiscardCall(peer, duration, reason, connectionId))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneGetCallConfig(): TLDataJSON = executeMethod(TLRequestPhoneGetCallConfig())

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneReceivedCall(peer: TLInputPhoneCall): TLBool = executeMethod(TLRequestPhoneReceivedCall(peer))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneRequestCall(
            userId: TLAbsInputUser,
            randomId: Int,
            gAHash: TLBytes,
            protocol: TLPhoneCallProtocol
    ): TLPhoneCall = executeMethod(TLRequestPhoneRequestCall(userId, randomId, gAHash, protocol))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneSaveCallDebug(peer: TLInputPhoneCall, debug: TLDataJSON): TLBool = executeMethod(TLRequestPhoneSaveCallDebug(peer, debug))

    @Throws(RpcErrorException::class, IOException::class)
    override fun phoneSetCallRating(
            peer: TLInputPhoneCall,
            rating: Int,
            comment: String
    ): TLAbsUpdates = executeMethod(TLRequestPhoneSetCallRating(peer, rating, comment))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosDeletePhotos(id: TLObjectVector<TLAbsInputPhoto>): TLLongVector = executeMethod(TLRequestPhotosDeletePhotos(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosGetUserPhotos(
            userId: TLAbsInputUser,
            offset: Int,
            maxId: Long,
            limit: Int
    ): TLAbsPhotos = executeMethod(TLRequestPhotosGetUserPhotos(userId, offset, maxId, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosUpdateProfilePhoto(id: TLAbsInputPhoto): TLAbsUserProfilePhoto = executeMethod(TLRequestPhotosUpdateProfilePhoto(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun photosUploadProfilePhoto(file: TLAbsInputFile): TLPhoto = executeMethod(TLRequestPhotosUploadProfilePhoto(file))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersAddStickerToSet(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem): TLStickerSet = executeMethod(TLRequestStickersAddStickerToSet(stickerset, sticker))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersChangeStickerPosition(sticker: TLAbsInputDocument, position: Int): TLStickerSet = executeMethod(TLRequestStickersChangeStickerPosition(sticker, position))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersCreateStickerSet(
            masks: Boolean,
            userId: TLAbsInputUser,
            title: String,
            shortName: String,
            stickers: TLObjectVector<TLInputStickerSetItem>
    ): TLStickerSet = executeMethod(TLRequestStickersCreateStickerSet(masks, userId, title, shortName, stickers))

    @Throws(RpcErrorException::class, IOException::class)
    override fun stickersRemoveStickerFromSet(sticker: TLAbsInputDocument): TLStickerSet = executeMethod(TLRequestStickersRemoveStickerFromSet(sticker))

    @Throws(RpcErrorException::class, IOException::class)
    override fun updatesGetChannelDifference(
            force: Boolean,
            channel: TLAbsInputChannel,
            filter: TLAbsChannelMessagesFilter,
            pts: Int,
            limit: Int
    ): TLAbsChannelDifference = executeMethod(TLRequestUpdatesGetChannelDifference(force, channel, filter, pts, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun updatesGetDifference(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ): TLAbsDifference = executeMethod(TLRequestUpdatesGetDifference(pts, ptsTotalLimit, date, qts))

    @Throws(RpcErrorException::class, IOException::class)
    override fun updatesGetState(): TLState = executeMethod(TLRequestUpdatesGetState())

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetCdnFile(
            fileToken: TLBytes,
            offset: Int,
            limit: Int
    ): TLAbsCdnFile = executeMethod(TLRequestUploadGetCdnFile(fileToken, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetCdnFileHashes(fileToken: TLBytes, offset: Int): TLObjectVector<TLFileHash> = executeMethod(TLRequestUploadGetCdnFileHashes(fileToken, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetFile(
            location: TLAbsInputFileLocation,
            offset: Int,
            limit: Int
    ): TLAbsFile = executeMethod(TLRequestUploadGetFile(location, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetFileHashes(location: TLAbsInputFileLocation, offset: Int): TLObjectVector<TLFileHash> = executeMethod(TLRequestUploadGetFileHashes(location, offset))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadGetWebFile(
            location: TLAbsInputWebFileLocation,
            offset: Int,
            limit: Int
    ): TLWebFile = executeMethod(TLRequestUploadGetWebFile(location, offset, limit))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadReuploadCdnFile(fileToken: TLBytes, requestToken: TLBytes): TLObjectVector<TLFileHash> = executeMethod(TLRequestUploadReuploadCdnFile(fileToken, requestToken))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadSaveBigFilePart(
            fileId: Long,
            filePart: Int,
            fileTotalParts: Int,
            bytes: TLBytes
    ): TLBool = executeMethod(TLRequestUploadSaveBigFilePart(fileId, filePart, fileTotalParts, bytes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun uploadSaveFilePart(
            fileId: Long,
            filePart: Int,
            bytes: TLBytes
    ): TLBool = executeMethod(TLRequestUploadSaveFilePart(fileId, filePart, bytes))

    @Throws(RpcErrorException::class, IOException::class)
    override fun usersGetFullUser(id: TLAbsInputUser): TLUserFull = executeMethod(TLRequestUsersGetFullUser(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun usersGetUsers(id: TLObjectVector<TLAbsInputUser>): TLObjectVector<TLAbsUser> = executeMethod(TLRequestUsersGetUsers(id))

    @Throws(RpcErrorException::class, IOException::class)
    override fun usersSetSecureValueErrors(id: TLAbsInputUser, errors: TLObjectVector<TLAbsSecureValueError>): TLBool = executeMethod(TLRequestUsersSetSecureValueErrors(id, errors))
}
