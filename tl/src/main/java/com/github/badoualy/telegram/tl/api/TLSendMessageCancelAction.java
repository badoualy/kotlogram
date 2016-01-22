package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSendMessageCancelAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0xfd5ec8f5;

    public TLSendMessageCancelAction() {
    }

    @Override
    public String toString() {
        return "sendMessageCancelAction#fd5ec8f5";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
