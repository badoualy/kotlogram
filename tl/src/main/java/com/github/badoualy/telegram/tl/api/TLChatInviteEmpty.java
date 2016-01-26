package com.github.badoualy.telegram.tl.api;

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

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean isNotEmpty() {
        return false;
    }
}
