package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserStatusLastMonth extends TLAbsUserStatus {
    public static final int CONSTRUCTOR_ID = 0x77ebc742;

    public TLUserStatusLastMonth() {
    }

    @Override
    public String toString() {
        return "userStatusLastMonth#77ebc742";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLUserStatusLastMonth)) return false;
        if (object == this) return true;

        TLUserStatusLastMonth o = (TLUserStatusLastMonth) object;

        return true;
    }
}
