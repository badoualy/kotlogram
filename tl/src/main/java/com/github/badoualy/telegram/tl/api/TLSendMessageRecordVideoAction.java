package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSendMessageRecordVideoAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0xa187d66f;

    public TLSendMessageRecordVideoAction() {
    }

    @Override
    public String toString() {
        return "sendMessageRecordVideoAction#a187d66f";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
