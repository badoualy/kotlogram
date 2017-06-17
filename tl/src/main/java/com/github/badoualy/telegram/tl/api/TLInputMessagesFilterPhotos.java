package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterPhotos extends TLAbsMessagesFilter {

    public static final int CONSTRUCTOR_ID = 0x9609a51c;

    private final String _constructor = "inputMessagesFilterPhotos#9609a51c";

    public TLInputMessagesFilterPhotos() {
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
