package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyValueDisallowAll extends TLAbsPrivacyRule {
    public static final int CONSTRUCTOR_ID = 0x8b73e763;

    public TLPrivacyValueDisallowAll() {
    }

    @Override
    public String toString() {
        return "privacyValueDisallowAll#8b73e763";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLPrivacyValueDisallowAll)) return false;
        if (object == this) return true;

        TLPrivacyValueDisallowAll o = (TLPrivacyValueDisallowAll) object;

        return true;
    }
}
