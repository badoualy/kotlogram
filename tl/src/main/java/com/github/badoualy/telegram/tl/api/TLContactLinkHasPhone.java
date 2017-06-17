package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLContactLinkHasPhone extends TLAbsContactLink {

    public static final int CONSTRUCTOR_ID = 0x268f3f59;

    private final String _constructor = "contactLinkHasPhone#268f3f59";

    public TLContactLinkHasPhone() {
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
