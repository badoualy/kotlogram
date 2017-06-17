package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyValueDisallowContacts extends TLAbsPrivacyRule {

    public static final int CONSTRUCTOR_ID = 0xf888fa1a;

    private final String _constructor = "privacyValueDisallowContacts#f888fa1a";

    public TLPrivacyValueDisallowContacts() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
