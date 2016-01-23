package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyValueAllowAll extends TLAbsPrivacyRule {
    public static final int CLASS_ID = 0x65427b82;

    public TLPrivacyValueAllowAll() {
    }

    @Override
    public String toString() {
        return "privacyValueAllowAll#65427b82";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
