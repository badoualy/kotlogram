package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserStatusLastWeek extends TLAbsUserStatus {
    public static final int CONSTRUCTOR_ID = 0x7bf09fc;

    public TLUserStatusLastWeek() {
    }

    @Override
    public String toString() {
        return "userStatusLastWeek#7bf09fc";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLUserStatusLastWeek)) return false;
        if (object == this) return true;

        TLUserStatusLastWeek o = (TLUserStatusLastWeek) object;

        return true;
    }
}
