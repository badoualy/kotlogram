package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyKeyPhoneCall extends TLAbsPrivacyKey {

    public static final int CONSTRUCTOR_ID = 0x3d662b7b;

    private final String _constructor = "privacyKeyPhoneCall#3d662b7b";

    public TLPrivacyKeyPhoneCall() {
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
