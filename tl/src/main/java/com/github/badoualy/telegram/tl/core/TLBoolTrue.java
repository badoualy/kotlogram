package com.github.badoualy.telegram.tl.core;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBoolTrue extends TLBool {

    public static final int CONSTRUCTOR_ID = 0x997275b5;

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    public String toString() {
        return "boolTrue#997275b5";
    }
}
