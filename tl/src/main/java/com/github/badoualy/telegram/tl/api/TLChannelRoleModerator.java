package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelRoleModerator extends TLAbsChannelParticipantRole {

    public static final int CONSTRUCTOR_ID = 0x9618d975;

    private final String _constructor = "channelRoleModerator#9618d975";

    public TLChannelRoleModerator() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
