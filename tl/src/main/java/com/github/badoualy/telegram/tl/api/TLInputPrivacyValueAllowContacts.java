package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPrivacyValueAllowContacts extends TLAbsInputPrivacyRule {
    public static final int CONSTRUCTOR_ID = 0xd09e07b;

    private final String _constructor = "inputPrivacyValueAllowContacts#d09e07b";

    public TLInputPrivacyValueAllowContacts() {
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
        if (!(object instanceof TLInputPrivacyValueAllowContacts)) return false;
        if (object == this) return true;

        TLInputPrivacyValueAllowContacts o = (TLInputPrivacyValueAllowContacts) object;

        return true;
    }
}
