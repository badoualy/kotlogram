package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputGeoPointEmpty extends TLAbsInputGeoPoint {
    public static final int CLASS_ID = 0xe4c123d6;

    public TLInputGeoPointEmpty() {
    }

    @Override
    public String toString() {
        return "inputGeoPointEmpty#e4c123d6";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
