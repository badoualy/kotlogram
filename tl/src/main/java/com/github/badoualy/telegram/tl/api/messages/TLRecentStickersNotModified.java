package com.github.badoualy.telegram.tl.api.messages;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRecentStickersNotModified extends TLAbsRecentStickers {

    public static final int CONSTRUCTOR_ID = 0xb17f890;

    private final String _constructor = "messages.recentStickersNotModified#b17f890";

    public TLRecentStickersNotModified() {
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
