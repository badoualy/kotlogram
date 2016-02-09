package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputGeoPointEmpty extends TLAbsInputGeoPoint {
    public static final int CONSTRUCTOR_ID = 0xe4c123d6;

    public TLInputGeoPointEmpty() {
    }

    @Override
    public String toString() {
        return "inputGeoPointEmpty#e4c123d6";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputGeoPointEmpty)) return false;
        if (object == this) return true;

        TLInputGeoPointEmpty o = (TLInputGeoPointEmpty) object;

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
