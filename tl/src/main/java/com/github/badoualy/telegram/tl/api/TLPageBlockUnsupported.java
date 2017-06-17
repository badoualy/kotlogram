package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPageBlockUnsupported extends TLAbsPageBlock {

    public static final int CONSTRUCTOR_ID = 0x13567e8a;

    private final String _constructor = "pageBlockUnsupported#13567e8a";

    public TLPageBlockUnsupported() {
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
