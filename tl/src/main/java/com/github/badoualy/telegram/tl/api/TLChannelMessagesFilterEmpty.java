package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelMessagesFilterEmpty extends TLAbsChannelMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0x94d42ee7;

    public TLChannelMessagesFilterEmpty() {
    }

    @Override
    public String toString() {
        return "channelMessagesFilterEmpty#94d42ee7";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLChannelMessagesFilterEmpty)) return false;
        if (object == this) return true;

        TLChannelMessagesFilterEmpty o = (TLChannelMessagesFilterEmpty) object;

        return true;
    }
}
