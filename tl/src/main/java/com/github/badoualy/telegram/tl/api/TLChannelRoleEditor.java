package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelRoleEditor extends TLAbsChannelParticipantRole {

    public static final int CONSTRUCTOR_ID = 0x820bfe8c;

    private final String _constructor = "channelRoleEditor#820bfe8c";

    public TLChannelRoleEditor() {
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
