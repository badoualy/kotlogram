package com.github.badoualy.telegram.tl.api.messages;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLAllStickersNotModified extends TLAbsAllStickers {
    public static final int CONSTRUCTOR_ID = 0xe86602c3;

    public TLAllStickersNotModified() {
    }

    @Override
    public String toString() {
        return "messages.allStickersNotModified#e86602c3";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLAllStickersNotModified)) return false;
        if (object == this) return true;

        TLAllStickersNotModified o = (TLAllStickersNotModified) object;

        return true;
    }
}
