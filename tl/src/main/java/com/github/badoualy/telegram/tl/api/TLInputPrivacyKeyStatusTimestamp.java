package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPrivacyKeyStatusTimestamp extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x4f96cb18;

    public TLInputPrivacyKeyStatusTimestamp() {
    }

    @Override
    public String toString() {
        return "inputPrivacyKeyStatusTimestamp#4f96cb18";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputPrivacyKeyStatusTimestamp)) return false;
        if (object == this) return true;

        TLInputPrivacyKeyStatusTimestamp o = (TLInputPrivacyKeyStatusTimestamp) object;

        return true;
    }
}
