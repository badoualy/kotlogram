package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserStatusEmpty extends TLAbsUserStatus {
    public static final int CONSTRUCTOR_ID = 0x9d05049;

    private final String _constructor = "userStatusEmpty#9d05049";

    public TLUserStatusEmpty() {
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
        if (!(object instanceof TLUserStatusEmpty)) return false;
        if (object == this) return true;

        TLUserStatusEmpty o = (TLUserStatusEmpty) object;

        return true;
    }
}
