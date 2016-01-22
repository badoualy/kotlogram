package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyValueAllowContacts extends TLAbsPrivacyRule {
    public static final int CLASS_ID = 0xfffe1bac;

    public TLPrivacyValueAllowContacts() {
    }

    @Override
    public String toString() {
        return "privacyValueAllowContacts#fffe1bac";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
