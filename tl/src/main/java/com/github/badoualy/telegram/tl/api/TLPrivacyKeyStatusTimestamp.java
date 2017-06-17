package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyKeyStatusTimestamp extends TLAbsPrivacyKey {

    public static final int CONSTRUCTOR_ID = 0xbc2eab30;

    private final String _constructor = "privacyKeyStatusTimestamp#bc2eab30";

    public TLPrivacyKeyStatusTimestamp() {
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
