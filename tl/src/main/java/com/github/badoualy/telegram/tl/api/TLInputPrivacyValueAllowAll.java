package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPrivacyValueAllowAll extends TLAbsInputPrivacyRule {

    public static final int CONSTRUCTOR_ID = 0x184b35ce;

    private final String _constructor = "inputPrivacyValueAllowAll#184b35ce";

    public TLInputPrivacyValueAllowAll() {
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
