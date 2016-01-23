package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLContactLinkContact extends TLAbsContactLink {
    public static final int CLASS_ID = 0xd502c2d0;

    public TLContactLinkContact() {
    }

    @Override
    public String toString() {
        return "contactLinkContact#d502c2d0";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
