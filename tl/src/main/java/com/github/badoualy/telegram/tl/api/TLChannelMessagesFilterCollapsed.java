package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelMessagesFilterCollapsed extends TLAbsChannelMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0xfa01232e;

    private final String _constructor = "channelMessagesFilterCollapsed#fa01232e";

    public TLChannelMessagesFilterCollapsed() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLChannelMessagesFilterCollapsed)) return false;
        if (object == this) return true;

        TLChannelMessagesFilterCollapsed o = (TLChannelMessagesFilterCollapsed) object;

        return true;
    }
}
