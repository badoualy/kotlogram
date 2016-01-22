package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPrivacyValueAllowAll extends TLAbsInputPrivacyRule {
    public static final int CLASS_ID = 0x184b35ce;

    public TLInputPrivacyValueAllowAll() {
    }

    @Override
    public String toString() {
        return "inputPrivacyValueAllowAll#184b35ce";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
