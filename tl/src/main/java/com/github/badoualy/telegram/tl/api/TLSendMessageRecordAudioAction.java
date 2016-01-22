package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSendMessageRecordAudioAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0xd52f73f7;

    public TLSendMessageRecordAudioAction() {
    }

    @Override
    public String toString() {
        return "sendMessageRecordAudioAction#d52f73f7";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
