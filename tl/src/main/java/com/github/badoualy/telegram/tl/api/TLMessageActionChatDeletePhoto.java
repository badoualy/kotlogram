package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageActionChatDeletePhoto extends TLAbsMessageAction {
    public static final int CLASS_ID = 0x95e3fbef;

    public TLMessageActionChatDeletePhoto() {
    }

    @Override
    public String toString() {
        return "messageActionChatDeletePhoto#95e3fbef";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
