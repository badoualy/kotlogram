package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputChannelEmpty extends TLAbsInputChannel {
    public static final int CONSTRUCTOR_ID = 0xee8c1e86;

    public TLInputChannelEmpty() {
    }

    @Override
    public String toString() {
        return "inputChannelEmpty#ee8c1e86";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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
