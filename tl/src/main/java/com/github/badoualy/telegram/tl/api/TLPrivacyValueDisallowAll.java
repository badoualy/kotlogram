package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyValueDisallowAll extends TLAbsPrivacyRule {

    public static final int CONSTRUCTOR_ID = 0x8b73e763;

    private final String _constructor = "privacyValueDisallowAll#8b73e763";

    public TLPrivacyValueDisallowAll() {
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
