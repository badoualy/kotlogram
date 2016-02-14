package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputChannelEmpty extends TLAbsInputChannel {
    public static final int CONSTRUCTOR_ID = 0xee8c1e86;

    private final String _constructor = "inputChannelEmpty#ee8c1e86";

    public TLInputChannelEmpty() {
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
        if (!(object instanceof TLInputChannelEmpty)) return false;
        if (object == this) return true;

        TLInputChannelEmpty o = (TLInputChannelEmpty) object;

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
