package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageMediaEmpty extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x3ded6320;

    private final String _constructor = "messageMediaEmpty#3ded6320";

    public TLMessageMediaEmpty() {
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
        if (!(object instanceof TLMessageMediaEmpty)) return false;
        if (object == this) return true;

        TLMessageMediaEmpty o = (TLMessageMediaEmpty) object;

        return true;
    }
}
