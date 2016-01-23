package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelRoleModerator extends TLAbsChannelParticipantRole {
    public static final int CLASS_ID = 0x9618d975;

    public TLChannelRoleModerator() {
    }

    @Override
    public String toString() {
        return "channelRoleModerator#9618d975";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
