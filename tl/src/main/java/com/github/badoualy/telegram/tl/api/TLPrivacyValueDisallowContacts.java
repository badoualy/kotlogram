package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyValueDisallowContacts extends TLAbsPrivacyRule {
    public static final int CLASS_ID = 0xf888fa1a;

    public TLPrivacyValueDisallowContacts() {
    }

    @Override
    public String toString() {
        return "privacyValueDisallowContacts#f888fa1a";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
