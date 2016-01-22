package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelRoleEditor extends TLAbsChannelParticipantRole {
    public static final int CLASS_ID = 0x820bfe8c;

    public TLChannelRoleEditor() {
    }

    @Override
    public String toString() {
        return "channelRoleEditor#820bfe8c";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
