package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPrivacyKeyPhoneCall extends TLAbsInputPrivacyKey {

    public static final int CONSTRUCTOR_ID = 0xfabadc5f;

    private final String _constructor = "inputPrivacyKeyPhoneCall#fabadc5f";

    public TLInputPrivacyKeyPhoneCall() {
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
