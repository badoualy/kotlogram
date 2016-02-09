package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputNotifyChats extends TLAbsInputNotifyPeer {
    public static final int CONSTRUCTOR_ID = 0x4a95e84e;

    public TLInputNotifyChats() {
    }

    @Override
    public String toString() {
        return "inputNotifyChats#4a95e84e";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputNotifyChats)) return false;
        if (object == this) return true;

        TLInputNotifyChats o = (TLInputNotifyChats) object;

        return true;
    }
}
