package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputVideoEmpty extends TLAbsInputVideo {
    public static final int CONSTRUCTOR_ID = 0x5508ec75;

    private final String _constructor = "inputVideoEmpty#5508ec75";

    public TLInputVideoEmpty() {
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
        if (!(object instanceof TLInputVideoEmpty)) return false;
        if (object == this) return true;

        TLInputVideoEmpty o = (TLInputVideoEmpty) object;

        return true;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean isNotEmpty() {
        return false;
    }
}
