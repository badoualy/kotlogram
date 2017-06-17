package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLTopPeerCategoryChannels extends TLAbsTopPeerCategory {

    public static final int CONSTRUCTOR_ID = 0x161d9628;

    private final String _constructor = "topPeerCategoryChannels#161d9628";

    public TLTopPeerCategoryChannels() {
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
