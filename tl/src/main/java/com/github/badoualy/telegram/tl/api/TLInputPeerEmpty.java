package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPeerEmpty extends TLAbsInputPeer {
    public static final int CONSTRUCTOR_ID = 0x7f3b18ea;

    public TLInputPeerEmpty() {
    }

    @Override
    public String toString() {
        return "inputPeerEmpty#7f3b18ea";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputPeerEmpty)) return false;
        if (object == this) return true;

        TLInputPeerEmpty o = (TLInputPeerEmpty) object;

        return true;
    }
}
