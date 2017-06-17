package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyValueAllowContacts extends TLAbsPrivacyRule {

    public static final int CONSTRUCTOR_ID = 0xfffe1bac;

    private final String _constructor = "privacyValueAllowContacts#fffe1bac";

    public TLPrivacyValueAllowContacts() {
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
