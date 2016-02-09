package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLNotifyUsers extends TLAbsNotifyPeer {
    public static final int CONSTRUCTOR_ID = 0xb4c83b4c;

    public TLNotifyUsers() {
    }

    @Override
    public String toString() {
        return "notifyUsers#b4c83b4c";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLNotifyUsers)) return false;
        if (object == this) return true;

        TLNotifyUsers o = (TLNotifyUsers) object;

        return true;
    }
}
