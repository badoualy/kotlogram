package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyValueAllowContacts extends TLAbsPrivacyRule {
    public static final int CONSTRUCTOR_ID = 0xfffe1bac;

    public TLPrivacyValueAllowContacts() {
    }

    @Override
    public String toString() {
        return "privacyValueAllowContacts#fffe1bac";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLPrivacyValueAllowContacts)) return false;
        if (object == this) return true;

        TLPrivacyValueAllowContacts o = (TLPrivacyValueAllowContacts) object;

        return true;
    }
}
