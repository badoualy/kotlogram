package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPrivacyValueAllowContacts extends TLAbsInputPrivacyRule {
    public static final int CLASS_ID = 0xd09e07b;

    public TLInputPrivacyValueAllowContacts() {
    }

    @Override
    public String toString() {
        return "inputPrivacyValueAllowContacts#d09e07b";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
