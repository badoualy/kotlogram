package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipantsAdmins extends TLAbsChannelParticipantsFilter {
    public static final int CONSTRUCTOR_ID = 0xb4608969;

    public TLChannelParticipantsAdmins() {
    }

    @Override
    public String toString() {
        return "channelParticipantsAdmins#b4608969";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLChannelParticipantsAdmins)) return false;
        if (object == this) return true;

        TLChannelParticipantsAdmins o = (TLChannelParticipantsAdmins) object;

        return true;
    }
}
