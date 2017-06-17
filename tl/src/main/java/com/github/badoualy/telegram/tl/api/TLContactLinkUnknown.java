package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLContactLinkUnknown extends TLAbsContactLink {

    public static final int CONSTRUCTOR_ID = 0x5f4f9247;

    private final String _constructor = "contactLinkUnknown#5f4f9247";

    public TLContactLinkUnknown() {
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
