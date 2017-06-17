package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLSendMessageCancelAction}: sendMessageCancelAction#fd5ec8f5</li>
 * <li>{@link TLSendMessageChooseContactAction}: sendMessageChooseContactAction#628cbc6f</li>
 * <li>{@link TLSendMessageGamePlayAction}: sendMessageGamePlayAction#dd6a8f48</li>
 * <li>{@link TLSendMessageGeoLocationAction}: sendMessageGeoLocationAction#176f8ba1</li>
 * <li>{@link TLSendMessageRecordAudioAction}: sendMessageRecordAudioAction#d52f73f7</li>
 * <li>{@link TLSendMessageRecordRoundAction}: sendMessageRecordRoundAction#88f27fbc</li>
 * <li>{@link TLSendMessageRecordVideoAction}: sendMessageRecordVideoAction#a187d66f</li>
 * <li>{@link TLSendMessageTypingAction}: sendMessageTypingAction#16bf744e</li>
 * <li>{@link TLSendMessageUploadAudioAction}: sendMessageUploadAudioAction#f351d7ab</li>
 * <li>{@link TLSendMessageUploadDocumentAction}: sendMessageUploadDocumentAction#aa0cd9e4</li>
 * <li>{@link TLSendMessageUploadPhotoAction}: sendMessageUploadPhotoAction#d1d34a26</li>
 * <li>{@link TLSendMessageUploadRoundAction}: sendMessageUploadRoundAction#243e1c66</li>
 * <li>{@link TLSendMessageUploadVideoAction}: sendMessageUploadVideoAction#e9763aec</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsSendMessageAction extends TLObject {

    public TLAbsSendMessageAction() {
    }
}
