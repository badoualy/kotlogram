package com.github.badoualy.telegram.tl.api.messages;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSavedGifsNotModified extends TLAbsSavedGifs {

    public static final int CONSTRUCTOR_ID = 0xe8025ca2;

    private final String _constructor = "messages.savedGifsNotModified#e8025ca2";

    public TLSavedGifsNotModified() {
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
