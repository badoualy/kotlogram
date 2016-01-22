package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatInviteEmpty extends TLAbsExportedChatInvite {
    public static final int CLASS_ID = 0x69df3769;

    public TLChatInviteEmpty() {
    }

    @Override
    public String toString() {
        return "chatInviteEmpty#69df3769";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
