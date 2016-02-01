package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMediaEmpty extends TLAbsInputMedia {
    public static final int CONSTRUCTOR_ID = 0x9664f57f;

    public TLInputMediaEmpty() {
    }

    @Override
    public String toString() {
        return "inputMediaEmpty#9664f57f";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
