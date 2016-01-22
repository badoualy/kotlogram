package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyValueDisallowAll extends TLAbsPrivacyRule {
    public static final int CLASS_ID = 0x8b73e763;

    public TLPrivacyValueDisallowAll() {
    }

    @Override
    public String toString() {
        return "privacyValueDisallowAll#8b73e763";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
