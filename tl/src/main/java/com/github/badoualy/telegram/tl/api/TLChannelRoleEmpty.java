package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelRoleEmpty extends TLAbsChannelParticipantRole {
    public static final int CLASS_ID = 0xb285a0c6;

    public TLChannelRoleEmpty() {
    }

    @Override
    public String toString() {
        return "channelRoleEmpty#b285a0c6";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
