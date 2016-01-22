package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPrivacyValueDisallowContacts extends TLAbsInputPrivacyRule {
    public static final int CLASS_ID = 0xba52007;

    public TLInputPrivacyValueDisallowContacts() {
    }

    @Override
    public String toString() {
        return "inputPrivacyValueDisallowContacts#ba52007";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
