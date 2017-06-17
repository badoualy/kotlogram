package com.github.badoualy.telegram.tl.api.messages;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFeaturedStickersNotModified extends TLAbsFeaturedStickers {

    public static final int CONSTRUCTOR_ID = 0x4ede3cf;

    private final String _constructor = "messages.featuredStickersNotModified#4ede3cf";

    public TLFeaturedStickersNotModified() {
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
