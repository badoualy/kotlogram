package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelRoleEmpty extends TLAbsChannelParticipantRole {
    public static final int CONSTRUCTOR_ID = 0xb285a0c6;

    public TLChannelRoleEmpty() {
    }

    @Override
    public String toString() {
        return "channelRoleEmpty#b285a0c6";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLChannelRoleEmpty)) return false;
        if (object == this) return true;

        TLChannelRoleEmpty o = (TLChannelRoleEmpty) object;

        return true;
    }
}
