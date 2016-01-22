package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLContactLinkHasPhone extends TLAbsContactLink {
    public static final int CLASS_ID = 0x268f3f59;

    public TLContactLinkHasPhone() {
    }

    @Override
    public String toString() {
        return "contactLinkHasPhone#268f3f59";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
