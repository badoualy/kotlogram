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
 * * [sendMessageCancelAction#fd5ec8f5][TLSendMessageCancelAction]
 * * [sendMessageChooseContactAction#628cbc6f][TLSendMessageChooseContactAction]
 * * [sendMessageGamePlayAction#dd6a8f48][TLSendMessageGamePlayAction]
 * * [sendMessageGeoLocationAction#176f8ba1][TLSendMessageGeoLocationAction]
 * * [sendMessageRecordAudioAction#d52f73f7][TLSendMessageRecordAudioAction]
 * * [sendMessageRecordRoundAction#88f27fbc][TLSendMessageRecordRoundAction]
 * * [sendMessageRecordVideoAction#a187d66f][TLSendMessageRecordVideoAction]
 * * [sendMessageTypingAction#16bf744e][TLSendMessageTypingAction]
 * * [sendMessageUploadAudioAction#f351d7ab][TLSendMessageUploadAudioAction]
 * * [sendMessageUploadDocumentAction#aa0cd9e4][TLSendMessageUploadDocumentAction]
 * * [sendMessageUploadPhotoAction#d1d34a26][TLSendMessageUploadPhotoAction]
 * * [sendMessageUploadRoundAction#243e1c66][TLSendMessageUploadRoundAction]
 * * [sendMessageUploadVideoAction#e9763aec][TLSendMessageUploadVideoAction]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsSendMessageAction : TLObject()
