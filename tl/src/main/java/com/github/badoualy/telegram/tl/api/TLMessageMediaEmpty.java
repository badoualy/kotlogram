package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageMediaEmpty extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x3ded6320;

    public TLMessageMediaEmpty() {
    }

    @Override
    public String toString() {
        return "messageMediaEmpty#3ded6320";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
