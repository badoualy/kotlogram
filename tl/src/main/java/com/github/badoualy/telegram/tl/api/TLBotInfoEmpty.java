package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotInfoEmpty extends TLAbsBotInfo {
    public static final int CLASS_ID = 0xbb2e37ce;

    public TLBotInfoEmpty() {
    }

    @Override
    public String toString() {
        return "botInfoEmpty#bb2e37ce";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean isNotEmpty() {
        return false;
    }
}
